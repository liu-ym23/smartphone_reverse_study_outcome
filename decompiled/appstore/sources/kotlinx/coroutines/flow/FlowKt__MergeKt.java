package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import kotlinx.coroutines.flow.internal.ChannelLimitedFlowMerge;

/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class FlowKt__MergeKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f21455a = 0;

    static {
        f21455a = kotlinx.coroutines.internal.c0.b("kotlinx.coroutines.flow.defaultConcurrency", 16, 1, Channel.UNLIMITED);
    }

    public static final Flow a(Flow r10, Function2 r11) {
        return c.S(r10, new FlowKt__MergeKt$mapLatest$1(r11, null));
    }

    public static final Flow b(Iterable r10) {
        CoroutineContext r11 = null;
        int r12 = 0;
        BufferOverflow r13 = null;
        return new ChannelLimitedFlowMerge(r10, r11, r12, r13, 14, null);
    }

    public static final Flow c(Flow... r10) {
        return c.I(kotlin.collections.n.m(r10));
    }

    public static final Flow d(Flow r10, Function3 r11) {
        CoroutineContext r12 = null;
        int r13 = 0;
        BufferOverflow r14 = null;
        return new ChannelFlowTransformLatest(r11, r10, r12, r13, r14, 28, null);
    }
}
