package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bytedanceos.common.ad.param.AdReportParam;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.AccessControlException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes.dex */
public class TypeUtils {
    public static boolean compatibleWithJavaBean = false;
    private static ConcurrentMap<String, Class<?>> mappings = null;
    private static boolean setAccessibleEnable = true;

    static {
        ConcurrentHashMap r10 = new ConcurrentHashMap();
        mappings = r10;
        r10.put("byte", Byte.TYPE);
        mappings.put("short", Short.TYPE);
        mappings.put("int", Integer.TYPE);
        mappings.put("long", Long.TYPE);
        mappings.put("float", Float.TYPE);
        mappings.put("double", Double.TYPE);
        mappings.put("boolean", Boolean.TYPE);
        mappings.put("char", Character.TYPE);
        mappings.put("[byte", byte[].class);
        mappings.put("[short", short[].class);
        mappings.put("[int", int[].class);
        mappings.put("[long", long[].class);
        mappings.put("[float", float[].class);
        mappings.put("[double", double[].class);
        mappings.put("[boolean", boolean[].class);
        mappings.put("[char", char[].class);
        mappings.put("[B", byte[].class);
        mappings.put("[S", short[].class);
        mappings.put("[I", int[].class);
        mappings.put("[J", long[].class);
        mappings.put("[F", float[].class);
        mappings.put("[D", double[].class);
        mappings.put("[C", char[].class);
        mappings.put("[Z", boolean[].class);
        mappings.put(HashMap.class.getName(), HashMap.class);
    }

    public TypeUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T cast(Object r10, Class<T> r11, ParserConfig r12) {
        if (r10 != 0) goto L5;
        return null;
    L5:
        if (r11 == null) goto L133;
        if (r11 != r10.getClass()) goto L10;
        return r10;
    L10:
        if ((r10 instanceof Map) == false) goto L22;
        if (r11 != Map.class) goto L14;
        return r10;
    L14:
        Map r13 = (Map) r10;
        if (r11 != Object.class) goto L20;
        if (r13.containsKey(JSON.DEFAULT_TYPE_KEY) == true) goto L20;
        return r10;
    L20:
        return (T) castToJavaBean(r13, r11, r12);
    L22:
        if (r11.isArray() == false) goto L35;
        if ((r10 instanceof Collection) == false) goto L31;
        Collection r14 = (Collection) r10;
        T r15 = (T) Array.newInstance(r11.getComponentType(), r14.size());
        Iterator r16 = r14.iterator();
        int r17 = 0;
    L27:
        if (r16.hasNext() == false) goto L29;
        Array.set(r15, r17, cast(r16.next(), r11.getComponentType(), r12));
        r17 = r17 + 1;
        goto L27
    L29:
        return r15;
    L31:
        if (r11 != byte[].class) goto L35;
        return (T) castToBytes(r10);
    L35:
        if (r11.isAssignableFrom(r10.getClass()) == false) goto L38;
        return r10;
    L38:
        if (r11 == Boolean.TYPE) goto L131;
        if (r11 == Boolean.class) goto L131;
        if (r11 == Byte.TYPE) goto L129;
        if (r11 == Byte.class) goto L129;
        if (r11 == Short.TYPE) goto L127;
        if (r11 == Short.class) goto L127;
        if (r11 == Integer.TYPE) goto L125;
        if (r11 == Integer.class) goto L125;
        if (r11 == Long.TYPE) goto L123;
        if (r11 == Long.class) goto L123;
        if (r11 == Float.TYPE) goto L121;
        if (r11 == Float.class) goto L121;
        if (r11 == Double.TYPE) goto L119;
        if (r11 == Double.class) goto L119;
        if (r11 != String.class) goto L77;
        return (T) castToString(r10);
    L77:
        if (r11 != BigDecimal.class) goto L81;
        return (T) castToBigDecimal(r10);
    L81:
        if (r11 != BigInteger.class) goto L85;
        return (T) castToBigInteger(r10);
    L85:
        if (r11 != Date.class) goto L89;
        return (T) castToDate(r10);
    L89:
        if (r11.isEnum() == false) goto L93;
        return (T) castToEnum(r10, r11, r12);
    L93:
        if (Calendar.class.isAssignableFrom(r11) == false) goto L105;
        Date r18 = castToDate(r10);
        if (r11 != Calendar.class) goto L134;
        Object r19 = (T) Calendar.getInstance(JSON.defaultTimeZone, JSON.defaultLocale);
    L99:
        ((Calendar) r19).setTime(r18);
        return (T) r19;
    L134:
        r19 = (T) ((Calendar) r11.newInstance());
    L101:
        e = move-exception;
        throw new JSONException("can not cast to : " + r11.getName(), e);
    L105:
        if ((r10 instanceof String) == false) goto L117;
        String r20 = (String) r10;
        if (r20.length() != 0) goto L109;
    L115:
        return null;
    L109:
        if ("null".equals(r20) == true) goto L115;
        if (r11 != Currency.class) goto L117;
        return (T) Currency.getInstance(r20);
    L117:
        throw new JSONException("can not cast to : " + r11.getName());
    L119:
        return (T) castToDouble(r10);
    L121:
        return (T) castToFloat(r10);
    L123:
        return (T) castToLong(r10);
    L125:
        return (T) castToInt(r10);
    L127:
        return (T) castToShort(r10);
    L129:
        return (T) castToByte(r10);
    L131:
        return (T) castToBoolean(r10);
    L133:
        throw new IllegalArgumentException("clazz is null");
    }

