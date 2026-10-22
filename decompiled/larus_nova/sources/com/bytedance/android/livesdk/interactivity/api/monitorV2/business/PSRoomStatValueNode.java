package com.bytedance.android.livesdk.interactivity.api.monitorV2.business;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u001d\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/monitorV2/business/PSRoomStatValueNode;", "", "", "valueNodeName", "Ljava/lang/String;", "getValueNodeName", "()Ljava/lang/String;", "TotalMsgCount", "TotalEnqueueCount", "TotalShowCount", "TotalScrollCount", "TotalFoldCount", "TotalFloatCount", "TotalOvertimeDrop", "TotalOverlimitDrop", "HistoryMessageFetchCostTime", "ReceiveHistoryMsgCostTime", "ReceiveRealtimeMsgCostTime", "ReceiveBackendTopMsgCostTime", "ChatMessageReceiveCount", "ChatMessageShowCount", "GiftMessageReceiveCount", "GiftMessageShowCount", "SystemMessageReceiveCount", "SystemMessageShowCount", "LandscapeDanmakuReceiveCount", "LandscapeDanmakuShowCount", "PortraitDanmakuReceiveCount", "PortraitDanmakuShowCount", "PaidDanmakuReceiveCount", "PaidDanmakuShowCount", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PSRoomStatValueNode extends Enum<PSRoomStatValueNode> {
    public static final PSRoomStatValueNode ChatMessageReceiveCount = null;
    public static final PSRoomStatValueNode ChatMessageShowCount = null;
    public static final PSRoomStatValueNode GiftMessageReceiveCount = null;
    public static final PSRoomStatValueNode GiftMessageShowCount = null;
    public static final PSRoomStatValueNode HistoryMessageFetchCostTime = null;
    public static final PSRoomStatValueNode LandscapeDanmakuReceiveCount = null;
    public static final PSRoomStatValueNode LandscapeDanmakuShowCount = null;
    public static final PSRoomStatValueNode PaidDanmakuReceiveCount = null;
    public static final PSRoomStatValueNode PaidDanmakuShowCount = null;
    public static final PSRoomStatValueNode PortraitDanmakuReceiveCount = null;
    public static final PSRoomStatValueNode PortraitDanmakuShowCount = null;
    public static final PSRoomStatValueNode ReceiveBackendTopMsgCostTime = null;
    public static final PSRoomStatValueNode ReceiveHistoryMsgCostTime = null;
    public static final PSRoomStatValueNode ReceiveRealtimeMsgCostTime = null;
    public static final PSRoomStatValueNode SystemMessageReceiveCount = null;
    public static final PSRoomStatValueNode SystemMessageShowCount = null;
    public static final PSRoomStatValueNode TotalEnqueueCount = null;
    public static final PSRoomStatValueNode TotalFloatCount = null;
    public static final PSRoomStatValueNode TotalFoldCount = null;
    public static final PSRoomStatValueNode TotalMsgCount = null;
    public static final PSRoomStatValueNode TotalOverlimitDrop = null;
    public static final PSRoomStatValueNode TotalOvertimeDrop = null;
    public static final PSRoomStatValueNode TotalScrollCount = null;
    public static final PSRoomStatValueNode TotalShowCount = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PSRoomStatValueNode[] f133352a = null;
    private final String valueNodeName;

    public static PSRoomStatValueNode valueOf(String r100) {
        return (PSRoomStatValueNode) a.a(PSRoomStatValueNode.class, r100);
    }

    public static PSRoomStatValueNode[] values() {
        return (PSRoomStatValueNode[]) f133352a.clone();
    }

    static {
        PSRoomStatValueNode r100 = new PSRoomStatValueNode("TotalMsgCount", 0, "total_msg_count");
        TotalMsgCount = r100;
        PSRoomStatValueNode r101 = new PSRoomStatValueNode("TotalEnqueueCount", 1, "total_enqueue_count");
        TotalEnqueueCount = r101;
        PSRoomStatValueNode r102 = new PSRoomStatValueNode("TotalShowCount", 2, "total_show_count");
        TotalShowCount = r102;
        PSRoomStatValueNode r103 = new PSRoomStatValueNode("TotalScrollCount", 3, "total_scroll_count");
        TotalScrollCount = r103;
        PSRoomStatValueNode r104 = new PSRoomStatValueNode("TotalFoldCount", 4, "total_fold_count");
        TotalFoldCount = r104;
        PSRoomStatValueNode r105 = new PSRoomStatValueNode("TotalFloatCount", 5, "total_float_count");
        TotalFloatCount = r105;
        PSRoomStatValueNode r106 = new PSRoomStatValueNode("TotalOvertimeDrop", 6, "total_overtime_drop");
        TotalOvertimeDrop = r106;
        PSRoomStatValueNode r107 = new PSRoomStatValueNode("TotalOverlimitDrop", 7, "total_overlimit_drop");
        TotalOverlimitDrop = r107;
        PSRoomStatValueNode r108 = new PSRoomStatValueNode("HistoryMessageFetchCostTime", 8, "history_message_fetch_cost_time");
        HistoryMessageFetchCostTime = r108;
        PSRoomStatValueNode r109 = new PSRoomStatValueNode("ReceiveHistoryMsgCostTime", 9, "receive_history_msg_cost_time");
        ReceiveHistoryMsgCostTime = r109;
        PSRoomStatValueNode r110 = new PSRoomStatValueNode("ReceiveRealtimeMsgCostTime", 10, "receive_realtime_msg_cost_time");
        ReceiveRealtimeMsgCostTime = r110;
        PSRoomStatValueNode r111 = new PSRoomStatValueNode("ReceiveBackendTopMsgCostTime", 11, "receive_backend_top_msg_cost_time");
        ReceiveBackendTopMsgCostTime = r111;
        PSRoomStatValueNode r112 = new PSRoomStatValueNode("ChatMessageReceiveCount", 12, "chat_receive_count");
        ChatMessageReceiveCount = r112;
        PSRoomStatValueNode r113 = new PSRoomStatValueNode("ChatMessageShowCount", 13, "chat_show_count");
        ChatMessageShowCount = r113;
        PSRoomStatValueNode r114 = new PSRoomStatValueNode("GiftMessageReceiveCount", 14, "gift_receive_count");
        GiftMessageReceiveCount = r114;
        PSRoomStatValueNode r115 = new PSRoomStatValueNode("GiftMessageShowCount", 15, "gift_show_count");
        GiftMessageShowCount = r115;
        PSRoomStatValueNode r116 = new PSRoomStatValueNode("SystemMessageReceiveCount", 16, "system_receive_count");
        SystemMessageReceiveCount = r116;
        PSRoomStatValueNode r117 = new PSRoomStatValueNode("SystemMessageShowCount", 17, "system_show_count");
        SystemMessageShowCount = r117;
        PSRoomStatValueNode r118 = new PSRoomStatValueNode("LandscapeDanmakuReceiveCount", 18, "landscape_danmaku_receive_count");
        LandscapeDanmakuReceiveCount = r118;
        PSRoomStatValueNode r119 = new PSRoomStatValueNode("LandscapeDanmakuShowCount", 19, "landscape_danmaku_show_count");
        LandscapeDanmakuShowCount = r119;
        PSRoomStatValueNode r120 = new PSRoomStatValueNode("PortraitDanmakuReceiveCount", 20, "portrait_danmaku_receive_count");
        PortraitDanmakuReceiveCount = r120;
        PSRoomStatValueNode r121 = new PSRoomStatValueNode("PortraitDanmakuShowCount", 21, "portrait_danmaku_show_count");
        PortraitDanmakuShowCount = r121;
        PSRoomStatValueNode r122 = new PSRoomStatValueNode("PaidDanmakuReceiveCount", 22, "privilege_danmaku_receive_count");
        PaidDanmakuReceiveCount = r122;
        PSRoomStatValueNode r123 = new PSRoomStatValueNode("PaidDanmakuShowCount", 23, "privilege_danmaku_show_count");
        PaidDanmakuShowCount = r123;
        f133352a = new PSRoomStatValueNode[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123};
    }

    public final String getValueNodeName() {
        return this.valueNodeName;
    }

    public PSRoomStatValueNode(String r100, int r101, String r102) {
        super(r100, r101);
        this.valueNodeName = r102;
    }
}
