package w0;

import kc.t;
import kc.w;
import kc.w0;
import kc.x0;
import kc.z0;
import o1.v;
import t.a0;
import u1.g1;
import u1.j1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class l implements u1.l {

    /* renamed from: f, reason: collision with root package name */
    public pc.c f15115f;

    /* renamed from: g, reason: collision with root package name */
    public int f15116g;
    public l i;

    /* renamed from: j, reason: collision with root package name */
    public l f15118j;

    /* renamed from: k, reason: collision with root package name */
    public j1 f15119k;

    /* renamed from: l, reason: collision with root package name */
    public g1 f15120l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f15121m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f15122n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f15123o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f15124p;

    /* renamed from: q, reason: collision with root package name */
    public a1.b f15125q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f15126r;

    /* renamed from: c, reason: collision with root package name */
    public l f15114c = this;

    /* renamed from: h, reason: collision with root package name */
    public int f15117h = -1;

    public void A0(g1 g1Var) {
        this.f15120l = g1Var;
    }

    public final t p0() {
        pc.c cVar = this.f15115f;
        if (cVar != null) {
            return cVar;
        }
        pc.c cVarA = w.a(((v1.t) u1.f.v(this)).getCoroutineContext().plus(new z0((x0) ((v1.t) u1.f.v(this)).getCoroutineContext().get(w0.f7498c))));
        this.f15115f = cVarA;
        return cVarA;
    }

    public boolean q0() {
        return !(this instanceof a0);
    }

    public void r0() {
        if (this.f15126r) {
            r1.a.b("node attached multiple times");
        }
        if (this.f15120l == null) {
            r1.a.b("attach invoked on a node without a coordinator");
        }
        this.f15126r = true;
        this.f15123o = true;
    }

    public void s0() {
        if (!this.f15126r) {
            r1.a.b("Cannot detach a node that is not attached");
        }
        if (this.f15123o) {
            r1.a.b("Must run runAttachLifecycle() before markAsDetached()");
        }
        if (this.f15124p) {
            r1.a.b("Must run runDetachLifecycle() before markAsDetached()");
        }
        this.f15126r = false;
        pc.c cVar = this.f15115f;
        if (cVar != null) {
            w.d(cVar, new v("The Modifier.Node was detached", 0));
            this.f15115f = null;
        }
    }

    public void w0() {
        if (!this.f15126r) {
            r1.a.b("reset() called on an unattached node");
        }
        v0();
    }

    public void x0() {
        if (!this.f15126r) {
            r1.a.b("Must run markAsAttached() prior to runAttachLifecycle");
        }
        if (!this.f15123o) {
            r1.a.b("Must run runAttachLifecycle() only once after markAsAttached()");
        }
        this.f15123o = false;
        t0();
        this.f15124p = true;
    }

    public void y0() {
        if (!this.f15126r) {
            r1.a.b("node detached multiple times");
        }
        if (this.f15120l == null) {
            r1.a.b("detach invoked on a node without a coordinator");
        }
        if (!this.f15124p) {
            r1.a.b("Must run runDetachLifecycle() once after runAttachLifecycle() and before markAsDetached()");
        }
        this.f15124p = false;
        a1.b bVar = this.f15125q;
        if (bVar != null) {
            bVar.invoke();
        }
        u0();
    }

    public void z0(l lVar) {
        this.f15114c = lVar;
    }

    public void t0() {
    }

    public void u0() {
    }

    public void v0() {
    }
}
