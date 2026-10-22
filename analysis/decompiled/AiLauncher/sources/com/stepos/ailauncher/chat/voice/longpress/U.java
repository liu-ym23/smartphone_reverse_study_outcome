package com.stepos.ailauncher.chat.voice.longpress;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.speech.R$string;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/longpress/U;", "Lcom/stepos/ailauncher/chat/voice/longpress/l;", "<init>", "()V", "", "recordingHintRes", "I", Const.INTENT_KEY_APIKEY, "()I", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class U implements InterfaceC3047l {
    public static final U INSTANCE = new U();
    private static final int recordingHintRes = R$string.speech_release_to_send_swipe_up_to_cancel;

    @Override // com.stepos.ailauncher.chat.voice.longpress.InterfaceC3047l
    public int a() {
        return recordingHintRes;
    }

    @Override // com.stepos.ailauncher.chat.voice.longpress.InterfaceC3047l
    public /* bridge */ int b(boolean z10) {
        return super.b(z10);
    }
}
