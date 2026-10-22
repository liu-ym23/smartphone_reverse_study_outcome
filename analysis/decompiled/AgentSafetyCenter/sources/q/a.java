package q;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f10064a = new int[0];

    /* renamed from: b, reason: collision with root package name */
    public static final long[] f10065b = new long[0];

    /* renamed from: c, reason: collision with root package name */
    public static final Object[] f10066c = new Object[0];

    public static final int a(int i, int i3, int[] iArr) {
        iArr.getClass();
        int i10 = i - 1;
        int i11 = 0;
        while (i11 <= i10) {
            int i12 = (i11 + i10) >>> 1;
            int i13 = iArr[i12];
            if (i13 < i3) {
                i11 = i12 + 1;
            } else {
                if (i13 <= i3) {
                    return i12;
                }
                i10 = i12 - 1;
            }
        }
        return ~i11;
    }

    public static final int b(long[] jArr, int i, long j10) {
        jArr.getClass();
        int i3 = i - 1;
        int i10 = 0;
        while (i10 <= i3) {
            int i11 = (i10 + i3) >>> 1;
            long j11 = jArr[i11];
            if (j11 < j10) {
                i10 = i11 + 1;
            } else {
                if (j11 <= j10) {
                    return i11;
                }
                i3 = i11 - 1;
            }
        }
        return ~i10;
    }
}
