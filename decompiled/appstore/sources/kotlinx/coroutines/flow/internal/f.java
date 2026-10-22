package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes4.dex */
public final class f extends ChannelFlowOperator {
    public /* synthetic */ f(Flow r10, CoroutineContext r11, int r12, BufferOverflow r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = EmptyCoroutineContext.INSTANCE;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = -3;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = BufferOverflow.SUSPEND;
    L11:
        this(r10, r11, r12, r13);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public ChannelFlow d(CoroutineContext r10, int r11, BufferOverflow r12) {
        return new f(this.f21522d, r10, r11, r12);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public Flow e() {
        return this.f21522d;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlowOperator
    public Object l(FlowCollector r10, Continuation r11) {
        Object r12 = this.f21522d.collect(r10, r11);
        if (r12 != kotlin.coroutines.intrinsics.a.d()) goto L6;
        return r12;
    L6:
        return Unit.f21064a;
    }

    public f(Flow r10, CoroutineContext r11, int r12, BufferOverflow r13) {
        super(r10, r11, r12, r13);
    }
}
