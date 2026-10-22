package io.reactivex.internal.operators.flowable;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableSampleTimed$SampleTimedEmitLast<T> extends FlowableSampleTimed$SampleTimedSubscriber<T> {
    private static final long serialVersionUID = -7139995637533111443L;
    final AtomicInteger wip;

    public FlowableSampleTimed$SampleTimedEmitLast(Subscriber<? super T> r10, long r11, TimeUnit r12, mf.f r13) {
        super(r10, r11, r12, r13);
        this.wip = new AtomicInteger(1);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableSampleTimed$SampleTimedSubscriber
    public void complete() {
        emit();
        if (this.wip.decrementAndGet() != 0) goto L6;
        this.downstream.onComplete();
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.wip.incrementAndGet() != 2) goto L8;
        emit();
        if (this.wip.decrementAndGet() != 0) goto L9;
        this.downstream.onComplete();
        return;
    L9:
        return;
    }
}
