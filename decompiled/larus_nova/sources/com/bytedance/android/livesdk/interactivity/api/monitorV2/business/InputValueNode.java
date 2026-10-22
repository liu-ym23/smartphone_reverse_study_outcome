package com.bytedance.android.livesdk.interactivity.api.monitorV2.business;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/monitorV2/business/InputValueNode;", "", "", "valueNodeName", "Ljava/lang/String;", "getValueNodeName", "()Ljava/lang/String;", "ClickComment", "DialogPopup", "ClickSend", "SendChat", "SendAudio", "SendPrivilegeDanmaku", "SendAdminDanmaku", "SendChatSuccess", "SendAudioSuccess", "SendAdminDanmakuSuccess", "SendPrivilegeDanmakuSuccess", "PortraitClickSendCount", "PortraitChatApiTriggerCount", "PortraitChatApiSuccessCount", "PortraitSelfChatShowCount", "LandscapeClickSendCount", "LandscapeChatApiTriggerCount", "LandscapeChatApiSuccessCount", "LandscapeSelfChatShowCount", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum InputValueNode extends Enum<InputValueNode> {
    public static final InputValueNode ClickComment = null;
    public static final InputValueNode ClickSend = null;
    public static final InputValueNode DialogPopup = null;
    public static final InputValueNode LandscapeChatApiSuccessCount = null;
    public static final InputValueNode LandscapeChatApiTriggerCount = null;
    public static final InputValueNode LandscapeClickSendCount = null;
    public static final InputValueNode LandscapeSelfChatShowCount = null;
    public static final InputValueNode PortraitChatApiSuccessCount = null;
    public static final InputValueNode PortraitChatApiTriggerCount = null;
    public static final InputValueNode PortraitClickSendCount = null;
    public static final InputValueNode PortraitSelfChatShowCount = null;
    public static final InputValueNode SendAdminDanmaku = null;
    public static final InputValueNode SendAdminDanmakuSuccess = null;
    public static final InputValueNode SendAudio = null;
    public static final InputValueNode SendAudioSuccess = null;
    public static final InputValueNode SendChat = null;
    public static final InputValueNode SendChatSuccess = null;
    public static final InputValueNode SendPrivilegeDanmaku = null;
    public static final InputValueNode SendPrivilegeDanmakuSuccess = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InputValueNode[] f133343a = null;
    private final String valueNodeName;

    public static InputValueNode valueOf(String r100) {
        return (InputValueNode) a.a(InputValueNode.class, r100);
    }

    public static InputValueNode[] values() {
        return (InputValueNode[]) f133343a.clone();
    }

    static {
        InputValueNode r100 = new InputValueNode("ClickComment", 0, "click_comment");
        ClickComment = r100;
        InputValueNode r101 = new InputValueNode("DialogPopup", 1, "dialog_popup");
        DialogPopup = r101;
        InputValueNode r102 = new InputValueNode("ClickSend", 2, "click_send");
        ClickSend = r102;
        InputValueNode r103 = new InputValueNode("SendChat", 3, "send_chat");
        SendChat = r103;
        InputValueNode r104 = new InputValueNode("SendAudio", 4, "send_audio");
        SendAudio = r104;
        InputValueNode r105 = new InputValueNode("SendPrivilegeDanmaku", 5, "send_privilege_danmaku");
        SendPrivilegeDanmaku = r105;
        InputValueNode r106 = new InputValueNode("SendAdminDanmaku", 6, "send_admin_danmaku");
        SendAdminDanmaku = r106;
        InputValueNode r107 = new InputValueNode("SendChatSuccess", 7, "send_chat_success");
        SendChatSuccess = r107;
        InputValueNode r108 = new InputValueNode("SendAudioSuccess", 8, "send_audio_success");
        SendAudioSuccess = r108;
        InputValueNode r109 = new InputValueNode("SendAdminDanmakuSuccess", 9, "send_admin_danmaku_success");
        SendAdminDanmakuSuccess = r109;
        InputValueNode r110 = new InputValueNode("SendPrivilegeDanmakuSuccess", 10, "send_privilege_danmaku_success");
        SendPrivilegeDanmakuSuccess = r110;
        InputValueNode r111 = new InputValueNode("PortraitClickSendCount", 11, "portrait_click_send_count");
        PortraitClickSendCount = r111;
        InputValueNode r112 = new InputValueNode("PortraitChatApiTriggerCount", 12, "portrait_chat_api_trigger_count");
        PortraitChatApiTriggerCount = r112;
        InputValueNode r113 = new InputValueNode("PortraitChatApiSuccessCount", 13, "portrait_chat_api_success_count");
        PortraitChatApiSuccessCount = r113;
        InputValueNode r114 = new InputValueNode("PortraitSelfChatShowCount", 14, "portrait_self_chat_show_count");
        PortraitSelfChatShowCount = r114;
        InputValueNode r115 = new InputValueNode("LandscapeClickSendCount", 15, "landscape_click_send_count");
        LandscapeClickSendCount = r115;
        InputValueNode r116 = new InputValueNode("LandscapeChatApiTriggerCount", 16, "landscape_chat_api_trigger_count");
        LandscapeChatApiTriggerCount = r116;
        InputValueNode r117 = new InputValueNode("LandscapeChatApiSuccessCount", 17, "landscape_chat_api_success_count");
        LandscapeChatApiSuccessCount = r117;
        InputValueNode r118 = new InputValueNode("LandscapeSelfChatShowCount", 18, "landscape_self_chat_show_count");
        LandscapeSelfChatShowCount = r118;
        f133343a = new InputValueNode[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118};
    }

    public final String getValueNodeName() {
        return this.valueNodeName;
    }

    public InputValueNode(String r100, int r101, String r102) {
        super(r100, r101);
        this.valueNodeName = r102;
    }
}
