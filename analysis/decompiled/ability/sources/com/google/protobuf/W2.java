package com.google.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* loaded from: classes3.dex */
public abstract class W2 {

    /* renamed from: a, reason: collision with root package name */
    public static final Unsafe f2886a;
    public static final Class b;
    public static final V2 c;
    public static final boolean d;
    public static final boolean e;
    public static final long f;
    public static final long g;
    public static final boolean h;

    static {
        Unsafe unsafeJ = j();
        f2886a = unsafeJ;
        b = AbstractC0944h.f2921a;
        boolean zF = f(Long.TYPE);
        boolean zF2 = f(Integer.TYPE);
        V2 u22 = null;
        if (unsafeJ != null) {
            if (!AbstractC0944h.a()) {
                u22 = new U2(unsafeJ);
            } else if (zF) {
                u22 = new T2(unsafeJ, 1);
            } else if (zF2) {
                u22 = new T2(unsafeJ, 0);
            }
        }
        c = u22;
        d = u22 == null ? false : u22.u();
        e = u22 == null ? false : u22.t();
        f = c(byte[].class);
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
        g = (fieldE == null || u22 == null) ? -1L : u22.l(fieldE);
        h = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static void a(Throwable th) {
        Logger.getLogger(W2.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    public static Object b(Class cls) {
        try {
            return f2886a.allocateInstance(cls);
        } catch (InstantiationException e6) {
            throw new IllegalStateException(e6);
        }
    }

    public static int c(Class cls) {
        if (e) {
            return c.a(cls);
        }
        return -1;
    }

    public static void d(Class cls) {
        if (e) {
            c.b(cls);
        }
    }

    public static Field e() {
        Field declaredField;
        Field declaredField2;
        if (AbstractC0944h.a()) {
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
        if (!AbstractC0944h.a()) {
            return false;
        }
        try {
            Class cls2 = b;
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

    public static byte g(byte[] bArr, long j5) {
        return c.f(bArr, f + j5);
    }

    public static byte h(Object obj, long j5) {
        return (byte) ((c.i(obj, (-4) & j5) >>> ((int) (((~j5) & 3) << 3))) & 255);
    }

    public static byte i(Object obj, long j5) {
        return (byte) ((c.i(obj, (-4) & j5) >>> ((int) ((j5 & 3) << 3))) & 255);
    }

    public static Unsafe j() {
        try {
            return (Unsafe) AccessController.doPrivileged(new S2());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void k(byte[] bArr, long j5, byte b5) {
        c.n(bArr, f + j5, b5);
    }

    public static void l(Object obj, long j5, byte b5) {
        long j6 = (-4) & j5;
        int i = c.i(obj, j6);
        int i6 = ((~((int) j5)) & 3) << 3;
        n(obj, j6, ((255 & b5) << i6) | (i & (~(255 << i6))));
    }

    public static void m(Object obj, long j5, byte b5) {
        long j6 = (-4) & j5;
        int i = (((int) j5) & 3) << 3;
        n(obj, j6, ((255 & b5) << i) | (c.i(obj, j6) & (~(255 << i))));
    }

    public static void n(Object obj, long j5, int i) {
        c.q(obj, j5, i);
    }

    public static void o(Object obj, long j5, long j6) {
        c.r(obj, j5, j6);
    }

    public static void p(Object obj, long j5, Object obj2) {
        c.s(obj, j5, obj2);
    }
}
