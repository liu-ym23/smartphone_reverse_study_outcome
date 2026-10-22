package w;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e implements f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14966a;

    @Override // w.f
    public final void b(o2.c cVar, int i, int[] iArr, o2.l lVar, int[] iArr2) {
        switch (this.f14966a) {
            case 0:
                if (lVar != o2.l.f9123c) {
                    k.b(iArr, iArr2, true);
                    break;
                } else {
                    k.c(i, iArr, iArr2, false);
                    break;
                }
            default:
                if (lVar != o2.l.f9123c) {
                    k.c(i, iArr, iArr2, true);
                    break;
                } else {
                    k.b(iArr, iArr2, false);
                    break;
                }
        }
    }

    public final String toString() {
        switch (this.f14966a) {
            case 0:
                return "Arrangement#End";
            default:
                return "Arrangement#Start";
        }
    }
}
