package com.baidu.mapapi.http.wrapper;

import android.text.TextUtils;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapapi.http.wrapper.annotation.Properties;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.platform.comapi.util.JsonBuilder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastByteProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.mt.protector.impl.string2number.CastShortProtector;
import com.huawei.hms.framework.common.ContainerUtils;
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

/* JADX INFO: loaded from: classes39.dex */
public class ParamsUtils {
    public ParamsUtils() {
    }

    private static Class<?> getGenericType(Class<?> r100) {
        Type r101 = ((ParameterizedType) r100.getGenericSuperclass()).getActualTypeArguments()[0];     // Catch: Exception -> L8
        if ((r101 instanceof Class) == false) goto L6;
        return (Class) r101;
    L6:
        return null;
    L11:
        return null;
    }

    public static Map<String, Object> getParamsMap(Object[] r110) throws IllegalAccessException {
        HashMap r100 = new HashMap();
        if (r110 == null) goto L44;
        int r101 = r110.length;
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L44;
        Object r103 = r110[r102];
        if ((r103 instanceof BaseParams) == false) goto L38;
        Class<?> r104 = r103.getClass();
    L9:
        if (r104 == null) goto L43;
        if (r104 == Object.class) goto L43;
        Field[] r105 = r104.getFields();
        int r106 = r105.length;
        int r107 = 0;
    L13:
        if (r107 >= r106) goto L24;
        Field r108 = r105[r107];
        Properties r111 = (Properties) r108.getAnnotation(Properties.class);
        if (r111 == null) goto L22;
        String r112 = r111.name();
        if (r112 != null) goto L19;
    L21:
        r100.put(r108.getName(), r108.get(r103));
    L23:
        r107 = r107 + 1;
        goto L13
    L19:
        if (r112.isEmpty() == true) goto L21;
        r100.put(r112, r108.get(r103));
        goto L23
    L22:
        r100.put(r108.getName(), r108.get(r103));
        goto L23
    L24:
        Field[] r109 = r104.getDeclaredFields();
        int r113 = r109.length;
        int r114 = 0;
    L25:
        if (r114 >= r113) goto L36;
        Field r115 = r109[r114];
        r115.setAccessible(true);
        Properties r116 = (Properties) r115.getAnnotation(Properties.class);
        if (r116 == null) goto L34;
        String r117 = r116.name();
        if (r117 != null) goto L31;
    L33:
        r100.put(r115.getName(), r115.get(r103));
    L35:
        r115.setAccessible(false);
        r114 = r114 + 1;
        goto L25
    L31:
        if (r117.isEmpty() == true) goto L33;
        r100.put(r117, r115.get(r103));
        goto L35
    L34:
        r100.put(r115.getName(), r115.get(r103));
        goto L35
    L36:
        r104 = r104.getSuperclass();
    L43:
        r102 = r102 + 1;
        goto L5
    L38:
        if ((r103 instanceof Map) == false) goto L43;
        Iterator r118 = ((Map) r103).entrySet().iterator();
    L41:
        if (r118.hasNext() == false) goto L43;
        Map.Entry r119 = (Map.Entry) r118.next();
        r100.put(String.valueOf(r119.getKey()), r119.getValue());
    L44:
        return r100;
    }

    private static boolean isBasicType(Class<?> r100) {
        if (r100 != String.class) goto L6;
        return true;
    L6:
        if (r100 != Byte.class) goto L8;
    L42:
        return true;
    L8:
        if (r100 == Byte.TYPE) goto L42;
        if (r100 == Short.class) goto L42;
        if (r100 == Short.TYPE) goto L42;
        if (r100 == Integer.class) goto L42;
        if (r100 == Integer.TYPE) goto L42;
        if (r100 == Long.class) goto L42;
        if (r100 == Long.TYPE) goto L42;
        if (r100 == Float.class) goto L42;
        if (r100 == Float.TYPE) goto L42;
        if (r100 == Double.class) goto L42;
        if (r100 == Double.TYPE) goto L42;
        if (r100 == Boolean.class) goto L42;
        if (r100 == Boolean.TYPE) goto L42;
        return false;
    }

    public static String makeFormString(Object[] r100) throws IllegalAccessException {
        return makeFormString(r100, true);
    }

    public static String makeJsonString(Object[] r100) throws IllegalAccessException {
        return makeJsonString(r100, true);
    }

