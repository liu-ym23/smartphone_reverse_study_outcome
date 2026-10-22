package com.alibaba.fastjson.util;

import com.alibaba.fastjson.annotation.JSONField;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: loaded from: classes.dex */
public class FieldInfo implements Comparable<FieldInfo> {
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
    public final Method method;
    private final JSONField methodAnnotation;
    public final String name;
    public final long nameHashCode;
    private int ordinal;

    public FieldInfo(String r10, Class<?> r11, Class<?> r12, Type r13, Field r14, int r15, int r16) {
        this.name = r10;
        this.declaringClass = r11;
        this.fieldClass = r12;
        this.fieldType = r13;
        this.method = null;
        this.field = r14;
        this.ordinal = r15;
        this.isEnum = r12.isEnum();
        this.fieldAnnotation = null;
        this.methodAnnotation = null;
        int r17 = 0;
        if (r14 == null) goto L5;
        int r18 = r14.getModifiers();
        this.fieldAccess = true;
        this.fieldTransient = Modifier.isTransient(r18);
    L6:
        this.getOnly = false;
        long r19 = -2128831035;
    L8:
        if (r17 >= r10.length()) goto L10;
        r19 = (r19 ^ ((long) r10.charAt(r17))) * 16777619;
        r17 = r17 + 1;
        goto L8
    L10:
        this.nameHashCode = r19;
        this.format = null;
        return;
    L5:
        this.fieldAccess = false;
        this.fieldTransient = false;
        goto L6
    }

    public static Type getFieldType(Class<?> r10, Type r11, Type r12) {
        if (r10 == null) goto L53;
        if (r11 == null) goto L53;
        if ((r12 instanceof GenericArrayType) == false) goto L13;
        Type r13 = ((GenericArrayType) r12).getGenericComponentType();
        Type r14 = getFieldType(r10, r11, r13);
        if (r13 != r14) goto L10;
        return r12;
    L10:
        return Array.newInstance(TypeUtils.getClass(r14), 0).getClass();
    L13:
        if (TypeUtils.isGenericParamType(r11) == true) goto L16;
        return r12;
    L16:
        if ((r12 instanceof TypeVariable) == false) goto L26;
        ParameterizedType r15 = (ParameterizedType) TypeUtils.getGenericParamType(r11);
        Class<?> r16 = TypeUtils.getClass(r15);
        TypeVariable r17 = (TypeVariable) r12;
        int r18 = 0;
    L19:
        if (r18 >= r16.getTypeParameters().length) goto L26;
        if (r16.getTypeParameters()[r18].getName().equals(r17.getName()) == true) goto L23;
        r18 = r18 + 1;
        goto L19
    L23:
        return r15.getActualTypeArguments()[r18];
    L26:
        if ((r12 instanceof ParameterizedType) == false) goto L53;
        ParameterizedType r19 = (ParameterizedType) r12;
        Type[] r20 = r19.getActualTypeArguments();
        Type[] r21 = null;
        if ((r11 instanceof ParameterizedType) == false) goto L31;
        ParameterizedType r110 = (ParameterizedType) r11;
        TypeVariable<Class<? super Object>>[] r111 = r10.getTypeParameters();
    L34:
        int r22 = 0;
        boolean r23 = false;
    L36:
        if (r22 >= r20.length) goto L50;
        if (r110 == null) goto L50;
        Type r24 = r20[r22];
        if ((r24 instanceof TypeVariable) == false) goto L49;
        TypeVariable r25 = (TypeVariable) r24;
        int r26 = 0;
    L42:
        if (r26 >= r111.length) goto L49;
        if (r111[r26].getName().equals(r25.getName()) == false) goto L48;
        if (r21 != null) goto L47;
        r21 = r110.getActualTypeArguments();
    L47:
        r20[r22] = r21[r26];
        r23 = true;
    L48:
        r26 = r26 + 1;
    L49:
        r22 = r22 + 1;
    L50:
        if (r23 == false) goto L53;
        return new ParameterizedTypeImpl(r20, r19.getOwnerType(), r19.getRawType());
    L31:
        if ((r10.getGenericSuperclass() instanceof ParameterizedType) == false) goto L33;
        r110 = (ParameterizedType) r10.getGenericSuperclass();
        r111 = r10.getSuperclass().getTypeParameters();
        goto L34
    L33:
        r111 = null;
        r110 = null;
    L53:
        return r12;
    }

