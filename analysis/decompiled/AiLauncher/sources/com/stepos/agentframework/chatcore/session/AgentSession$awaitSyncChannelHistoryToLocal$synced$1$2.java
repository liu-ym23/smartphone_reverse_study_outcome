package com.stepos.agentframework.chatcore.session;

import com.stepos.agentframework.chatcore.session.AgentSession;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.AgentSession$awaitSyncChannelHistoryToLocal$synced$1$2", f = "AgentSession.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentSession$awaitSyncChannelHistoryToLocal$synced$1$2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $sessionId;
    final /* synthetic */ List<ChatMessage> $settled;
    final /* synthetic */ AgentSession $this_runCatching;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentSession$awaitSyncChannelHistoryToLocal$synced$1$2(AgentSession agentSession, String str, List<ChatMessage> list, InterfaceC4014c<? super AgentSession$awaitSyncChannelHistoryToLocal$synced$1$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$this_runCatching = agentSession;
        this.$sessionId = str;
        this.$settled = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentSession$awaitSyncChannelHistoryToLocal$synced$1$2(this.$this_runCatching, this.$sessionId, this.$settled, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentSession$awaitSyncChannelHistoryToLocal$synced$1$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        AgentSession.AgentConversation agentConversationP0 = this.$this_runCatching.P0(this.$sessionId);
        for (ChatMessage chatMessage : this.$settled) {
            if (agentConversationP0 != null) {
                agentConversationP0.q(chatMessage);
            }
        }
        return Y8.t.f7040a;
    }
}
