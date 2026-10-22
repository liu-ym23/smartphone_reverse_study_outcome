package androidx.datastore.preferences.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
final class s0 {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f10121a = Logger.getLogger(s0.class.getName());

    /* renamed from: b, reason: collision with root package name */
    private static final Unsafe f10122b = B();

    /* renamed from: c, reason: collision with root package name */
    private static final Class<?> f10123c = C0484d.b();

    /* renamed from: d, reason: collision with root package name */
    private static final boolean f10124d = m(Long.TYPE);

    /* renamed from: e, reason: collision with root package name */
    private static final boolean f10125e = m(Integer.TYPE);

    /* renamed from: f, reason: collision with root package name */
    private static final e f10126f = z();

    /* renamed from: g, reason: collision with root package name */
    private static final boolean f10127g = Q();

    /* renamed from: h, reason: collision with root package name */
    private static final boolean f10128h = P();

    /* renamed from: i, reason: collision with root package name */
    static final long f10129i;

    /* renamed from: j, reason: collision with root package name */
    private static final long f10130j;

    /* renamed from: k, reason: collision with root package name */
    private static final long f10131k;

    /* renamed from: l, reason: collision with root package name */
    private static final long f10132l;

    /* renamed from: m, reason: collision with root package name */
    private static final long f10133m;

    /* renamed from: n, reason: collision with root package name */
    private static final long f10134n;

    /* renamed from: o, reason: collision with root package name */
    private static final long f10135o;

    /* renamed from: p, reason: collision with root package name */
    private static final long f10136p;

    /* renamed from: q, reason: collision with root package name */
    private static final long f10137q;

    /* renamed from: r, reason: collision with root package name */
    private static final long f10138r;

    /* renamed from: s, reason: collision with root package name */
    private static final long f10139s;

    /* renamed from: t, reason: collision with root package name */
    private static final long f10140t;

    /* renamed from: u, reason: collision with root package name */
    private static final long f10141u;

    /* renamed from: v, reason: collision with root package name */
    private static final long f10142v;

    /* renamed from: w, reason: collision with root package name */
    private static final int f10143w;

    /* renamed from: x, reason: collision with root package name */
    static final boolean f10144x;

    static class a implements PrivilegedExceptionAction<Unsafe> {
        a() {
        }

