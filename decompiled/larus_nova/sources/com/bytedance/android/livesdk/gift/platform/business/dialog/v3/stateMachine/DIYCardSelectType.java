package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/DIYCardSelectType;", "", "type", "", "(Ljava/lang/String;II)V", "IDLE", "DEFAULT_SELECT", "CLICK_SELECT", "RECOMMEND_SELECT", "CARD_NAME_SELECT", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum DIYCardSelectType extends Enum<DIYCardSelectType> {
    private static final /* synthetic */ DIYCardSelectType[] $VALUES = null;
    public static final DIYCardSelectType CARD_NAME_SELECT = null;
    public static final DIYCardSelectType CLICK_SELECT = null;
    public static final DIYCardSelectType DEFAULT_SELECT = null;
    public static final DIYCardSelectType IDLE = null;
    public static final DIYCardSelectType RECOMMEND_SELECT = null;

    static {
        DIYCardSelectType r100 = new DIYCardSelectType("IDLE", 0, -1);
        IDLE = r100;
        DIYCardSelectType r101 = new DIYCardSelectType("DEFAULT_SELECT", 1, 1);
        DEFAULT_SELECT = r101;
        DIYCardSelectType r102 = new DIYCardSelectType("CLICK_SELECT", 2, 2);
        CLICK_SELECT = r102;
        DIYCardSelectType r103 = new DIYCardSelectType("RECOMMEND_SELECT", 3, 3);
        RECOMMEND_SELECT = r103;
        DIYCardSelectType r104 = new DIYCardSelectType("CARD_NAME_SELECT", 4, 4);
        CARD_NAME_SELECT = r104;
        $VALUES = new DIYCardSelectType[]{r100, r101, r102, r103, r104};
    }

    public static DIYCardSelectType valueOf(String r100) {
        return (DIYCardSelectType) a.a(DIYCardSelectType.class, r100);
    }

    public static DIYCardSelectType[] values() {
        return (DIYCardSelectType[]) $VALUES.clone();
    }

    private DIYCardSelectType(String r100, int r101, int r102) {
        super(r100, r101);
    }
}
