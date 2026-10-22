package com.stepos.agentframework.chatcore.session;

import com.stepos.agentframework.chatcore.InterfaceC1848c;
import com.stepos.agentframework.chatcore.session.AgentSession;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.Iterator;
import kotlin.C4849c;
import kotlin.Function2;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import u4.AgentMessage;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation$regenerate$1", f = "AgentSession.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentSession$AgentConversation$regenerate$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $messageId;
    int label;
    final /* synthetic */ AgentSession this$0;
    final /* synthetic */ AgentSession.AgentConversation this$1;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation$regenerate$1$1", f = "AgentSession.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation$regenerate$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        int label;
        final /* synthetic */ AgentSession this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(AgentSession agentSession, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.this$0 = agentSession;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.this$0, interfaceC4014c);
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
            InterfaceC1848c chatView = this.this$0.getHandler().getChatView();
            if (chatView != null) {
                chatView.S();
            }
            return Y8.t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation$regenerate$1$2", f = "AgentSession.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation$regenerate$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ String $messageId;
        final /* synthetic */ ChatMessage $oldReply;
        final /* synthetic */ VariantGroupTag $tag;
        final /* synthetic */ ChatMessage $userMessage;
        int label;
        final /* synthetic */ AgentSession this$0;
        final /* synthetic */ AgentSession.AgentConversation this$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(AgentSession agentSession, String str, AgentSession.AgentConversation agentConversation, ChatMessage chatMessage, VariantGroupTag variantGroupTag, ChatMessage chatMessage2, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.this$0 = agentSession;
            this.$messageId = str;
            this.this$1 = agentConversation;
            this.$userMessage = chatMessage;
            this.$tag = variantGroupTag;
            this.$oldReply = chatMessage2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass2(this.this$0, this.$messageId, this.this$1, this.$userMessage, this.$tag, this.$oldReply, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            this.this$0.getHandler().k3(this.$messageId);
            AgentSession.AgentConversation.k0(this.this$1, this.$userMessage.i(), this.$userMessage, null, false, null, null, this.$tag, this.$oldReply.getMessageId(), 60, null);
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentSession$AgentConversation$regenerate$1(AgentSession agentSession, String str, AgentSession.AgentConversation agentConversation, InterfaceC4014c<? super AgentSession$AgentConversation$regenerate$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = agentSession;
        this.$messageId = str;
        this.this$1 = agentConversation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentSession$AgentConversation$regenerate$1(this.this$0, this.$messageId, this.this$1, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentSession$AgentConversation$regenerate$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object next;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        ChatMessage chatMessageV = this.this$0.messageRepository.v(this.$messageId);
        if (chatMessageV == null || chatMessageV.getRole() != AgentRole.ASSISTANT) {
            C4148a.u(this.this$1.TAG, "regenerate skip: not an assistant message, id=" + this.$messageId, false, 4, null);
            return Y8.t.f7040a;
        }
        Iterator<T> it = this.this$0.messageRepository.m(chatMessageV.getPairId()).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            AgentMessage agentMessage = (AgentMessage) Z8.F.s0(((ChatMessage) next).i());
            if ((agentMessage != null ? agentMessage.getType() : null) == AgentMessageType.TEXT) {
                break;
            }
        }
        ChatMessage chatMessage = (ChatMessage) next;
        if (chatMessage == null) {
            C4148a.u(this.this$1.TAG, "regenerate skip: no text question in pair " + chatMessageV.getPairId(), false, 4, null);
            Function2.b(new AnonymousClass1(this.this$0, null));
            return Y8.t.f7040a;
        }
        String variantGroupId = chatMessageV.getVariantGroupId();
        if (variantGroupId.length() == 0) {
            variantGroupId = chatMessageV.getMessageId();
        }
        if (!kotlin.p.INSTANCE.a(chatMessageV.getVariantCount())) {
            int iR = this.this$0.messageRepository.r(variantGroupId, chatMessageV.getVariantIndex());
            this.this$0.messageRepository.u(chatMessageV, variantGroupId, chatMessageV.getVariantIndex());
            VariantGroupTag variantGroupTag = new VariantGroupTag(variantGroupId, iR, iR + 1);
            C1939k0.d(chatMessage.getMessageId());
            Function2.b(new AnonymousClass2(this.this$0, this.$messageId, this.this$1, chatMessage, variantGroupTag, chatMessageV, null));
            return Y8.t.f7040a;
        }
        C4148a.u(this.this$1.TAG, "regenerate skip: max times reached count=" + chatMessageV.getVariantCount() + " group=" + variantGroupId, false, 4, null);
        return Y8.t.f7040a;
    }
}
