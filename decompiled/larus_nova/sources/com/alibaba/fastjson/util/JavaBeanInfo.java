package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONPOJOBuilder;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.amap.api.col.s.ce;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes28.dex */
public class JavaBeanInfo {
    public final Method buildMethod;
    public final Class<?> builderClass;
    public final Class<?> clazz;
    public final Constructor<?> creatorConstructor;
    public Type[] creatorConstructorParameterTypes;
    public String[] creatorConstructorParameters;
    public final Constructor<?> defaultConstructor;
    public final int defaultConstructorParameterSize;
    public final Method factoryMethod;
    public final FieldInfo[] fields;
    public final JSONType jsonType;

    /* JADX INFO: renamed from: kotlin, reason: collision with root package name */
    public boolean f24938kotlin;
    public Constructor<?> kotlinDefaultConstructor;
    public String[] orders;
    public final int parserFeatures;
    public final FieldInfo[] sortedFields;
    public final String typeKey;
    public final String typeName;

    private static Map<TypeVariable, Type> buildGenericInfo(Class<?> r100) {
        Class<? super Object> r101 = r100.getSuperclass();
        HashMap r102 = null;
        if (r101 != null) goto L5;
        return null;
    L5:
        Class<? super Object> r103 = r101;
        Class<?> r104 = r100;
        r100 = r103;
        if (r100 == null) goto L22;
        if (r100 == Object.class) goto L22;
        if ((r104.getGenericSuperclass() instanceof ParameterizedType) == false) goto L21;
        Type[] r105 = ((ParameterizedType) r104.getGenericSuperclass()).getActualTypeArguments();
        TypeVariable<Class<?>>[] r106 = r100.getTypeParameters();
        int r107 = 0;
    L13:
        if (r107 >= r105.length) goto L21;
        if (r102 != null) goto L17;
        r102 = new HashMap();
    L17:
        if (r102.containsKey(r105[r107]) == false) goto L19;
        Type r108 = r102.get(r105[r107]);
        r102.put(r106[r107], r108);
    L20:
        r107 = r107 + 1;
        goto L13
    L19:
        r102.put(r106[r107], r105[r107]);
    L21:
        r101 = r100.getSuperclass();
    L22:
        return r102;
    }

    public static Class<?> getBuilderClass(JSONType r100) {
        return getBuilderClass(null, r100);
    }

    public static Constructor<?> getCreatorConstructor(Constructor[] r110) {
        int r100 = r110.length;
        Constructor r101 = null;
        int r102 = 0;
    L4:
        if (r102 >= r100) goto L12;
        Constructor r103 = r110[r102];
        if (((JSONCreator) r103.getAnnotation(JSONCreator.class)) == null) goto L11;
        if (r101 != null) goto L10;
        r101 = r103;
        goto L11
    L10:
        throw new JSONException("multi-JSONCreator");
    L11:
        r102 = r102 + 1;
        goto L4
    L12:
        if (r101 == null) goto L14;
        return r101;
    L14:
        int r104 = r110.length;
        int r105 = 0;
    L15:
        if (r105 >= r104) goto L38;
        Constructor r106 = r110[r105];
        Annotation[][] r107 = TypeUtils.getParameterAnnotations(r106);
        if (r107.length == 0) goto L37;
        int r108 = r107.length;
        int r109 = 0;
    L20:
        boolean r111 = true;
        if (r109 >= r108) goto L32;
        Annotation[] r112 = r107[r109];
        int r113 = r112.length;
        int r114 = 0;
    L23:
        if (r114 >= r113) goto L28;
        if ((r112[r114] instanceof JSONField) == true) goto L29;
        r114 = r114 + 1;
    L29:
        if (r111 == false) goto L30;
        r109 = r109 + 1;
        goto L20
    L30:
        r111 = false;
        goto L32
    L28:
        r111 = false;
    L32:
        if (r111 == false) goto L37;
        if (r101 != null) goto L36;
        r101 = r106;
        goto L37
    L36:
        throw new JSONException("multi-JSONCreator");
    L37:
        r105 = r105 + 1;
        goto L15
    L38:
        return r101;
    }

    public static boolean add(List<FieldInfo> r100, FieldInfo r101) {
        int r102 = r100.size() - 1;
    L3:
        if (r102 < 0) goto L22;
        FieldInfo r103 = (FieldInfo) ListProtector.get(r100, r102);
        if (r103.name.equals(r101.name) == false) goto L21;
        if (r103.getOnly == false) goto L12;
        if (r101.getOnly == false) goto L21;
    L12:
        if (r103.fieldClass.isAssignableFrom(r101.fieldClass) == false) goto L16;
        ListProtector.set(r100, r102, r101);
        return true;
    L16:
        if (r103.compareTo2(r101) >= 0) goto L19;
        ListProtector.set(r100, r102, r101);
        return true;
    L19:
        return false;
    L21:
        r102 = r102 - 1;
        goto L3
    L22:
        r100.add(r101);
        return true;
    }

    public static Class<?> getBuilderClass(Class<?> r100, JSONType r101) {
        if (r100 == null) goto L8;
        if (r100.getName().equals("org.springframework.security.web.savedrequest.DefaultSavedRequest") == false) goto L8;
        return TypeUtils.loadClass("org.springframework.security.web.savedrequest.DefaultSavedRequest$Builder");
    L8:
        if (r101 != null) goto L10;
        return null;
    L10:
        Class<?> r102 = r101.builder();
        if (r102 != Void.class) goto L13;
        return null;
    L13:
        return r102;
    }