    public static String makeQueryString(Object[] r100) throws IllegalAccessException {
        return makeQueryString(r100, true);
    }

    public static boolean verify(BaseParams r100) {
        Class<?> r101 = r100.getClass();     // Catch: Exception -> L39
    L5:
        if (r101 == null) goto L38;
        if (r101 == Object.class) goto L38;
        Field[] r102 = r101.getFields();     // Catch: Exception -> L39
        int r103 = r102.length;     // Catch: Exception -> L39
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L22;
        Field r105 = r102[r104];     // Catch: Exception -> L39
        Object r106 = r105.get(r100);     // Catch: Exception -> L39
        Properties r107 = (Properties) r105.getAnnotation(Properties.class);     // Catch: Exception -> L39
        if (r107 == null) goto L21;
        if (r107.require() == false) goto L21;
        if (r106 == null) goto L15;
        if ((r106 instanceof String) == false) goto L21;
        if (TextUtils.isEmpty(String.valueOf(r106)) == false) goto L21;
        return false;
    L15:
        return false;
    L21:
        r104 = r104 + 1;     // Catch: Exception -> L39
        goto L9
    L22:
        Field[] r108 = r101.getDeclaredFields();     // Catch: Exception -> L39
        int r109 = r108.length;     // Catch: Exception -> L39
        int r110 = 0;
    L23:
        if (r110 >= r109) goto L36;
        Field r111 = r108[r110];     // Catch: Exception -> L39
        r111.setAccessible(true);     // Catch: Exception -> L39
        Object r112 = r111.get(r100);     // Catch: Exception -> L39
        Properties r113 = (Properties) r111.getAnnotation(Properties.class);     // Catch: Exception -> L39
        r111.setAccessible(false);     // Catch: Exception -> L39
        if (r113 == null) goto L35;
        if (r113.require() == false) goto L35;
        if (r112 == null) goto L29;
        if ((r112 instanceof String) == false) goto L35;
        if (TextUtils.isEmpty(String.valueOf(r112)) == false) goto L35;
        return false;
    L29:
        return false;
    L35:
        r110 = r110 + 1;     // Catch: Exception -> L39
        goto L23
    L36:
        r101 = r101.getSuperclass();     // Catch: Exception -> L39
    L38:
        return true;
    L39:
        return false;
    }

    public static String getJsonValue(Object r100, boolean r101) throws IllegalAccessException {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (isBasicType(r100.getClass()) == false) goto L10;
        return getValue(r100, r101);
    L10:
        return makeJsonString(new Object[]{r100}, r101);
    }

    public static String getValue(Object r100, boolean r101) {
        if (r101 == false) goto L6;
        return AppMD5.encodeUrlParamsValue(String.valueOf(r100));
    L6:
        return String.valueOf(r100);
    }

    public static String makeFormString(Object[] r100, boolean r101) throws IllegalAccessException {
        StringBuilder r102 = new StringBuilder();
        Iterator<Map.Entry<String, Object>> r103 = getParamsMap(r100).entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L17;
        Map.Entry<String, Object> r104 = r103.next();
        if (r104 == null) goto L4;
        if (r104.getKey() == null) goto L4;
        if (r104.getValue() == null) goto L4;
        if (TextUtils.isEmpty(r104.getKey()) == true) goto L4;
        if (TextUtils.isEmpty(String.valueOf(r104.getValue())) == true) goto L4;
        r102.append("--bd_map_sdk_cc\r\n");
        r102.append(String.format(HttpClient.PARAM_TEMPLATE, new Object[]{r104.getKey()}));
        r102.append("\r\n\r\n");
        r102.append(getValue(r104.getValue(), r101));
        r102.append("\r\n");
        goto L4
    L17:
        return r102.toString();
    }

    public static String makeJsonString(Object[] r100, boolean r101) throws IllegalAccessException {
        return toJsonString(getParamsMap(r100), r101);
    }

