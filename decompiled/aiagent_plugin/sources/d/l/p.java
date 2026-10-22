package d.l;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: _Ranges.kt */
/* JADX INFO: loaded from: classes4.dex */
class p extends o {
    public static final float a(float r1, float r2) {
        if (r1 < r2) goto L5;
        return r1;
    L5:
        return r2;
    }

    public static final long a(long r1, long r3) {
        if (r1 < r3) goto L5;
        return r1;
    L5:
        return r3;
    }

    public static final double b(double r1, double r3) {
        if (r1 < r3) goto L5;
        return r1;
    L5:
        return r3;
    }

    public static final float b(float r1, float r2) {
        if (r1 > r2) goto L5;
        return r1;
    L5:
        return r2;
    }

    public static final long b(long r1, long r3) {
        if (r1 > r3) goto L5;
        return r1;
    L5:
        return r3;
    }

    public static final int c(int r0, int r1) {
        if (r0 < r1) goto L4;
        return r0;
    L4:
        return r1;
    }

    public static final int d(int r0, int r1) {
        if (r0 > r1) goto L4;
        return r0;
    L4:
        return r1;
    }

    public static final long a(m r1, d.k.c r2) {
        d.h.b.o.e(r1, "<this>");
        d.h.b.o.e(r2, "random");
        return d.k.d.a(r2, r1);
    L5:
        e = move-exception;
        throw new NoSuchElementException(e.getMessage());
    }

    public static final h a(int r2, int r3) {
        return h.f38533a.a(r2, r3, -1);
    }

    public static final h a(h r4, int r5) {
        d.h.b.o.e(r4, "<this>");
        if (r5 <= 0) goto L5;
        boolean r0 = true;
    L6:
        n.a(r0, (Number) ZeusTransformUtils.preCheckCast(Integer.valueOf(r5), Number.class, "com.obric.aiagent.plugin"));
        h.a r1 = h.f38533a;
        int r2 = r4.a();
        int r3 = r4.b();
        if (r4.c() > 0) goto L11;
        r5 = -r5;
    L11:
        return r1.a(r2, r3, r5);
    L5:
        r0 = false;
        goto L6
    }

    public static final j b(int r1, int r2) {
        if (r2 > Integer.MIN_VALUE) goto L7;
        return j.f38541b.a();
    L7:
        return new j(r1, r2 - 1);
    }

    public static final <T extends Comparable<? super T>> T a(T r2, T r3, T r4) {
        T r5 = (T) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.aiagent.plugin");
        T r6 = (T) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.aiagent.plugin");
        T r7 = (T) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        if (r6 == null) goto L15;
        if (r7 == null) goto L15;
        if (r6.compareTo(r7) > 0) goto L14;
        if (r5.compareTo(r6) >= 0) goto L11;
        return r6;
    L11:
        if (r5.compareTo(r7) <= 0) goto L23;
        return r7;
    L23:
        return r5;
    L14:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + r7 + " is less than minimum " + r6 + '.');
    L15:
        if (r6 != null) goto L17;
    L19:
        if (r7 == null) goto L23;
        if (r5.compareTo(r7) <= 0) goto L23;
        return r7;
    L17:
        if (r5.compareTo(r6) >= 0) goto L19;
        return r6;
    }

    public static final int a(int r2, int r3, int r4) {
        if (r3 > r4) goto L9;
        if (r2 >= r3) goto L5;
        return r3;
    L5:
        if (r2 <= r4) goto L7;
        return r4;
    L7:
        return r2;
    L9:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + r4 + " is less than minimum " + r3 + '.');
    }

    public static final long a(long r1, long r3, long r5) {
        if (r3 > r5) goto L12;
        if (r1 >= r3) goto L8;
        return r3;
    L8:
        if (r1 <= r5) goto L10;
        return r5;
    L10:
        return r1;
    L12:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + r5 + " is less than minimum " + r3 + '.');
    }

    public static final float a(float r2, float r3, float r4) {
        if (r3 > r4) goto L12;
        if (r2 >= r3) goto L8;
        return r3;
    L8:
        if (r2 <= r4) goto L10;
        return r4;
    L10:
        return r2;
    L12:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + r4 + " is less than minimum " + r3 + '.');
    }

    public static final double a(double r1, double r3, double r5) {
        if (r3 > r5) goto L12;
        if (r1 >= r3) goto L8;
        return r3;
    L8:
        if (r1 <= r5) goto L10;
        return r5;
    L10:
        return r1;
    L12:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + r5 + " is less than minimum " + r3 + '.');
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T extends Comparable<? super T>> T a(T r2, e<T> r3) {
        T r4 = (T) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.aiagent.plugin");
        e r5 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        d.h.b.o.e(r5, "range");
        if (r5.d() == true) goto L16;
        if (r5.a(r4, r5.g()) == false) goto L10;
        if (r5.a(r5.g(), r4) == true) goto L10;
        return (T) r5.g();
    L10:
        if (r5.a(r5.h(), r4) == true) goto L12;
        return r4;
    L12:
        if (r5.a(r4, r5.h()) == false) goto L14;
        return r4;
    L14:
        return (T) r5.h();
    L16:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + r5 + '.');
    }

    public static final int a(int r3, f<Integer> r4) {
        f r5 = (f) ZeusTransformUtils.wrapperContextForParams(r4, f.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "range");
        if (ZeusTransformUtils.instanceOf(r5, e.class) == false) goto L7;
        return ((Number) ZeusTransformUtils.preCheckCast(n.a((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(r3), Comparable.class, "com.obric.aiagent.plugin"), (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin")), Number.class, "com.obric.aiagent.plugin")).intValue();
    L7:
        if (r5.d() == true) goto L16;
        if (r3 >= ((Number) ZeusTransformUtils.preCheckCast(r5.g(), Number.class, "com.obric.aiagent.plugin")).intValue()) goto L12;
        return ((Number) ZeusTransformUtils.preCheckCast(r5.g(), Number.class, "com.obric.aiagent.plugin")).intValue();
    L12:
        if (r3 > ((Number) ZeusTransformUtils.preCheckCast(r5.h(), Number.class, "com.obric.aiagent.plugin")).intValue()) goto L14;
        return r3;
    L14:
        return ((Number) ZeusTransformUtils.preCheckCast(r5.h(), Number.class, "com.obric.aiagent.plugin")).intValue();
    L16:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + r5 + '.');
    }
}
