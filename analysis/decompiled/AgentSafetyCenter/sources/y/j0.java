package y;

import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j0 extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f15768c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ t0.g f15769f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j0(t0.g gVar, int i) {
        super(1);
        this.f15768c = i;
        this.f15769f = gVar;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        switch (this.f15768c) {
            case 0:
                t0.g gVar = this.f15769f;
                return Boolean.valueOf(gVar != null ? gVar.a(obj) : true);
            default:
                return new l0(this.f15769f, (Map) obj);
        }
    }
}
