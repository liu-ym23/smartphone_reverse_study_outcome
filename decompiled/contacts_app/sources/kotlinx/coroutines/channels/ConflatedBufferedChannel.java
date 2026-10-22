package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.PerfConsts;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectInstance;

/* JADX INFO: compiled from: ConflatedBufferedChannel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\"\b\u0002\u0010\u0007\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\n¢\u0006\u0002\u0010\u000bJ\u001e\u0010\u000f\u001a\u00020\t2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u0019\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u001b\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00028\u0000H\u0090@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0015J\r\u0010\u0018\u001a\u00020\rH\u0010¢\u0006\u0002\b\u0019J&\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u001b2\u0006\u0010\u0012\u001a\u00028\u0000H\u0016ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ.\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u001b2\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\rH\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b \u0010!J&\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\u001b2\u0006\u0010\u0012\u001a\u00028\u0000H\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b#\u0010\u001dJ.\u0010$\u001a\b\u0012\u0004\u0012\u00020\t0\u001b2\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\rH\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b%\u0010!R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006&"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBufferedChannel;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/BufferedChannel;", PerfConsts.KEY_CURRENT_CAPACITY, "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(ILkotlinx/coroutines/channels/BufferOverflow;Lkotlin/jvm/functions/Function1;)V", "isConflatedDropOldest", "", "()Z", "registerSelectForSend", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "element", "", CommonKey.KEY_SEND, "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendBroadcast", "sendBroadcast$kotlinx_coroutines_core", "shouldSendSuspend", "shouldSendSuspend$kotlinx_coroutines_core", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySendDropLatest", "isSendOp", "trySendDropLatest-Mj0NB7M", "(Ljava/lang/Object;Z)Ljava/lang/Object;", "trySendDropOldest", "trySendDropOldest-JP2dKIU", "trySendImpl", "trySendImpl-Mj0NB7M", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class ConflatedBufferedChannel<E> extends BufferedChannel<E> {
    private final int capacity;
    private final BufferOverflow onBufferOverflow;

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    public Object send(E r1, Continuation<? super Unit> r2) {
        return send$suspendImpl(this, r1, r2);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public Object sendBroadcast$kotlinx_coroutines_core(E r1, Continuation<? super Boolean> r2) {
        return sendBroadcast$suspendImpl(this, r1, r2);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public boolean shouldSendSuspend$kotlinx_coroutines_core() {
        return false;
    }

    public /* synthetic */ ConflatedBufferedChannel(int r1, BufferOverflow r2, Function1 r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }

    public ConflatedBufferedChannel(int r2, BufferOverflow r3, Function1<? super E, Unit> r4) {
        super(r2, r4);
        this.capacity = r2;
        this.onBufferOverflow = r3;
        boolean r5 = false;
        if (r3 == BufferOverflow.SUSPEND) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L14;
        if (r2 < 1) goto L9;
        r5 = true;
    L9:
        if (r5 == false) goto L12;
        return;
    L12:
        throw new IllegalArgumentException(("Buffered channel capacity must be at least 1, but " + r2 + " was specified").toString());
    L14:
        throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + Reflection.getOrCreateKotlinClass(BufferedChannel.class).getSimpleName() + " instead").toString());
    L5:
        r1 = false;
        goto L6
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    protected boolean isConflatedDropOldest() {
        if (this.onBufferOverflow != BufferOverflow.DROP_OLDEST) goto L5;
        return true;
    L5:
        return false;
    }

    static /* synthetic */ <E> Object send$suspendImpl(ConflatedBufferedChannel<E> r2, E r3, Continuation<? super Unit> r4) {
        Object r5 = r2.m2349trySendImplMj0NB7M(r3, true);
        if ((r5 instanceof ChannelResult.Closed) == false) goto L13;
        ChannelResult.m2335exceptionOrNullimpl(r5);
        Function1<E, Unit> r6 = r2.onUndeliveredElement;
        if (r6 == null) goto L11;
        UndeliveredElementException r7 = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(r6, r3, null, 2, null);
        if (r7 == null) goto L11;
        ExceptionsKt.addSuppressed(r7, r2.getSendException());
        throw r7;
    L11:
        throw r2.getSendException();
    L13:
        return Unit.INSTANCE;
    }

    static /* synthetic */ <E> Object sendBroadcast$suspendImpl(ConflatedBufferedChannel<E> r0, E r1, Continuation<? super Boolean> r2) {
        Object r3 = r0.m2349trySendImplMj0NB7M(r1, true);
        if ((r3 instanceof ChannelResult.Failed) == true) goto L7;
        Unit r4 = (Unit) r3;
        return Boxing.boxBoolean(true);
    L7:
        return Boxing.boxBoolean(false);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public Object mo2321trySendJP2dKIU(E r2) {
        return m2349trySendImplMj0NB7M(r2, false);
    }

    /* JADX INFO: renamed from: trySendImpl-Mj0NB7M, reason: not valid java name */
    private final Object m2349trySendImplMj0NB7M(E r3, boolean r4) {
        if (this.onBufferOverflow != BufferOverflow.DROP_LATEST) goto L6;
        return m2347trySendDropLatestMj0NB7M(r3, r4);
    L6:
        return m2348trySendDropOldestJP2dKIU(r3);
    }

    /* JADX INFO: renamed from: trySendDropLatest-Mj0NB7M, reason: not valid java name */
    private final Object m2347trySendDropLatestMj0NB7M(E r3, boolean r4) {
        Object r0 = super.mo2321trySendJP2dKIU(r3);
        if (ChannelResult.m2341isSuccessimpl(r0) == false) goto L5;
    L16:
        return r0;
    L5:
        if (ChannelResult.m2339isClosedimpl(r0) == true) goto L16;
        if (r4 == false) goto L15;
        Function1<E, Unit> r2 = this.onUndeliveredElement;
        if (r2 == null) goto L15;
        UndeliveredElementException r5 = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(r2, r3, null, 2, null);
        if (r5 == null) goto L15;
        throw r5;
    L15:
        return ChannelResult.Companion.m2346successJP2dKIU(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: trySendDropOldest-JP2dKIU, reason: not valid java name */
    private final Object m2348trySendDropOldestJP2dKIU(E r17) {
        Object r9 = BufferedChannelKt.BUFFERED;
        ConflatedBufferedChannel<E> r10 = this;
        ChannelSegment r1 = (ChannelSegment) BufferedChannel.access$getSendSegment$FU$p().get(r10);
    L3:
        long r2 = BufferedChannel.access$getSendersAndCloseStatus$FU$p().getAndIncrement(r10);
        long r11 = r2 & 1152921504606846975L;
        boolean r13 = BufferedChannel.access$isClosedForSend0(r10, r2);
        long r3 = r11 / ((long) BufferedChannelKt.SEGMENT_SIZE);
        int r14 = (int) (r11 % ((long) BufferedChannelKt.SEGMENT_SIZE));
        if (r1.id == r3) goto L11;
        ChannelSegment r4 = BufferedChannel.access$findSegmentSend(r10, r3, r1);
        if (r4 == null) goto L7;
        ChannelSegment r15 = r4;
    L12:
        int r5 = BufferedChannel.access$updateCellSend(r10, r15, r14, r17, r11, r9, r13);
        if (r5 == 0) goto L47;
        if (r5 == 1) goto L46;
        if (r5 == 2) goto L34;
        if (r5 == 3) goto L33;
        if (r5 == 4) goto L28;
        if (r5 != 5) goto L26;
        r15.cleanPrev();
    L26:
        r1 = r15;
        goto L3
    L28:
        if (r11 >= r10.getReceiversCounter$kotlinx_coroutines_core()) goto L31;
        r15.cleanPrev();
    L31:
        return ChannelResult.Companion.m2344closedJP2dKIU(getSendException());
    L33:
        throw new IllegalStateException("unexpected".toString());
    L34:
        if (r13 == false) goto L38;
        r15.onSlotCleaned();
        return ChannelResult.Companion.m2344closedJP2dKIU(getSendException());
    L38:
        if ((r9 instanceof Waiter) == false) goto L40;
        Waiter r12 = (Waiter) r9;
    L41:
        if (r12 == null) goto L43;
        BufferedChannel.access$prepareSenderForSuspension(r10, r12, r15, r14);
    L43:
        dropFirstElementUntilTheSpecifiedCellIsInTheBuffer((r15.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) + ((long) r14));
        return ChannelResult.Companion.m2346successJP2dKIU(Unit.INSTANCE);
    L40:
        r12 = null;
        goto L41
    L46:
        return ChannelResult.Companion.m2346successJP2dKIU(Unit.INSTANCE);
    L47:
        r15.cleanPrev();
        return ChannelResult.Companion.m2346successJP2dKIU(Unit.INSTANCE);
    L7:
        if (r13 == false) goto L3;
        return ChannelResult.Companion.m2344closedJP2dKIU(getSendException());
    L11:
        r15 = r1;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.BufferedChannel
    protected void registerSelectForSend(SelectInstance<?> r1, Object r2) {
        Object r0 = mo2321trySendJP2dKIU(r2);
        if ((r0 instanceof ChannelResult.Failed) == true) goto L7;
        Unit r3 = (Unit) r0;
        r1.selectInRegistrationPhase(Unit.INSTANCE);
        return;
    L7:
        if ((r0 instanceof ChannelResult.Closed) == false) goto L11;
        ChannelResult.m2335exceptionOrNullimpl(r0);
        r1.selectInRegistrationPhase(BufferedChannelKt.getCHANNEL_CLOSED());
        return;
    L11:
        throw new IllegalStateException("unreachable".toString());
    }
}
