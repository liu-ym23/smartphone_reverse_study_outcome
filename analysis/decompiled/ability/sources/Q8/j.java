package Q8;

import D7.v;

/* loaded from: classes4.dex */
public final class j implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1126a;
    public final S7.a b;

    public /* synthetic */ j(int i, S7.a aVar) {
        this.f1126a = i;
        this.b = aVar;
    }

    @Override // S7.a
    public final Object invoke() {
        int i = this.f1126a;
        S7.a aVar = this.b;
        switch (i) {
            case 0:
                o oVar = (o) aVar.invoke();
                return oVar instanceof k ? ((k) oVar).g() : oVar;
            default:
                return v.j1((Iterable) aVar.invoke());
        }
    }
}
