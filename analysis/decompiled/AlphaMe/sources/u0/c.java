package u0;

import B0.f;
import B0.k;
import C0.n;
import Z2.o0;
import android.content.Context;
import android.text.TextUtils;
import androidx.appcompat.widget.RunnableC0209k;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import s0.C0844b;
import s0.G;
import t0.C0911F;
import t0.C0917c;
import t0.InterfaceC0918d;
import t0.r;
import t0.t;
import t0.x;
import x0.C0979a;
import x0.e;
import z0.l;

/* loaded from: classes.dex */
public final class c implements t, e, InterfaceC0918d {

    /* renamed from: o, reason: collision with root package name */
    public static final String f15456o = s0.t.f("GreedyScheduler");

    /* renamed from: a, reason: collision with root package name */
    public final Context f15457a;

    /* renamed from: c, reason: collision with root package name */
    public final C0936a f15459c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f15460d;

    /* renamed from: g, reason: collision with root package name */
    public final r f15463g;

    /* renamed from: h, reason: collision with root package name */
    public final C0911F f15464h;

    /* renamed from: i, reason: collision with root package name */
    public final C0844b f15465i;

    /* renamed from: k, reason: collision with root package name */
    public Boolean f15467k;

    /* renamed from: l, reason: collision with root package name */
    public final stepos.support.v7.app.palette.b f15468l;

    /* renamed from: m, reason: collision with root package name */
    public final E0.a f15469m;

    /* renamed from: n, reason: collision with root package name */
    public final d f15470n;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f15458b = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public final Object f15461e = new Object();

    /* renamed from: f, reason: collision with root package name */
    public final B0.e f15462f = new B0.e();

    /* renamed from: j, reason: collision with root package name */
    public final HashMap f15466j = new HashMap();

    public c(Context context, C0844b c0844b, l lVar, r rVar, C0911F c0911f, E0.a aVar) {
        this.f15457a = context;
        C0917c c0917c = c0844b.f14175f;
        this.f15459c = new C0936a(this, c0917c, c0844b.f14172c);
        this.f15470n = new d(c0917c, c0911f);
        this.f15469m = aVar;
        this.f15468l = new stepos.support.v7.app.palette.b(lVar);
        this.f15465i = c0844b;
        this.f15463g = rVar;
        this.f15464h = c0911f;
    }

    @Override // t0.t
    public final void a(String str) {
        Runnable runnable;
        if (this.f15467k == null) {
            int i4 = n.f308a;
            Context context = this.f15457a;
            Intrinsics.checkNotNullParameter(context, "context");
            C0844b configuration = this.f15465i;
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            String strA = C0.a.f286a.a();
            configuration.getClass();
            this.f15467k = Boolean.valueOf(Intrinsics.areEqual(strA, context.getApplicationInfo().processName));
        }
        boolean zBooleanValue = this.f15467k.booleanValue();
        String str2 = f15456o;
        if (!zBooleanValue) {
            s0.t.d().e(str2, "Ignoring schedule request in non-main process");
            return;
        }
        if (!this.f15460d) {
            this.f15463g.a(this);
            this.f15460d = true;
        }
        s0.t.d().a(str2, "Cancelling work ID " + str);
        C0936a c0936a = this.f15459c;
        if (c0936a != null && (runnable = (Runnable) c0936a.f15453d.remove(str)) != null) {
            c0936a.f15451b.f15383a.removeCallbacks(runnable);
        }
        for (x workSpecId : this.f15462f.l(str)) {
            this.f15470n.a(workSpecId);
            C0911F c0911f = this.f15464h;
            c0911f.getClass();
            Intrinsics.checkNotNullParameter(workSpecId, "workSpecId");
            c0911f.a(workSpecId, -512);
        }
    }

    @Override // x0.e
    public final void b(B0.r rVar, x0.c cVar) {
        k kVarV = f.v(rVar);
        boolean z4 = cVar instanceof C0979a;
        C0911F c0911f = this.f15464h;
        d dVar = this.f15470n;
        String str = f15456o;
        B0.e eVar = this.f15462f;
        if (!z4) {
            s0.t.d().a(str, "Constraints not met: Cancelling work ID " + kVarV);
            x workSpecId = eVar.m(kVarV);
            if (workSpecId != null) {
                dVar.a(workSpecId);
                int i4 = ((x0.b) cVar).f15870a;
                c0911f.getClass();
                Intrinsics.checkNotNullParameter(workSpecId, "workSpecId");
                c0911f.a(workSpecId, i4);
                return;
            }
            return;
        }
        if (eVar.f(kVarV)) {
            return;
        }
        s0.t.d().a(str, "Constraints met: Scheduling work ID " + kVarV);
        x workSpecId2 = eVar.n(kVarV);
        dVar.b(workSpecId2);
        c0911f.getClass();
        Intrinsics.checkNotNullParameter(workSpecId2, "workSpecId");
        Intrinsics.checkNotNullParameter(workSpecId2, "workSpecId");
        c0911f.f15321b.a(new H.a(c0911f.f15320a, workSpecId2, null));
    }

