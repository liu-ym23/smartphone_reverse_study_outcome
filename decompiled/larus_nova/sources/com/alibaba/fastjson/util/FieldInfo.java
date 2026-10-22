package com.alibaba.fastjson.util;

import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.annotation.JSONField;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Map;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes28.dex */
public class FieldInfo implements Comparable<FieldInfo> {
    public final String[] alternateNames;
    public final Class<?> declaringClass;
    public final Field field;
    public final boolean fieldAccess;
    private final JSONField fieldAnnotation;
    public final Class<?> fieldClass;
    public final boolean fieldTransient;
    public final Type fieldType;
    public final String format;
    public final boolean getOnly;
    public final boolean isEnum;
    public final boolean jsonDirect;
    public final String label;
    public final Method method;
    private final JSONField methodAnnotation;
    public final String name;
    public final long nameHashCode;
    public final char[] name_chars;
    private int ordinal;
    public final int parserFeatures;
    public final int serialzeFeatures;
    public final boolean unwrapped;

    public char[] genFieldNameChars() {
        int r100 = this.name.length();
        char[] r101 = new char[r100 + 3];
        String r102 = this.name;
        r102.getChars(0, r102.length(), r101, 1);
        r101[0] = Typography.quote;
        r101[r100 + 1] = Typography.quote;
        r101[r100 + 2] = ':';
        return r101;
    }

    public JSONField getAnnotation() {
        JSONField r100 = this.fieldAnnotation;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return this.methodAnnotation;
    }

    public Class<?> getDeclaredClass() {
        Method r100 = this.method;
        if (r100 != null) goto L5;
        Field r101 = this.field;
        if (r101 != null) goto L9;
        return null;
    L9:
        return r101.getDeclaringClass();
    L5:
        return r100.getDeclaringClass();
    }

    public Member getMember() {
        Method r100 = this.method;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return this.field;
    }

    public void setAccessible() throws SecurityException {
        Method r100 = this.method;
        if (r100 == null) goto L6;
        TypeUtils.setAccessible(r100);
        return;
    L6:
        TypeUtils.setAccessible(this.field);
    }

    public String getFormat() {
        return this.format;
    }

