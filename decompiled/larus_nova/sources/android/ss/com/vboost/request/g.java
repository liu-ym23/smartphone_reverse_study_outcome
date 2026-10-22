package android.ss.com.vboost.request;

/* JADX INFO: loaded from: classes2.dex */
public final enum g extends Enum<g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f4761a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f4762b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g f4763c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g f4764d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final g f4765e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ g[] f4766f = null;

    static {
        g r100 = new g("USE_PROVIDERS", 0, 0);
        f4761a = r100;
        g r101 = new g("USE_OURS", 1, 1);
        f4762b = r101;
        g r102 = new g("USER_CANCEL", 2, 2);
        f4763c = r102;
        g r103 = new g("ONE_TIME", 3, 3);
        f4764d = r103;
        g r104 = new g("ETERNAL", 4, 4);
        f4765e = r104;
        f4766f = new g[]{r100, r101, r102, r103, r104};
    }

    private g(String r100, int r101, int r102) {
        super(r100, r101);
    }

    public static g valueOf(String r100) {
        return (g) r27.a.a(g.class, r100);
    }

    public static g[] values() {
        return (g[]) f4766f.clone();
    }
}
