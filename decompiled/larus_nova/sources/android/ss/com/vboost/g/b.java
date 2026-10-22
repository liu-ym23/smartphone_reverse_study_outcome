package android.ss.com.vboost.g;

/* JADX INFO: loaded from: classes2.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f4611a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f4612b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ b[] f4613c = null;

    static {
        b r100 = new b("USER_SPECIFIED", 0, 1);
        f4611a = r100;
        b r101 = new b("BIND_CLUSTER", 1, 2);
        f4612b = r101;
        f4613c = new b[]{r100, r101};
    }

    private b(String r100, int r101, int r102) {
        super(r100, r101);
    }

    public static b valueOf(String r100) {
        return (b) r27.a.a(b.class, r100);
    }

    public static b[] values() {
        return (b[]) f4613c.clone();
    }
}
