package m0;

import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class f {
    public static final void a(int i, List list) {
        int size = list.size();
        if (i < 0 || i >= size) {
            c(i, size);
        }
    }

    public static final void b(List list, int i, int i3) {
        if (i > i3) {
            f(i, i3);
        }
        if (i < 0) {
            d(i);
        }
        if (i3 > list.size()) {
            e(i3, list.size());
        }
    }

    private static final void c(int i, int i3) {
        throw new IndexOutOfBoundsException("Index " + i + " is out of bounds. The list has " + i3 + " elements.");
    }

    private static final void d(int i) {
        throw new IndexOutOfBoundsException(k0.a.k(i, "fromIndex (", ") is less than 0."));
    }

    private static final void e(int i, int i3) {
        throw new IndexOutOfBoundsException("toIndex (" + i + ") is more than than the list size (" + i3 + ')');
    }

    private static final void f(int i, int i3) {
        throw new IllegalArgumentException("Indices are out of order. fromIndex (" + i + ") is greater than toIndex (" + i3 + ").");
    }
}
