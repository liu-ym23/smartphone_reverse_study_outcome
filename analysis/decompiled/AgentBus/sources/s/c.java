package s;

import b0.f2;
import c7.r;
import eb.k;
import i1.d1;
import i7.i;
import ia.b0;
import ia.d0;
import p.v;
import p7.n;
import q7.m;
import w7.e0;

/* loaded from: classes.dex */
public final class c extends i implements n {

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f9153f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ d f9154g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ d1 f9155h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ m f9156i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ k f9157j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public c(d dVar, d1 d1Var, p7.a aVar, k kVar, g7.d dVar2) {
        super(2, dVar2);
        this.f9154g = dVar;
        this.f9155h = d1Var;
        this.f9156i = (m) aVar;
        this.f9157j = kVar;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [p7.a, q7.m] */
    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        c cVar = new c(this.f9154g, this.f9155h, this.f9156i, this.f9157j, dVar);
        cVar.f9153f = obj;
        return cVar;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((c) create((b0) obj, (g7.d) obj2)).invokeSuspend(r.f1986a);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [p7.a, q7.m] */
    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        h7.a aVar = h7.a.f4212f;
        e0.N(obj);
        b0 b0Var = (b0) this.f9153f;
        d1 d1Var = this.f9155h;
        ?? r22 = this.f9156i;
        d dVar = this.f9154g;
        d0.s(b0Var, null, null, new f2(dVar, d1Var, (p7.a) r22, (g7.d) null), 3);
        return d0.s(b0Var, null, null, new v(dVar, this.f9157j, null, 2), 3);
    }
}
