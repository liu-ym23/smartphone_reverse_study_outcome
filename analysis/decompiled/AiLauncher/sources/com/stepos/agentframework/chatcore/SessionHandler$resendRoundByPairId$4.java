package com.stepos.agentframework.chatcore;

import Ua.M;
import com.stepos.agentframework.chatcore.session.AgentSession;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import u4.AgentMessage;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.SessionHandler$resendRoundByPairId$4", f = "SessionHandler.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class SessionHandler$resendRoundByPairId$4 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ Map<String, String> $meta;
    final /* synthetic */ List<ChatMessage> $pairUsers;
    final /* synthetic */ List<AgentMessage> $parts;
    final /* synthetic */ String $staleAssistantId;
    final /* synthetic */ ChatMessage $textAnchor;
    int label;
    final /* synthetic */ SessionHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionHandler$resendRoundByPairId$4(SessionHandler sessionHandler, String str, ChatMessage chatMessage, List<ChatMessage> list, List<AgentMessage> list2, Map<String, String> map, InterfaceC4014c<? super SessionHandler$resendRoundByPairId$4> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = sessionHandler;
        this.$staleAssistantId = str;
        this.$textAnchor = chatMessage;
        this.$pairUsers = list;
        this.$parts = list2;
        this.$meta = map;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SessionHandler$resendRoundByPairId$4(this.this$0, this.$staleAssistantId, this.$textAnchor, this.$pairUsers, this.$parts, this.$meta, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((SessionHandler$resendRoundByPairId$4) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        AgentSession.AgentConversation topConversation;
        InterfaceC1848c chatView;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        InterfaceC1848c chatView2 = this.this$0.getChatView();
        if (chatView2 != null) {
            InterfaceC1848c.j(chatView2, null, 1, null);
        }
        String str = this.$staleAssistantId;
        if (str != null && (chatView = this.this$0.getChatView()) != null) {
            chatView.K(str);
        }
        if (this.$textAnchor == null) {
            List<ChatMessage> list = this.$pairUsers;
            SessionHandler sessionHandler = this.this$0;
            for (ChatMessage chatMessage : list) {
                InterfaceC1848c chatView3 = sessionHandler.getChatView();
                if (chatView3 != null) {
                    chatView3.K(chatMessage.getMessageId());
                }
            }
        }
        this.this$0.b1();
        AgentSession agentSession = this.this$0.session;
        if (agentSession != null && (topConversation = agentSession.getTopConversation()) != null) {
            List<AgentMessage> list2 = this.$parts;
            ChatMessage chatMessage2 = this.$textAnchor;
            if (chatMessage2 == null) {
                chatMessage2 = (ChatMessage) Z8.F.C0(this.$pairUsers);
            }
            AgentSession.AgentConversation.k0(topConversation, list2, chatMessage2, null, false, this.$meta, null, null, null, 236, null);
        }
        return Y8.t.f7040a;
    }
}
