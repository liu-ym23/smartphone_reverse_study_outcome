package io.reactivex.processors;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BehaviorProcessor extends a {

    public static final class BehaviorSubscription<T> extends AtomicLong implements Subscription, AppendOnlyLinkedArrayList.NonThrowingPredicate<Object> {
        private static final long serialVersionUID = 3293175281126227086L;
        volatile boolean cancelled;
        final Subscriber<? super T> downstream;
        boolean emitting;
        boolean fastPath;
        long index;
        boolean next;
        AppendOnlyLinkedArrayList queue;
        final BehaviorProcessor state;

        public BehaviorSubscription(Subscriber<? super T> r10, BehaviorProcessor r11) {
            this.downstream = r10;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled == false) goto L5;
            return;
        L5:
            this.cancelled = true;
            throw null;
        }

        public void emitFirst() {
            if (this.cancelled == false) goto L5;
            return;
        L5:
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L7:
            if (this.cancelled == false) goto L13;
            monitor-exit(this);     // Catch: Throwable -> L10
            return;
        L13:
            if (this.next == false) goto L17;
            monitor-exit(this);     // Catch: Throwable -> L10
            return;
        L17:
            throw null;     // Catch: Throwable -> L10
        }

        public void emitLoop() {
        L3:
            if (this.cancelled == true) goto L4;
            monitor-enter(this);
            AppendOnlyLinkedArrayList r10 = this.queue;     // Catch: Throwable -> L11
            if (r10 == null) goto L8;
            this.queue = null;     // Catch: Throwable -> L11
            monitor-exit(this);     // Catch: Throwable -> L11
            r10.b(this);
            goto L3
        L8:
            this.emitting = false;     // Catch: Throwable -> L11
            monitor-exit(this);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }

        public void emitNext(Object r10, long r11) {
            if (this.cancelled == false) goto L6;
            return;
        L6:
            if (this.fastPath == true) goto L31;
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L9:
            if (this.cancelled == false) goto L15;
            monitor-exit(this);     // Catch: Throwable -> L12
            return;
        L15:
            if (this.index != r11) goto L19;
            monitor-exit(this);     // Catch: Throwable -> L12
            return;
        L19:
            if (this.emitting == false) goto L26;
            AppendOnlyLinkedArrayList r12 = this.queue;     // Catch: Throwable -> L12
            if (r12 != null) goto L23;
            r12 = new AppendOnlyLinkedArrayList(4);     // Catch: Throwable -> L12
            this.queue = r12;     // Catch: Throwable -> L12
        L23:
            r12.a(r10);     // Catch: Throwable -> L12
            monitor-exit(this);     // Catch: Throwable -> L12
            return;
        L26:
            this.next = true;     // Catch: Throwable -> L12
            monitor-exit(this);     // Catch: Throwable -> L12
            this.fastPath = true;
        L31:
            test(r10);
        }

        public boolean isFull() {
            if (get() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // org.reactivestreams.Subscription
        public void request(long r10) {
            if (SubscriptionHelper.validate(r10) == false) goto L6;
            io.reactivex.internal.util.a.a(this, r10);
            return;
        }

        @Override // io.reactivex.internal.util.AppendOnlyLinkedArrayList.NonThrowingPredicate, io.reactivex.functions.Predicate
        public boolean test(Object r10) {
            if (this.cancelled == false) goto L6;
            return true;
        L6:
            if (NotificationLite.isComplete(r10) == false) goto L10;
            this.downstream.onComplete();
            return true;
        L10:
            if (NotificationLite.isError(r10) == false) goto L13;
            this.downstream.onError(NotificationLite.getError(r10));
            return true;
        L13:
            long r11 = get();
            if (r11 == 0) goto L20;
            this.downstream.onNext((Object) NotificationLite.getValue(r10));
            if (r11 == Long.MAX_VALUE) goto L22;
            decrementAndGet();
            return false;
        L22:
            return false;
        L20:
            cancel();
            this.downstream.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
            return true;
        }
    }
}
