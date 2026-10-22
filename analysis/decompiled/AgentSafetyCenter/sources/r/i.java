package r;

import s.e1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i extends yb.l implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10298c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ e1 f10299f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ w0.m f10300g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ s0.c f10301h;
    public final /* synthetic */ int i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f10302j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f10303k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(e1 e1Var, w0.m mVar, Object obj, Object obj2, s0.c cVar, int i, int i3) {
        super(2);
        this.f10298c = i3;
        this.f10299f = e1Var;
        this.f10300g = mVar;
        this.f10302j = obj;
        this.f10303k = obj2;
        this.f10301h = cVar;
        this.i = i;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f10298c) {
            case 0:
                ((Number) obj2).intValue();
                xb.l lVar = (xb.l) this.f10302j;
                xb.l lVar2 = (xb.l) this.f10303k;
                h5.t.b(this.f10299f, this.f10300g, lVar, lVar2, this.f10301h, (k0.s) obj, k0.z.D(this.i | 1));
                break;
            default:
                ((Number) obj2).intValue();
                h0 h0Var = (h0) this.f10302j;
                i0 i0Var = (i0) this.f10303k;
                androidx.compose.animation.a.c(this.f10299f, this.f10300g, h0Var, i0Var, this.f10301h, (k0.s) obj, k0.z.D(this.i | 1));
                break;
        }
        return jb.v.f6774a;
    }
}
