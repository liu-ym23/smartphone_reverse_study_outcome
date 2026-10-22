package com.bytedance.android.livesdk.interactivity.api.comment.event;

import com.ss.android.lark.biz.im.api.extension.message.IMessageResourcePreloadTask;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u001b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/comment/event/OpenInputSource;", "", "", "source", "Ljava/lang/String;", "getSource", "()Ljava/lang/String;", "ClickCommentBox", "EmojiExpose", "LongPressMessage", "PSDialogReply", "AudiencePSDialogReply", "ProfileAt", "AnchorInteractivityPanel", "ChatChannel", "SecretChat", "ReplySecretChat", "ReplyHeartSecretChat", "AtUserEvent", "OpenPanelEvent", "OpenEmojiEvent", "InputActivityEmojiEvent", "InputFusionEmojiEvent", "OpenLiveEvent", "Preview", "BindMobilePhone", "Unknow", "GuideEvent", "PreviewEntryChat", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum OpenInputSource extends Enum<OpenInputSource> {
    public static final OpenInputSource AnchorInteractivityPanel = null;
    public static final OpenInputSource AtUserEvent = null;
    public static final OpenInputSource AudiencePSDialogReply = null;
    public static final OpenInputSource BindMobilePhone = null;
    public static final OpenInputSource ChatChannel = null;
    public static final OpenInputSource ClickCommentBox = null;
    public static final OpenInputSource EmojiExpose = null;
    public static final OpenInputSource GuideEvent = null;
    public static final OpenInputSource InputActivityEmojiEvent = null;
    public static final OpenInputSource InputFusionEmojiEvent = null;
    public static final OpenInputSource LongPressMessage = null;
    public static final OpenInputSource OpenEmojiEvent = null;
    public static final OpenInputSource OpenLiveEvent = null;
    public static final OpenInputSource OpenPanelEvent = null;
    public static final OpenInputSource PSDialogReply = null;
    public static final OpenInputSource Preview = null;
    public static final OpenInputSource PreviewEntryChat = null;
    public static final OpenInputSource ProfileAt = null;
    public static final OpenInputSource ReplyHeartSecretChat = null;
    public static final OpenInputSource ReplySecretChat = null;
    public static final OpenInputSource SecretChat = null;
    public static final OpenInputSource Unknow = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OpenInputSource[] f133042a = null;
    private final String source;

    public static OpenInputSource valueOf(String r100) {
        return (OpenInputSource) a.a(OpenInputSource.class, r100);
    }

    public static OpenInputSource[] values() {
        return (OpenInputSource[]) f133042a.clone();
    }

    static {
        OpenInputSource r100 = new OpenInputSource("ClickCommentBox", 0, "click_comment_box");
        ClickCommentBox = r100;
        OpenInputSource r101 = new OpenInputSource("EmojiExpose", 1, "emojiExpose");
        EmojiExpose = r101;
        OpenInputSource r102 = new OpenInputSource("LongPressMessage", 2, "long_press_message");
        LongPressMessage = r102;
        OpenInputSource r103 = new OpenInputSource("PSDialogReply", 3, "ps_dialog_reply");
        PSDialogReply = r103;
        OpenInputSource r104 = new OpenInputSource("AudiencePSDialogReply", 4, "audience_ps_dialog_reply");
        AudiencePSDialogReply = r104;
        OpenInputSource r105 = new OpenInputSource("ProfileAt", 5, "profile_at");
        ProfileAt = r105;
        OpenInputSource r106 = new OpenInputSource("AnchorInteractivityPanel", 6, "anchor_interactivity_panel");
        AnchorInteractivityPanel = r106;
        OpenInputSource r107 = new OpenInputSource("ChatChannel", 7, "chat_channel");
        ChatChannel = r107;
        OpenInputSource r108 = new OpenInputSource("SecretChat", 8, IMessageResourcePreloadTask.Scene.SECRET_CHAT);
        SecretChat = r108;
        OpenInputSource r109 = new OpenInputSource("ReplySecretChat", 9, "reply_secret_chat");
        ReplySecretChat = r109;
        OpenInputSource r110 = new OpenInputSource("ReplyHeartSecretChat", 10, "reply_heart_secret_chat");
        ReplyHeartSecretChat = r110;
        OpenInputSource r111 = new OpenInputSource("AtUserEvent", 11, "jsb_at_user");
        AtUserEvent = r111;
        OpenInputSource r112 = new OpenInputSource("OpenPanelEvent", 12, "jsb_open_panel");
        OpenPanelEvent = r112;
        OpenInputSource r113 = new OpenInputSource("OpenEmojiEvent", 13, "jsb_open_emoji");
        OpenEmojiEvent = r113;
        OpenInputSource r114 = new OpenInputSource("InputActivityEmojiEvent", 14, "jsb_input_activity_emoji");
        InputActivityEmojiEvent = r114;
        OpenInputSource r115 = new OpenInputSource("InputFusionEmojiEvent", 15, "jsb_input_fusion_emoji");
        InputFusionEmojiEvent = r115;
        OpenInputSource r116 = new OpenInputSource("OpenLiveEvent", 16, "jsb_open_live");
        OpenLiveEvent = r116;
        OpenInputSource r117 = new OpenInputSource("Preview", 17, "preview");
        Preview = r117;
        OpenInputSource r118 = new OpenInputSource("BindMobilePhone", 18, "bind_phone_number");
        BindMobilePhone = r118;
        OpenInputSource r119 = new OpenInputSource("Unknow", 19, "unknow");
        Unknow = r119;
        OpenInputSource r120 = new OpenInputSource("GuideEvent", 20, "guide_event");
        GuideEvent = r120;
        OpenInputSource r121 = new OpenInputSource("PreviewEntryChat", 21, "preview_entry_chat");
        PreviewEntryChat = r121;
        f133042a = new OpenInputSource[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121};
    }

    public final String getSource() {
        return this.source;
    }

    public OpenInputSource(String r100, int r101, String r102) {
        super(r100, r101);
        this.source = r102;
    }
}
