package com.bytedance.retrofit2;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
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
import java.util.Objects;

/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: classes.dex */
public final class an {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Type[] f9465a = null;

    /* JADX INFO: compiled from: Utils.java */
    private static final class a implements GenericArrayType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Type f9467a;

        public a(Type r3) {
            this.f9467a = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.aiagent.plugin");
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.f9467a;
        }

        public boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, GenericArrayType.class) == true) goto L5;
        L7:
            return false;
        L5:
            if (an.a(this, (GenericArrayType) ZeusTransformUtils.preCheckCast(r3, GenericArrayType.class, "com.obric.aiagent.plugin")) == false) goto L7;
            return true;
        }

        public int hashCode() {
            return this.f9467a.hashCode();
        }

        public String toString() {
            return an.b(this.f9467a) + "[]";
        }
    }

    /* JADX INFO: compiled from: Utils.java */
    static final class b implements ParameterizedType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Type f9468a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Type f9469b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Type[] f9470c;

        b(Type r6, Type r7, Type... r8) {
            Type r9 = (Type) ZeusTransformUtils.wrapperContextForParams(r6, Type.class, "com.obric.aiagent.plugin");
            Type r10 = (Type) ZeusTransformUtils.wrapperContextForParams(r7, Type.class, "com.obric.aiagent.plugin");
            int r2 = 0;
            if (ZeusTransformUtils.instanceOf(r10, Class.class) == false) goto L16;
            boolean r0 = true;
            if (r9 != null) goto L7;
            boolean r3 = true;
        L9:
            if (((Class) ZeusTransformUtils.preCheckCast(r10, Class.class, "com.obric.aiagent.plugin")).getEnclosingClass() == null) goto L12;
            r0 = false;
        L12:
            if (r3 == r0) goto L16;
            throw new IllegalArgumentException();
        L7:
            r3 = false;
        L16:
            this.f9468a = r9;
            this.f9469b = r10;
            this.f9470c = (Type[]) ZeusTransformUtils.preCheckCast(r8.clone(), Type[].class, "com.obric.aiagent.plugin");
            int r5 = r8.length;
        L17:
            if (r2 >= r5) goto L19;
            Type r11 = r8[r2];
            an.a(r11, "typeArgument == null");
            an.c(r11);
            r2 = r2 + 1;
            goto L17
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) ZeusTransformUtils.preCheckCast(this.f9470c.clone(), Type[].class, "com.obric.aiagent.plugin");
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f9469b;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.f9468a;
        }

        public boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, ParameterizedType.class) == true) goto L5;
        L7:
            return false;
        L5:
            if (an.a(this, (ParameterizedType) ZeusTransformUtils.preCheckCast(r3, ParameterizedType.class, "com.obric.aiagent.plugin")) == false) goto L7;
            return true;
        }

        public int hashCode() {
            int r0 = Arrays.hashCode(this.f9470c) ^ this.f9469b.hashCode();
            Type r2 = this.f9468a;
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
            StringBuilder r0 = new StringBuilder((this.f9470c.length + 1) * 30);
            r0.append(an.b(this.f9469b));
            if (this.f9470c.length == 0) goto L5;
            r0.append("<").append(an.b(this.f9470c[0]));
        L8:
            if (r2 >= this.f9470c.length) goto L11;
            r0.append(", ").append(an.b(this.f9470c[r2]));
            r2 = r2 + 1;
            goto L8
        L11:
            return r0.append(">").toString();
        L5:
            return r0.toString();
        }
    }

    /* JADX INFO: compiled from: Utils.java */
    private static final class c implements WildcardType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Type f9471a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Type f9472b;

        c(Type[] r4, Type[] r5) {
            if (r5.length > 1) goto L18;
            if (r4.length != 1) goto L16;
            if (r5.length != 1) goto L13;
            Objects.requireNonNull(r5[0]);
            an.c(r5[0]);
            if (r4[0] != Object.class) goto L12;
            this.f9472b = r5[0];
            this.f9471a = Object.class;
            return;
        L12:
            throw new IllegalArgumentException();
        L13:
            Objects.requireNonNull(r4[0]);
            an.c(r4[0]);
            this.f9472b = null;
            this.f9471a = r4[0];
            return;
        L16:
            throw new IllegalArgumentException();
        L18:
            throw new IllegalArgumentException();
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.f9471a};
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type r2 = this.f9472b;
            if (r2 == null) goto L6;
            return new Type[]{r2};
        L6:
            return an.f9465a;
        }

        public boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, WildcardType.class) == true) goto L5;
        L7:
            return false;
        L5:
            if (an.a(this, (WildcardType) ZeusTransformUtils.preCheckCast(r3, WildcardType.class, "com.obric.aiagent.plugin")) == false) goto L7;
            return true;
        }

        public int hashCode() {
            Type r0 = this.f9472b;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode() + 31;
        L7:
            return (this.f9471a.hashCode() + 31) ^ r1;
        L5:
            r1 = 1;
            goto L7
        }

        public String toString() {
            if (this.f9472b == null) goto L7;
            return "? super " + an.b(this.f9472b);
        L7:
            if (this.f9471a != Object.class) goto L11;
            return "?";
        L11:
            return "? extends " + an.b(this.f9471a);
        }
    }

    static {
        f9465a = new Type[0];
    }

    static byte[] a(InputStream r4) {
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

    static Class<?> a(Type r3) {
        Type r4 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.aiagent.plugin");
        a(r4, "type == null");
        if (ZeusTransformUtils.instanceOf(r4, Class.class) == false) goto L7;
        return (Class) ZeusTransformUtils.preCheckCast(r4, Class.class, "com.obric.aiagent.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r4, ParameterizedType.class) == false) goto L15;
        Type r5 = ((ParameterizedType) ZeusTransformUtils.preCheckCast(r4, ParameterizedType.class, "com.obric.aiagent.plugin")).getRawType();
        if (ZeusTransformUtils.instanceOf(r5, Class.class) == false) goto L13;
        return (Class) ZeusTransformUtils.preCheckCast(r5, Class.class, "com.obric.aiagent.plugin");
    L13:
        throw new IllegalArgumentException();
    L15:
        if (ZeusTransformUtils.instanceOf(r4, GenericArrayType.class) == false) goto L19;
        return Array.newInstance(a(((GenericArrayType) ZeusTransformUtils.preCheckCast(r4, GenericArrayType.class, "com.obric.aiagent.plugin")).getGenericComponentType()), 0).getClass();
    L19:
        if (ZeusTransformUtils.instanceOf(r4, TypeVariable.class) == false) goto L23;
        return Object.class;
    L23:
        if (ZeusTransformUtils.instanceOf(r4, WildcardType.class) == false) goto L27;
        return a(((WildcardType) ZeusTransformUtils.preCheckCast(r4, WildcardType.class, "com.obric.aiagent.plugin")).getUpperBounds()[0]);
    L27:
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + r4 + "> is of type " + r4.getClass().getName());
    }

    static boolean a(Type r4, Type r5) {
        Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.aiagent.plugin");
        Type r7 = (Type) ZeusTransformUtils.wrapperContextForParams(r5, Type.class, "com.obric.aiagent.plugin");
        if (r6 != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r6, Class.class) == false) goto L10;
        return r6.equals(r7);
    L10:
        if (ZeusTransformUtils.instanceOf(r6, ParameterizedType.class) == false) goto L27;
        if (ZeusTransformUtils.instanceOf(r7, ParameterizedType.class) == true) goto L14;
        return false;
    L14:
        ParameterizedType r8 = (ParameterizedType) ZeusTransformUtils.preCheckCast(r6, ParameterizedType.class, "com.obric.aiagent.plugin");
        ParameterizedType r9 = (ParameterizedType) ZeusTransformUtils.preCheckCast(r7, ParameterizedType.class, "com.obric.aiagent.plugin");
        Type r1 = r8.getOwnerType();
        Type r2 = r9.getOwnerType();
        if (r1 == r2) goto L20;
        if (r1 == null) goto L25;
        if (r1.equals(r2) == true) goto L20;
    L25:
        return false;
    L20:
        if (r8.getRawType().equals(r9.getRawType()) == false) goto L25;
        if (Arrays.equals(r8.getActualTypeArguments(), r9.getActualTypeArguments()) == false) goto L25;
        return true;
    L27:
        if (ZeusTransformUtils.instanceOf(r6, GenericArrayType.class) == false) goto L34;
        if (ZeusTransformUtils.instanceOf(r7, GenericArrayType.class) == true) goto L31;
        return false;
    L31:
        GenericArrayType r10 = (GenericArrayType) ZeusTransformUtils.preCheckCast(r6, GenericArrayType.class, "com.obric.aiagent.plugin");
        GenericArrayType r11 = (GenericArrayType) ZeusTransformUtils.preCheckCast(r7, GenericArrayType.class, "com.obric.aiagent.plugin");
        return a(r10.getGenericComponentType(), r11.getGenericComponentType());
    L34:
        if (ZeusTransformUtils.instanceOf(r6, WildcardType.class) == false) goto L46;
        if (ZeusTransformUtils.instanceOf(r7, WildcardType.class) == true) goto L38;
        return false;
    L38:
        WildcardType r12 = (WildcardType) ZeusTransformUtils.preCheckCast(r6, WildcardType.class, "com.obric.aiagent.plugin");
        WildcardType r13 = (WildcardType) ZeusTransformUtils.preCheckCast(r7, WildcardType.class, "com.obric.aiagent.plugin");
        if (Arrays.equals(r12.getUpperBounds(), r13.getUpperBounds()) == false) goto L44;
        if (Arrays.equals(r12.getLowerBounds(), r13.getLowerBounds()) == false) goto L44;
        return true;
    L44:
        return false;
    L46:
        if (ZeusTransformUtils.instanceOf(r6, TypeVariable.class) == true) goto L48;
        return false;
    L48:
        if (ZeusTransformUtils.instanceOf(r7, TypeVariable.class) == true) goto L50;
        return false;
    L50:
        TypeVariable r14 = (TypeVariable) ZeusTransformUtils.preCheckCast(r6, TypeVariable.class, "com.obric.aiagent.plugin");
        TypeVariable r15 = (TypeVariable) ZeusTransformUtils.preCheckCast(r7, TypeVariable.class, "com.obric.aiagent.plugin");
        if (r14.getGenericDeclaration() != r15.getGenericDeclaration()) goto L56;
        if (r14.getName().equals(r15.getName()) == false) goto L56;
        return true;
    L56:
        return false;
    }

    static Type a(Type r3, Class<?> r4, Class<?> r5) {
        Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.aiagent.plugin");
        if (r5 != r4) goto L6;
        return r6;
    L6:
        if (r5.isInterface() == false) goto L19;
        Class<?>[] r7 = r4.getInterfaces();
        int r0 = 0;
        int r1 = r7.length;
    L8:
        if (r0 >= r1) goto L19;
        if (r7[r0] == r5) goto L12;
        if (r5.isAssignableFrom(r7[r0]) == true) goto L16;
        r0 = r0 + 1;
        goto L8
    L16:
        return a(r4.getGenericInterfaces()[r0], r7[r0], r5);
    L12:
        return r4.getGenericInterfaces()[r0];
    L19:
        if (r4.isInterface() == false) goto L21;
    L31:
        return r5;
    L21:
        if (r4 == Object.class) goto L31;
        Class<? super Object> r8 = r4.getSuperclass();
        if (r8 == r5) goto L25;
        if (r5.isAssignableFrom(r8) == true) goto L29;
        r4 = r8;
        goto L21
    L29:
        return a(r4.getGenericSuperclass(), r8, r5);
    L25:
        return r4.getGenericSuperclass();
    }

    private static int a(Object[] r2, Object r3) {
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

    static String b(Type r2) {
        Type r3 = (Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Class.class) == false) goto L6;
        return ((Class) ZeusTransformUtils.preCheckCast(r3, Class.class, "com.obric.aiagent.plugin")).getName();
    L6:
        return r3.toString();
    }

    static Type b(Type r2, Class<?> r3, Class<?> r4) {
        Type r5 = (Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.aiagent.plugin");
        if (r4.isAssignableFrom(r3) == false) goto L7;
        return a(r5, r3, a(r5, r3, r4));
    L7:
        throw new IllegalArgumentException();
    }

    static Type a(Type r9, Class<?> r10, Type r11) {
        Type r12 = (Type) ZeusTransformUtils.wrapperContextForParams(r9, Type.class, "com.obric.aiagent.plugin");
        Type r13 = (Type) ZeusTransformUtils.wrapperContextForParams(r11, Type.class, "com.obric.aiagent.plugin");
    L4:
        if (ZeusTransformUtils.instanceOf(r13, TypeVariable.class) == false) goto L10;
        TypeVariable r14 = (TypeVariable) ZeusTransformUtils.preCheckCast(r13, TypeVariable.class, "com.obric.aiagent.plugin");
        Type r0 = a(r12, r10, r14);
        if (r0 == r14) goto L7;
        r13 = r0;
        goto L4
    L7:
        return r0;
    L10:
        if (ZeusTransformUtils.instanceOf(r13, Class.class) == false) goto L19;
        if (((Class) ZeusTransformUtils.preCheckCast(r13, Class.class, "com.obric.aiagent.plugin")).isArray() == false) goto L19;
        Class r15 = (Class) ZeusTransformUtils.preCheckCast(r13, Class.class, "com.obric.aiagent.plugin");
        Class<?> r1 = r15.getComponentType();
        Type r16 = a(r12, r10, r1);
        if (r1 != r16) goto L17;
        return r15;
    L17:
        return new a(r16);
    L19:
        if (ZeusTransformUtils.instanceOf(r13, GenericArrayType.class) == false) goto L25;
        GenericArrayType r17 = (GenericArrayType) ZeusTransformUtils.preCheckCast(r13, GenericArrayType.class, "com.obric.aiagent.plugin");
        Type r2 = r17.getGenericComponentType();
        Type r18 = a(r12, r10, r2);
        if (r2 != r18) goto L24;
        return r17;
    L24:
        return new a(r18);
    L25:
        int r3 = 0;
        if (ZeusTransformUtils.instanceOf(r13, ParameterizedType.class) == false) goto L42;
        ParameterizedType r19 = (ParameterizedType) ZeusTransformUtils.preCheckCast(r13, ParameterizedType.class, "com.obric.aiagent.plugin");
        Type r4 = r19.getOwnerType();
        Type r5 = a(r12, r10, r4);
        if (r5 == r4) goto L30;
        boolean r6 = true;
    L31:
        Type[] r7 = r19.getActualTypeArguments();
        int r8 = r7.length;
    L32:
        if (r3 >= r8) goto L39;
        Type r20 = a(r12, r10, r7[r3]);
        if (r20 == r7[r3]) goto L38;
        if (r6 == true) goto L37;
        r7 = (Type[]) ZeusTransformUtils.preCheckCast(r7.clone(), Type[].class, "com.obric.aiagent.plugin");
        r6 = true;
    L37:
        r7[r3] = r20;
    L38:
        r3 = r3 + 1;
        goto L32
    L39:
        if (r6 == true) goto L41;
        return r19;
    L41:
        return new b(r5, r19.getRawType(), r7);
    L30:
        r6 = false;
        goto L31
    L42:
        boolean r21 = ZeusTransformUtils.instanceOf(r13, WildcardType.class);
        Type r110 = r13;
        if (r21 == false) goto L56;
        WildcardType r111 = (WildcardType) ZeusTransformUtils.preCheckCast(r13, WildcardType.class, "com.obric.aiagent.plugin");
        Type[] r22 = r111.getLowerBounds();
        Type[] r23 = r111.getUpperBounds();
        if (r22.length != 1) goto L50;
        Type r24 = a(r12, r10, r22[0]);
        r110 = r111;
        if (r24 == r22[0]) goto L56;
        return new c(new Type[]{Object.class}, new Type[]{r24});
    L50:
        r110 = r111;
        if (r23.length != 1) goto L56;
        Type r25 = a(r12, r10, r23[0]);
        r110 = r111;
        if (r25 == r23[0]) goto L56;
        return new c(new Type[]{r25}, f9465a);
    L56:
        return r110;
    }

    private static Type a(Type r2, Class<?> r3, TypeVariable<?> r4) {
        Type r5 = (Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.aiagent.plugin");
        TypeVariable r6 = (TypeVariable) ZeusTransformUtils.wrapperContextForParams(r4, TypeVariable.class, "com.obric.aiagent.plugin");
        Class<?> r0 = a(r6);
        if (r0 != null) goto L5;
        return r6;
    L5:
        Type r7 = a(r5, r3, r0);
        if (ZeusTransformUtils.instanceOf(r7, ParameterizedType.class) == false) goto L9;
        int r8 = a(r0.getTypeParameters(), r6);
        return ((ParameterizedType) ZeusTransformUtils.preCheckCast(r7, ParameterizedType.class, "com.obric.aiagent.plugin")).getActualTypeArguments()[r8];
    L9:
        return r6;
    }

    private static Class<?> a(TypeVariable<?> r2) {
        GenericDeclaration r3 = ((TypeVariable) ZeusTransformUtils.wrapperContextForParams(r2, TypeVariable.class, "com.obric.aiagent.plugin")).getGenericDeclaration();
        if (ZeusTransformUtils.instanceOf(r3, Class.class) == true) goto L7;
        return null;
    L7:
        return (Class) ZeusTransformUtils.preCheckCast(r3, Class.class, "com.obric.aiagent.plugin");
    }

    static void c(Type r2) {
        Type r3 = (Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Class.class) == true) goto L5;
        return;
    L5:
        if (((Class) ZeusTransformUtils.preCheckCast(r3, Class.class, "com.obric.aiagent.plugin")).isPrimitive() == true) goto L8;
        return;
    L8:
        throw new IllegalArgumentException();
    }

    static <T> T a(T r0, String r1) {
        Objects.requireNonNull(r0, r1);
        return r0;
    }

    static boolean a(Annotation[] r4, Class<? extends Annotation> r5) {
        int r0 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (ZeusTransformUtils.instanceOf(r5, r4[r2]) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    static <T> void a(Class<T> r1) {
        if (r1.isInterface() == false) goto L10;
        if (r1.getInterfaces().length > 0) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("API interfaces must not extend other interfaces.");
    L10:
        throw new IllegalArgumentException("API declarations must be interfaces.");
    }

    static Type a(int r4, ParameterizedType r5) {
        ParameterizedType r6 = (ParameterizedType) ZeusTransformUtils.wrapperContextForParams(r5, ParameterizedType.class, "com.obric.aiagent.plugin");
        Type[] r0 = r6.getActualTypeArguments();
        if (r4 < 0) goto L11;
        if (r4 >= r0.length) goto L11;
        Type r7 = r0[r4];
        if (ZeusTransformUtils.instanceOf(r7, WildcardType.class) == true) goto L9;
        return r7;
    L9:
        return ((WildcardType) ZeusTransformUtils.preCheckCast(r7, WildcardType.class, "com.obric.aiagent.plugin")).getUpperBounds()[0];
    L11:
        throw new IllegalArgumentException("Index " + r4 + " not in range [0," + r0.length + ") for " + r6);
    }

    static boolean d(Type r5) {
        Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r5, Type.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Class.class) == false) goto L6;
        return false;
    L6:
        if (ZeusTransformUtils.instanceOf(r6, ParameterizedType.class) == false) goto L15;
        Type[] r7 = ((ParameterizedType) ZeusTransformUtils.preCheckCast(r6, ParameterizedType.class, "com.obric.aiagent.plugin")).getActualTypeArguments();
        int r0 = r7.length;
        int r1 = 0;
    L8:
        if (r1 >= r0) goto L13;
        if (d(r7[r1]) == true) goto L11;
        r1 = r1 + 1;
        goto L8
    L11:
        return true;
    L13:
        return false;
    L15:
        if (ZeusTransformUtils.instanceOf(r6, GenericArrayType.class) == false) goto L19;
        return d(((GenericArrayType) ZeusTransformUtils.preCheckCast(r6, GenericArrayType.class, "com.obric.aiagent.plugin")).getGenericComponentType());
    L19:
        if (ZeusTransformUtils.instanceOf(r6, TypeVariable.class) == false) goto L22;
        return true;
    L22:
        if (ZeusTransformUtils.instanceOf(r6, WildcardType.class) == false) goto L24;
        return true;
    L24:
        if (r6 != null) goto L26;
        String r2 = "null";
    L28:
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + r6 + "> is of type " + r2);
    L26:
        r2 = r6.getClass().getName();
        goto L28
    }

    static Type e(Type r3) {
        Type r4 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ParameterizedType.class) == false) goto L7;
        return a(0, (ParameterizedType) ZeusTransformUtils.preCheckCast(r4, ParameterizedType.class, "com.obric.aiagent.plugin"));
    L7:
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }

    public static boolean a(String r1) {
        if (r1.equals("POST") == false) goto L5;
    L14:
        return true;
    L5:
        if (r1.equals("PUT") == true) goto L14;
        if (r1.equals("PATCH") == true) goto L14;
        if (r1.equals("PROPPATCH") == true) goto L14;
        if (r1.equals("REPORT") == true) goto L14;
        return false;
    }

    public static boolean b(String r1) {
        if (a(r1) == false) goto L5;
    L16:
        return true;
    L5:
        if (r1.equals("OPTIONS") == true) goto L16;
        if (r1.equals("DELETE") == true) goto L16;
        if (r1.equals("PROPFIND") == true) goto L16;
        if (r1.equals("MKCOL") == true) goto L16;
        if (r1.equals("LOCK") == true) goto L16;
        return false;
    }

    public static com.bytedance.retrofit2.e.j a(final okhttp3.ac r1) {
        return new AnonymousClass1(r1);
    }

    static Type b(int r2, ParameterizedType r3) {
        Type r4 = ((ParameterizedType) ZeusTransformUtils.wrapperContextForParams(r3, ParameterizedType.class, "com.obric.aiagent.plugin")).getActualTypeArguments()[r2];
        if (ZeusTransformUtils.instanceOf(r4, WildcardType.class) == true) goto L5;
        return r4;
    L5:
        return ((WildcardType) ZeusTransformUtils.preCheckCast(r4, WildcardType.class, "com.obric.aiagent.plugin")).getLowerBounds()[0];
    }

    static RuntimeException a(Method r1, String r2, Object... r3) {
        return a(r1, null, r2, r3);
    }

    static RuntimeException a(Method r1, Throwable r2, String r3, Object... r4) {
        return new IllegalArgumentException(String.format(r3, r4) + "\n    for method " + r1.getDeclaringClass().getSimpleName() + "." + r1.getName(), r2);
    }

    static RuntimeException a(Method r1, Throwable r2, int r3, String r4, Object... r5) {
        return a(r1, r2, r4 + " (parameter #" + (r3 + 1) + ")", r5);
    }

    static RuntimeException a(Method r1, int r2, String r3, Object... r4) {
        return a(r1, r3 + " (parameter #" + (r2 + 1) + ")", r4);
    }
}