    public static final BigDecimal castToBigDecimal(Object r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if ((r10 instanceof BigDecimal) == false) goto L10;
        return (BigDecimal) r10;
    L10:
        if ((r10 instanceof BigInteger) == true) goto L12;
        String r11 = r10.toString();
        if (r11.length() != 0) goto L16;
        return null;
    L16:
        if ("null".equals(r11) == false) goto L19;
        return null;
    L19:
        return new BigDecimal(r11);
    L12:
        return new BigDecimal((BigInteger) r10);
    }

    public static final BigInteger castToBigInteger(Object r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if ((r10 instanceof BigInteger) == false) goto L10;
        return (BigInteger) r10;
    L10:
        if ((r10 instanceof Float) == true) goto L22;
        if ((r10 instanceof Double) == true) goto L22;
        String r11 = r10.toString();
        if (r11.length() != 0) goto L17;
        return null;
    L17:
        if ("null".equals(r11) == false) goto L20;
        return null;
    L20:
        return new BigInteger(r11);
    L22:
        return BigInteger.valueOf(((Number) r10).longValue());
    }

    public static final Boolean castToBoolean(Object r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if ((r10 instanceof Boolean) == false) goto L10;
        return (Boolean) r10;
    L10:
        if ((r10 instanceof Number) == false) goto L18;
        boolean r11 = true;
        if (((Number) r10).intValue() == 1) goto L16;
        r11 = false;
    L16:
        return Boolean.valueOf(r11);
    L18:
        if ((r10 instanceof String) == false) goto L39;
        String r12 = (String) r10;
        if (r12.length() != 0) goto L22;
    L37:
        return null;
    L22:
        if ("null".equals(r12) == true) goto L37;
        if ("true".equalsIgnoreCase(r12) == true) goto L36;
        if ("1".equals(r12) == true) goto L36;
        if ("false".equalsIgnoreCase(r12) == true) goto L34;
        if (AdReportParam.ClickPosType.SKIP.equals(r12) == false) goto L39;
    L34:
        return Boolean.FALSE;
    L36:
        return Boolean.TRUE;
    L39:
        throw new JSONException("can not cast to int, value : " + r10);
    }

    public static final Byte castToByte(Object r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if ((r10 instanceof Number) == false) goto L10;
        return Byte.valueOf(((Number) r10).byteValue());
    L10:
        if ((r10 instanceof String) == false) goto L20;
        String r11 = (String) r10;
        if (r11.length() != 0) goto L14;
    L18:
        return null;
    L14:
        if ("null".equals(r11) == true) goto L18;
        return Byte.valueOf(Byte.parseByte(r11));
    L20:
        throw new JSONException("can not cast to byte, value : " + r10);
    }

    public static final byte[] castToBytes(Object r10) {
        if ((r10 instanceof byte[]) == false) goto L7;
        return (byte[]) r10;
    L7:
        if ((r10 instanceof String) == false) goto L11;
        String r11 = (String) r10;
        return JSONLexer.decodeFast(r11, 0, r11.length());
    L11:
        throw new JSONException("can not cast to int, value : " + r10);
    }

    public static final Character castToChar(Object r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if ((r10 instanceof Character) == false) goto L10;
        return (Character) r10;
    L10:
        if ((r10 instanceof String) == false) goto L21;
        String r11 = (String) r10;
        if (r11.length() != 0) goto L15;
        return null;
    L15:
        if (r11.length() != 1) goto L19;
        return Character.valueOf(r11.charAt(0));
    L19:
        throw new JSONException("can not cast to byte, value : " + r10);
    L21:
        throw new JSONException("can not cast to byte, value : " + r10);
    }

    public static final Date castToDate(Object r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if ((r10 instanceof Calendar) == false) goto L10;
        return ((Calendar) r10).getTime();
    L10:
        if ((r10 instanceof Date) == false) goto L14;
        return (Date) r10;
    L14:
        if ((r10 instanceof Number) == false) goto L16;
        long r11 = ((Number) r10).longValue();
    L18:
        if ((r10 instanceof String) == false) goto L44;
        String r12 = (String) r10;
        if (r12.indexOf(45) == (-1)) goto L37;
        if (r12.length() != JSON.DEFFAULT_DATE_FORMAT.length()) goto L25;
        String r13 = JSON.DEFFAULT_DATE_FORMAT;
    L31:
        SimpleDateFormat r14 = new SimpleDateFormat(r13, JSON.defaultLocale);
        r14.setTimeZone(JSON.defaultTimeZone);
        return r14.parse(r12);
    L35:
        throw new JSONException("can not cast to Date, value : " + r12);
    L25:
        if (r12.length() != 10) goto L28;
        r13 = "yyyy-MM-dd";
        goto L31
    L28:
        if (r12.length() != 19) goto L30;
        r13 = "yyyy-MM-dd HH:mm:ss";
        goto L31
    L30:
        r13 = "yyyy-MM-dd HH:mm:ss.SSS";
        goto L31
    L37:
        if (r12.length() != 0) goto L39;
    L42:
        return null;
    L39:
        if ("null".equals(r12) == true) goto L42;
        r11 = Long.parseLong(r12);
    L44:
        if (r11 < 0) goto L48;
        return new Date(r11);
    L48:
        throw new JSONException("can not cast to Date, value : " + r10);
    L16:
        r11 = -1;
        goto L18
    }