        @Override // java.security.PrivilegedExceptionAction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unsafe run() throws IllegalAccessException, SecurityException, IllegalArgumentException {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            return null;
        }
    }

    private static final class b extends e {
        b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // androidx.datastore.preferences.protobuf.s0.e
        public boolean c(Object obj, long j5) {
            return s0.f10144x ? s0.q(obj, j5) : s0.r(obj, j5);
        }

        @Override // androidx.datastore.preferences.protobuf.s0.e
        public byte d(Object obj, long j5) {
            return s0.f10144x ? s0.t(obj, j5) : s0.u(obj, j5);
        }

        @Override // androidx.datastore.preferences.protobuf.s0.e
        public double e(Object obj, long j5) {
            return Double.longBitsToDouble(h(obj, j5));
        }

        @Override // androidx.datastore.preferences.protobuf.s0.e
        public float f(Object obj, long j5) {
            return Float.intBitsToFloat(g(obj, j5));
        }

        @Override // androidx.datastore.preferences.protobuf.s0.e
        public void k(Object obj, long j5, boolean z5) {
            if (s0.f10144x) {
                s0.F(obj, j5, z5);
            } else {
                s0.G(obj, j5, z5);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.s0.e
        public void l(Object obj, long j5, byte b6) {
            if (s0.f10144x) {
                s0.I(obj, j5, b6);
            } else {
                s0.J(obj, j5, b6);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.s0.e
        public void m(Object obj, long j5, double d6) {
            p(obj, j5, Double.doubleToLongBits(d6));
        }

        @Override // androidx.datastore.preferences.protobuf.s0.e
        public void n(Object obj, long j5, float f5) {
            o(obj, j5, Float.floatToIntBits(f5));
        }
    }

    private static final class c extends e {
        c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // androidx.datastore.preferences.protobuf.s0.e
        public boolean c(Object obj, long j5) {
            return s0.f10144x ? s0.q(obj, j5) : s0.r(obj, j5);
        }

        @Override // androidx.datastore.preferences.protobuf.s0.e
        public byte d(Object obj, long j5) {
            return s0.f10144x ? s0.t(obj, j5) : s0.u(obj, j5);
        }

        @Override // androidx.datastore.preferences.protobuf.s0.e
        public double e(Object obj, long j5) {
            return Double.longBitsToDouble(h(obj, j5));
        }

        @Override // androidx.datastore.preferences.protobuf.s0.e
        public float f(Object obj, long j5) {
            return Float.intBitsToFloat(g(obj, j5));
        }

        @Override // androidx.datastore.preferences.protobuf.s0.e
        public void k(Object obj, long j5, boolean z5) {
            if (s0.f10144x) {
                s0.F(obj, j5, z5);
            } else {
                s0.G(obj, j5, z5);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.s0.e
        public void l(Object obj, long j5, byte b6) {
            if (s0.f10144x) {
                s0.I(obj, j5, b6);
            } else {
                s0.J(obj, j5, b6);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.s0.e
        public void m(Object obj, long j5, double d6) {
            p(obj, j5, Double.doubleToLongBits(d6));
        }

        @Override // androidx.datastore.preferences.protobuf.s0.e
        public void n(Object obj, long j5, float f5) {
            o(obj, j5, Float.floatToIntBits(f5));
        }
    }

    private static final class d extends e {
        d(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // androidx.datastore.preferences.protobuf.s0.e
        public boolean c(Object obj, long j5) {
            return this.f10145a.getBoolean(obj, j5);
        }

        @Override // androidx.datastore.preferences.protobuf.s0.e
        public byte d(Object obj, long j5) {
            return this.f10145a.getByte(obj, j5);
        }

        @Override // androidx.datastore.preferences.protobuf.s0.e
        public double e(Object obj, long j5) {
            return this.f10145a.getDouble(obj, j5);
        }

        @Override // androidx.datastore.preferences.protobuf.s0.e
        public float f(Object obj, long j5) {
            return this.f10145a.getFloat(obj, j5);
        }

        @Override // androidx.datastore.preferences.protobuf.s0.e
        public void k(Object obj, long j5, boolean z5) {
            this.f10145a.putBoolean(obj, j5, z5);
        }

        @Override // androidx.datastore.preferences.protobuf.s0.e
        public void l(Object obj, long j5, byte b6) {
            this.f10145a.putByte(obj, j5, b6);
        }

        @Override // androidx.datastore.preferences.protobuf.s0.e
        public void m(Object obj, long j5, double d6) {
            this.f10145a.putDouble(obj, j5, d6);
        }

        @Override // androidx.datastore.preferences.protobuf.s0.e
        public void n(Object obj, long j5, float f5) {
            this.f10145a.putFloat(obj, j5, f5);
        }
    }

    private static abstract class e {

        /* renamed from: a, reason: collision with root package name */
        Unsafe f10145a;

        e(Unsafe unsafe) {
            this.f10145a = unsafe;
        }

        public final int a(Class<?> cls) {
            return this.f10145a.arrayBaseOffset(cls);
        }

        public final int b(Class<?> cls) {
            return this.f10145a.arrayIndexScale(cls);
        }

        public abstract boolean c(Object obj, long j5);

        public abstract byte d(Object obj, long j5);

        public abstract double e(Object obj, long j5);

        public abstract float f(Object obj, long j5);

        public final int g(Object obj, long j5) {
            return this.f10145a.getInt(obj, j5);
        }

        public final long h(Object obj, long j5) {
            return this.f10145a.getLong(obj, j5);
        }

        public final Object i(Object obj, long j5) {
            return this.f10145a.getObject(obj, j5);
        }

        public final long j(Field field) {
            return this.f10145a.objectFieldOffset(field);
        }

        public abstract void k(Object obj, long j5, boolean z5);

        public abstract void l(Object obj, long j5, byte b6);

        public abstract void m(Object obj, long j5, double d6);

        public abstract void n(Object obj, long j5, float f5);

        public final void o(Object obj, long j5, int i5) {
            this.f10145a.putInt(obj, j5, i5);
        }

        public final void p(Object obj, long j5, long j6) {
            this.f10145a.putLong(obj, j5, j6);
        }

        public final void q(Object obj, long j5, Object obj2) {
            this.f10145a.putObject(obj, j5, obj2);
        }
    }

    static {
        long j5 = j(byte[].class);
        f10129i = j5;
        f10130j = j(boolean[].class);
        f10131k = k(boolean[].class);
        f10132l = j(int[].class);
        f10133m = k(int[].class);
        f10134n = j(long[].class);
        f10135o = k(long[].class);
        f10136p = j(float[].class);
        f10137q = k(float[].class);
        f10138r = j(double[].class);
        f10139s = k(double[].class);
        f10140t = j(Object[].class);
        f10141u = k(Object[].class);
        f10142v = o(l());
        f10143w = (int) (j5 & 7);
        f10144x = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private s0() {
    }

    static Object A(Object obj, long j5) {
        return f10126f.i(obj, j5);
    }

    static Unsafe B() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean C() {
        return f10128h;
    }

    static boolean D() {
        return f10127g;
    }

    static void E(Object obj, long j5, boolean z5) {
        f10126f.k(obj, j5, z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void F(Object obj, long j5, boolean z5) {
        I(obj, j5, z5 ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void G(Object obj, long j5, boolean z5) {
        J(obj, j5, z5 ? (byte) 1 : (byte) 0);
    }

    static void H(byte[] bArr, long j5, byte b6) {
        f10126f.l(bArr, f10129i + j5, b6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void I(Object obj, long j5, byte b6) {
        long j6 = (-4) & j5;
        int iX = x(obj, j6);
        int i5 = ((~((int) j5)) & 3) << 3;
        M(obj, j6, ((255 & b6) << i5) | (iX & (~(255 << i5))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void J(Object obj, long j5, byte b6) {
        long j6 = (-4) & j5;
        int i5 = (((int) j5) & 3) << 3;
        M(obj, j6, ((255 & b6) << i5) | (x(obj, j6) & (~(255 << i5))));
    }

    static void K(Object obj, long j5, double d6) {
        f10126f.m(obj, j5, d6);
    }

    static void L(Object obj, long j5, float f5) {
        f10126f.n(obj, j5, f5);
    }

    static void M(Object obj, long j5, int i5) {
        f10126f.o(obj, j5, i5);
    }

    static void N(Object obj, long j5, long j6) {
        f10126f.p(obj, j5, j6);
    }

    static void O(Object obj, long j5, Object obj2) {
        f10126f.q(obj, j5, obj2);
    }

    private static boolean P() {
        Unsafe unsafe = f10122b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            Class cls2 = Long.TYPE;
            cls.getMethod("getInt", Object.class, cls2);
            cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
            cls.getMethod("getLong", Object.class, cls2);
            cls.getMethod("putLong", Object.class, cls2, cls2);
            cls.getMethod("getObject", Object.class, cls2);
            cls.getMethod("putObject", Object.class, cls2, Object.class);
            if (C0484d.c()) {
                return true;
            }
            cls.getMethod("getByte", Object.class, cls2);
            cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, cls2);
            cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, cls2);
            cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
            cls.getMethod("getDouble", Object.class, cls2);
            cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
            return true;
        } catch (Throwable th) {
            f10121a.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
            return false;
        }
    }

    private static boolean Q() {
        Unsafe unsafe = f10122b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            Class cls2 = Long.TYPE;
            cls.getMethod("getLong", Object.class, cls2);
            if (l() == null) {
                return false;
            }
            if (C0484d.c()) {
                return true;
            }
            cls.getMethod("getByte", cls2);
            cls.getMethod("putByte", cls2, Byte.TYPE);
            cls.getMethod("getInt", cls2);
            cls.getMethod("putInt", cls2, Integer.TYPE);
            cls.getMethod("getLong", cls2);
            cls.getMethod("putLong", cls2, cls2);
            cls.getMethod("copyMemory", cls2, cls2, cls2);
            cls.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
            return true;
        } catch (Throwable th) {
            f10121a.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
            return false;
        }
    }

    static <T> T i(Class<T> cls) {
        try {
            return (T) f10122b.allocateInstance(cls);
        } catch (InstantiationException e6) {
            throw new IllegalStateException(e6);
        }
    }

    private static int j(Class<?> cls) {
        if (f10128h) {
            return f10126f.a(cls);
        }
        return -1;
    }

    private static int k(Class<?> cls) {
        if (f10128h) {
            return f10126f.b(cls);
        }
        return -1;
    }

    private static Field l() {
        Field fieldN;
        if (C0484d.c() && (fieldN = n(Buffer.class, "effectiveDirectAddress")) != null) {
            return fieldN;
        }
        Field fieldN2 = n(Buffer.class, "address");
        if (fieldN2 == null || fieldN2.getType() != Long.TYPE) {
            return null;
        }
        return fieldN2;
    }

    private static boolean m(Class<?> cls) {
        if (!C0484d.c()) {
            return false;
        }
        try {
            Class<?> cls2 = f10123c;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Field n(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static long o(Field field) {
        e eVar;
        if (field == null || (eVar = f10126f) == null) {
            return -1L;
        }
        return eVar.j(field);
    }

    static boolean p(Object obj, long j5) {
        return f10126f.c(obj, j5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean q(Object obj, long j5) {
        return t(obj, j5) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean r(Object obj, long j5) {
        return u(obj, j5) != 0;
    }

    static byte s(byte[] bArr, long j5) {
        return f10126f.d(bArr, f10129i + j5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte t(Object obj, long j5) {
        return (byte) ((x(obj, (-4) & j5) >>> ((int) (((~j5) & 3) << 3))) & 255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte u(Object obj, long j5) {
        return (byte) ((x(obj, (-4) & j5) >>> ((int) ((j5 & 3) << 3))) & 255);
    }

    static double v(Object obj, long j5) {
        return f10126f.e(obj, j5);
    }

    static float w(Object obj, long j5) {
        return f10126f.f(obj, j5);
    }

    static int x(Object obj, long j5) {
        return f10126f.g(obj, j5);
    }

    static long y(Object obj, long j5) {
        return f10126f.h(obj, j5);
    }

    private static e z() {
        Unsafe unsafe = f10122b;
        if (unsafe == null) {
            return null;
        }
        if (!C0484d.c()) {
            return new d(unsafe);
        }
        if (f10124d) {
            return new c(unsafe);
        }
        if (f10125e) {
            return new b(unsafe);
        }
        return null;
    }
}
