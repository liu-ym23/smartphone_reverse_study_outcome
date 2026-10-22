package kotlinx.coroutines.flow;

import java.util.Collection;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ReceiveChannel;

/* JADX INFO: loaded from: classes4.dex */
public abstract class c {
    public static final Flow A(Function2 r10) {
        return n.b(r10);
    }

    public static final Flow B(Flow r10, Flow r11, Function3 r12) {
        return FlowKt__ZipKt.d(r10, r11, r12);
    }

    public static final Flow C(Object r10) {
        return n.c(r10);
    }

    public static final Flow D(Flow r10, CoroutineContext r11) {
        return q.e(r10, r11);
    }

    public static final Object E(Flow r10, Continuation r11) {
        return FlowKt__ReduceKt.f(r10, r11);
    }

    public static final Object F(Flow r10, Continuation r11) {
        return FlowKt__ReduceKt.g(r10, r11);
    }

    public static final Job G(Flow r10, CoroutineScope r11) {
        return FlowKt__CollectKt.d(r10, r11);
    }

    public static final Flow H(Flow r10, Function2 r11) {
        return FlowKt__MergeKt.a(r10, r11);
    }

    public static final Flow I(Iterable r10) {
        return FlowKt__MergeKt.b(r10);
    }

    public static final Flow J(Flow... r10) {
        return FlowKt__MergeKt.c(r10);
    }

    public static final Flow K(Flow r10, Function2 r11) {
        return FlowKt__TransformKt.b(r10, r11);
    }

    public static final Flow L(Flow r10, Function2 r11) {
        return FlowKt__EmittersKt.d(r10, r11);
    }

    public static final ReceiveChannel M(Flow r10, CoroutineScope r11) {
        return FlowKt__ChannelsKt.d(r10, r11);
    }

    public static final Object N(Flow r10, Function3 r11, Continuation r12) {
        return FlowKt__ReduceKt.h(r10, r11, r12);
    }

    public static final Object O(Flow r10, Continuation r11) {
        return FlowKt__ReduceKt.i(r10, r11);
    }

    public static final Object P(Flow r10, Continuation r11) {
        return FlowKt__ReduceKt.j(r10, r11);
    }

    public static final StateFlow Q(Flow r10, CoroutineScope r11, SharingStarted r12, Object r13) {
        return FlowKt__ShareKt.e(r10, r11, r12, r13);
    }

    public static final Object R(Flow r10, Collection r11, Continuation r12) {
        return FlowKt__CollectionKt.a(r10, r11, r12);
    }

    public static final Flow S(Flow r10, Function3 r11) {
        return FlowKt__MergeKt.d(r10, r11);
    }

    public static final SharedFlow a(MutableSharedFlow r10) {
        return FlowKt__ShareKt.a(r10);
    }

    public static final StateFlow b(MutableStateFlow r10) {
        return FlowKt__ShareKt.b(r10);
    }

    public static final Flow c(Flow r10, int r11, BufferOverflow r12) {
        return q.a(r10, r11, r12);
    }

    public static /* synthetic */ Flow d(Flow r10, int r11, BufferOverflow r12, int r13, Object r14) {
        return q.b(r10, r11, r12, r13, r14);
    }

    public static final Flow e(Function2 r10) {
        return n.a(r10);
    }

    public static final Object f(Flow r10, FlowCollector r11, Continuation r12) {
        return FlowKt__ErrorsKt.a(r10, r11, r12);
    }

    public static final Object g(Flow r10, Continuation r11) {
        return FlowKt__CollectKt.a(r10, r11);
    }

    public static final Object h(Flow r10, Function2 r11, Continuation r12) {
        return FlowKt__CollectKt.b(r10, r11, r12);
    }

    public static final Flow i(Flow r10, Flow r11, Function3 r12) {
        return FlowKt__ZipKt.b(r10, r11, r12);
    }

    public static final Flow j(Flow r10, Flow r11, Flow r12, Function4 r13) {
        return FlowKt__ZipKt.c(r10, r11, r12, r13);
    }

    public static final Flow k(Flow r10) {
        return q.d(r10);
    }

    public static final Object l(Flow r10, Continuation r11) {
        return FlowKt__CountKt.a(r10, r11);
    }

    public static final Object m(Flow r10, Function2 r11, Continuation r12) {
        return FlowKt__CountKt.b(r10, r11, r12);
    }

    public static final Flow n(Flow r10) {
        return FlowKt__DistinctKt.a(r10);
    }

    public static final Flow o(Flow r10, Function1 r11) {
        return FlowKt__DistinctKt.b(r10, r11);
    }

    public static final Flow p(Flow r10, Function2 r11) {
        return FlowKt__LimitKt.c(r10, r11);
    }

    public static final Object q(FlowCollector r10, ReceiveChannel r11, Continuation r12) {
        return FlowKt__ChannelsKt.b(r10, r11, r12);
    }

    public static final Object r(FlowCollector r10, Flow r11, Continuation r12) {
        return FlowKt__CollectKt.c(r10, r11, r12);
    }

    public static final void s(FlowCollector r10) {
        FlowKt__EmittersKt.b(r10);
    }

    public static final Flow t(Flow r10) {
        return FlowKt__TransformKt.a(r10);
    }

    public static final Object u(Flow r10, Continuation r11) {
        return FlowKt__ReduceKt.a(r10, r11);
    }

    public static final Object v(Flow r10, Function2 r11, Continuation r12) {
        return FlowKt__ReduceKt.b(r10, r11, r12);
    }

    public static final Object w(Flow r10, Continuation r11) {
        return FlowKt__ReduceKt.c(r10, r11);
    }

    public static final Object x(Flow r10, Function2 r11, Continuation r12) {
        return FlowKt__ReduceKt.d(r10, r11, r12);
    }

    public static final ReceiveChannel y(CoroutineScope r10, long r11, long r12) {
        return FlowKt__DelayKt.a(r10, r11, r12);
    }

    public static /* synthetic */ ReceiveChannel z(CoroutineScope r10, long r11, long r12, int r13, Object r14) {
        return FlowKt__DelayKt.b(r10, r11, r12, r13, r14);
    }
}
