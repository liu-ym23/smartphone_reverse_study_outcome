package androidx.datastore.preferences.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g1 {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f1815a = Logger.getLogger(g1.class.getName());

    /* renamed from: b, reason: collision with root package name */
    public static final Unsafe f1816b;

    /* renamed from: c, reason: collision with root package name */
    public static final Class<?> f1817c;

    /* renamed from: d, reason: collision with root package name */
    public static final e f1818d;

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f1819e;

    /* renamed from: f, reason: collision with root package name */
    public static final boolean f1820f;

    /* renamed from: g, reason: collision with root package name */
    public static final long f1821g;
    public static final boolean h;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a implements PrivilegedExceptionAction<Unsafe> {
        public static Unsafe a() throws IllegalAccessException, SecurityException, IllegalArgumentException {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            return null;
        }

        @Override // java.security.PrivilegedExceptionAction
        public final /* bridge */ /* synthetic */ Unsafe run() {
            return a();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b extends e {
        @Override // androidx.datastore.preferences.protobuf.g1.e
        public final boolean c(long j10, Object obj) {
            return g1.h ? g1.g(j10, obj) != 0 : g1.h(j10, obj) != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.g1.e
        public final byte d(long j10, Object obj) {
            return g1.h ? g1.g(j10, obj) : g1.h(j10, obj);
        }

        @Override // androidx.datastore.preferences.protobuf.g1.e
        public final double e(long j10, Object obj) {
            return Double.longBitsToDouble(h(j10, obj));
        }

        @Override // androidx.datastore.preferences.protobuf.g1.e
        public final float f(long j10, Object obj) {
            return Float.intBitsToFloat(g(j10, obj));
        }

        @Override // androidx.datastore.preferences.protobuf.g1.e
        public final void k(Object obj, long j10, boolean z) {
            if (g1.h) {
                g1.k(obj, j10, z ? (byte) 1 : (byte) 0);
            } else {
                g1.l(obj, j10, z ? (byte) 1 : (byte) 0);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.g1.e
        public final void l(Object obj, long j10, byte b10) {
            if (g1.h) {
                g1.k(obj, j10, b10);
            } else {
                g1.l(obj, j10, b10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.g1.e
        public final void m(Object obj, long j10, double d8) {
            p(j10, Double.doubleToLongBits(d8), obj);
        }

        @Override // androidx.datastore.preferences.protobuf.g1.e
        public final void n(Object obj, long j10, float f8) {
            o(j10, Float.floatToIntBits(f8), obj);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class c extends e {
        @Override // androidx.datastore.preferences.protobuf.g1.e
        public final boolean c(long j10, Object obj) {
            return g1.h ? g1.g(j10, obj) != 0 : g1.h(j10, obj) != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.g1.e
        public final byte d(long j10, Object obj) {
            return g1.h ? g1.g(j10, obj) : g1.h(j10, obj);
        }

        @Override // androidx.datastore.preferences.protobuf.g1.e
        public final double e(long j10, Object obj) {
            return Double.longBitsToDouble(h(j10, obj));
        }

        @Override // androidx.datastore.preferences.protobuf.g1.e
        public final float f(long j10, Object obj) {
            return Float.intBitsToFloat(g(j10, obj));
        }

        @Override // androidx.datastore.preferences.protobuf.g1.e
        public final void k(Object obj, long j10, boolean z) {
            if (g1.h) {
                g1.k(obj, j10, z ? (byte) 1 : (byte) 0);
            } else {
                g1.l(obj, j10, z ? (byte) 1 : (byte) 0);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.g1.e
        public final void l(Object obj, long j10, byte b10) {
            if (g1.h) {
                g1.k(obj, j10, b10);
            } else {
                g1.l(obj, j10, b10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.g1.e
        public final void m(Object obj, long j10, double d8) {
            p(j10, Double.doubleToLongBits(d8), obj);
        }

        @Override // androidx.datastore.preferences.protobuf.g1.e
        public final void n(Object obj, long j10, float f8) {
            o(j10, Float.floatToIntBits(f8), obj);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class d extends e {
        @Override // androidx.datastore.preferences.protobuf.g1.e
        public final boolean c(long j10, Object obj) {
            return this.f1822a.getBoolean(obj, j10);
        }

        @Override // androidx.datastore.preferences.protobuf.g1.e
        public final byte d(long j10, Object obj) {
            return this.f1822a.getByte(obj, j10);
        }

        @Override // androidx.datastore.preferences.protobuf.g1.e
        public final double e(long j10, Object obj) {
            return this.f1822a.getDouble(obj, j10);
        }

        @Override // androidx.datastore.preferences.protobuf.g1.e
        public final float f(long j10, Object obj) {
            return this.f1822a.getFloat(obj, j10);
        }

        @Override // androidx.datastore.preferences.protobuf.g1.e
        public final void k(Object obj, long j10, boolean z) {
            this.f1822a.putBoolean(obj, j10, z);
        }

        @Override // androidx.datastore.preferences.protobuf.g1.e
        public final void l(Object obj, long j10, byte b10) {
            this.f1822a.putByte(obj, j10, b10);
        }

        @Override // androidx.datastore.preferences.protobuf.g1.e
        public final void m(Object obj, long j10, double d8) {
            this.f1822a.putDouble(obj, j10, d8);
        }

        @Override // androidx.datastore.preferences.protobuf.g1.e
        public final void n(Object obj, long j10, float f8) {
            this.f1822a.putFloat(obj, j10, f8);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class e {

        /* renamed from: a, reason: collision with root package name */
        public final Unsafe f1822a;

        public e(Unsafe unsafe) {
            this.f1822a = unsafe;
        }

        public final int a(Class<?> cls) {
            return this.f1822a.arrayBaseOffset(cls);
        }

        public final int b(Class<?> cls) {
            return this.f1822a.arrayIndexScale(cls);
        }

        public abstract boolean c(long j10, Object obj);

        public abstract byte d(long j10, Object obj);

        public abstract double e(long j10, Object obj);

        public abstract float f(long j10, Object obj);

        public final int g(long j10, Object obj) {
            return this.f1822a.getInt(obj, j10);
        }

        public final long h(long j10, Object obj) {
            return this.f1822a.getLong(obj, j10);
        }

        public final Object i(long j10, Object obj) {
            return this.f1822a.getObject(obj, j10);
        }

        public final long j(Field field) {
            return this.f1822a.objectFieldOffset(field);
        }

        public abstract void k(Object obj, long j10, boolean z);

        public abstract void l(Object obj, long j10, byte b10);

        public abstract void m(Object obj, long j10, double d8);

        public abstract void n(Object obj, long j10, float f8);

        public final void o(long j10, int i10, Object obj) {
            this.f1822a.putInt(obj, j10, i10);
        }

        public final void p(long j10, long j11, Object obj) {
            this.f1822a.putLong(obj, j10, j11);
        }

        public final void q(long j10, Object obj, Object obj2) {
            this.f1822a.putObject(obj, j10, obj2);
        }
    }

    static {
        Class cls;
        Class<?> cls2;
        boolean z;
        boolean z3;
        e eVar;
        Unsafe unsafeI = i();
        f1816b = unsafeI;
        f1817c = androidx.datastore.preferences.protobuf.d.f1798a;
        Class cls3 = Long.TYPE;
        boolean zE = e(cls3);
        Class cls4 = Integer.TYPE;
        boolean zE2 = e(cls4);
        e dVar = null;
        if (unsafeI != null) {
            if (!androidx.datastore.preferences.protobuf.d.a()) {
                dVar = new d(unsafeI);
            } else if (zE) {
                dVar = new c(unsafeI);
            } else if (zE2) {
                dVar = new b(unsafeI);
            }
        }
        f1818d = dVar;
        Class cls5 = Byte.TYPE;
        if (unsafeI == null) {
            cls = Field.class;
            z = false;
        } else {
            try {
                cls2 = unsafeI.getClass();
                cls2.getMethod("objectFieldOffset", Field.class);
                cls2.getMethod("getLong", Object.class, cls3);
            } catch (Throwable th) {
                cls = Field.class;
                f1815a.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
            }
            if (d() == null) {
                cls = Field.class;
                z = false;
            } else {
                if (!androidx.datastore.preferences.protobuf.d.a()) {
                    cls2.getMethod("getByte", cls3);
                    cls2.getMethod("putByte", cls3, cls5);
                    cls2.getMethod("getInt", cls3);
                    cls2.getMethod("putInt", cls3, cls4);
                    cls2.getMethod("getLong", cls3);
                    cls2.getMethod("putLong", cls3, cls3);
                    cls2.getMethod("copyMemory", cls3, cls3, cls3);
                    cls2.getMethod("copyMemory", Object.class, cls3, Object.class, cls3, cls3);
                }
                cls = Field.class;
                z = true;
            }
        }
        f1819e = z;
        Unsafe unsafe = f1816b;
        if (unsafe == null) {
            z3 = false;
        } else {
            try {
                Class<?> cls6 = unsafe.getClass();
                cls6.getMethod("objectFieldOffset", cls);
                cls6.getMethod("arrayBaseOffset", Class.class);
                cls6.getMethod("arrayIndexScale", Class.class);
                cls6.getMethod("getInt", Object.class, cls3);
                cls6.getMethod("putInt", Object.class, cls3, cls4);
                cls6.getMethod("getLong", Object.class, cls3);
                cls6.getMethod("putLong", Object.class, cls3, cls3);
                cls6.getMethod("getObject", Object.class, cls3);
                cls6.getMethod("putObject", Object.class, cls3, Object.class);
                if (!androidx.datastore.preferences.protobuf.d.a()) {
                    cls6.getMethod("getByte", Object.class, cls3);
                    cls6.getMethod("putByte", Object.class, cls3, cls5);
                    cls6.getMethod("getBoolean", Object.class, cls3);
                    cls6.getMethod("putBoolean", Object.class, cls3, Boolean.TYPE);
                    cls6.getMethod("getFloat", Object.class, cls3);
                    cls6.getMethod("putFloat", Object.class, cls3, Float.TYPE);
                    cls6.getMethod("getDouble", Object.class, cls3);
                    cls6.getMethod("putDouble", Object.class, cls3, Double.TYPE);
                }
                z3 = true;
            } catch (Throwable th2) {
                f1815a.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th2);
            }
        }
        f1820f = z3;
        f1821g = b(byte[].class);
        b(boolean[].class);
        c(boolean[].class);
        b(int[].class);
        c(int[].class);
        b(long[].class);
        c(long[].class);
        b(float[].class);
        c(float[].class);
        b(double[].class);
        c(double[].class);
        b(Object[].class);
        c(Object[].class);
        Field fieldD = d();
        if (fieldD != null && (eVar = f1818d) != null) {
            eVar.j(fieldD);
        }
        h = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static <T> T a(Class<T> cls) {
        try {
            return (T) f1816b.allocateInstance(cls);
        } catch (InstantiationException e10) {
            throw new IllegalStateException(e10);
        }
    }

    public static int b(Class<?> cls) {
        if (f1820f) {
            return f1818d.a(cls);
        }
        return -1;
    }

    public static void c(Class cls) {
        if (f1820f) {
            f1818d.b(cls);
        }
    }

    public static Field d() {
        Field declaredField;
        Field declaredField2;
        if (androidx.datastore.preferences.protobuf.d.a()) {
            try {
                declaredField2 = Buffer.class.getDeclaredField("effectiveDirectAddress");
            } catch (Throwable unused) {
                declaredField2 = null;
            }
            if (declaredField2 != null) {
                return declaredField2;
            }
        }
        try {
            declaredField = Buffer.class.getDeclaredField("address");
        } catch (Throwable unused2) {
            declaredField = null;
        }
        if (declaredField == null || declaredField.getType() != Long.TYPE) {
            return null;
        }
        return declaredField;
    }

    public static boolean e(Class<?> cls) {
        if (!androidx.datastore.preferences.protobuf.d.a()) {
            return false;
        }
        try {
            Class<?> cls2 = f1817c;
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

    public static byte f(byte[] bArr, long j10) {
        return f1818d.d(f1821g + j10, bArr);
    }

    public static byte g(long j10, Object obj) {
        return (byte) ((f1818d.g((-4) & j10, obj) >>> ((int) (((~j10) & 3) << 3))) & 255);
    }

    public static byte h(long j10, Object obj) {
        return (byte) ((f1818d.g((-4) & j10, obj) >>> ((int) ((j10 & 3) << 3))) & 255);
    }

    public static Unsafe i() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void j(byte[] bArr, long j10, byte b10) {
        f1818d.l(bArr, f1821g + j10, b10);
    }

    public static void k(Object obj, long j10, byte b10) {
        long j11 = (-4) & j10;
        int iG = f1818d.g(j11, obj);
        int i10 = ((~((int) j10)) & 3) << 3;
        m(j11, ((255 & b10) << i10) | (iG & (~(255 << i10))), obj);
    }

    public static void l(Object obj, long j10, byte b10) {
        long j11 = (-4) & j10;
        int i10 = (((int) j10) & 3) << 3;
        m(j11, ((255 & b10) << i10) | (f1818d.g(j11, obj) & (~(255 << i10))), obj);
    }

    public static void m(long j10, int i10, Object obj) {
        f1818d.o(j10, i10, obj);
    }

    public static void n(long j10, long j11, Object obj) {
        f1818d.p(j10, j11, obj);
    }

    public static void o(long j10, Object obj, Object obj2) {
        f1818d.q(j10, obj, obj2);
    }
}
