package com.bytedance.android.livesdk.utils.condition.base;

/* JADX INFO: loaded from: classes11.dex */
public final enum ConditionConstant$ConditionRepo extends Enum<ConditionConstant$ConditionRepo> {
    public static final ConditionConstant$ConditionRepo SHOW_CLEAR_GUIDE = null;
    public static final ConditionConstant$ConditionRepo SHOW_PERFORMANCE_CLEAR_GUIDE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ConditionConstant$ConditionRepo[] f158913a = null;
    String description;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    int f158914id;

    static {
        ConditionConstant$ConditionRepo r100 = new ConditionConstant$ConditionRepo("SHOW_CLEAR_GUIDE", 0, 0, "房间信息过载时，展示清屏的引导提示");
        SHOW_CLEAR_GUIDE = r100;
        ConditionConstant$ConditionRepo r101 = new ConditionConstant$ConditionRepo("SHOW_PERFORMANCE_CLEAR_GUIDE", 1, 1, "房间低功耗或卡顿时，展示清屏的引导提示");
        SHOW_PERFORMANCE_CLEAR_GUIDE = r101;
        f158913a = new ConditionConstant$ConditionRepo[]{r100, r101};
    }

    public static ConditionConstant$ConditionRepo[] values() {
        return (ConditionConstant$ConditionRepo[]) f158913a.clone();
    }

    public String getDescription() {
        return this.description;
    }

    public int getId() {
        return this.f158914id;
    }

    public static ConditionConstant$ConditionRepo valueOf(String r100) {
        return (ConditionConstant$ConditionRepo) r27.a.a(ConditionConstant$ConditionRepo.class, r100);
    }

    public ConditionConstant$ConditionRepo(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.f158914id = r102;
        this.description = r103;
    }
}