    public static Constructor<?> getDefaultConstructor(Class<?> r100, Constructor<?>[] r101) {
        Constructor<?> r102 = null;
        if (Modifier.isAbstract(r100.getModifiers()) == false) goto L5;
        return null;
    L5:
        int r103 = r101.length;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L11;
        Constructor<?> r105 = r101[r104];
        if (r105.getParameterTypes().length == 0) goto L9;
        r104 = r104 + 1;
        goto L6
    L9:
        r102 = r105;
    L11:
        if (r102 == null) goto L13;
        return r102;
    L13:
        if (r100.isMemberClass() == true) goto L15;
        return r102;
    L15:
        if (Modifier.isStatic(r100.getModifiers()) == true) goto L32;
        int r106 = r101.length;
        int r107 = 0;
    L17:
        if (r107 >= r106) goto L34;
        Constructor<?> r108 = r101[r107];
        Class<?>[] r109 = r108.getParameterTypes();
        if (r109.length != 1) goto L23;
        if (r109[0].equals(r100.getDeclaringClass()) == false) goto L23;
        return r108;
    L23:
        r107 = r107 + 1;
        goto L17
    L34:
        return r102;
    L32:
        return r102;
    }

    private static FieldInfo getField(List<FieldInfo> r100, String r101) {
        Iterator<FieldInfo> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L15;
        FieldInfo r103 = r102.next();
        if (r103.name.equals(r101) == true) goto L7;
        Field r104 = r103.field;
        if (r104 == null) goto L4;
        if (r103.getAnnotation() == null) goto L4;
        if (r104.getName().equals(r101) == false) goto L4;
        return r103;
    L7:
        return r103;
    L15:
        return null;
    }

    public static JavaBeanInfo build(Class<?> r100, Type r101, PropertyNamingStrategy r102) {
        return build(r100, r101, r102, false, TypeUtils.compatibleWithJavaBean, false);
    }

    private static Method getFactoryMethod(Class<?> r100, Method[] r101, boolean r102) {
        int r103 = r101.length;
        Method r104 = null;
        int r105 = 0;
        int r106 = 0;
    L3:
        if (r106 >= r103) goto L17;
        Method r107 = r101[r106];
        if (Modifier.isStatic(r107.getModifiers()) == false) goto L16;
        if (r100.isAssignableFrom(r107.getReturnType()) == false) goto L16;
        if (((JSONCreator) TypeUtils.getAnnotation(r107, JSONCreator.class)) == null) goto L16;
        if (r104 != null) goto L15;
        r104 = r107;
        goto L16
    L15:
        throw new JSONException("multi-JSONCreator");
    L16:
        r106 = r106 + 1;
        goto L3
    L17:
        if (r104 != null) goto L25;
        if (r102 == false) goto L34;
        int r108 = r101.length;
    L20:
        if (r105 >= r108) goto L36;
        Method r109 = r101[r105];
        if (TypeUtils.isJacksonCreator(r109) == true) goto L35;
        r105 = r105 + 1;
        goto L20
    L35:
        return r109;
    L36:
        return r104;
    L34:
        return r104;
    L25:
        return r104;
    }

    public static JavaBeanInfo build(Class<?> r100, Type r101, PropertyNamingStrategy r102, boolean r103, boolean r110) {
        return build(r100, r101, r102, r103, r110, false);
    }

    private static void computeFields(Class<?> r210, Type r211, PropertyNamingStrategy r212, List<FieldInfo> r213, Field[] r214) {
        Map<TypeVariable, Type> r110 = buildGenericInfo(r210);
        int r111 = r214.length;
        int r112 = 0;
    L3:
        if (r112 >= r111) goto L47;
        Field r100 = r214[r112];
        int r101 = r100.getModifiers();
        if ((r101 & 8) != 0) goto L46;
        boolean r102 = true;
        if ((r101 & 16) == 0) goto L24;
        Class<?> r103 = r100.getType();
        if (Map.class.isAssignableFrom(r103) == false) goto L12;
    L21:
        boolean r104 = true;
    L22:
        if (r104 == true) goto L24;
    L12:
        if (Collection.class.isAssignableFrom(r103) == true) goto L21;
        if (AtomicLong.class.equals(r103) == true) goto L21;
        if (AtomicInteger.class.equals(r103) == true) goto L21;
        if (AtomicBoolean.class.equals(r103) == true) goto L21;
        r104 = false;
    L24:
        Iterator<FieldInfo> r105 = r213.iterator();
    L26:
        if (r105.hasNext() == false) goto L30;
        if (r105.next().name.equals(r100.getName()) == false) goto L26;
    L31:
        if (r102 == true) goto L46;
        String r106 = r100.getName();
        JSONField r113 = (JSONField) TypeUtils.getAnnotation(r100, JSONField.class);
        if (r113 != null) goto L36;
        int r107 = 0;
        int r108 = 0;
        int r114 = 0;
    L43:
        if (r212 == null) goto L45;
        r106 = r212.translate(r106);
    L45:
        add(r213, new FieldInfo(r106, null, r100, r210, r211, r107, r108, r114, null, r113, null, r110));
        goto L46
    L36:
        if (r113.deserialize() == false) goto L46;
        int r109 = r113.ordinal();
        int r115 = SerializerFeature.of(r113.serialzeFeatures());
        int r116 = Feature.of(r113.parseFeatures());
        if (r113.name().length() == 0) goto L41;
        r106 = r113.name();
    L41:
        r107 = r109;
        r108 = r115;
        r114 = r116;
        goto L43
    L30:
        r102 = false;
    L46:
        r112 = r112 + 1;
        r111 = r111;
        goto L3
    }

