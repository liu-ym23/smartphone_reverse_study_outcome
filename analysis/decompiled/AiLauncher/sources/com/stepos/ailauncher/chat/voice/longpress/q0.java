package com.stepos.ailauncher.chat.voice.longpress;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.speech.R$string;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/longpress/q0;", "Lcom/stepos/ailauncher/chat/voice/longpress/l;", "<init>", "()V", "", "holdToTalk", "", Const.INTENT_KEY_PKGNAME, "(Z)I", "recordingHintRes", "I", Const.INTENT_KEY_APIKEY, "()I", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class q0 implements InterfaceC3047l {
    public static final q0 INSTANCE = new q0();
    private static final int recordingHintRes = R$string.speech_listening;

    @Override // com.stepos.ailauncher.chat.voice.longpress.InterfaceC3047l
    public int a() {
        return recordingHintRes;
    }

    @Override // com.stepos.ailauncher.chat.voice.longpress.InterfaceC3047l
    public int b(boolean holdToTalk) {
        return holdToTalk ? R$string.speech_release_to_send : a();
    }
}
