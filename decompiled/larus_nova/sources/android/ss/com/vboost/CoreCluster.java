package android.ss.com.vboost;

/* JADX INFO: loaded from: classes2.dex */
public final enum CoreCluster extends Enum<CoreCluster> {
    private static final /* synthetic */ CoreCluster[] $VALUES = null;
    public static final CoreCluster GOLD = null;
    public static final CoreCluster SILVER = null;
    public static final CoreCluster SUPER = null;
    private int index;

    static {
        CoreCluster r100 = new CoreCluster("SILVER", 0, 1);
        SILVER = r100;
        CoreCluster r101 = new CoreCluster("GOLD", 1, 2);
        GOLD = r101;
        CoreCluster r102 = new CoreCluster("SUPER", 2, 3);
        SUPER = r102;
        $VALUES = new CoreCluster[]{r100, r101, r102};
    }

    private CoreCluster(String r100, int r101, int r102) {
        super(r100, r101);
        this.index = r102;
    }

    public static CoreCluster valueOf(int r100) {
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L13;
        if (r100 == 3) goto L11;
        return null;
    L11:
        return SUPER;
    L13:
        return GOLD;
    L15:
        return SILVER;
    }

    public static CoreCluster valueOf(String r100) {
        return (CoreCluster) r27.a.a(CoreCluster.class, r100);
    }

    public static CoreCluster[] values() {
        return (CoreCluster[]) $VALUES.clone();
    }

    public int getIndex() {
        return this.index;
    }
}
