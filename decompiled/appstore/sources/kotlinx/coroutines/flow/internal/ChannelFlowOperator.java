package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ChannelFlowOperator extends ChannelFlow {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Flow f21522d;

    public ChannelFlowOperator(Flow r10, CoroutineContext r11, int r12, BufferOverflow r13) {
        super(r11, r12, r13);
        this.f21522d = r10;
    }

    public static /* synthetic */ Object i(ChannelFlowOperator r10, FlowCollector r11, Continuation r12) {
        if (r10.f21520b != (-3)) goto L18;
        CoroutineContext r13 = r12.getContext();
        CoroutineContext r14 = r13.plus(r10.f21519a);
        if (kotlin.jvm.internal.q.b(r14, r13) == false) goto L11;
        Object r15 = r10.l(r11, r12);
        if (r15 != kotlin.coroutines.intrinsics.a.d()) goto L10;
        return r15;
    L10:
        return Unit.f21064a;
    L11:
        ContinuationInterceptor.b r16 = ContinuationInterceptor.Key;
        if (kotlin.jvm.internal.q.b(r14.get(r16), r13.get(r16)) == false) goto L18;
        Object r17 = r10.k(r11, r14, r12);
        if (r17 != kotlin.coroutines.intrinsics.a.d()) goto L17;
        return r17;
    L17:
        return Unit.f21064a;
    L18:
        Object r18 = super.collect(r11, r12);
        if (r18 != kotlin.coroutines.intrinsics.a.d()) goto L22;
        return r18;
    L22:
        return Unit.f21064a;
    }

    public static /* synthetic */ Object j(ChannelFlowOperator r10, ProducerScope r11, Continuation r12) {
        Object r13 = r10.l(new o(r11), r12);
        if (r13 != kotlin.coroutines.intrinsics.a.d()) goto L6;
        return r13;
    L6:
        return Unit.f21064a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public Object c(ProducerScope r10, Continuation r11) {
        return j(this, r10, r11);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector r10, Continuation r11) {
        return i(this, r10, r11);
    }

    public final Object k(FlowCollector r10, CoroutineContext r11, Continuation r12) {
        Object r13 = d.d(r11, d.a(r10, r12.getContext()), null, new ChannelFlowOperator$collectWithContextUndispatched$2(this, null), r12, 4, null);
        if (r13 != kotlin.coroutines.intrinsics.a.d()) goto L6;
        return r13;
    L6:
        return Unit.f21064a;
    }

    public abstract Object l(FlowCollector r10, Continuation r11);

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public String toString() {
        return this.f21522d + " -> " + super.toString();
    }
}
