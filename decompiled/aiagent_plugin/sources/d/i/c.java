package d.i;

/* JADX INFO: compiled from: MathJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
class c extends b {
    public static final int a(double r2) {
        if (Double.isNaN(r2) == true) goto L13;
        if (r2 <= 2.147483647E9d) goto L8;
        return Integer.MAX_VALUE;
    L8:
        if (r2 >= (-2.147483648E9d)) goto L11;
        return Integer.MIN_VALUE;
    L11:
        return (int) Math.round(r2);
    L13:
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    public static final long b(double r1) {
        if (Double.isNaN(r1) == true) goto L7;
        return Math.round(r1);
    L7:
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    public static final int a(float r1) {
        if (Float.isNaN(r1) == true) goto L7;
        return Math.round(r1);
    L7:
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    public static final long b(float r2) {
        return a.b(r2);
    }
}