    public static String makeQueryString(Object[] r100, boolean r101) throws IllegalAccessException {
        Map<String, Object> r102 = getParamsMap(r100);
        StringBuilder r103 = new StringBuilder();
        Iterator<Map.Entry<String, Object>> r104 = r102.entrySet().iterator();
    L4:
        if (r104.hasNext() == false) goto L40;
        Map.Entry<String, Object> r105 = r104.next();
        String r106 = r105.getKey();
        Object r107 = r105.getValue();
        if (r106 == null) goto L4;
        if (r107 == null) goto L4;
        if (TextUtils.isEmpty(r106) == true) goto L4;
        if (TextUtils.isEmpty(String.valueOf(r105.getValue())) == true) goto L4;
        r103.append(r106);
        r103.append(ContainerUtils.KEY_VALUE_DELIMITER);
        int r108 = 0;
        if (r107.getClass().isArray() == false) goto L21;
        Object[] r109 = (Object[]) r107;
        if (r109.length <= 0) goto L38;
        int r110 = r109.length;
    L17:
        if (r108 >= r110) goto L19;
        r103.append(getValue(r109[r108], r101));
        r103.append(",");
        r108 = r108 + 1;
        goto L17
    L19:
        r103.deleteCharAt(r103.length() - 1);
    L38:
        r103.append("&");
        goto L4
    L21:
        if ((r107 instanceof List) == false) goto L29;
        List r111 = (List) r107;
        if (r111.isEmpty() == true) goto L38;
    L25:
        if (r108 >= r111.size()) goto L27;
        r103.append(getValue(ListProtector.get(r111, r108), r101));
        r103.append(",");
        r108 = r108 + 1;
        goto L25
    L27:
        r103.deleteCharAt(r103.length() - 1);
        goto L38
    L29:
        if ((r107 instanceof Set) == false) goto L37;
        Set r112 = (Set) r107;
        if (r112.isEmpty() == true) goto L38;
        Iterator r113 = r112.iterator();
    L34:
        if (r113.hasNext() == false) goto L36;
        r103.append(getValue(r113.next(), r101));
        r103.append(",");
        goto L34
    L36:
        r103.deleteCharAt(r103.length() - 1);
        goto L38
    L37:
        r103.append(getValue(r107, r101));
        goto L38
    L40:
        if (r103.length() <= 0) goto L43;
        r103.deleteCharAt(r103.length() - 1);
    L43:
        return r103.toString();
    }

    private static Object toBasicValue(Object r100, Class<?> r101) {
        if (r101 != String.class) goto L7;
        return r100.toString();
    L7:
        if (r101 == Byte.class) goto L56;
        if (r101 == Byte.TYPE) goto L56;
        if (r101 == Short.class) goto L54;
        if (r101 == Short.TYPE) goto L54;
        if (r101 == Integer.class) goto L52;
        if (r101 == Integer.TYPE) goto L52;
        if (r101 == Long.class) goto L50;
        if (r101 == Long.TYPE) goto L50;
        if (r101 == Float.class) goto L48;
        if (r101 == Float.TYPE) goto L48;
        if (r101 == Double.class) goto L46;
        if (r101 == Double.TYPE) goto L46;
        if (r101 == Boolean.class) goto L44;
        if (r101 == Boolean.TYPE) goto L44;
        return null;
    L44:
        return Boolean.valueOf(r100.toString());
    L46:
        return CastDoubleProtector.valueOf(r100.toString());
    L48:
        return CastFloatProtector.valueOf(r100.toString());
    L50:
        return CastLongProtector.valueOf(r100.toString());
    L52:
        return CastIntegerProtector.valueOf(r100.toString());
    L54:
        return CastShortProtector.valueOf(r100.toString());
    L56:
        return CastByteProtector.valueOf(r100.toString());
    }

    public static String toJsonString(Object r100, boolean r101) throws IllegalAccessException {
        if (r100 != null) goto L5;
        return "";
    L5:
        JsonBuilder r102 = new JsonBuilder();
        toJsonStringInner(r100, r101, r102);
        return r102.getJson();
    }

