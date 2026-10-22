package com.google.gson.reflect;

import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class TypeToken<T> {
    final int hashCode;
    final Class<? super T> rawType;
    final Type type;

    public TypeToken() {
        Type r10 = getSuperclassTypeParameter(getClass());
        this.type = r10;
        this.rawType = (Class<? super T>) C$Gson$Types.getRawType(r10);
        this.hashCode = r10.hashCode();
    }

    private static AssertionError buildUnexpectedTypeError(Type r10, Class<?>... r11) {
        StringBuilder r12 = new StringBuilder("Unexpected type. Expected one of: ");
        int r13 = r11.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r12.append(r11[r14].getName());
        r12.append(", ");
        r14 = r14 + 1;
        goto L3
    L5:
        r12.append("but got: ");
        r12.append(r10.getClass().getName());
        r12.append(", for type token: ");
        r12.append(r10.toString());
        r12.append('.');
        return new AssertionError(r12.toString());
    }

    public static TypeToken<?> get(Type r10) {
        return new TypeToken(r10);
    }

    public static TypeToken<?> getArray(Type r10) {
        return new TypeToken(C$Gson$Types.arrayOf(r10));
    }

    public static TypeToken<?> getParameterized(Type r10, Type... r11) {
        return new TypeToken(C$Gson$Types.newParameterizedTypeWithOwner(null, r10, r11));
    }

    public static Type getSuperclassTypeParameter(Class<?> r10) {
        Type r11 = r10.getGenericSuperclass();
        if ((r11 instanceof Class) == true) goto L7;
        return C$Gson$Types.canonicalize(((ParameterizedType) r11).getActualTypeArguments()[0]);
    L7:
        throw new RuntimeException("Missing type parameter.");
    }

    private static boolean matches(Type r10, Type r11, Map<String, Type> r12) {
        if (r11.equals(r10) == false) goto L5;
    L10:
        return true;
    L5:
        if ((r10 instanceof TypeVariable) == true) goto L7;
    L9:
        return false;
    L7:
        if (r11.equals(r12.get(((TypeVariable) r10).getName())) == false) goto L9;
        goto L9
    }

    private static boolean typeEquals(ParameterizedType r10, ParameterizedType r11, Map<String, Type> r12) {
        if (r10.getRawType().equals(r11.getRawType()) == false) goto L13;
        Type[] r13 = r10.getActualTypeArguments();
        Type[] r14 = r11.getActualTypeArguments();
        int r15 = 0;
    L6:
        if (r15 >= r13.length) goto L11;
        if (matches(r13[r15], r14[r15], r12) == false) goto L9;
        r15 = r15 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    L13:
        return false;
    }

    public final boolean equals(Object r10) {
        if ((r10 instanceof TypeToken) == true) goto L5;
    L7:
        return false;
    L5:
        if (C$Gson$Types.equals(this.type, ((TypeToken) r10).type) == false) goto L7;
        return true;
    }

    public final Class<? super T> getRawType() {
        return this.rawType;
    }

    public final Type getType() {
        return this.type;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    @Deprecated
    public boolean isAssignableFrom(Class<?> r10) {
        return isAssignableFrom(r10);
    }

    public final String toString() {
        return C$Gson$Types.typeToString(this.type);
    }

    public static <T> TypeToken<T> get(Class<T> r10) {
        return new TypeToken(r10);
    }

    @Deprecated
    public boolean isAssignableFrom(Type r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if (this.type.equals(r10) == false) goto L8;
        return true;
    L8:
        Type r11 = this.type;
        if ((r11 instanceof Class) == false) goto L13;
        return this.rawType.isAssignableFrom(C$Gson$Types.getRawType(r10));
    L13:
        if ((r11 instanceof ParameterizedType) == false) goto L17;
        return isAssignableFrom(r10, (ParameterizedType) r11, new HashMap());
    L17:
        if ((r11 instanceof GenericArrayType) == false) goto L25;
        if (this.rawType.isAssignableFrom(C$Gson$Types.getRawType(r10)) == true) goto L21;
        return false;
    L21:
        if (isAssignableFrom(r10, (GenericArrayType) this.type) == true) goto L23;
        return false;
    L23:
        return true;
    L25:
        throw buildUnexpectedTypeError(r11, new Class[]{Class.class, ParameterizedType.class, GenericArrayType.class});
    }

    public TypeToken(Type r10) {
        Type r11 = C$Gson$Types.canonicalize((Type) C$Gson$Preconditions.checkNotNull(r10));
        this.type = r11;
        this.rawType = (Class<? super T>) C$Gson$Types.getRawType(r11);
        this.hashCode = r11.hashCode();
    }

    @Deprecated
    public boolean isAssignableFrom(TypeToken<?> r10) {
        return isAssignableFrom(r10.getType());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r1v9 */
    private static boolean isAssignableFrom(Type r10, GenericArrayType r11) {
        Type r12 = r11.getGenericComponentType();
        if ((r12 instanceof ParameterizedType) == true) goto L5;
        return true;
    L5:
        if ((r10 instanceof GenericArrayType) == false) goto L8;
        r10 = ((GenericArrayType) r10).getGenericComponentType();
    L14:
        return isAssignableFrom(r10, (ParameterizedType) r12, new HashMap());
    L8:
        if ((r10 instanceof Class) == false) goto L14;
        r10 = (Class) r10;
    L11:
        if (r10.isArray() == false) goto L14;
        r10 = r10.getComponentType();
        goto L11
    }

    private static boolean isAssignableFrom(Type r10, ParameterizedType r11, Map<String, Type> r12) {
        int r13 = 0;
        if (r10 != null) goto L6;
        return false;
    L6:
        if (r11.equals(r10) == false) goto L8;
        return true;
    L8:
        Class<?> r14 = C$Gson$Types.getRawType(r10);
        if ((r10 instanceof ParameterizedType) == false) goto L11;
        ParameterizedType r15 = (ParameterizedType) r10;
    L12:
        if (r15 == null) goto L24;
        Type[] r16 = r15.getActualTypeArguments();
        TypeVariable<Class<?>>[] r17 = r14.getTypeParameters();
        int r18 = 0;
    L15:
        if (r18 >= r16.length) goto L22;
        Type r19 = r16[r18];
        TypeVariable<Class<?>> r20 = r17[r18];
    L18:
        if ((r19 instanceof TypeVariable) == false) goto L20;
        r19 = r12.get(((TypeVariable) r19).getName());
        goto L18
    L20:
        r12.put(r20.getName(), r19);
        r18 = r18 + 1;
        goto L15
    L22:
        if (typeEquals(r15, r11, r12) == false) goto L24;
        return true;
    L24:
        Type[] r21 = r14.getGenericInterfaces();
        int r22 = r21.length;
    L25:
        if (r13 >= r22) goto L31;
        if (isAssignableFrom(r21[r13], r11, new HashMap(r12)) == true) goto L28;
        r13 = r13 + 1;
        goto L25
    L28:
        return true;
    L31:
        return isAssignableFrom(r14.getGenericSuperclass(), r11, new HashMap(r12));
    L11:
        r15 = null;
        goto L12
    }
}
