package v0;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final long f10264a;

    /* renamed from: b, reason: collision with root package name */
    public static final long f10265b;

    /* renamed from: c, reason: collision with root package name */
    public static final long f10266c;

    /* renamed from: d, reason: collision with root package name */
    public static final long f10267d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f10268e = 0;

    static {
        long j2 = 3;
        long j4 = j2 << 32;
        f10264a = (0 & 4294967295L) | j4;
        f10265b = (1 & 4294967295L) | j4;
        f10266c = j4 | (2 & 4294967295L);
        f10267d = (j2 & 4294967295L) | (4 << 32);
    }

    public static final boolean a(long j2, long j4) {
        return j2 == j4;
    }

    public static String b(long j2) {
        return a(j2, f10264a) ? "Rgb" : a(j2, f10265b) ? "Xyz" : a(j2, f10266c) ? "Lab" : a(j2, f10267d) ? "Cmyk" : "Unknown";
    }
}
