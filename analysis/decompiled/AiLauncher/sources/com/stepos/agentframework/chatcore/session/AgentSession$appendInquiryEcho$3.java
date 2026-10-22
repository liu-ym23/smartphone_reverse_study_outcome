package com.stepos.agentframework.chatcore.session;

import com.stepos.agentframework.chatcore.session.L0;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Function2;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import u4.m;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.AgentSession$appendInquiryEcho$3", f = "AgentSession.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentSession$appendInquiryEcho$3 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $askUserMessageId;
    final /* synthetic */ m.InquiryMessage $echo;
    final /* synthetic */ String $inquiryId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AgentSession this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.AgentSession$appendInquiryEcho$3$1", f = "AgentSession.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.agentframework.chatcore.session.AgentSession$appendInquiryEcho$3$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ ChatMessage $target;
        int label;
        final /* synthetic */ AgentSession this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(AgentSession agentSession, ChatMessage chatMessage, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.this$0 = agentSession;
            this.$target = chatMessage;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.this$0, this.$target, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            AgentSession agentSession = this.this$0;
            String sessionId = this.$target.getSessionId();
            if (sessionId.length() == 0) {
                sessionId = null;
            }
            agentSession.B0(new L0.MessageUpsert(sessionId, this.$target, 0L, 4, null));
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentSession$appendInquiryEcho$3(AgentSession agentSession, String str, String str2, m.InquiryMessage inquiryMessage, InterfaceC4014c<? super AgentSession$appendInquiryEcho$3> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = agentSession;
        this.$askUserMessageId = str;
        this.$inquiryId = str2;
        this.$echo = inquiryMessage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AgentSession$appendInquiryEcho$3 agentSession$appendInquiryEcho$3 = new AgentSession$appendInquiryEcho$3(this.this$0, this.$askUserMessageId, this.$inquiryId, this.$echo, interfaceC4014c);
        agentSession$appendInquiryEcho$3.L$0 = obj;
        return agentSession$appendInquiryEcho$3;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentSession$appendInquiryEcho$3) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        ChatMessage chatMessageV = this.this$0.messageRepository.v(this.$askUserMessageId);
        if (chatMessageV != null) {
            if (!K.c(chatMessageV, this.$inquiryId)) {
                chatMessageV.i().add(K.f(this.$echo));
                this.this$0.messageRepository.t(chatMessageV);
            }
            Function2.b(new AnonymousClass1(this.this$0, chatMessageV, null));
            return Y8.t.f7040a;
        }
        AgentSession agentSession = this.this$0;
        String str = this.$askUserMessageId;
        C4148a.u(agentSession.TAG, "appendInquiryEcho: message not found messageId:" + str, false, 4, null);
        return Y8.t.f7040a;
    }
}
