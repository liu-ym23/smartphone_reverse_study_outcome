package V8;

import D7.N;

/* loaded from: classes4.dex */
public final class m implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1398a;
    public final o b;
    public final p c;

    public /* synthetic */ m(o oVar, p pVar, int i) {
        this.f1398a = i;
        this.b = oVar;
        this.c = pVar;
    }

    @Override // S7.a
    public final Object invoke() {
        switch (this.f1398a) {
            case 0:
                return N.L(this.b.f1401a.keySet(), this.c.n());
            default:
                return N.L(this.b.b.keySet(), this.c.o());
        }
    }
}
