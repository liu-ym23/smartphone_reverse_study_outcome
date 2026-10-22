package com.bytedance.android.livesdk.feedback.condition.trigger.base;

import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/condition/trigger/base/TriggerId;", "", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "LIVE_END", "RECEIVE_FEEDBACK_MSG", "FANS_CLUB", "TOTAL_WATCH_TIME_SECTION", "FOLLOW", OpenNetMethod.REPORT, "PURCHASE", "COMMENT", "DIGG", "SEND_GIFT", "BOTTOM_RIGHT_CARD_SHOW", "RECEIVE_LIVE_ROOM_FEEDBACK_MSG", "Pcu", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TriggerId extends Enum<TriggerId> {
    public static final TriggerId BOTTOM_RIGHT_CARD_SHOW = null;
    public static final TriggerId COMMENT = null;
    public static final TriggerId DIGG = null;
    public static final TriggerId FANS_CLUB = null;
    public static final TriggerId FOLLOW = null;
    public static final TriggerId LIVE_END = null;
    public static final TriggerId PURCHASE = null;
    public static final TriggerId Pcu = null;
    public static final TriggerId RECEIVE_FEEDBACK_MSG = null;
    public static final TriggerId RECEIVE_LIVE_ROOM_FEEDBACK_MSG = null;
    public static final TriggerId REPORT = null;
    public static final TriggerId SEND_GIFT = null;
    public static final TriggerId TOTAL_WATCH_TIME_SECTION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TriggerId[] f124692a = null;
    private final String desc;

    public static TriggerId valueOf(String r100) {
        return (TriggerId) a.a(TriggerId.class, r100);
    }

    public static TriggerId[] values() {
        return (TriggerId[]) f124692a.clone();
    }

    static {
        TriggerId r100 = new TriggerId("LIVE_END", 0, "直播结束");
        LIVE_END = r100;
        TriggerId r101 = new TriggerId("RECEIVE_FEEDBACK_MSG", 1, "监听服务端feedback消息，目前没有用，都是客户端本地触发的");
        RECEIVE_FEEDBACK_MSG = r101;
        TriggerId r102 = new TriggerId("FANS_CLUB", 2, "加入粉丝团");
        FANS_CLUB = r102;
        TriggerId r103 = new TriggerId("TOTAL_WATCH_TIME_SECTION", 3, "直播间累计看播时长在[x,y]内问卷可以展示，去除后台时间");
        TOTAL_WATCH_TIME_SECTION = r103;
        TriggerId r104 = new TriggerId("FOLLOW", 4, "关注、取关");
        FOLLOW = r104;
        TriggerId r105 = new TriggerId(OpenNetMethod.REPORT, 5, "举报");
        REPORT = r105;
        TriggerId r106 = new TriggerId("PURCHASE", 6, "加购");
        PURCHASE = r106;
        TriggerId r107 = new TriggerId("COMMENT", 7, "评论");
        COMMENT = r107;
        TriggerId r108 = new TriggerId("DIGG", 8, "点赞");
        DIGG = r108;
        TriggerId r109 = new TriggerId("SEND_GIFT", 9, "送礼");
        SEND_GIFT = r109;
        TriggerId r110 = new TriggerId("BOTTOM_RIGHT_CARD_SHOW", 10, "直播间右下角讲解卡位置有元素要展示");
        BOTTOM_RIGHT_CARD_SHOW = r110;
        TriggerId r111 = new TriggerId("RECEIVE_LIVE_ROOM_FEEDBACK_MSG", 11, "监听服务端房间feedback消息");
        RECEIVE_LIVE_ROOM_FEEDBACK_MSG = r111;
        TriggerId r112 = new TriggerId("Pcu", 12, "直播间pcu人数");
        Pcu = r112;
        f124692a = new TriggerId[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112};
    }

    public final String getDesc() {
        return this.desc;
    }

    public TriggerId(String r100, int r101, String r102) {
        super(r100, r101);
        this.desc = r102;
    }
}
