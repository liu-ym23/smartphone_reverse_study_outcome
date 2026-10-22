package com.bytedance.android.livesdk.utils.condition.base;

/* JADX INFO: loaded from: classes11.dex */
public final enum ConditionConstant$ConditionType extends Enum<ConditionConstant$ConditionType> {
    public static final ConditionConstant$ConditionType CLAER_GUIDE_TRIGGER_2 = null;
    public static final ConditionConstant$ConditionType SHOW_BUBBLE = null;
    public static final ConditionConstant$ConditionType SHOW_CARD = null;
    public static final ConditionConstant$ConditionType SHOW_COMMENT = null;
    public static final ConditionConstant$ConditionType SHOW_GIFT_EFFECT = null;
    public static final ConditionConstant$ConditionType SHOW_LOW_BATTERY = null;
    public static final ConditionConstant$ConditionType SHOW_PIN_COMMENT = null;
    public static final ConditionConstant$ConditionType SHOW_SALE = null;
    public static final ConditionConstant$ConditionType SHOW_UI_STALL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ConditionConstant$ConditionType[] f158915a = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    int f158916id;

    static {
        ConditionConstant$ConditionType r100 = new ConditionConstant$ConditionType("CLAER_GUIDE_TRIGGER_2", 0, 1001);
        CLAER_GUIDE_TRIGGER_2 = r100;
        ConditionConstant$ConditionType r101 = new ConditionConstant$ConditionType("SHOW_COMMENT", 1, 0);
        SHOW_COMMENT = r101;
        ConditionConstant$ConditionType r102 = new ConditionConstant$ConditionType("SHOW_GIFT_EFFECT", 2, 1);
        SHOW_GIFT_EFFECT = r102;
        ConditionConstant$ConditionType r103 = new ConditionConstant$ConditionType("SHOW_CARD", 3, 2);
        SHOW_CARD = r103;
        ConditionConstant$ConditionType r104 = new ConditionConstant$ConditionType("SHOW_SALE", 4, 3);
        SHOW_SALE = r104;
        ConditionConstant$ConditionType r105 = new ConditionConstant$ConditionType("SHOW_BUBBLE", 5, 5);
        SHOW_BUBBLE = r105;
        ConditionConstant$ConditionType r110 = new ConditionConstant$ConditionType("SHOW_PIN_COMMENT", 6, 6);
        SHOW_PIN_COMMENT = r110;
        ConditionConstant$ConditionType r111 = new ConditionConstant$ConditionType("SHOW_LOW_BATTERY", 7, 7);
        SHOW_LOW_BATTERY = r111;
        ConditionConstant$ConditionType r112 = new ConditionConstant$ConditionType("SHOW_UI_STALL", 8, 8);
        SHOW_UI_STALL = r112;
        f158915a = new ConditionConstant$ConditionType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
    }

    public static ConditionConstant$ConditionType[] values() {
        return (ConditionConstant$ConditionType[]) f158915a.clone();
    }

    public static ConditionConstant$ConditionType valueOf(String r100) {
        return (ConditionConstant$ConditionType) r27.a.a(ConditionConstant$ConditionType.class, r100);
    }

    public ConditionConstant$ConditionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.f158916id = r102;
    }
}
