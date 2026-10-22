package x4;

import ab.s;
import b0.b2;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import k5.t;
import la.k0;
import la.u0;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final String f11205a;

    /* renamed from: b, reason: collision with root package name */
    public final t f11206b;

    /* renamed from: c, reason: collision with root package name */
    public final a5.a f11207c;

    /* renamed from: d, reason: collision with root package name */
    public final a f11208d;

    /* renamed from: e, reason: collision with root package name */
    public final b2 f11209e;

    /* renamed from: f, reason: collision with root package name */
    public final ab.t f11210f;

    /* renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f11211g;

    /* renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f11212h;

    /* renamed from: i, reason: collision with root package name */
    public nb.g f11213i;

    /* renamed from: j, reason: collision with root package name */
    public final u0 f11214j;

    public k(String str, t tVar, a5.a aVar, a aVar2, b2 b2Var) {
        q7.k.e(tVar, "logger");
        this.f11205a = str;
        this.f11206b = tVar;
        this.f11207c = aVar;
        this.f11208d = aVar2;
        this.f11209e = b2Var;
        s sVar = new s();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        q7.k.e(timeUnit, "unit");
        sVar.f625y = bb.b.b("interval", 30L, timeUnit);
        sVar.a(15L, timeUnit);
        sVar.b(0L, TimeUnit.MILLISECONDS);
        this.f11210f = new ab.t(sVar);
        this.f11211g = new AtomicBoolean(false);
        this.f11212h = new AtomicBoolean(false);
        this.f11214j = k0.c(Boolean.FALSE);
    }

    public final void a() {
        nb.g gVar = this.f11213i;
        if (gVar != null) {
            gVar.b(1000, "client stop");
        }
        b(null);
    }

    public final void b(Exception exc) {
        this.f11211g.set(false);
        Boolean bool = Boolean.FALSE;
        u0 u0Var = this.f11214j;
        u0Var.getClass();
        u0Var.g(null, bool);
        this.f11213i = null;
        if (this.f11212h.compareAndSet(false, true)) {
            this.f11209e.invoke(exc);
        }
    }

    public final boolean c(byte[] bArr) {
        nb.g gVar = this.f11213i;
        if (gVar == null) {
            k5.s.warn$default(this.f11206b, "BffGatewayClient", n.f.c(bArr.length, "WS send skipped: no socket bytes="), null, 4, null);
            return false;
        }
        if (!this.f11211g.get()) {
            k5.s.warn$default(this.f11206b, "BffGatewayClient", n.f.c(bArr.length, "WS send skipped: not open bytes="), null, 4, null);
            return false;
        }
        ob.k kVar = ob.k.f7997i;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        q7.k.e(bArrCopyOf, "data");
        byte[] bArrCopyOf2 = Arrays.copyOf(bArrCopyOf, bArrCopyOf.length);
        q7.k.d(bArrCopyOf2, "copyOf(...)");
        boolean zG = gVar.g(2, new ob.k(bArrCopyOf2));
        if (!zG) {
            k5.s.warn$default(this.f11206b, "BffGatewayClient", n.f.c(bArr.length, "WS send failed bytes="), null, 4, null);
        }
        return zG;
    }
}
