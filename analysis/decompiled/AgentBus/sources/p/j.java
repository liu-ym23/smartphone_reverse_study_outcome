package p;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final class j extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public q7.s f8124f;

    /* renamed from: g, reason: collision with root package name */
    public n.i f8125g;

    /* renamed from: h, reason: collision with root package name */
    public int f8126h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ float f8127i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ nb.f f8128j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ v0 f8129k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(float f10, nb.f fVar, v0 v0Var, g7.d dVar) {
        super(2, dVar);
        this.f8127i = f10;
        this.f8128j = fVar;
        this.f8129k = v0Var;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        return new j(this.f8127i, this.f8128j, this.f8129k, dVar);
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((j) create((ia.b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        float f10;
        q7.s sVar;
        n.i iVar;
        Object objB;
        Object obj2 = h7.a.f4212f;
        int i2 = this.f8126h;
        if (i2 == 0) {
            w7.e0.N(obj);
            f10 = this.f8127i;
            if (Math.abs(f10) > 1.0f) {
                q7.s sVar2 = new q7.s();
                sVar2.f8817f = f10;
                q7.s sVar3 = new q7.s();
                q6.b bVar = n.g1.f6621a;
                n.i iVar2 = new n.i(bVar, Float.valueOf(0.0f), new n.j(f10), Long.MIN_VALUE, Long.MIN_VALUE, false);
                try {
                    nb.f fVar = this.f8128j;
                    a7.d dVar = (a7.d) fVar.f6947g;
                    n.b0 b0Var = new n.b0(sVar3, this.f8129k, sVar2, fVar);
                    this.f8124f = sVar2;
                    this.f8125g = iVar2;
                    this.f8126h = 1;
                    objB = n.d.b(iVar2, new h4.a(dVar, bVar, iVar2.f6632g.getValue(), iVar2.f6633h), Long.MIN_VALUE, b0Var, this);
                    if (objB != obj2) {
                        objB = c7.r.f1986a;
                    }
                } catch (CancellationException unused) {
                    sVar = sVar2;
                    iVar = iVar2;
                    sVar.f8817f = ((Number) ((p7.k) iVar.f6631f.f8787g).invoke(iVar.f6633h)).floatValue();
                    f10 = sVar.f8817f;
                    return new Float(f10);
                }
                if (objB == obj2) {
                    return obj2;
                }
                sVar = sVar2;
                f10 = sVar.f8817f;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            iVar = this.f8125g;
            sVar = this.f8124f;
            try {
                w7.e0.N(obj);
            } catch (CancellationException unused2) {
                sVar.f8817f = ((Number) ((p7.k) iVar.f6631f.f8787g).invoke(iVar.f6633h)).floatValue();
                f10 = sVar.f8817f;
                return new Float(f10);
            }
            f10 = sVar.f8817f;
        }
        return new Float(f10);
    }
}
