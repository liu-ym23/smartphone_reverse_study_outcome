package com.bytedance.android.livesdk.interactivity.textmessage.render;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/textmessage/render/TextMessageSpanAction;", "", "Ltb2/b;", "CHAT_CONTENT", "INVITOR_NAME", "INVITEE_NAME", "interactivity-platform-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TextMessageSpanAction extends Enum<TextMessageSpanAction> implements tb2.b {
    public static final TextMessageSpanAction CHAT_CONTENT = null;
    public static final TextMessageSpanAction INVITEE_NAME = null;
    public static final TextMessageSpanAction INVITOR_NAME = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TextMessageSpanAction[] f141208a = null;

    static {
        TextMessageSpanAction r100 = new TextMessageSpanAction("CHAT_CONTENT", 0);
        CHAT_CONTENT = r100;
        TextMessageSpanAction r101 = new TextMessageSpanAction("INVITOR_NAME", 1);
        INVITOR_NAME = r101;
        TextMessageSpanAction r102 = new TextMessageSpanAction("INVITEE_NAME", 2);
        INVITEE_NAME = r102;
        f141208a = new TextMessageSpanAction[]{r100, r101, r102};
    }

    public static TextMessageSpanAction valueOf(String r100) {
        return (TextMessageSpanAction) r27.a.a(TextMessageSpanAction.class, r100);
    }

    public static TextMessageSpanAction[] values() {
        return (TextMessageSpanAction[]) f141208a.clone();
    }

    public TextMessageSpanAction(String r100, int r101) {
        super(r100, r101);
    }
}