    public static JavaBeanInfo build(Class<?> r410, Type r411, PropertyNamingStrategy r412, boolean r413, boolean r414, boolean r510) {
        Class<?> r110 = r410;
        boolean r100 = r510;
        JSONType r111 = (JSONType) TypeUtils.getAnnotation(r110, JSONType.class);
        if (r111 == null) goto L9;
        PropertyNamingStrategy r101 = r111.naming();
        if (r101 == null) goto L9;
        if (r101 == PropertyNamingStrategy.CamelCase) goto L9;
        PropertyNamingStrategy r112 = r101;
    L10:
        Class<?> r113 = getBuilderClass(r110, r111);
        Field[] r114 = r410.getDeclaredFields();
        Method[] r102 = r410.getMethods();
        Map<TypeVariable, Type> r115 = buildGenericInfo(r410);
        boolean r116 = TypeUtils.isKotlin(r410);
        Constructor<?>[] r103 = r410.getDeclaredConstructors();
        if (r116 == true) goto L13;
    L16:
        if (r113 != null) goto L18;
        Constructor<?> r104 = getDefaultConstructor(r110, r103);
    L19:
        Constructor<?> r117 = r104;
    L20:
        Method r210 = null;
        Method r211 = null;
        ArrayList r105 = new ArrayList();
        if (r413 == false) goto L30;
        Class<?> r106 = r110;
    L23:
        if (r106 == null) goto L25;
        computeFields(r110, r411, r112, r105, r106.getDeclaredFields());
        r106 = r106.getSuperclass();
        goto L23
    L25:
        if (r117 == null) goto L28;
        TypeUtils.setAccessible(r117);
    L28:
        return new JavaBeanInfo(r410, r113, r117, null, null, null, r111, r105);
    L30:
        if (r410.isInterface() == false) goto L32;
    L35:
        boolean r107 = true;
    L36:
        if (r117 != null) goto L38;
        if (r113 != null) goto L38;
    L39:
        Type r108 = JSON.getMixInAnnotations(r410);
        if ((r108 instanceof Class) == false) goto L46;
        Constructor<?> r109 = getCreatorConstructor(((Class) r108).getConstructors());
        if (r109 == null) goto L46;
        Constructor<?> r118 = r110.getConstructor(r109.getParameterTypes());     // Catch: NoSuchMethodException -> L45
    L47:
        if (r118 != null) goto L49;
        r118 = getCreatorConstructor(r103);
    L49:
        Constructor<?> r212 = r118;
        if (r212 == null) goto L89;
        if (r107 == true) goto L89;
        TypeUtils.setAccessible(r212);
        Class<?>[] r119 = r212.getParameterTypes();
        if (r119.length <= 0) goto L87;
        Annotation[][] r120 = TypeUtils.getParameterAnnotations(r212);
        String[] r121 = null;
        int r122 = 0;
    L56:
        if (r122 >= r119.length) goto L87;
        if (r122 >= r120.length) goto L87;
        Annotation[] r123 = r120[r122];
        int r124 = r123.length;
        int r125 = 0;
    L60:
        if (r125 >= r124) goto L65;
        Annotation r126 = r123[r125];
        Annotation[] r511 = r123;
        if ((r126 instanceof JSONField) == true) goto L63;
        r125 = r125 + 1;
        r123 = r511;
        goto L60
    L63:
        JSONField r127 = (JSONField) r126;
    L66:
        Class<?> r128 = r119[r122];
        Type r129 = r212.getGenericParameterTypes()[r122];
        if (r127 == null) goto L69;
        Field r130 = TypeUtils.getField(r110, r127.name(), r114);
        int r213 = r127.ordinal();
        int r214 = SerializerFeature.of(r127.serialzeFeatures());
        int r215 = Feature.of(r127.parseFeatures());
        String r131 = r127.name();
    L70:
        if (r131 != null) goto L72;
    L73:
        if (r121 != null) goto L75;
        r121 = ASMUtils.lookupParameterNames(r212);
    L75:
        r131 = r121[r122];
    L76:
        if (r130 != null) goto L85;
        if (r121 != null) goto L82;
        if (r116 == false) goto L80;
        r121 = TypeUtils.getKoltinConstructorParameters(r410);
        goto L82
    L80:
        r121 = ASMUtils.lookupParameterNames(r212);
    L82:
        if (r121.length <= r122) goto L85;
        String[] r216 = r121;
        Field r217 = TypeUtils.getField(r110, r121[r122], r114);
    L86:
        ArrayList r132 = r105;
        PropertyNamingStrategy r218 = r112;
        add(r132, new FieldInfo(r131, r410, r128, r129, r217, r213, r214, r215));
        r122 = r122 + 1;
        r119 = r119;
        r102 = r102;
        r105 = r132;
        r112 = r218;
        r121 = r216;
        r120 = r120;
    L85:
        r217 = r130;
        r216 = r121;
        goto L86
    L72:
        if (r131.length() != 0) goto L76;
    L69:
        r130 = null;
        r131 = null;
        r213 = 0;
        r214 = 0;
        r215 = 0;
        goto L70
    L65:
        r127 = null;
    L87:
        ArrayList r133 = r105;
        PropertyNamingStrategy r219 = r112;
        Method[] r134 = r102;
    L222:
        if (r117 == null) goto L224;
        TypeUtils.setAccessible(r117);
    L224:
        String r135 = "set";
        if (r113 == null) goto L298;
        JSONPOJOBuilder r136 = (JSONPOJOBuilder) TypeUtils.getAnnotation(r113, JSONPOJOBuilder.class);
        if (r136 == null) goto L229;
        String r137 = r136.withPrefix();
    L230:
        if (r137 != null) goto L232;
        r137 = "with";
    L232:
        String r138 = r137;
        Method[] r139 = r113.getMethods();
        int r140 = r139.length;
        int r141 = 0;
    L233:
        if (r141 >= r140) goto L278;
        Method r142 = r139[r141];
        if (Modifier.isStatic(r142.getModifiers()) == false) goto L238;
    L236:
        r141 = r141;
        r140 = r140;
        r139 = r139;
        String r220 = r138;
        String r310 = r135;
        r114 = r114;
        r113 = r113;
        r111 = r111;
        r219 = r219;
        r134 = r134;
    L277:
        r141 = r141 + 1;
        r110 = r410;
        r134 = r134;
        r138 = r220;
        r111 = r111;
        r140 = r140;
        r139 = r139;
        r114 = r114;
        r113 = r113;
        r219 = r219;
        r135 = r310;
        goto L233
    L238:
        if (r142.getReturnType().equals(r113) == false) goto L236;
        JSONField r143 = (JSONField) TypeUtils.getAnnotation(r142, JSONField.class);
        if (r143 != null) goto L243;
        r143 = TypeUtils.getSuperMethodAnnotation(r110, r142);
    L243:
        JSONField r221 = r143;
        if (r221 != null) goto L246;
        int r144 = 0;
        int r145 = 0;
        int r146 = 0;
    L253:
        String r147 = r142.getName();
        String r148 = r135;
        if (r147.startsWith(r148) == false) goto L260;
        if (r147.length() <= 3) goto L260;
        StringBuilder r149 = new StringBuilder(r147.substring(3));
    L262:
        String r150 = r138;
    L271:
        char r151 = r149.charAt(0);
        if (r150.length() != 0) goto L274;
    L276:
        r149.setCharAt(0, Character.toLowerCase(r151));
        r220 = r150;
        r310 = r148;
        add(r133, new FieldInfo(r149.toString(), r142, null, r410, r411, r144, r145, r146, r221, null, null, r115));
        goto L277
    L274:
        if (Character.isUpperCase(r151) == true) goto L276;
    L266:
        r220 = r150;
        r310 = r148;
    L260:
        if (r138.length() != 0) goto L264;
        r149 = new StringBuilder(r147);
        goto L262
    L264:
        r150 = r138;
        if (r147.startsWith(r150) == false) goto L266;
        if (r147.length() <= r150.length()) goto L266;
        r149 = new StringBuilder(r147.substring(r150.length()));
        goto L271
    L246:
        if (r221.deserialize() == false) goto L236;
        int r222 = r221.ordinal();
        int r223 = SerializerFeature.of(r221.serialzeFeatures());
        int r224 = Feature.of(r221.parseFeatures());
        if (r221.name().length() == 0) goto L251;
        r141 = r141;
        r140 = r140;
        r139 = r139;
        r114 = r114;
        r113 = r113;
        r111 = r111;
        r219 = r219;
        r134 = r134;
        add(r133, new FieldInfo(r221.name(), r142, null, r410, r411, r222, r223, r224, r221, null, null, r115));
        r220 = r138;
        r310 = r135;
        goto L277
    L251:
        r144 = r222;
        r145 = r223;
        r146 = r224;
        goto L253
    L278:
        String r311 = r135;
        Field[] r312 = r114;
        JSONType r225 = r111;
        PropertyNamingStrategy r313 = r219;
        Method[] r152 = r134;
        Class<?> r153 = r113;
        JSONPOJOBuilder r154 = (JSONPOJOBuilder) TypeUtils.getAnnotation(r153, JSONPOJOBuilder.class);
        if (r154 == null) goto L281;
        String r155 = r154.buildMethod();
    L282:
        if (r155 != null) goto L284;
    L285:
        r155 = "build";
    L286:
        char r156 = 0;
        r210 = r153.getMethod(r155, new Class[0]);     // Catch: Throwable -> L289
    L290:
        if (r210 == null) goto L505;
    L294:
        if (r210 == null) goto L297;
        TypeUtils.setAccessible(r210);
    L299:
        int r157 = r152.length;
        int r158 = 0;
    L300:
        String r159 = MonitorConstants.CONNECT_TYPE_GET;
        int r160 = 4;
        if (r158 >= r157) goto L433;
        Method r161 = r152[r158];
        int r162 = 0;
        int r163 = 0;
        int r226 = 0;
        String r164 = r161.getName();
        if (Modifier.isStatic(r161.getModifiers()) == false) goto L306;
    L304:
        int r314 = r158;
        int r227 = r157;
        r153 = r153;
        r152 = r152;
        Field[] r165 = r312;
        r313 = r313;
        String r166 = r311;
    L432:
        r158 = r314 + 1;
        r313 = r313;
        r157 = r227;
        r152 = r152;
        r311 = r166;
        r153 = r153;
        r312 = r165;
        r156 = 0;
        goto L300
    L306:
        Class<?> r167 = r161.getReturnType();
        if (r167.equals(Void.TYPE) == true) goto L312;
        if (r167.equals(r161.getDeclaringClass()) == false) goto L304;
    L312:
        if (r161.getDeclaringClass() == Object.class) goto L304;
        Class<?>[] r168 = r161.getParameterTypes();
        if (r168.length == 0) goto L304;
        if (r168.length > 2) goto L304;
        JSONField r228 = (JSONField) TypeUtils.getAnnotation(r161, JSONField.class);
        if (r228 != null) goto L322;
    L328:
        r314 = r158;
        r227 = r157;
        if (r168.length == 1) goto L333;
    L330:
        r153 = r153;
        r152 = r152;
        r165 = r312;
        r166 = r311;
        goto L432
    L333:
        if (r228 != null) goto L335;
        r228 = TypeUtils.getSuperMethodAnnotation(r410, r161);
    L335:
        if (r228 == null) goto L337;
    L339:
        if (r228 != null) goto L341;
    L347:
        r166 = r311;
        if (r228 == null) goto L350;
    L354:
        if (r153 != null) goto L352;
        char r169 = r164.charAt(3);
        if (r116 == false) goto L365;
        ArrayList r170 = new ArrayList();
        int r171 = 0;
    L360:
        if (r171 >= r152.length) goto L367;
        if (r152[r171].getName().startsWith(MonitorConstants.CONNECT_TYPE_GET) == false) goto L364;
        r170.add(r152[r171].getName());
    L364:
        r171 = r171 + 1;
    L367:
        if (Character.isUpperCase(r169) == false) goto L369;
    L399:
        Class<?> r172 = r410;
        r165 = r312;
        if (r116 == false) goto L404;
        String r173 = TypeUtils.getPropertyNameByMethodName(ce.f26391f + r164.substring(1));
    L402:
        Field r174 = null;
    L407:
        if (r174 != null) goto L409;
        r174 = TypeUtils.getField(r172, r173, r165);
    L409:
        if (r174 != null) goto L415;
        if (r168[0] != Boolean.TYPE) goto L415;
        r174 = TypeUtils.getField(r172, "is" + Character.toUpperCase(r173.charAt(0)) + r173.substring(1), r165);
    L415:
        if (r174 == null) goto L427;
        JSONField r229 = (JSONField) TypeUtils.getAnnotation(r174, JSONField.class);
        if (r229 != null) goto L419;
        int r175 = r226;
    L426:
        JSONField r176 = r229;
    L428:
        PropertyNamingStrategy r177 = r313;
        if (r177 == null) goto L431;
        r173 = r177.translate(r173);
    L431:
        r153 = r153;
        r313 = r177;
        add(r133, new FieldInfo(r173, r161, r174, r410, r411, r162, r163, r175, r228, r176, null, r115));
        goto L432
    L419:
        if (r229.deserialize() == true) goto L421;
        r165 = r165;
        goto L432
    L421:
        r162 = r229.ordinal();
        r163 = SerializerFeature.of(r229.serialzeFeatures());
        int r178 = Feature.of(r229.parseFeatures());
        if (r229.name().length() == 0) goto L424;
        r165 = r165;
        r152 = r152;
        r166 = r166;
        add(r133, new FieldInfo(r229.name(), r161, r174, r410, r411, r162, r163, r178, r228, r229, null, r115));
        r153 = r153;
        r313 = r313;
        goto L432
    L424:
        r175 = r178;
        goto L426
    L427:
        r165 = r165;
        r166 = r166;
        r152 = r152;
        r176 = null;
        r175 = r226;
        goto L428
    L404:
        if (TypeUtils.compatibleWithJavaBean == false) goto L406;
        r173 = TypeUtils.decapitalize(r164.substring(3));
        goto L402
    L406:
        r173 = TypeUtils.getPropertyNameByMethodName(r164);
        goto L402
    L369:
        if (r169 > 512) goto L399;
        if (r169 != '_') goto L386;
        if (r116 == true) goto L375;
        r172 = r410;
        Field[] r179 = r312;
        String r180 = r164.substring(4);
        Field r181 = TypeUtils.getField(r172, r180, r179);
        if (r181 != null) goto L383;
        r173 = r164.substring(3);
        r181 = TypeUtils.getField(r172, r173, r179);
        if (r181 == null) goto L383;
    L384:
        r174 = r181;
    L385:
        r165 = r179;
    L383:
        r173 = r180;
        goto L384
    L375:
        if (r170.contains(ce.f26391f + r164.substring(1)) == false) goto L377;
        r173 = r164.substring(3);
    L378:
        r172 = r410;
        r179 = r312;
        r174 = TypeUtils.getField(r172, r173, r179);
        goto L385
    L377:
        r173 = "is" + r164.substring(3);
        goto L378
    L386:
        r172 = r410;
        r179 = r312;
        if (r169 != 'f') goto L391;
        r173 = r164.substring(3);
    L389:
        r165 = r179;
        goto L402
    L391:
        if (r164.length() >= 5) goto L393;
    L395:
        r173 = r164.substring(3);
        r174 = TypeUtils.getField(r172, r173, r179);
        if (r174 != null) goto L385;
        r165 = r179;
        goto L432
    L393:
        if (Character.isUpperCase(r164.charAt(4)) == false) goto L395;
        r173 = TypeUtils.decapitalize(r164.substring(3));
        goto L389
    L365:
        r170 = null;
    L352:
        r165 = r312;
        goto L432
    L350:
        if (r164.startsWith(r166) == false) goto L352;
    L341:
        if (r228.deserialize() == false) goto L330;
        r162 = r228.ordinal();
        r163 = SerializerFeature.of(r228.serialzeFeatures());
        int r182 = Feature.of(r228.parseFeatures());
        if (r228.name().length() == 0) goto L346;
        add(r133, new FieldInfo(r228.name(), r161, null, r410, r411, r162, r163, r182, r228, null, null, r115));
        goto L330
    L346:
        r226 = r182;
        goto L347
    L337:
        if (r164.length() >= 4) goto L339;
    L322:
        if (r168.length != 2) goto L328;
        if (r168[r156] != String.class) goto L328;
        if (r168[1] != Object.class) goto L328;
        r314 = r158;
        r227 = r157;
        add(r133, new FieldInfo("", r161, null, r410, r411, 0, 0, 0, r228, null, null, r115));
        goto L330
    L433:
        Class<?> r315 = r153;
        Field[] r415 = r312;
        PropertyNamingStrategy r183 = r313;
        boolean r230 = true;
        computeFields(r410, r411, r183, r133, r410.getFields());
        Method[] r184 = r410.getMethods();
        int r185 = r184.length;
        int r186 = 0;
    L434:
        if (r186 >= r185) goto L489;
        Method r187 = r184[r186];
        String r188 = r187.getName();
        if (r188.length() >= r160) goto L440;
    L437:
        Field[] r416 = r415;
    L488:
        r186 = r186 + 1;
        r185 = r185;
        r159 = r159;
        r184 = r184;
        r415 = r416;
        r160 = 4;
        goto L434
    L440:
        if (Modifier.isStatic(r187.getModifiers()) == true) goto L437;
        if (r315 != null) goto L437;
        if (r188.startsWith(r159) == false) goto L437;
        if (Character.isUpperCase(r188.charAt(3)) == false) goto L437;
        if (r187.getParameterTypes().length != 0) goto L437;
        if (Collection.class.isAssignableFrom(r187.getReturnType()) == false) goto L453;
    L460:
        JSONField r189 = (JSONField) TypeUtils.getAnnotation(r187, JSONField.class);
        if (r189 != null) goto L463;
    L465:
        if (r189 != null) goto L467;
    L469:
        String r190 = TypeUtils.getPropertyNameByMethodName(r188);
        Field[] r191 = r415;
        Field r192 = TypeUtils.getField(r410, r190, r191);
        if (r192 == null) goto L481;
        JSONField r193 = (JSONField) TypeUtils.getAnnotation(r192, JSONField.class);
        if (r193 == null) goto L477;
        if (r193.deserialize() == true) goto L477;
    L486:
        r416 = r191;
    L477:
        if (Collection.class.isAssignableFrom(r187.getReturnType()) == false) goto L479;
    L480:
        Field r194 = r192;
    L482:
        if (r183 == null) goto L484;
        r190 = r183.translate(r190);
    L484:
        String r195 = r190;
        if (getField(r133, r195) != null) goto L486;
        r416 = r191;
        r186 = r186;
        r159 = r159;
        r185 = r185;
        r184 = r184;
        add(r133, new FieldInfo(r195, r187, r194, r410, r411, 0, 0, 0, r189, null, null, r115));
        goto L488
    L479:
        if (Map.class.isAssignableFrom(r187.getReturnType()) == true) goto L480;
    L481:
        r194 = null;
        goto L482
    L467:
        if (r189.name().length() <= 0) goto L469;
        r190 = r189.name();
        r194 = null;
        r191 = r415;
        goto L482
    L463:
        if (r189.deserialize() == false) goto L465;
    L453:
        if (Map.class.isAssignableFrom(r187.getReturnType()) == true) goto L460;
        if (AtomicBoolean.class == r187.getReturnType()) goto L460;
        if (AtomicInteger.class == r187.getReturnType()) goto L460;
        if (AtomicLong.class != r187.getReturnType()) goto L437;
    L489:
        Field[] r417 = r415;
        if (r133.size() != 0) goto L500;
        if (TypeUtils.isXmlField(r410) == true) goto L495;
        r230 = r413;
    L495:
        if (r230 == false) goto L500;
        Class<?> r196 = r410;
    L497:
        if (r196 == null) goto L500;
        computeFields(r410, r411, r183, r133, r417);
        r196 = r196.getSuperclass();
    L500:
        return new JavaBeanInfo(r410, r315, r117, r212, r211, r210, r225, r133);
    L297:
        throw new JSONException("buildMethod not found.");
    L505:
        r210 = r153.getMethod("create", new Class[0]);     // Catch: Throwable -> L293
        goto L294
    L284:
        if (r155.length() != 0) goto L286;
    L281:
        r155 = null;
        goto L282
    L229:
        r137 = null;
        goto L230
    L298:
        r311 = "set";
        r312 = r114;
        r153 = r113;
        r225 = r111;
        r313 = r219;
        r152 = r134;
        r156 = 0;
    L89:
        r133 = r105;
        r219 = r112;
        r134 = r102;
        r211 = getFactoryMethod(r110, r134, r100);
        if (r211 == null) goto L124;
        TypeUtils.setAccessible(r211);
        Class<?>[] r197 = r211.getParameterTypes();
        if (r197.length <= 0) goto L222;
        Annotation[][] r198 = TypeUtils.getParameterAnnotations(r211);
        String[] r199 = null;
        int r200 = 0;
    L95:
        if (r200 >= r197.length) goto L123;
        Annotation[] r201 = r198[r200];
        int r202 = r201.length;
        int r203 = 0;
    L97:
        if (r203 >= r202) goto L102;
        Annotation r204 = r201[r203];
        if ((r204 instanceof JSONField) == true) goto L100;
        r203 = r203 + 1;
        goto L97
    L100:
        JSONField r205 = (JSONField) r204;
    L103:
        if (r205 != null) goto L110;
        if (r100 == false) goto L109;
        if (TypeUtils.isJacksonCreator(r211) == true) goto L110;
    L109:
        throw new JSONException("illegal json creator");
    L110:
        if (r205 == null) goto L112;
        String r206 = r205.name();
        int r207 = r205.ordinal();
        int r208 = SerializerFeature.of(r205.serialzeFeatures());
        int r209 = r207;
        int r1100 = Feature.of(r205.parseFeatures());
        int r1101 = r208;
    L113:
        if (r206 != null) goto L115;
    L118:
        if (r199 != null) goto L120;
        r199 = ASMUtils.lookupParameterNames(r211);
    L120:
        r206 = r199[r200];
    L117:
        String[] r1102 = r199;
        int r231 = r200;
        int r232 = r1101;
        add(r133, new FieldInfo(r206, r410, r197[r200], r211.getGenericParameterTypes()[r200], TypeUtils.getField(r110, r206, r114), r209, r232, r1100));
        r200 = r231 + 1;
        r100 = r510;
        r197 = r197;
        r199 = r1102;
        goto L95
    L115:
        if (r206.length() != 0) goto L117;
    L112:
        r206 = null;
        r209 = 0;
        r1101 = 0;
        r1100 = 0;
        goto L113
    L102:
        r205 = null;
        goto L103
    L123:
        return new JavaBeanInfo(r410, r113, null, null, r211, null, r111, r133);
    L124:
        if (r107 == true) goto L222;
        String r233 = r410.getName();
        if (r116 == true) goto L128;
    L131:
        int r234 = r103.length;
        String[] r235 = null;
        int r236 = 0;
    L132:
        if (r236 >= r234) goto L180;
        Constructor<?> r237 = r103[r236];
        Class<?>[] r238 = r237.getParameterTypes();
        if (r233.equals("org.springframework.security.web.authentication.WebAuthenticationDetails") == false) goto L145;
        if (r238.length != 2) goto L179;
        if (r238[0] != String.class) goto L179;
        if (r238[1] != String.class) goto L179;
        r237.setAccessible(true);
        String[] r239 = ASMUtils.lookupParameterNames(r237);
    L142:
        String[] r240 = r239;
        r212 = r237;
    L181:
        if (r240 == null) goto L183;
        Class<?>[] r241 = r212.getParameterTypes();
    L184:
        if (r240 == null) goto L220;
        if (r241.length != r240.length) goto L220;
        Annotation[][] r242 = TypeUtils.getParameterAnnotations(r212);
        int r243 = 0;
    L189:
        if (r243 >= r241.length) goto L214;
        Annotation[] r244 = r242[r243];
        String r245 = r240[r243];
        int r246 = r244.length;
        int r247 = 0;
    L191:
        if (r247 >= r246) goto L196;
        Annotation r248 = r244[r247];
        if ((r248 instanceof JSONField) == true) goto L194;
        r247 = r247 + 1;
        goto L191
    L194:
        JSONField r249 = (JSONField) r248;
    L197:
        Class<?> r250 = r241[r243];
        Type r251 = r212.getGenericParameterTypes()[r243];
        Field r252 = TypeUtils.getField(r110, r245, r114);
        if (r252 == null) goto L201;
        if (r249 != null) goto L201;
        r249 = (JSONField) TypeUtils.getAnnotation(r252, JSONField.class);
    L201:
        if (r249 == null) goto L203;
        String r253 = r249.name();
        if (r253.length() == 0) goto L211;
        r245 = r253;
    L211:
        int r254 = r249.ordinal();
        int r255 = SerializerFeature.of(r249.serialzeFeatures());
        int r256 = Feature.of(r249.parseFeatures());
        int r257 = r255;
        int r258 = r254;
    L212:
        Class<?>[] r316 = r241;
        int r259 = r258;
        add(r133, new FieldInfo(r245, r410, r250, r251, r252, r259, r257, r256));
        r243 = r243 + 1;
        r233 = r233;
        r240 = r240;
        r241 = r316;
        goto L189
    L203:
        if ("org.springframework.security.core.userdetails.User".equals(r233) == true) goto L205;
    L207:
        r258 = 0;
        r257 = 0;
        r256 = 0;
        goto L212
    L205:
        if ("password".equals(r245) == false) goto L207;
        r256 = Feature.InitStringFieldAsEmpty.mask;
        r258 = 0;
        r257 = 0;
        goto L212
    L196:
        r249 = null;
        goto L197
    L214:
        if (r116 == true) goto L222;
        if (r410.getName().equals("javax.servlet.http.Cookie") == true) goto L222;
        return new JavaBeanInfo(r410, r113, null, r212, null, null, r111, r133);
    L220:
        throw new JSONException("default constructor not found. " + r110);
    L183:
        r241 = null;
    L179:
        r236 = r236 + 1;
        goto L132
    L145:
        if (r233.equals("org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken") == false) goto L156;
        if (r238.length != 3) goto L179;
        if (r238[0] != Object.class) goto L179;
        if (r238[1] != Object.class) goto L179;
        if (r238[2] != Collection.class) goto L179;
        r237.setAccessible(true);
        r239 = new String[]{"principal", "credentials", "authorities"};
        goto L142
    L156:
        if (r233.equals("org.springframework.security.core.authority.SimpleGrantedAuthority") == false) goto L163;
        if (r238.length != 1) goto L179;
        if (r238[0] != String.class) goto L179;
        r240 = new String[]{"authority"};
        r212 = r237;
        goto L181
    L163:
        if ((r237.getModifiers() & 1) == 0) goto L165;
        boolean r260 = true;
    L166:
        if (r260 == false) goto L179;
        String[] r261 = ASMUtils.lookupParameterNames(r237);
        if (r261 == null) goto L179;
        if (r261.length == 0) goto L179;
        if (r212 == null) goto L178;
        if (r235 == null) goto L178;
        if (r261.length <= r235.length) goto L179;
    L178:
        r212 = r237;
        r235 = r261;
        goto L179
    L165:
        r260 = false;
        goto L166
    L180:
        r240 = r235;
        goto L181
    L128:
        if (r103.length <= 0) goto L131;
        String[] r262 = TypeUtils.getKoltinConstructorParameters(r410);
        Constructor<?> r263 = TypeUtils.getKotlinConstructor(r103, r262);
        TypeUtils.setAccessible(r263);
        r212 = r263;
        r240 = r262;
    L46:
        r118 = null;
    L38:
        if (r107 == true) goto L39;
        r133 = r105;
        r219 = r112;
        r134 = r102;
        r212 = null;
        goto L222
    L32:
        if (Modifier.isAbstract(r410.getModifiers()) == true) goto L35;
        r107 = false;
        goto L36
    L18:
        r104 = getDefaultConstructor(r113, r113.getDeclaredConstructors());
        goto L19
    L13:
        if (r103.length == 1) goto L16;
        r117 = null;
    L9:
        r112 = r412;
        goto L10
    }

