package mb;

import java.util.Comparator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements Comparator {

    /* renamed from: f, reason: collision with root package name */
    public static final a f8547f = new a(0);

    /* renamed from: g, reason: collision with root package name */
    public static final a f8548g = new a(1);

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8549c;

    public /* synthetic */ a(int i) {
        this.f8549c = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f8549c) {
            case 0:
                Comparable comparable = (Comparable) obj;
                Comparable comparable2 = (Comparable) obj2;
                comparable.getClass();
                comparable2.getClass();
                return comparable.compareTo(comparable2);
            default:
                Comparable comparable3 = (Comparable) obj;
                Comparable comparable4 = (Comparable) obj2;
                comparable3.getClass();
                comparable4.getClass();
                return comparable4.compareTo(comparable3);
        }
    }

    @Override // java.util.Comparator
    public final Comparator reversed() {
        switch (this.f8549c) {
            case 0:
                return f8548g;
            default:
                return f8547f;
        }
    }
}
