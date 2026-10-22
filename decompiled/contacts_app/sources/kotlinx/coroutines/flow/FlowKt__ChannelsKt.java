package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChannelFlowKt;

/* JADX INFO: compiled from: Channels.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\u001a\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005\u001a/\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a9\u0010\u000b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a$\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0012\u001a\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"asFlow", "Lkotlinx/coroutines/flow/Flow;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/channels/BroadcastChannel;", "consumeAsFlow", "Lkotlinx/coroutines/channels/ReceiveChannel;", "emitAll", "", "Lkotlinx/coroutines/flow/FlowCollector;", "channel", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitAllImpl", "consume", "", "emitAllImpl$FlowKt__ChannelsKt", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "produceIn", "scope", "Lkotlinx/coroutines/CoroutineScope;", "receiveAsFlow", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class FlowKt__ChannelsKt {
    public static final /* synthetic */ Object access$emitAllImpl$FlowKt__ChannelsKt(FlowCollector r0, ReceiveChannel r1, boolean r2, Continuation r3) {
        return emitAllImpl$FlowKt__ChannelsKt(r0, r1, r2, r3);
    }

    public static final <T> Object emitAll(FlowCollector<? super T> r1, ReceiveChannel<? extends T> r2, Continuation<? super Unit> r3) {
        Object r4 = emitAllImpl$FlowKt__ChannelsKt(r1, r2, true, r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0090 -> B:14:0x003a). Please report as a decompilation issue!!! */
    private static final <T> Object emitAllImpl$FlowKt__ChannelsKt(FlowCollector<? super T> r6, ReceiveChannel<? extends T> r7, boolean r8, Continuation<? super Unit> r9) {
        if ((r9 instanceof FlowKt__ChannelsKt$emitAllImpl$1) == false) goto L7;
        FlowKt__ChannelsKt$emitAllImpl$1 r0 = (FlowKt__ChannelsKt$emitAllImpl$1) r9;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L20;
        if (r2 == 1) goto L17;
        if (r2 != 2) goto L16;
        r8 = r0.Z$0;
        ChannelIterator<? extends T> r11 = (ChannelIterator) r0.L$2;
        r7 = (ReceiveChannel) r0.L$1;
        FlowCollector<? super T> r3 = (FlowCollector) r0.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L35
    L14:
        ChannelIterator<? extends T> r12 = r11;
        r6 = r3;
    L22:
        r0.L$0 = r6;     // Catch: Throwable -> L35
        r0.L$1 = r7;     // Catch: Throwable -> L35
        r0.L$2 = r12;     // Catch: Throwable -> L35
        r0.Z$0 = r8;     // Catch: Throwable -> L35
        r0.label = 1;     // Catch: Throwable -> L35
        Object r4 = r12.hasNext(r0);     // Catch: Throwable -> L35
        if (r4 != r1) goto L25;
        return r1;
    L25:
        r3 = r6;
        r11 = r12;
        r10 = r4;
    L27:
        if (((Boolean) r10).booleanValue() == false) goto L31;
        T r13 = r11.next();     // Catch: Throwable -> L35
        r0.L$0 = r3;     // Catch: Throwable -> L35
        r0.L$1 = r7;     // Catch: Throwable -> L35
        r0.L$2 = r11;     // Catch: Throwable -> L35
        r0.Z$0 = r8;     // Catch: Throwable -> L35
        r0.label = 2;     // Catch: Throwable -> L35
        if (r3.emit(r13, r0) != r1) goto L14;
        return r1;
    L31:
        if (r8 == false) goto L34;
        ChannelsKt.cancelConsumed(r7, null);
    L34:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r8 = r0.Z$0;
        r11 = (ChannelIterator) r0.L$2;
        r7 = (ReceiveChannel) r0.L$1;
        r3 = (FlowCollector) r0.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L35
        goto L27
    L20:
        ResultKt.throwOnFailure(r10);
        FlowKt.ensureActive(r6);
        r12 = r7.iterator();     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        if (r8 == false) goto L40;
        ChannelsKt.cancelConsumed(r7, th);
    L40:
        throw th;
    L7:
        r0 = new FlowKt__ChannelsKt$emitAllImpl$1(r9);
        goto L8
    }

    public static final <T> Flow<T> receiveAsFlow(ReceiveChannel<? extends T> r9) {
        return new ChannelAsFlow(r9, false, null, 0, null, 28, null);
    }

    public static final <T> Flow<T> consumeAsFlow(ReceiveChannel<? extends T> r9) {
        return new ChannelAsFlow(r9, true, null, 0, null, 28, null);
    }

    public static final <T> ReceiveChannel<T> produceIn(Flow<? extends T> r0, CoroutineScope r1) {
        return ChannelFlowKt.asChannelFlow(r0).produceImpl(r1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "'BroadcastChannel' is obsolete and all corresponding operators are deprecated in the favour of StateFlow and SharedFlow")
    public static final <T> Flow<T> asFlow(final BroadcastChannel<T> r1) {
        return new FlowKt__ChannelsKt$asFlow$$inlined$unsafeFlow$1(r1);
    }
}
