package a1;

import android.view.ViewGroup;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d extends p {

    /* renamed from: a, reason: collision with root package name */
    public boolean f11a = false;

    /* renamed from: b, reason: collision with root package name */
    public final ViewGroup f12b;

    public d(ViewGroup viewGroup) {
        this.f12b = viewGroup;
    }

    @Override // a1.p, a1.m
    public final void b() {
        x.b(this.f12b, false);
    }

    @Override // a1.p, a1.m
    public final void c(o oVar) {
        x.b(this.f12b, false);
        this.f11a = true;
    }

    @Override // a1.p, a1.m
    public final void d() {
        x.b(this.f12b, true);
    }

    @Override // a1.m
    public final void f(o oVar) {
        if (!this.f11a) {
            x.b(this.f12b, false);
        }
        oVar.x(this);
    }
}
