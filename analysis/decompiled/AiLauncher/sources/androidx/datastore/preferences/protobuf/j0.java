package androidx.datastore.preferences.protobuf;

import com.autonavi.aps.amapapi.config.Const;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
public final class j0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f13590a = Logger.getLogger(j0.class.getName());

    /* renamed from: b, reason: collision with root package name */
    public static final Unsafe f13591b = B();

    /* renamed from: c, reason: collision with root package name */
    public static final Class<?> f13592c = C1341d.b();

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f13593d = m(Long.TYPE);

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f13594e = m(Integer.TYPE);

    /* renamed from: f, reason: collision with root package name */
    public static final e f13595f = z();

    /* renamed from: g, reason: collision with root package name */
    public static final boolean f13596g = Q();

    /* renamed from: h, reason: collision with root package name */
    public static final boolean f13597h = P();

    /* renamed from: i, reason: collision with root package name */
    public static final long f13598i;

    /* renamed from: j, reason: collision with root package name */
    public static final long f13599j;

    /* renamed from: k, reason: collision with root package name */
    public static final long f13600k;

    /* renamed from: l, reason: collision with root package name */
    public static final long f13601l;

    /* renamed from: m, reason: collision with root package name */
    public static final long f13602m;

    /* renamed from: n, reason: collision with root package name */
    public static final long f13603n;

    /* renamed from: o, reason: collision with root package name */
    public static final long f13604o;

    /* renamed from: p, reason: collision with root package name */
    public static final long f13605p;

    /* renamed from: q, reason: collision with root package name */
    public static final long f13606q;

    /* renamed from: r, reason: collision with root package name */
    public static final long f13607r;

    /* renamed from: s, reason: collision with root package name */
    public static final long f13608s;

    /* renamed from: t, reason: collision with root package name */
    public static final long f13609t;

    /* renamed from: u, reason: collision with root package name */
    public static final long f13610u;

    /* renamed from: v, reason: collision with root package name */
    public static final long f13611v;

    /* renamed from: w, reason: collision with root package name */
    public static final int f13612w;

    /* renamed from: x, reason: collision with root package name */
    public static final boolean f13613x;

    public static class a implements PrivilegedExceptionAction<Unsafe> {
        @Override // java.security.PrivilegedExceptionAction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unsafe run() throws Exception {
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

    public static final class b extends e {
        public b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // androidx.datastore.preferences.protobuf.j0.e
        public boolean c(Object obj, long j10) {
            return j0.f13613x ? j0.q(obj, j10) : j0.r(obj, j10);
        }

        @Override // androidx.datastore.preferences.protobuf.j0.e
        public byte d(Object obj, long j10) {
            return j0.f13613x ? j0.t(obj, j10) : j0.u(obj, j10);
        }

        @Override // androidx.datastore.preferences.protobuf.j0.e
        public double e(Object obj, long j10) {
            return Double.longBitsToDouble(h(obj, j10));
        }

        @Override // androidx.datastore.preferences.protobuf.j0.e
        public float f(Object obj, long j10) {
            return Float.intBitsToFloat(g(obj, j10));
        }

        @Override // androidx.datastore.preferences.protobuf.j0.e
        public void k(Object obj, long j10, boolean z10) {
            if (j0.f13613x) {
                j0.F(obj, j10, z10);
            } else {
                j0.G(obj, j10, z10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.j0.e
        public void l(Object obj, long j10, byte b10) {
            if (j0.f13613x) {
                j0.I(obj, j10, b10);
            } else {
                j0.J(obj, j10, b10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.j0.e
        public void m(Object obj, long j10, double d10) {
            p(obj, j10, Double.doubleToLongBits(d10));
        }

        @Override // androidx.datastore.preferences.protobuf.j0.e
        public void n(Object obj, long j10, float f10) {
            o(obj, j10, Float.floatToIntBits(f10));
        }
    }

    public static final class c extends e {
        public c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // androidx.datastore.preferences.protobuf.j0.e
        public boolean c(Object obj, long j10) {
            return j0.f13613x ? j0.q(obj, j10) : j0.r(obj, j10);
        }

        @Override // androidx.datastore.preferences.protobuf.j0.e
        public byte d(Object obj, long j10) {
            return j0.f13613x ? j0.t(obj, j10) : j0.u(obj, j10);
        }

        @Override // androidx.datastore.preferences.protobuf.j0.e
        public double e(Object obj, long j10) {
            return Double.longBitsToDouble(h(obj, j10));
        }

        @Override // androidx.datastore.preferences.protobuf.j0.e
        public float f(Object obj, long j10) {
            return Float.intBitsToFloat(g(obj, j10));
        }

        @Override // androidx.datastore.preferences.protobuf.j0.e
        public void k(Object obj, long j10, boolean z10) {
            if (j0.f13613x) {
                j0.F(obj, j10, z10);
            } else {
                j0.G(obj, j10, z10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.j0.e
        public void l(Object obj, long j10, byte b10) {
            if (j0.f13613x) {
                j0.I(obj, j10, b10);
            } else {
                j0.J(obj, j10, b10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.j0.e
        public void m(Object obj, long j10, double d10) {
            p(obj, j10, Double.doubleToLongBits(d10));
        }

        @Override // androidx.datastore.preferences.protobuf.j0.e
        public void n(Object obj, long j10, float f10) {
            o(obj, j10, Float.floatToIntBits(f10));
        }
    }

    public static final class d extends e {
        public d(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // androidx.datastore.preferences.protobuf.j0.e
        public boolean c(Object obj, long j10) {
            return this.f13614a.getBoolean(obj, j10);
        }

        @Override // androidx.datastore.preferences.protobuf.j0.e
        public byte d(Object obj, long j10) {
            return this.f13614a.getByte(obj, j10);
        }

        @Override // androidx.datastore.preferences.protobuf.j0.e
        public double e(Object obj, long j10) {
            return this.f13614a.getDouble(obj, j10);
        }

        @Override // androidx.datastore.preferences.protobuf.j0.e
        public float f(Object obj, long j10) {
            return this.f13614a.getFloat(obj, j10);
        }

        @Override // androidx.datastore.preferences.protobuf.j0.e
        public void k(Object obj, long j10, boolean z10) {
            this.f13614a.putBoolean(obj, j10, z10);
        }

        @Override // androidx.datastore.preferences.protobuf.j0.e
        public void l(Object obj, long j10, byte b10) {
            this.f13614a.putByte(obj, j10, b10);
        }

        @Override // androidx.datastore.preferences.protobuf.j0.e
        public void m(Object obj, long j10, double d10) {
            this.f13614a.putDouble(obj, j10, d10);
        }

        @Override // androidx.datastore.preferences.protobuf.j0.e
        public void n(Object obj, long j10, float f10) {
            this.f13614a.putFloat(obj, j10, f10);
        }
    }

    public static abstract class e {

        /* renamed from: a, reason: collision with root package name */
        public Unsafe f13614a;

        public e(Unsafe unsafe) {
            this.f13614a = unsafe;
        }

        public final int a(Class<?> cls) {
            return this.f13614a.arrayBaseOffset(cls);
        }

        public final int b(Class<?> cls) {
            return this.f13614a.arrayIndexScale(cls);
        }

        public abstract boolean c(Object obj, long j10);

        public abstract byte d(Object obj, long j10);

        public abstract double e(Object obj, long j10);

        public abstract float f(Object obj, long j10);

        public final int g(Object obj, long j10) {
            return this.f13614a.getInt(obj, j10);
        }

        public final long h(Object obj, long j10) {
            return this.f13614a.getLong(obj, j10);
        }

        public final Object i(Object obj, long j10) {
            return this.f13614a.getObject(obj, j10);
        }

        public final long j(Field field) {
            return this.f13614a.objectFieldOffset(field);
        }

        public abstract void k(Object obj, long j10, boolean z10);

        public abstract void l(Object obj, long j10, byte b10);

        public abstract void m(Object obj, long j10, double d10);

        public abstract void n(Object obj, long j10, float f10);

        public final void o(Object obj, long j10, int i10) {
            this.f13614a.putInt(obj, j10, i10);
        }

        public final void p(Object obj, long j10, long j11) {
            this.f13614a.putLong(obj, j10, j11);
        }

        public final void q(Object obj, long j10, Object obj2) {
            this.f13614a.putObject(obj, j10, obj2);
        }
    }

    static {
        long j10 = j(byte[].class);
        f13598i = j10;
        f13599j = j(boolean[].class);
        f13600k = k(boolean[].class);
        f13601l = j(int[].class);
        f13602m = k(int[].class);
        f13603n = j(long[].class);
        f13604o = k(long[].class);
        f13605p = j(float[].class);
        f13606q = k(float[].class);
        f13607r = j(double[].class);
        f13608s = k(double[].class);
        f13609t = j(Object[].class);
        f13610u = k(Object[].class);
        f13611v = o(l());
        f13612w = (int) (j10 & 7);
        f13613x = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static Object A(Object obj, long j10) {
        return f13595f.i(obj, j10);
    }

    public static Unsafe B() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean C() {
        return f13597h;
    }

    public static boolean D() {
        return f13596g;
    }

    public static void E(Object obj, long j10, boolean z10) {
        f13595f.k(obj, j10, z10);
    }

    public static void F(Object obj, long j10, boolean z10) {
        I(obj, j10, z10 ? (byte) 1 : (byte) 0);
    }

    public static void G(Object obj, long j10, boolean z10) {
        J(obj, j10, z10 ? (byte) 1 : (byte) 0);
    }

    public static void H(byte[] bArr, long j10, byte b10) {
        f13595f.l(bArr, f13598i + j10, b10);
    }

    public static void I(Object obj, long j10, byte b10) {
        long j11 = (-4) & j10;
        int iX = x(obj, j11);
        int i10 = ((~((int) j10)) & 3) << 3;
        M(obj, j11, ((255 & b10) << i10) | (iX & (~(255 << i10))));
    }

    public static void J(Object obj, long j10, byte b10) {
        long j11 = (-4) & j10;
        int i10 = (((int) j10) & 3) << 3;
        M(obj, j11, ((255 & b10) << i10) | (x(obj, j11) & (~(255 << i10))));
    }

    public static void K(Object obj, long j10, double d10) {
        f13595f.m(obj, j10, d10);
    }

    public static void L(Object obj, long j10, float f10) {
        f13595f.n(obj, j10, f10);
    }

    public static void M(Object obj, long j10, int i10) {
        f13595f.o(obj, j10, i10);
    }

    public static void N(Object obj, long j10, long j11) {
        f13595f.p(obj, j10, j11);
    }

    public static void O(Object obj, long j10, Object obj2) {
        f13595f.q(obj, j10, obj2);
    }

    public static boolean P() {
        Unsafe unsafe = f13591b;
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
            if (C1341d.c()) {
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
            f13590a.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
            return false;
        }
    }

    public static boolean Q() {
        Unsafe unsafe = f13591b;
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
            if (C1341d.c()) {
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
            f13590a.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
            return false;
        }
    }

    public static <T> T i(Class<T> cls) {
        try {
            return (T) f13591b.allocateInstance(cls);
        } catch (InstantiationException e10) {
            throw new IllegalStateException(e10);
        }
    }

    public static int j(Class<?> cls) {
        if (f13597h) {
            return f13595f.a(cls);
        }
        return -1;
    }

    public static int k(Class<?> cls) {
        if (f13597h) {
            return f13595f.b(cls);
        }
        return -1;
    }

    public static Field l() {
        Field fieldN;
        if (C1341d.c() && (fieldN = n(Buffer.class, "effectiveDirectAddress")) != null) {
            return fieldN;
        }
        Field fieldN2 = n(Buffer.class, Const.JSON_KEY_ADDRESS);
        if (fieldN2 == null || fieldN2.getType() != Long.TYPE) {
            return null;
        }
        return fieldN2;
    }

    public static boolean m(Class<?> cls) {
        if (!C1341d.c()) {
            return false;
        }
        try {
            Class<?> cls2 = f13592c;
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

    public static Field n(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static long o(Field field) {
        e eVar;
        if (field == null || (eVar = f13595f) == null) {
            return -1L;
        }
        return eVar.j(field);
    }

    public static boolean p(Object obj, long j10) {
        return f13595f.c(obj, j10);
    }

    public static boolean q(Object obj, long j10) {
        return t(obj, j10) != 0;
    }

    public static boolean r(Object obj, long j10) {
        return u(obj, j10) != 0;
    }

    public static byte s(byte[] bArr, long j10) {
        return f13595f.d(bArr, f13598i + j10);
    }

    public static byte t(Object obj, long j10) {
        return (byte) ((x(obj, (-4) & j10) >>> ((int) (((~j10) & 3) << 3))) & 255);
    }

    public static byte u(Object obj, long j10) {
        return (byte) ((x(obj, (-4) & j10) >>> ((int) ((j10 & 3) << 3))) & 255);
    }

    public static double v(Object obj, long j10) {
        return f13595f.e(obj, j10);
    }

    public static float w(Object obj, long j10) {
        return f13595f.f(obj, j10);
    }

    public static int x(Object obj, long j10) {
        return f13595f.g(obj, j10);
    }

    public static long y(Object obj, long j10) {
        return f13595f.h(obj, j10);
    }

    public static e z() {
        Unsafe unsafe = f13591b;
        if (unsafe == null) {
            return null;
        }
        if (!C1341d.c()) {
            return new d(unsafe);
        }
        if (f13593d) {
            return new c(unsafe);
        }
        if (f13594e) {
            return new b(unsafe);
        }
        return null;
    }
}
