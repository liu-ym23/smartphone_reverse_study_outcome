package m;

import n.v0;

/* loaded from: classes.dex */
public final class p extends q7.m implements p7.k {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f6088g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ y f6089h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ z f6090i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p(y yVar, z zVar, int i2) {
        super(1);
        this.f6088g = i2;
        this.f6089h = yVar;
        this.f6090i = zVar;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        switch (this.f6088g) {
            case 0:
                v0 v0Var = (v0) obj;
                n nVar = n.f6080f;
                n nVar2 = n.f6081g;
                if (!v0Var.a(nVar, nVar2) && v0Var.a(nVar2, n.f6082h)) {
                    return t.f6098a;
                }
                return t.f6098a;
            default:
                int iOrdinal = ((n) obj).ordinal();
                if (iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2) {
                    return Float.valueOf(1.0f);
                }
                throw new a4.u();
        }
    }
}
