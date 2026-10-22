package android.ss.com.vboost.request;

/* JADX INFO: loaded from: classes2.dex */
final enum i extends Enum<i> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f4769a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i f4770b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i f4771c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final i f4772d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ i[] f4773e = null;

    static {
        i r100 = new i("FIFO", 0, 0);
        f4769a = r100;
        i r101 = new i("LIFO", 1, 1);
        f4770b = r101;
        i r102 = new i("SMALL", 2, 2);
        f4771c = r102;
        i r103 = new i("LAGER", 3, 3);
        f4772d = r103;
        f4773e = new i[]{r100, r101, r102, r103};
    }

    private i(String r100, int r101, int r102) {
        super(r100, r101);
    }

    public static i valueOf(String r100) {
        return (i) r27.a.a(i.class, r100);
    }

    public static i[] values() {
        return (i[]) f4773e.clone();
    }
}
