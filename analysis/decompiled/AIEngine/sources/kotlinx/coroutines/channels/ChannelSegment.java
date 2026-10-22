package kotlinx.coroutines.channels;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.internal.Segment;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ChannelSegment<E> extends Segment<ChannelSegment<E>> {
    private final BufferedChannel<E> _channel;
    private final /* synthetic */ AtomicReferenceArray data;

    public ChannelSegment(long j10, ChannelSegment<E> channelSegment, BufferedChannel<E> bufferedChannel, int i10) {
        super(j10, channelSegment, i10);
        this._channel = bufferedChannel;
        this.data = new AtomicReferenceArray(BufferedChannelKt.SEGMENT_SIZE * 2);
    }

    private final /* synthetic */ AtomicReferenceArray getData() {
        return this.data;
    }

    private final void setElementLazy(int i10, Object obj) {
        getData().set(i10 * 2, obj);
    }

    public final boolean casState$kotlinx_coroutines_core(int i10, Object obj, Object obj2) {
        AtomicReferenceArray data = getData();
        int i11 = (i10 * 2) + 1;
        while (!data.compareAndSet(i11, obj, obj2)) {
            if (data.get(i11) != obj) {
                return false;
            }
        }
        return true;
    }

    public final void cleanElement$kotlinx_coroutines_core(int i10) {
        setElementLazy(i10, null);
    }

    public final Object getAndSetState$kotlinx_coroutines_core(int i10, Object obj) {
        return getData().getAndSet((i10 * 2) + 1, obj);
    }

    public final BufferedChannel<E> getChannel() {
        BufferedChannel<E> bufferedChannel = this._channel;
        g.c(bufferedChannel);
        return bufferedChannel;
    }

    public final E getElement$kotlinx_coroutines_core(int i10) {
        return (E) getData().get(i10 * 2);
    }

    @Override // kotlinx.coroutines.internal.Segment
    public int getNumberOfSlots() {
        return BufferedChannelKt.SEGMENT_SIZE;
    }

    public final Object getState$kotlinx_coroutines_core(int i10) {
        return getData().get((i10 * 2) + 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x005f, code lost:
    
        cleanElement$kotlinx_coroutines_core(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0062, code lost:
    
        if (r0 == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0064, code lost:
    
        r3 = getChannel().onUndeliveredElement;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006a, code lost:
    
        if (r3 == null) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006c, code lost:
    
        kotlinx.coroutines.internal.OnUndeliveredElementKt.callUndeliveredElement(r3, r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x006f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:?, code lost:
    
        return;
     */
    @Override // kotlinx.coroutines.internal.Segment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onCancellation(int r4, java.lang.Throwable r5, kotlin.coroutines.d r6) {
        /*
            r3 = this;
            int r5 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            if (r4 < r5) goto L6
            r0 = 1
            goto L7
        L6:
            r0 = 0
        L7:
            if (r0 == 0) goto La
            int r4 = r4 - r5
        La:
            java.lang.Object r5 = r3.getElement$kotlinx_coroutines_core(r4)
        Le:
            java.lang.Object r1 = r3.getState$kotlinx_coroutines_core(r4)
            boolean r2 = r1 instanceof kotlinx.coroutines.Waiter
            if (r2 != 0) goto L70
            boolean r2 = r1 instanceof kotlinx.coroutines.channels.WaiterEB
            if (r2 == 0) goto L1b
            goto L70
        L1b:
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.access$getINTERRUPTED_SEND$p()
            if (r1 == r2) goto L5f
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.access$getINTERRUPTED_RCV$p()
            if (r1 != r2) goto L28
            goto L5f
        L28:
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.access$getRESUMING_BY_EB$p()
            if (r1 == r2) goto Le
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.access$getRESUMING_BY_RCV$p()
            if (r1 != r2) goto L35
            goto Le
        L35:
            kotlinx.coroutines.internal.Symbol r3 = kotlinx.coroutines.channels.BufferedChannelKt.access$getDONE_RCV$p()
            if (r1 == r3) goto L96
            kotlinx.coroutines.internal.Symbol r3 = kotlinx.coroutines.channels.BufferedChannelKt.BUFFERED
            if (r1 != r3) goto L40
            goto L96
        L40:
            kotlinx.coroutines.internal.Symbol r3 = kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED()
            if (r1 != r3) goto L47
            goto L96
        L47:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "unexpected state: "
            r4.<init>(r5)
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        L5f:
            r3.cleanElement$kotlinx_coroutines_core(r4)
            if (r0 == 0) goto L96
            kotlinx.coroutines.channels.BufferedChannel r3 = r3.getChannel()
            zb.l<E, lb.n> r3 = r3.onUndeliveredElement
            if (r3 == 0) goto L96
            kotlinx.coroutines.internal.OnUndeliveredElementKt.callUndeliveredElement(r3, r5, r6)
            return
        L70:
            if (r0 == 0) goto L77
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.access$getINTERRUPTED_SEND$p()
            goto L7b
        L77:
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.access$getINTERRUPTED_RCV$p()
        L7b:
            boolean r1 = r3.casState$kotlinx_coroutines_core(r4, r1, r2)
            if (r1 == 0) goto Le
            r3.cleanElement$kotlinx_coroutines_core(r4)
            r1 = r0 ^ 1
            r3.onCancelledRequest(r4, r1)
            if (r0 == 0) goto L96
            kotlinx.coroutines.channels.BufferedChannel r3 = r3.getChannel()
            zb.l<E, lb.n> r3 = r3.onUndeliveredElement
            if (r3 == 0) goto L96
            kotlinx.coroutines.internal.OnUndeliveredElementKt.callUndeliveredElement(r3, r5, r6)
        L96:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelSegment.onCancellation(int, java.lang.Throwable, kotlin.coroutines.d):void");
    }

    public final void onCancelledRequest(int i10, boolean z) {
        if (z) {
            getChannel().waitExpandBufferCompletion$kotlinx_coroutines_core((this.f10114id * BufferedChannelKt.SEGMENT_SIZE) + i10);
        }
        onSlotCleaned();
    }

    public final E retrieveElement$kotlinx_coroutines_core(int i10) {
        E element$kotlinx_coroutines_core = getElement$kotlinx_coroutines_core(i10);
        cleanElement$kotlinx_coroutines_core(i10);
        return element$kotlinx_coroutines_core;
    }

    public final void setState$kotlinx_coroutines_core(int i10, Object obj) {
        getData().set((i10 * 2) + 1, obj);
    }

    public final void storeElement$kotlinx_coroutines_core(int i10, E e10) {
        setElementLazy(i10, e10);
    }
}
