package b0;

import d2.l0;
import r.h0;
import r.i0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m extends yb.l implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1763c = 0;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f1764f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ w0.m f1765g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f1766h;
    public final /* synthetic */ int i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f1767j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f1768k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f1769l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ jb.b f1770m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(d2.g gVar, w0.m mVar, l0 l0Var, boolean z10, int i, int i3, xb.l lVar, xb.l lVar2, int i10) {
        super(2);
        this.f1767j = gVar;
        this.f1765g = mVar;
        this.f1768k = l0Var;
        this.f1764f = z10;
        this.f1766h = i;
        this.i = i3;
        this.f1769l = lVar;
        this.f1770m = lVar2;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f1763c) {
            case 0:
                ((Number) obj2).intValue();
                d2.g gVar = (d2.g) this.f1767j;
                l0 l0Var = (l0) this.f1768k;
                xb.l lVar = (xb.l) this.f1769l;
                xb.l lVar2 = (xb.l) this.f1770m;
                a.a.b(gVar, this.f1765g, l0Var, this.f1764f, this.f1766h, this.i, lVar, lVar2, (k0.s) obj, k0.z.D(385));
                break;
            default:
                ((Number) obj2).intValue();
                h0 h0Var = (h0) this.f1767j;
                i0 i0Var = (i0) this.f1768k;
                String str = (String) this.f1769l;
                s0.c cVar = (s0.c) this.f1770m;
                androidx.compose.animation.a.b(this.f1764f, this.f1765g, h0Var, i0Var, str, cVar, (k0.s) obj, k0.z.D(this.f1766h | 1), this.i);
                break;
        }
        return jb.v.f6774a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(boolean z10, w0.m mVar, h0 h0Var, i0 i0Var, String str, s0.c cVar, int i, int i3) {
        super(2);
        this.f1764f = z10;
        this.f1765g = mVar;
        this.f1767j = h0Var;
        this.f1768k = i0Var;
        this.f1769l = str;
        this.f1770m = cVar;
        this.f1766h = i;
        this.i = i3;
    }
}
