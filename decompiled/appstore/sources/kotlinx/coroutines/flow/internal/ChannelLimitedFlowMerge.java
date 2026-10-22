package kotlinx.coroutines.flow.internal;

import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes4.dex */
public final class ChannelLimitedFlowMerge extends ChannelFlow {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Iterable f21528d;

    public /* synthetic */ ChannelLimitedFlowMerge(Iterable r10, CoroutineContext r11, int r12, BufferOverflow r13, int r14, DefaultConstructorMarker r15) {
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

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public Object c(ProducerScope r10, Continuation r11) {
        o r12 = new o(r10);
        Iterator r13 = this.f21528d.iterator();
    L4:
        if (r13.hasNext() == false) goto L7;
        kotlinx.coroutines.h.d(r10, null, null, new ChannelLimitedFlowMerge$collectTo$2$1((Flow) r13.next(), r12, null), 3, null);
        goto L4
    L7:
        return Unit.f21064a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public ChannelFlow d(CoroutineContext r10, int r11, BufferOverflow r12) {
        return new ChannelLimitedFlowMerge(this.f21528d, r10, r11, r12);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public ReceiveChannel h(CoroutineScope r10) {
        return ProduceKt.b(r10, this.f21519a, this.f21520b, f());
    }

    public ChannelLimitedFlowMerge(Iterable r10, CoroutineContext r11, int r12, BufferOverflow r13) {
        super(r11, r12, r13);
        this.f21528d = r10;
    }
}
