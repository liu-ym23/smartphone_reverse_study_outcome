package com.bytedance.android.live.room.api.messagewindow.strategy.showintercept;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/room/api/messagewindow/strategy/showintercept/ConditionId;", "", "", "value", "I", "getValue", "()I", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "CARD_SHOW_INTERVAL_TIME_LIMIT", "EXIT_CARD_TIMES_LIMIT", "ALREADY_FOLLOWED_NOT_DISPLAY", "SAME_ANCHOR_NOT_DISPLAY", "ANCHOR_EXIT_MIC_NOT_DISPLAY", "PRELOADING_RESULT_LIMIT", "SCREEN_ORIENTATION_LIMIT", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ConditionId extends Enum<ConditionId> {
    public static final ConditionId ALREADY_FOLLOWED_NOT_DISPLAY = null;
    public static final ConditionId ANCHOR_EXIT_MIC_NOT_DISPLAY = null;
    public static final ConditionId CARD_SHOW_INTERVAL_TIME_LIMIT = null;
    public static final ConditionId EXIT_CARD_TIMES_LIMIT = null;
    public static final ConditionId PRELOADING_RESULT_LIMIT = null;
    public static final ConditionId SAME_ANCHOR_NOT_DISPLAY = null;
    public static final ConditionId SCREEN_ORIENTATION_LIMIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ConditionId[] f99038a = null;
    private final String desc;
    private final int value;

    static {
        ConditionId r100 = new ConditionId("CARD_SHOW_INTERVAL_TIME_LIMIT", 0, 1, "相同类型卡片展示间隔Ns");
        CARD_SHOW_INTERVAL_TIME_LIMIT = r100;
        ConditionId r101 = new ConditionId("EXIT_CARD_TIMES_LIMIT", 1, 2, "卡片被关闭N次后不再触发展示");
        EXIT_CARD_TIMES_LIMIT = r101;
        ConditionId r102 = new ConditionId("ALREADY_FOLLOWED_NOT_DISPLAY", 2, 1001, "观众已关注的主播不展示");
        ALREADY_FOLLOWED_NOT_DISPLAY = r102;
        ConditionId r103 = new ConditionId("SAME_ANCHOR_NOT_DISPLAY", 3, 1002, "同一个主播直播间（上麦期间）仅展示一次卡片");
        SAME_ANCHOR_NOT_DISPLAY = r103;
        ConditionId r104 = new ConditionId("ANCHOR_EXIT_MIC_NOT_DISPLAY", 4, 1003, "主播关注卡片仅出在主播自己直播间内：下麦后不再触发");
        ANCHOR_EXIT_MIC_NOT_DISPLAY = r104;
        ConditionId r105 = new ConditionId("PRELOADING_RESULT_LIMIT", 5, 9998, "预加载状态限制，需等待预加载状态完成才能展示");
        PRELOADING_RESULT_LIMIT = r105;
        ConditionId r106 = new ConditionId("SCREEN_ORIENTATION_LIMIT", 6, 9999, "屏幕状态限制");
        SCREEN_ORIENTATION_LIMIT = r106;
        f99038a = new ConditionId[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static ConditionId valueOf(String r100) {
        return (ConditionId) a.a(ConditionId.class, r100);
    }

    public static ConditionId[] values() {
        return (ConditionId[]) f99038a.clone();
    }

    public final String getDesc() {
        return this.desc;
    }

    public final int getValue() {
        return this.value;
    }

    public ConditionId(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.value = r102;
        this.desc = r103;
    }
}
