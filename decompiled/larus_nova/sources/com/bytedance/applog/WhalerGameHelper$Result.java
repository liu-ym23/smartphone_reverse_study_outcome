package com.bytedance.applog;

/* JADX INFO: loaded from: classes14.dex */
public final enum WhalerGameHelper$Result extends Enum<WhalerGameHelper$Result> {
    public static final WhalerGameHelper$Result FAIL = null;
    public static final WhalerGameHelper$Result SUCCESS = null;
    public static final WhalerGameHelper$Result UNCOMPLETED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WhalerGameHelper$Result[] f192392a = null;
    final String gameResult;

    static {
        WhalerGameHelper$Result r100 = new WhalerGameHelper$Result("UNCOMPLETED", 0, "uncompleted");
        UNCOMPLETED = r100;
        WhalerGameHelper$Result r101 = new WhalerGameHelper$Result("SUCCESS", 1, "success");
        SUCCESS = r101;
        WhalerGameHelper$Result r102 = new WhalerGameHelper$Result("FAIL", 2, "fail");
        FAIL = r102;
        f192392a = new WhalerGameHelper$Result[]{r100, r101, r102};
    }

    public static WhalerGameHelper$Result[] values() {
        return (WhalerGameHelper$Result[]) f192392a.clone();
    }

    public static WhalerGameHelper$Result valueOf(String r100) {
        return (WhalerGameHelper$Result) r27.a.a(WhalerGameHelper$Result.class, r100);
    }

    public WhalerGameHelper$Result(String r100, int r101, String r102) {
        super(r100, r101);
        this.gameResult = r102;
    }
}
