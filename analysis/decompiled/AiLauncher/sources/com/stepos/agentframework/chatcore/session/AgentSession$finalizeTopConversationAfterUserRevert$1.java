package com.stepos.agentframework.chatcore.session;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.AgentSession$finalizeTopConversationAfterUserRevert$1", f = "AgentSession.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentSession$finalizeTopConversationAfterUserRevert$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $recalledMessageId;
    int label;
    final /* synthetic */ AgentSession this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentSession$finalizeTopConversationAfterUserRevert$1(AgentSession agentSession, String str, InterfaceC4014c<? super AgentSession$finalizeTopConversationAfterUserRevert$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = agentSession;
        this.$recalledMessageId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentSession$finalizeTopConversationAfterUserRevert$1(this.this$0, this.$recalledMessageId, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentSession$finalizeTopConversationAfterUserRevert$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String sessionId;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        try {
            sessionId = this.this$0.getTopConversation().getSessionId();
            AgentSession agentSession = this.this$0;
            if (sessionId.length() == 0) {
                sessionId = agentSession.getTopConversation().getTempSessionId();
            }
        } catch (Exception e10) {
            C4148a.t(this.this$0.TAG, "finalizeTopConversationAfterUserRevert error:" + e10.getMessage(), e10, false, 8, null);
        }
        if (sessionId.length() == 0) {
            return Y8.t.f7040a;
        }
        List<ChatMessage> listG = this.this$0.messageRepository.g(sessionId);
        String str = this.$recalledMessageId;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : listG) {
            ChatMessage chatMessage = (ChatMessage) obj2;
            if (!kotlin.jvm.internal.p.d(chatMessage.getMessageId(), str) && (chatMessage.getRole() != AgentRole.ASSISTANT || !K.e(chatMessage))) {
                arrayList.add(obj2);
            }
        }
        if (arrayList.isEmpty()) {
            this.this$0.z0(sessionId, this.$recalledMessageId);
        } else {
            if (!arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (((ChatMessage) it.next()).getRole() == AgentRole.USER) {
                        break;
                    }
                }
            }
            this.this$0.h2(sessionId);
        }
        return Y8.t.f7040a;
    }
}
