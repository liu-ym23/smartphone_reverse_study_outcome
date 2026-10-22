package u;

import b0.p;
import c7.r;
import n7.o;
import p7.n;
import q7.m;
import s1.h0;

/* loaded from: classes.dex */
public final class a extends m implements n {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f9859g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ n0.m f9860h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ h0 f9861i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f9862j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ boolean f9863k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f9864l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f9865m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ int f9866n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String str, n0.m mVar, h0 h0Var, int i2, boolean z4, int i10, int i11, int i12) {
        super(2);
        this.f9859g = str;
        this.f9860h = mVar;
        this.f9861i = h0Var;
        this.f9862j = i2;
        this.f9863k = z4;
        this.f9864l = i10;
        this.f9865m = i11;
        this.f9866n = i12;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        ((Number) obj2).intValue();
        o.a(this.f9859g, this.f9860h, this.f9861i, this.f9862j, this.f9863k, this.f9864l, this.f9865m, (p) obj, b0.b.s(this.f9866n | 1));
        return r.f1986a;
    }
}
