package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/TopicLabelStatus;", "", "(Ljava/lang/String;I)V", "ARROW_UP", "ARROW_DOWN", "ARROW_GONE", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TopicLabelStatus extends Enum<TopicLabelStatus> {
    private static final /* synthetic */ TopicLabelStatus[] $VALUES = null;
    public static final TopicLabelStatus ARROW_DOWN = null;
    public static final TopicLabelStatus ARROW_GONE = null;
    public static final TopicLabelStatus ARROW_UP = null;

    static {
        TopicLabelStatus r100 = new TopicLabelStatus("ARROW_UP", 0);
        ARROW_UP = r100;
        TopicLabelStatus r101 = new TopicLabelStatus("ARROW_DOWN", 1);
        ARROW_DOWN = r101;
        TopicLabelStatus r102 = new TopicLabelStatus("ARROW_GONE", 2);
        ARROW_GONE = r102;
        $VALUES = new TopicLabelStatus[]{r100, r101, r102};
    }

    public static TopicLabelStatus valueOf(String r100) {
        return (TopicLabelStatus) a.a(TopicLabelStatus.class, r100);
    }

    public static TopicLabelStatus[] values() {
        return (TopicLabelStatus[]) $VALUES.clone();
    }

    private TopicLabelStatus(String r100, int r101) {
        super(r100, r101);
    }
}
