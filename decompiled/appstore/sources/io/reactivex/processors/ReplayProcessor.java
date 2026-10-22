package io.reactivex.processors;

import io.reactivex.annotations.Nullable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ReplayProcessor extends a {

    public static final class Node<T> extends AtomicReference<Node<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final T value;

        public Node(T r10) {
            this.value = r10;
        }
    }

    public interface ReplayBuffer<T> {
        void complete();

        void error(Throwable r10);

        Throwable getError();

        @Nullable
        T getValue();

        T[] getValues(T[] r10);

        boolean isDone();

        void next(T r10);

        void replay(ReplaySubscription<T> r10);

        int size();

        void trimHead();
    }

    public static final class ReplaySubscription<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 466549804534799122L;
        volatile boolean cancelled;
        final Subscriber<? super T> downstream;
        long emitted;
        Object index;
        final AtomicLong requested;
        final ReplayProcessor state;

        public ReplaySubscription(Subscriber<? super T> r10, ReplayProcessor r11) {
            this.downstream = r10;
            this.requested = new AtomicLong();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled == false) goto L5;
            return;
        L5:
            this.cancelled = true;
            throw null;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r10) {
            if (SubscriptionHelper.validate(r10) == true) goto L5;
            return;
        L5:
            io.reactivex.internal.util.a.a(this.requested, r10);
            throw null;
        }
    }

    public static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final long time;
        final T value;

        public TimedNode(T r10, long r11) {
            this.value = r10;
            this.time = r11;
        }
    }
}
