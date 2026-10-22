package m;

import n.b1;

/* loaded from: classes.dex */
public final class e extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f6054g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ b1 f6055h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(b1 b1Var, int i2) {
        super(0);
        this.f6054g = i2;
        this.f6055h = b1Var;
    }

    @Override // p7.a
    public final Object c() {
        switch (this.f6054g) {
            case 0:
                b1 b1Var = this.f6055h;
                Object objC = b1Var.c();
                n nVar = n.f6082h;
                return Boolean.valueOf(objC == nVar && b1Var.f6549d.getValue() == nVar);
            default:
                return Long.valueOf(this.f6055h.b());
        }
    }
}
