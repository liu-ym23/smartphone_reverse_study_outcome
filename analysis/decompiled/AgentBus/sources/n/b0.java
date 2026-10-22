package n;

import b0.b3;

/* loaded from: classes.dex */
public final class b0 extends q7.m implements p7.k {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f6541g = 0;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ q7.s f6542h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f6543i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f6544j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f6545k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(b0.f1 f1Var, d0 d0Var, q7.s sVar, ia.b0 b0Var) {
        super(1);
        this.f6543i = f1Var;
        this.f6544j = d0Var;
        this.f6542h = sVar;
        this.f6545k = b0Var;
    }

    /* JADX WARN: Type inference failed for: r13v13, types: [p7.a, q7.m] */
    @Override // p7.k
    public final Object invoke(Object obj) {
        boolean z4;
        switch (this.f6541g) {
            case 0:
                long jLongValue = ((Number) obj).longValue();
                ia.b0 b0Var = (ia.b0) this.f6545k;
                d0 d0Var = (d0) this.f6544j;
                b3 b3Var = (b3) ((b0.f1) this.f6543i).getValue();
                long jLongValue2 = b3Var != null ? ((Number) b3Var.getValue()).longValue() : jLongValue;
                long j2 = d0Var.f6598c;
                d0.e eVar = d0Var.f6596a;
                int i2 = 0;
                q7.s sVar = this.f6542h;
                if (j2 == Long.MIN_VALUE || sVar.f8817f != d.g(b0Var.k())) {
                    d0Var.f6598c = jLongValue;
                    int i10 = eVar.f2751h;
                    if (i10 > 0) {
                        Object[] objArr = eVar.f2749f;
                        int i11 = 0;
                        do {
                            ((a0) objArr[i11]).f6533l = true;
                            i11++;
                        } while (i11 < i10);
                    }
                    sVar.f8817f = d.g(b0Var.k());
                }
                float f10 = sVar.f8817f;
                if (f10 == 0.0f) {
                    int i12 = eVar.f2751h;
                    if (i12 > 0) {
                        Object[] objArr2 = eVar.f2749f;
                        do {
                            a0 a0Var = (a0) objArr2[i2];
                            a0Var.f6530i.setValue(a0Var.f6531j.f6725c);
                            a0Var.f6533l = true;
                            i2++;
                        } while (i2 < i12);
                    }
                } else {
                    long j4 = (long) ((jLongValue2 - d0Var.f6598c) / f10);
                    int i13 = eVar.f2751h;
                    if (i13 > 0) {
                        Object[] objArr3 = eVar.f2749f;
                        int i14 = 0;
                        z4 = true;
                        do {
                            a0 a0Var2 = (a0) objArr3[i14];
                            if (!a0Var2.f6532k) {
                                a0Var2.f6535n.f6597b.setValue(Boolean.FALSE);
                                if (a0Var2.f6533l) {
                                    a0Var2.f6533l = false;
                                    a0Var2.f6534m = j4;
                                }
                                long j10 = j4 - a0Var2.f6534m;
                                a0Var2.f6530i.setValue(a0Var2.f6531j.c(j10));
                                a0Var2.f6532k = a0Var2.f6531j.i(j10);
                            }
                            if (!a0Var2.f6532k) {
                                z4 = false;
                            }
                            i14++;
                        } while (i14 < i13);
                    } else {
                        z4 = true;
                    }
                    d0Var.f6599d.setValue(Boolean.valueOf(!z4));
                }
                break;
            default:
                g gVar = (g) obj;
                float fFloatValue = ((Number) gVar.f6615e.getValue()).floatValue();
                q7.s sVar2 = this.f6542h;
                float f11 = fFloatValue - sVar2.f8817f;
                float fA = ((p.v0) this.f6543i).a(f11);
                sVar2.f8817f = ((Number) gVar.f6615e.getValue()).floatValue();
                ((q7.s) this.f6544j).f8817f = ((Number) ((p7.k) gVar.f6611a.f8787g).invoke(gVar.f6616f)).floatValue();
                if (Math.abs(f11 - fA) > 0.5f) {
                    gVar.f6619i.setValue(Boolean.FALSE);
                    gVar.f6614d.c();
                }
                ((nb.f) this.f6545k).getClass();
                break;
        }
        return c7.r.f1986a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(q7.s sVar, p.v0 v0Var, q7.s sVar2, nb.f fVar) {
        super(1);
        this.f6542h = sVar;
        this.f6543i = v0Var;
        this.f6544j = sVar2;
        this.f6545k = fVar;
    }
}
