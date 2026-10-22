package f7;

import java.util.Comparator;
import q7.k;

/* loaded from: classes.dex */
public final class b implements Comparator {

    /* renamed from: b, reason: collision with root package name */
    public static final b f3457b = new b(0);

    /* renamed from: c, reason: collision with root package name */
    public static final b f3458c = new b(1);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3459a;

    public /* synthetic */ b(int i2) {
        this.f3459a = i2;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f3459a) {
            case 0:
                Comparable comparable = (Comparable) obj;
                Comparable comparable2 = (Comparable) obj2;
                k.e(comparable, "a");
                k.e(comparable2, "b");
                return comparable.compareTo(comparable2);
            default:
                Comparable comparable3 = (Comparable) obj;
                Comparable comparable4 = (Comparable) obj2;
                k.e(comparable3, "a");
                k.e(comparable4, "b");
                return comparable4.compareTo(comparable3);
        }
    }

    @Override // java.util.Comparator
    public final Comparator reversed() {
        switch (this.f3459a) {
            case 0:
                return f3458c;
            default:
                return f3457b;
        }
    }
}