    @Override // t0.InterfaceC0918d
    public final void c(k kVar, boolean z4) {
        o0 o0Var;
        x xVarM = this.f15462f.m(kVar);
        if (xVarM != null) {
            this.f15470n.a(xVarM);
        }
        synchronized (this.f15461e) {
            o0Var = (o0) this.f15458b.remove(kVar);
        }
        if (o0Var != null) {
            s0.t.d().a(f15456o, "Stopping tracking for " + kVar);
            o0Var.b(null);
        }
        if (z4) {
            return;
        }
        synchronized (this.f15461e) {
            this.f15466j.remove(kVar);
        }
    }

    @Override // t0.t
    public final boolean d() {
        return false;
    }

    @Override // t0.t
    public final void e(B0.r... rVarArr) {
        long jMax;
        if (this.f15467k == null) {
            int i4 = n.f308a;
            Context context = this.f15457a;
            Intrinsics.checkNotNullParameter(context, "context");
            C0844b configuration = this.f15465i;
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            String strA = C0.a.f286a.a();
            configuration.getClass();
            this.f15467k = Boolean.valueOf(Intrinsics.areEqual(strA, context.getApplicationInfo().processName));
        }
        if (!this.f15467k.booleanValue()) {
            s0.t.d().e(f15456o, "Ignoring schedule request in a secondary process");
            return;
        }
        if (!this.f15460d) {
            this.f15463g.a(this);
            this.f15460d = true;
        }
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (B0.r spec : rVarArr) {
            if (!this.f15462f.f(f.v(spec))) {
                synchronized (this.f15461e) {
                    try {
                        k kVarV = f.v(spec);
                        C0937b c0937b = (C0937b) this.f15466j.get(kVarV);
                        if (c0937b == null) {
                            int i5 = spec.f177k;
                            this.f15465i.f14172c.getClass();
                            c0937b = new C0937b(i5, System.currentTimeMillis());
                            this.f15466j.put(kVarV, c0937b);
                        }
                        jMax = (Math.max((spec.f177k - c0937b.f15454a) - 5, 0) * 30000) + c0937b.f15455b;
                    } finally {
                    }
                }
                long jMax2 = Math.max(spec.a(), jMax);
                this.f15465i.f14172c.getClass();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (spec.f168b == G.f14153a) {
                    if (jCurrentTimeMillis < jMax2) {
                        C0936a c0936a = this.f15459c;
                        if (c0936a != null) {
                            HashMap map = c0936a.f15453d;
                            Runnable runnable = (Runnable) map.remove(spec.f167a);
                            C0917c c0917c = c0936a.f15451b;
                            if (runnable != null) {
                                c0917c.f15383a.removeCallbacks(runnable);
                            }
                            RunnableC0209k runnableC0209k = new RunnableC0209k(8, c0936a, spec);
                            map.put(spec.f167a, runnableC0209k);
                            c0936a.f15452c.getClass();
                            c0917c.f15383a.postDelayed(runnableC0209k, jMax2 - System.currentTimeMillis());
                        }
                    } else if (spec.c()) {
                        if (spec.f176j.f14187c) {
                            s0.t.d().a(f15456o, "Ignoring " + spec + ". Requires device idle.");
                        } else if (!r7.f14192h.isEmpty()) {
                            s0.t.d().a(f15456o, "Ignoring " + spec + ". Requires ContentUri triggers.");
                        } else {
                            hashSet.add(spec);
                            hashSet2.add(spec.f167a);
                        }
                    } else if (!this.f15462f.f(f.v(spec))) {
                        s0.t.d().a(f15456o, "Starting work for " + spec.f167a);
                        B0.e eVar = this.f15462f;
                        eVar.getClass();
                        Intrinsics.checkNotNullParameter(spec, "spec");
                        x workSpecId = eVar.n(f.v(spec));
                        this.f15470n.b(workSpecId);
                        C0911F c0911f = this.f15464h;
                        c0911f.getClass();
                        Intrinsics.checkNotNullParameter(workSpecId, "workSpecId");
                        Intrinsics.checkNotNullParameter(workSpecId, "workSpecId");
                        c0911f.f15321b.a(new H.a(c0911f.f15320a, workSpecId, null));
                    }
                }
            }
        }
        synchronized (this.f15461e) {
            try {
                if (!hashSet.isEmpty()) {
                    s0.t.d().a(f15456o, "Starting tracking for " + TextUtils.join(",", hashSet2));
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        B0.r rVar = (B0.r) it.next();
                        k kVarV2 = f.v(rVar);
                        if (!this.f15458b.containsKey(kVarV2)) {
                            this.f15458b.put(kVarV2, x0.k.a(this.f15468l, rVar, ((E0.c) this.f15469m).f401b, this));
                        }
                    }
                }
            } finally {
            }
        }
    }
}
