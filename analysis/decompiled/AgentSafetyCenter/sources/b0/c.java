package b0;

import java.util.List;
import s.e1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends yb.l implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1716c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1717f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f1718g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f1719h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(Object obj, int i, int i3, Object obj2) {
        super(2);
        this.f1716c = i3;
        this.f1718g = obj;
        this.f1719h = obj2;
        this.f1717f = i;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        int i = this.f1716c;
        k0.s sVar = (k0.s) obj;
        ((Number) obj2).intValue();
        switch (i) {
            case 0:
                d.a((d2.g) this.f1718g, (List) this.f1719h, sVar, k0.z.D(this.f1717f | 1));
                break;
            case 1:
                ((e1) this.f1718g).a(this.f1719h, sVar, k0.z.D(this.f1717f | 1));
                break;
            case 2:
                id.c.c((w0.m) this.f1718g, (xb.p) this.f1719h, sVar, k0.z.D(this.f1717f | 1));
                break;
            default:
                t.n.a((w0.m) this.f1718g, (xb.l) this.f1719h, sVar, k0.z.D(this.f1717f | 1));
                break;
        }
        return jb.v.f6774a;
    }
}
