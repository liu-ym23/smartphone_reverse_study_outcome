package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowableRange extends Flowable<Integer> {
    final int end;
    final int start;

    static abstract class BaseRangeSubscription extends BasicQueueSubscription<Integer> {
        private static final long serialVersionUID = -2252972430506210021L;
        volatile boolean cancelled;
        final int end;
        int index;

        abstract void fastPath();

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int r1) {
            return r1 & 1;
        }

        abstract void slowPath(long r1);

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public /* bridge */ /* synthetic */ Object poll() throws Exception {
            return poll();
        }

        BaseRangeSubscription(int r1, int r2) {
            this.index = r1;
            this.end = r2;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final Integer poll() {
            int r0 = this.index;
            if (r0 != this.end) goto L6;
            return null;
        L6:
            this.index = r0 + 1;
            return Integer.valueOf(r0);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            if (this.index != this.end) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            this.index = this.end;
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long r5) {
            if (SubscriptionHelper.validate(r5) == true) goto L5;
            return;
        L5:
            if (BackpressureHelper.add(this, r5) == 0) goto L7;
            return;
        L7:
            if (r5 != Long.MAX_VALUE) goto L9;
            fastPath();
            return;
        L9:
            slowPath(r5);
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.cancelled = true;
        }
    }

    static final class RangeConditionalSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        final ConditionalSubscriber<? super Integer> downstream;

        RangeConditionalSubscription(ConditionalSubscriber<? super Integer> r1, int r2, int r3) {
            super(r2, r3);
            this.downstream = r1;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        void fastPath() {
            int r0 = this.end;
            ConditionalSubscriber<? super Integer> r1 = this.downstream;
            int r2 = this.index;
        L3:
            if (r2 == r0) goto L9;
            if (this.cancelled == true) goto L6;
            r1.tryOnNext(Integer.valueOf(r2));
            r2 = r2 + 1;
            goto L3
        L6:
            return;
        L9:
            if (this.cancelled == false) goto L11;
            return;
        L11:
            r1.onComplete();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        void slowPath(long r10) {
            int r0 = this.end;
            int r1 = this.index;
            ConditionalSubscriber<? super Integer> r2 = this.downstream;
        L3:
            long r5 = 0;
        L5:
            if (r5 == r10) goto L14;
            if (r1 == r0) goto L14;
            if (this.cancelled == true) goto L9;
            if (r2.tryOnNext(Integer.valueOf(r1)) == false) goto L13;
            r5 = r5 + 1;
        L13:
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        L14:
            if (r1 == r0) goto L16;
            r10 = get();
            if (r5 != r10) goto L5;
            this.index = r1;
            r10 = addAndGet(-r5);
            if (r10 != 0) goto L3;
            return;
        L16:
            if (this.cancelled == true) goto L35;
            r2.onComplete();
            return;
        }
    }

    static final class RangeSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        final Subscriber<? super Integer> downstream;

        RangeSubscription(Subscriber<? super Integer> r1, int r2, int r3) {
            super(r2, r3);
            this.downstream = r1;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        void fastPath() {
            int r0 = this.end;
            Subscriber<? super Integer> r1 = this.downstream;
            int r2 = this.index;
        L3:
            if (r2 == r0) goto L9;
            if (this.cancelled == true) goto L6;
            r1.onNext(Integer.valueOf(r2));
            r2 = r2 + 1;
            goto L3
        L6:
            return;
        L9:
            if (this.cancelled == false) goto L11;
            return;
        L11:
            r1.onComplete();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        void slowPath(long r10) {
            int r0 = this.end;
            int r1 = this.index;
            Subscriber<? super Integer> r2 = this.downstream;
        L3:
            long r5 = 0;
        L5:
            if (r5 == r10) goto L11;
            if (r1 == r0) goto L11;
            if (this.cancelled == true) goto L9;
            r2.onNext(Integer.valueOf(r1));
            r5 = r5 + 1;
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        L11:
            if (r1 == r0) goto L13;
            r10 = get();
            if (r5 != r10) goto L5;
            this.index = r1;
            r10 = addAndGet(-r5);
            if (r10 != 0) goto L3;
            return;
        L13:
            if (this.cancelled == true) goto L32;
            r2.onComplete();
            return;
        }
    }

    public FlowableRange(int r1, int r2) {
        this.start = r1;
        this.end = r1 + r2;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Integer> r4) {
        if ((r4 instanceof ConditionalSubscriber) == false) goto L5;
        r4.onSubscribe(new RangeConditionalSubscription((ConditionalSubscriber) r4, this.start, this.end));
        return;
    L5:
        r4.onSubscribe(new RangeSubscription(r4, this.start, this.end));
    }
}
