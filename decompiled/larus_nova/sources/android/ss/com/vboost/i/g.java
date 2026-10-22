package android.ss.com.vboost.i;

/* JADX INFO: loaded from: classes2.dex */
public final enum g extends Enum<g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f4705a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f4706b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ g[] f4707c = null;

    static {
        g r100 = new g("VENDOR", 0, 1);
        f4705a = r100;
        g r101 = new g("PLATFORM", 1, 2);
        f4706b = r101;
        f4707c = new g[]{r100, r101};
    }

    private g(String r100, int r101, int r102) {
        super(r100, r101);
    }

    public static g valueOf(String r100) {
        return (g) r27.a.a(g.class, r100);
    }

    public static g[] values() {
        return (g[]) f4707c.clone();
    }
}
