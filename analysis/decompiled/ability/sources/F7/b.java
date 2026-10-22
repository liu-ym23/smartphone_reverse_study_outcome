package F7;

import java.util.Comparator;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class b implements Comparator {
    public static final b b = new b(0);
    public static final b c = new b(1);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f588a;

    public /* synthetic */ b(int i) {
        this.f588a = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f588a) {
            case 0:
                Comparable a3 = (Comparable) obj;
                Comparable b5 = (Comparable) obj2;
                k.f(a3, "a");
                k.f(b5, "b");
                return a3.compareTo(b5);
            default:
                Comparable a4 = (Comparable) obj;
                Comparable b10 = (Comparable) obj2;
                k.f(a4, "a");
                k.f(b10, "b");
                return b10.compareTo(a4);
        }
    }

    @Override // java.util.Comparator
    public final Comparator reversed() {
        switch (this.f588a) {
            case 0:
                return c;
            default:
                return b;
        }
    }
}
