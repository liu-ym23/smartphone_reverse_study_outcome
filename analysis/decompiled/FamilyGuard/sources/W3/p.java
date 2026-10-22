package W3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends o {
    public static final <T> Collection<T> d(T[] tArr, boolean z5) {
        j4.k.g(tArr, "<this>");
        return new C0394e(tArr, z5);
    }

    public static /* synthetic */ Collection e(Object[] objArr, boolean z5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = false;
        }
        return d(objArr, z5);
    }

    public static final <T extends Comparable<? super T>> int f(List<? extends T> list, T t5, int i5, int i6) {
        j4.k.g(list, "<this>");
        p(list.size(), i5, i6);
        int i7 = i6 - 1;
        while (i5 <= i7) {
            int i8 = (i5 + i7) >>> 1;
            int iA = X3.a.a(list.get(i8), t5);
            if (iA < 0) {
                i5 = i8 + 1;
            } else {
                if (iA <= 0) {
                    return i8;
                }
                i7 = i8 - 1;
            }
        }
        return -(i5 + 1);
    }

    public static /* synthetic */ int g(List list, Comparable comparable, int i5, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i5 = 0;
        }
        if ((i7 & 4) != 0) {
            i6 = list.size();
        }
        return f(list, comparable, i5, i6);
    }

    public static <T> List<T> h() {
        return z.f5763a;
    }

    public static kotlin.ranges.h i(Collection<?> collection) {
        j4.k.g(collection, "<this>");
        return new kotlin.ranges.h(0, collection.size() - 1);
    }

    public static <T> int j(List<? extends T> list) {
        j4.k.g(list, "<this>");
        return list.size() - 1;
    }

    public static <T> List<T> k(T... tArr) {
        j4.k.g(tArr, "elements");
        return tArr.length > 0 ? C0399j.c(tArr) : h();
    }

    public static <T> List<T> l(T t5) {
        return t5 != null ? o.b(t5) : h();
    }

    public static <T> List<T> m(T... tArr) {
        j4.k.g(tArr, "elements");
        return C0400k.m(tArr);
    }

    public static <T> List<T> n(T... tArr) {
        j4.k.g(tArr, "elements");
        return tArr.length == 0 ? new ArrayList() : new ArrayList(d(tArr, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> o(List<? extends T> list) {
        j4.k.g(list, "<this>");
        int size = list.size();
        return size != 0 ? size != 1 ? list : o.b(list.get(0)) : h();
    }

    private static final void p(int i5, int i6, int i7) {
        if (i6 > i7) {
            throw new IllegalArgumentException("fromIndex (" + i6 + ") is greater than toIndex (" + i7 + ").");
        }
        if (i6 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i6 + ") is less than zero.");
        }
        if (i7 <= i5) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i7 + ") is greater than size (" + i5 + ").");
    }

    public static void q() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
