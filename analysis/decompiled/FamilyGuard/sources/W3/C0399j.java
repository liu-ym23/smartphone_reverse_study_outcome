package W3;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: W3.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0399j extends C0398i {
    public static <T> List<T> c(T[] tArr) {
        j4.k.g(tArr, "<this>");
        List<T> listA = C0401l.a(tArr);
        j4.k.f(listA, "asList(...)");
        return listA;
    }

    public static int[] d(int[] iArr, int[] iArr2, int i5, int i6, int i7) {
        j4.k.g(iArr, "<this>");
        j4.k.g(iArr2, "destination");
        System.arraycopy(iArr, i6, iArr2, i5, i7 - i6);
        return iArr2;
    }

    public static long[] e(long[] jArr, long[] jArr2, int i5, int i6, int i7) {
        j4.k.g(jArr, "<this>");
        j4.k.g(jArr2, "destination");
        System.arraycopy(jArr, i6, jArr2, i5, i7 - i6);
        return jArr2;
    }

    public static <T> T[] f(T[] tArr, T[] tArr2, int i5, int i6, int i7) {
        j4.k.g(tArr, "<this>");
        j4.k.g(tArr2, "destination");
        System.arraycopy(tArr, i6, tArr2, i5, i7 - i6);
        return tArr2;
    }

    public static /* synthetic */ int[] g(int[] iArr, int[] iArr2, int i5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i5 = 0;
        }
        if ((i8 & 4) != 0) {
            i6 = 0;
        }
        if ((i8 & 8) != 0) {
            i7 = iArr.length;
        }
        return d(iArr, iArr2, i5, i6, i7);
    }

    public static /* synthetic */ Object[] h(Object[] objArr, Object[] objArr2, int i5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i5 = 0;
        }
        if ((i8 & 4) != 0) {
            i6 = 0;
        }
        if ((i8 & 8) != 0) {
            i7 = objArr.length;
        }
        return f(objArr, objArr2, i5, i6, i7);
    }

    public static <T> T[] i(T[] tArr, int i5, int i6) {
        j4.k.g(tArr, "<this>");
        C0397h.b(i6, tArr.length);
        T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i5, i6);
        j4.k.f(tArr2, "copyOfRange(...)");
        return tArr2;
    }

    public static final <T> void j(T[] tArr, T t5, int i5, int i6) {
        j4.k.g(tArr, "<this>");
        Arrays.fill(tArr, i5, i6, t5);
    }

    public static final <T> void k(T[] tArr) {
        j4.k.g(tArr, "<this>");
        if (tArr.length > 1) {
            Arrays.sort(tArr);
        }
    }
}