    public static final Double castToDouble(Object r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if ((r10 instanceof Number) == false) goto L10;
        return Double.valueOf(((Number) r10).doubleValue());
    L10:
        if ((r10 instanceof String) == false) goto L20;
        String r11 = r10.toString();
        if (r11.length() != 0) goto L14;
    L18:
        return null;
    L14:
        if ("null".equals(r11) == true) goto L18;
        return Double.valueOf(Double.parseDouble(r11));
    L20:
        throw new JSONException("can not cast to double, value : " + r10);
    }

    public static final <T> T castToEnum(Object r10, Class<T> r11, ParserConfig r12) {
    L11:
        e = move-exception;
        throw new JSONException("can not cast to : " + r11.getName(), e);
    L4:
        if ((r10 instanceof String) == false) goto L14;
        String r13 = (String) r10;     // Catch: Exception -> L11
        if (r13.length() != 0) goto L10;
        return null;
    L10:
        return (T) Enum.valueOf(r11, r13);
    L14:
        if ((r10 instanceof Number) == false) goto L20;
        int r14 = ((Number) r10).intValue();     // Catch: Exception -> L11
        T[] r15 = r11.getEnumConstants();     // Catch: Exception -> L11
        if (r14 >= r15.length) goto L20;
        return r15[r14];
    L20:
        throw new JSONException("can not cast to : " + r11.getName());
    }

    public static final Float castToFloat(Object r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if ((r10 instanceof Number) == false) goto L10;
        return Float.valueOf(((Number) r10).floatValue());
    L10:
        if ((r10 instanceof String) == false) goto L20;
        String r11 = r10.toString();
        if (r11.length() != 0) goto L14;
    L18:
        return null;
    L14:
        if ("null".equals(r11) == true) goto L18;
        return Float.valueOf(Float.parseFloat(r11));
    L20:
        throw new JSONException("can not cast to float, value : " + r10);
    }

    public static final Integer castToInt(Object r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if ((r10 instanceof Integer) == false) goto L10;
        return (Integer) r10;
    L10:
        if ((r10 instanceof Number) == false) goto L14;
        return Integer.valueOf(((Number) r10).intValue());
    L14:
        if ((r10 instanceof String) == false) goto L24;
        String r11 = (String) r10;
        if (r11.length() != 0) goto L18;
    L22:
        return null;
    L18:
        if ("null".equals(r11) == true) goto L22;
        return Integer.valueOf(Integer.parseInt(r11));
    L24:
        throw new JSONException("can not cast to int, value : " + r10);
    }

    public static final <T> T castToJavaBean(Object r10, Class<T> r11) {
        return (T) cast(r10, r11, ParserConfig.global);
    }

    public static final Long castToLong(Object r10) {
        Calendar r11 = null;
        if (r10 != null) goto L6;
        return null;
    L6:
        if ((r10 instanceof Number) == false) goto L10;
        return Long.valueOf(((Number) r10).longValue());
    L10:
        if ((r10 instanceof String) == false) goto L27;
        String r12 = (String) r10;
        if (r12.length() != 0) goto L14;
    L25:
        return null;
    L14:
        if ("null".equals(r12) == true) goto L25;
        return Long.valueOf(Long.parseLong(r12));
    L18:
        JSONLexer r13 = new JSONLexer(r12);
        if (r13.scanISO8601DateIfMatch(false) == false) goto L21;
        r11 = r13.calendar;
    L21:
        r13.close();
        if (r11 == null) goto L27;
        return Long.valueOf(r11.getTimeInMillis());
    L27:
        throw new JSONException("can not cast to long, value : " + r10);
    }

    public static final Short castToShort(Object r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if ((r10 instanceof Number) == false) goto L10;
        return Short.valueOf(((Number) r10).shortValue());
    L10:
        if ((r10 instanceof String) == false) goto L20;
        String r11 = (String) r10;
        if (r11.length() != 0) goto L14;
    L18:
        return null;
    L14:
        if ("null".equals(r11) == true) goto L18;
        return Short.valueOf(Short.parseShort(r11));
    L20:
        throw new JSONException("can not cast to short, value : " + r10);
    }

    public static final String castToString(Object r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return r10.toString();
    }

