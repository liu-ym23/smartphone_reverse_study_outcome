package ac2;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes9.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Type[] f2660a = null;

    public static final class a implements GenericArrayType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f2661a;

        public final int hashCode() {
            return this.f2661a.hashCode();
        }

        public final String toString() {
            return y.h(this.f2661a) + "[]";
        }

        @Override // java.lang.reflect.GenericArrayType
        public final Type getGenericComponentType() {
            return this.f2661a;
        }

        public a(Type r100) {
            this.f2661a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof GenericArrayType) == true) goto L5;
        L7:
            return false;
        L5:
            if (y.b(this, (GenericArrayType) r100) == false) goto L7;
            return true;
        }
    }

    public static final class b implements ParameterizedType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f2662a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Type f2663b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Type[] f2664c;

        @Override // java.lang.reflect.ParameterizedType
        public final Type[] getActualTypeArguments() {
            return (Type[]) this.f2664c.clone();
        }

        public final int hashCode() {
            int r100 = Arrays.hashCode(this.f2664c) ^ this.f2663b.hashCode();
            Type r101 = this.f2662a;
            if (r101 == null) goto L5;
            int r102 = r101.hashCode();
        L7:
            return r100 ^ r102;
        L5:
            r102 = 0;
            goto L7
        }

        public final String toString() {
            int r100 = 1;
            StringBuilder r101 = new StringBuilder((this.f2664c.length + 1) * 30);
            r101.append(y.h(this.f2663b));
            if (this.f2664c.length == 0) goto L5;
            r101.append("<");
            r101.append(y.h(this.f2664c[0]));
        L8:
            if (r100 >= this.f2664c.length) goto L10;
            r101.append(", ");
            r101.append(y.h(this.f2664c[r100]));
            r100 = r100 + 1;
            goto L8
        L10:
            r101.append(">");
            return r101.toString();
        L5:
            return r101.toString();
        }

        @Override // java.lang.reflect.ParameterizedType
        public final Type getOwnerType() {
            return this.f2662a;
        }

        @Override // java.lang.reflect.ParameterizedType
        public final Type getRawType() {
            return this.f2663b;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof ParameterizedType) == true) goto L5;
        L7:
            return false;
        L5:
            if (y.b(this, (ParameterizedType) r100) == false) goto L7;
            return true;
        }

        public b(Type r100, Type r101, Type... r102) {
            int r103 = 0;
            if ((r101 instanceof Class) == false) goto L16;
            boolean r104 = true;
            if (r100 != null) goto L7;
            boolean r105 = true;
        L9:
            if (((Class) r101).getEnclosingClass() == null) goto L12;
            r104 = false;
        L12:
            if (r105 == r104) goto L16;
            throw new IllegalArgumentException();
        L7:
            r105 = false;
        L16:
            this.f2662a = r100;
            this.f2663b = r101;
            Type[] r106 = (Type[]) r102.clone();
            this.f2664c = r106;
            int r107 = r106.length;
        L17:
            if (r103 >= r107) goto L19;
            Type r108 = r106[r103];
            r108.getClass();
            y.a(r108);
            r103 = r103 + 1;
            goto L17
        }
    }

    public static final class c implements WildcardType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f2665a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Type f2666b;

        @Override // java.lang.reflect.WildcardType
        public final Type[] getUpperBounds() {
            return new Type[]{this.f2665a};
        }

        @Override // java.lang.reflect.WildcardType
        public final Type[] getLowerBounds() {
            Type r100 = this.f2666b;
            if (r100 == null) goto L6;
            return new Type[]{r100};
        L6:
            return y.f2660a;
        }

        public final int hashCode() {
            Type r100 = this.f2666b;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode() + 31;
        L7:
            return r101 ^ (this.f2665a.hashCode() + 31);
        L5:
            r101 = 1;
            goto L7
        }

        public final String toString() {
            if (this.f2666b == null) goto L7;
            return "? super " + y.h(this.f2666b);
        L7:
            if (this.f2665a != Object.class) goto L11;
            return "?";
        L11:
            return "? extends " + y.h(this.f2665a);
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof WildcardType) == true) goto L5;
        L7:
            return false;
        L5:
            if (y.b(this, (WildcardType) r100) == false) goto L7;
            return true;
        }

        public c(Type[] r100, Type[] r101) {
            if (r101.length > 1) goto L18;
            if (r100.length != 1) goto L16;
            if (r101.length != 1) goto L13;
            Type r102 = r101[0];
            r102.getClass();
            y.a(r102);
            if (r100[0] != Object.class) goto L12;
            this.f2666b = r101[0];
            this.f2665a = Object.class;
            return;
        L12:
            throw new IllegalArgumentException();
        L13:
            Type r103 = r100[0];
            r103.getClass();
            y.a(r103);
            this.f2666b = null;
            this.f2665a = r100[0];
            return;
        L16:
            throw new IllegalArgumentException();
        L18:
            throw new IllegalArgumentException();
        }
    }

    static {
        f2660a = new Type[0];
    }

    public static void a(Type r100) {
        if ((r100 instanceof Class) == true) goto L5;
        return;
    L5:
        if (((Class) r100).isPrimitive() == true) goto L8;
        return;
    L8:
        throw new IllegalArgumentException();
    }

    public static Class<?> e(Type r100) {
        if (r100 == null) goto L30;
        if ((r100 instanceof Class) == false) goto L8;
        return (Class) r100;
    L8:
        if ((r100 instanceof ParameterizedType) == false) goto L16;
        Type r101 = ((ParameterizedType) r100).getRawType();
        if ((r101 instanceof Class) == false) goto L14;
        return (Class) r101;
    L14:
        throw new IllegalArgumentException();
    L16:
        if ((r100 instanceof GenericArrayType) == false) goto L20;
        return Array.newInstance(e(((GenericArrayType) r100).getGenericComponentType()), 0).getClass();
    L20:
        if ((r100 instanceof TypeVariable) == false) goto L24;
        return Object.class;
    L24:
        if ((r100 instanceof WildcardType) == false) goto L28;
        return e(((WildcardType) r100).getUpperBounds()[0]);
    L28:
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + r100 + "> is of type " + r100.getClass().getName());
    L30:
        throw new NullPointerException("type == null");
    }

    public static boolean f(Type r100) {
        if ((r100 instanceof Class) == false) goto L6;
        return false;
    L6:
        if ((r100 instanceof ParameterizedType) == false) goto L15;
        Type[] r101 = ((ParameterizedType) r100).getActualTypeArguments();
        int r102 = r101.length;
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L13;
        if (f(r101[r103]) == true) goto L11;
        r103 = r103 + 1;
        goto L8
    L11:
        return true;
    L13:
        return false;
    L15:
        if ((r100 instanceof GenericArrayType) == false) goto L19;
        return f(((GenericArrayType) r100).getGenericComponentType());
    L19:
        if ((r100 instanceof TypeVariable) == false) goto L22;
        return true;
    L22:
        if ((r100 instanceof WildcardType) == false) goto L24;
        return true;
    L24:
        if (r100 != null) goto L26;
        String r104 = "null";
    L28:
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + r100 + "> is of type " + r104);
    L26:
        r104 = r100.getClass().getName();
        goto L28
    }

    public static String h(Type r100) {
        if ((r100 instanceof Class) == false) goto L6;
        return ((Class) r100).getName();
    L6:
        return r100.toString();
    }

    public static <T> void i(Class<T> r100) {
        if (r100.isInterface() == false) goto L10;
        if (r100.getInterfaces().length > 0) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("API interfaces must not extend other interfaces.");
    L10:
        throw new IllegalArgumentException("API declarations must be interfaces.");
    }

    public static boolean b(Type r100, Type r101) {
        if (r100 != r101) goto L6;
        return true;
    L6:
        if ((r100 instanceof Class) == false) goto L10;
        return r100.equals(r101);
    L10:
        if ((r100 instanceof ParameterizedType) == false) goto L31;
        if ((r101 instanceof ParameterizedType) == true) goto L14;
        return false;
    L14:
        ParameterizedType r102 = (ParameterizedType) r100;
        ParameterizedType r103 = (ParameterizedType) r101;
        Type r104 = r102.getOwnerType();
        Type r105 = r103.getOwnerType();
        if (r104 == r105) goto L21;
        if (r104 != null) goto L18;
    L20:
        boolean r106 = false;
    L22:
        if (r106 == true) goto L24;
    L28:
        return false;
    L24:
        if (r102.getRawType().equals(r103.getRawType()) == false) goto L28;
        if (Arrays.equals(r102.getActualTypeArguments(), r103.getActualTypeArguments()) == false) goto L28;
        return true;
    L18:
        if (r104.equals(r105) == false) goto L20;
    L21:
        r106 = true;
        goto L22
    L31:
        if ((r100 instanceof GenericArrayType) == false) goto L38;
        if ((r101 instanceof GenericArrayType) == true) goto L36;
        return false;
    L36:
        return b(((GenericArrayType) r100).getGenericComponentType(), ((GenericArrayType) r101).getGenericComponentType());
    L38:
        if ((r100 instanceof WildcardType) == false) goto L50;
        if ((r101 instanceof WildcardType) == true) goto L42;
        return false;
    L42:
        WildcardType r107 = (WildcardType) r100;
        WildcardType r108 = (WildcardType) r101;
        if (Arrays.equals(r107.getUpperBounds(), r108.getUpperBounds()) == true) goto L45;
    L47:
        return false;
    L45:
        if (Arrays.equals(r107.getLowerBounds(), r108.getLowerBounds()) == false) goto L47;
        return true;
    L50:
        if ((r100 instanceof TypeVariable) == true) goto L52;
        return false;
    L52:
        if ((r101 instanceof TypeVariable) == true) goto L54;
        return false;
    L54:
        TypeVariable r109 = (TypeVariable) r100;
        TypeVariable r110 = (TypeVariable) r101;
        if (r109.getGenericDeclaration() == r110.getGenericDeclaration()) goto L57;
    L59:
        return false;
    L57:
        if (r109.getName().equals(r110.getName()) == false) goto L59;
        return true;
    }

    public static Type d(int r100, ParameterizedType r101) {
        Type[] r102 = r101.getActualTypeArguments();
        if (r100 < 0) goto L11;
        if (r100 >= r102.length) goto L11;
        Type r103 = r102[r100];
        if ((r103 instanceof WildcardType) == true) goto L9;
        return r103;
    L9:
        return ((WildcardType) r103).getUpperBounds()[0];
    L11:
        throw new IllegalArgumentException("Index " + r100 + " not in range [0," + r102.length + ") for " + r101);
    }

    public static Type c(Type r100, Class<?> r101, Class<?> r102) {
        if (r102 != r101) goto L5;
        return r100;
    L5:
        if (r102.isInterface() == false) goto L18;
        Class<?>[] r103 = r101.getInterfaces();
        int r104 = r103.length;
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L18;
        Class<?> r106 = r103[r105];
        if (r106 == r102) goto L11;
        if (r102.isAssignableFrom(r106) == true) goto L15;
        r105 = r105 + 1;
        goto L7
    L15:
        return c(r101.getGenericInterfaces()[r105], r103[r105], r102);
    L11:
        return r101.getGenericInterfaces()[r105];
    L18:
        if (r101.isInterface() == false) goto L20;
    L30:
        return r102;
    L20:
        if (r101 == Object.class) goto L30;
        Class<? super Object> r107 = r101.getSuperclass();
        if (r107 == r102) goto L24;
        if (r102.isAssignableFrom(r107) == true) goto L28;
        r101 = r107;
        goto L20
    L28:
        return c(r101.getGenericSuperclass(), r107, r102);
    L24:
        return r101.getGenericSuperclass();
    }

    public static Type g(Type r100, Class<?> r101, Type r110) {
    L2:
        int r102 = 0;
        if ((r10 instanceof TypeVariable) == false) goto L26;
        TypeVariable r111 = (TypeVariable) r10;
        GenericDeclaration r103 = r111.getGenericDeclaration();
        if ((r103 instanceof Class) == false) goto L7;
        Class r104 = (Class) r103;
    L8:
        if (r104 == null) goto L21;
        Type r105 = c(r100, r101, r104);
        if ((r105 instanceof ParameterizedType) == false) goto L21;
        TypeVariable[] r106 = r104.getTypeParameters();
    L14:
        if (r102 >= r106.length) goto L20;
        if (r111.equals(r106[r102]) == true) goto L17;
        r102 = r102 + 1;
        goto L14
    L17:
        Type r107 = ((ParameterizedType) r105).getActualTypeArguments()[r102];
    L22:
        if (r107 == r111) goto L23;
        Type r112 = r107;
        goto L2
    L23:
        return r107;
    L20:
        throw new NoSuchElementException();
    L21:
        r107 = r111;
        goto L22
    L7:
        r104 = null;
        goto L8
    L26:
        if ((r112 instanceof Class) == false) goto L35;
        Class r108 = (Class) r112;
        if (r108.isArray() == false) goto L35;
        Class<?> r113 = r108.getComponentType();
        Type r109 = g(r100, r101, r113);
        if (r113 != r109) goto L33;
        return r108;
    L33:
        return new a(r109);
    L35:
        if ((r112 instanceof GenericArrayType) == false) goto L42;
        GenericArrayType r114 = (GenericArrayType) r112;
        Type r115 = r114.getGenericComponentType();
        Type r116 = g(r100, r101, r115);
        if (r115 != r116) goto L40;
        return r114;
    L40:
        return new a(r116);
    L42:
        if ((r112 instanceof ParameterizedType) == false) goto L58;
        ParameterizedType r117 = (ParameterizedType) r112;
        Type r118 = r117.getOwnerType();
        Type r119 = g(r100, r101, r118);
        if (r119 == r118) goto L46;
        boolean r120 = true;
    L47:
        Type[] r121 = r117.getActualTypeArguments();
        int r122 = r121.length;
    L48:
        if (r102 >= r122) goto L55;
        Type r123 = g(r100, r101, r121[r102]);
        if (r123 == r121[r102]) goto L54;
        if (r120 == true) goto L53;
        r121 = (Type[]) r121.clone();
        r120 = true;
    L53:
        r121[r102] = r123;
    L54:
        r102 = r102 + 1;
        goto L48
    L55:
        if (r120 == true) goto L57;
        return r117;
    L57:
        return new b(r119, r117.getRawType(), r121);
    L46:
        r120 = false;
        goto L47
    L58:
        boolean r124 = r112 instanceof WildcardType;
        Type r125 = r112;
        if (r124 == false) goto L76;
        WildcardType r126 = (WildcardType) r112;
        Type[] r127 = r126.getLowerBounds();
        Type[] r128 = r126.getUpperBounds();
        if (r127.length != 1) goto L66;
        Type r129 = g(r100, r101, r127[0]);
        r125 = r126;
        if (r129 == r127[0]) goto L76;
        return new c(new Type[]{Object.class}, new Type[]{r129});
    L66:
        r125 = r126;
        if (r128.length != 1) goto L76;
        Type r130 = g(r100, r101, r128[0]);     // Catch: Throwable -> L74
        r125 = r126;
        if (r130 == r128[0]) goto L76;
        return new c(new Type[]{r130}, f2660a);
    L74:
        th = move-exception;
        throw th;
    L76:
        return r125;
    }
}
