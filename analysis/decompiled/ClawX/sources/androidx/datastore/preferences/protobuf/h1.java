package androidx.datastore.preferences.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class h1 {

    /* renamed from: a, reason: collision with root package name */
    public static final Unsafe f486a;

    /* renamed from: b, reason: collision with root package name */
    public static final Class f487b;

    /* renamed from: c, reason: collision with root package name */
    public static final g1 f488c;
    public static final boolean d;

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f489e;

    /* renamed from: f, reason: collision with root package name */
    public static final long f490f;

    /* renamed from: g, reason: collision with root package name */
    public static final boolean f491g;

    static {
        Unsafe unsafeI = i();
        f486a = unsafeI;
        f487b = c.f456a;
        boolean zH = h(Long.TYPE);
        boolean zH2 = h(Integer.TYPE);
        g1 f1Var = null;
        if (unsafeI != null) {
            if (!c.a()) {
                f1Var = new f1(unsafeI);
            } else if (zH) {
                f1Var = new e1(unsafeI, 1);
            } else if (zH2) {
                f1Var = new e1(unsafeI, 0);
            }
        }
        f488c = f1Var;
        d = f1Var == null ? false : f1Var.r();
        f489e = f1Var == null ? false : f1Var.q();
        f490f = e(byte[].class);
        e(boolean[].class);
        f(boolean[].class);
        e(int[].class);
        f(int[].class);
        e(long[].class);
        f(long[].class);
        e(float[].class);
        f(float[].class);
        e(double[].class);
        f(double[].class);
        e(Object[].class);
        f(Object[].class);
        Field fieldG = g();
        if (fieldG != null && f1Var != null) {
            f1Var.i(fieldG);
        }
        f491g = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static void a(Throwable th) {
        Logger.getLogger(h1.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    public static boolean b(Object obj, long j4) {
        return ((byte) ((f488c.f(obj, (-4) & j4) >>> ((int) (((~j4) & 3) << 3))) & 255)) != 0;
    }

    public static boolean c(Object obj, long j4) {
        return ((byte) ((f488c.f(obj, (-4) & j4) >>> ((int) ((j4 & 3) << 3))) & 255)) != 0;
    }

    public static Object d(Class cls) {
        try {
            return f486a.allocateInstance(cls);
        } catch (InstantiationException e9) {
            throw new IllegalStateException(e9);
        }
    }

    public static int e(Class cls) {
        if (f489e) {
            return f488c.a(cls);
        }
        return -1;
    }

    public static void f(Class cls) {
        if (f489e) {
            f488c.b(cls);
        }
    }

    public static Field g() {
        Field declaredField;
        Field declaredField2;
        if (c.a()) {
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

    public static boolean h(Class cls) {
        if (!c.a()) {
            return false;
        }
        try {
            Class cls2 = f487b;
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

    public static Unsafe i() {
        try {
            return (Unsafe) AccessController.doPrivileged(new d1());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void j(byte[] bArr, long j4, byte b9) {
        f488c.k(bArr, f490f + j4, b9);
    }

    public static void k(Object obj, long j4, byte b9) {
        long j8 = (-4) & j4;
        int iF = f488c.f(obj, j8);
        int i8 = ((~((int) j4)) & 3) << 3;
        m(((255 & b9) << i8) | (iF & (~(255 << i8))), j8, obj);
    }

    public static void l(Object obj, long j4, byte b9) {
        long j8 = (-4) & j4;
        int i8 = (((int) j4) & 3) << 3;
        m(((255 & b9) << i8) | (f488c.f(obj, j8) & (~(255 << i8))), j8, obj);
    }

    public static void m(int i8, long j4, Object obj) {
        f488c.n(i8, j4, obj);
    }

    public static void n(Object obj, long j4, long j8) {
        f488c.o(obj, j4, j8);
    }

    public static void o(long j4, Object obj, Object obj2) {
        f488c.p(j4, obj, obj2);
    }
}
