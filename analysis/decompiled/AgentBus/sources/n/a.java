package n;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final class a extends i7.i implements p7.k {

    /* renamed from: f, reason: collision with root package name */
    public i f6520f;

    /* renamed from: g, reason: collision with root package name */
    public q7.r f6521g;

    /* renamed from: h, reason: collision with root package name */
    public int f6522h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ c f6523i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f6524j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ s0 f6525k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ long f6526l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c cVar, Object obj, s0 s0Var, long j2, g7.d dVar) {
        super(1, dVar);
        this.f6523i = cVar;
        this.f6524j = obj;
        this.f6525k = s0Var;
        this.f6526l = j2;
    }

    @Override // i7.a
    public final g7.d create(g7.d dVar) {
        return new a(this.f6523i, this.f6524j, this.f6525k, this.f6526l, dVar);
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        return ((a) create((g7.d) obj)).invokeSuspend(c7.r.f1986a);
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        i iVar;
        q7.r rVar;
        s0 s0Var = this.f6525k;
        h7.a aVar = h7.a.f4212f;
        int i2 = this.f6522h;
        int i10 = 1;
        c cVar = this.f6523i;
        try {
            if (i2 == 0) {
                w7.e0.N(obj);
                cVar.f6559c.f6633h = (n) ((p7.k) cVar.f6557a.f8788h).invoke(this.f6524j);
                cVar.f6561e.setValue(s0Var.f6725c);
                cVar.f6560d.setValue(Boolean.TRUE);
                i iVar2 = cVar.f6559c;
                i iVar3 = new i(iVar2.f6631f, iVar2.f6632g.getValue(), d.e(iVar2.f6633h), iVar2.f6634i, Long.MIN_VALUE, iVar2.f6636k);
                q7.r rVar2 = new q7.r();
                long j2 = this.f6526l;
                m.q qVar = new m.q(cVar, iVar3, rVar2, 1);
                this.f6520f = iVar3;
                this.f6521g = rVar2;
                this.f6522h = 1;
                if (d.b(iVar3, s0Var, j2, qVar, this) == aVar) {
                    return aVar;
                }
                iVar = iVar3;
                rVar = rVar2;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                rVar = this.f6521g;
                iVar = this.f6520f;
                w7.e0.N(obj);
            }
            if (!rVar.f8816f) {
                i10 = 2;
            }
            i iVar4 = cVar.f6559c;
            iVar4.f6633h.d();
            iVar4.f6634i = Long.MIN_VALUE;
            cVar.f6560d.setValue(Boolean.FALSE);
            return new d1.b(i10, 4, iVar);
        } catch (CancellationException e10) {
            i iVar5 = cVar.f6559c;
            iVar5.f6633h.d();
            iVar5.f6634i = Long.MIN_VALUE;
            cVar.f6560d.setValue(Boolean.FALSE);
            throw e10;
        }
    }
}