    public static List<FieldInfo> computeGetters(Class<?> r39, int r40, boolean r41, JSONType r42, Map<String, String> r43, boolean r44, boolean r45, boolean r46, PropertyNamingStrategy r47) {
        LinkedHashMap r10 = new LinkedHashMap();
        Field[] r11 = r39.getDeclaredFields();
        Class<? super Object> r12 = Object.class;
        Class<JSONField> r13 = JSONField.class;
        if (r41 == true) goto L144;
        Method[] r14 = r39.getMethods();
        int r15 = r14.length;
        int r16 = 0;
    L5:
        if (r16 >= r15) goto L144;
        Method r17 = r14[r16];
        String r18 = r17.getName();
        if ((r17.getModifiers() & 8) == 0) goto L9;
    L20:
        r16 = r16;
        r15 = r15;
        r14 = r14;
        Class<JSONField> r19 = r13;
        r12 = r12;
        Field[] r110 = r11;
    L21:
        LinkedHashMap r111 = r10;
    L143:
        r16 = r16 + 1;
        r11 = r110;
        r13 = r19;
        r10 = r111;
        r14 = r14;
        r15 = r15;
        r12 = r12;
        goto L5
    L9:
        if (r17.getReturnType().equals(Void.TYPE) == true) goto L20;
        if (r17.getParameterTypes().length != 0) goto L20;
        if (r17.getReturnType() == ClassLoader.class) goto L20;
        if (r17.getDeclaringClass() == r12) goto L20;
        if (r18.equals("getMetaClass") == true) goto L19;
    L22:
        if (r45 == false) goto L24;
        JSONField r20 = (JSONField) r17.getAnnotation(r13);
    L25:
        if (r20 != null) goto L28;
        if (r45 == false) goto L28;
        r20 = getSupperMethodAnnotation(r39, r17);
    L28:
        JSONField r112 = r20;
        if (r112 != null) goto L31;
        int r21 = 0;
        int r22 = 0;
    L45:
        if (r18.startsWith("get") == true) goto L47;
        r10 = r10;
        Class<JSONField> r35 = r13;
        Field[] r36 = r11;
    L96:
        if (r18.startsWith("is") == true) goto L98;
    L99:
        r111 = r10;
        r19 = r35;
        r110 = r36;
        goto L143
    L98:
        if (r18.length() < 3) goto L99;
        char r23 = r18.charAt(2);
        if (Character.isUpperCase(r23) == false) goto L108;
        if (compatibleWithJavaBean == false) goto L106;
        String r24 = decapitalize(r18.substring(2));
    L105:
        r110 = r36;
        Field r25 = getField(r39, r24, r110);
        if (r25 != null) goto L115;
        Field r26 = getField(r39, r18, r110);
    L116:
        r19 = r35;
        if (r26 == null) goto L135;
        if (r45 == false) goto L120;
        JSONField r27 = (JSONField) r26.getAnnotation(r19);
    L121:
        if (r27 != null) goto L123;
        JSONField r28 = r27;
    L134:
        int r29 = r21;
        int r30 = r22;
    L136:
        if (r47 == 0) goto L138;
        r24 = r47.translate(r24);
    L138:
        if (r43 == null) goto L142;
        r24 = r43.get(r24);
        if (r24 == null) goto L21;
    L142:
        String r31 = r24;
        setAccessible(r39, r26, r40);
        setAccessible(r39, r17, r40);
        r111 = r10;
        r111.put(r31, new FieldInfo(r31, r17, r26, r39, null, r29, r30, r112, r28, r46));
        goto L143
    L123:
        if (r27.serialize() == false) goto L21;
        int r32 = r27.ordinal();
        int r33 = SerializerFeature.of(r27.serialzeFeatures());
        if (r27.name().length() == 0) goto L132;
        r24 = r27.name();
        if (r43 == null) goto L132;
        r24 = r43.get(r24);
        if (r24 == null) goto L21;
    L132:
        r28 = r27;
        r29 = r32;
        r30 = r33;
        goto L136
    L120:
        r27 = null;
        goto L121
    L135:
        r28 = null;
        goto L134
    L115:
        r26 = r25;
        goto L116
    L106:
        r24 = Character.toLowerCase(r18.charAt(2)) + r18.substring(3);
        goto L105
    L108:
        if (r23 != '_') goto L110;
        r24 = r18.substring(3);
        goto L105
    L110:
        if (r23 != 'f') goto L99;
        r24 = r18.substring(2);
        goto L105
    L47:
        if (r18.length() >= 4) goto L49;
    L41:
        r111 = r10;
        r19 = r13;
        r110 = r11;
        goto L143
    L49:
        if (r18.equals("getClass") == true) goto L41;
        char r34 = r18.charAt(3);
        if (Character.isUpperCase(r34) == true) goto L54;
        if (r34 != '_') goto L59;
        String r37 = r18.substring(4);
    L67:
        if (isJSONTypeIgnore(r39, r42, r37) == true) goto L41;
        Field[] r38 = r11;
        Field r48 = getField(r39, r37, r38);
        Class<JSONField> r49 = r13;
        if (r48 == null) goto L86;
        if (r45 == false) goto L73;
        JSONField r50 = (JSONField) r48.getAnnotation(r49);
    L74:
        if (r50 != null) goto L76;
    L85:
        int r210 = r22;
        int r211 = r21;
        JSONField r212 = r50;
    L87:
        if (r47 == 0) goto L89;
        r37 = r47.translate(r37);
    L89:
        if (r43 == null) goto L93;
        r37 = r43.get(r37);
        if (r37 != null) goto L93;
    L77:
        r19 = r49;
        r111 = r10;
        r110 = r38;
    L93:
        String r113 = r37;
        setAccessible(r39, r17, r40);
        r35 = r49;
        r36 = r38;
        r10 = r10;
        r10.put(r113, new FieldInfo(r113, r17, r48, r39, null, r211, r210, r112, r212, r46));
        r21 = r211;
        r22 = r210;
        goto L96
    L76:
        if (r50.serialize() == false) goto L77;
        r21 = r50.ordinal();
        r22 = SerializerFeature.of(r50.serialzeFeatures());
        if (r50.name().length() == 0) goto L85;
        r37 = r50.name();
        if (r43 == null) goto L85;
        r37 = r43.get(r37);
        if (r37 != null) goto L85;
    L73:
        r50 = null;
        goto L74
    L86:
        r210 = r22;
        r211 = r21;
        r212 = null;
        goto L87
    L59:
        if (r34 != 'f') goto L62;
        r37 = r18.substring(3);
        goto L67
    L62:
        if (r18.length() < 5) goto L41;
        if (Character.isUpperCase(r18.charAt(4)) == false) goto L41;
        r37 = decapitalize(r18.substring(3));
        goto L67
    L54:
        if (compatibleWithJavaBean == false) goto L56;
        r37 = decapitalize(r18.substring(3));
        goto L67
    L56:
        r37 = Character.toLowerCase(r18.charAt(3)) + r18.substring(4);
        goto L67
    L31:
        if (r112.serialize() == false) goto L20;
        r21 = r112.ordinal();
        r22 = SerializerFeature.of(r112.serialzeFeatures());
        if (r112.name().length() == 0) goto L45;
        String r51 = r112.name();
        if (r43 == null) goto L40;
        r51 = r43.get(r51);
        if (r51 == null) goto L20;
    L40:
        String r52 = r51;
        setAccessible(r39, r17, r40);
        r16 = r16;
        r15 = r15;
        r14 = r14;
        r13 = r13;
        r12 = r12;
        r11 = r11;
        r10 = r10;
        r10.put(r52, new FieldInfo(r52, r17, null, r39, null, r21, r22, r112, null, true));
        goto L41
    L24:
        r20 = null;
        goto L25
    L19:
        if (r17.getReturnType().getName().equals("groovy.lang.MetaClass") == false) goto L22;
    L144:
        Class<JSONField> r114 = r13;
        Class<? super Object> r310 = r12;
        Field[] r115 = r11;
        LinkedHashMap r116 = r10;
        ArrayList r53 = new ArrayList(r115.length);
        int r54 = r115.length;
        int r55 = 0;
    L145:
        if (r55 >= r54) goto L156;
        Field r56 = r115[r55];
        if ((r56.getModifiers() & 8) != 0) goto L155;
        if (r56.getName().equals("this$0") == true) goto L155;
        if ((r56.getModifiers() & 1) == 0) goto L155;
        r53.add(r56);
    L155:
        r55 = r55 + 1;
        goto L145
    L156:
        Class<? super Object> r57 = r39.getSuperclass();
    L157:
        if (r57 == null) goto L170;
        Class<? super Object> r58 = r310;
        if (r57 == r58) goto L170;
        Field[] r59 = r57.getDeclaredFields();
        int r60 = r59.length;
        int r61 = 0;
    L161:
        if (r61 >= r60) goto L169;
        Field r62 = r59[r61];
        if ((r62.getModifiers() & 8) != 0) goto L168;
        if ((r62.getModifiers() & 1) == 0) goto L168;
        r53.add(r62);
    L168:
        r61 = r61 + 1;
        goto L161
    L169:
        r57 = r57.getSuperclass();
        r310 = r58;
    L170:
        Iterator r117 = r53.iterator();
    L172:
        if (r117.hasNext() == false) goto L199;
        Field r63 = (Field) r117.next();
        if (r45 == false) goto L176;
        JSONField r64 = (JSONField) r63.getAnnotation(r114);
    L177:
        String r65 = r63.getName();
        if (r64 == null) goto L186;
        if (r64.serialize() == false) goto L172;
        int r66 = r64.ordinal();
        int r67 = SerializerFeature.of(r64.serialzeFeatures());
        if (r64.name().length() == 0) goto L185;
        r65 = r64.name();
    L185:
        int r68 = r66;
        int r69 = r67;
    L187:
        if (r43 == null) goto L192;
        r65 = r43.get(r65);
        if (r65 == null) goto L172;
    L192:
        if (r47 == null) goto L194;
        r65 = r47.translate(r65);
    L194:
        String r118 = r65;
        if (r116.containsKey(r118) == true) goto L198;
        setAccessible(r39, r63, r40);
        r116.put(r118, new FieldInfo(r118, null, r63, r39, null, r68, r69, null, r64, r46));
    L198:
        r117 = r117;
        goto L172
    L186:
        r68 = 0;
        r69 = 0;
        goto L187
    L176:
        r64 = null;
        goto L177
    L199:
        ArrayList r70 = new ArrayList();
        if (r42 == null) goto L213;
        String[] r71 = r42.orders();
        if (r71 != null) goto L204;
    L212:
        boolean r72 = false;
    L214:
        if (r72 == false) goto L218;
        int r73 = r71.length;
        int r74 = 0;
    L216:
        if (r74 >= r73) goto L224;
        r70.add((FieldInfo) r116.get(r71[r74]));
        r74 = r74 + 1;
    L224:
        return r70;
    L218:
        Iterator r75 = r116.values().iterator();
    L220:
        if (r75.hasNext() == false) goto L222;
        r70.add((FieldInfo) r75.next());
        goto L220
    L222:
        if (r44 == false) goto L224;
        Collections.sort(r70);
        goto L224
    L204:
        if (r71.length != r116.size()) goto L212;
        int r76 = r71.length;
        int r77 = 0;
    L206:
        if (r77 >= r76) goto L211;
        if (r116.containsKey(r71[r77]) == false) goto L212;
        r77 = r77 + 1;
        goto L206
    L211:
        r72 = true;
        goto L214
    L213:
        r71 = null;
        goto L212
    }

