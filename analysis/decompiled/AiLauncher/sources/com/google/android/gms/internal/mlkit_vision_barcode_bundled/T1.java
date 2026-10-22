package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.autonavi.aps.amapapi.config.Const;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* loaded from: classes2.dex */
public final class T1 {

    /* renamed from: a, reason: collision with root package name */
    public static final Unsafe f20053a;

    /* renamed from: b, reason: collision with root package name */
    public static final Class f20054b;

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f20055c;

    /* renamed from: d, reason: collision with root package name */
    public static final S1 f20056d;

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f20057e;

    /* renamed from: f, reason: collision with root package name */
    public static final boolean f20058f;

    /* renamed from: g, reason: collision with root package name */
    public static final long f20059g;

    /* renamed from: h, reason: collision with root package name */
    public static final boolean f20060h;

    /* JADX WARN: Removed duplicated region for block: B:11:0x003d  */
    static {
        /*
            Method dump skipped, instructions count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.T1.<clinit>():void");
    }

    public static boolean A(Class cls) {
        int i10 = W.f20062a;
        try {
            Class cls2 = f20054b;
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

    public static boolean B(Object obj, long j10) {
        return f20056d.g(obj, j10);
    }

    public static boolean C() {
        return f20058f;
    }

    public static boolean D() {
        return f20057e;
    }

    public static int E(Class cls) {
        if (f20058f) {
            return f20056d.f20052a.arrayBaseOffset(cls);
        }
        return -1;
    }

    public static int a(Class cls) {
        if (f20058f) {
            return f20056d.f20052a.arrayIndexScale(cls);
        }
        return -1;
    }

    public static Field b() {
        int i10 = W.f20062a;
        Field fieldC = c(Buffer.class, "effectiveDirectAddress");
        if (fieldC != null) {
            return fieldC;
        }
        Field fieldC2 = c(Buffer.class, Const.JSON_KEY_ADDRESS);
        if (fieldC2 == null || fieldC2.getType() != Long.TYPE) {
            return null;
        }
        return fieldC2;
    }

    public static Field c(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void d(Object obj, long j10, byte b10) {
        S1 s12 = f20056d;
        long j11 = (-4) & j10;
        int i10 = s12.f20052a.getInt(obj, j11);
        int i11 = ((~((int) j10)) & 3) << 3;
        s12.f20052a.putInt(obj, j11, ((255 & b10) << i11) | (i10 & (~(255 << i11))));
    }

    public static void e(Object obj, long j10, byte b10) {
        S1 s12 = f20056d;
        long j11 = (-4) & j10;
        int i10 = (((int) j10) & 3) << 3;
        s12.f20052a.putInt(obj, j11, ((255 & b10) << i10) | (s12.f20052a.getInt(obj, j11) & (~(255 << i10))));
    }

    public static double f(Object obj, long j10) {
        return f20056d.a(obj, j10);
    }

    public static float g(Object obj, long j10) {
        return f20056d.b(obj, j10);
    }

    public static int h(Object obj, long j10) {
        return f20056d.f20052a.getInt(obj, j10);
    }

    public static long i(Object obj, long j10) {
        return f20056d.f20052a.getLong(obj, j10);
    }

    public static Object j(Class cls) {
        try {
            return f20053a.allocateInstance(cls);
        } catch (InstantiationException e10) {
            throw new IllegalStateException(e10);
        }
    }

    public static Object k(Object obj, long j10) {
        return f20056d.f20052a.getObject(obj, j10);
    }

    public static Unsafe l() {
        try {
            return (Unsafe) AccessController.doPrivileged(new P1());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static /* bridge */ /* synthetic */ void m(Throwable th) {
        Logger.getLogger(T1.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
    }

    public static void r(Object obj, long j10, boolean z10) {
        f20056d.c(obj, j10, z10);
    }

    public static void s(byte[] bArr, long j10, byte b10) {
        f20056d.d(bArr, f20059g + j10, b10);
    }

    public static void t(Object obj, long j10, double d10) {
        f20056d.e(obj, j10, d10);
    }

    public static void u(Object obj, long j10, float f10) {
        f20056d.f(obj, j10, f10);
    }

    public static void v(Object obj, long j10, int i10) {
        f20056d.f20052a.putInt(obj, j10, i10);
    }

    public static void w(Object obj, long j10, long j11) {
        f20056d.f20052a.putLong(obj, j10, j11);
    }

    public static void x(Object obj, long j10, Object obj2) {
        f20056d.f20052a.putObject(obj, j10, obj2);
    }

    public static /* bridge */ /* synthetic */ boolean y(Object obj, long j10) {
        return ((byte) ((f20056d.f20052a.getInt(obj, (-4) & j10) >>> ((int) (((~j10) & 3) << 3))) & 255)) != 0;
    }

    public static /* bridge */ /* synthetic */ boolean z(Object obj, long j10) {
        return ((byte) ((f20056d.f20052a.getInt(obj, (-4) & j10) >>> ((int) ((j10 & 3) << 3))) & 255)) != 0;
    }
}
