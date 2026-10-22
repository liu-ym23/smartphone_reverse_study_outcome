package androidx.datastore.preferences.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class j1 {

    /* renamed from: a, reason: collision with root package name */
    public static final Unsafe f1138a;

    /* renamed from: b, reason: collision with root package name */
    public static final Class f1139b;

    /* renamed from: c, reason: collision with root package name */
    public static final i1 f1140c;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f1141d;

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f1142e;

    /* renamed from: f, reason: collision with root package name */
    public static final long f1143f;

    /* renamed from: g, reason: collision with root package name */
    public static final boolean f1144g;

    static {
        Unsafe unsafeI = i();
        f1138a = unsafeI;
        f1139b = b.f1087a;
        boolean zH = h(Long.TYPE);
        boolean zH2 = h(Integer.TYPE);
        i1 h1Var = null;
        if (unsafeI != null) {
            if (!b.a()) {
                h1Var = new h1(unsafeI);
            } else if (zH) {
                h1Var = new g1(unsafeI, 1);
            } else if (zH2) {
                h1Var = new g1(unsafeI, 0);
            }
        }
        f1140c = h1Var;
        f1141d = h1Var == null ? false : h1Var.r();
        f1142e = h1Var == null ? false : h1Var.q();
        f1143f = e(byte[].class);
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
        if (fieldG != null && h1Var != null) {
            h1Var.i(fieldG);
        }
        f1144g = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static void a(Throwable th) {
        Logger.getLogger(j1.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    public static boolean b(Object obj, long j10) {
        return ((byte) ((f1140c.f(obj, (-4) & j10) >>> ((int) (((~j10) & 3) << 3))) & 255)) != 0;
    }

    public static boolean c(Object obj, long j10) {
        return ((byte) ((f1140c.f(obj, (-4) & j10) >>> ((int) ((j10 & 3) << 3))) & 255)) != 0;
    }

    public static Object d(Class cls) {
        try {
            return f1138a.allocateInstance(cls);
        } catch (InstantiationException e10) {
            throw new IllegalStateException(e10);
        }
    }

    public static int e(Class cls) {
        if (f1142e) {
            return f1140c.a(cls);
        }
        return -1;
    }

    public static void f(Class cls) {
        if (f1142e) {
            f1140c.b(cls);
        }
    }

    public static Field g() {
        Field declaredField;
        Field declaredField2;
        if (b.a()) {
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
        if (!b.a()) {
            return false;
        }
        try {
            Class cls2 = f1139b;
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
            return (Unsafe) AccessController.doPrivileged(new f1());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void j(byte[] bArr, long j10, byte b10) {
        f1140c.k(bArr, f1143f + j10, b10);
    }

    public static void k(Object obj, long j10, byte b10) {
        long j11 = (-4) & j10;
        int iF = f1140c.f(obj, j11);
        int i = ((~((int) j10)) & 3) << 3;
        m(obj, j11, ((255 & b10) << i) | (iF & (~(255 << i))));
    }

    public static void l(Object obj, long j10, byte b10) {
        long j11 = (-4) & j10;
        int i = (((int) j10) & 3) << 3;
        m(obj, j11, ((255 & b10) << i) | (f1140c.f(obj, j11) & (~(255 << i))));
    }

    public static void m(Object obj, long j10, int i) {
        f1140c.n(obj, j10, i);
    }

    public static void n(Object obj, long j10, long j11) {
        f1140c.o(obj, j10, j11);
    }

    public static void o(Object obj, long j10, Object obj2) {
        f1140c.p(obj, j10, obj2);
    }
}
