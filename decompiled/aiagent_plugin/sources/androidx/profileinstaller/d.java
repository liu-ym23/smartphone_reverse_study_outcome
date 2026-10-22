package androidx.profileinstaller;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FileSectionType.java */
/* JADX INFO: loaded from: classes.dex */
final enum d extends Enum<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f2250a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f2251b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f2252c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f2253d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f2254e = null;
    private static final /* synthetic */ d[] g = null;
    private final long f;

    private static /* synthetic */ d[] b() {
        return new d[]{f2250a, f2251b, f2252c, f2253d, f2254e};
    }

    public static d valueOf(String r2) {
        return (d) ZeusTransformUtils.preCheckCast(Enum.valueOf(d.class, r2), d.class, "com.obric.aiagent.plugin");
    }

    public static d[] values() {
        return (d[]) ZeusTransformUtils.preCheckCast(g.clone(), d[].class, "com.obric.aiagent.plugin");
    }

    static {
        f2250a = new d("DEX_FILES", 0, 0);
        f2251b = new d("EXTRA_DESCRIPTORS", 1, 1);
        f2252c = new d("CLASSES", 2, 2);
        f2253d = new d("METHODS", 3, 3);
        f2254e = new d("AGGREGATION_COUNT", 4, 4);
        g = b();
    }

    private d(String r1, int r2, long r3) {
        super(r1, r2);
        this.f = r3;
    }

    public long a() {
        return this.f;
    }
}
