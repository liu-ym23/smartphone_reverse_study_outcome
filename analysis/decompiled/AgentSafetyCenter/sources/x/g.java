package x;

import jb.v;
import k0.z;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends yb.l implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f15408c = 1;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ h f15409f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f15410g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f15411h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(int i, Object obj, h hVar) {
        super(2);
        this.f15409f = hVar;
        this.f15410g = i;
        this.f15411h = obj;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f15408c) {
            case 0:
                ((Number) obj2).intValue();
                int iD = z.D(1);
                this.f15409f.a(this.f15410g, this.f15411h, (k0.s) obj, iD);
                break;
            default:
                k0.s sVar = (k0.s) obj;
                if ((((Number) obj2).intValue() & 3) == 2 && sVar.B()) {
                    sVar.S();
                } else {
                    this.f15409f.a(this.f15410g, this.f15411h, sVar, 0);
                }
                break;
        }
        return v.f6774a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(h hVar, int i, Object obj, int i3) {
        super(2);
        this.f15409f = hVar;
        this.f15410g = i;
        this.f15411h = obj;
    }
}
