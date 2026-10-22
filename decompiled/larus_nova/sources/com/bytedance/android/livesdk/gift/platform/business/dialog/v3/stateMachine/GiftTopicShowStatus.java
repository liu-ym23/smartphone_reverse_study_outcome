package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftTopicShowStatus;", "", "(Ljava/lang/String;I)V", "GONE", "VISIBLE", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GiftTopicShowStatus extends Enum<GiftTopicShowStatus> {
    private static final /* synthetic */ GiftTopicShowStatus[] $VALUES = null;
    public static final GiftTopicShowStatus GONE = null;
    public static final GiftTopicShowStatus VISIBLE = null;

    static {
        GiftTopicShowStatus r100 = new GiftTopicShowStatus("GONE", 0);
        GONE = r100;
        GiftTopicShowStatus r101 = new GiftTopicShowStatus("VISIBLE", 1);
        VISIBLE = r101;
        $VALUES = new GiftTopicShowStatus[]{r100, r101};
    }

    public static GiftTopicShowStatus valueOf(String r100) {
        return (GiftTopicShowStatus) a.a(GiftTopicShowStatus.class, r100);
    }

    public static GiftTopicShowStatus[] values() {
        return (GiftTopicShowStatus[]) $VALUES.clone();
    }

    private GiftTopicShowStatus(String r100, int r101) {
        super(r100, r101);
    }
}