    public static Type getInheritGenericType(Class<?> r10, TypeVariable<?> r11) {
        GenericDeclaration r12 = r11.getGenericDeclaration();
    L3:
        Type r13 = r10.getGenericSuperclass();
        if (r13 == null) goto L5;
        if ((r13 instanceof ParameterizedType) == false) goto L25;
        ParameterizedType r14 = (ParameterizedType) r13;
        Type r15 = r14.getRawType();
        if (r12.equals(r15) == true) goto L16;
        if ((r12 instanceof Class) == false) goto L25;
        if ((r15 instanceof Class) == false) goto L25;
        if (((Class) r12).isAssignableFrom((Class) r15) == false) goto L25;
    L16:
        TypeVariable<?>[] r16 = r12.getTypeParameters();
        Type[] r17 = r14.getActualTypeArguments();
        int r18 = 0;
    L18:
        if (r18 >= r16.length) goto L24;
        if (r16[r18] == r11) goto L22;
        r18 = r18 + 1;
        goto L18
    L22:
        return r17[r18];
    L24:
        return null;
    L25:
        r10 = TypeUtils.getClass(r13);
        goto L3
    L5:
        return null;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(FieldInfo r10) {
        return compareTo2(r10);
    }

    public boolean equals(FieldInfo r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if (compareTo2(r10) == 0) goto L10;
        return false;
    L10:
        return true;
    }

    public Object get(Object r10) throws IllegalAccessException, InvocationTargetException {
        if (this.fieldAccess == false) goto L7;
        return this.field.get(r10);
    L7:
        return this.method.invoke(r10, null);
    }

    public JSONField getAnnotation() {
        JSONField r10 = this.fieldAnnotation;
        if (r10 == null) goto L6;
        return r10;
    L6:
        return this.methodAnnotation;
    }

    public void set(Object r10, Object r11) throws IllegalAccessException, InvocationTargetException {
        Method r12 = this.method;
        if (r12 == null) goto L6;
        r12.invoke(r10, new Object[]{r11});
        return;
    L6:
        this.field.set(r10, r11);
    }

    public String toString() {
        return this.name;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(FieldInfo r10) {
        int r11 = this.ordinal;
        int r12 = r10.ordinal;
        if (r11 >= r12) goto L6;
        return -1;
    L6:
        if (r11 <= r12) goto L10;
        return 1;
    L10:
        return this.name.compareTo(r10.name);
    }

    public FieldInfo(String r10, Method r11, Field r12, Class<?> r13, Type r14, int r15, int r16, JSONField r17, JSONField r18, boolean r19) {
        this.name = r10;
        this.method = r11;
        this.field = r12;
        this.ordinal = r15;
        this.methodAnnotation = r17;
        this.fieldAnnotation = r18;
        JSONField r20 = getAnnotation();
        String r110 = null;
        if (r20 == null) goto L8;
        String r21 = r20.format();
        if (r21.trim().length() == 0) goto L8;
        r110 = r21;
    L8:
        this.format = r110;
        boolean r22 = true;
        if (r12 == null) goto L24;
        int r111 = r12.getModifiers();
        if (r11 != null) goto L13;
    L18:
        boolean r112 = true;
    L19:
        this.fieldAccess = r112;
        if ((r111 & 128) == 0) goto L22;
        boolean r113 = true;
    L23:
        this.fieldTransient = r113;
    L25:
        long r114 = -2128831035;
        int r23 = 0;
    L27:
        if (r23 >= r10.length()) goto L29;
        r114 = (r114 ^ ((long) r10.charAt(r23))) * 16777619;
        r23 = r23 + 1;
        goto L27
    L29:
        this.nameHashCode = r114;
        if (r11 == null) goto L50;
        Class<?>[] r24 = r11.getParameterTypes();
        if (r24.length != 1) goto L43;
        Class<?> r25 = r24[0];
        if (r25 == Class.class) goto L41;
        if (r25 == String.class) goto L41;
        if (r25.isPrimitive() == true) goto L41;
        if (r19 == false) goto L41;
        Type r26 = r11.getGenericParameterTypes()[0];
    L42:
        this.getOnly = false;
    L49:
        this.declaringClass = r11.getDeclaringClass();
    L60:
        if (r13 == null) goto L70;
        if (r25 != Object.class) goto L70;
        if ((r26 instanceof TypeVariable) == false) goto L70;
        Type r27 = getInheritGenericType(r13, (TypeVariable) r26);
        if (r27 == null) goto L70;
        this.fieldClass = TypeUtils.getClass(r27);
        this.fieldType = r27;
        this.isEnum = r25.isEnum();
        return;
    L70:
        if ((r26 instanceof Class) == true) goto L83;
        if (r14 != null) goto L74;
        r14 = r13;
    L74:
        Type r28 = getFieldType(r13, r14, r26);
        if (r28 != r26) goto L77;
    L79:
        r26 = r28;
        goto L83
    L77:
        if ((r28 instanceof ParameterizedType) == false) goto L81;
        r25 = TypeUtils.getClass(r28);
        goto L79
    L81:
        if ((r28 instanceof Class) == false) goto L79;
        r25 = TypeUtils.getClass(r28);
    L83:
        this.fieldType = r26;
        this.fieldClass = r25;
        if (r25.isArray() == false) goto L86;
    L88:
        r22 = false;
    L89:
        this.isEnum = r22;
        return;
    L86:
        if (r25.isEnum() == false) goto L88;
    L41:
        r26 = r25;
        goto L42
    L43:
        r25 = r11.getReturnType();
        if (r25 != Class.class) goto L46;
    L45:
        r26 = r25;
    L48:
        this.getOnly = true;
        goto L49
    L46:
        if (r19 == false) goto L45;
        r26 = r11.getGenericReturnType();
        goto L48
    L50:
        Class<?> r29 = r12.getType();
        if (r29.isPrimitive() == true) goto L58;
        if (r29 == String.class) goto L58;
        if (r29.isEnum() == true) goto L58;
        if (r19 == false) goto L58;
        r26 = r12.getGenericType();
    L59:
        this.declaringClass = r12.getDeclaringClass();
        this.getOnly = Modifier.isFinal(r12.getModifiers());
        r25 = r29;
    L58:
        r26 = r29;
        goto L59
    L22:
        r113 = false;
        goto L23
    L13:
        if ((r111 & 1) != 0) goto L15;
    L17:
        r112 = false;
        goto L19
    L15:
        if (r11.getReturnType() != r12.getType()) goto L17;
    L24:
        this.fieldAccess = false;
        this.fieldTransient = false;
        goto L25
    }
}
