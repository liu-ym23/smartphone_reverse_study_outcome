package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;
import okhttp3.ResponseBody;
import okio.Buffer;

/* JADX INFO: loaded from: classes4.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Type[] f24118a = null;

    public static final class a implements GenericArrayType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f24119a;

        public a(Type r10) {
            this.f24119a = r10;
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof GenericArrayType) == true) goto L5;
        L7:
            return false;
        L5:
            if (i.f(this, (GenericArrayType) r10) == false) goto L7;
            return true;
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.f24119a;
        }

        public int hashCode() {
            return this.f24119a.hashCode();
        }

        public String toString() {
            return i.r(this.f24119a) + "[]";
        }
    }

    public static final class b implements ParameterizedType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f24120a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Type f24121b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Type[] f24122c;

        public b(Type r10, Type r11, Type... r12) {
            int r13 = 0;
            if ((r11 instanceof Class) == false) goto L16;
            boolean r14 = true;
            if (r10 != null) goto L7;
            boolean r15 = true;
        L9:
            if (((Class) r11).getEnclosingClass() == null) goto L12;
            r14 = false;
        L12:
            if (r15 == r14) goto L16;
            throw new IllegalArgumentException();
        L7:
            r15 = false;
        L16:
            int r16 = r12.length;
        L17:
            if (r13 >= r16) goto L19;
            Type r17 = r12[r13];
            i.b(r17, "typeArgument == null");
            i.c(r17);
            r13 = r13 + 1;
            goto L17
        L19:
            this.f24120a = r10;
            this.f24121b = r11;
            this.f24122c = (Type[]) r12.clone();
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof ParameterizedType) == true) goto L5;
        L7:
            return false;
        L5:
            if (i.f(this, (ParameterizedType) r10) == false) goto L7;
            return true;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.f24122c.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.f24120a;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f24121b;
        }

        public int hashCode() {
            int r10 = Arrays.hashCode(this.f24122c) ^ this.f24121b.hashCode();
            return i.m(this.f24120a) ^ r10;
        }

        public String toString() {
            if (this.f24122c.length == 0) goto L5;
            int r10 = 1;
            StringBuilder r11 = new StringBuilder((this.f24122c.length + 1) * 30);
            r11.append(i.r(this.f24121b));
            r11.append("<");
            r11.append(i.r(this.f24122c[0]));
        L8:
            if (r10 >= this.f24122c.length) goto L10;
            r11.append(", ");
            r11.append(i.r(this.f24122c[r10]));
            r10 = r10 + 1;
            goto L8
        L10:
            r11.append(">");
            return r11.toString();
        L5:
            return i.r(this.f24121b);
        }
    }

    public static final class c implements WildcardType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f24123a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Type f24124b;

        public c(Type[] r10, Type[] r11) {
            if (r11.length > 1) goto L24;
            if (r10.length != 1) goto L22;
            if (r11.length != 1) goto L16;
            Type r12 = r11[0];
            if (r12 == null) goto L15;
            i.c(r12);
            if (r10[0] != Object.class) goto L14;
            this.f24124b = r11[0];
            this.f24123a = Object.class;
            return;
        L14:
            throw new IllegalArgumentException();
        L15:
            throw null;
        L16:
            Type r13 = r10[0];
            if (r13 == null) goto L20;
            i.c(r13);
            this.f24124b = null;
            this.f24123a = r10[0];
            return;
        L20:
            throw null;
        L22:
            throw new IllegalArgumentException();
        L24:
            throw new IllegalArgumentException();
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof WildcardType) == true) goto L5;
        L7:
            return false;
        L5:
            if (i.f(this, (WildcardType) r10) == false) goto L7;
            return true;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type r10 = this.f24124b;
            if (r10 == null) goto L6;
            return new Type[]{r10};
        L6:
            return i.f24118a;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.f24123a};
        }

        public int hashCode() {
            Type r10 = this.f24124b;
            if (r10 == null) goto L5;
            int r11 = r10.hashCode() + 31;
        L7:
            return (this.f24123a.hashCode() + 31) ^ r11;
        L5:
            r11 = 1;
            goto L7
        }

        public String toString() {
            if (this.f24124b == null) goto L7;
            return "? super " + i.r(this.f24124b);
        L7:
            if (this.f24123a != Object.class) goto L11;
            return "?";
        L11:
            return "? extends " + i.r(this.f24123a);
        }
    }

    static {
        f24118a = new Type[0];
    }

    public static ResponseBody a(ResponseBody r10) {
        Buffer r11 = new Buffer();
        r10.source().readAll(r11);
        return ResponseBody.create(r10.contentType(), r10.contentLength(), r11);
    }

    public static Object b(Object r10, String r11) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new NullPointerException(r11);
    }

    public static void c(Type r10) {
        if ((r10 instanceof Class) == true) goto L5;
        return;
    L5:
        if (((Class) r10).isPrimitive() == true) goto L8;
        return;
    L8:
        throw new IllegalArgumentException();
    }

    public static Class d(TypeVariable r10) {
        GenericDeclaration r11 = r10.getGenericDeclaration();
        if ((r11 instanceof Class) == true) goto L7;
        return null;
    L7:
        return (Class) r11;
    }

    public static boolean e(Object r10, Object r11) {
        if (r10 == r11) goto L8;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.equals(r11) == false) goto L7;
    L8:
        return true;
    }

    public static boolean f(Type r10, Type r11) {
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
        if (e(r12.getOwnerType(), r13.getOwnerType()) == false) goto L22;
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
        return f(((GenericArrayType) r10).getGenericComponentType(), ((GenericArrayType) r11).getGenericComponentType());
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

    public static Type g(Type r10) {
        if ((r10 instanceof ParameterizedType) == false) goto L7;
        return i(0, (ParameterizedType) r10);
    L7:
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }

    public static Type h(Type r10, Class r11, Class r12) {
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
        return h(r11.getGenericInterfaces()[r15], r13[r15], r12);
    L11:
        return r11.getGenericInterfaces()[r15];
    L18:
        if (r11.isInterface() == false) goto L20;
    L30:
        return r12;
    L20:
        if (r11 == Object.class) goto L30;
        Class<?> r17 = r11.getSuperclass();
        if (r17 == r12) goto L24;
        if (r12.isAssignableFrom(r17) == true) goto L28;
        r11 = r17;
        goto L20
    L28:
        return h(r11.getGenericSuperclass(), r17, r12);
    L24:
        return r11.getGenericSuperclass();
    }

    public static Type i(int r10, ParameterizedType r11) {
        Type[] r12 = r11.getActualTypeArguments();
        if (r10 < 0) goto L11;
        if (r10 >= r12.length) goto L11;
        Type r13 = r12[r10];
        if ((r13 instanceof WildcardType) == true) goto L9;
        return r13;
    L9:
        return ((WildcardType) r13).getUpperBounds()[0];
    L11:
        throw new IllegalArgumentException("Index " + r10 + " not in range [0," + r12.length + ") for " + r11);
    }

    public static Class j(Type r10) {
        b(r10, "type == null");
        if ((r10 instanceof Class) == false) goto L7;
        return (Class) r10;
    L7:
        if ((r10 instanceof ParameterizedType) == false) goto L15;
        Type r11 = ((ParameterizedType) r10).getRawType();
        if ((r11 instanceof Class) == false) goto L13;
        return (Class) r11;
    L13:
        throw new IllegalArgumentException();
    L15:
        if ((r10 instanceof GenericArrayType) == false) goto L19;
        return Array.newInstance(j(((GenericArrayType) r10).getGenericComponentType()), 0).getClass();
    L19:
        if ((r10 instanceof TypeVariable) == false) goto L23;
        return Object.class;
    L23:
        if ((r10 instanceof WildcardType) == false) goto L27;
        return j(((WildcardType) r10).getUpperBounds()[0]);
    L27:
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + r10 + "> is of type " + r10.getClass().getName());
    }

    public static Type k(Type r10, Class r11, Class r12) {
        if (r12.isAssignableFrom(r11) == false) goto L7;
        return p(r10, r11, h(r10, r11, r12));
    L7:
        throw new IllegalArgumentException();
    }

    public static boolean l(Type r10) {
        if ((r10 instanceof Class) == false) goto L6;
        return false;
    L6:
        if ((r10 instanceof ParameterizedType) == false) goto L15;
        Type[] r11 = ((ParameterizedType) r10).getActualTypeArguments();
        int r12 = r11.length;
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L13;
        if (l(r11[r13]) == true) goto L11;
        r13 = r13 + 1;
        goto L8
    L11:
        return true;
    L13:
        return false;
    L15:
        if ((r10 instanceof GenericArrayType) == false) goto L19;
        return l(((GenericArrayType) r10).getGenericComponentType());
    L19:
        if ((r10 instanceof TypeVariable) == false) goto L22;
        return true;
    L22:
        if ((r10 instanceof WildcardType) == false) goto L24;
        return true;
    L24:
        if (r10 != null) goto L26;
        String r14 = "null";
    L28:
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + r10 + "> is of type " + r14);
    L26:
        r14 = r10.getClass().getName();
        goto L28
    }

    public static int m(Object r10) {
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.hashCode();
    }

    public static int n(Object[] r10, Object r11) {
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L10;
        if (r11.equals(r10[r12]) == true) goto L7;
        r12 = r12 + 1;
        goto L4
    L7:
        return r12;
    L10:
        throw new NoSuchElementException();
    }

    public static boolean o(Annotation[] r10, Class r11) {
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        if (r11.isInstance(r10[r13]) == true) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static Type p(Type r10, Class r11, Type r12) {
        int r13 = 0;
        Type r14 = r12;
    L4:
        if ((r14 instanceof TypeVariable) == false) goto L10;
        TypeVariable r15 = (TypeVariable) r14;
        Type r16 = q(r10, r11, r15);
        if (r16 == r15) goto L7;
        r14 = r16;
        goto L4
    L7:
        return r16;
    L10:
        if ((r14 instanceof Class) == false) goto L19;
        Class r17 = (Class) r14;
        if (r17.isArray() == false) goto L19;
        Class<?> r18 = r17.getComponentType();
        Type r19 = p(r10, r11, r18);
        if (r18 != r19) goto L17;
        return r17;
    L17:
        return new a(r19);
    L19:
        if ((r14 instanceof GenericArrayType) == false) goto L26;
        GenericArrayType r110 = (GenericArrayType) r14;
        Type r20 = r110.getGenericComponentType();
        Type r21 = p(r10, r11, r20);
        if (r20 != r21) goto L24;
        return r110;
    L24:
        return new a(r21);
    L26:
        if ((r14 instanceof ParameterizedType) == false) goto L42;
        ParameterizedType r111 = (ParameterizedType) r14;
        Type r22 = r111.getOwnerType();
        Type r23 = p(r10, r11, r22);
        if (r23 == r22) goto L30;
        boolean r24 = true;
    L31:
        Type[] r25 = r111.getActualTypeArguments();
        int r26 = r25.length;
    L32:
        if (r13 >= r26) goto L39;
        Type r27 = p(r10, r11, r25[r13]);
        if (r27 == r25[r13]) goto L38;
        if (r24 == true) goto L37;
        r25 = (Type[]) r25.clone();
        r24 = true;
    L37:
        r25[r13] = r27;
    L38:
        r13 = r13 + 1;
        goto L32
    L39:
        if (r24 == true) goto L41;
        return r111;
    L41:
        return new b(r23, r111.getRawType(), r25);
    L30:
        r24 = false;
        goto L31
    L42:
        boolean r28 = r14 instanceof WildcardType;
        Type r112 = r14;
        if (r28 == false) goto L56;
        WildcardType r113 = (WildcardType) r14;
        Type[] r29 = r113.getLowerBounds();
        Type[] r30 = r113.getUpperBounds();
        if (r29.length != 1) goto L50;
        Type r31 = p(r10, r11, r29[0]);
        r112 = r113;
        if (r31 == r29[0]) goto L56;
        return new c(new Type[]{Object.class}, new Type[]{r31});
    L50:
        r112 = r113;
        if (r30.length != 1) goto L56;
        Type r32 = p(r10, r11, r30[0]);
        r112 = r113;
        if (r32 == r30[0]) goto L56;
        return new c(new Type[]{r32}, f24118a);
    L56:
        return r112;
    }

    public static Type q(Type r10, Class r11, TypeVariable r12) {
        Class r13 = d(r12);
        if (r13 != null) goto L5;
        return r12;
    L5:
        Type r14 = h(r10, r11, r13);
        if ((r14 instanceof ParameterizedType) == false) goto L9;
        int r15 = n(r13.getTypeParameters(), r12);
        return ((ParameterizedType) r14).getActualTypeArguments()[r15];
    L9:
        return r12;
    }

    public static String r(Type r10) {
        if ((r10 instanceof Class) == false) goto L6;
        return ((Class) r10).getName();
    L6:
        return r10.toString();
    }

    public static void s(Class r10) {
        if (r10.isInterface() == false) goto L10;
        if (r10.getInterfaces().length > 0) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("API interfaces must not extend other interfaces.");
    L10:
        throw new IllegalArgumentException("API declarations must be interfaces.");
    }
}
