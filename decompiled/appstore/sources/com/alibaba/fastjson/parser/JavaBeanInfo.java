package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class JavaBeanInfo {
    final Constructor<?> creatorConstructor;
    final Constructor<?> defaultConstructor;
    final int defaultConstructorParameterSize;
    final Method factoryMethod;
    final FieldInfo[] fields;
    final JSONType jsonType;
    boolean ordered;
    public final int parserFeatures;
    final FieldInfo[] sortedFields;
    final boolean supportBeanToArray;
    public final String typeName;

    public JavaBeanInfo(Class<?> r10, Constructor<?> r11, Constructor<?> r12, Method r13, FieldInfo[] r14, FieldInfo[] r15, JSONType r16) {
        int r17 = 0;
        this.ordered = false;
        this.defaultConstructor = r11;
        this.creatorConstructor = r12;
        this.factoryMethod = r13;
        this.fields = r14;
        this.jsonType = r16;
        if (r16 == null) goto L11;
        String r18 = r16.typeName();
        if (r18.length() == 0) goto L7;
        this.typeName = r18;
    L8:
        Feature[] r19 = r16.parseFeatures();
        int r20 = r19.length;
        int r21 = 0;
        int r22 = 0;
    L9:
        if (r21 >= r20) goto L12;
        r22 = r22 | r19[r21].mask;
        r21 = r21 + 1;
    L12:
        this.parserFeatures = r22;
        if (r16 == null) goto L20;
        Feature[] r23 = r16.parseFeatures();
        int r24 = r23.length;
        int r25 = 0;
        boolean r110 = false;
    L15:
        if (r25 >= r24) goto L21;
        if (r23[r25] != Feature.SupportArrayToBean) goto L19;
        r110 = true;
    L19:
        r25 = r25 + 1;
    L21:
        this.supportBeanToArray = r110;
        FieldInfo[] r26 = computeSortedFields(r14, r15);
        if (Arrays.equals(r14, r26) == true) goto L25;
        r14 = r26;
    L25:
        this.sortedFields = r14;
        if (r11 == null) goto L28;
        r17 = r11.getParameterTypes().length;
    L28:
        this.defaultConstructorParameterSize = r17;
        return;
    L20:
        r110 = false;
        goto L21
    L7:
        this.typeName = r10.getName();
        goto L8
    L11:
        this.typeName = r10.getName();
        r22 = 0;
        goto L12
    }

    public static boolean addField(List<FieldInfo> r10, FieldInfo r11, boolean r12) {
        if (r12 == true) goto L14;
        int r13 = r10.size();
        int r14 = 0;
    L4:
        if (r14 >= r13) goto L14;
        FieldInfo r15 = r10.get(r14);
        if (r15.name.equals(r11.name) == false) goto L13;
        if (r15.getOnly == false) goto L12;
        if (r11.getOnly == false) goto L13;
    L12:
        return false;
    L13:
        r14 = r14 + 1;
    L14:
        r10.add(r11);
        return true;
    }

    public static JavaBeanInfo build(Class<?> r38, int r39, Type r40, boolean r41, boolean r42, boolean r43, boolean r44, PropertyNamingStrategy r45) {
        Class<?> r11 = r38;
        ArrayList r15 = new ArrayList();
        int r10 = r39 & 1024;
        boolean r12 = true;
        int r13 = 0;
        if (r10 == 0) goto L296;
        Constructor<?> r14 = null;
    L22:
        if (r41 == false) goto L24;
        Method[] r16 = null;
    L25:
        Field[] r17 = r38.getDeclaredFields();
        Class<JSONType> r18 = JSONType.class;
        if (r14 == null) goto L28;
    L109:
        Class<JSONType> r19 = r18;
        Field[] r24 = r17;
        if (r14 == null) goto L112;
        TypeUtils.setAccessible(r11, r14, r39);
    L112:
        Class<? super Object> r20 = Object.class;
        Class<JSONField> r21 = JSONField.class;
        int r22 = 4;
        if (r41 == true) goto L198;
        int r23 = r16.length;
        int r25 = 0;
    L115:
        if (r25 >= r23) goto L198;
        Method r110 = r16[r25];
        String r26 = r110.getName();
        if (r26.length() >= r22) goto L119;
    L120:
        boolean r111 = true;
    L121:
        Class<JSONField> r112 = r21;
    L197:
        r25 = r25 + 1;
        r21 = r112;
        r16 = r16;
        r14 = r14;
        r23 = r23;
        r19 = r19;
        r20 = r20;
        r24 = r24;
        r22 = 4;
        r11 = r11;
        r12 = r111;
        goto L115
    L119:
        if (Modifier.isStatic(r110.getModifiers()) == true) goto L120;
        Class<?> r27 = r110.getReturnType();
        if (r27 == Void.TYPE) goto L127;
        if (r27 != r110.getDeclaringClass()) goto L120;
    L127:
        if (r110.getParameterTypes().length == 1) goto L129;
    L130:
        r111 = true;
        goto L121
    L129:
        if (r110.getDeclaringClass() == r20) goto L130;
        if (r43 == false) goto L133;
        JSONField r28 = (JSONField) r110.getAnnotation(r21);
    L134:
        if (r28 != null) goto L137;
        if (r43 == false) goto L137;
        r28 = TypeUtils.getSupperMethodAnnotation(r11, r110);
    L137:
        JSONField r113 = r28;
        if (r113 != null) goto L140;
        JSONField r114 = null;
        int r29 = 0;
        int r210 = 0;
    L149:
        if (r26.startsWith("set") == false) goto L145;
        char r30 = r26.charAt(3);
        if (Character.isUpperCase(r30) == false) goto L159;
        if (TypeUtils.compatibleWithJavaBean == false) goto L156;
        String r31 = TypeUtils.decapitalize(r26.substring(3));
    L169:
        Field r32 = TypeUtils.getField(r11, r31, r24);
        if (r32 == null) goto L172;
        boolean r33 = true;
    L174:
        Field r34 = r32;
        if (r34 == null) goto L192;
        Class<JSONField> r35 = r21;
        if (r43 == false) goto L181;
        JSONField r115 = (JSONField) r34.getAnnotation(r35);
    L182:
        if (r115 == null) goto L191;
        int r36 = r115.ordinal();
        int r116 = SerializerFeature.of(r115.serialzeFeatures());
        if (r115.name().length() == 0) goto L186;
        r24 = r24;
        addField(r15, new FieldInfo(r115.name(), r110, r34, r38, r40, r36, r116, r113, r115, r44), r41);
        r11 = r38;
        r112 = r35;
        r111 = r33;
        goto L197
    L186:
        r112 = r35;
        boolean r211 = r33;
        r24 = r24;
        int r37 = r36;
        if (r113 != null) goto L190;
        JSONField r46 = r115;
    L189:
        int r47 = r116;
        r111 = r211;
    L194:
        if (r45 == 0) goto L196;
        r31 = r45.translate(r31);
    L196:
        addField(r15, new FieldInfo(r31, r110, null, r38, r40, r37, r47, r46, null, r44), r41);
        r11 = r38;
        TypeUtils.setAccessible(r11, r110, r39);
        goto L197
    L190:
        r46 = r113;
        goto L189
    L191:
        r112 = r35;
    L193:
        r37 = r29;
        r46 = r113;
        r111 = r33;
        r47 = r210;
        goto L194
    L181:
        r115 = r114;
        goto L182
    L192:
        r112 = r21;
        goto L193
    L172:
        if (r110.getParameterTypes()[0] != Boolean.TYPE) goto L175;
        StringBuilder r48 = new StringBuilder();
        r48.append("is");
        r48.append(Character.toUpperCase(r31.charAt(0)));
        r33 = true;
        r48.append(r31.substring(1));
        r32 = TypeUtils.getField(r11, r48.toString(), r24);
        goto L174
    L175:
        r33 = true;
        goto L174
    L156:
        r31 = Character.toLowerCase(r26.charAt(3)) + r26.substring(4);
        goto L169
    L159:
        if (r30 != '_') goto L162;
        r31 = r26.substring(4);
        goto L169
    L162:
        if (r30 != 'f') goto L165;
        r31 = r26.substring(3);
        goto L169
    L165:
        if (r26.length() < 5) goto L145;
        if (Character.isUpperCase(r26.charAt(4)) == false) goto L145;
        r31 = TypeUtils.decapitalize(r26.substring(3));
    L145:
        r11 = r11;
        r24 = r24;
        r112 = r21;
        r111 = true;
        goto L197
    L140:
        if (r113.deserialize() == false) goto L130;
        int r212 = r113.ordinal();
        r210 = SerializerFeature.of(r113.serialzeFeatures());
        if (r113.name().length() == 0) goto L146;
        r25 = r25;
        r23 = r23;
        r21 = r21;
        r16 = r16;
        r14 = r14;
        r19 = r19;
        r20 = r20;
        addField(r15, new FieldInfo(r113.name(), r110, null, r38, r40, r212, r210, r113, null, r44), r41);
        TypeUtils.setAccessible(r11, r110, r39);
        goto L145
    L146:
        r114 = null;
        r29 = r212;
        goto L149
    L133:
        r28 = null;
    L198:
        Constructor<?> r213 = r14;
        Class<JSONType> r310 = r19;
        Class<? super Object> r311 = r20;
        boolean r117 = r12;
        Class<?> r118 = r11;
        Field[] r312 = r24;
        Class<JSONField> r119 = r21;
        ArrayList r49 = new ArrayList(r312.length);
        int r50 = r312.length;
        int r51 = 0;
    L199:
        Class<Map> r52 = Map.class;
        if (r51 >= r50) goto L214;
        Field r53 = r312[r51];
        int r54 = r53.getModifiers();
        if ((r54 & 8) != 0) goto L213;
        if ((r54 & 16) == 0) goto L211;
        Class<?> r55 = r53.getType();
        if (r52.isAssignableFrom(r55) == true) goto L211;
        if (Collection.class.isAssignableFrom(r55) == false) goto L213;
    L211:
        if ((r53.getModifiers() & 1) == 0) goto L213;
        r49.add(r53);
    L213:
        r51 = r51 + 1;
        goto L199
    L214:
        Class<? super Object> r56 = r38.getSuperclass();
    L215:
        if (r56 == null) goto L234;
        Class<? super Object> r57 = r311;
        if (r56 == r57) goto L234;
        Field[] r58 = r56.getDeclaredFields();
        int r59 = r58.length;
        int r60 = 0;
    L219:
        if (r60 >= r59) goto L233;
        Field r61 = r58[r60];
        int r62 = r61.getModifiers();
        if ((r62 & 8) != 0) goto L232;
        if ((r62 & 16) == 0) goto L230;
        Class<?> r63 = r61.getType();
        if (r52.isAssignableFrom(r63) == true) goto L230;
        if (Collection.class.isAssignableFrom(r63) == false) goto L232;
    L230:
        if ((r62 & 1) == 0) goto L232;
        r49.add(r61);
    L232:
        r60 = r60 + 1;
        goto L219
    L233:
        r56 = r56.getSuperclass();
        r311 = r57;
    L234:
        Iterator r120 = r49.iterator();
    L236:
        if (r120.hasNext() == false) goto L257;
        Field r64 = (Field) r120.next();
        String r65 = r64.getName();
        int r66 = r15.size();
        boolean r67 = false;
        int r68 = 0;
    L238:
        if (r68 >= r66) goto L243;
        if (((FieldInfo) r15.get(r68)).name.equals(r65) == false) goto L242;
        r67 = r117;
    L242:
        r68 = r68 + 1;
        goto L238
    L243:
        if (r67 == true) goto L236;
        if (r43 == false) goto L247;
        JSONField r69 = (JSONField) r64.getAnnotation(r119);
    L248:
        if (r69 == null) goto L253;
        int r70 = r69.ordinal();
        int r71 = SerializerFeature.of(r69.serialzeFeatures());
        if (r69.name().length() == 0) goto L252;
        r65 = r69.name();
    L252:
        int r72 = r70;
        int r73 = r71;
    L254:
        if (r45 == 0) goto L256;
        r65 = r45.translate(r65);
    L256:
        TypeUtils.setAccessible(r118, r64, r39);
        addField(r15, new FieldInfo(r65, null, r64, r38, r40, r72, r73, null, r69, r44), r41);
        r118 = r38;
        r52 = r52;
        goto L236
    L253:
        r72 = 0;
        r73 = 0;
        goto L254
    L247:
        r69 = null;
        goto L248
    L257:
        Class<Map> r313 = r52;
        if (r41 == true) goto L290;
        Method[] r121 = r38.getMethods();
        int r74 = r121.length;
        int r75 = 0;
    L260:
        if (r75 >= r74) goto L290;
        Method r76 = r121[r75];
        String r77 = r76.getName();
        if (r77.length() < 4) goto L266;
        if (Modifier.isStatic(r76.getModifiers()) == true) goto L266;
        if (r77.startsWith("get") == false) goto L266;
        if (Character.isUpperCase(r77.charAt(3)) == false) goto L266;
        if (r76.getParameterTypes().length != 0) goto L266;
        Class<?> r78 = r76.getReturnType();
        Class<Map> r79 = r313;
        if (Collection.class.isAssignableFrom(r78) == false) goto L277;
    L280:
        if (r43 == false) goto L282;
        JSONField r122 = (JSONField) r76.getAnnotation(r119);
    L283:
        if (r122 == null) goto L287;
        String r80 = r122.name();
        if (r80.length() <= 0) goto L287;
    L288:
        Class<Map> r214 = r79;
        addField(r15, new FieldInfo(r80, r76, null, r38, r40, 0, 0, r122, null, r44), r41);
        TypeUtils.setAccessible(r38, r76, r39);
    L289:
        r75 = r75 + 1;
        r74 = r74;
        r121 = r121;
        r313 = r214;
    L287:
        r80 = Character.toLowerCase(r77.charAt(3)) + r77.substring(4);
        goto L288
    L282:
        r122 = null;
        goto L283
    L277:
        if (r79.isAssignableFrom(r78) == true) goto L280;
        r214 = r79;
    L266:
        r214 = r313;
    L290:
        int r81 = r15.size();
        FieldInfo[] r82 = new FieldInfo[r81];
        r15.toArray(r82);
        FieldInfo[] r83 = new FieldInfo[r81];
        System.arraycopy(r82, 0, r83, 0, r81);
        Arrays.sort(r83);
        if (r42 == false) goto L293;
        JSONType r84 = (JSONType) r38.getAnnotation(r310);
    L295:
        return new JavaBeanInfo(r38, r213, null, null, r82, r83, r84);
    L293:
        r84 = null;
        goto L295
    L28:
        if (r38.isInterface() == true) goto L109;
        if (r10 != 0) goto L109;
        Constructor<?>[] r85 = r38.getDeclaredConstructors();
        int r86 = r85.length;
        int r87 = 0;
    L32:
        if (r87 >= r86) goto L37;
        Constructor<?> r88 = r85[r87];
        if (((JSONCreator) r88.getAnnotation(JSONCreator.class)) != null) goto L35;
        r87 = r87 + 1;
        goto L32
    L35:
        Constructor<?> r123 = r88;
    L39:
        if (r123 == null) goto L67;
        TypeUtils.setAccessible(r11, r123, r39);
        Class<?>[] r89 = r123.getParameterTypes();
        if (r44 == false) goto L43;
        Type[] r124 = r123.getGenericParameterTypes();
    L44:
        int r90 = 0;
    L46:
        if (r90 >= r89.length) goto L61;
        Annotation[] r91 = r123.getParameterAnnotations()[r90];
        int r92 = r91.length;
        int r93 = r13;
    L48:
        if (r93 >= r92) goto L53;
        Annotation r94 = r91[r93];
        if ((r94 instanceof JSONField) == true) goto L51;
        r93 = r93 + 1;
        goto L48
    L51:
        JSONField r95 = (JSONField) r94;
    L54:
        if (r95 == null) goto L60;
        Class<?> r96 = r89[r90];
        Type r125 = r124[r90];
        Field r97 = TypeUtils.getField(r11, r95.name(), r17);
        if (r97 == null) goto L58;
        TypeUtils.setAccessible(r11, r97, r39);
    L58:
        addField(r15, new FieldInfo(r95.name(), r38, r96, r125, r97, r95.ordinal(), SerializerFeature.of(r95.serialzeFeatures())), r41);
        r90 = r90 + 1;
        r18 = r18;
        r89 = r89;
        r17 = r17;
        r13 = 0;
        goto L46
    L60:
        throw new JSONException("illegal json creator");
    L53:
        r95 = null;
        goto L54
    L61:
        Class<JSONType> r98 = r18;
        int r99 = r15.size();
        FieldInfo[] r100 = new FieldInfo[r99];
        r15.toArray(r100);
        FieldInfo[] r101 = new FieldInfo[r99];
        System.arraycopy(r100, 0, r101, 0, r99);
        Arrays.sort(r101);
        if (r42 == false) goto L64;
        JSONType r102 = (JSONType) r11.getAnnotation(r98);
    L66:
        return new JavaBeanInfo(r38, null, r123, null, r100, r101, r102);
    L64:
        r102 = null;
        goto L66
    L43:
        r124 = r89;
        goto L44
    L67:
        Field[] r215 = r17;
        int r103 = r16.length;
        int r104 = 0;
    L68:
        if (r104 >= r103) goto L78;
        Method r105 = r16[r104];
        if (Modifier.isStatic(r105.getModifiers()) == false) goto L77;
        if (r11.isAssignableFrom(r105.getReturnType()) == false) goto L77;
        if (((JSONCreator) r105.getAnnotation(JSONCreator.class)) == null) goto L77;
        Method r106 = r105;
    L79:
        if (r106 == null) goto L108;
        TypeUtils.setAccessible(r11, r106, r39);
        Class<?>[] r126 = r106.getParameterTypes();
        if (r44 == false) goto L83;
        Type[] r127 = r106.getGenericParameterTypes();
    L84:
        int r107 = 0;
    L86:
        if (r107 >= r126.length) goto L98;
        Annotation[] r108 = r106.getParameterAnnotations()[r107];
        int r109 = r108.length;
        int r128 = 0;
    L88:
        if (r128 >= r109) goto L93;
        Annotation r129 = r108[r128];
        if ((r129 instanceof JSONField) == true) goto L91;
        r128 = r128 + 1;
        goto L88
    L91:
        JSONField r130 = (JSONField) r129;
    L94:
        if (r130 == null) goto L97;
        Field[] r131 = r215;
        addField(r15, new FieldInfo(r130.name(), r38, r126[r107], r127[r107], TypeUtils.getField(r11, r130.name(), r131), r130.ordinal(), SerializerFeature.of(r130.serialzeFeatures())), r41);
        r107 = r107 + 1;
        r126 = r126;
        r215 = r131;
        goto L86
    L97:
        throw new JSONException("illegal json creator");
    L93:
        r130 = null;
        goto L94
    L98:
        int r132 = r15.size();
        FieldInfo[] r133 = new FieldInfo[r132];
        r15.toArray(r133);
        FieldInfo[] r134 = new FieldInfo[r132];
        System.arraycopy(r133, 0, r134, 0, r132);
        Arrays.sort(r134);
        if (Arrays.equals(r133, r134) == false) goto L101;
        FieldInfo[] r135 = r133;
    L102:
        if (r42 == false) goto L104;
        JSONType r136 = (JSONType) r11.getAnnotation(r18);
    L106:
        return new JavaBeanInfo(r38, null, null, r106, r133, r135, r136);
    L104:
        r136 = null;
        goto L106
    L101:
        r135 = r134;
        goto L102
    L83:
        r127 = r126;
        goto L84
    L108:
        throw new JSONException("default constructor not found. " + r11);
    L77:
        r104 = r104 + 1;
        goto L68
    L78:
        r106 = null;
        goto L79
    L37:
        r123 = null;
        goto L39
    L24:
        r16 = r38.getMethods();
        goto L25
    L296:
        Constructor<?> r137 = r11.getDeclaredConstructor(null);     // Catch: Exception -> L6
    L7:
        if (r137 == null) goto L9;
    L20:
        r14 = r137;
        goto L22
    L9:
        if (r38.isMemberClass() == false) goto L20;
        if ((r39 & 8) != 0) goto L20;
        Constructor<?>[] r138 = r38.getDeclaredConstructors();
        int r139 = r138.length;
        int r140 = 0;
    L13:
        if (r140 >= r139) goto L20;
        Constructor<?> r141 = r138[r140];
        Class<?>[] r142 = r141.getParameterTypes();
        if (r142.length != 1) goto L19;
        if (r142[0].equals(r38.getDeclaringClass()) == false) goto L19;
        r14 = r141;
    L19:
        r140 = r140 + 1;
    L6:
        r137 = null;
        goto L7
    }

    private FieldInfo[] computeSortedFields(FieldInfo[] r10, FieldInfo[] r11) {
        JSONType r12 = this.jsonType;
        if (r12 != null) goto L5;
        return r11;
    L5:
        String[] r13 = r12.orders();
        if (r13 != null) goto L8;
    L66:
        return r11;
    L8:
        if (r13.length == 0) goto L66;
        int r14 = 0;
    L11:
        if (r14 >= r13.length) goto L21;
        int r15 = 0;
    L14:
        if (r15 >= r11.length) goto L19;
        if (r11[r15].name.equals(r13[r14]) == true) goto L17;
        r15 = r15 + 1;
        goto L14
    L17:
        r14 = r14 + 1;
        goto L11
    L19:
        return r11;
    L21:
        if (r13.length != r10.length) goto L42;
        int r16 = 0;
    L24:
        if (r16 >= r13.length) goto L41;
        if (r11[r16].name.equals(r13[r16]) == false) goto L27;
        r16 = r16 + 1;
        goto L24
    L27:
        FieldInfo[] r17 = new FieldInfo[r11.length];
        int r18 = 0;
    L29:
        if (r18 >= r13.length) goto L38;
        int r19 = 0;
    L32:
        if (r19 >= r11.length) goto L37;
        if (r11[r19].name.equals(r13[r18]) == true) goto L35;
        r19 = r19 + 1;
        goto L32
    L35:
        r17[r18] = r11[r19];
    L37:
        r18 = r18 + 1;
        goto L29
    L38:
        this.ordered = true;
        return r17;
    L41:
        return r11;
    L42:
        int r20 = r11.length;
        FieldInfo[] r21 = new FieldInfo[r20];
        int r22 = 0;
    L44:
        if (r22 >= r13.length) goto L53;
        int r23 = 0;
    L47:
        if (r23 >= r11.length) goto L52;
        if (r11[r23].name.equals(r13[r22]) == true) goto L50;
        r23 = r23 + 1;
        goto L47
    L50:
        r21[r22] = r11[r23];
    L52:
        r22 = r22 + 1;
        goto L44
    L53:
        int r24 = r13.length;
        int r25 = 0;
    L55:
        if (r25 >= r11.length) goto L65;
        int r26 = 0;
    L57:
        if (r26 >= r20) goto L63;
        if (r26 >= r24) goto L63;
        if (r21[r25].equals(r11[r26]) == true) goto L64;
        r26 = r26 + 1;
    L64:
        r25 = r25 + 1;
    L63:
        r21[r24] = r11[r25];
        r24 = r24 + 1;
        goto L64
    L65:
        this.ordered = true;
        goto L66
    }
}
