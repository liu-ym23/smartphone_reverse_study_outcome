package com.stepos.agentframework.chatcore.session;

import Z8.C1173v;
import com.stepos.agentframework.adapter.netcore.BusTaskStatus;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import s4.C5442c;
import u4.AgentTaskEvent;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.ChatRound$onDispatchedTaskSettled$1", f = "ChatRound.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class ChatRound$onDispatchedTaskSettled$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ AgentTaskEvent $event;
    int label;
    final /* synthetic */ ChatRound this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatRound$onDispatchedTaskSettled$1(ChatRound chatRound, AgentTaskEvent agentTaskEvent, InterfaceC4014c<? super ChatRound$onDispatchedTaskSettled$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = chatRound;
        this.$event = agentTaskEvent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ChatRound$onDispatchedTaskSettled$1(this.this$0, this.$event, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ChatRound$onDispatchedTaskSettled$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        if (this.this$0.getTalkPhase() == TalkPhase.FINISHED) {
            return Y8.t.f7040a;
        }
        if (this.this$0.roundActivitySeq.get() != this.this$0.taskDispatchActivitySeq) {
            C4148a.k(this.this$0.TAG, "skip settle-finish: round still active taskId=" + this.$event.y() + " seq=" + this.this$0.roundActivitySeq.get() + " dispatchSeq=" + this.this$0.taskDispatchActivitySeq + " phase=" + this.this$0.getTalkPhase(), false, 4, null);
            return Y8.t.f7040a;
        }
        C4148a.k(this.this$0.TAG, "finish round by settled task taskId=" + this.$event.y() + " status=" + this.$event.s() + " eventType=" + this.$event.getEventType() + " pairId=" + this.this$0.pairId + " phase=" + this.this$0.getTalkPhase(), false, 4, null);
        C5442c c5442c = C5442c.INSTANCE;
        String traceId = this.this$0.getTraceId();
        Pair pairA = Y8.j.a("taskId", this.$event.y());
        BusTaskStatus busTaskStatusS = this.$event.s();
        C5442c.l(c5442c, traceId, "event", kotlin.collections.a.m(pairA, Y8.j.a("status", busTaskStatusS != null ? busTaskStatusS.name() : null), Y8.j.a("eventType", this.$event.getEventType().name()), Y8.j.a("phase", this.this$0.getTalkPhase().name())), null, "ChatRound.onDispatchedTaskSettled", 8, null);
        G0 g02 = this.this$0.responseAssembler;
        String sessionId = this.this$0.getSession().getSessionId();
        ChatRound chatRound = this.this$0;
        if (sessionId.length() == 0) {
            sessionId = chatRound.getSession().getTempSessionId();
        }
        ChatMessage chatMessageV = g02.v(sessionId, this.this$0.owner.getAgentInfo().getAgentId(), this.this$0.pairId);
        if (chatMessageV != null) {
            ChatRound chatRound2 = this.this$0;
            chatRound2.r0(chatMessageV);
            C1939k0.k(C1173v.h(chatMessageV));
            chatRound2.S1(System.currentTimeMillis());
            ChatRound.N1(chatRound2, "COMPLETED", "", null, C4109a.a(!chatRound2.X0(chatMessageV)), 4, null);
        }
        this.this$0.D0();
        this.this$0.C0();
        this.this$0.getSession().u(this.this$0);
        return Y8.t.f7040a;
    }
}
