package f8;

import java.util.List;

/* loaded from: classes.dex */
public final class d implements q0 {

    /* renamed from: f, reason: collision with root package name */
    public final q0 f3469f;

    /* renamed from: g, reason: collision with root package name */
    public final h f3470g;

    /* renamed from: h, reason: collision with root package name */
    public final int f3471h;

    public d(q0 q0Var, h hVar, int i2) {
        this.f3469f = q0Var;
        this.f3470g = hVar;
        this.f3471h = i2;
    }

    @Override // f8.q0
    public final u9.n A() {
        return this.f3469f.A();
    }

    @Override // f8.q0
    public final boolean M() {
        return true;
    }

    @Override // f8.q0
    public final boolean N() {
        return this.f3469f.N();
    }

    @Override // f8.j
    public final Object P(l lVar, Object obj) {
        return this.f3469f.P(lVar, obj);
    }

    @Override // f8.g, f8.j
    public final g a() {
        return this.f3469f.a();
    }

    @Override // f8.q0
    public final int a0() {
        return this.f3469f.a0();
    }

    @Override // g8.a
    public final g8.j getAnnotations() {
        return this.f3469f.getAnnotations();
    }

    @Override // f8.q0
    public final int getIndex() {
        return this.f3469f.getIndex() + this.f3471h;
    }

    @Override // f8.j
    public final e9.f getName() {
        return this.f3469f.getName();
    }

    @Override // f8.q0
    public final List getUpperBounds() {
        return this.f3469f.getUpperBounds();
    }

    @Override // f8.q0, f8.g
    public final v9.m0 h() {
        return this.f3469f.h();
    }

    @Override // f8.g
    public final v9.z k() {
        return this.f3469f.k();
    }

    @Override // f8.j
    public final j p() {
        return this.f3470g;
    }

    @Override // f8.k
    public final n0 q() {
        return this.f3469f.q();
    }

    public final String toString() {
        return this.f3469f + "[inner-copy]";
    }

    @Override // f8.j
    public final j a() {
        return this.f3469f.a();
    }

    @Override // f8.q0, f8.g, f8.j
    public final q0 a() {
        return this.f3469f.a();
    }
}
