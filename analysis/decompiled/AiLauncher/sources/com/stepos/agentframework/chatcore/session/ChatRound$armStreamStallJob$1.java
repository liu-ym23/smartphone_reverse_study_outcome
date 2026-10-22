package com.stepos.agentframework.chatcore.session;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Function2;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.ChatRound$armStreamStallJob$1", f = "ChatRound.kt", l = {796}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class ChatRound$armStreamStallJob$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ TalkPhase $phase;
    int label;
    final /* synthetic */ ChatRound this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.ChatRound$armStreamStallJob$1$1", f = "ChatRound.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.agentframework.chatcore.session.ChatRound$armStreamStallJob$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ boolean $offline;
        final /* synthetic */ TalkPhase $phase;
        int label;
        final /* synthetic */ ChatRound this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ChatRound chatRound, TalkPhase talkPhase, boolean z10, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.this$0 = chatRound;
            this.$phase = talkPhase;
            this.$offline = z10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.this$0, this.$phase, this.$offline, interfaceC4014c);
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
            if (this.this$0.getTalkPhase() != this.$phase) {
                return Y8.t.f7040a;
            }
            if (this.this$0.f1("stream-stall")) {
                this.this$0.V(this.$phase);
                return Y8.t.f7040a;
            }
            C4148a.u(this.this$0.TAG, "stream stalled over " + this.this$0.owner.getConfig().getStreamStallTimeoutMs() + " ms at " + this.$phase + " offline=" + this.$offline, false, 4, null);
            ChatRound.T0(this.this$0, InterruptCause.STREAM_STALL, C4109a.a(this.$offline), false, 4, null);
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatRound$armStreamStallJob$1(ChatRound chatRound, TalkPhase talkPhase, InterfaceC4014c<? super ChatRound$armStreamStallJob$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = chatRound;
        this.$phase = talkPhase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ChatRound$armStreamStallJob$1(this.this$0, this.$phase, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ChatRound$armStreamStallJob$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            long streamStallTimeoutMs = this.this$0.owner.getConfig().getStreamStallTimeoutMs();
            this.label = 1;
            if (Ua.U.a(streamStallTimeoutMs, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        if (this.this$0.getTalkPhase() != this.$phase) {
            return Y8.t.f7040a;
        }
        Function2.b(new AnonymousClass1(this.this$0, this.$phase, this.this$0.a1(), null));
        return Y8.t.f7040a;
    }
}
