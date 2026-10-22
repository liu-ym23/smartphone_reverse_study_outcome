package com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/EntranceDisplayType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "None", "StaticEntrance", "ProductEntrance", "PlanActivityEntrance", "BigCardEntrance", "BigCardBenefitEntrance", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EntranceDisplayType extends Enum<EntranceDisplayType> {
    private static final /* synthetic */ EntranceDisplayType[] $VALUES = null;
    public static final EntranceDisplayType BigCardBenefitEntrance = null;
    public static final EntranceDisplayType BigCardEntrance = null;
    public static final EntranceDisplayType None = null;
    public static final EntranceDisplayType PlanActivityEntrance = null;
    public static final EntranceDisplayType ProductEntrance = null;
    public static final EntranceDisplayType StaticEntrance = null;
    private final int value;

    static {
        EntranceDisplayType r100 = new EntranceDisplayType("None", 0, 0);
        None = r100;
        EntranceDisplayType r101 = new EntranceDisplayType("StaticEntrance", 1, 1);
        StaticEntrance = r101;
        EntranceDisplayType r102 = new EntranceDisplayType("ProductEntrance", 2, 2);
        ProductEntrance = r102;
        EntranceDisplayType r103 = new EntranceDisplayType("PlanActivityEntrance", 3, 3);
        PlanActivityEntrance = r103;
        EntranceDisplayType r104 = new EntranceDisplayType("BigCardEntrance", 4, 4);
        BigCardEntrance = r104;
        EntranceDisplayType r105 = new EntranceDisplayType("BigCardBenefitEntrance", 5, 5);
        BigCardBenefitEntrance = r105;
        $VALUES = new EntranceDisplayType[]{r100, r101, r102, r103, r104, r105};
    }

    public static EntranceDisplayType valueOf(String r100) {
        return (EntranceDisplayType) a.a(EntranceDisplayType.class, r100);
    }

    public static EntranceDisplayType[] values() {
        return (EntranceDisplayType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    private EntranceDisplayType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
