package com.stepos.config.dag.util;

import android.util.Log;
import com.stepos.config.dag.annotation.JsonMapKey;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class JsonBeanMapper {
    private static final String TAG = "JsonBeanMapper";

    public static void mapJsonToBean(JSONObject json, Object bean) throws IllegalAccessException, IllegalArgumentException {
        if (json == null || bean == null) {
            return;
        }
        Class<?> clazz = bean.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (!Modifier.isStatic(field.getModifiers()) && !Modifier.isFinal(field.getModifiers())) {
                try {
                    String fieldName = field.getName();
                    String jsonKey = camelToSnake(fieldName);
                    if (json.has(jsonKey)) {
                        field.setAccessible(true);
                        Object value = parseValue(json, jsonKey, field);
                        if (value != null) {
                            field.set(bean, value);
                        }
                    }
                } catch (Exception e) {
                    Log.w(TAG, "Failed to map field: " + field.getName(), e);
                }
            }
        }
    }

    private static Object parseValue(JSONObject json, String key, Field field) throws Exception {
        Class<?> fieldType = field.getType();
        if (fieldType == String.class) {
            return json.optString(key, null);
        }
        if (fieldType == Integer.TYPE || fieldType == Integer.class) {
            return Integer.valueOf(json.optInt(key));
        }
        if (fieldType == Long.TYPE || fieldType == Long.class) {
            return Long.valueOf(json.optLong(key));
        }
        if (fieldType == Boolean.TYPE || fieldType == Boolean.class) {
            return Boolean.valueOf(json.optBoolean(key));
        }
        if (fieldType == Double.TYPE || fieldType == Double.class) {
            return Double.valueOf(json.optDouble(key));
        }
        if (fieldType == Float.TYPE || fieldType == Float.class) {
            return Float.valueOf((float) json.optDouble(key));
        }
        if (List.class.isAssignableFrom(fieldType)) {
            return parseList(json, key, field);
        }
        if (Map.class.isAssignableFrom(fieldType)) {
            return parseMap(json, key, field);
        }
        JSONObject nestedJson = json.optJSONObject(key);
        if (nestedJson == null) {
            return null;
        }
        Object nestedBean = fieldType.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        mapJsonToBean(nestedJson, nestedBean);
        return nestedBean;
    }

    private static List<?> parseList(JSONObject json, String key, Field field) throws Exception {
        JSONArray array = json.optJSONArray(key);
        if (array == null) {
            return new ArrayList();
        }
        List<Object> list = new ArrayList<>();
        Type genericType = field.getGenericType();
        if (genericType instanceof ParameterizedType) {
            ParameterizedType paramType = (ParameterizedType) genericType;
            Type[] typeArgs = paramType.getActualTypeArguments();
            if (typeArgs.length > 0) {
                Class<?> elementType = (Class) typeArgs[0];
                for (int i = 0; i < array.length(); i++) {
                    if (elementType == String.class) {
                        String item = array.optString(i);
                        if (item != null && !item.isEmpty()) {
                            list.add(item);
                        }
                    } else if (elementType == Integer.class || elementType == Integer.TYPE) {
                        list.add(Integer.valueOf(array.optInt(i)));
                    } else {
                        JSONObject itemJson = array.optJSONObject(i);
                        if (itemJson != null) {
                            try {
                                Method fromJson = elementType.getMethod("fromJson", JSONObject.class);
                                Object item2 = fromJson.invoke(null, itemJson);
                                if (item2 != null) {
                                    list.add(item2);
                                }
                            } catch (NoSuchMethodException e) {
                                Object item3 = elementType.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                                mapJsonToBean(itemJson, item3);
                                list.add(item3);
                            }
                        }
                    }
                }
            }
        }
        return list;
    }

    private static Map<?, ?> parseMap(JSONObject json, String key, Field field) throws Exception {
        JsonMapKey mapKeyAnnotation = (JsonMapKey) field.getAnnotation(JsonMapKey.class);
        if (mapKeyAnnotation != null) {
            return parseMapWithKeyInjection(json, key, field, mapKeyAnnotation);
        }
        JSONObject mapJson = json.optJSONObject(key);
        if (mapJson == null) {
            return new HashMap();
        }
        Map<String, Object> map = new HashMap<>();
        Type genericType = field.getGenericType();
        if (genericType instanceof ParameterizedType) {
            ParameterizedType paramType = (ParameterizedType) genericType;
            Type[] typeArgs = paramType.getActualTypeArguments();
            if (typeArgs.length == 2) {
                Class<?> valueType = (Class) typeArgs[1];
                Iterator<String> it = mapJson.keys();
                while (it.hasNext()) {
                    String mapKey = it.next();
                    if (valueType == String.class) {
                        map.put(mapKey, mapJson.optString(mapKey));
                    } else if (List.class.isAssignableFrom(valueType)) {
                        List<String> list = new ArrayList<>();
                        JSONArray array = mapJson.optJSONArray(mapKey);
                        if (array != null) {
                            for (int i = 0; i < array.length(); i++) {
                                String item = array.optString(i);
                                if (item != null && !item.isEmpty()) {
                                    list.add(item);
                                }
                            }
                        }
                        map.put(mapKey, list);
                    } else {
                        JSONObject valueJson = mapJson.optJSONObject(mapKey);
                        if (valueJson != null) {
                            Object value = valueType.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                            mapJsonToBean(valueJson, value);
                            map.put(mapKey, value);
                        }
                    }
                }
            }
        }
        return map;
    }

    private static Map<String, Object> parseMapWithKeyInjection(JSONObject json, String key, Field field, JsonMapKey annotation) throws Exception {
        Iterator<String> keysIterator;
        JSONObject mapJson = json.optJSONObject(key);
        if (mapJson == null) {
            return new HashMap();
        }
        Map<String, Object> resultMap = new HashMap<>();
        Type genericType = field.getGenericType();
        if (!(genericType instanceof ParameterizedType)) {
            return resultMap;
        }
        ParameterizedType paramType = (ParameterizedType) genericType;
        Type[] typeArgs = paramType.getActualTypeArguments();
        if (typeArgs.length != 2) {
            return resultMap;
        }
        Class<?> valueType = (Class) typeArgs[1];
        String keyFieldName = annotation.keyField();
        String[] specifiedKeys = annotation.keys();
        if (specifiedKeys.length > 0) {
            List<String> keysList = new ArrayList<>();
            for (String k : specifiedKeys) {
                if (mapJson.has(k)) {
                    keysList.add(k);
                }
            }
            Iterator<String> keysIterator2 = keysList.iterator();
            keysIterator = keysIterator2;
        } else {
            Iterator<String> keysIterator3 = mapJson.keys();
            keysIterator = keysIterator3;
        }
        while (keysIterator.hasNext()) {
            String mapKey = keysIterator.next();
            try {
                Object valueObj = valueType.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                injectKeyToField(valueObj, keyFieldName, mapKey);
                Object jsonValue = mapJson.opt(mapKey);
                if (jsonValue instanceof JSONArray) {
                    mapArrayToFirstListField(valueObj, (JSONArray) jsonValue);
                } else if (jsonValue instanceof JSONObject) {
                    mapJsonToBean((JSONObject) jsonValue, valueObj);
                }
                resultMap.put(mapKey, valueObj);
            } catch (Exception e) {
                Log.w(TAG, "Failed to parse map entry: " + mapKey, e);
            }
        }
        return resultMap;
    }

    private static void injectKeyToField(Object obj, String fieldName, String keyValue) throws Exception {
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, keyValue);
        } catch (NoSuchFieldException e) {
            String setterName = "set" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
            Method setter = obj.getClass().getMethod(setterName, String.class);
            setter.invoke(obj, keyValue);
        }
    }

    private static void mapArrayToFirstListField(Object bean, JSONArray array) throws Exception {
        Class<?> clazz = bean.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (List.class.isAssignableFrom(field.getType())) {
                field.setAccessible(true);
                List<Object> list = new ArrayList<>();
                Type genericType = field.getGenericType();
                if (genericType instanceof ParameterizedType) {
                    ParameterizedType paramType = (ParameterizedType) genericType;
                    Type[] typeArgs = paramType.getActualTypeArguments();
                    if (typeArgs.length > 0) {
                        Class<?> elementType = (Class) typeArgs[0];
                        for (int i = 0; i < array.length(); i++) {
                            JSONObject itemJson = array.optJSONObject(i);
                            if (itemJson != null) {
                                try {
                                    Method fromJson = elementType.getMethod("fromJson", JSONObject.class);
                                    Object item = fromJson.invoke(null, itemJson);
                                    if (item != null) {
                                        list.add(item);
                                    }
                                } catch (NoSuchMethodException e) {
                                    Object item2 = elementType.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                                    mapJsonToBean(itemJson, item2);
                                    list.add(item2);
                                }
                            }
                        }
                    }
                }
                field.set(bean, list);
                return;
            }
        }
    }

    private static String camelToSnake(String camelCase) {
        if (camelCase == null || camelCase.isEmpty()) {
            return camelCase;
        }
        StringBuilder result = new StringBuilder();
        result.append(Character.toLowerCase(camelCase.charAt(0)));
        for (int i = 1; i < camelCase.length(); i++) {
            char c = camelCase.charAt(i);
            if (Character.isUpperCase(c)) {
                result.append('_');
                result.append(Character.toLowerCase(c));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static <T> T createBeanFromJson(Class<T> beanClass, JSONObject json) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        try {
            T bean = beanClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            mapJsonToBean(json, bean);
            return bean;
        } catch (Exception e) {
            Log.e(TAG, "Failed to create bean from JSON", e);
            return null;
        }
    }

    public static <T> Map<String, T> parseMapWithKeyInValue(JSONObject json, String mapKey, String[] subKeys, Class<T> beanClass, String keyFieldName) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Map<String, T> resultMap = new HashMap<>();
        JSONObject mapJson = json.optJSONObject(mapKey);
        if (mapJson == null) {
            return resultMap;
        }
        for (String subKey : subKeys) {
            if (mapJson.has(subKey)) {
                try {
                    T bean = beanClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    try {
                        Field field = beanClass.getDeclaredField(keyFieldName);
                        field.setAccessible(true);
                        field.set(bean, subKey);
                    } catch (NoSuchFieldException e) {
                        String setterName = "set" + Character.toUpperCase(keyFieldName.charAt(0)) + keyFieldName.substring(1);
                        try {
                            Method setter = beanClass.getMethod(setterName, String.class);
                            setter.invoke(bean, subKey);
                        } catch (Exception ex) {
                            Log.w(TAG, "Failed to set key field: " + keyFieldName, ex);
                        }
                    }
                    Object subValue = mapJson.opt(subKey);
                    if (subValue instanceof JSONArray) {
                        mapArrayToBean(bean, (JSONArray) subValue);
                    } else if (subValue instanceof JSONObject) {
                        mapJsonToBean((JSONObject) subValue, bean);
                    }
                    resultMap.put(subKey, bean);
                } catch (Exception e2) {
                    Log.w(TAG, "Failed to parse map entry: " + subKey, e2);
                }
            }
        }
        return resultMap;
    }

    private static void mapArrayToBean(Object bean, JSONArray array) throws Exception {
        Class<?> clazz = bean.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (List.class.isAssignableFrom(field.getType())) {
                field.setAccessible(true);
                List<Object> list = new ArrayList<>();
                Type genericType = field.getGenericType();
                if (genericType instanceof ParameterizedType) {
                    ParameterizedType paramType = (ParameterizedType) genericType;
                    Type[] typeArgs = paramType.getActualTypeArguments();
                    if (typeArgs.length > 0) {
                        Class<?> elementType = (Class) typeArgs[0];
                        for (int i = 0; i < array.length(); i++) {
                            JSONObject itemJson = array.optJSONObject(i);
                            if (itemJson != null) {
                                try {
                                    Method fromJson = elementType.getMethod("fromJson", JSONObject.class);
                                    Object item = fromJson.invoke(null, itemJson);
                                    if (item != null) {
                                        list.add(item);
                                    }
                                } catch (NoSuchMethodException e) {
                                    Object item2 = elementType.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                                    mapJsonToBean(itemJson, item2);
                                    list.add(item2);
                                }
                            }
                        }
                    }
                }
                field.set(bean, list);
                return;
            }
        }
    }
}
