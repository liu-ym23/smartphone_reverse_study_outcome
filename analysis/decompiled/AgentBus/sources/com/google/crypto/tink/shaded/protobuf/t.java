package com.google.crypto.tink.shaded.protobuf;

/* loaded from: classes.dex */
public abstract class t implements p0, Cloneable {

    /* renamed from: f, reason: collision with root package name */
    public final v f2286f;

    /* renamed from: g, reason: collision with root package name */
    public v f2287g;

    public t(v vVar) {
        this.f2286f = vVar;
        if (vVar.m()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.f2287g = vVar.p();
    }

    public static void e(Object obj, Object obj2) {
        x0 x0Var = x0.f2290c;
        x0Var.getClass();
        x0Var.a(obj.getClass()).a(obj, obj2);
    }

    public final v a() {
        v vVarB = b();
        vVarB.getClass();
        if (v.l(vVarB, true)) {
            return vVarB;
        }
        throw new c1();
    }

    public final v b() {
        if (!this.f2287g.m()) {
            return this.f2287g;
        }
        v vVar = this.f2287g;
        vVar.getClass();
        x0 x0Var = x0.f2290c;
        x0Var.getClass();
        x0Var.a(vVar.getClass()).b(vVar);
        vVar.n();
        return this.f2287g;
    }

    public final t c() {
        t tVarO = this.f2286f.c();
        tVarO.f2287g = b();
        return tVarO;
    }

    public final void d() {
        if (this.f2287g.m()) {
            return;
        }
        v vVarP = this.f2286f.p();
        e(vVarP, this.f2287g);
        this.f2287g = vVarP;
    }
}
