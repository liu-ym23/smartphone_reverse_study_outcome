package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

/* JADX INFO: renamed from: com.google.gson.internal.$Gson$Types, reason: invalid class name */
/* JADX INFO: loaded from: classes3.dex */
public final class C$Gson$Types {
    static final Type[] EMPTY_TYPE_ARRAY = null;

    /* JADX INFO: renamed from: com.google.gson.internal.$Gson$Types$GenericArrayTypeImpl */
    public static final class GenericArrayTypeImpl implements GenericArrayType, Serializable {
        private static final long serialVersionUID = 0;
        private final Type componentType;

        public GenericArrayTypeImpl(Type r10) {
            this.componentType = C$Gson$Types.canonicalize(r10);
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof GenericArrayType) == true) goto L5;
        L7:
            return false;
        L5:
            if (C$Gson$Types.equals(this, (GenericArrayType) r10) == false) goto L7;
            return true;
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.componentType;
        }

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public String toString() {
            return C$Gson$Types.typeToString(this.componentType) + "[]";
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.$Gson$Types$ParameterizedTypeImpl */
    public static final class ParameterizedTypeImpl implements ParameterizedType, Serializable {
        private static final long serialVersionUID = 0;
        private final Type ownerType;
        private final Type rawType;
        private final Type[] typeArguments;

        public ParameterizedTypeImpl(Type r10, Type r11, Type... r12) {
            int r13 = 0;
            if ((r11 instanceof Class) == false) goto L16;
            Class r14 = (Class) r11;
            boolean r15 = true;
            if (Modifier.isStatic(r14.getModifiers()) == false) goto L7;
        L10:
            boolean r16 = true;
        L11:
            if (r10 != null) goto L15;
            if (r16 == true) goto L15;
            r15 = false;
        L15:
            C$Gson$Preconditions.checkArgument(r15);
            goto L16
        L7:
            if (r14.getEnclosingClass() == null) goto L10;
            r16 = false;
        L16:
            if (r10 != null) goto L18;
            Type r17 = null;
        L19:
            this.ownerType = r17;
            this.rawType = C$Gson$Types.canonicalize(r11);
            Type[] r18 = (Type[]) r12.clone();
            this.typeArguments = r18;
            int r19 = r18.length;
        L20:
            if (r13 >= r19) goto L22;
            C$Gson$Preconditions.checkNotNull(this.typeArguments[r13]);
            C$Gson$Types.checkNotPrimitive(this.typeArguments[r13]);
            Type[] r20 = this.typeArguments;
            r20[r13] = C$Gson$Types.canonicalize(r20[r13]);
            r13 = r13 + 1;
            goto L20
        L22:
            return;
        L18:
            r17 = C$Gson$Types.canonicalize(r10);
            goto L19
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof ParameterizedType) == true) goto L5;
        L7:
            return false;
        L5:
            if (C$Gson$Types.equals(this, (ParameterizedType) r10) == false) goto L7;
            return true;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.typeArguments.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.ownerType;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.rawType;
        }

        public int hashCode() {
            int r10 = Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode();
            return C$Gson$Types.hashCodeOrZero(this.ownerType) ^ r10;
        }

        public String toString() {
            int r10 = this.typeArguments.length;
            if (r10 == 0) goto L5;
            StringBuilder r11 = new StringBuilder((r10 + 1) * 30);
            r11.append(C$Gson$Types.typeToString(this.rawType));
            r11.append("<");
            r11.append(C$Gson$Types.typeToString(this.typeArguments[0]));
            int r12 = 1;
        L7:
            if (r12 >= r10) goto L9;
            r11.append(", ");
            r11.append(C$Gson$Types.typeToString(this.typeArguments[r12]));
            r12 = r12 + 1;
            goto L7
        L9:
            r11.append(">");
            return r11.toString();
        L5:
            return C$Gson$Types.typeToString(this.rawType);
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.$Gson$Types$WildcardTypeImpl */
    public static final class WildcardTypeImpl implements WildcardType, Serializable {
        private static final long serialVersionUID = 0;
        private final Type lowerBound;
        private final Type upperBound;

        public WildcardTypeImpl(Type[] r10, Type[] r11) {
            boolean r12 = true;
            if (r11.length > 1) goto L5;
            boolean r13 = true;
        L6:
            C$Gson$Preconditions.checkArgument(r13);
            if (r10.length != 1) goto L9;
            boolean r14 = true;
        L10:
            C$Gson$Preconditions.checkArgument(r14);
            if (r11.length != 1) goto L17;
            C$Gson$Preconditions.checkNotNull(r11[0]);
            C$Gson$Types.checkNotPrimitive(r11[0]);
            if (r10[0] == Object.class) goto L16;
            r12 = false;
        L16:
            C$Gson$Preconditions.checkArgument(r12);
            this.lowerBound = C$Gson$Types.canonicalize(r11[0]);
            this.upperBound = Object.class;
            return;
        L17:
            C$Gson$Preconditions.checkNotNull(r10[0]);
            C$Gson$Types.checkNotPrimitive(r10[0]);
            this.lowerBound = null;
            this.upperBound = C$Gson$Types.canonicalize(r10[0]);
            return;
        L9:
            r14 = false;
            goto L10
        L5:
            r13 = false;
            goto L6
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof WildcardType) == true) goto L5;
        L7:
            return false;
        L5:
            if (C$Gson$Types.equals(this, (WildcardType) r10) == false) goto L7;
            return true;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type r10 = this.lowerBound;
            if (r10 == null) goto L6;
            return new Type[]{r10};
        L6:
            return C$Gson$Types.EMPTY_TYPE_ARRAY;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.upperBound};
        }

        public int hashCode() {
            Type r10 = this.lowerBound;
            if (r10 == null) goto L5;
            int r11 = r10.hashCode() + 31;
        L7:
            return (this.upperBound.hashCode() + 31) ^ r11;
        L5:
            r11 = 1;
            goto L7
        }

        public String toString() {
            if (this.lowerBound == null) goto L7;
            return "? super " + C$Gson$Types.typeToString(this.lowerBound);
        L7:
            if (this.upperBound != Object.class) goto L11;
            return "?";
        L11:
            return "? extends " + C$Gson$Types.typeToString(this.upperBound);
        }
    }

    static {
        EMPTY_TYPE_ARRAY = new Type[0];
    }

    private C$Gson$Types() {
        throw new UnsupportedOperationException();
    }

    public static GenericArrayType arrayOf(Type r10) {
        return new GenericArrayTypeImpl(r10);
    }

    public static Type canonicalize(Type r10) {
        if ((r10 instanceof Class) == false) goto L9;
        Class r11 = (Class) r10;
        if (r11.isArray() == true) goto L7;
        return r11;
    L7:
        return new GenericArrayTypeImpl(canonicalize(r11.getComponentType()));
    L9:
        if ((r10 instanceof ParameterizedType) == false) goto L13;
        ParameterizedType r12 = (ParameterizedType) r10;
        return new ParameterizedTypeImpl(r12.getOwnerType(), r12.getRawType(), r12.getActualTypeArguments());
    L13:
        if ((r10 instanceof GenericArrayType) == false) goto L17;
        return new GenericArrayTypeImpl(((GenericArrayType) r10).getGenericComponentType());
    L17:
        if ((r10 instanceof WildcardType) == false) goto L20;
        WildcardType r13 = (WildcardType) r10;
        return new WildcardTypeImpl(r13.getUpperBounds(), r13.getLowerBounds());
    L20:
        return r10;
    }

    public static void checkNotPrimitive(Type r10) {
        if ((r10 instanceof Class) == true) goto L5;
    L8:
        boolean r11 = true;
    L9:
        C$Gson$Preconditions.checkArgument(r11);
        return;
    L5:
        if (((Class) r10).isPrimitive() == false) goto L8;
        r11 = false;
        goto L9
    }

    private static Class<?> declaringClassOf(TypeVariable<?> r10) {
        GenericDeclaration r11 = r10.getGenericDeclaration();
        if ((r11 instanceof Class) == true) goto L7;
        return null;
    L7:
        return (Class) r11;
    }

    public static boolean equal(Object r10, Object r11) {
        if (r10 == r11) goto L8;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.equals(r11) == false) goto L7;
    L8:
        return true;
    }

    public static boolean equals(Type r10, Type r11) {
        if (r10 != r11) goto L6;
        return true;
    L6:
        if ((r10 instanceof Class) == false) goto L10;
        return r10.equals(r11);
    L10:
        if ((r10 instanceof ParameterizedType) == false) goto L24;
        if ((r11 instanceof ParameterizedType) == true) goto L14;
        return false;
    L14:
        ParameterizedType r12 = (ParameterizedType) r10;
        ParameterizedType r13 = (ParameterizedType) r11;
        if (equal(r12.getOwnerType(), r13.getOwnerType()) == false) goto L22;
        if (r12.getRawType().equals(r13.getRawType()) == false) goto L22;
        if (Arrays.equals(r12.getActualTypeArguments(), r13.getActualTypeArguments()) == false) goto L22;
        return true;
    L22:
        return false;
    L24:
        if ((r10 instanceof GenericArrayType) == false) goto L31;
        if ((r11 instanceof GenericArrayType) == true) goto L29;
        return false;
    L29:
        return equals(((GenericArrayType) r10).getGenericComponentType(), ((GenericArrayType) r11).getGenericComponentType());
    L31:
        if ((r10 instanceof WildcardType) == false) goto L43;
        if ((r11 instanceof WildcardType) == true) goto L35;
        return false;
    L35:
        WildcardType r14 = (WildcardType) r10;
        WildcardType r15 = (WildcardType) r11;
        if (Arrays.equals(r14.getUpperBounds(), r15.getUpperBounds()) == false) goto L41;
        if (Arrays.equals(r14.getLowerBounds(), r15.getLowerBounds()) == false) goto L41;
        return true;
    L41:
        return false;
    L43:
        if ((r10 instanceof TypeVariable) == true) goto L45;
        return false;
    L45:
        if ((r11 instanceof TypeVariable) == true) goto L47;
        return false;
    L47:
        TypeVariable r16 = (TypeVariable) r10;
        TypeVariable r17 = (TypeVariable) r11;
        if (r16.getGenericDeclaration() != r17.getGenericDeclaration()) goto L53;
        if (r16.getName().equals(r17.getName()) == false) goto L53;
        return true;
    L53:
        return false;
    }

    public static Type getArrayComponentType(Type r10) {
        if ((r10 instanceof GenericArrayType) == false) goto L6;
        return ((GenericArrayType) r10).getGenericComponentType();
    L6:
        return ((Class) r10).getComponentType();
    }

    public static Type getCollectionElementType(Type r10, Class<?> r11) {
        Type r12 = getSupertype(r10, r11, Collection.class);
        if ((r12 instanceof WildcardType) == false) goto L6;
        r12 = ((WildcardType) r12).getUpperBounds()[0];
    L6:
        if ((r12 instanceof ParameterizedType) == true) goto L8;
        return Object.class;
    L8:
        return ((ParameterizedType) r12).getActualTypeArguments()[0];
    }

    public static Type getGenericSupertype(Type r10, Class<?> r11, Class<?> r12) {
        if (r12 != r11) goto L5;
        return r10;
    L5:
        if (r12.isInterface() == false) goto L18;
        Class<?>[] r13 = r11.getInterfaces();
        int r14 = r13.length;
        int r15 = 0;
    L7:
        if (r15 >= r14) goto L18;
        Class<?> r16 = r13[r15];
        if (r16 == r12) goto L11;
        if (r12.isAssignableFrom(r16) == true) goto L15;
        r15 = r15 + 1;
        goto L7
    L15:
        return getGenericSupertype(r11.getGenericInterfaces()[r15], r13[r15], r12);
    L11:
        return r11.getGenericInterfaces()[r15];
    L18:
        if (r11.isInterface() == false) goto L20;
    L30:
        return r12;
    L20:
        if (r11 == Object.class) goto L30;
        Class<? super Object> r17 = r11.getSuperclass();
        if (r17 == r12) goto L24;
        if (r12.isAssignableFrom(r17) == true) goto L28;
        r11 = r17;
        goto L20
    L28:
        return getGenericSupertype(r11.getGenericSuperclass(), r17, r12);
    L24:
        return r11.getGenericSuperclass();
    }

    public static Type[] getMapKeyAndValueTypes(Type r10, Class<?> r11) {
        if (r10 == Properties.class) goto L5;
        Type r12 = getSupertype(r10, r11, Map.class);
        if ((r12 instanceof ParameterizedType) == false) goto L11;
        return ((ParameterizedType) r12).getActualTypeArguments();
    L11:
        return new Type[]{Object.class, Object.class};
    L5:
        return new Type[]{String.class, String.class};
    }

    public static Class<?> getRawType(Type r10) {
        if ((r10 instanceof Class) == false) goto L7;
        return (Class) r10;
    L7:
        if ((r10 instanceof ParameterizedType) == false) goto L11;
        Type r11 = ((ParameterizedType) r10).getRawType();
        C$Gson$Preconditions.checkArgument(r11 instanceof Class);
        return (Class) r11;
    L11:
        if ((r10 instanceof GenericArrayType) == false) goto L15;
        return Array.newInstance(getRawType(((GenericArrayType) r10).getGenericComponentType()), 0).getClass();
    L15:
        if ((r10 instanceof TypeVariable) == false) goto L19;
        return Object.class;
    L19:
        if ((r10 instanceof WildcardType) == true) goto L21;
        if (r10 != null) goto L24;
        String r12 = "null";
    L26:
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + r10 + "> is of type " + r12);
    L24:
        r12 = r10.getClass().getName();
        goto L26
    L21:
        return getRawType(((WildcardType) r10).getUpperBounds()[0]);
    }

    public static Type getSupertype(Type r10, Class<?> r11, Class<?> r12) {
        if ((r10 instanceof WildcardType) == false) goto L5;
        r10 = ((WildcardType) r10).getUpperBounds()[0];
    L5:
        C$Gson$Preconditions.checkArgument(r12.isAssignableFrom(r11));
        return resolve(r10, r11, getGenericSupertype(r10, r11, r12));
    }

    public static int hashCodeOrZero(Object r10) {
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.hashCode();
    }

    private static int indexOf(Object[] r10, Object r11) {
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        if (r11.equals(r10[r13]) == true) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return r13;
    L9:
        throw new NoSuchElementException();
    }

    public static ParameterizedType newParameterizedTypeWithOwner(Type r10, Type r11, Type... r12) {
        return new ParameterizedTypeImpl(r10, r11, r12);
    }

    public static Type resolve(Type r10, Class<?> r11, Type r12) {
        return resolve(r10, r11, r12, new HashSet());
    }

    public static Type resolveTypeVariable(Type r10, Class<?> r11, TypeVariable<?> r12) {
        Class<?> r13 = declaringClassOf(r12);
        if (r13 != null) goto L5;
        return r12;
    L5:
        Type r14 = getGenericSupertype(r10, r11, r13);
        if ((r14 instanceof ParameterizedType) == false) goto L9;
        int r15 = indexOf(r13.getTypeParameters(), r12);
        return ((ParameterizedType) r14).getActualTypeArguments()[r15];
    L9:
        return r12;
    }

    public static WildcardType subtypeOf(Type r10) {
        if ((r10 instanceof WildcardType) == false) goto L5;
        Type[] r11 = ((WildcardType) r10).getUpperBounds();
    L7:
        return new WildcardTypeImpl(r11, EMPTY_TYPE_ARRAY);
    L5:
        r11 = new Type[]{r10};
        goto L7
    }

    public static WildcardType supertypeOf(Type r10) {
        if ((r10 instanceof WildcardType) == false) goto L5;
        Type[] r11 = ((WildcardType) r10).getLowerBounds();
    L7:
        return new WildcardTypeImpl(new Type[]{Object.class}, r11);
    L5:
        r11 = new Type[]{r10};
        goto L7
    }

    public static String typeToString(Type r10) {
        if ((r10 instanceof Class) == false) goto L6;
        return ((Class) r10).getName();
    L6:
        return r10.toString();
    }

    private static Type resolve(Type r10, Class<?> r11, Type r12, Collection<TypeVariable> r13) {
    L3:
        if ((r12 instanceof TypeVariable) == false) goto L11;
        TypeVariable r14 = (TypeVariable) r12;
        if (r13.contains(r14) == true) goto L6;
        r13.add(r14);
        r12 = resolveTypeVariable(r10, r11, r14);
        if (r12 != r14) goto L3;
        return r12;
    L6:
        return r12;
    L11:
        if ((r12 instanceof Class) == false) goto L20;
        Class r15 = (Class) r12;
        if (r15.isArray() == false) goto L20;
        Class<?> r16 = r15.getComponentType();
        Type r17 = resolve(r10, r11, r16, r13);
        if (r16 != r17) goto L18;
        return r15;
    L18:
        return arrayOf(r17);
    L20:
        if ((r12 instanceof GenericArrayType) == false) goto L26;
        GenericArrayType r18 = (GenericArrayType) r12;
        Type r19 = r18.getGenericComponentType();
        Type r20 = resolve(r10, r11, r19, r13);
        if (r19 != r20) goto L25;
        return r18;
    L25:
        return arrayOf(r20);
    L26:
        int r21 = 0;
        if ((r12 instanceof ParameterizedType) == false) goto L43;
        ParameterizedType r110 = (ParameterizedType) r12;
        Type r22 = r110.getOwnerType();
        Type r23 = resolve(r10, r11, r22, r13);
        if (r23 == r22) goto L31;
        boolean r24 = true;
    L32:
        Type[] r25 = r110.getActualTypeArguments();
        int r26 = r25.length;
    L33:
        if (r21 >= r26) goto L40;
        Type r27 = resolve(r10, r11, r25[r21], r13);
        if (r27 == r25[r21]) goto L39;
        if (r24 == true) goto L38;
        r25 = (Type[]) r25.clone();
        r24 = true;
    L38:
        r25[r21] = r27;
    L39:
        r21 = r21 + 1;
        goto L33
    L40:
        if (r24 == true) goto L42;
        return r110;
    L42:
        return newParameterizedTypeWithOwner(r23, r110.getRawType(), r25);
    L31:
        r24 = false;
        goto L32
    L43:
        boolean r28 = r12 instanceof WildcardType;
        Type r111 = r12;
        if (r28 == false) goto L57;
        WildcardType r112 = (WildcardType) r12;
        Type[] r29 = r112.getLowerBounds();
        Type[] r30 = r112.getUpperBounds();
        if (r29.length != 1) goto L51;
        Type r31 = resolve(r10, r11, r29[0], r13);
        r111 = r112;
        if (r31 == r29[0]) goto L57;
        return supertypeOf(r31);
    L51:
        r111 = r112;
        if (r30.length != 1) goto L57;
        Type r32 = resolve(r10, r11, r30[0], r13);
        r111 = r112;
        if (r32 == r30[0]) goto L57;
        return subtypeOf(r32);
    L57:
        return r111;
    }
}