    public JavaBeanInfo(Class<?> r100, Class<?> r101, Constructor<?> r110, Constructor<?> r111, Method r112, Method r113, JSONType r114, List<FieldInfo> r115) {
        this.clazz = r100;
        this.builderClass = r101;
        this.defaultConstructor = r110;
        this.creatorConstructor = r111;
        this.factoryMethod = r112;
        this.parserFeatures = TypeUtils.getParserFeatures(r100);
        this.buildMethod = r113;
        this.jsonType = r114;
        if (r114 == null) goto L16;
        String r116 = r114.typeName();
        String r102 = r114.typeKey();
        if (r102.length() > 0) goto L8;
        r102 = null;
    L8:
        this.typeKey = r102;
        if (r116.length() == 0) goto L11;
        this.typeName = r116;
    L12:
        String[] r117 = r114.orders();
        if (r117.length != 0) goto L15;
        r117 = null;
    L15:
        this.orders = r117;
    L17:
        FieldInfo[] r118 = new FieldInfo[r115.size()];
        this.fields = r118;
        r115.toArray(r118);
        FieldInfo[] r119 = new FieldInfo[r118.length];
        boolean r103 = false;
        if (this.orders == null) goto L32;
        LinkedHashMap r104 = new LinkedHashMap(r115.size());
        int r120 = r118.length;
        int r105 = 0;
    L20:
        if (r105 >= r120) goto L22;
        FieldInfo r106 = r118[r105];
        r104.put(r106.name, r106);
        r105 = r105 + 1;
        goto L20
    L22:
        String[] r121 = this.orders;
        int r122 = r121.length;
        int r107 = 0;
        int r108 = 0;
    L23:
        if (r107 >= r122) goto L28;
        String r109 = r121[r107];
        FieldInfo r123 = (FieldInfo) r104.get(r109);
        if (r123 == null) goto L27;
        r119[r108] = r123;
        r104.remove(r109);
        r108 = r108 + 1;
    L27:
        r107 = r107 + 1;
        goto L23
    L28:
        Iterator r124 = r104.values().iterator();
    L30:
        if (r124.hasNext() == false) goto L34;
        r119[r108] = (FieldInfo) r124.next();
        r108 = r108 + 1;
    L34:
        if (Arrays.equals(this.fields, r119) == false) goto L36;
        r119 = this.fields;
    L36:
        this.sortedFields = r119;
        if (r110 == null) goto L39;
        this.defaultConstructorParameterSize = r110.getParameterTypes().length;
    L42:
        if (r111 == null) goto L95;
        this.creatorConstructorParameterTypes = r111.getParameterTypes();
        boolean r125 = TypeUtils.isKotlin(r100);
        this.f24938kotlin = r125;
        if (r125 == false) goto L65;
        this.creatorConstructorParameters = TypeUtils.getKoltinConstructorParameters(r100);
        this.kotlinDefaultConstructor = r100.getConstructor(new Class[0]);     // Catch: Throwable -> L78
    L47:
        Annotation[][] r126 = TypeUtils.getParameterAnnotations(r111);
        int r127 = 0;
    L49:
        if (r127 >= this.creatorConstructorParameters.length) goto L97;
        if (r127 >= r126.length) goto L98;
        Annotation[] r128 = r126[r127];
        int r129 = r128.length;
        int r130 = 0;
    L53:
        if (r130 >= r129) goto L58;
        Annotation r131 = r128[r130];
        if ((r131 instanceof JSONField) == true) goto L56;
        r130 = r130 + 1;
        goto L53
    L56:
        JSONField r132 = (JSONField) r131;
    L59:
        if (r132 == null) goto L63;
        String r133 = r132.name();
        if (r133.length() <= 0) goto L63;
        this.creatorConstructorParameters[r127] = r133;
    L63:
        r127 = r127 + 1;
        goto L49
    L58:
        r132 = null;
        goto L59
    L98:
        return;
    L97:
        return;
    L65:
        if (this.creatorConstructorParameterTypes.length != this.fields.length) goto L75;
        int r134 = 0;
    L68:
        Type[] r135 = this.creatorConstructorParameterTypes;
        if (r134 >= r135.length) goto L74;
        if (r135[r134] != this.fields[r134].fieldClass) goto L75;
        r134 = r134 + 1;
        goto L68
    L74:
        r103 = true;
    L75:
        if (r103 == true) goto L96;
        this.creatorConstructorParameters = ASMUtils.lookupParameterNames(r111);
        return;
    L96:
        return;
    L95:
        return;
    L39:
        if (r112 == null) goto L41;
        this.defaultConstructorParameterSize = r112.getParameterTypes().length;
        goto L42
    L41:
        this.defaultConstructorParameterSize = 0;
        goto L42
    L32:
        System.arraycopy(r118, 0, r119, 0, r118.length);
        Arrays.sort(r119);
        goto L34
    L11:
        this.typeName = r100.getName();
        goto L12
    L16:
        this.typeName = r100.getName();
        this.typeKey = null;
        this.orders = null;
        goto L17
    }
}
