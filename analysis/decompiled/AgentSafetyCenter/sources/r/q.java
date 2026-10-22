package r;

import s.e1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q extends yb.l implements xb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10335c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ e1 f10336f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q(e1 e1Var, int i) {
        super(0);
        this.f10335c = i;
        this.f10336f = e1Var;
    }

    @Override // xb.a
    public final Object invoke() {
        switch (this.f10335c) {
            case 0:
                e1 e1Var = this.f10336f;
                Object objC = e1Var.c();
                w wVar = w.f10350g;
                return Boolean.valueOf(objC == wVar && e1Var.f10992d.getValue() == wVar);
            default:
                return Long.valueOf(this.f10336f.b());
        }
    }
}
