package com.bytedance.retrofit2;

import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes2.dex */
public final class Utils {
    private static final int BUFFER_SIZE = 4096;
    static final Type[] EMPTY_TYPE_ARRAY = null;

    private static final class GenericArrayTypeImpl implements GenericArrayType {
        private final Type componentType;

        public GenericArrayTypeImpl(Type r1) {
            this.componentType = r1;
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.componentType;
        }

        public boolean equals(Object r2) {
            if ((r2 instanceof GenericArrayType) == true) goto L5;
        L7:
            return false;
        L5:
            if (Utils.equals(this, (GenericArrayType) r2) == false) goto L7;
            return true;
        }

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public String toString() {
            return Utils.typeToString(this.componentType) + "[]";
        }
    }

    static final class ParameterizedTypeImpl implements ParameterizedType {

        @Nullable
        private final Type ownerType;
        private final Type rawType;
        private final Type[] typeArguments;

        ParameterizedTypeImpl(@Nullable Type r5, Type r6, Type... r7) {
            int r1 = 0;
            if ((r6 instanceof Class) == false) goto L16;
            boolean r0 = true;
            if (r5 != null) goto L7;
            boolean r2 = true;
        L9:
            if (((Class) r6).getEnclosingClass() == null) goto L12;
            r0 = false;
        L12:
            if (r2 == r0) goto L16;
            throw new IllegalArgumentException();
        L7:
            r2 = false;
        L16:
            this.ownerType = r5;
            this.rawType = r6;
            this.typeArguments = (Type[]) r7.clone();
            int r4 = r7.length;
        L17:
            if (r1 >= r4) goto L19;
            Type r8 = r7[r1];
            Utils.checkNotNull(r8, "typeArgument == null");
            Utils.checkNotPrimitive(r8);
            r1 = r1 + 1;
            goto L17
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.typeArguments.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.rawType;
        }

        @Override // java.lang.reflect.ParameterizedType
        @Nullable
        public Type getOwnerType() {
            return this.ownerType;
        }

        public boolean equals(Object r2) {
            if ((r2 instanceof ParameterizedType) == true) goto L5;
        L7:
            return false;
        L5:
            if (Utils.equals(this, (ParameterizedType) r2) == false) goto L7;
            return true;
        }

        public int hashCode() {
            int r0 = Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode();
            Type r2 = this.ownerType;
            if (r2 == null) goto L5;
            int r3 = r2.hashCode();
        L7:
            return r3 ^ r0;
        L5:
            r3 = 0;
            goto L7
        }

        public String toString() {
            int r2 = 1;
            StringBuilder r0 = new StringBuilder((this.typeArguments.length + 1) * 30);
            r0.append(Utils.typeToString(this.rawType));
            if (this.typeArguments.length == 0) goto L5;
            r0.append("<").append(Utils.typeToString(this.typeArguments[0]));
        L8:
            if (r2 >= this.typeArguments.length) goto L11;
            r0.append(", ").append(Utils.typeToString(this.typeArguments[r2]));
            r2 = r2 + 1;
            goto L8
        L11:
            return r0.append(">").toString();
        L5:
            return r0.toString();
        }
    }

    private static final class WildcardTypeImpl implements WildcardType {

        @Nullable
        private final Type lowerBound;
        private final Type upperBound;

        WildcardTypeImpl(Type[] r4, Type[] r5) {
            if (r5.length > 1) goto L18;
            if (r4.length != 1) goto L16;
            if (r5.length != 1) goto L13;
            Type r0 = r5[0];
            r0.getClass();
            Utils.checkNotPrimitive(r0);
            if (r4[0] != Object.class) goto L12;
            this.lowerBound = r5[0];
            this.upperBound = Object.class;
            return;
        L12:
            throw new IllegalArgumentException();
        L13:
            Type r6 = r4[0];
            r6.getClass();
            Utils.checkNotPrimitive(r6);
            this.lowerBound = null;
            this.upperBound = r4[0];
            return;
        L16:
            throw new IllegalArgumentException();
        L18:
            throw new IllegalArgumentException();
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.upperBound};
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type r2 = this.lowerBound;
            if (r2 == null) goto L6;
            return new Type[]{r2};
        L6:
            return Utils.EMPTY_TYPE_ARRAY;
        }

