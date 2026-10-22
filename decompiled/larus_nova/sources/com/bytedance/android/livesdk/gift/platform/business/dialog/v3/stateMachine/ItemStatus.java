package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ItemStatus;", "", "(Ljava/lang/String;I)V", "IDLE", "SELECTED", "GONE", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ItemStatus extends Enum<ItemStatus> {
    private static final /* synthetic */ ItemStatus[] $VALUES = null;
    public static final ItemStatus GONE = null;
    public static final ItemStatus IDLE = null;
    public static final ItemStatus SELECTED = null;

    static {
        ItemStatus r100 = new ItemStatus("IDLE", 0);
        IDLE = r100;
        ItemStatus r101 = new ItemStatus("SELECTED", 1);
        SELECTED = r101;
        ItemStatus r102 = new ItemStatus("GONE", 2);
        GONE = r102;
        $VALUES = new ItemStatus[]{r100, r101, r102};
    }

    public static ItemStatus valueOf(String r100) {
        return (ItemStatus) a.a(ItemStatus.class, r100);
    }

    public static ItemStatus[] values() {
        return (ItemStatus[]) $VALUES.clone();
    }

    private ItemStatus(String r100, int r101) {
        super(r100, r101);
    }
}
