package com.stepos.agentframework.chatcore;

import Ua.M;
import com.stepos.agentframework.chatcore.session.AgentRole;
import com.stepos.agentframework.chatcore.session.AgentSession;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.SessionHandler$resendRound$1", f = "SessionHandler.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class SessionHandler$resendRound$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ AgentSession $currentSession;
    final /* synthetic */ String $messageId;
    final /* synthetic */ Map<String, String> $meta;
    int label;
    final /* synthetic */ SessionHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionHandler$resendRound$1(AgentSession agentSession, String str, SessionHandler sessionHandler, Map<String, String> map, InterfaceC4014c<? super SessionHandler$resendRound$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$currentSession = agentSession;
        this.$messageId = str;
        this.this$0 = sessionHandler;
        this.$meta = map;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SessionHandler$resendRound$1(this.$currentSession, this.$messageId, this.this$0, this.$meta, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((SessionHandler$resendRound$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ChatMessage chatMessagePrevious;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        x4.f messageRepository = this.$currentSession.getMessageRepository();
        ChatMessage chatMessageV = messageRepository.v(this.$messageId);
        String messageId = null;
        if (chatMessageV == null || chatMessageV.getRole() != AgentRole.USER) {
            C4148a.u(this.this$0.TAG, "resendRound skipped: user message not found id=" + this.$messageId, false, 4, null);
            return Y8.t.f7040a;
        }
        String sessionId = chatMessageV.getSessionId();
        if (sessionId.length() <= 0) {
            sessionId = null;
        }
        if (sessionId != null) {
            List<ChatMessage> listG = messageRepository.g(sessionId);
            ListIterator<ChatMessage> listIterator = listG.listIterator(listG.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    chatMessagePrevious = null;
                    break;
                }
                chatMessagePrevious = listIterator.previous();
                ChatMessage chatMessage = chatMessagePrevious;
                if (chatMessage.getRole() == AgentRole.ASSISTANT && kotlin.jvm.internal.p.d(chatMessage.getPairId(), chatMessageV.getPairId())) {
                    break;
                }
            }
            ChatMessage chatMessage2 = chatMessagePrevious;
            if (chatMessage2 != null) {
                messageId = chatMessage2.getMessageId();
            }
        }
        this.this$0.u3(messageRepository, chatMessageV, messageId, this.$meta);
        return Y8.t.f7040a;
    }
}