        public boolean equals(Object r2) {
            if ((r2 instanceof WildcardType) == true) goto L5;
        L7:
            return false;
        L5:
            if (Utils.equals(this, (WildcardType) r2) == false) goto L7;
            return true;
        }

        public int hashCode() {
            Type r0 = this.lowerBound;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode() + 31;
        L7:
            return (this.upperBound.hashCode() + 31) ^ r1;
        L5:
            r1 = 1;
            goto L7
        }

        public String toString() {
            if (this.lowerBound == null) goto L7;
            return "? super " + Utils.typeToString(this.lowerBound);
        L7:
            if (this.upperBound != Object.class) goto L11;
            return "?";
        L11:
            return "? extends " + Utils.typeToString(this.upperBound);
        }
    }

    static {
        EMPTY_TYPE_ARRAY = new Type[0];
    }

    private Utils() {
    }

    static byte[] streamToBytes(@Nullable InputStream r4) throws IOException {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        if (r4 == null) goto L9;
        byte[] r1 = new byte[4096];
    L5:
        int r2 = r4.read(r1);
        if (r2 == (-1)) goto L9;
        r0.write(r1, 0, r2);
    L9:
        return r0.toByteArray();
    }

    static Class<?> getRawType(Type r3) {
        checkNotNull(r3, "type == null");
        if ((r3 instanceof Class) == false) goto L7;
        return (Class) r3;
    L7:
        if ((r3 instanceof ParameterizedType) == false) goto L15;
        Type r4 = ((ParameterizedType) r3).getRawType();
        if ((r4 instanceof Class) == false) goto L13;
        return (Class) r4;
    L13:
        throw new IllegalArgumentException();
    L15:
        if ((r3 instanceof GenericArrayType) == false) goto L19;
        return Array.newInstance(getRawType(((GenericArrayType) r3).getGenericComponentType()), 0).getClass();
    L19:
        if ((r3 instanceof TypeVariable) == false) goto L23;
        return Object.class;
    L23:
        if ((r3 instanceof WildcardType) == false) goto L27;
        return getRawType(((WildcardType) r3).getUpperBounds()[0]);
    L27:
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + r3 + "> is of type " + r3.getClass().getName());
    }

    static boolean equals(Type r4, Type r5) {
        if (r4 != r5) goto L6;
        return true;
    L6:
        if ((r4 instanceof Class) == false) goto L10;
        return r4.equals(r5);
    L10:
        if ((r4 instanceof ParameterizedType) == false) goto L27;
        if ((r5 instanceof ParameterizedType) == true) goto L14;
        return false;
    L14:
        ParameterizedType r6 = (ParameterizedType) r4;
        ParameterizedType r7 = (ParameterizedType) r5;
        Type r1 = r6.getOwnerType();
        Type r3 = r7.getOwnerType();
        if (r1 == r3) goto L20;
        if (r1 == null) goto L25;
        if (r1.equals(r3) == true) goto L20;
    L25:
        return false;
    L20:
        if (r6.getRawType().equals(r7.getRawType()) == false) goto L25;
        if (Arrays.equals(r6.getActualTypeArguments(), r7.getActualTypeArguments()) == false) goto L25;
        return true;
    L27:
        if ((r4 instanceof GenericArrayType) == false) goto L34;
        if ((r5 instanceof GenericArrayType) == true) goto L32;
        return false;
    L32:
        return equals(((GenericArrayType) r4).getGenericComponentType(), ((GenericArrayType) r5).getGenericComponentType());
    L34:
        if ((r4 instanceof WildcardType) == false) goto L46;
        if ((r5 instanceof WildcardType) == true) goto L38;
        return false;
    L38:
        WildcardType r8 = (WildcardType) r4;
        WildcardType r9 = (WildcardType) r5;
        if (Arrays.equals(r8.getUpperBounds(), r9.getUpperBounds()) == false) goto L44;
        if (Arrays.equals(r8.getLowerBounds(), r9.getLowerBounds()) == false) goto L44;
        return true;
    L44:
        return false;
    L46:
        if ((r4 instanceof TypeVariable) == true) goto L48;
        return false;
    L48:
        if ((r5 instanceof TypeVariable) == true) goto L50;
        return false;
    L50:
        TypeVariable r10 = (TypeVariable) r4;
        TypeVariable r11 = (TypeVariable) r5;
        if (r10.getGenericDeclaration() != r11.getGenericDeclaration()) goto L56;
        if (r10.getName().equals(r11.getName()) == false) goto L56;
        return true;
    L56:
        return false;
    }

    static Type getGenericSupertype(Type r3, Class<?> r4, Class<?> r5) {
        if (r5 != r4) goto L5;
        return r3;
    L5:
        if (r5.isInterface() == false) goto L18;
        Class<?>[] r6 = r4.getInterfaces();
        int r0 = r6.length;
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L18;
        Class<?> r2 = r6[r1];
        if (r2 == r5) goto L11;
        if (r5.isAssignableFrom(r2) == true) goto L15;
        r1 = r1 + 1;
        goto L7
    L15:
        return getGenericSupertype(r4.getGenericInterfaces()[r1], r6[r1], r5);
    L11:
        return r4.getGenericInterfaces()[r1];
    L18:
        if (r4.isInterface() == false) goto L20;
    L30:
        return r5;
    L20:
        if (r4 == Object.class) goto L30;
        Class<? super Object> r7 = r4.getSuperclass();
        if (r7 == r5) goto L24;
        if (r5.isAssignableFrom(r7) == true) goto L28;
        r4 = r7;
        goto L20
    L28:
        return getGenericSupertype(r4.getGenericSuperclass(), r7, r5);
    L24:
        return r4.getGenericSuperclass();
    }

    private static int indexOf(Object[] r2, Object r3) {
        int r0 = 0;
    L4:
        if (r0 >= r2.length) goto L10;
        if (r3.equals(r2[r0]) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L10:
        throw new NoSuchElementException();
    }

    static String typeToString(Type r1) {
        if ((r1 instanceof Class) == false) goto L6;
        return ((Class) r1).getName();
    L6:
        return r1.toString();
    }

    static Type getSupertype(Type r1, Class<?> r2, Class<?> r3) {
        if (r3.isAssignableFrom(r2) == false) goto L7;
        return resolve(r1, r2, getGenericSupertype(r1, r2, r3));
    L7:
        throw new IllegalArgumentException();
    }

    static Type resolve(Type r8, Class<?> r9, Type r10) {
    L3:
        if ((r10 instanceof TypeVariable) == false) goto L9;
        TypeVariable r11 = (TypeVariable) r10;
        Type r0 = resolveTypeVariable(r8, r9, r11);
        if (r0 == r11) goto L6;
        Type r12 = r0;
        goto L3
    L6:
        return r0;
    L9:
        if ((r12 instanceof Class) == false) goto L18;
        Class r1 = (Class) r12;
        if (r1.isArray() == false) goto L18;
        Class<?> r13 = r1.getComponentType();
        Type r14 = resolve(r8, r9, r13);
        if (r13 != r14) goto L16;
        return r1;
    L16:
        return new GenericArrayTypeImpl(r14);
    L18:
        if ((r12 instanceof GenericArrayType) == false) goto L24;
        GenericArrayType r15 = (GenericArrayType) r12;
        Type r2 = r15.getGenericComponentType();
        Type r16 = resolve(r8, r9, r2);
        if (r2 != r16) goto L23;
        return r15;
    L23:
        return new GenericArrayTypeImpl(r16);
    L24:
        int r3 = 0;
        if ((r12 instanceof ParameterizedType) == false) goto L41;
        ParameterizedType r17 = (ParameterizedType) r12;
        Type r4 = r17.getOwnerType();
        Type r5 = resolve(r8, r9, r4);
        if (r5 == r4) goto L29;
        boolean r6 = true;
    L30:
        Type[] r7 = r17.getActualTypeArguments();
        int r18 = r7.length;
    L31:
        if (r3 >= r18) goto L38;
        Type r19 = resolve(r8, r9, r7[r3]);
        if (r19 == r7[r3]) goto L37;
        if (r6 == true) goto L36;
        r7 = (Type[]) r7.clone();
        r6 = true;
    L36:
        r7[r3] = r19;
    L37:
        r3 = r3 + 1;
        goto L31
    L38:
        if (r6 == true) goto L40;
        return r17;
    L40:
        return new ParameterizedTypeImpl(r5, r17.getRawType(), r7);
    L29:
        r6 = false;
        goto L30
    L41:
        boolean r20 = r12 instanceof WildcardType;
        Type r110 = r12;
        if (r20 == false) goto L55;
        WildcardType r111 = (WildcardType) r12;
        Type[] r21 = r111.getLowerBounds();
        Type[] r22 = r111.getUpperBounds();
        if (r21.length != 1) goto L49;
        Type r23 = resolve(r8, r9, r21[0]);
        r110 = r111;
        if (r23 == r21[0]) goto L55;
        return new WildcardTypeImpl(new Type[]{Object.class}, new Type[]{r23});
    L49:
        r110 = r111;
        if (r22.length != 1) goto L55;
        Type r24 = resolve(r8, r9, r22[0]);
        r110 = r111;
        if (r24 == r22[0]) goto L55;
        return new WildcardTypeImpl(new Type[]{r24}, EMPTY_TYPE_ARRAY);
    L55:
        return r110;
    }

    private static Type resolveTypeVariable(Type r1, Class<?> r2, TypeVariable<?> r3) {
        Class<?> r0 = declaringClassOf(r3);
        if (r0 != null) goto L5;
        return r3;
    L5:
        Type r4 = getGenericSupertype(r1, r2, r0);
        if ((r4 instanceof ParameterizedType) == false) goto L9;
        int r5 = indexOf(r0.getTypeParameters(), r3);
        return ((ParameterizedType) r4).getActualTypeArguments()[r5];
    L9:
        return r3;
    }

    @Nullable
    private static Class<?> declaringClassOf(TypeVariable<?> r1) {
        GenericDeclaration r2 = r1.getGenericDeclaration();
        if ((r2 instanceof Class) == true) goto L7;
        return null;
    L7:
        return (Class) r2;
    }

    static void checkNotPrimitive(Type r1) {
        if ((r1 instanceof Class) == true) goto L5;
        return;
    L5:
        if (((Class) r1).isPrimitive() == true) goto L8;
        return;
    L8:
        throw new IllegalArgumentException();
    }

    static <T> T checkNotNull(@Nullable T r0, String r1) {
        if (r0 == null) goto L5;
        return r0;
    L5:
        throw new NullPointerException(r1);
    }

    static boolean isAnnotationPresent(Annotation[] r4, Class<? extends Annotation> r5) {
        int r0 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (r5.isInstance(r4[r2]) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    static <T> void validateServiceInterface(Class<T> r1) {
        if (r1.isInterface() == false) goto L10;
        if (r1.getInterfaces().length > 0) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("API interfaces must not extend other interfaces.");
    L10:
        throw new IllegalArgumentException("API declarations must be interfaces.");
    }

    static Type getParameterUpperBound(int r4, ParameterizedType r5) {
        Type[] r0 = r5.getActualTypeArguments();
        if (r4 < 0) goto L11;
        if (r4 >= r0.length) goto L11;
        Type r6 = r0[r4];
        if ((r6 instanceof WildcardType) == true) goto L9;
        return r6;
    L9:
        return ((WildcardType) r6).getUpperBounds()[0];
    L11:
        throw new IllegalArgumentException("Index " + r4 + " not in range [0," + r0.length + ") for " + r5);
    }

    static boolean hasUnresolvableType(@Nullable Type r5) {
        if ((r5 instanceof Class) == false) goto L6;
        return false;
    L6:
        if ((r5 instanceof ParameterizedType) == false) goto L15;
        Type[] r6 = ((ParameterizedType) r5).getActualTypeArguments();
        int r0 = r6.length;
        int r3 = 0;
    L8:
        if (r3 >= r0) goto L13;
        if (hasUnresolvableType(r6[r3]) == true) goto L11;
        r3 = r3 + 1;
        goto L8
    L11:
        return true;
    L13:
        return false;
    L15:
        if ((r5 instanceof GenericArrayType) == false) goto L19;
        return hasUnresolvableType(((GenericArrayType) r5).getGenericComponentType());
    L19:
        if ((r5 instanceof TypeVariable) == false) goto L22;
        return true;
    L22:
        if ((r5 instanceof WildcardType) == false) goto L24;
        return true;
    L24:
        if (r5 != null) goto L26;
        String r1 = "null";
    L28:
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + r5 + "> is of type " + r1);
    L26:
        r1 = r5.getClass().getName();
        goto L28
    }

    static Type getCallResponseType(Type r1) {
        if ((r1 instanceof ParameterizedType) == false) goto L7;
        return getParameterUpperBound(0, (ParameterizedType) r1);
    L7:
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }

    public static boolean requiresRequestBody(String r1) {
        if (r1.equals("POST") == false) goto L5;
    L14:
        return true;
    L5:
        if (r1.equals(HttpMethodContrants.PUT) == true) goto L14;
        if (r1.equals(HttpMethodContrants.PATCH) == true) goto L14;
        if (r1.equals("PROPPATCH") == true) goto L14;
        if (r1.equals("REPORT") == true) goto L14;
        return false;
    }

    public static boolean permitsRequestBody(String r1) {
        if (requiresRequestBody(r1) == false) goto L5;
    L16:
        return true;
    L5:
        if (r1.equals(HttpMethodContrants.OPTIONS) == true) goto L16;
        if (r1.equals(HttpMethodContrants.DELETE) == true) goto L16;
        if (r1.equals("PROPFIND") == true) goto L16;
        if (r1.equals("MKCOL") == true) goto L16;
        if (r1.equals("LOCK") == true) goto L16;
        return false;
    }

    public static TypedOutput convert(final RequestBody r1) {
        return new AnonymousClass1(r1);
    }

    static Type getParameterLowerBound(int r0, ParameterizedType r1) {
        Type r2 = r1.getActualTypeArguments()[r0];
        if ((r2 instanceof WildcardType) == true) goto L5;
        return r2;
    L5:
        return ((WildcardType) r2).getLowerBounds()[0];
    }

    static RuntimeException methodError(Method r1, String r2, Object... r3) {
        return methodError(r1, null, r2, r3);
    }

    static RuntimeException methodError(Method r1, @Nullable Throwable r2, String r3, Object... r4) {
        return new IllegalArgumentException(String.format(r3, r4) + "\n    for method " + r1.getDeclaringClass().getSimpleName() + LibrarianImpl.Constants.DOT + r1.getName(), r2);
    }

    static RuntimeException parameterError(Method r1, Throwable r2, int r3, String r4, Object... r5) {
        return methodError(r1, r2, r4 + " (parameter #" + (r3 + 1) + ")", r5);
    }

    static RuntimeException parameterError(Method r1, int r2, String r3, Object... r4) {
        return methodError(r1, r3 + " (parameter #" + (r2 + 1) + ")", r4);
    }

    static void throwIfFatal(Throwable r1) {
        if ((r1 instanceof VirtualMachineError) == true) goto L14;
        if ((r1 instanceof ThreadDeath) == true) goto L12;
        if ((r1 instanceof LinkageError) == true) goto L10;
        return;
    L10:
        throw ((LinkageError) r1);
    L12:
        throw ((ThreadDeath) r1);
    L14:
        throw ((VirtualMachineError) r1);
    }
}