    private static Object toMultiValue(String r100, Type r101) throws JSONException, IllegalAccessException, InstantiationException {
        if ((r101 instanceof Class) == false) goto L5;
        Class r102 = (Class) r101;
    L7:
        if ((r101 instanceof ParameterizedType) == false) goto L9;
        r102 = (Class) ((ParameterizedType) r101).getRawType();
    L9:
        if (r102 != null) goto L12;
        return null;
    L12:
        if (Set.class.isAssignableFrom(r102) == false) goto L14;
    L20:
        JSONArray r103 = new JSONArray(r100);
        int r104 = r103.length();
        Object[] r105 = new Object[r104];
        ParameterizedType r106 = (ParameterizedType) r101;
        Type r107 = r106.getActualTypeArguments()[0];
        int r108 = 0;
    L21:
        if (r108 >= r104) goto L30;
        if ((r107 instanceof Class) == false) goto L27;
        Class r109 = (Class) r107;
        if (isBasicType(r109) == false) goto L27;
        r105[r108] = toBasicValue(r103.get(r108).toString(), r109);
    L28:
        r108 = r108 + 1;
    L27:
        r105[r108] = toMultiValue(r103.get(r108).toString(), r106.getActualTypeArguments()[0]);
        goto L28
    L30:
        if (TreeSet.class.isAssignableFrom(r102) == false) goto L34;
        return new TreeSet(Arrays.asList(r105));
    L34:
        if (LinkedList.class.isAssignableFrom(r102) == false) goto L38;
        return new LinkedList(Arrays.asList(r105));
    L38:
        if (Set.class.isAssignableFrom(r102) == false) goto L42;
        return new HashSet(Arrays.asList(r105));
    L42:
        if (List.class.isAssignableFrom(r102) == true) goto L44;
        return r105;
    L44:
        return new ArrayList(Arrays.asList(r105));
    L14:
        if (List.class.isAssignableFrom(r102) == true) goto L20;
        if (r102.isArray() == true) goto L20;
        return toObject(r100, r102);
    L5:
        r102 = null;
        goto L7
    }

    public static Object toObject(String r100, Class<?> r101) throws JSONException, IllegalAccessException, InstantiationException {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        if (isBasicType(r101) == true) goto L8;
        int r102 = 0;
        if (BaseParams.class.isAssignableFrom(r101) == false) goto L42;
        JSONObject r103 = new JSONObject(r100);
        Object r104 = r101.newInstance();
    L12:
        if (r101 == null) goto L40;
        if (r101 == Object.class) goto L40;
        Field[] r105 = r101.getFields();
        int r106 = r105.length;
        int r107 = 0;
    L16:
        if (r107 >= r106) goto L27;
        Field r108 = r105[r107];
        Properties r109 = (Properties) r108.getAnnotation(Properties.class);
        if (r109 != null) goto L20;
    L22:
        if (r109 != null) goto L26;
        if (r103.has(r108.getName()) == false) goto L26;
        setValue(r104, r108, r103.get(r108.getName()));
    L26:
        r107 = r107 + 1;
        goto L16
    L20:
        if (r103.has(r109.name()) == false) goto L22;
        setValue(r104, r108, r103.get(r109.name()));
        goto L26
    L27:
        Field[] r110 = r101.getDeclaredFields();
        int r111 = r110.length;
        int r112 = 0;
    L28:
        if (r112 >= r111) goto L39;
        Field r113 = r110[r112];
        r113.setAccessible(true);
        Properties r114 = (Properties) r113.getAnnotation(Properties.class);
        if (r114 != null) goto L32;
    L34:
        if (r114 != null) goto L38;
        if (r103.has(r113.getName()) == false) goto L38;
        setValue(r104, r113, r103.get(r113.getName()));
    L38:
        r113.setAccessible(false);
        r112 = r112 + 1;
        goto L28
    L32:
        if (r103.has(r114.name()) == false) goto L34;
        setValue(r104, r113, r103.get(r114.name()));
        goto L38
    L39:
        r101 = r101.getSuperclass();
    L40:
        return r104;
    L42:
        if (Map.class.isAssignableFrom(r101) == false) goto L52;
        JSONObject r115 = new JSONObject(r100);
        Map r116 = new HashMap();
        if (TreeMap.class.isAssignableFrom(r101) == false) goto L46;
        r116 = new TreeMap();
    L46:
        Iterator<String> r117 = r115.keys();
    L48:
        if (r117.hasNext() == false) goto L50;
        String r118 = r117.next();
        r116.put(r118, r115.get(r118));
        goto L48
    L50:
        return r116;
    L52:
        if (Set.class.isAssignableFrom(r101) == false) goto L54;
    L59:
        JSONArray r119 = new JSONArray(r100);
        int r120 = r119.length();
        Object[] r121 = new Object[r120];
        if (r101.isArray() == false) goto L62;
        Class<?> r122 = r101.getComponentType();
    L63:
        int r123 = 0;
    L64:
        if (r123 >= r120) goto L71;
        if (isBasicType(r122) == false) goto L68;
        r121[r123] = toBasicValue(r119.get(r123).toString(), r122);
    L69:
        r123 = r123 + 1;
        goto L64
    L68:
        r121[r123] = toObject(r119.get(r123).toString(), r122);
        goto L69
    L71:
        if (TreeSet.class.isAssignableFrom(r101) == false) goto L75;
        return new TreeSet(Arrays.asList(r121));
    L75:
        if (LinkedList.class.isAssignableFrom(r101) == false) goto L79;
        return new LinkedList(Arrays.asList(r121));
    L79:
        if (Set.class.isAssignableFrom(r101) == false) goto L83;
        return new HashSet(Arrays.asList(r121));
    L83:
        if (List.class.isAssignableFrom(r101) == false) goto L87;
        return new ArrayList(Arrays.asList(r121));
    L87:
        if (r101.isArray() == false) goto L92;
        Object r124 = Array.newInstance(r101.getComponentType(), r120);
    L89:
        if (r102 >= r120) goto L91;
        Array.set(r124, r102, r121[r102]);
        r102 = r102 + 1;
        goto L89
    L91:
        return r124;
    L92:
        return r121;
    L62:
        r122 = getGenericType(r101);
        goto L63
    L54:
        if (List.class.isAssignableFrom(r101) == true) goto L59;
        if (r101.isArray() == true) goto L59;
        return null;
    L8:
        return toBasicValue(r100, r101);
    }

