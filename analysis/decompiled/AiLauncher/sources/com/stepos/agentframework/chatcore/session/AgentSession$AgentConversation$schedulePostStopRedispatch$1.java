package com.stepos.agentframework.chatcore.session;

import com.stepos.agentframework.chatcore.session.AgentSession;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.concurrent.CancellationException;
import kotlin.C4849c;
import kotlin.Function2;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation$schedulePostStopRedispatch$1", f = "AgentSession.kt", l = {4604}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentSession$AgentConversation$schedulePostStopRedispatch$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ PendingSend $payload;
    final /* synthetic */ ChatRound $round;
    int label;
    final /* synthetic */ AgentSession.AgentConversation this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation$schedulePostStopRedispatch$1$1", f = "AgentSession.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation$schedulePostStopRedispatch$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ ChatRound $round;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ChatRound chatRound, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$round = chatRound;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.$round, interfaceC4014c);
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
            this.$round.b(false, null, "post-stop redispatch failed");
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentSession$AgentConversation$schedulePostStopRedispatch$1(ChatRound chatRound, AgentSession.AgentConversation agentConversation, PendingSend pendingSend, InterfaceC4014c<? super AgentSession$AgentConversation$schedulePostStopRedispatch$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$round = chatRound;
        this.this$0 = agentConversation;
        this.$payload = pendingSend;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentSession$AgentConversation$schedulePostStopRedispatch$1(this.$round, this.this$0, this.$payload, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentSession$AgentConversation$schedulePostStopRedispatch$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                this.label = 1;
                if (Ua.U.a(500L, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
        } catch (CancellationException e10) {
            throw e10;
        } catch (Exception e11) {
            C4148a.t(this.this$0.TAG, "post-stop redispatch error:" + e11.getMessage(), e11, false, 8, null);
            this.$round.k1();
            ChatRound chatRound = this.this$0.chatRound;
            ChatRound chatRound2 = this.$round;
            if (chatRound == chatRound2 && chatRound2.getTalkPhase() == TalkPhase.SENDING) {
                Function2.b(new AnonymousClass1(this.$round, null));
            }
        }
        if (this.$round.getTalkPhase() == TalkPhase.SENDING) {
            ChatRound chatRound3 = this.this$0.chatRound;
            ChatRound chatRound4 = this.$round;
            if (chatRound3 == chatRound4 && !chatRound4.getSendPhaseHardTimedOut()) {
                this.$round.k1();
                C4148a.k(this.this$0.TAG, "post-stop redispatch user message once sessionId=" + this.this$0.B(), false, 4, null);
                this.this$0.Y(this.$payload.b(), this.$payload.getDeepThinking(), this.$payload.c());
                return Y8.t.f7040a;
            }
        }
        C4148a.k(this.this$0.TAG, "post-stop redispatch skipped: round not SENDING/current sessionId=" + this.this$0.B(), false, 4, null);
        this.$round.k1();
        return Y8.t.f7040a;
    }
}
