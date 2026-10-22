package com.google.crypto.tink.shaded.protobuf;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class u implements q0, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public final w f1536a;

    /* renamed from: b, reason: collision with root package name */
    public w f1537b;

    public u(w wVar) {
        this.f1536a = wVar;
        if (wVar.n()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.f1537b = wVar.q();
    }

    public static void f(Object obj, Object obj2) {
        y0 y0Var = y0.f1540c;
        y0Var.getClass();
        y0Var.a(obj.getClass()).a(obj, obj2);
    }

    public final w b() {
        w wVarC = c();
        wVarC.getClass();
        if (w.m(wVarC, true)) {
            return wVarC;
        }
        throw new d1();
    }

    public final w c() {
        if (!this.f1537b.n()) {
            return this.f1537b;
        }
        w wVar = this.f1537b;
        wVar.getClass();
        y0 y0Var = y0.f1540c;
        y0Var.getClass();
        y0Var.a(wVar.getClass()).b(wVar);
        wVar.o();
        return this.f1537b;
    }

    public final u d() {
        u uVarP = this.f1536a.d();
        uVarP.f1537b = c();
        return uVarP;
    }

    public final void e() {
        if (this.f1537b.n()) {
            return;
        }
        w wVarQ = this.f1536a.q();
        f(wVarQ, this.f1537b);
        this.f1537b = wVarQ;
    }
}
