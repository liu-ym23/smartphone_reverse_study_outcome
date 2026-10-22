package b0;

import java.util.List;

/* loaded from: classes.dex */
public final class e2 extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1137f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f1138g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e2(int i2, g7.d dVar, int i10) {
        super(i2, dVar);
        this.f1137f = i10;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f1137f) {
            case 0:
                e2 e2Var = new e2(2, dVar, 0);
                e2Var.f1138g = obj;
                return e2Var;
            case 1:
                e2 e2Var2 = new e2(2, dVar, 1);
                e2Var2.f1138g = obj;
                return e2Var2;
            case 2:
                e2 e2Var3 = new e2(2, dVar, 2);
                e2Var3.f1138g = obj;
                return e2Var3;
            case 3:
                e2 e2Var4 = new e2(2, dVar, 3);
                e2Var4.f1138g = obj;
                return e2Var4;
            case 4:
                e2 e2Var5 = new e2(2, dVar, 4);
                e2Var5.f1138g = obj;
                return e2Var5;
            default:
                e2 e2Var6 = new e2(2, dVar, 5);
                e2Var6.f1138g = obj;
                return e2Var6;
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f1137f) {
            case 0:
                return ((e2) create((d2) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
            case 1:
                return ((e2) create((d5.r) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
            case 2:
                return ((e2) create((la.m0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
            case 3:
                return ((e2) create((o4.h1) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
            case 4:
                return ((e2) create((s2.h0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
            default:
                return ((e2) create((List) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
        }
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f1137f) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                w7.e0.N(obj);
                return Boolean.valueOf(((d2) this.f1138g) == d2.f1123f);
            case 1:
                h7.a aVar2 = h7.a.f4212f;
                w7.e0.N(obj);
                d5.r rVar = (d5.r) this.f1138g;
                return Boolean.valueOf((rVar instanceof d5.q) || (rVar instanceof d5.o));
            case 2:
                h7.a aVar3 = h7.a.f4212f;
                w7.e0.N(obj);
                return Boolean.valueOf(((la.m0) this.f1138g) != la.m0.f5958f);
            case 3:
                h7.a aVar4 = h7.a.f4212f;
                w7.e0.N(obj);
                return Boolean.valueOf(((o4.h1) this.f1138g) == o4.h1.ONLINE);
            case 4:
                h7.a aVar5 = h7.a.f4212f;
                w7.e0.N(obj);
                return Boolean.valueOf(!(((s2.h0) this.f1138g) instanceof s2.a0));
            default:
                h7.a aVar6 = h7.a.f4212f;
                w7.e0.N(obj);
                return Boolean.valueOf(!((List) this.f1138g).isEmpty());
        }
    }
}
