package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.PerfConsts;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.TrySelectDetailedResult;

/* JADX INFO: compiled from: BroadcastChannel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u000245B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0017\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010!H\u0010¢\u0006\u0002\b\"J\u0012\u0010#\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0016J\u001e\u0010&\u001a\u00020'2\n\u0010(\u001a\u0006\u0012\u0002\b\u00030\u00132\b\u0010)\u001a\u0004\u0018\u00010\rH\u0014J\u0016\u0010*\u001a\u00020'2\f\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0002J\u0019\u0010,\u001a\u00020'2\u0006\u0010)\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010-J\b\u0010.\u001a\u00020/H\u0016J&\u00100\u001a\b\u0012\u0004\u0012\u00020'012\u0006\u0010)\u001a\u00028\u0000H\u0016ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b2\u00103R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\u0011\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0013\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0012j\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0013\u0012\u0006\u0012\u0004\u0018\u00010\r`\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\u00028\u00008F¢\u0006\f\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001c\u001a\u0004\u0018\u00018\u00008F¢\u0006\f\u0012\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001b\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00066"}, d2 = {"Lkotlinx/coroutines/channels/BroadcastChannelImpl;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/BufferedChannel;", "Lkotlinx/coroutines/channels/BroadcastChannel;", PerfConsts.KEY_CURRENT_CAPACITY, "", "(I)V", "getCapacity", "()I", "isClosedForSend", "", "()Z", "lastConflatedElement", "", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "onSendInternalResult", "Ljava/util/HashMap;", "Lkotlinx/coroutines/selects/SelectInstance;", "Lkotlin/collections/HashMap;", "subscribers", "", "value", "getValue$annotations", "()V", "getValue", "()Ljava/lang/Object;", "valueOrNull", "getValueOrNull$annotations", "getValueOrNull", "cancelImpl", "cause", "", "cancelImpl$kotlinx_coroutines_core", "close", "openSubscription", "Lkotlinx/coroutines/channels/ReceiveChannel;", "registerSelectForSend", "", "select", "element", "removeSubscriber", "s", CommonKey.KEY_SEND, "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toString", "", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "SubscriberBuffered", "SubscriberConflated", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BroadcastChannelImpl<E> extends BufferedChannel<E> implements BroadcastChannel<E> {
    private final int capacity;
    private Object lastConflatedElement;
    private final ReentrantLock lock;
    private final HashMap<SelectInstance<?>, Object> onSendInternalResult;
    private List<? extends BufferedChannel<E>> subscribers;

    /* JADX INFO: compiled from: BroadcastChannel.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/channels/BroadcastChannelImpl$SubscriberBuffered;", "Lkotlinx/coroutines/channels/BufferedChannel;", "(Lkotlinx/coroutines/channels/BroadcastChannelImpl;)V", "cancelImpl", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class SubscriberBuffered extends BufferedChannel<E> {
        final /* synthetic */ BroadcastChannelImpl<E> this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public SubscriberBuffered(BroadcastChannelImpl r3) {
            this.this$0 = r3;
            super(r3.getCapacity(), null, 2, 0 == true ? 1 : 0);
        }

        @Override // kotlinx.coroutines.channels.BufferedChannel
        public /* bridge */ /* synthetic */ boolean cancelImpl$kotlinx_coroutines_core(Throwable r1) {
            return cancelImpl(r1);
        }

        public boolean cancelImpl(Throwable r4) {
            ReentrantLock r0 = BroadcastChannelImpl.access$getLock$p(this.this$0);
            BroadcastChannelImpl<E> r1 = this.this$0;
            ReentrantLock r2 = r0;
            r2.lock();
            BroadcastChannelImpl.access$removeSubscriber(r1, this);     // Catch: Throwable -> L6
            boolean r3 = super.cancelImpl$kotlinx_coroutines_core(r4);     // Catch: Throwable -> L6
            r2.unlock();
            return r3;
        L6:
            th = move-exception;
            r2.unlock();
            throw th;
        }
    }

    /* JADX INFO: compiled from: BroadcastChannel.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/channels/BroadcastChannelImpl$SubscriberConflated;", "Lkotlinx/coroutines/channels/ConflatedBufferedChannel;", "(Lkotlinx/coroutines/channels/BroadcastChannelImpl;)V", "cancelImpl", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class SubscriberConflated extends ConflatedBufferedChannel<E> {
        final /* synthetic */ BroadcastChannelImpl<E> this$0;

        public SubscriberConflated(BroadcastChannelImpl r7) {
            this.this$0 = r7;
            super(1, BufferOverflow.DROP_OLDEST, null, 4, null);
        }

        @Override // kotlinx.coroutines.channels.BufferedChannel
        public /* bridge */ /* synthetic */ boolean cancelImpl$kotlinx_coroutines_core(Throwable r1) {
            return cancelImpl(r1);
        }

        public boolean cancelImpl(Throwable r3) {
            BroadcastChannelImpl.access$removeSubscriber(this.this$0, this);
            return super.cancelImpl$kotlinx_coroutines_core(r3);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.BroadcastChannelImpl$registerSelectForSend$2, reason: invalid class name */
    /* JADX INFO: compiled from: BroadcastChannel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.BroadcastChannelImpl$registerSelectForSend$2", f = "BroadcastChannel.kt", i = {}, l = {291}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Object $element;
        final /* synthetic */ SelectInstance<?> $select;
        int label;
        final /* synthetic */ BroadcastChannelImpl<E> this$0;

        AnonymousClass2(BroadcastChannelImpl<E> r1, Object r2, SelectInstance<?> r3, Continuation<? super AnonymousClass2> r4) {
            this.this$0 = r1;
            this.$element = r2;
            this.$select = r3;
            super(2, r4);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.this$0, this.$element, this.$select, r4);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass2) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r2 = false;
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L7
        L15:
            boolean r7 = true;
        L23:
            ReentrantLock r3 = BroadcastChannelImpl.access$getLock$p(this.this$0);
            BroadcastChannelImpl<E> r4 = this.this$0;
            SelectInstance<?> r5 = this.$select;
            ReentrantLock r8 = r3;
            r8.lock();
        L43:
            th = move-exception;
            r8.unlock();
            throw th;
        L25:
            if (DebugKt.getASSERTIONS_ENABLED() == true) goto L27;
        L33:
            HashMap r9 = BroadcastChannelImpl.access$getOnSendInternalResult$p(r4);     // Catch: Throwable -> L43
            if (r7 == false) goto L36;
            Object r10 = Unit.INSTANCE;     // Catch: Throwable -> L43
        L37:
            r9.put(r5, r10);     // Catch: Throwable -> L43
            Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");     // Catch: Throwable -> L43
            SelectImplementation r11 = (SelectImplementation) r5;     // Catch: Throwable -> L43
            if (((SelectImplementation) r5).trySelectDetailed(r4, Unit.INSTANCE) == TrySelectDetailedResult.REREGISTER) goto L40;
            BroadcastChannelImpl.access$getOnSendInternalResult$p(r4).remove(r5);     // Catch: Throwable -> L43
        L40:
            Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L43
            r8.unlock();
            return Unit.INSTANCE;
        L36:
            r10 = BufferedChannelKt.getCHANNEL_CLOSED();     // Catch: Throwable -> L43
            goto L37
        L27:
            if (BroadcastChannelImpl.access$getOnSendInternalResult$p(r4).get(r5) != null) goto L29;
            r2 = true;
        L29:
            if (r2 == true) goto L33;
            throw new AssertionError();     // Catch: Throwable -> L43
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r6);
            BroadcastChannelImpl<E> r13 = this.this$0;     // Catch: Throwable -> L7
            Object r14 = this.$element;     // Catch: Throwable -> L7
            this.label = 1;     // Catch: Throwable -> L7
            if (r13.send((E) r14, this) != r0) goto L15;
            return r0;
        L7:
            th = move-exception;
            if (this.this$0.isClosedForSend() == true) goto L19;
        L46:
            throw th;
        L19:
            if ((th instanceof ClosedSendChannelException) == false) goto L21;
        L22:
            r7 = false;
            goto L23
        L21:
            if (this.this$0.getSendException() != th) goto L46;
            goto L22
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.BroadcastChannelImpl$send$1, reason: invalid class name */
    /* JADX INFO: compiled from: BroadcastChannel.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.BroadcastChannelImpl", f = "BroadcastChannel.kt", i = {0, 0}, l = {230}, m = CommonKey.KEY_SEND, n = {"this", "element"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ BroadcastChannelImpl<E> this$0;

        AnonymousClass1(BroadcastChannelImpl<E> r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.send(null, this);
        }
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    public static /* synthetic */ void getValueOrNull$annotations() {
    }

    public static final /* synthetic */ ReentrantLock access$getLock$p(BroadcastChannelImpl r0) {
        return r0.lock;
    }

    public static final /* synthetic */ HashMap access$getOnSendInternalResult$p(BroadcastChannelImpl r0) {
        return r0.onSendInternalResult;
    }

    public static final /* synthetic */ void access$removeSubscriber(BroadcastChannelImpl r0, ReceiveChannel r1) {
        r0.removeSubscriber(r1);
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public BroadcastChannelImpl(int r4) {
        boolean r1 = false;
        super(0, null);
        this.capacity = r4;
        if (r4 < 1) goto L5;
    L6:
        r1 = true;
    L7:
        if (r1 == false) goto L11;
        this.lock = new ReentrantLock();
        this.subscribers = CollectionsKt.emptyList();
        this.lastConflatedElement = BroadcastChannelKt.access$getNO_ELEMENT$p();
        this.onSendInternalResult = new HashMap();
        return;
    L11:
        throw new IllegalArgumentException(("BroadcastChannel capacity must be positive or Channel.CONFLATED, but " + r4 + " was specified").toString());
    L5:
        if (r4 != (-1)) goto L7;
        goto L6
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public ReceiveChannel<E> openSubscription() {
        ReentrantLock r0 = this.lock;
        r0.lock();
    L21:
        th = move-exception;
        r0.unlock();
        throw th;
    L4:
        if (this.capacity != (-1)) goto L7;
        BufferedChannel r1 = new SubscriberConflated(this);     // Catch: Throwable -> L21
    L6:
        BufferedChannel r2 = r1;     // Catch: Throwable -> L21
        if (isClosedForSend() == false) goto L16;
        if (this.lastConflatedElement != BroadcastChannelKt.access$getNO_ELEMENT$p()) goto L16;
        r2.close(getCloseCause());     // Catch: Throwable -> L21
        BufferedChannel r3 = r2;     // Catch: Throwable -> L21
        r0.unlock();
        return r3;
    L16:
        if (this.lastConflatedElement == BroadcastChannelKt.access$getNO_ELEMENT$p()) goto L18;
        r2.mo2321trySendJP2dKIU(getValue());     // Catch: Throwable -> L21
    L18:
        this.subscribers = CollectionsKt.plus(this.subscribers, r2);     // Catch: Throwable -> L21
        r0.unlock();
        return r2;
    L7:
        r1 = new SubscriberBuffered(this);     // Catch: Throwable -> L21
        goto L6
    }

    private final void removeSubscriber(ReceiveChannel<? extends E> r6) {
        ReentrantLock r0 = this.lock;
        r0.lock();
        List<? extends BufferedChannel<E>> r1 = this.subscribers;     // Catch: Throwable -> L15
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L15
        Iterator<T> r3 = r1.iterator();     // Catch: Throwable -> L15
    L5:
        if (r3.hasNext() == false) goto L12;
        BufferedChannel r4 = (Object) r3.next();
        if (r4 == r6) goto L9;
        boolean r5 = true;
    L10:
        if (r5 == false) goto L5;
        r2.add(r4);     // Catch: Throwable -> L15
        goto L5
    L9:
        r5 = false;
        goto L10
    L12:
        this.subscribers = r2;     // Catch: Throwable -> L15
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r0.unlock();
        return;
    L15:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0082 -> B:12:0x0036). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    public Object send(E r7, Continuation<? super Unit> r8) {
        if ((r8 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r8;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L15;
        if (r2 != 1) goto L14;
        Iterator r6 = (Iterator) r0.L$2;
        Object r10 = r0.L$1;
        BroadcastChannelImpl<E> r3 = (BroadcastChannelImpl) r0.L$0;
        ResultKt.throwOnFailure(r9);
        AnonymousClass1 r5 = r0;
        Object r4 = r10;
        BroadcastChannelImpl<E> r11 = r3;
    L12:
        Object r12 = r1;
        AnonymousClass1 r13 = r5;
        if (((Boolean) r9).booleanValue() == false) goto L32;
    L36:
        Object r14 = r4;
        r0 = r13;
        r1 = r12;
    L24:
        if (r6.hasNext() == false) goto L38;
        BufferedChannel r15 = (BufferedChannel) r6.next();
        r0.L$0 = r11;
        r0.L$1 = r14;
        r0.L$2 = r6;
        r0.label = 1;
        Object r16 = r15.sendBroadcast$kotlinx_coroutines_core(r14, r0);
        if (r16 != r1) goto L28;
        return r1;
    L28:
        r5 = r0;
        r4 = r14;
        r9 = r16;
        goto L12
    L38:
        return Unit.INSTANCE;
    L32:
        if (r11.isClosedForSend() == false) goto L36;
        throw r11.getSendException();
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r9);
        ReentrantLock r17 = this.lock;
        r17.lock();
    L41:
        th = move-exception;
        r17.unlock();
        throw th;
    L17:
        if (isClosedForSend() == true) goto L40;
        if (this.capacity != (-1)) goto L21;
        this.lastConflatedElement = r7;     // Catch: Throwable -> L41
    L21:
        List<? extends BufferedChannel<E>> r18 = this.subscribers;     // Catch: Throwable -> L41
        r17.unlock();
        r11 = this;
        r6 = r18.iterator();
        r14 = r7;
        goto L24
    L40:
        throw getSendException();     // Catch: Throwable -> L41
    L7:
        r0 = new AnonymousClass1(this, r8);
        goto L8
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: trySend-JP2dKIU, reason: not valid java name */
    public Object mo2321trySendJP2dKIU(E r5) {
        ReentrantLock r0 = this.lock;
        r0.lock();
    L33:
        th = move-exception;
        r0.unlock();
        throw th;
    L4:
        if (isClosedForSend() == false) goto L8;
        Object r4 = super.mo2321trySendJP2dKIU(r5);     // Catch: Throwable -> L33
        r0.unlock();
        return r4;
    L8:
        List<? extends BufferedChannel<E>> r1 = this.subscribers;     // Catch: Throwable -> L33
        boolean r3 = false;
        if ((r1 instanceof Collection) == true) goto L11;
    L13:
        Iterator<T> r2 = r1.iterator();     // Catch: Throwable -> L33
    L15:
        if (r2.hasNext() == false) goto L19;
        if (((BufferedChannel) r2.next()).shouldSendSuspend$kotlinx_coroutines_core() == false) goto L15;
        r3 = true;
    L19:
        if (r3 == false) goto L24;
        Object r6 = ChannelResult.Companion.m2345failurePtdJZtk();     // Catch: Throwable -> L33
        r0.unlock();
        return r6;
    L24:
        if (this.capacity != (-1)) goto L26;
        this.lastConflatedElement = r5;     // Catch: Throwable -> L33
    L26:
        Iterator<T> r7 = this.subscribers.iterator();     // Catch: Throwable -> L33
    L28:
        if (r7.hasNext() == false) goto L30;
        ((BufferedChannel) r7.next()).mo2321trySendJP2dKIU(r5);     // Catch: Throwable -> L33
        goto L28
    L30:
        Object r8 = ChannelResult.Companion.m2346successJP2dKIU(Unit.INSTANCE);     // Catch: Throwable -> L33
        r0.unlock();
        return r8;
    L11:
        if (r1.isEmpty() == false) goto L13;
        goto L13
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    protected void registerSelectForSend(SelectInstance<?> r8, Object r9) {
        ReentrantLock r0 = this.lock;
        r0.lock();
        Object r1 = this.onSendInternalResult.remove(r8);     // Catch: Throwable -> L11
        if (r1 == null) goto L8;
        r8.selectInRegistrationPhase(r1);     // Catch: Throwable -> L11
        r0.unlock();
        return;
    L8:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L11
        r0.unlock();
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(r8.getContext()), null, CoroutineStart.UNDISPATCHED, new AnonymousClass2(this, r9, r8, null), 1, null);
        return;
    L11:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable r6) {
        ReentrantLock r0 = this.lock;
        r0.lock();
        Iterator<T> r1 = this.subscribers.iterator();     // Catch: Throwable -> L16
    L5:
        if (r1.hasNext() == false) goto L7;
        ((BufferedChannel) r1.next()).close(r6);     // Catch: Throwable -> L16
        goto L5
    L7:
        List<? extends BufferedChannel<E>> r2 = this.subscribers;     // Catch: Throwable -> L16
        ArrayList r3 = new ArrayList();     // Catch: Throwable -> L16
        Iterator<T> r4 = r2.iterator();     // Catch: Throwable -> L16
    L9:
        if (r4.hasNext() == false) goto L13;
        BufferedChannel r5 = (Object) r4.next();
        if (r5.hasElements$kotlinx_coroutines_core() == false) goto L9;
        r3.add(r5);     // Catch: Throwable -> L16
        goto L9
    L13:
        this.subscribers = r3;     // Catch: Throwable -> L16
        boolean r7 = super.close(r6);     // Catch: Throwable -> L16
        r0.unlock();
        return r7;
    L16:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public boolean cancelImpl$kotlinx_coroutines_core(Throwable r4) {
        ReentrantLock r0 = this.lock;
        r0.lock();
        Iterator<T> r1 = this.subscribers.iterator();     // Catch: Throwable -> L10
    L5:
        if (r1.hasNext() == false) goto L7;
        ((BufferedChannel) r1.next()).cancelImpl$kotlinx_coroutines_core(r4);     // Catch: Throwable -> L10
        goto L5
    L7:
        this.lastConflatedElement = BroadcastChannelKt.access$getNO_ELEMENT$p();     // Catch: Throwable -> L10
        boolean r3 = super.cancelImpl$kotlinx_coroutines_core(r4);     // Catch: Throwable -> L10
        r0.unlock();
        return r3;
    L10:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        ReentrantLock r0 = this.lock;
        r0.lock();
        boolean r1 = super.isClosedForSend();     // Catch: Throwable -> L6
        r0.unlock();
        return r1;
    L6:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    public final E getValue() {
        ReentrantLock r0 = this.lock;
        r0.lock();
    L16:
        th = move-exception;
        r0.unlock();
        throw th;
    L4:
        if (isClosedForSend() == false) goto L10;
        Throwable r3 = getCloseCause();     // Catch: Throwable -> L16
        if (r3 == null) goto L8;
        throw r3;     // Catch: Throwable -> L16
    L8:
        throw new IllegalStateException("This broadcast channel is closed");     // Catch: Throwable -> L16
    L10:
        if (this.lastConflatedElement == BroadcastChannelKt.access$getNO_ELEMENT$p()) goto L15;
        E r4 = (E) this.lastConflatedElement;
        r0.unlock();
        return r4;
    L15:
        throw new IllegalStateException("No value".toString());     // Catch: Throwable -> L16
    }

    public final E getValueOrNull() {
        ReentrantLock r0 = this.lock;
        r0.lock();
        E r2 = null;
        if (isClosedForReceive() == false) goto L7;
    L10:
        r0.unlock();
        return r2;
    L7:
        if (this.lastConflatedElement == BroadcastChannelKt.access$getNO_ELEMENT$p()) goto L10;
        r2 = (E) this.lastConflatedElement;
    L12:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.lastConflatedElement == BroadcastChannelKt.access$getNO_ELEMENT$p()) goto L5;
        String r1 = "CONFLATED_ELEMENT=" + this.lastConflatedElement + "; ";
    L7:
        return r0.append(r1).append("BROADCAST=<").append(super.toString()).append(">; SUBSCRIBERS=").append(CollectionsKt.joinToString$default(this.subscribers, ";", "<", ">", 0, null, null, 56, null)).toString();
    L5:
        r1 = "";
        goto L7
    }
}
