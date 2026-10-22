package com.bytedance.android.livesdk.interactivity.api.monitorV2.business;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u001b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/monitorV2/business/PSRealtimeIndicatorNode;", "", "", "indicatorNodeName", "Ljava/lang/String;", "getIndicatorNodeName", "()Ljava/lang/String;", "ScrollShowDelayAvg", "ScrollDispatchAndShowDelayAvg", "FloatShowDelayAvg", "BindAvgConsume", "AsyncRendConsume", "MessageRendTextConsume", "MessageRendTextSuccessRate", "SelfMsgShowDelayAvg", "SelfCommentSendSuccessDelayAvg", "SelfCommentShowDelayAvg", "ChatMessageShowDelay", "GiftMessageShowDelay", "SystemMessageShowDelay", "OtherMessageShowDelay", "HighPriorityShowDelay", "NormalPriorityShowDelay", "LowPriorityShowDelay", "LandscapeDanmakuShowDelay", "LandscapeDanmakuDispatchAndShowDelay", "LandscapeChatDanmakuShowDelay", "LandscapeGiftDanmakuShowDelay", "PortraitDanmakuShowDelay", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PSRealtimeIndicatorNode extends Enum<PSRealtimeIndicatorNode> {
    public static final PSRealtimeIndicatorNode AsyncRendConsume = null;
    public static final PSRealtimeIndicatorNode BindAvgConsume = null;
    public static final PSRealtimeIndicatorNode ChatMessageShowDelay = null;
    public static final PSRealtimeIndicatorNode FloatShowDelayAvg = null;
    public static final PSRealtimeIndicatorNode GiftMessageShowDelay = null;
    public static final PSRealtimeIndicatorNode HighPriorityShowDelay = null;
    public static final PSRealtimeIndicatorNode LandscapeChatDanmakuShowDelay = null;
    public static final PSRealtimeIndicatorNode LandscapeDanmakuDispatchAndShowDelay = null;
    public static final PSRealtimeIndicatorNode LandscapeDanmakuShowDelay = null;
    public static final PSRealtimeIndicatorNode LandscapeGiftDanmakuShowDelay = null;
    public static final PSRealtimeIndicatorNode LowPriorityShowDelay = null;
    public static final PSRealtimeIndicatorNode MessageRendTextConsume = null;
    public static final PSRealtimeIndicatorNode MessageRendTextSuccessRate = null;
    public static final PSRealtimeIndicatorNode NormalPriorityShowDelay = null;
    public static final PSRealtimeIndicatorNode OtherMessageShowDelay = null;
    public static final PSRealtimeIndicatorNode PortraitDanmakuShowDelay = null;
    public static final PSRealtimeIndicatorNode ScrollDispatchAndShowDelayAvg = null;
    public static final PSRealtimeIndicatorNode ScrollShowDelayAvg = null;
    public static final PSRealtimeIndicatorNode SelfCommentSendSuccessDelayAvg = null;
    public static final PSRealtimeIndicatorNode SelfCommentShowDelayAvg = null;
    public static final PSRealtimeIndicatorNode SelfMsgShowDelayAvg = null;
    public static final PSRealtimeIndicatorNode SystemMessageShowDelay = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PSRealtimeIndicatorNode[] f133346a = null;
    private final String indicatorNodeName;

    public static PSRealtimeIndicatorNode valueOf(String r100) {
        return (PSRealtimeIndicatorNode) a.a(PSRealtimeIndicatorNode.class, r100);
    }

    public static PSRealtimeIndicatorNode[] values() {
        return (PSRealtimeIndicatorNode[]) f133346a.clone();
    }

    static {
        PSRealtimeIndicatorNode r100 = new PSRealtimeIndicatorNode("ScrollShowDelayAvg", 0, "scroll_show_delay_avg");
        ScrollShowDelayAvg = r100;
        PSRealtimeIndicatorNode r101 = new PSRealtimeIndicatorNode("ScrollDispatchAndShowDelayAvg", 1, "scroll_dispatch_and_show_delay_avy");
        ScrollDispatchAndShowDelayAvg = r101;
        PSRealtimeIndicatorNode r102 = new PSRealtimeIndicatorNode("FloatShowDelayAvg", 2, "float_show_delay_avg");
        FloatShowDelayAvg = r102;
        PSRealtimeIndicatorNode r103 = new PSRealtimeIndicatorNode("BindAvgConsume", 3, "message_bind_avg_consume");
        BindAvgConsume = r103;
        PSRealtimeIndicatorNode r104 = new PSRealtimeIndicatorNode("AsyncRendConsume", 4, "async_rend_consume");
        AsyncRendConsume = r104;
        PSRealtimeIndicatorNode r105 = new PSRealtimeIndicatorNode("MessageRendTextConsume", 5, "message_rend_text_consume");
        MessageRendTextConsume = r105;
        PSRealtimeIndicatorNode r106 = new PSRealtimeIndicatorNode("MessageRendTextSuccessRate", 6, "message_rend_text_success_rate");
        MessageRendTextSuccessRate = r106;
        PSRealtimeIndicatorNode r107 = new PSRealtimeIndicatorNode("SelfMsgShowDelayAvg", 7, "selfmsg_show_delay_avg");
        SelfMsgShowDelayAvg = r107;
        PSRealtimeIndicatorNode r108 = new PSRealtimeIndicatorNode("SelfCommentSendSuccessDelayAvg", 8, "self_comment_send_success_avg");
        SelfCommentSendSuccessDelayAvg = r108;
        PSRealtimeIndicatorNode r109 = new PSRealtimeIndicatorNode("SelfCommentShowDelayAvg", 9, "self_comment_show_delay_avg");
        SelfCommentShowDelayAvg = r109;
        PSRealtimeIndicatorNode r110 = new PSRealtimeIndicatorNode("ChatMessageShowDelay", 10, "chat_show_delay_avg");
        ChatMessageShowDelay = r110;
        PSRealtimeIndicatorNode r111 = new PSRealtimeIndicatorNode("GiftMessageShowDelay", 11, "gift_show_delay_avg");
        GiftMessageShowDelay = r111;
        PSRealtimeIndicatorNode r112 = new PSRealtimeIndicatorNode("SystemMessageShowDelay", 12, "system_show_delay_avg");
        SystemMessageShowDelay = r112;
        PSRealtimeIndicatorNode r113 = new PSRealtimeIndicatorNode("OtherMessageShowDelay", 13, "other_show_delay_avg");
        OtherMessageShowDelay = r113;
        PSRealtimeIndicatorNode r114 = new PSRealtimeIndicatorNode("HighPriorityShowDelay", 14, "high_priority_show_delay");
        HighPriorityShowDelay = r114;
        PSRealtimeIndicatorNode r115 = new PSRealtimeIndicatorNode("NormalPriorityShowDelay", 15, "normal_priority_show_delay");
        NormalPriorityShowDelay = r115;
        PSRealtimeIndicatorNode r116 = new PSRealtimeIndicatorNode("LowPriorityShowDelay", 16, "low_priority_show_delay");
        LowPriorityShowDelay = r116;
        PSRealtimeIndicatorNode r117 = new PSRealtimeIndicatorNode("LandscapeDanmakuShowDelay", 17, "landscape_danmaku_show_delay");
        LandscapeDanmakuShowDelay = r117;
        PSRealtimeIndicatorNode r118 = new PSRealtimeIndicatorNode("LandscapeDanmakuDispatchAndShowDelay", 18, "landscape_danmaku_dispatch_and_show_delay");
        LandscapeDanmakuDispatchAndShowDelay = r118;
        PSRealtimeIndicatorNode r119 = new PSRealtimeIndicatorNode("LandscapeChatDanmakuShowDelay", 19, "landscape_chat_danmaku_show_delay");
        LandscapeChatDanmakuShowDelay = r119;
        PSRealtimeIndicatorNode r120 = new PSRealtimeIndicatorNode("LandscapeGiftDanmakuShowDelay", 20, "landscape_gift_danmaku_show_delay");
        LandscapeGiftDanmakuShowDelay = r120;
        PSRealtimeIndicatorNode r121 = new PSRealtimeIndicatorNode("PortraitDanmakuShowDelay", 21, "portrait_danmaku_show_delay");
        PortraitDanmakuShowDelay = r121;
        f133346a = new PSRealtimeIndicatorNode[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121};
    }

    public final String getIndicatorNodeName() {
        return this.indicatorNodeName;
    }

    public PSRealtimeIndicatorNode(String r100, int r101, String r102) {
        super(r100, r101);
        this.indicatorNodeName = r102;
    }
}
