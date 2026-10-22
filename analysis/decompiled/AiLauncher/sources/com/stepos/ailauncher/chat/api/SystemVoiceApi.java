package com.stepos.ailauncher.chat.api;

import Ac.f;
import e9.InterfaceC4014c;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/chat/api/SystemVoiceApi;", "", "Lcom/stepos/ailauncher/chat/api/SystemVoicesResponse;", "getSystemVoices", "(Le9/c;)Ljava/lang/Object;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface SystemVoiceApi {
    @f("cloud-audio-trans/api/v1/stepfun/audio/system-voices")
    Object getSystemVoices(InterfaceC4014c<? super SystemVoicesResponse> interfaceC4014c);
}
