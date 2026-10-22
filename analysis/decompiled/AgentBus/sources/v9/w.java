package v9;

import java.util.List;

/* loaded from: classes.dex */
public final class w extends q7.m implements p7.k {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f10597g = 1;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ m0 f10598h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ List f10599i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(List list, o9.n nVar, i0 i0Var, m0 m0Var, boolean z4) {
        super(1);
        this.f10598h = m0Var;
        this.f10599i = list;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        switch (this.f10597g) {
            case 0:
                q7.k.e((w9.g) obj, "refiner");
                this.f10598h.c();
                break;
            default:
                q7.k.e((w9.g) obj, "kotlinTypeRefiner");
                this.f10598h.c();
                break;
        }
        return null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(List list, i0 i0Var, m0 m0Var, boolean z4) {
        super(1);
        this.f10598h = m0Var;
        this.f10599i = list;
    }
}
