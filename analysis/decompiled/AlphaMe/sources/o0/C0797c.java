package o0;

import android.view.ViewGroup;

/* renamed from: o0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0797c extends t {

    /* renamed from: a, reason: collision with root package name */
    public boolean f13694a = false;

    /* renamed from: b, reason: collision with root package name */
    public final ViewGroup f13695b;

    public C0797c(ViewGroup viewGroup) {
        this.f13695b = viewGroup;
    }

    @Override // o0.t, o0.q
    public final void a() {
        AbstractC0786B.b(this.f13695b, false);
    }

    @Override // o0.t, o0.q
    public final void b() {
        AbstractC0786B.b(this.f13695b, true);
    }

    @Override // o0.t, o0.q
    public final void d(s sVar) {
        AbstractC0786B.b(this.f13695b, false);
        this.f13694a = true;
    }

    @Override // o0.q
    public final void f(s sVar) {
        if (!this.f13694a) {
            AbstractC0786B.b(this.f13695b, false);
        }
        sVar.y(this);
    }
}
