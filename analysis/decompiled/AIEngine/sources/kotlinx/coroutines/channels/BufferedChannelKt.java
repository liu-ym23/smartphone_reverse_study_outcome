package kotlinx.coroutines.channels;

import com.stepos.core.ability.speech.TtsCloudConfig;
import ec.e;
import kotlin.coroutines.d;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.SystemPropsKt__SystemProps_commonKt;
import lb.n;
import zb.p;
import zb.q;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class BufferedChannelKt {
    private static final ChannelSegment<Object> NULL_SEGMENT = new ChannelSegment<>(-1, null, null, 0);
    public static final int SEGMENT_SIZE = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12, (Object) null);
    private static final int EXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12, (Object) null);
    public static final Symbol BUFFERED = new Symbol("BUFFERED");
    private static final Symbol IN_BUFFER = new Symbol("SHOULD_BUFFER");
    private static final Symbol RESUMING_BY_RCV = new Symbol("S_RESUMING_BY_RCV");
    private static final Symbol RESUMING_BY_EB = new Symbol("RESUMING_BY_EB");
    private static final Symbol POISONED = new Symbol("POISONED");
    private static final Symbol DONE_RCV = new Symbol("DONE_RCV");
    private static final Symbol INTERRUPTED_SEND = new Symbol("INTERRUPTED_SEND");
    private static final Symbol INTERRUPTED_RCV = new Symbol("INTERRUPTED_RCV");
    private static final Symbol CHANNEL_CLOSED = new Symbol("CHANNEL_CLOSED");
    private static final Symbol SUSPEND = new Symbol(TtsCloudConfig.DEFAULT_STREAM_BACKPRESSURE_MODE);
    private static final Symbol SUSPEND_NO_WAITER = new Symbol("SUSPEND_NO_WAITER");
    private static final Symbol FAILED = new Symbol("FAILED");
    private static final Symbol NO_RECEIVE_RESULT = new Symbol("NO_RECEIVE_RESULT");
    private static final Symbol CLOSE_HANDLER_CLOSED = new Symbol("CLOSE_HANDLER_CLOSED");
    private static final Symbol CLOSE_HANDLER_INVOKED = new Symbol("CLOSE_HANDLER_INVOKED");
    private static final Symbol NO_CLOSE_CAUSE = new Symbol("NO_CLOSE_CAUSE");

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: kotlinx.coroutines.channels.BufferedChannelKt$createSegmentFunction$1, reason: invalid class name */
    public /* synthetic */ class AnonymousClass1<E> extends FunctionReferenceImpl implements p<Long, ChannelSegment<E>, ChannelSegment<E>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2, BufferedChannelKt.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
        }

        @Override // zb.p
        public /* bridge */ /* synthetic */ Object invoke(Long l10, Object obj) {
            return invoke(l10.longValue(), (ChannelSegment) obj);
        }

        public final ChannelSegment<E> invoke(long j10, ChannelSegment<E> channelSegment) {
            return BufferedChannelKt.createSegment(j10, channelSegment);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long constructEBCompletedAndPauseFlag(long j10, boolean z) {
        return (z ? 4611686018427387904L : 0L) + j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long constructSendersAndCloseStatus(long j10, int i10) {
        return (i10 << 60) + j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <E> ChannelSegment<E> createSegment(long j10, ChannelSegment<E> channelSegment) {
        return new ChannelSegment<>(j10, channelSegment, channelSegment.getChannel(), 0);
    }

    public static final <E> e<ChannelSegment<E>> createSegmentFunction() {
        return AnonymousClass1.INSTANCE;
    }

    public static final Symbol getCHANNEL_CLOSED() {
        return CHANNEL_CLOSED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long initialBufferEnd(int i10) {
        if (i10 == 0) {
            return 0L;
        }
        if (i10 != Integer.MAX_VALUE) {
            return i10;
        }
        return Long.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> boolean tryResume0(CancellableContinuation<? super T> cancellableContinuation, T t8, q<? super Throwable, ? super T, ? super d, n> qVar) {
        Object objTryResume = cancellableContinuation.tryResume(t8, null, qVar);
        if (objTryResume == null) {
            return false;
        }
        cancellableContinuation.completeResume(objTryResume);
        return true;
    }

    public static /* synthetic */ boolean tryResume0$default(CancellableContinuation cancellableContinuation, Object obj, q qVar, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            qVar = null;
        }
        return tryResume0(cancellableContinuation, obj, qVar);
    }
}
