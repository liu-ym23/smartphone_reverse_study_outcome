package com.google.crypto.tink.shaded.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class n1 {

    /* renamed from: a, reason: collision with root package name */
    public static final Unsafe f1497a;

    /* renamed from: b, reason: collision with root package name */
    public static final Class f1498b;

    /* renamed from: c, reason: collision with root package name */
    public static final m1 f1499c;
    public static final boolean d;

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f1500e;

    /* renamed from: f, reason: collision with root package name */
    public static final long f1501f;

    /* renamed from: g, reason: collision with root package name */
    public static final boolean f1502g;

    static {
        Unsafe unsafeJ = j();
        f1497a = unsafeJ;
        f1498b = c.f1434a;
        boolean zF = f(Long.TYPE);
        boolean zF2 = f(Integer.TYPE);
        m1 l1Var = null;
        if (unsafeJ != null) {
            if (!c.a()) {
                l1Var = new l1(unsafeJ);
            } else if (zF) {
                l1Var = new k1(unsafeJ, 1);
            } else if (zF2) {
                l1Var = new k1(unsafeJ, 0);
            }
        }
        f1499c = l1Var;
        d = l1Var == null ? false : l1Var.s();
        f1500e = l1Var == null ? false : l1Var.r();
        f1501f = c(byte[].class);
        c(boolean[].class);
        d(boolean[].class);
        c(int[].class);
        d(int[].class);
        c(long[].class);
        d(long[].class);
        c(float[].class);
        d(float[].class);
        c(double[].class);
        d(double[].class);
        c(Object[].class);
        d(Object[].class);
        Field fieldE = e();
        if (fieldE != null && l1Var != null) {
            l1Var.j(fieldE);
        }
        f1502g = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static void a(Throwable th) {
        Logger.getLogger(n1.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    public static Object b(Class cls) {
        try {
            return f1497a.allocateInstance(cls);
        } catch (InstantiationException e9) {
            throw new IllegalStateException(e9);
        }
    }

    public static int c(Class cls) {
        if (f1500e) {
            return f1499c.a(cls);
        }
        return -1;
    }

    public static void d(Class cls) {
        if (f1500e) {
            f1499c.b(cls);
        }
    }

    public static Field e() {
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

    public static boolean f(Class cls) {
        if (!c.a()) {
            return false;
        }
        try {
            Class cls2 = f1498b;
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

    public static byte g(long j4, byte[] bArr) {
        return f1499c.d(bArr, f1501f + j4);
    }

    public static byte h(Object obj, long j4) {
        return (byte) ((f1499c.g(obj, (-4) & j4) >>> ((int) (((~j4) & 3) << 3))) & 255);
    }

    public static byte i(Object obj, long j4) {
        return (byte) ((f1499c.g(obj, (-4) & j4) >>> ((int) ((j4 & 3) << 3))) & 255);
    }

    public static Unsafe j() {
        try {
            return (Unsafe) AccessController.doPrivileged(new j1());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void k(byte[] bArr, long j4, byte b9) {
        f1499c.l(bArr, f1501f + j4, b9);
    }

    public static void l(Object obj, long j4, byte b9) {
        long j8 = (-4) & j4;
        int iG = f1499c.g(obj, j8);
        int i8 = ((~((int) j4)) & 3) << 3;
        n(((255 & b9) << i8) | (iG & (~(255 << i8))), j8, obj);
    }

    public static void m(Object obj, long j4, byte b9) {
        long j8 = (-4) & j4;
        int i8 = (((int) j4) & 3) << 3;
        n(((255 & b9) << i8) | (f1499c.g(obj, j8) & (~(255 << i8))), j8, obj);
    }

    public static void n(int i8, long j4, Object obj) {
        f1499c.o(i8, j4, obj);
    }

    public static void o(Object obj, long j4, long j8) {
        f1499c.p(obj, j4, j8);
    }

    public static void p(long j4, Object obj, Object obj2) {
        f1499c.q(j4, obj, obj2);
    }
}