    public static String decapitalize(String r10) {
        if (r10 != null) goto L4;
    L14:
        return r10;
    L4:
        if (r10.length() == 0) goto L14;
        if (r10.length() > 1) goto L8;
    L12:
        char[] r11 = r10.toCharArray();
        r11[0] = Character.toLowerCase(r11[0]);
        return new String(r11);
    L8:
        if (Character.isUpperCase(r10.charAt(1)) == false) goto L12;
        if (Character.isUpperCase(r10.charAt(0)) == false) goto L12;
        goto L12
    }

    public static Class<?> getClass(Type r10) {
        if (r10.getClass() != Class.class) goto L7;
        return (Class) r10;
    L7:
        if ((r10 instanceof ParameterizedType) == false) goto L11;
        return getClass(((ParameterizedType) r10).getRawType());
    L11:
        if ((r10 instanceof TypeVariable) == true) goto L13;
        return Object.class;
    L13:
        return (Class) ((TypeVariable) r10).getBounds()[0];
    }

    public static Field getField(Class<?> r10, String r11, Field[] r12) {
        Field r13 = getField0(r10, r11, r12);
        if (r13 != null) goto L5;
        r13 = getField0(r10, "_" + r11, r12);
    L5:
        if (r13 != null) goto L7;
        r13 = getField0(r10, "m_" + r11, r12);
    L7:
        if (r13 == null) goto L9;
        return r13;
    L9:
        return getField0(r10, "m" + r11.substring(0, 1).toUpperCase() + r11.substring(1), r12);
    }

