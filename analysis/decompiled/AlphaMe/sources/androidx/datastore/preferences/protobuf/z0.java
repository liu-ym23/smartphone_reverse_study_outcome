package androidx.datastore.preferences.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
public abstract class z0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f3555a = Logger.getLogger(z0.class.getName());

    /* renamed from: b, reason: collision with root package name */
    public static final Unsafe f3556b;

    /* renamed from: c, reason: collision with root package name */
    public static final Class f3557c;

    /* renamed from: d, reason: collision with root package name */
    public static final y0 f3558d;

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f3559e;

    /* renamed from: f, reason: collision with root package name */
    public static final boolean f3560f;

    /* renamed from: g, reason: collision with root package name */
    public static final long f3561g;

    /* renamed from: h, reason: collision with root package name */
    public static final boolean f3562h;

    /* JADX WARN: Removed duplicated region for block: B:81:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0237  */
    static {
        /*
            Method dump skipped, instructions count: 572
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.z0.<clinit>():void");
    }

    public static Object a(Class cls) {
        try {
            return f3556b.allocateInstance(cls);
        } catch (InstantiationException e4) {
            throw new IllegalStateException(e4);
        }
    }

    public static int b(Class cls) {
        if (f3560f) {
            return f3558d.a(cls);
        }
        return -1;
    }

    public static void c(Class cls) {
        if (f3560f) {
            f3558d.b(cls);
        }
    }

    public static Field d() {
        Field declaredField;
        Field declaredField2;
        if (AbstractC0251d.a()) {
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

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean e(Class cls) {
        if (!AbstractC0251d.a()) {
            return false;
        }
        try {
            Class cls2 = f3557c;
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

    public static byte f(long j4, byte[] bArr) {
        return f3558d.d(f3561g + j4, bArr);
    }

    public static byte g(long j4, Object obj) {
        return (byte) ((f3558d.g((-4) & j4, obj) >>> ((int) (((~j4) & 3) << 3))) & 255);
    }

    public static byte h(long j4, Object obj) {
        return (byte) ((f3558d.g((-4) & j4, obj) >>> ((int) ((j4 & 3) << 3))) & 255);
    }

    public static int i(long j4, Object obj) {
        return f3558d.g(j4, obj);
    }

    public static long j(long j4, Object obj) {
        return f3558d.h(j4, obj);
    }

    public static Object k(long j4, Object obj) {
        return f3558d.i(j4, obj);
    }

    public static Unsafe l() {
        try {
            return (Unsafe) AccessController.doPrivileged(new v0());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void m(byte[] bArr, long j4, byte b4) {
        f3558d.l(bArr, f3561g + j4, b4);
    }

    public static void n(Object obj, long j4, byte b4) {
        long j5 = (-4) & j4;
        int iG = f3558d.g(j5, obj);
        int i4 = ((~((int) j4)) & 3) << 3;
        p(((255 & b4) << i4) | (iG & (~(255 << i4))), j5, obj);
    }

    public static void o(Object obj, long j4, byte b4) {
        long j5 = (-4) & j4;
        int i4 = (((int) j4) & 3) << 3;
        p(((255 & b4) << i4) | (f3558d.g(j5, obj) & (~(255 << i4))), j5, obj);
    }

    public static void p(int i4, long j4, Object obj) {
        f3558d.o(i4, j4, obj);
    }

    public static void q(Object obj, long j4, long j5) {
        f3558d.p(obj, j4, j5);
    }

    public static void r(long j4, Object obj, Object obj2) {
        f3558d.q(j4, obj, obj2);
    }
}
