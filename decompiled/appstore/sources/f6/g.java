package f6;

import com.android.volley.toolbox.HttpClientStack;
import com.bytedance.retrofit2.mime.TypedOutput;
import fg.j;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
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
import okhttp3.RequestBody;
import okio.BufferedSink;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Type[] f19532a = null;

    public static class a implements TypedOutput {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RequestBody f19533a;

        public a(RequestBody r10) {
            this.f19533a = r10;
        }

        @Override // com.bytedance.retrofit2.mime.TypedOutput
        public String fileName() {
            return null;
        }

        @Override // com.bytedance.retrofit2.mime.TypedOutput
        public long length() {
            return this.f19533a.a();
        L4:
            th = move-exception;
            th.printStackTrace();
            return -1;
        }

        @Override // com.bytedance.retrofit2.mime.TypedOutput
        public String md5Stub() {
            return null;
        }

        @Override // com.bytedance.retrofit2.mime.TypedOutput
        public String mimeType() {
            if (this.f19533a.b() != null) goto L5;
            return "";
        L5:
            return this.f19533a.b().toString();
        }

        @Override // com.bytedance.retrofit2.mime.TypedOutput
        public void writeTo(OutputStream r10) {
            BufferedSink r11 = j.c(j.h(r10));
            this.f19533a.g(r11);
            r11.flush();
            r11.close();
        }
    }

    public static final class b implements GenericArrayType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f19534a;

        public b(Type r10) {
            this.f19534a = r10;
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof GenericArrayType) == true) goto L5;
        L7:
            return false;
        L5:
            if (g.f(this, (GenericArrayType) r10) == false) goto L7;
            return true;
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.f19534a;
        }

        public int hashCode() {
            return this.f19534a.hashCode();
        }

        public String toString() {
            return g.t(this.f19534a) + "[]";
        }
    }

    public static final class c implements ParameterizedType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f19535a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Type f19536b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Type[] f19537c;

        public c(Type r10, Type r11, Type... r12) {
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
            this.f19535a = r10;
            this.f19536b = r11;
            Type[] r16 = (Type[]) r12.clone();
            this.f19537c = r16;
            int r17 = r16.length;
        L17:
            if (r13 >= r17) goto L23;
            Type r18 = r16[r13];
            if (r18 == null) goto L22;
            g.b(r18);
            r13 = r13 + 1;
            goto L17
        L22:
            throw null;
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof ParameterizedType) == true) goto L5;
        L7:
            return false;
        L5:
            if (g.f(this, (ParameterizedType) r10) == false) goto L7;
            return true;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.f19537c.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.f19535a;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f19536b;
        }

        public int hashCode() {
            int r10 = Arrays.hashCode(this.f19537c) ^ this.f19536b.hashCode();
            return g.m(this.f19535a) ^ r10;
        }

        public String toString() {
            int r10 = 1;
            StringBuilder r11 = new StringBuilder((this.f19537c.length + 1) * 30);
            r11.append(g.t(this.f19536b));
            if (this.f19537c.length == 0) goto L5;
            r11.append("<");
            r11.append(g.t(this.f19537c[0]));
        L8:
            if (r10 >= this.f19537c.length) goto L10;
            r11.append(", ");
            r11.append(g.t(this.f19537c[r10]));
            r10 = r10 + 1;
            goto L8
        L10:
            r11.append(">");
            return r11.toString();
        L5:
            return r11.toString();
        }
    }

    public static final class d implements WildcardType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f19538a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Type f19539b;

        public d(Type[] r10, Type[] r11) {
            if (r11.length > 1) goto L24;
            if (r10.length != 1) goto L22;
            if (r11.length != 1) goto L16;
            Type r12 = r11[0];
            if (r12 == null) goto L15;
            g.b(r12);
            if (r10[0] != Object.class) goto L14;
            this.f19539b = r11[0];
            this.f19538a = Object.class;
            return;
        L14:
            throw new IllegalArgumentException();
        L15:
            throw null;
        L16:
            Type r13 = r10[0];
            if (r13 == null) goto L20;
            g.b(r13);
            this.f19539b = null;
            this.f19538a = r10[0];
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
            if (g.f(this, (WildcardType) r10) == false) goto L7;
            return true;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type r10 = this.f19539b;
            if (r10 == null) goto L6;
            return new Type[]{r10};
        L6:
            return g.f19532a;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.f19538a};
        }

        public int hashCode() {
            Type r10 = this.f19539b;
            if (r10 == null) goto L5;
            int r11 = r10.hashCode() + 31;
        L7:
            return (this.f19538a.hashCode() + 31) ^ r11;
        L5:
            r11 = 1;
            goto L7
        }

        public String toString() {
            if (this.f19539b == null) goto L7;
            return "? super " + g.t(this.f19539b);
        L7:
            if (this.f19538a != Object.class) goto L11;
            return "?";
        L11:
            return "? extends " + g.t(this.f19538a);
        }
    }

    static {
        f19532a = new Type[0];
    }

    public static Object a(Object r10, String r11) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new NullPointerException(r11);
    }

    public static void b(Type r10) {
        if ((r10 instanceof Class) == true) goto L5;
        return;
    L5:
        if (((Class) r10).isPrimitive() == true) goto L8;
        return;
    L8:
        throw new IllegalArgumentException();
    }

    public static TypedOutput c(RequestBody r10) {
        return new a(r10);
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
        if (r10 == null) goto L30;
        if ((r10 instanceof Class) == false) goto L8;
        return (Class) r10;
    L8:
        if ((r10 instanceof ParameterizedType) == false) goto L16;
        Type r11 = ((ParameterizedType) r10).getRawType();
        if ((r11 instanceof Class) == false) goto L14;
        return (Class) r11;
    L14:
        throw new IllegalArgumentException();
    L16:
        if ((r10 instanceof GenericArrayType) == false) goto L20;
        return Array.newInstance(j(((GenericArrayType) r10).getGenericComponentType()), 0).getClass();
    L20:
        if ((r10 instanceof TypeVariable) == false) goto L24;
        return Object.class;
    L24:
        if ((r10 instanceof WildcardType) == false) goto L28;
        return j(((WildcardType) r10).getUpperBounds()[0]);
    L28:
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + r10 + "> is of type " + r10.getClass().getName());
    L30:
        throw new NullPointerException("type == null");
    }

    public static Type k(Type r10, Class r11, Class r12) {
        if (r12.isAssignableFrom(r11) == false) goto L7;
        return q(r10, r11, h(r10, r11, r12));
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

    public static boolean p(String r10) {
        if (r10.equals("POST") == false) goto L5;
    L14:
        return true;
    L5:
        if (r10.equals("PUT") == true) goto L14;
        if (r10.equals(HttpClientStack.HttpPatch.METHOD_NAME) == true) goto L14;
        if (r10.equals("PROPPATCH") == true) goto L14;
        if (r10.equals("REPORT") == true) goto L14;
        return false;
    }

    public static Type q(Type r10, Class r11, Type r12) {
        int r13 = 0;
        Type r14 = r12;
    L4:
        if ((r14 instanceof TypeVariable) == false) goto L10;
        TypeVariable r15 = (TypeVariable) r14;
        Type r16 = r(r10, r11, r15);
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
        Type r19 = q(r10, r11, r18);
        if (r18 != r19) goto L17;
        return r17;
    L17:
        return new b(r19);
    L19:
        if ((r14 instanceof GenericArrayType) == false) goto L26;
        GenericArrayType r110 = (GenericArrayType) r14;
        Type r20 = r110.getGenericComponentType();
        Type r21 = q(r10, r11, r20);
        if (r20 != r21) goto L24;
        return r110;
    L24:
        return new b(r21);
    L26:
        if ((r14 instanceof ParameterizedType) == false) goto L42;
        ParameterizedType r111 = (ParameterizedType) r14;
        Type r22 = r111.getOwnerType();
        Type r23 = q(r10, r11, r22);
        if (r23 == r22) goto L30;
        boolean r24 = true;
    L31:
        Type[] r25 = r111.getActualTypeArguments();
        int r26 = r25.length;
    L32:
        if (r13 >= r26) goto L39;
        Type r27 = q(r10, r11, r25[r13]);
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
        return new c(r23, r111.getRawType(), r25);
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
        Type r31 = q(r10, r11, r29[0]);
        r112 = r113;
        if (r31 == r29[0]) goto L56;
        return new d(new Type[]{Object.class}, new Type[]{r31});
    L50:
        r112 = r113;
        if (r30.length != 1) goto L56;
        Type r32 = q(r10, r11, r30[0]);
        r112 = r113;
        if (r32 == r30[0]) goto L56;
        return new d(new Type[]{r32}, f19532a);
    L56:
        return r112;
    }

    public static Type r(Type r10, Class r11, TypeVariable r12) {
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

    public static byte[] s(InputStream r10) {
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
        if (r10 == null) goto L9;
        byte[] r12 = new byte[4096];
    L5:
        int r13 = r10.read(r12);
        if (r13 == (-1)) goto L9;
        r11.write(r12, 0, r13);
    L9:
        return r11.toByteArray();
    }

    public static String t(Type r10) {
        if ((r10 instanceof Class) == false) goto L6;
        return ((Class) r10).getName();
    L6:
        return r10.toString();
    }

    public static void u(Class r10) {
        if (r10.isInterface() == false) goto L10;
        if (r10.getInterfaces().length > 0) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("API interfaces must not extend other interfaces.");
    L10:
        throw new IllegalArgumentException("API declarations must be interfaces.");
    }
}
