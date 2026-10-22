package com.google.crypto.tink.shaded.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
public abstract class m1 {

    /* renamed from: a, reason: collision with root package name */
    public static final Unsafe f2244a;

    /* renamed from: b, reason: collision with root package name */
    public static final Class f2245b;

    /* renamed from: c, reason: collision with root package name */
    public static final l1 f2246c;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f2247d;

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f2248e;

    /* renamed from: f, reason: collision with root package name */
    public static final long f2249f;

    /* renamed from: g, reason: collision with root package name */
    public static final boolean f2250g;

    static {
        Unsafe unsafeJ = j();
        f2244a = unsafeJ;
        f2245b = c.f2182a;
        boolean zF = f(Long.TYPE);
        boolean zF2 = f(Integer.TYPE);
        l1 k1Var = null;
        if (unsafeJ != null) {
            if (!c.a()) {
                k1Var = new k1(unsafeJ);
            } else if (zF) {
                k1Var = new j1(unsafeJ, 1);
            } else if (zF2) {
                k1Var = new j1(unsafeJ, 0);
            }
        }
        f2246c = k1Var;
        f2247d = k1Var == null ? false : k1Var.s();
        f2248e = k1Var == null ? false : k1Var.r();
        f2249f = c(byte[].class);
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
        if (fieldE != null && k1Var != null) {
            k1Var.j(fieldE);
        }
        f2250g = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static void a(Throwable th) {
        Logger.getLogger(m1.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    public static Object b(Class cls) {
        try {
            return f2244a.allocateInstance(cls);
        } catch (InstantiationException e10) {
            throw new IllegalStateException(e10);
        }
    }

    public static int c(Class cls) {
        if (f2248e) {
            return f2246c.a(cls);
        }
        return -1;
    }

    public static void d(Class cls) {
        if (f2248e) {
            f2246c.b(cls);
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
            Class cls2 = f2245b;
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

    public static byte g(long j2, byte[] bArr) {
        return f2246c.d(f2249f + j2, bArr);
    }

    public static byte h(long j2, Object obj) {
        return (byte) ((f2246c.g((-4) & j2, obj) >>> ((int) (((~j2) & 3) << 3))) & 255);
    }

    public static byte i(long j2, Object obj) {
        return (byte) ((f2246c.g((-4) & j2, obj) >>> ((int) ((j2 & 3) << 3))) & 255);
    }

    public static Unsafe j() {
        try {
            return (Unsafe) AccessController.doPrivileged(new i1());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void k(byte[] bArr, long j2, byte b10) {
        f2246c.l(bArr, f2249f + j2, b10);
    }

    public static void l(Object obj, long j2, byte b10) {
        long j4 = (-4) & j2;
        int iG = f2246c.g(j4, obj);
        int i2 = ((~((int) j2)) & 3) << 3;
        n(((255 & b10) << i2) | (iG & (~(255 << i2))), j4, obj);
    }

    public static void m(Object obj, long j2, byte b10) {
        long j4 = (-4) & j2;
        int i2 = (((int) j2) & 3) << 3;
        n(((255 & b10) << i2) | (f2246c.g(j4, obj) & (~(255 << i2))), j4, obj);
    }

    public static void n(int i2, long j2, Object obj) {
        f2246c.o(i2, j2, obj);
    }

    public static void o(Object obj, long j2, long j4) {
        f2246c.p(obj, j2, j4);
    }

    public static void p(long j2, Object obj, Object obj2) {
        f2246c.q(j2, obj, obj2);
    }
}
