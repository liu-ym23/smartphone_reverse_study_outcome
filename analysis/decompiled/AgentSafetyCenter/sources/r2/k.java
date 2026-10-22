package r2;

import jb.v;
import k0.s;
import k0.z;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k extends yb.l implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10413c = 1;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ xb.l f10414f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ w0.m f10415g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ xb.l f10416h;
    public final /* synthetic */ int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(xb.l lVar, w0.m mVar, xb.l lVar2, int i) {
        super(2);
        this.f10414f = lVar;
        this.f10415g = mVar;
        this.f10416h = lVar2;
        this.i = i;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f10413c) {
            case 0:
                ((Number) obj2).intValue();
                int iD = z.D(1);
                int i = this.i;
                androidx.compose.ui.viewinterop.a.b(this.f10414f, this.f10415g, this.f10416h, (s) obj, iD, i);
                break;
            default:
                ((Number) obj2).intValue();
                int iD2 = z.D(this.i | 1);
                androidx.compose.ui.viewinterop.a.a(this.f10414f, this.f10415g, this.f10416h, (s) obj, iD2);
                break;
        }
        return v.f6774a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(xb.l lVar, w0.m mVar, xb.l lVar2, int i, int i3) {
        super(2);
        this.f10414f = lVar;
        this.f10415g = mVar;
        this.f10416h = lVar2;
        this.i = i3;
    }
}
