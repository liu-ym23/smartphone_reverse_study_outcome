package com.stepos.agentframework.chatcore.send;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.AgentSession;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\b\u0000\u0012\n\u0010\u0004\u001a\u00060\u0002R\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u001e\u0010\u0004\u001a\u00060\u0002R\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/agentframework/chatcore/send/l;", "", "Lcom/stepos/agentframework/chatcore/session/AgentSession$AgentConversation;", "Lcom/stepos/agentframework/chatcore/session/AgentSession;", "conversation", "<init>", "(Lcom/stepos/agentframework/chatcore/session/AgentSession$AgentConversation;)V", "", "toString", "()Ljava/lang/String;", "Lcom/stepos/agentframework/chatcore/session/AgentSession$AgentConversation;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/agentframework/chatcore/session/AgentSession$AgentConversation;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.send.l, reason: from toString */
/* loaded from: classes2.dex */
public final class SlaSessionAnchor {
    private final AgentSession.AgentConversation conversation;

    public SlaSessionAnchor(AgentSession.AgentConversation conversation) {
        p.i(conversation, "conversation");
        this.conversation = conversation;
    }

    /* renamed from: a, reason: from getter */
    public final AgentSession.AgentConversation getConversation() {
        return this.conversation;
    }

    public String toString() {
        return "SlaSessionAnchor(sid=" + this.conversation.getSessionId() + ",temp=" + this.conversation.getTempSessionId() + ")";
    }
}
