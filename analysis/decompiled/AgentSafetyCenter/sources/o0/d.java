package o0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d extends a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f8978g;

    /* renamed from: h, reason: collision with root package name */
    public Object f8979h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(int i, int i3, int i10) {
        super(i, i3);
        this.f8978g = i10;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        switch (this.f8978g) {
            case 0:
                if (!hasNext()) {
                    g5.f.k();
                    break;
                } else {
                    Object[] objArr = (Object[]) this.f8979h;
                    int i = this.f8974c;
                    this.f8974c = i + 1;
                    break;
                }
            default:
                if (!hasNext()) {
                    g5.f.k();
                    break;
                } else {
                    this.f8974c++;
                    break;
                }
        }
        return null;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        switch (this.f8978g) {
            case 0:
                if (!hasPrevious()) {
                    g5.f.k();
                    break;
                } else {
                    Object[] objArr = (Object[]) this.f8979h;
                    int i = this.f8974c - 1;
                    this.f8974c = i;
                    break;
                }
            default:
                if (!hasPrevious()) {
                    g5.f.k();
                    break;
                } else {
                    this.f8974c--;
                    break;
                }
        }
        return null;
    }
}