    private static void setValue(Object r100, Field r101, Object r102) throws IllegalAccessException {
        if (isBasicType(r101.getType()) == false) goto L5;
        r101.set(r100, toBasicValue(r102, r101.getType()));     // Catch: Exception -> L7
    L8:
        return;
    L5:
        r101.set(r100, toMultiValue(r102.toString(), r101.getGenericType()));     // Catch: Exception -> L7
    }

    private static void toJsonStringInner(Object r100, boolean r101, JsonBuilder r102) throws IllegalAccessException {
        if (r100 != null) goto L6;
        r102.valueDirect("null");
        return;
    L6:
        if ((r100 instanceof Map) == false) goto L12;
        r102.object();
        Iterator r103 = ((Map) r100).entrySet().iterator();
    L9:
        if (r103.hasNext() == false) goto L11;
        Map.Entry r104 = (Map.Entry) r103.next();
        r102.key(String.valueOf(r104.getKey()));
        toJsonStringInner(r104.getValue(), r101, r102);
        goto L9
    L11:
        r102.endObject();
        return;
    L12:
        boolean r105 = r100 instanceof List;
        int r106 = 0;
        if (r105 == false) goto L15;
    L29:
        r102.arrayValue();
        if (r105 == false) goto L36;
        List r107 = (List) r100;
    L33:
        if (r106 >= r107.size()) goto L46;
        toJsonStringInner(ListProtector.get(r107, r106), r101, r102);
        r106 = r106 + 1;
    L46:
        r102.endArrayValue();
        return;
    L36:
        if ((r100 instanceof Set) == false) goto L41;
        Iterator r108 = ((Set) r100).iterator();
    L39:
        if (r108.hasNext() == false) goto L46;
        toJsonStringInner(r108.next(), r101, r102);
        goto L39
    L41:
        int r109 = Array.getLength(r100);
    L42:
        if (r106 >= r109) goto L46;
        toJsonStringInner(Array.get(r100, r106), r101, r102);     // Catch: Throwable -> L48
        r106 = r106 + 1;
    L48:
        th = move-exception;
        throw th;
    L15:
        if ((r100 instanceof Set) == true) goto L29;
        if (r100.getClass().isArray() == true) goto L29;
        if (isBasicType(r100.getClass()) == false) goto L26;
        Object r110 = toBasicValue(r100, r100.getClass());
        if ((r110 instanceof String) == false) goto L24;
        r102.valueDirect(String.format("\"%s\"", new Object[]{getValue(r110, r101)}));
        return;
    L24:
        r102.valueDirect(String.valueOf(r110));
        return;
    L26:
        if ((r100 instanceof BaseParams) == false) goto L28;
        toJsonStringInner(getParamsMap(new Object[]{r100}), r101, r102);
        return;
    L28:
        r102.value(r100.toString());
    }
}
