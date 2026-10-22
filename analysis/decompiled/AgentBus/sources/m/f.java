package m;

import n.v0;

/* loaded from: classes.dex */
public final class f extends q7.m implements p7.k {

    /* renamed from: h, reason: collision with root package name */
    public static final f f6059h;

    /* renamed from: i, reason: collision with root package name */
    public static final f f6060i;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f6061g;

    static {
        int i2 = 1;
        f6059h = new f(i2, 0);
        f6060i = new f(i2, 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(int i2, int i10) {
        super(i2);
        this.f6061g = i10;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        switch (this.f6061g) {
            case 0:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                return bool;
            case 1:
                return t.f6099b;
            case 2:
                return new d2.k(ib.k.a((int) (((d2.k) obj).f2792a >> 32), 0));
            case 3:
                return new d2.k(ib.k.a((int) (((d2.k) obj).f2792a >> 32), 0));
            default:
                v0 v0Var = (v0) obj;
                n nVar = n.f6080f;
                n nVar2 = n.f6081g;
                if (!v0Var.a(nVar, nVar2) && v0Var.a(nVar2, n.f6082h)) {
                    return t.f6099b;
                }
                return t.f6099b;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(w wVar) {
        super(1);
        this.f6061g = 4;
    }
}
