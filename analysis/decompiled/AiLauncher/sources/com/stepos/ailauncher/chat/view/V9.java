package com.stepos.ailauncher.chat.view;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.AgentSession;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\r\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00020\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/chat/view/V9;", "Lcom/stepos/agentframework/chatcore/session/AgentSession$h;", "Lcom/stepos/ailauncher/chat/view/c8;", "sink", "<init>", "(Lcom/stepos/ailauncher/chat/view/c8;)V", "", "sessionId", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)V", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "sinkRef", "Ljava/lang/ref/WeakReference;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class V9 implements AgentSession.h {
    private final WeakReference<InterfaceC2786c8> sinkRef;

    public V9(InterfaceC2786c8 sink) {
        kotlin.jvm.internal.p.i(sink, "sink");
        this.sinkRef = new WeakReference<>(sink);
    }

    @Override // com.stepos.agentframework.chatcore.session.AgentSession.h
    public void a(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        InterfaceC2786c8 interfaceC2786c8 = this.sinkRef.get();
        if (interfaceC2786c8 != null) {
            interfaceC2786c8.a(sessionId);
        }
    }
}
