package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes4.dex */
public final class ChannelFlowTransformLatest extends ChannelFlowOperator {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function3 f21523e;

    public /* synthetic */ ChannelFlowTransformLatest(Function3 r10, Flow r11, CoroutineContext r12, int r13, BufferOverflow r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 4) == 0) goto L5;
        r12 = EmptyCoroutineContext.INSTANCE;
    L5:
        CoroutineContext r17 = r12;
        if ((r15 & 8) == 0) goto L8;
        r13 = -2;
    L8:
        int r18 = r13;
        if ((r15 & 16) == 0) goto L11;
        r14 = BufferOverflow.SUSPEND;
    L11:
        this(r10, r11, r17, r18, r14);
    }

    public static final /* synthetic */ Function3 m(ChannelFlowTransformLatest r10) {
        return r10.f21523e;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public ChannelFlow d(CoroutineContext r10, int r11, BufferOverflow r12) {
        return new ChannelFlowTransformLatest(this.f21523e, this.f21522d, r10, r11, r12);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlowOperator
    public Object l(FlowCollector r10, Continuation r11) {
        Object r12 = d0.e(new ChannelFlowTransformLatest$flowCollect$3(this, r10, null), r11);
        if (r12 != kotlin.coroutines.intrinsics.a.d()) goto L6;
        return r12;
    L6:
        return Unit.f21064a;
    }

    public ChannelFlowTransformLatest(Function3 r10, Flow r11, CoroutineContext r12, int r13, BufferOverflow r14) {
        super(r11, r12, r13, r14);
        this.f21523e = r10;
    }
}
