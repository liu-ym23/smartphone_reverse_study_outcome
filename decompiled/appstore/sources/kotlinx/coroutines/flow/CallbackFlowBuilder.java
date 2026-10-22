package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.internal.ChannelFlow;

/* JADX INFO: loaded from: classes4.dex */
public final class CallbackFlowBuilder extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function2 f21426e;

    public /* synthetic */ CallbackFlowBuilder(Function2 r10, CoroutineContext r11, int r12, BufferOverflow r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = EmptyCoroutineContext.INSTANCE;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = -2;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = BufferOverflow.SUSPEND;
    L11:
        this(r10, r11, r12, r13);
    }

    @Override // kotlinx.coroutines.flow.b, kotlinx.coroutines.flow.internal.ChannelFlow
    public Object c(ProducerScope r10, Continuation r11) {
        if ((r11 instanceof CallbackFlowBuilder$collectTo$1) == false) goto L7;
        CallbackFlowBuilder$collectTo$1 r12 = (CallbackFlowBuilder$collectTo$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        r10 = (ProducerScope) r12.L$0;
        kotlin.c.b(r14);
    L18:
        if (r10.isClosedForSend() == false) goto L22;
        return Unit.f21064a;
    L22:
        throw new IllegalStateException("'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details.");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        kotlin.c.b(r14);
        r12.L$0 = r10;
        r12.label = 1;
        if (super.c(r10, r12) != r15) goto L18;
        return r15;
    L7:
        r12 = new CallbackFlowBuilder$collectTo$1(this, r11);
        goto L8
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public ChannelFlow d(CoroutineContext r10, int r11, BufferOverflow r12) {
        return new CallbackFlowBuilder(this.f21426e, r10, r11, r12);
    }

    public CallbackFlowBuilder(Function2 r10, CoroutineContext r11, int r12, BufferOverflow r13) {
        super(r10, r11, r12, r13);
        this.f21426e = r10;
    }
}
