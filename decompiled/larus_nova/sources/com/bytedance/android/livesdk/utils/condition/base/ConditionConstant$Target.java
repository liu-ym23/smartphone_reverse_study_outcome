package com.bytedance.android.livesdk.utils.condition.base;

/* JADX INFO: loaded from: classes11.dex */
public final enum ConditionConstant$Target extends Enum<ConditionConstant$Target> {
    public static final ConditionConstant$Target SHOW_CLEAR_GUIDE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ConditionConstant$Target[] f158917a = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    int f158918id;

    static {
        ConditionConstant$Target r100 = new ConditionConstant$Target();
        SHOW_CLEAR_GUIDE = r100;
        f158917a = new ConditionConstant$Target[]{r100};
    }

    public ConditionConstant$Target() {
        super("SHOW_CLEAR_GUIDE", 0);
        this.f158918id = 0;
    }

    public static ConditionConstant$Target[] values() {
        return (ConditionConstant$Target[]) f158917a.clone();
    }

    public static ConditionConstant$Target valueOf(String r100) {
        return (ConditionConstant$Target) r27.a.a(ConditionConstant$Target.class, r100);
    }
}
