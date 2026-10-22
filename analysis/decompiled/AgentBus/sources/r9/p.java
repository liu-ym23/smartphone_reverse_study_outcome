package r9;

import z8.f0;

/* loaded from: classes.dex */
public final class p extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f9090g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ r f9091h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ f0 f9092i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ t9.q f9093j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p(r rVar, f0 f0Var, t9.q qVar, int i2) {
        super(0);
        this.f9090g = i2;
        this.f9091h = rVar;
        this.f9092i = f0Var;
        this.f9093j = qVar;
    }

    @Override // p7.a
    public final Object c() {
        switch (this.f9090g) {
            case 0:
                r rVar = this.f9091h;
                k kVar = rVar.f9100a;
                a4.e eVarA = rVar.a((f8.j) kVar.f9072h);
                q7.k.b(eVarA);
                a aVar = ((i) kVar.f9070f).f9051e;
                v9.v vVarF = this.f9093j.f();
                q7.k.d(vVarF, "property.returnType");
                return (j9.g) aVar.e(eVarA, this.f9092i, vVarF);
            case 1:
                r rVar2 = this.f9091h;
                u9.k kVar2 = ((i) rVar2.f9100a.f9070f).f9047a;
                p pVar = new p(rVar2, this.f9092i, this.f9093j, 0);
                kVar2.getClass();
                return new u9.h(kVar2, pVar);
            case 2:
                r rVar3 = this.f9091h;
                k kVar3 = rVar3.f9100a;
                a4.e eVarA2 = rVar3.a((f8.j) kVar3.f9072h);
                q7.k.b(eVarA2);
                a aVar2 = ((i) kVar3.f9070f).f9051e;
                v9.v vVarF2 = this.f9093j.f();
                q7.k.d(vVarF2, "property.returnType");
                return (j9.g) aVar2.r(eVarA2, this.f9092i, vVarF2);
            default:
                r rVar4 = this.f9091h;
                u9.k kVar4 = ((i) rVar4.f9100a.f9070f).f9047a;
                p pVar2 = new p(rVar4, this.f9092i, this.f9093j, 2);
                kVar4.getClass();
                return new u9.h(kVar4, pVar2);
        }
    }
}
