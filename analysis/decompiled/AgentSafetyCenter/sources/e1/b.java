package e1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final long f3334a;

    /* renamed from: b, reason: collision with root package name */
    public static final long f3335b;

    /* renamed from: c, reason: collision with root package name */
    public static final long f3336c;

    /* renamed from: d, reason: collision with root package name */
    public static final long f3337d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f3338e = 0;

    static {
        long j10 = 3;
        long j11 = j10 << 32;
        f3334a = (0 & 4294967295L) | j11;
        f3335b = (1 & 4294967295L) | j11;
        f3336c = j11 | (2 & 4294967295L);
        f3337d = (j10 & 4294967295L) | (4 << 32);
    }

    public static final boolean a(long j10, long j11) {
        return j10 == j11;
    }

    public static String b(long j10) {
        return a(j10, f3334a) ? "Rgb" : a(j10, f3335b) ? "Xyz" : a(j10, f3336c) ? "Lab" : a(j10, f3337d) ? "Cmyk" : "Unknown";
    }
}