    private static Field getField0(Class<?> r10, String r11, Field[] r12) {
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        Field r15 = r12[r14];
        if (r11.equals(r15.getName()) == true) goto L6;
        r14 = r14 + 1;
        goto L3
    L6:
        return r15;
    L8:
        Class<? super Object> r16 = r10.getSuperclass();
        if (r16 != null) goto L11;
    L13:
        return null;
    L11:
        if (r16 == Object.class) goto L13;
        return getField(r16, r11, r16.getDeclaredFields());
    }

    public static Type getGenericParamType(Type r10) {
        if ((r10 instanceof Class) == true) goto L5;
        return r10;
    L5:
        return getGenericParamType(((Class) r10).getGenericSuperclass());
    }

    public static JSONField getSupperMethodAnnotation(Class<?> r14, Method r15) {
        Class<?>[] r10 = r14.getInterfaces();
        int r11 = r10.length;
        int r12 = 0;
    L4:
        if (r12 >= r11) goto L25;
        Method[] r13 = r10[r12].getMethods();
        int r16 = r13.length;
        int r17 = 0;
    L6:
        if (r17 >= r16) goto L24;
        Method r18 = r13[r17];
        if (r18.getName().equals(r15.getName()) == false) goto L23;
        Class<?>[] r19 = r18.getParameterTypes();
        Class<?>[] r110 = r15.getParameterTypes();
        if (r19.length != r110.length) goto L23;
        int r111 = 0;
    L15:
        if (r111 >= r19.length) goto L20;
        if (r19[r111].equals(r110[r111]) == false) goto L23;
        r111 = r111 + 1;
        goto L15
    L20:
        JSONField r20 = (JSONField) r18.getAnnotation(JSONField.class);
        if (r20 == null) goto L23;
        return r20;
    L23:
        r17 = r17 + 1;
        goto L6
    L24:
        r12 = r12 + 1;
        goto L4
    L25:
        Class<? super Object> r112 = r14.getSuperclass();
        if (r112 != null) goto L29;
        return null;
    L29:
        if (Modifier.isAbstract(r112.getModifiers()) == false) goto L49;
        Class<?>[] r21 = r15.getParameterTypes();
        Method[] r113 = r112.getMethods();
        int r22 = r113.length;
        int r23 = 0;
    L31:
        if (r23 >= r22) goto L49;
        Method r24 = r113[r23];
        Class<?>[] r25 = r24.getParameterTypes();
        if (r25.length != r21.length) goto L48;
        if (r24.getName().equals(r15.getName()) == false) goto L48;
        int r26 = 0;
    L40:
        if (r26 >= r21.length) goto L45;
        if (r25[r26].equals(r21[r26]) == false) goto L48;
        r26 = r26 + 1;
        goto L40
    L45:
        JSONField r27 = (JSONField) r24.getAnnotation(JSONField.class);
        if (r27 == null) goto L48;
        return r27;
    L48:
        r23 = r23 + 1;
    L49:
        return null;
    }

