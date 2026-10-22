package v1;

import android.os.Handler;
import android.view.Choreographer;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m0 extends kc.p {

    /* renamed from: p, reason: collision with root package name */
    public static final jb.k f14492p = new jb.k(h0.f14436k);

    /* renamed from: q, reason: collision with root package name */
    public static final ae.b f14493q = new ae.b(4);

    /* renamed from: f, reason: collision with root package name */
    public final Choreographer f14494f;

    /* renamed from: g, reason: collision with root package name */
    public final Handler f14495g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f14496h = new Object();
    public final kb.j i = new kb.j();

    /* renamed from: j, reason: collision with root package name */
    public ArrayList f14497j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    public ArrayList f14498k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    public boolean f14499l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f14500m;

    /* renamed from: n, reason: collision with root package name */
    public final l0 f14501n;

    /* renamed from: o, reason: collision with root package name */
    public final k0.m1 f14502o;

    public m0(Choreographer choreographer, Handler handler) {
        this.f14494f = choreographer;
        this.f14495g = handler;
        l0 l0Var = new l0();
        l0Var.f14488c = this;
        VarHandle.storeStoreFence();
        this.f14501n = l0Var;
        k0.m1 m1Var = new k0.m1(1);
        m1Var.f6977f = choreographer;
        m1Var.f6978g = this;
        VarHandle.storeStoreFence();
        this.f14502o = m1Var;
    }

    public static final void Q(m0 m0Var) {
        Runnable runnable;
        boolean z10;
        do {
            synchronized (m0Var.f14496h) {
                kb.j jVar = m0Var.i;
                runnable = (Runnable) (jVar.isEmpty() ? null : jVar.removeFirst());
            }
            while (runnable != null) {
                runnable.run();
                synchronized (m0Var.f14496h) {
                    kb.j jVar2 = m0Var.i;
                    runnable = (Runnable) (jVar2.isEmpty() ? null : jVar2.removeFirst());
                }
            }
            synchronized (m0Var.f14496h) {
                if (m0Var.i.isEmpty()) {
                    z10 = false;
                    m0Var.f14499l = false;
                } else {
                    z10 = true;
                }
            }
        } while (z10);
    }

    @Override // kc.p
    public final void M(nb.g gVar, Runnable runnable) {
        synchronized (this.f14496h) {
            this.i.addLast(runnable);
            if (!this.f14499l) {
                this.f14499l = true;
                this.f14495g.post(this.f14501n);
                if (!this.f14500m) {
                    this.f14500m = true;
                    this.f14494f.postFrameCallback(this.f14501n);
                }
            }
        }
    }
}
