package x4;

import android.content.Context;
import b0.b2;
import com.stepos.agentbus.config.BffBridgeConfig;
import ia.d0;
import ia.f1;
import ia.g1;
import ia.w1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import k5.s;
import k5.t;
import la.f0;
import la.k0;
import la.u0;
import q7.v;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final Context f11181a;

    /* renamed from: b, reason: collision with root package name */
    public final BffBridgeConfig f11182b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11183c;

    /* renamed from: d, reason: collision with root package name */
    public final l5.b f11184d;

    /* renamed from: e, reason: collision with root package name */
    public final i5.f f11185e;

    /* renamed from: f, reason: collision with root package name */
    public final t f11186f;

    /* renamed from: g, reason: collision with root package name */
    public final na.d f11187g;

    /* renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f11188h;

    /* renamed from: i, reason: collision with root package name */
    public final ra.d f11189i;

    /* renamed from: j, reason: collision with root package name */
    public k f11190j;

    /* renamed from: k, reason: collision with root package name */
    public w1 f11191k;

    /* renamed from: l, reason: collision with root package name */
    public w1 f11192l;

    /* renamed from: m, reason: collision with root package name */
    public w1 f11193m;

    /* renamed from: n, reason: collision with root package name */
    public w1 f11194n;

    /* renamed from: o, reason: collision with root package name */
    public i5.f f11195o;

    /* renamed from: p, reason: collision with root package name */
    public volatile boolean f11196p;

    /* renamed from: q, reason: collision with root package name */
    public volatile String f11197q;

    /* renamed from: r, reason: collision with root package name */
    public volatile int f11198r;

    /* renamed from: s, reason: collision with root package name */
    public volatile boolean f11199s;

    /* renamed from: t, reason: collision with root package name */
    public volatile boolean f11200t;

    /* renamed from: u, reason: collision with root package name */
    public final List f11201u;

    /* renamed from: v, reason: collision with root package name */
    public final u0 f11202v;

    /* renamed from: w, reason: collision with root package name */
    public final f0 f11203w;

    public i(Context context, BffBridgeConfig bffBridgeConfig, String str, l5.b bVar, i5.f fVar, k5.a aVar, k5.g gVar) {
        q7.k.e(context, "context");
        q7.k.e(bVar, "accountTokenProvider");
        q7.k.e(fVar, "downlinkRouter");
        q7.k.e(aVar, "dispatchers");
        q7.k.e(gVar, "logger");
        this.f11181a = context;
        this.f11182b = bffBridgeConfig;
        this.f11183c = str;
        this.f11184d = bVar;
        this.f11185e = fVar;
        this.f11186f = gVar;
        this.f11187g = d0.b(f1.plus(d0.c(), aVar.f5616a));
        this.f11188h = new AtomicBoolean(false);
        this.f11189i = new ra.d();
        this.f11199s = true;
        this.f11201u = Collections.synchronizedList(new ArrayList());
        u0 u0VarC = k0.c(new b(false, false));
        this.f11202v = u0VarC;
        this.f11203w = new f0(u0VarC);
    }

    public static final void a(i iVar, String str) {
        k kVar;
        if (iVar.f11188h.get()) {
            List list = iVar.f11201u;
            q7.k.d(list, "pendingQueue");
            if (list.isEmpty() && (kVar = iVar.f11190j) != null && kVar.f11211g.get()) {
                s.info$default(iVar.f11186f, "BffBridge", str, null, 4, null);
                iVar.f11200t = true;
                w1 w1Var = iVar.f11191k;
                if (w1Var != null) {
                    f1.cancel$default((g1) w1Var, (CancellationException) null, 1, (Object) null);
                }
                iVar.f11191k = null;
                k kVar2 = iVar.f11190j;
                if (kVar2 != null) {
                    kVar2.a();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(x4.i r13, i7.c r14) {
        /*
            Method dump skipped, instructions count: 409
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x4.i.b(x4.i, i7.c):java.lang.Object");
    }

    public final boolean c() {
        if (this.f11199s) {
            return true;
        }
        List list = this.f11201u;
        q7.k.d(list, "pendingQueue");
        return !list.isEmpty();
    }

    public final void d(boolean z4) {
        if (!z4 && !c()) {
            s.info$default(this.f11186f, "BffBridge", "skip connect: screen off and no pending uplink", null, 4, null);
            return;
        }
        k kVar = this.f11190j;
        this.f11190j = null;
        if (kVar != null) {
            this.f11200t = true;
            kVar.a();
            this.f11200t = false;
        }
        v vVar = new v();
        String str = this.f11183c;
        t tVar = this.f11186f;
        k kVar2 = new k(str, tVar, new a5.a(24, this), new a(this, 0), new b2(9, this, vVar));
        vVar.f8820f = kVar2;
        this.f11190j = kVar2;
        if (!kVar2.f11211g.get()) {
            kVar2.f11212h.set(false);
            s.info$default(tVar, "BffGatewayClient", "WS connecting url=".concat(str), null, 4, null);
            ab.v vVar2 = new ab.v();
            vVar2.d(str);
            kVar2.f11213i = kVar2.f11210f.c(vVar2.a(), new j(kVar2));
        }
        u0 u0Var = this.f11202v;
        ((b) u0Var.getValue()).getClass();
        b bVar = new b(false, false);
        u0Var.getClass();
        u0Var.g(null, bVar);
    }

    public final void e() {
        i iVar;
        w1 w1Var = this.f11193m;
        g7.d dVar = null;
        if (w1Var != null) {
            f1.cancel$default((g1) w1Var, (CancellationException) null, 1, (Object) null);
        }
        long idleDisconnectMs = this.f11182b.getIdleDisconnectMs();
        Long lValueOf = Long.valueOf(idleDisconnectMs);
        if (idleDisconnectMs <= 0) {
            lValueOf = null;
        }
        if (lValueOf != null) {
            iVar = this;
            iVar.f11193m = d0.s(iVar.f11187g, null, null, new g(lValueOf.longValue(), iVar, dVar, 0), 3);
        } else {
            iVar = this;
        }
        iVar.f();
    }

    public final void f() {
        w1 w1Var = this.f11194n;
        g7.d dVar = null;
        if (w1Var != null) {
            f1.cancel$default((g1) w1Var, (CancellationException) null, 1, (Object) null);
        }
        if (this.f11199s) {
            return;
        }
        long screenOffIdleMs = this.f11182b.getScreenOffIdleMs();
        Long lValueOf = Long.valueOf(screenOffIdleMs);
        if (screenOffIdleMs <= 0) {
            lValueOf = null;
        }
        if (lValueOf != null) {
            this.f11194n = d0.s(this.f11187g, null, null, new g(lValueOf.longValue(), this, dVar, 1), 3);
        }
    }

    public final void g(int i2) {
        w1 w1Var = this.f11192l;
        if (w1Var != null) {
            f1.cancel$default((g1) w1Var, (CancellationException) null, 1, (Object) null);
        }
        int heartbeatIntervalSec = this.f11182b.getHeartbeatIntervalSec();
        if (i2 < heartbeatIntervalSec) {
            i2 = heartbeatIntervalSec;
        }
        this.f11192l = d0.s(this.f11187g, null, null, new p.k(i2, null, this), 3);
    }

    public final void h() {
        if (this.f11188h.get()) {
            if (!c()) {
                s.info$default(this.f11186f, "BffBridge", "screen off and no pending uplink, skip reconnect", null, 4, null);
                return;
            }
            w1 w1Var = this.f11191k;
            g7.d dVar = null;
            if (w1Var != null) {
                f1.cancel$default((g1) w1Var, (CancellationException) null, 1, (Object) null);
            }
            this.f11191k = d0.s(this.f11187g, null, null, new d(1, dVar, this), 3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(byte[] r19, i7.c r20) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x4.i.i(byte[], i7.c):java.lang.Object");
    }

    public final void j() {
        if (this.f11188h.compareAndSet(true, false)) {
            w1 w1Var = this.f11191k;
            if (w1Var != null) {
                f1.cancel$default((g1) w1Var, (CancellationException) null, 1, (Object) null);
            }
            w1 w1Var2 = this.f11192l;
            if (w1Var2 != null) {
                f1.cancel$default((g1) w1Var2, (CancellationException) null, 1, (Object) null);
            }
            w1 w1Var3 = this.f11193m;
            if (w1Var3 != null) {
                f1.cancel$default((g1) w1Var3, (CancellationException) null, 1, (Object) null);
            }
            w1 w1Var4 = this.f11194n;
            if (w1Var4 != null) {
                f1.cancel$default((g1) w1Var4, (CancellationException) null, 1, (Object) null);
            }
            i5.f fVar = this.f11195o;
            if (fVar != null) {
                fVar.T();
            }
            this.f11195o = null;
            this.f11200t = true;
            k kVar = this.f11190j;
            if (kVar != null) {
                kVar.a();
            }
            this.f11190j = null;
            this.f11196p = false;
            this.f11201u.clear();
            u0 u0Var = this.f11202v;
            b bVar = new b(false, false);
            u0Var.getClass();
            u0Var.g(null, bVar);
            s.info$default(this.f11186f, "BffBridge", "stopped", null, 4, null);
        }
    }

    public final void k() {
        AtomicBoolean atomicBoolean = this.f11188h;
        if (atomicBoolean.get()) {
            List list = this.f11201u;
            if (list.isEmpty()) {
                s.info$default(this.f11186f, "BffBridge", "network recovered but no pending uplink, skip bff reconnect", null, 4, null);
                return;
            }
            s.info$default(this.f11186f, "BffBridge", a1.a.f(list.size(), "network recovered with pending=", ", waking bff"), null, 4, null);
            if (atomicBoolean.get()) {
                d0.s(this.f11187g, null, null, new e(2, null, this), 3);
            }
        }
    }
}
