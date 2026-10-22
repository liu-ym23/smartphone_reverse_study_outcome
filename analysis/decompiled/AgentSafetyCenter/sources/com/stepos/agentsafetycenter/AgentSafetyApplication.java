package com.stepos.agentsafetycenter;

import ab.e;
import ac.a;
import ad.s;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import androidx.lifecycle.h0;
import androidx.lifecycle.r;
import b.b;
import com.fasterxml.jackson.core.JsonPointer;
import com.stepos.agentsafetycenter.sync.PendingSyncWorker;
import d2.y;
import g5.v;
import g9.b0;
import g9.j1;
import g9.k1;
import g9.u;
import g9.v0;
import h5.t;
import java.lang.invoke.VarHandle;
import java.util.LinkedHashSet;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import jb.i;
import jb.k;
import kb.l;
import kc.e0;
import kc.w;
import o8.n;
import p5.f;
import p5.m;
import pc.c;
import rc.d;
import td.h;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class AgentSafetyApplication extends Application {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f2487h = 0;

    /* renamed from: c, reason: collision with root package name */
    public final k f2488c;

    /* renamed from: f, reason: collision with root package name */
    public final c f2489f;

    /* renamed from: g, reason: collision with root package name */
    public final c f2490g;

    public AgentSafetyApplication() {
        e eVar = new e(7);
        eVar.f393f = this;
        VarHandle.storeStoreFence();
        this.f2488c = new k(eVar);
        this.f2489f = w.a(a.N(w.c(), e0.f7430a));
        this.f2490g = w.a(a.N(w.c(), d.f10552f));
    }

    @Override // android.app.Application
    public final void onCreate() {
        Object objL;
        super.onCreate();
        r8.a aVar = r8.a.f10474a;
        int i = 3;
        nb.c cVar = null;
        int i3 = 1;
        if (!r8.a.f10476c) {
            synchronized (aVar) {
                if (!r8.a.f10476c) {
                    r8.a.f10476c = true;
                    w.u(r8.a.f10477d, null, null, new r(getApplicationContext(), cVar, 10), 3);
                }
            }
        }
        try {
            b bVar = new b(i);
            bVar.f1685f = this;
            VarHandle.storeStoreFence();
            t.f5380a = bVar;
            n6.a.k(this);
            h.f13310d = true;
            objL = Integer.valueOf(Log.i("UsageStatsInit", "UsageStats initialized appId=20013638"));
        } catch (Throwable th) {
            objL = id.c.l(th);
        }
        Throwable thB = i.b(objL);
        if (thB != null) {
            Log.w("UsageStatsInit", "UsageStats init failed", thB);
        }
        t8.c.f13219d.j(this).l(System.currentTimeMillis() - 2592000000L);
        l8.b bVar2 = l8.b.f7755a;
        l8.b.f7757c = getApplicationContext();
        if (l8.b.f7756b == null) {
            synchronized (bVar2) {
                if (l8.b.f7756b == null) {
                    l8.b.f7756b = new m(getApplicationContext());
                    Log.i("MzAccountSession", "MzAuthenticator initialized (basic)");
                }
            }
        }
        h9.b bVar3 = h9.b.f5420a;
        h9.b.a(this);
        registerActivityLifecycleCallbacks(k8.c.f7284a);
        Stack stack = n.f9321a;
        registerActivityLifecycleCallbacks(new o8.m());
        f.H(this);
        r2.i iVar = t8.c.f13221f;
        Context applicationContext = getApplicationContext();
        applicationContext.getClass();
        if (!iVar.k(applicationContext).d().isEmpty()) {
            g5.d dVar = new g5.d(new q5.d(null), 2, false, false, false, false, -1L, -1L, l.O0(new LinkedHashSet()));
            v vVar = new v(PendingSyncWorker.class);
            vVar.f4310c.f9772j = dVar;
            g5.w wVar = (g5.w) ((v) vVar.d(30L, TimeUnit.SECONDS)).a();
            Context applicationContext2 = getApplicationContext();
            applicationContext2.getClass();
            new h5.n(h5.r.b(applicationContext2), "agent_safety_pending_sync_drain", 1, a.E(wVar), 0).a();
        }
        String string = hc.h.w0(t1.e.p(this)).toString();
        int i10 = 0;
        if (!hc.h.g0(string)) {
            Context applicationContext3 = getApplicationContext();
            applicationContext3.getClass();
            u uVar = new u();
            uVar.f4623a = applicationContext3;
            VarHandle.storeStoreFence();
            v0 v0Var = (v0) k1.f4514b.getValue();
            b0 b0Var = new b0();
            b0Var.f4408a = k0.a.n(hc.h.x0(string, JsonPointer.SEPARATOR), "/v1/agent_permission/report");
            ad.v vVar2 = new ad.v();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            vVar2.a(30L, timeUnit);
            vVar2.f601t = bd.b.b(30L, timeUnit);
            vVar2.f602u = bd.b.b(30L, timeUnit);
            vVar2.f588f = true;
            b0Var.f4409b = new ad.w(vVar2);
            Pattern pattern = s.f568d;
            b0Var.f4410c = id.k.t("application/json; charset=utf-8");
            VarHandle.storeStoreFence();
            c cVar2 = this.f2489f;
            androidx.room.d dVar2 = new androidx.room.d(1, uVar, u.class, "broadcast", "broadcast(Lcom/stepos/agentsafetycenter/permission/PermissionReport;)V", 0, 0, 2);
            androidx.room.c cVar3 = new androidx.room.c(9);
            y yVar = j1.f4500h;
            v0Var.getClass();
            cVar2.getClass();
            j1 j1Var = new j1();
            j1Var.f4501a = v0Var;
            j1Var.f4502b = b0Var;
            j1Var.f4503c = cVar3;
            j1Var.f4504d = yVar;
            j1Var.f4505e = dVar2;
            j1Var.f4506f = t.c(128, 4, mc.a.f8551f);
            VarHandle.storeStoreFence();
            if (j1Var.f4507g == null) {
                w.u(cVar2, null, null, new h0(j1Var, cVar, 7), 3);
                j1Var.f4507g = w.u(cVar2, null, null, new androidx.room.e(j1Var, cVar, i), 3);
            }
        }
        c cVar4 = this.f2490g;
        androidx.room.c cVar5 = new androidx.room.c(26);
        cVar4.getClass();
        w.u(cVar4, null, null, new g9.r(cVar5, getApplicationContext(), cVar, i3), 3);
        c cVar6 = this.f2490g;
        androidx.room.c cVar7 = new androidx.room.c(6);
        cVar6.getClass();
        w.u(cVar6, null, null, new g9.r(cVar7, getApplicationContext(), cVar, i10), 3);
        i9.b0.f5839d.m(this);
        w.u(this.f2490g, null, null, new h0(this, cVar, 11), 3);
    }
}