    public String toString() {
        return this.name;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(FieldInfo r100) {
        Method r101 = r100.method;
        if (r101 != null) goto L5;
    L13:
        int r102 = this.ordinal;
        int r103 = r100.ordinal;
        if (r102 >= r103) goto L16;
        return -1;
    L16:
        if (r102 <= r103) goto L18;
        return 1;
    L18:
        int r104 = this.name.compareTo(r100.name);
        if (r104 == 0) goto L21;
        return r104;
    L21:
        Class<?> r105 = getDeclaredClass();
        Class<?> r106 = r100.getDeclaredClass();
        if (r105 == null) goto L31;
        if (r106 == null) goto L31;
        if (r105 == r106) goto L31;
        if (r105.isAssignableFrom(r106) == false) goto L29;
        return -1;
    L29:
        if (r106.isAssignableFrom(r105) == false) goto L31;
        return 1;
    L31:
        Field r107 = this.field;
        boolean r108 = false;
        if (r107 != null) goto L34;
    L36:
        boolean r109 = false;
    L37:
        Field r110 = r100.field;
        if (r110 != null) goto L40;
    L42:
        if (r109 == false) goto L45;
        if (r108 == true) goto L45;
        return 1;
    L45:
        if (r108 == false) goto L49;
        if (r109 == true) goto L49;
        return -1;
    L49:
        if (r100.fieldClass.isPrimitive() == false) goto L54;
        if (this.fieldClass.isPrimitive() == true) goto L54;
        return 1;
    L54:
        if (this.fieldClass.isPrimitive() == false) goto L59;
        if (r100.fieldClass.isPrimitive() == true) goto L59;
        return -1;
    L59:
        if (r100.fieldClass.getName().startsWith("java.") == false) goto L64;
        if (this.fieldClass.getName().startsWith("java.") == true) goto L64;
        return 1;
    L64:
        if (this.fieldClass.getName().startsWith("java.") == false) goto L69;
        if (r100.fieldClass.getName().startsWith("java.") == true) goto L69;
        return -1;
    L69:
        return this.fieldClass.getName().compareTo(r100.fieldClass.getName());
    L40:
        if (r110.getType() != r100.fieldClass) goto L42;
        r108 = true;
        goto L42
    L34:
        if (r107.getType() != this.fieldClass) goto L36;
        r109 = true;
        goto L37
    L5:
        if (this.method == null) goto L13;
        if (r101.isBridge() == false) goto L13;
        if (this.method.isBridge() == true) goto L13;
        if (r100.method.getName().equals(this.method.getName()) == false) goto L13;
        return 1;
    }

    public Object get(Object r100) throws IllegalAccessException, InvocationTargetException {
        Method r101 = this.method;
        if (r101 == null) goto L6;
        return r101.invoke(r100, new Object[0]);
    L6:
        return this.field.get(r100);
    }

    public <T extends Annotation> T getAnnation(Class<T> r100) {
        if (r100 == JSONField.class) goto L5;
        Method r101 = this.method;
        if (r101 == null) goto L9;
        T r102 = (T) TypeUtils.getAnnotation(r101, r100);
    L10:
        if (r102 != null) goto L15;
        Field r103 = this.field;
        if (r103 != null) goto L14;
        return r102;
    L14:
        return (T) TypeUtils.getAnnotation(r103, r100);
    L15:
        return r102;
    L9:
        r102 = null;
        goto L10
    L5:
        return getAnnotation();
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(FieldInfo r100) {
        return compareTo2(r100);
    }

    private static boolean getArgument(Type[] r100, Map<TypeVariable, Type> r101) {
        int r102 = 0;
        if (r101 != null) goto L5;
    L23:
        return false;
    L5:
        if (r101.size() == 0) goto L23;
        boolean r103 = false;
    L9:
        if (r102 >= r100.length) goto L22;
        Type r104 = r100[r102];
        if ((r104 instanceof ParameterizedType) == false) goto L16;
        ParameterizedType r105 = (ParameterizedType) r104;
        Type[] r106 = r105.getActualTypeArguments();
        if (getArgument(r106, r101) == false) goto L21;
        r100[r102] = TypeReference.intern(new ParameterizedTypeImpl(r106, r105.getOwnerType(), r105.getRawType()));
    L20:
        r103 = true;
    L21:
        r102 = r102 + 1;
        goto L9
    L16:
        if ((r104 instanceof TypeVariable) == false) goto L21;
        if (r101.containsKey(r104) == false) goto L21;
        r100[r102] = r101.get(r104);
        goto L20
    L22:
        return r103;
    }

    private long nameHashCode64(String r100, JSONField r101) {
        if (r101 == null) goto L8;
        if (r101.name().length() == 0) goto L8;
        return TypeUtils.fnv1a_64_lower(r100);
    L8:
        return TypeUtils.fnv1a_64_extract(r100);
    }

    public void set(Object r100, Object r101) throws IllegalAccessException, InvocationTargetException {
        Method r102 = this.method;
        if (r102 == null) goto L6;
        r102.invoke(r100, new Object[]{r101});
        return;
    L6:
        this.field.set(r100, r101);
    }

    private static boolean getArgument(Type[] r100, TypeVariable[] r101, Type[] r102) {
        if (r102 != null) goto L5;
    L26:
        return false;
    L5:
        if (r101.length == 0) goto L26;
        int r103 = 0;
        boolean r104 = false;
    L9:
        if (r103 >= r100.length) goto L25;
        Type r105 = r100[r103];
        if ((r105 instanceof ParameterizedType) == false) goto L16;
        ParameterizedType r106 = (ParameterizedType) r105;
        Type[] r107 = r106.getActualTypeArguments();
        if (getArgument(r107, r101, r102) == false) goto L24;
        r100[r103] = TypeReference.intern(new ParameterizedTypeImpl(r107, r106.getOwnerType(), r106.getRawType()));
        r104 = true;
    L24:
        r103 = r103 + 1;
        goto L9
    L16:
        if ((r105 instanceof TypeVariable) == false) goto L24;
        int r108 = 0;
    L19:
        if (r108 >= r101.length) goto L24;
        if (r105.equals(r101[r108]) == false) goto L23;
        r100[r103] = r102[r108];
        r104 = true;
    L23:
        r108 = r108 + 1;
        goto L19
    L25:
        return r104;
    }

    public static Type getFieldType(Class<?> r100, Type r101, Type r102) {
        return getFieldType(r100, r101, r102, null);
    }

    private static Type getInheritGenericType(Class<?> r100, Type r101, TypeVariable<?> r102) {
        if ((r102.getGenericDeclaration() instanceof Class) == false) goto L5;
        Class<?> r103 = (Class) r102.getGenericDeclaration();
    L6:
        if (r103 == r100) goto L8;
        Type[] r104 = null;
    L12:
        if (r100 == null) goto L20;
        if (r100 == Object.class) goto L20;
        if (r100 == r103) goto L20;
        Type r105 = r100.getGenericSuperclass();
        if ((r105 instanceof ParameterizedType) == false) goto L19;
        Type[] r106 = ((ParameterizedType) r105).getActualTypeArguments();
        getArgument(r106, r100.getTypeParameters(), r104);
        r104 = r106;
    L19:
        r100 = r100.getSuperclass();
    L20:
        Type[] r107 = r104;
    L21:
        if (r107 == null) goto L31;
        if (r103 == null) goto L40;
        TypeVariable<Class<?>>[] r108 = r103.getTypeParameters();
        int r109 = 0;
    L26:
        if (r109 >= r108.length) goto L41;
        if (r102.equals(r108[r109]) == true) goto L39;
        r109 = r109 + 1;
        goto L26
    L39:
        return r107[r109];
    L41:
        return null;
    L40:
        return null;
    L31:
        return null;
    L8:
        if ((r101 instanceof ParameterizedType) == false) goto L10;
        r107 = ((ParameterizedType) r101).getActualTypeArguments();
        goto L21
    L10:
        r107 = null;
        goto L21
    L5:
        r103 = null;
        goto L6
    }

    public static Type getFieldType(Class<?> r100, Type r101, Type r102, Map<TypeVariable, Type> r103) {
        if (r100 == null) goto L40;
        if (r101 == null) goto L40;
        int r104 = 0;
        if ((r102 instanceof GenericArrayType) == false) goto L13;
        Type r105 = ((GenericArrayType) r102).getGenericComponentType();
        Type r106 = getFieldType(r100, r101, r105, r103);
        if (r105 != r106) goto L10;
        return r102;
    L10:
        return Array.newInstance(TypeUtils.getClass(r106), 0).getClass();
    L13:
        if (TypeUtils.isGenericParamType(r101) == true) goto L16;
        return r102;
    L16:
        if ((r102 instanceof TypeVariable) == false) goto L26;
        ParameterizedType r107 = (ParameterizedType) TypeUtils.getGenericParamType(r101);
        TypeVariable r108 = (TypeVariable) r102;
        TypeVariable<Class<?>>[] r109 = TypeUtils.getClass(r107).getTypeParameters();
    L19:
        if (r104 >= r109.length) goto L26;
        if (r109[r104].getName().equals(r108.getName()) == true) goto L23;
        r104 = r104 + 1;
        goto L19
    L23:
        return r107.getActualTypeArguments()[r104];
    L26:
        if ((r102 instanceof ParameterizedType) == false) goto L40;
        ParameterizedType r110 = (ParameterizedType) r102;
        Type[] r111 = r110.getActualTypeArguments();
        boolean r112 = getArgument(r111, r103);
        if (r112 == false) goto L30;
    L37:
        if (r112 == false) goto L40;
        return TypeReference.intern(new ParameterizedTypeImpl(r111, r110.getOwnerType(), r110.getRawType()));
    L30:
        if ((r101 instanceof ParameterizedType) == false) goto L33;
        ParameterizedType r113 = (ParameterizedType) r101;
        TypeVariable<Class<?>>[] r114 = r100.getTypeParameters();
    L36:
        r112 = getArgument(r111, r114, r113.getActualTypeArguments());
        goto L37
    L33:
        if ((r100.getGenericSuperclass() instanceof ParameterizedType) == false) goto L35;
        r113 = (ParameterizedType) r100.getGenericSuperclass();
        r114 = r100.getSuperclass().getTypeParameters();
        goto L36
    L35:
        r114 = r101.getClass().getTypeParameters();
        r113 = r110;
    L40:
        return r102;
    }

    public FieldInfo(String r100, Class<?> r101, Class<?> r102, Type r103, Field r104, int r105, int r106, int r107) {
        this.ordinal = 0;
        if (r105 >= 0) goto L5;
        r105 = 0;
    L5:
        this.name = r100;
        this.declaringClass = r101;
        this.fieldClass = r102;
        this.fieldType = r103;
        this.method = null;
        this.field = r104;
        this.ordinal = r105;
        this.serialzeFeatures = r106;
        this.parserFeatures = r107;
        this.isEnum = r102.isEnum();
        if (r104 == null) goto L8;
        int r108 = r104.getModifiers();
        int r109 = r108 & 1;
        this.fieldAccess = true;
        this.fieldTransient = Modifier.isTransient(r108);
    L9:
        this.name_chars = genFieldNameChars();
        if (r104 == null) goto L12;
        TypeUtils.setAccessible(r104);
    L12:
        this.label = "";
        if (r104 != null) goto L15;
        JSONField r110 = null;
    L16:
        this.fieldAnnotation = r110;
        this.methodAnnotation = null;
        this.getOnly = false;
        this.jsonDirect = false;
        this.unwrapped = false;
        this.format = null;
        this.alternateNames = new String[0];
        this.nameHashCode = nameHashCode64(r100, r110);
        return;
    L15:
        r110 = (JSONField) TypeUtils.getAnnotation(r104, JSONField.class);
        goto L16
    L8:
        this.fieldTransient = false;
        this.fieldAccess = false;
        goto L9
    }

    public FieldInfo(String r110, Method r111, Field r112, Class<?> r113, Type r114, int r115, int r210, int r211, JSONField r212, JSONField r213, String r214) {
        this(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214, null);
    }

    public FieldInfo(String r100, Method r101, Field r102, Class<?> r103, Type r104, int r105, int r110, int r111, JSONField r112, JSONField r113, String r114, Map<TypeVariable, Type> r115) {
        boolean r106 = false;
        this.ordinal = 0;
        if (r102 == null) goto L7;
        String r107 = r102.getName();
        if (r107.equals(r100) == false) goto L7;
        r100 = r107;
    L7:
        if (r105 >= 0) goto L9;
        r105 = 0;
    L9:
        this.name = r100;
        this.method = r101;
        this.field = r102;
        this.ordinal = r105;
        this.serialzeFeatures = r110;
        this.parserFeatures = r111;
        this.fieldAnnotation = r112;
        this.methodAnnotation = r113;
        if (r102 == null) goto L25;
        int r116 = r102.getModifiers();
        if ((r116 & 1) != 0) goto L16;
        if (r101 == null) goto L16;
        boolean r117 = false;
    L17:
        this.fieldAccess = r117;
        if (Modifier.isTransient(r116) == false) goto L20;
    L23:
        boolean r118 = true;
    L24:
        this.fieldTransient = r118;
    L26:
        if (r114 != null) goto L28;
    L30:
        this.label = "";
    L31:
        JSONField r119 = getAnnotation();
        this.nameHashCode = nameHashCode64(r100, r119);
        String r108 = null;
        if (r119 == null) goto L38;
        String r120 = r119.format();
        if (r120.trim().length() == 0) goto L37;
        r108 = r120;
    L37:
        boolean r121 = r119.jsonDirect();
        this.unwrapped = r119.unwrapped();
        this.alternateNames = r119.alternateNames();
    L39:
        this.format = r108;
        this.name_chars = genFieldNameChars();
        if (r101 == null) goto L42;
        TypeUtils.setAccessible(r101);
    L42:
        if (r102 == null) goto L44;
        TypeUtils.setAccessible(r102);
    L44:
        if (r101 == null) goto L58;
        Class<?>[] r109 = r101.getParameterTypes();
        if (r109.length != 1) goto L50;
        Class<?> r122 = r109[0];
        Class<?> r123 = r122;
        Type r124 = r101.getGenericParameterTypes()[0];
    L48:
        boolean r125 = false;
        Class<?> r126 = r123;
        Type r127 = r124;
    L57:
        this.declaringClass = r101.getDeclaringClass();
        Class<?> r128 = r126;
        Type r129 = r127;
    L59:
        this.getOnly = r125;
        if (r121 == true) goto L62;
    L64:
        this.jsonDirect = r106;
        if (r103 != null) goto L67;
    L74:
        boolean r130 = r129 instanceof Class;
        Class<?> r131 = r128;
        Type r132 = r129;
        if (r130 == true) goto L88;
        if (r104 != null) goto L79;
        r104 = r103;
    L79:
        Type r133 = getFieldType(r103, r104, r129, r115);
        Class<?> r134 = r128;
        if (r133 != r129) goto L82;
    L87:
        r132 = r133;
        r131 = r134;
        goto L88
    L82:
        if ((r133 instanceof ParameterizedType) == false) goto L84;
        r134 = TypeUtils.getClass(r133);
        goto L87
    L84:
        r134 = r128;
        if ((r133 instanceof Class) == false) goto L87;
        r134 = TypeUtils.getClass(r133);
    L88:
        this.fieldType = r132;
        this.fieldClass = r131;
        this.isEnum = r131.isEnum();
        return;
    L67:
        if (r128 != Object.class) goto L74;
        if ((r129 instanceof TypeVariable) == false) goto L74;
        Type r135 = getInheritGenericType(r103, r104, (TypeVariable) r129);
        if (r135 == null) goto L74;
        this.fieldClass = TypeUtils.getClass(r135);
        this.fieldType = r135;
        this.isEnum = r128.isEnum();
        return;
    L62:
        if (r128 != String.class) goto L64;
        r106 = true;
        goto L64
    L50:
        if (r109.length != 2) goto L56;
        Class<?> r136 = r109[0];
        if (r136 != String.class) goto L56;
        if (r109[1] != Object.class) goto L56;
        r123 = r136;
        r124 = r136;
    L56:
        Class<?> r137 = r101.getReturnType();
        r125 = true;
        r126 = r137;
        r127 = r101.getGenericReturnType();
        goto L57
    L58:
        Class<?> r138 = r102.getType();
        Type r139 = r102.getGenericType();
        this.declaringClass = r102.getDeclaringClass();
        r125 = Modifier.isFinal(r102.getModifiers());
        r129 = r139;
        r128 = r138;
        goto L59
    L38:
        this.unwrapped = false;
        this.alternateNames = new String[0];
        r121 = false;
        goto L39
    L28:
        if (r114.length() <= 0) goto L30;
        this.label = r114;
        goto L31
    L20:
        if (TypeUtils.isTransient(r101) == true) goto L23;
        r118 = false;
    L16:
        r117 = true;
        goto L17
    L25:
        this.fieldAccess = false;
        this.fieldTransient = TypeUtils.isTransient(r101);
        goto L26
    }
}