    public static boolean isGenericParamType(Type r10) {
        if ((r10 instanceof ParameterizedType) == false) goto L6;
        return true;
    L6:
        if ((r10 instanceof Class) == false) goto L14;
        Type r11 = ((Class) r10).getGenericSuperclass();
        if (r11 == Object.class) goto L13;
        if (isGenericParamType(r11) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    private static boolean isJSONTypeIgnore(Class<?> r10, JSONType r11, String r12) {
        if (r11 != null) goto L5;
    L12:
        Class<? super Object> r13 = r10.getSuperclass();
        if (r13 == Object.class) goto L21;
        if (r13 != null) goto L16;
        return false;
    L16:
        if (isJSONTypeIgnore(r13, (JSONType) r13.getAnnotation(JSONType.class), r12) == true) goto L18;
        return false;
    L18:
        return true;
    L21:
        return false;
    L5:
        if (r11.ignores() == null) goto L12;
        String[] r14 = r11.ignores();
        int r15 = r14.length;
        int r16 = 0;
    L7:
        if (r16 >= r15) goto L12;
        if (r12.equalsIgnoreCase(r14[r16]) == true) goto L10;
        r16 = r16 + 1;
        goto L7
    L10:
        return true;
    }

    public static Class<?> loadClass(String r10, ClassLoader r11) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (r10.length() == 0) goto L43;
        Class<?> r12 = mappings.get(r10);
        if (r12 == null) goto L10;
        return r12;
    L10:
        if (r10.charAt(0) != '[') goto L14;
        return Array.newInstance(loadClass(r10.substring(1), r11), 0).getClass();
    L14:
        if (r10.startsWith("L") == true) goto L16;
    L19:
        if (r11 == null) goto L41;
        r12 = r11.loadClass(r10);     // Catch: Exception -> L22
        mappings.put(r10, r12);     // Catch: Exception -> L22
        return r12;
    L22:
        e = move-exception;
        e.printStackTrace();
    L41:
        ClassLoader r13 = Thread.currentThread().getContextClassLoader();     // Catch: Exception -> L28
        if (r13 == null) goto L37;
        r12 = r13.loadClass(r10);     // Catch: Exception -> L28
        mappings.put(r10, r12);     // Catch: Exception -> L28
        return r12;
    L37:
        r12 = Class.forName(r10);     // Catch: Exception -> L32
        mappings.put(r10, r12);     // Catch: Exception -> L32
        return r12;
    L32:
        e = move-exception;
        e.printStackTrace();
        return r12;
    L28:
        e = move-exception;
        e.printStackTrace();
        goto L37
    L16:
        if (r10.endsWith(";") == false) goto L19;
        return loadClass(r10.substring(1, r10.length() - 1), r11);
    L43:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean setAccessible(Class<?> r10, Member r11, int r12) {
        if (r11 != 0) goto L5;
    L20:
        return false;
    L5:
        if (setAccessibleEnable == false) goto L20;
        Class<? super Object> r13 = r10.getSuperclass();
        if (r13 == null) goto L12;
        if (r13 == Object.class) goto L12;
    L21:
        ((AccessibleObject) r11).setAccessible(true);     // Catch: AccessControlException -> L19
        return true;
    L19:
        setAccessibleEnable = false;
    L12:
        if ((r11.getModifiers() & 1) == 0) goto L21;
        if ((r12 & 1) == 0) goto L21;
        return false;
    }

    public static final <T> T castToJavaBean(Map<String, Object> r10, Class<T> r11, ParserConfig r12) {
        if (r11 != StackTraceElement.class) goto L12;
        String r13 = (String) r10.get("className");     // Catch: Exception -> L10
        String r14 = (String) r10.get("methodName");     // Catch: Exception -> L10
        String r15 = (String) r10.get("fileName");     // Catch: Exception -> L10
        Number r16 = (Number) r10.get("lineNumber");     // Catch: Exception -> L10
        if (r16 != null) goto L7;
        int r17 = 0;
    L9:
        return (T) new StackTraceElement(r13, r14, r15, r17);
    L7:
        r17 = r16.intValue();     // Catch: Exception -> L10
        goto L9
    L12:
        Object r18 = r10.get(JSON.DEFAULT_TYPE_KEY);     // Catch: Exception -> L10
        JavaBeanDeserializer r19 = null;
        if ((r18 instanceof String) == false) goto L23;
        String r20 = (String) r18;     // Catch: Exception -> L10
        Class<?> r21 = loadClass(r20, null);     // Catch: Exception -> L10
        if (r21 == null) goto L21;
        if (r21.equals(r11) == true) goto L23;
        return (T) castToJavaBean(r10, r21, r12);
    L21:
        throw new ClassNotFoundException(r20 + " not found");     // Catch: Exception -> L10
    L23:
        if (r11.isInterface() == true) goto L25;
        if (r12 != null) goto L32;
        r12 = ParserConfig.global;     // Catch: Exception -> L10
    L32:
        ObjectDeserializer r22 = r12.getDeserializer(r11);     // Catch: Exception -> L10
        if ((r22 instanceof JavaBeanDeserializer) == false) goto L35;
        r19 = (JavaBeanDeserializer) r22;     // Catch: Exception -> L10
    L35:
        if (r19 == null) goto L39;
        return (T) r19.createInstance(r10, r12);
    L39:
        throw new JSONException("can not get javaBeanDeserializer");     // Catch: Exception -> L10
    L25:
        if ((r10 instanceof JSONObject) == false) goto L27;
        JSONObject r23 = (JSONObject) r10;     // Catch: Exception -> L10
    L29:
        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{r11}, r23);
    L27:
        r23 = new JSONObject(r10);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        throw new JSONException(e.getMessage(), e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T cast(Object r10, Type r11, ParserConfig r12) {
        if (r10 != 0) goto L6;
        return null;
    L6:
        if ((r11 instanceof Class) == false) goto L10;
        return (T) cast(r10, (Class) r11, r12);
    L10:
        if ((r11 instanceof ParameterizedType) == false) goto L14;
        return (T) cast(r10, (ParameterizedType) r11, r12);
    L14:
        if ((r10 instanceof String) == false) goto L21;
        String r13 = (String) r10;
        if (r13.length() != 0) goto L18;
    L19:
        return null;
    L18:
        if ("null".equals(r13) == true) goto L19;
    L21:
        if ((r11 instanceof TypeVariable) == false) goto L24;
        return r10;
    L24:
        throw new JSONException("can not cast to : " + r11);
    }

    /* JADX WARN: Type inference failed for: r8v5, types: [T, java.util.HashMap, java.util.Map] */
    public static final <T> T cast(Object r10, ParameterizedType r11, ParserConfig r12) {
        Type r13 = r11.getRawType();
        if (r13 == Set.class) goto L10;
        if (r13 == HashSet.class) goto L10;
        if (r13 == TreeSet.class) goto L10;
        if (r13 == List.class) goto L10;
        if (r13 == ArrayList.class) goto L10;
    L25:
        if (r13 != Map.class) goto L27;
    L28:
        Type r14 = r11.getActualTypeArguments()[0];
        Type r15 = r11.getActualTypeArguments()[1];
        if ((r10 instanceof Map) == false) goto L36;
        ?? r16 = (T) new HashMap();
        Iterator r17 = ((Map) r10).entrySet().iterator();
    L32:
        if (r17.hasNext() == false) goto L34;
        Map.Entry r18 = (Map.Entry) r17.next();
        r16.put(cast(r18.getKey(), r14, r12), cast(r18.getValue(), r15, r12));
        goto L32
    L34:
        return r16;
    L36:
        if ((r10 instanceof String) == false) goto L44;
        String r19 = (String) r10;
        if (r19.length() != 0) goto L40;
        return null;
    L40:
        if ("null".equals(r19) == false) goto L44;
        return null;
    L44:
        if (r11.getActualTypeArguments().length != 1) goto L50;
        if ((r11.getActualTypeArguments()[0] instanceof WildcardType) == false) goto L50;
        return (T) cast(r10, r13, r12);
    L50:
        throw new JSONException("can not cast to : " + r11);
    L27:
        if (r13 != HashMap.class) goto L36;
    L10:
        Type r20 = r11.getActualTypeArguments()[0];
        if ((r10 instanceof Iterable) == false) goto L25;
        if (r13 == Set.class) goto L18;
        if (r13 == HashSet.class) goto L18;
        if (r13 != TreeSet.class) goto L17;
        T r21 = (T) new TreeSet();
    L19:
        Iterator<T> r22 = ((Iterable) r10).iterator();
    L21:
        if (r22.hasNext() == false) goto L23;
        ((Collection) r21).add(cast(r22.next(), r20, r12));
        goto L21
    L23:
        return r21;
    L17:
        r21 = (T) new ArrayList();
    L18:
        r21 = (T) new HashSet();
        goto L19
    }
}
