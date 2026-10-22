package m;

import n.b1;

/* loaded from: classes.dex */
public final class j extends q7.m implements p7.n {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ b1 f6070g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ y f6071h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ z f6072i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ j0.d f6073j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ int f6074k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(b1 b1Var, y yVar, z zVar, j0.d dVar, int i2) {
        super(2);
        this.f6070g = b1Var;
        this.f6071h = yVar;
        this.f6072i = zVar;
        this.f6073j = dVar;
        this.f6074k = i2;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        ((Number) obj2).intValue();
        androidx.compose.animation.a.c(this.f6070g, this.f6071h, this.f6072i, this.f6073j, (b0.p) obj, b0.b.s(this.f6074k | 1));
        return c7.r.f1986a;
    }
}
