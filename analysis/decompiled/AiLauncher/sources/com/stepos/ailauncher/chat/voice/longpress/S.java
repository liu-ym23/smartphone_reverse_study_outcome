package com.stepos.ailauncher.chat.voice.longpress;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/longpress/S;", "", "<init>", "()V", "", "isSessionCenter", "hasConversationPanel", "hasInputBar", "Lcom/stepos/ailauncher/chat/voice/longpress/RecordingPresentation;", Const.INTENT_KEY_APIKEY, "(ZZZ)Lcom/stepos/ailauncher/chat/voice/longpress/RecordingPresentation;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class S {
    public static final S INSTANCE = new S();

    public final RecordingPresentation a(boolean isSessionCenter, boolean hasConversationPanel, boolean hasInputBar) {
        return (isSessionCenter || hasConversationPanel || hasInputBar) ? RecordingPresentation.INPUT_BAR : RecordingPresentation.FULL_SCREEN;
    }
}
