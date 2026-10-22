package bytedance.jvm.time.format;

/* JADX INFO: loaded from: classes28.dex */
public final enum ResolverStyle extends Enum<ResolverStyle> {
    public static final ResolverStyle LENIENT = null;
    public static final ResolverStyle SMART = null;
    public static final ResolverStyle STRICT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResolverStyle[] f21638a = null;

    static {
        ResolverStyle r100 = new ResolverStyle("STRICT", 0);
        STRICT = r100;
        ResolverStyle r101 = new ResolverStyle("SMART", 1);
        SMART = r101;
        ResolverStyle r102 = new ResolverStyle("LENIENT", 2);
        LENIENT = r102;
        f21638a = new ResolverStyle[]{r100, r101, r102};
    }

    public static ResolverStyle[] values() {
        return (ResolverStyle[]) f21638a.clone();
    }

    public static ResolverStyle valueOf(String r100) {
        return (ResolverStyle) r27.a.a(ResolverStyle.class, r100);
    }

    public ResolverStyle(String r100, int r101) {
        super(r100, r101);
    }
}
