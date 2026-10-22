package q;

import java.util.ConcurrentModificationException;
import r.C0990a;

/* renamed from: q.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0936d {
    public static final <E> void a(C0934b<E> c0934b, int i5) {
        j4.k.g(c0934b, "<this>");
        c0934b.o(new int[i5]);
        c0934b.n(new Object[i5]);
    }

    public static final <E> int b(C0934b<E> c0934b, int i5) {
        j4.k.g(c0934b, "<this>");
        try {
            return C0990a.a(c0934b.f(), c0934b.i(), i5);
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static final <E> int c(C0934b<E> c0934b, Object obj, int i5) {
        j4.k.g(c0934b, "<this>");
        int i6 = c0934b.i();
        if (i6 == 0) {
            return -1;
        }
        int iB = b(c0934b, i5);
        if (iB < 0 || j4.k.b(obj, c0934b.c()[iB])) {
            return iB;
        }
        int i7 = iB + 1;
        while (i7 < i6 && c0934b.f()[i7] == i5) {
            if (j4.k.b(obj, c0934b.c()[i7])) {
                return i7;
            }
            i7++;
        }
        for (int i8 = iB - 1; i8 >= 0 && c0934b.f()[i8] == i5; i8--) {
            if (j4.k.b(obj, c0934b.c()[i8])) {
                return i8;
            }
        }
        return ~i7;
    }

    public static final <E> int d(C0934b<E> c0934b) {
        j4.k.g(c0934b, "<this>");
        return c(c0934b, null, 0);
    }
}
