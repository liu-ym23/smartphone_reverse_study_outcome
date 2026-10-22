package o4;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k implements r, androidx.room.m {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9195a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f9196b;

    public /* synthetic */ k(int i) {
        this.f9195a = i;
    }

    @Override // o4.r
    public final x4.a b() {
        switch (this.f9195a) {
            case 0:
                return ((q) this.f9196b).f9219a;
            default:
                return ((p4.d) this.f9196b).f9703a;
        }
    }

    @Override // androidx.room.m
    public final Object d(String str, xb.l lVar, pb.c cVar) {
        switch (this.f9195a) {
            case 0:
                return ((q) this.f9196b).d(str, lVar, cVar);
            default:
                return ((p4.d) this.f9196b).d(str, lVar, cVar);
        }
    }
}
