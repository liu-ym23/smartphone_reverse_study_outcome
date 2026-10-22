package v1;

import android.view.View;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f14527c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f14528f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(x.r rVar, int i) {
        super(1);
        this.f14527c = 2;
        this.f14528f = i;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        switch (this.f14527c) {
            case 0:
                return Boolean.valueOf(((b1.q) obj).F0(this.f14528f));
            case 1:
                return Boolean.valueOf(((View) obj).getId() == this.f14528f);
            default:
                y.c0 c0Var = (y.c0) obj;
                u0.f fVarD = u0.r.d();
                u0.r.j(fVarD, u0.r.g(fVarD), fVarD != null ? fVarD.e() : null);
                c0Var.getClass();
                long j10 = y.f0.f15739a;
                throw null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(int i, int i3) {
        super(1);
        this.f14527c = i3;
        this.f14528f = i;
    }
}
