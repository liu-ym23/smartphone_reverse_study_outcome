package lc;

import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.VarHandle;
import java.util.concurrent.CancellationException;
import kc.a0;
import kc.e0;
import kc.g;
import kc.g0;
import kc.i1;
import kc.o1;
import kc.p;
import kc.w;
import pc.n;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d extends p implements a0 {

    /* renamed from: f, reason: collision with root package name */
    public final Handler f7858f;

    /* renamed from: g, reason: collision with root package name */
    public final String f7859g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f7860h;
    public final d i;

    public d(Handler handler, String str, boolean z10) {
        this.f7858f = handler;
        this.f7859g = str;
        this.f7860h = z10;
        this.i = z10 ? this : new d(handler, str, true);
    }

    @Override // kc.a0
    public final void F(long j10, g gVar) {
        int i = 8;
        com.stepos.statsrpk.service.d dVar = new com.stepos.statsrpk.service.d(i);
        dVar.f2885f = gVar;
        dVar.f2886g = this;
        VarHandle.storeStoreFence();
        if (j10 > 4611686018427387903L) {
            j10 = 4611686018427387903L;
        }
        if (!this.f7858f.postDelayed(dVar, j10)) {
            Q(gVar.i, dVar);
            return;
        }
        aa.g gVar2 = new aa.g(i);
        gVar2.f319f = this;
        gVar2.f320g = dVar;
        VarHandle.storeStoreFence();
        gVar.u(gVar2);
    }

    @Override // kc.p
    public final void M(nb.g gVar, Runnable runnable) {
        if (this.f7858f.post(runnable)) {
            return;
        }
        Q(gVar, runnable);
    }

    @Override // kc.p
    public final boolean O(nb.g gVar) {
        return (this.f7860h && k.a(Looper.myLooper(), this.f7858f.getLooper())) ? false : true;
    }

    public final void Q(nb.g gVar, Runnable runnable) {
        w.e(gVar, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        rc.e eVar = e0.f7430a;
        rc.d.f10552f.M(gVar, runnable);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return dVar.f7858f == this.f7858f && dVar.f7860h == this.f7860h;
    }

    public final int hashCode() {
        return (this.f7860h ? 1231 : 1237) ^ System.identityHashCode(this.f7858f);
    }

    @Override // kc.a0
    public final g0 n(long j10, o1 o1Var, nb.g gVar) {
        if (j10 > 4611686018427387903L) {
            j10 = 4611686018427387903L;
        }
        if (!this.f7858f.postDelayed(o1Var, j10)) {
            Q(gVar, o1Var);
            return i1.f7443c;
        }
        c cVar = new c();
        cVar.f7856c = this;
        cVar.f7857f = o1Var;
        VarHandle.storeStoreFence();
        return cVar;
    }

    @Override // kc.p
    public final String toString() {
        d dVar;
        String str;
        rc.e eVar = e0.f7430a;
        d dVar2 = n.f9978a;
        if (this == dVar2) {
            str = "Dispatchers.Main";
        } else {
            try {
                dVar = dVar2.i;
            } catch (UnsupportedOperationException unused) {
                dVar = null;
            }
            str = this == dVar ? "Dispatchers.Main.immediate" : null;
        }
        if (str != null) {
            return str;
        }
        String string = this.f7859g;
        if (string == null) {
            string = this.f7858f.toString();
        }
        return this.f7860h ? k0.a.n(string, ".immediate") : string;
    }

    public d(Handler handler) {
        this(handler, null, false);
    }
}
