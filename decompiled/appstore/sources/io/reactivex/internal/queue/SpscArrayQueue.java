package io.reactivex.internal.queue;

import io.reactivex.annotations.Nullable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.f;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes4.dex */
public final class SpscArrayQueue<E> extends AtomicReferenceArray<E> implements SimplePlainQueue<E> {
    private static final Integer MAX_LOOK_AHEAD_STEP = null;
    private static final long serialVersionUID = -1296597691183856449L;
    final AtomicLong consumerIndex;
    final int lookAheadStep;
    final int mask;
    final AtomicLong producerIndex;
    long producerLookAhead;

    static {
        MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    }

    public SpscArrayQueue(int r10) {
        super(f.a(r10));
        this.mask = length() - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        this.lookAheadStep = Math.min(r10 / 4, MAX_LOOK_AHEAD_STEP.intValue());
    }

    public int calcElementOffset(long r10, int r11) {
        return ((int) r10) & r11;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
    L3:
        if (poll() != null) goto L3;
        if (isEmpty() == false) goto L3;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        if (this.producerIndex.get() != this.consumerIndex.get()) goto L5;
        return true;
    L5:
        return false;
    }

    public E lvElement(int r10) {
        return get(r10);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(E r10) {
        if (r10 == null) goto L15;
        int r11 = this.mask;
        long r12 = this.producerIndex.get();
        int r13 = calcElementOffset(r12, r11);
        if (r12 < this.producerLookAhead) goto L12;
        long r14 = ((long) this.lookAheadStep) + r12;
        if (lvElement(calcElementOffset(r14, r11)) != null) goto L9;
        this.producerLookAhead = r14;
        goto L12
    L9:
        if (lvElement(r13) == null) goto L12;
        return false;
    L12:
        soElement(r13, r10);
        soProducerIndex(r12 + 1);
        return true;
    L15:
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // io.reactivex.internal.fuseable.SimplePlainQueue, io.reactivex.internal.fuseable.SimpleQueue
    @Nullable
    public E poll() {
        long r10 = this.consumerIndex.get();
        int r11 = calcElementOffset(r10);
        E r12 = lvElement(r11);
        if (r12 != null) goto L5;
        return null;
    L5:
        soConsumerIndex(r10 + 1);
        soElement(r11, null);
        return r12;
    }

    public void soConsumerIndex(long r10) {
        this.consumerIndex.lazySet(r10);
    }

    public void soElement(int r10, E r11) {
        lazySet(r10, r11);
    }

    public void soProducerIndex(long r10) {
        this.producerIndex.lazySet(r10);
    }

    public int calcElementOffset(long r10) {
        int r11 = this.mask;
        return r11 & ((int) r10);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(E r10, E r11) {
        if (offer(r10) == true) goto L5;
    L7:
        return false;
    L5:
        if (offer(r11) == false) goto L7;
        return true;
    }
}
