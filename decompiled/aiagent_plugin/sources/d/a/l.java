package d.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: _ArraysJvm.kt */
/* JADX INFO: loaded from: classes4.dex */
class l extends k {
    public static final <T> List<T> a(T[] r1) {
        d.h.b.o.e(r1, "<this>");
        List<T> r2 = n.a(r1);
        d.h.b.o.c(r2, "asList(...)");
        return r2;
    }

    public static /* synthetic */ int a(float[] r0, float r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = r0.length;
    L9:
        return i.a(r0, r1, r2, r3);
    }

    public static final int a(float[] r1, float r2, int r3, int r4) {
        d.h.b.o.e(r1, "<this>");
        return Arrays.binarySearch(r1, r3, r4, r2);
    }

    public static /* synthetic */ Object[] a(Object[] r1, Object[] r2, int r3, int r4, int r5, int r6, Object r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r6 & 8) == 0) goto L12;
        r5 = r1.length;
    L12:
        return i.a(r1, r2, r3, r4, r5);
    }

    public static final <T> T[] a(T[] r1, T[] r2, int r3, int r4, int r5) {
        d.h.b.o.e(r1, "<this>");
        d.h.b.o.e(r2, "destination");
        System.arraycopy(r1, r4, r2, r3, r5 - r4);
        return r2;
    }

    public static /* synthetic */ byte[] a(byte[] r1, byte[] r2, int r3, int r4, int r5, int r6, Object r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r6 & 8) == 0) goto L12;
        r5 = r1.length;
    L12:
        return i.a(r1, r2, r3, r4, r5);
    }

    public static final byte[] a(byte[] r1, byte[] r2, int r3, int r4, int r5) {
        d.h.b.o.e(r1, "<this>");
        d.h.b.o.e(r2, "destination");
        System.arraycopy(r1, r4, r2, r3, r5 - r4);
        return r2;
    }

    public static final <T> T[] a(T[] r1, int r2, int r3) {
        d.h.b.o.e(r1, "<this>");
        i.a(r3, r1.length);
        T[] r4 = (T[]) Arrays.copyOfRange(r1, r2, r3);
        d.h.b.o.c(r4, "copyOfRange(...)");
        return r4;
    }

    public static final byte[] a(byte[] r1, int r2, int r3) {
        d.h.b.o.e(r1, "<this>");
        i.a(r3, r1.length);
        byte[] r4 = Arrays.copyOfRange(r1, r2, r3);
        d.h.b.o.c(r4, "copyOfRange(...)");
        return r4;
    }

    public static /* synthetic */ void a(Object[] r0, Object r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = r0.length;
    L8:
        i.a(r0, r1, r2, r3);
    }

    public static final <T> void a(T[] r1, T r2, int r3, int r4) {
        d.h.b.o.e(r1, "<this>");
        Arrays.fill(r1, r3, r4, r2);
    }

    public static final <T> T[] a(T[] r2, T r3) {
        d.h.b.o.e(r2, "<this>");
        int r0 = r2.length;
        T[] r4 = (T[]) Arrays.copyOf(r2, r0 + 1);
        r4[r0] = r3;
        d.h.b.o.a(r4);
        return r4;
    }

    public static final <T> T[] a(T[] r3, T[] r4) {
        d.h.b.o.e(r3, "<this>");
        d.h.b.o.e(r4, "elements");
        int r0 = r3.length;
        int r1 = r4.length;
        T[] r5 = (T[]) Arrays.copyOf(r3, r0 + r1);
        System.arraycopy(r4, 0, r5, r0, r1);
        d.h.b.o.a(r5);
        return r5;
    }

    public static final byte[] a(byte[] r3, byte[] r4) {
        d.h.b.o.e(r3, "<this>");
        d.h.b.o.e(r4, "elements");
        int r0 = r3.length;
        int r1 = r4.length;
        byte[] r5 = Arrays.copyOf(r3, r0 + r1);
        System.arraycopy(r4, 0, r5, r0, r1);
        d.h.b.o.a(r5);
        return r5;
    }

    public static final <T> void b(T[] r2) {
        d.h.b.o.e(r2, "<this>");
        if (r2.length <= 1) goto L6;
        Arrays.sort(r2);
        return;
    }

    public static final <T> void a(T[] r2, Comparator<? super T> r3) {
        Comparator r4 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "<this>");
        d.h.b.o.e(r4, "comparator");
        if (r2.length <= 1) goto L6;
        Arrays.sort(r2, r4);
        return;
    }

    public static final Integer[] a(int[] r4) {
        d.h.b.o.e(r4, "<this>");
        Integer[] r0 = new Integer[r4.length];
        int r1 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0[r2] = Integer.valueOf(r4[r2]);
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }
}
