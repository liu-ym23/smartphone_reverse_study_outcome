package com.bytedance.android.livesdk.interactivity.api.comment.plugin;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/comment/plugin/CommentEntry;", "", "Click", "WannaSendAtEvent", "WannaSendEvent", "OpenPanelEvent", "GuideEvent", "SendFailed", "SendException", "ChatChannelWannaEvent", "SquareChatEvent", "SecretChat", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CommentEntry extends Enum<CommentEntry> {
    public static final CommentEntry ChatChannelWannaEvent = null;
    public static final CommentEntry Click = null;
    public static final CommentEntry GuideEvent = null;
    public static final CommentEntry OpenPanelEvent = null;
    public static final CommentEntry SecretChat = null;
    public static final CommentEntry SendException = null;
    public static final CommentEntry SendFailed = null;
    public static final CommentEntry SquareChatEvent = null;
    public static final CommentEntry WannaSendAtEvent = null;
    public static final CommentEntry WannaSendEvent = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CommentEntry[] f133047a = null;

    static {
        CommentEntry r100 = new CommentEntry("Click", 0);
        Click = r100;
        CommentEntry r101 = new CommentEntry("WannaSendAtEvent", 1);
        WannaSendAtEvent = r101;
        CommentEntry r102 = new CommentEntry("WannaSendEvent", 2);
        WannaSendEvent = r102;
        CommentEntry r103 = new CommentEntry("OpenPanelEvent", 3);
        OpenPanelEvent = r103;
        CommentEntry r104 = new CommentEntry("GuideEvent", 4);
        GuideEvent = r104;
        CommentEntry r105 = new CommentEntry("SendFailed", 5);
        SendFailed = r105;
        CommentEntry r106 = new CommentEntry("SendException", 6);
        SendException = r106;
        CommentEntry r107 = new CommentEntry("ChatChannelWannaEvent", 7);
        ChatChannelWannaEvent = r107;
        CommentEntry r108 = new CommentEntry("SquareChatEvent", 8);
        SquareChatEvent = r108;
        CommentEntry r109 = new CommentEntry("SecretChat", 9);
        SecretChat = r109;
        f133047a = new CommentEntry[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109};
    }

    public static CommentEntry valueOf(String r100) {
        return (CommentEntry) a.a(CommentEntry.class, r100);
    }

    public static CommentEntry[] values() {
        return (CommentEntry[]) f133047a.clone();
    }

    public CommentEntry(String r100, int r101) {
        super(r100, r101);
    }
}
