package p7;

import java.lang.invoke.VarHandle;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.util.BitSet;
import java.util.Currency;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class g1 {
    public static final w0 A;
    public static final i B;

    /* renamed from: a, reason: collision with root package name */
    public static final w0 f9845a = a(Class.class, new n0().nullSafe());

    /* renamed from: b, reason: collision with root package name */
    public static final w0 f9846b = a(BitSet.class, new x0().nullSafe());

    /* renamed from: c, reason: collision with root package name */
    public static final a1 f9847c;

    /* renamed from: d, reason: collision with root package name */
    public static final y0 f9848d;

    /* renamed from: e, reason: collision with root package name */
    public static final y0 f9849e;

    /* renamed from: f, reason: collision with root package name */
    public static final y0 f9850f;

    /* renamed from: g, reason: collision with root package name */
    public static final y0 f9851g;

    /* renamed from: h, reason: collision with root package name */
    public static final w0 f9852h;
    public static final w0 i;

    /* renamed from: j, reason: collision with root package name */
    public static final w0 f9853j;

    /* renamed from: k, reason: collision with root package name */
    public static final e0 f9854k;

    /* renamed from: l, reason: collision with root package name */
    public static final y0 f9855l;

    /* renamed from: m, reason: collision with root package name */
    public static final j0 f9856m;

    /* renamed from: n, reason: collision with root package name */
    public static final k0 f9857n;

    /* renamed from: o, reason: collision with root package name */
    public static final l0 f9858o;

    /* renamed from: p, reason: collision with root package name */
    public static final w0 f9859p;

    /* renamed from: q, reason: collision with root package name */
    public static final w0 f9860q;

    /* renamed from: r, reason: collision with root package name */
    public static final w0 f9861r;

    /* renamed from: s, reason: collision with root package name */
    public static final w0 f9862s;

    /* renamed from: t, reason: collision with root package name */
    public static final w0 f9863t;

    /* renamed from: u, reason: collision with root package name */
    public static final w0 f9864u;

    /* renamed from: v, reason: collision with root package name */
    public static final w0 f9865v;

    /* renamed from: w, reason: collision with root package name */
    public static final w0 f9866w;

    /* renamed from: x, reason: collision with root package name */
    public static final s f9867x;

    /* renamed from: y, reason: collision with root package name */
    public static final w0 f9868y;

    /* renamed from: z, reason: collision with root package name */
    public static final m f9869z;

    static {
        z0 z0Var = new z0();
        f9847c = new a1();
        f9848d = b(Boolean.TYPE, Boolean.class, z0Var);
        f9849e = b(Byte.TYPE, Byte.class, new b1());
        f9850f = b(Short.TYPE, Short.class, new c1());
        f9851g = b(Integer.TYPE, Integer.class, new d1());
        f9852h = a(AtomicInteger.class, new e1().nullSafe());
        i = a(AtomicBoolean.class, new f1().nullSafe());
        f9853j = a(AtomicIntegerArray.class, new d0().nullSafe());
        f9854k = new e0();
        new f0();
        new g0();
        f9855l = b(Character.TYPE, Character.class, new h0());
        i0 i0Var = new i0();
        f9856m = new j0();
        f9857n = new k0();
        f9858o = new l0();
        f9859p = a(String.class, i0Var);
        f9860q = a(StringBuilder.class, new m0());
        f9861r = a(StringBuffer.class, new o0());
        f9862s = a(URL.class, new p0());
        f9863t = a(URI.class, new q0());
        r0 r0Var = new r0();
        int i3 = 1;
        w0 w0Var = new w0(i3);
        w0Var.f9913f = InetAddress.class;
        w0Var.f9914g = r0Var;
        VarHandle.storeStoreFence();
        f9864u = w0Var;
        f9865v = a(UUID.class, new s0());
        f9866w = a(Currency.class, new t0().nullSafe());
        u0 u0Var = new u0();
        s sVar = new s(i3);
        sVar.f9897f = u0Var;
        VarHandle.storeStoreFence();
        f9867x = sVar;
        f9868y = a(Locale.class, new v0());
        m mVar = m.f9880a;
        f9869z = mVar;
        w0 w0Var2 = new w0(i3);
        w0Var2.f9913f = m7.g.class;
        w0Var2.f9914g = mVar;
        VarHandle.storeStoreFence();
        A = w0Var2;
        B = j.f9873d;
    }

    public static w0 a(Class cls, m7.n nVar) {
        w0 w0Var = new w0(0);
        w0Var.f9913f = cls;
        w0Var.f9914g = nVar;
        VarHandle.storeStoreFence();
        return w0Var;
    }

    public static y0 b(Class cls, Class cls2, m7.n nVar) {
        y0 y0Var = new y0();
        y0Var.f9917c = cls;
        y0Var.f9918f = cls2;
        y0Var.f9919g = nVar;
        VarHandle.storeStoreFence();
        return y0Var;
    }
}
