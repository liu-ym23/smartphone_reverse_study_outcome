package com.baidu.mapapi.http.wrapper;

import android.text.TextUtils;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapapi.http.wrapper.annotation.Properties;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.platform.comapi.util.JsonBuilder;
import com.stepos.alphame.utils.Consts;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ParamsUtils {
    private static Class<?> getGenericType(Class<?> cls) {
        try {
            Type type = ((ParameterizedType) cls.getGenericSuperclass()).getActualTypeArguments()[0];
            if (type instanceof Class) {
                return (Class) type;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getJsonValue(Object obj, boolean z4) throws IllegalAccessException {
        if (obj == null) {
            return null;
        }
        return isBasicType(obj.getClass()) ? getValue(obj, z4) : makeJsonString(new Object[]{obj}, z4);
    }

    public static Map<String, Object> getParamsMap(Object[] objArr) throws IllegalAccessException, SecurityException {
        HashMap map = new HashMap();
        if (objArr != null) {
            for (Object obj : objArr) {
                if (obj instanceof BaseParams) {
                    for (Field field : obj.getClass().getFields()) {
                        Properties properties = (Properties) field.getAnnotation(Properties.class);
                        if (properties != null) {
                            String strName = properties.name();
                            if (strName == null || strName.isEmpty()) {
                                map.put(field.getName(), field.get(obj));
                            } else {
                                map.put(strName, field.get(obj));
                            }
                        } else {
                            map.put(field.getName(), field.get(obj));
                        }
                    }
                    for (Field field2 : obj.getClass().getDeclaredFields()) {
                        field2.setAccessible(true);
                        Properties properties2 = (Properties) field2.getAnnotation(Properties.class);
                        if (properties2 != null) {
                            String strName2 = properties2.name();
                            if (strName2 == null || strName2.isEmpty()) {
                                map.put(field2.getName(), field2.get(obj));
                            } else {
                                map.put(strName2, field2.get(obj));
                            }
                        } else {
                            map.put(field2.getName(), field2.get(obj));
                        }
                        field2.setAccessible(false);
                    }
                } else if (obj instanceof Map) {
                    for (Map.Entry entry : ((Map) obj).entrySet()) {
                        map.put(String.valueOf(entry.getKey()), entry.getValue());
                    }
                }
            }
        }
        return map;
    }

    public static String getValue(Object obj, boolean z4) {
        return z4 ? AppMD5.encodeUrlParamsValue(String.valueOf(obj)) : String.valueOf(obj);
    }

    private static boolean isBasicType(Class<?> cls) {
        return cls == String.class || cls == Byte.class || cls == Byte.TYPE || cls == Short.class || cls == Short.TYPE || cls == Integer.class || cls == Integer.TYPE || cls == Long.class || cls == Long.TYPE || cls == Float.class || cls == Float.TYPE || cls == Double.class || cls == Double.TYPE || cls == Boolean.class || cls == Boolean.TYPE;
    }

    public static String makeFormString(Object[] objArr) throws IllegalAccessException {
        return makeFormString(objArr, true);
    }

    public static String makeJsonString(Object[] objArr) throws IllegalAccessException {
        return makeJsonString(objArr, true);
    }

    public static String makeQueryString(Object[] objArr) throws IllegalAccessException {
        return makeQueryString(objArr, true);
    }

    private static void setValue(Object obj, Field field, Object obj2) throws IllegalAccessException, IllegalArgumentException {
        try {
            if (isBasicType(field.getType())) {
                field.set(obj, toBasicValue(obj2, field.getType()));
            } else {
                field.set(obj, toMultiValue(obj2.toString(), field.getGenericType()));
            }
        } catch (Exception unused) {
        }
    }

    private static Object toBasicValue(Object obj, Class<?> cls) {
        if (cls == String.class) {
            return obj.toString();
        }
        if (cls == Byte.class || cls == Byte.TYPE) {
            return Byte.valueOf(obj.toString());
        }
        if (cls == Short.class || cls == Short.TYPE) {
            return Short.valueOf(obj.toString());
        }
        if (cls == Integer.class || cls == Integer.TYPE) {
            return Integer.valueOf(obj.toString());
        }
        if (cls == Long.class || cls == Long.TYPE) {
            return Long.valueOf(obj.toString());
        }
        if (cls == Float.class || cls == Float.TYPE) {
            return Float.valueOf(obj.toString());
        }
        if (cls == Double.class || cls == Double.TYPE) {
            return Double.valueOf(obj.toString());
        }
        if (cls == Boolean.class || cls == Boolean.TYPE) {
            return Boolean.valueOf(obj.toString());
        }
        return null;
    }

    public static String toJsonString(Object obj, boolean z4) throws IllegalAccessException {
        if (obj == null) {
            return "";
        }
        JsonBuilder jsonBuilder = new JsonBuilder();
        toJsonStringInner(obj, z4, jsonBuilder);
        return jsonBuilder.getJson();
    }

    private static void toJsonStringInner(Object obj, boolean z4, JsonBuilder jsonBuilder) throws IllegalAccessException {
        if (obj == null) {
            jsonBuilder.value("");
            return;
        }
        if (obj instanceof Map) {
            jsonBuilder.object();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                jsonBuilder.key(String.valueOf(entry.getKey()));
                toJsonStringInner(entry.getValue(), z4, jsonBuilder);
            }
            jsonBuilder.endObject();
            return;
        }
        boolean z5 = obj instanceof List;
        if (!z5 && !(obj instanceof Set) && !obj.getClass().isArray()) {
            if (!isBasicType(obj.getClass())) {
                toJsonStringInner(getParamsMap(new Object[]{obj}), z4, jsonBuilder);
                return;
            }
            Object basicValue = toBasicValue(obj, obj.getClass());
            if (!(basicValue instanceof String)) {
                jsonBuilder.valueDirect(String.valueOf(basicValue));
                return;
            }
            jsonBuilder.valueDirect("\"" + getValue(basicValue, z4) + "\"");
            return;
        }
        jsonBuilder.arrayValue();
        int i4 = 0;
        if (z5) {
            List list = (List) obj;
            while (i4 < list.size()) {
                toJsonStringInner(list.get(i4), z4, jsonBuilder);
                i4++;
            }
        } else if (obj instanceof Set) {
            Iterator it = ((Set) obj).iterator();
            while (it.hasNext()) {
                toJsonStringInner(it.next(), z4, jsonBuilder);
            }
        } else {
            int length = Array.getLength(obj);
            while (i4 < length) {
                toJsonStringInner(Array.get(obj, i4), z4, jsonBuilder);
                i4++;
            }
        }
        jsonBuilder.endArrayValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.Object toMultiValue(java.lang.String r10, java.lang.reflect.Type r11) throws org.json.JSONException, java.lang.IllegalAccessException, java.lang.InstantiationException {
        /*
            boolean r0 = r11 instanceof java.lang.Class
            r1 = 0
            if (r0 == 0) goto L9
            r0 = r11
            java.lang.Class r0 = (java.lang.Class) r0
            goto La
        L9:
            r0 = r1
        La:
            boolean r2 = r11 instanceof java.lang.reflect.ParameterizedType
            if (r2 == 0) goto L17
            r0 = r11
            java.lang.reflect.ParameterizedType r0 = (java.lang.reflect.ParameterizedType) r0
            java.lang.reflect.Type r0 = r0.getRawType()
            java.lang.Class r0 = (java.lang.Class) r0
        L17:
            if (r0 != 0) goto L1a
            return r1
        L1a:
            java.lang.Class<java.util.Set> r1 = java.util.Set.class
            boolean r2 = r1.isAssignableFrom(r0)
            java.lang.Class<java.util.List> r3 = java.util.List.class
            if (r2 != 0) goto L36
            boolean r2 = r3.isAssignableFrom(r0)
            if (r2 != 0) goto L36
            boolean r2 = r0.isArray()
            if (r2 == 0) goto L31
            goto L36
        L31:
            java.lang.Object r10 = toObject(r10, r0)
            return r10
        L36:
            org.json.JSONArray r2 = new org.json.JSONArray
            r2.<init>(r10)
            int r10 = r2.length()
            java.lang.Object[] r4 = new java.lang.Object[r10]
            java.lang.reflect.ParameterizedType r11 = (java.lang.reflect.ParameterizedType) r11
            java.lang.reflect.Type[] r5 = r11.getActualTypeArguments()
            r6 = 0
            r5 = r5[r6]
            r7 = r6
        L4b:
            if (r7 >= r10) goto L80
            boolean r8 = r5 instanceof java.lang.Class
            if (r8 == 0) goto L69
            r8 = r5
            java.lang.Class r8 = (java.lang.Class) r8
            boolean r9 = isBasicType(r8)
            if (r9 == 0) goto L69
            java.lang.Object r9 = r2.get(r7)
            java.lang.String r9 = r9.toString()
            java.lang.Object r8 = toBasicValue(r9, r8)
            r4[r7] = r8
            goto L7d
        L69:
            java.lang.Object r8 = r2.get(r7)
            java.lang.String r8 = r8.toString()
            java.lang.reflect.Type[] r9 = r11.getActualTypeArguments()
            r9 = r9[r6]
            java.lang.Object r8 = toMultiValue(r8, r9)
            r4[r7] = r8
        L7d:
            int r7 = r7 + 1
            goto L4b
        L80:
            java.lang.Class<java.util.TreeSet> r10 = java.util.TreeSet.class
            boolean r10 = r10.isAssignableFrom(r0)
            if (r10 == 0) goto L92
            java.util.TreeSet r10 = new java.util.TreeSet
            java.util.List r11 = java.util.Arrays.asList(r4)
            r10.<init>(r11)
            return r10
        L92:
            java.lang.Class<java.util.LinkedList> r10 = java.util.LinkedList.class
            boolean r10 = r10.isAssignableFrom(r0)
            if (r10 == 0) goto La4
            java.util.LinkedList r10 = new java.util.LinkedList
            java.util.List r11 = java.util.Arrays.asList(r4)
            r10.<init>(r11)
            return r10
        La4:
            boolean r10 = r1.isAssignableFrom(r0)
            if (r10 == 0) goto Lb4
            java.util.HashSet r10 = new java.util.HashSet
            java.util.List r11 = java.util.Arrays.asList(r4)
            r10.<init>(r11)
            return r10
        Lb4:
            boolean r10 = r3.isAssignableFrom(r0)
            if (r10 == 0) goto Lc4
            java.util.ArrayList r10 = new java.util.ArrayList
            java.util.List r11 = java.util.Arrays.asList(r4)
            r10.<init>(r11)
            return r10
        Lc4:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.http.wrapper.ParamsUtils.toMultiValue(java.lang.String, java.lang.reflect.Type):java.lang.Object");
    }

    public static Object toObject(String str, Class<?> cls) throws IllegalAccessException, JSONException, InstantiationException, SecurityException, ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (isBasicType(cls)) {
            return toBasicValue(str, cls);
        }
        if (BaseParams.class.isAssignableFrom(cls)) {
            JSONObject jSONObject = new JSONObject(str);
            Object objNewInstance = cls.newInstance();
            for (Field field : cls.getFields()) {
                Properties properties = (Properties) field.getAnnotation(Properties.class);
                if (properties != null && jSONObject.has(properties.name())) {
                    setValue(objNewInstance, field, jSONObject.get(properties.name()));
                } else if (properties == null && jSONObject.has(field.getName())) {
                    setValue(objNewInstance, field, jSONObject.get(field.getName()));
                }
            }
            for (Field field2 : cls.getDeclaredFields()) {
                field2.setAccessible(true);
                Properties properties2 = (Properties) field2.getAnnotation(Properties.class);
                if (properties2 != null && jSONObject.has(properties2.name())) {
                    setValue(objNewInstance, field2, jSONObject.get(properties2.name()));
                } else if (properties2 == null && jSONObject.has(field2.getName())) {
                    setValue(objNewInstance, field2, jSONObject.get(field2.getName()));
                }
                field2.setAccessible(false);
            }
            return objNewInstance;
        }
        if (Map.class.isAssignableFrom(cls)) {
            JSONObject jSONObject2 = new JSONObject(str);
            Map map = new HashMap();
            if (TreeMap.class.isAssignableFrom(cls)) {
                map = new TreeMap();
            }
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject2.get(next));
            }
            return map;
        }
        if (!Set.class.isAssignableFrom(cls) && !List.class.isAssignableFrom(cls) && !cls.isArray()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray(str);
        int length = jSONArray.length();
        Object[] objArr = new Object[length];
        Class<?> componentType = cls.isArray() ? cls.getComponentType() : getGenericType(cls);
        for (int i4 = 0; i4 < length; i4++) {
            if (isBasicType(componentType)) {
                objArr[i4] = toBasicValue(jSONArray.get(i4).toString(), componentType);
            } else {
                objArr[i4] = toObject(jSONArray.get(i4).toString(), componentType);
            }
        }
        if (TreeSet.class.isAssignableFrom(cls)) {
            return new TreeSet(Arrays.asList(objArr));
        }
        if (LinkedList.class.isAssignableFrom(cls)) {
            return new LinkedList(Arrays.asList(objArr));
        }
        if (Set.class.isAssignableFrom(cls)) {
            return new HashSet(Arrays.asList(objArr));
        }
        if (List.class.isAssignableFrom(cls)) {
            return new ArrayList(Arrays.asList(objArr));
        }
        if (!cls.isArray()) {
            return objArr;
        }
        Object objNewInstance2 = Array.newInstance(cls.getComponentType(), length);
        for (int i5 = 0; i5 < length; i5++) {
            Array.set(objNewInstance2, i5, objArr[i5]);
        }
        return objNewInstance2;
    }

    public static boolean verify(BaseParams baseParams) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        try {
            Class<?> cls = baseParams.getClass();
            for (Field field : cls.getFields()) {
                Object obj = field.get(baseParams);
                Properties properties = (Properties) field.getAnnotation(Properties.class);
                if (properties != null && properties.require()) {
                    if (obj == null) {
                        return false;
                    }
                    if ((obj instanceof String) && TextUtils.isEmpty(String.valueOf(obj))) {
                        return false;
                    }
                }
            }
            for (Field field2 : cls.getDeclaredFields()) {
                field2.setAccessible(true);
                Object obj2 = field2.get(baseParams);
                Properties properties2 = (Properties) field2.getAnnotation(Properties.class);
                field2.setAccessible(false);
                if (properties2 != null && properties2.require()) {
                    if (obj2 == null) {
                        return false;
                    }
                    if ((obj2 instanceof String) && TextUtils.isEmpty(String.valueOf(obj2))) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String makeFormString(Object[] objArr, boolean z4) throws IllegalAccessException {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : getParamsMap(objArr).entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null && !TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(String.valueOf(entry.getValue()))) {
                sb.append("--bd_map_sdk_cc\r\n");
                sb.append(String.format(HttpClient.PARAM_TEMPLATE, entry.getKey()));
                sb.append("\r\n\r\n");
                sb.append(getValue(entry.getValue(), z4));
                sb.append(HttpClient.NEWLINE);
            }
        }
        return sb.toString();
    }

    public static String makeJsonString(Object[] objArr, boolean z4) throws IllegalAccessException {
        return toJsonString(getParamsMap(objArr), z4);
    }

    public static String makeQueryString(Object[] objArr, boolean z4) throws IllegalAccessException, SecurityException {
        Map<String, Object> paramsMap = getParamsMap(objArr);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : paramsMap.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (entry.getKey() != null && entry.getValue() != null && !TextUtils.isEmpty(key) && !TextUtils.isEmpty(String.valueOf(entry.getValue()))) {
                sb.append(key);
                sb.append(Consts.SPLITTER_EQUAL);
                int i4 = 0;
                if (value.getClass().isArray()) {
                    Object[] objArr2 = (Object[]) value;
                    if (objArr2.length > 0) {
                        int length = objArr2.length;
                        while (i4 < length) {
                            sb.append(getValue(objArr2[i4], z4));
                            sb.append(",");
                            i4++;
                        }
                        sb.deleteCharAt(sb.length() - 1);
                    }
                } else if (value instanceof List) {
                    List list = (List) value;
                    if (!list.isEmpty()) {
                        while (i4 < list.size()) {
                            sb.append(getValue(Integer.valueOf(i4), z4));
                            sb.append(",");
                            i4++;
                        }
                        sb.deleteCharAt(sb.length() - 1);
                    }
                } else if (value instanceof Set) {
                    Set set = (Set) value;
                    if (!set.isEmpty()) {
                        Iterator it = set.iterator();
                        while (it.hasNext()) {
                            sb.append(getValue(it.next(), z4));
                            sb.append(",");
                        }
                        sb.deleteCharAt(sb.length() - 1);
                    }
                } else {
                    sb.append(getValue(value, z4));
                }
                sb.append("&");
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
