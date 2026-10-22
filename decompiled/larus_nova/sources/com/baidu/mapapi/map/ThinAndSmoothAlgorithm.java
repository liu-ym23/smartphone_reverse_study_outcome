package com.baidu.mapapi.map;

/* JADX INFO: loaded from: classes39.dex */
public final enum ThinAndSmoothAlgorithm extends Enum<ThinAndSmoothAlgorithm> {
    public static final ThinAndSmoothAlgorithm ALGORITHM_NONR = null;
    public static final ThinAndSmoothAlgorithm BEZIER_SMOOTH = null;
    public static final ThinAndSmoothAlgorithm DOUGLAS_PEUCKER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ ThinAndSmoothAlgorithm[] f31462a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f31463b;

    static {
        ThinAndSmoothAlgorithm r100 = new ThinAndSmoothAlgorithm("ALGORITHM_NONR", 0, 1);
        ALGORITHM_NONR = r100;
        ThinAndSmoothAlgorithm r101 = new ThinAndSmoothAlgorithm("DOUGLAS_PEUCKER", 1, 2);
        DOUGLAS_PEUCKER = r101;
        ThinAndSmoothAlgorithm r102 = new ThinAndSmoothAlgorithm("BEZIER_SMOOTH", 2, 32);
        BEZIER_SMOOTH = r102;
        f31462a = new ThinAndSmoothAlgorithm[]{r100, r101, r102};
    }

    public static ThinAndSmoothAlgorithm[] values() {
        return (ThinAndSmoothAlgorithm[]) f31462a.clone();
    }

    public int getValue() {
        return this.f31463b;
    }

    public static ThinAndSmoothAlgorithm valueOf(String r100) {
        return (ThinAndSmoothAlgorithm) r27.a.a(ThinAndSmoothAlgorithm.class, r100);
    }

    private ThinAndSmoothAlgorithm(String r100, int r101, int r102) {
        super(r100, r101);
        this.f31463b = r102;
    }
}
