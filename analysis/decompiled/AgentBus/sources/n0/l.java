package n0;

import c1.p;
import i1.d1;
import i1.g1;
import ia.b0;
import ia.d0;
import ia.i1;
import ia.z;
import j1.y;

/* loaded from: classes.dex */
public abstract class l implements i1.j {

    /* renamed from: g, reason: collision with root package name */
    public na.d f6798g;

    /* renamed from: h, reason: collision with root package name */
    public int f6799h;

    /* renamed from: j, reason: collision with root package name */
    public l f6801j;

    /* renamed from: k, reason: collision with root package name */
    public l f6802k;

    /* renamed from: l, reason: collision with root package name */
    public g1 f6803l;

    /* renamed from: m, reason: collision with root package name */
    public d1 f6804m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f6805n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f6806o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f6807p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f6808q;

    /* renamed from: r, reason: collision with root package name */
    public a8.e f6809r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f6810s;

    /* renamed from: f, reason: collision with root package name */
    public l f6797f = this;

    /* renamed from: i, reason: collision with root package name */
    public int f6800i = -1;

    public final b0 Z() {
        na.d dVar = this.f6798g;
        if (dVar != null) {
            return dVar;
        }
        na.d dVarB = d0.b(((y) i1.l.v(this)).getCoroutineContext().Q(new i1((ia.g1) ((y) i1.l.v(this)).getCoroutineContext().o(z.f5027g))));
        this.f6798g = dVarB;
        return dVarB;
    }

    public boolean a0() {
        return !(this instanceof o.z);
    }

    public void b0() {
        if (this.f6810s) {
            f1.a.b("node attached multiple times");
        }
        if (this.f6804m == null) {
            f1.a.b("attach invoked on a node without a coordinator");
        }
        this.f6810s = true;
        this.f6807p = true;
    }

    public void c0() {
        if (!this.f6810s) {
            f1.a.b("Cannot detach a node that is not attached");
        }
        if (this.f6807p) {
            f1.a.b("Must run runAttachLifecycle() before markAsDetached()");
        }
        if (this.f6808q) {
            f1.a.b("Must run runDetachLifecycle() before markAsDetached()");
        }
        this.f6810s = false;
        na.d dVar = this.f6798g;
        if (dVar != null) {
            d0.e(dVar, new p("The Modifier.Node was detached", 0));
            this.f6798g = null;
        }
    }

    public void d0() {
    }

    public void e0() {
    }

    public void f0() {
    }

    public void g0() {
        if (!this.f6810s) {
            f1.a.b("reset() called on an unattached node");
        }
        f0();
    }

    public void h0() {
        if (!this.f6810s) {
            f1.a.b("Must run markAsAttached() prior to runAttachLifecycle");
        }
        if (!this.f6807p) {
            f1.a.b("Must run runAttachLifecycle() only once after markAsAttached()");
        }
        this.f6807p = false;
        d0();
        this.f6808q = true;
    }

    public void i0() {
        if (!this.f6810s) {
            f1.a.b("node detached multiple times");
        }
        if (this.f6804m == null) {
            f1.a.b("detach invoked on a node without a coordinator");
        }
        if (!this.f6808q) {
            f1.a.b("Must run runDetachLifecycle() once after runAttachLifecycle() and before markAsDetached()");
        }
        this.f6808q = false;
        a8.e eVar = this.f6809r;
        if (eVar != null) {
            eVar.c();
        }
        e0();
    }

    public void j0(l lVar) {
        this.f6797f = lVar;
    }

    public void k0(d1 d1Var) {
        this.f6804m = d1Var;
    }
}
