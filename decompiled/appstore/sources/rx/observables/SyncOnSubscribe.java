package rx.observables;

import java.util.concurrent.atomic.AtomicLong;
import og.c;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SyncOnSubscribe implements Observable.OnSubscribe {

    public static final class SubscriptionProducer<S, T> extends AtomicLong implements Producer, Subscription, Observer<T> {
        private static final long serialVersionUID = -3736864024352728072L;
        private final Subscriber actualSubscriber;
        private boolean hasTerminated;
        private boolean onNextCalled;
        private final SyncOnSubscribe parent;
        private S state;

        public SubscriptionProducer(Subscriber r10, SyncOnSubscribe r11, S r12) {
            this.actualSubscriber = r10;
            this.state = r12;
        }

        private void doUnsubscribe() {
            throw null;     // Catch: Throwable -> L4
        L4:
            th = move-exception;
            rx.exceptions.a.e(th);
            c.j(th);
        }

        private void fastPath() {
            Subscriber r10 = this.actualSubscriber;
        L11:
            this.onNextCalled = false;     // Catch: Throwable -> L8
            nextIteration(null);     // Catch: Throwable -> L8
            if (tryUnsubscribe() == false) goto L11;
            return;
        L8:
            th = move-exception;
            handleThrownError(r10, th);
        }

        private void handleThrownError(Subscriber r10, Throwable r11) {
            if (this.hasTerminated == false) goto L5;
            c.j(r11);
            return;
        L5:
            this.hasTerminated = true;
            r10.onError(r11);
            unsubscribe();
        }

        private void nextIteration(SyncOnSubscribe r10) {
            throw null;
        }

        private void slowPath(long r10) {
            Subscriber r11 = this.actualSubscriber;
        L3:
            long r12 = r10;
        L21:
            this.onNextCalled = false;     // Catch: Throwable -> L18
            nextIteration(null);     // Catch: Throwable -> L18
            if (tryUnsubscribe() == true) goto L8;
            if (this.onNextCalled == false) goto L13;
            r12 = r12 - 1;
        L13:
            if (r12 != 0) goto L21;
            r10 = addAndGet(-r10);
            if (r10 > 0) goto L3;
            tryUnsubscribe();
            return;
        L8:
            return;
        L18:
            th = move-exception;
            handleThrownError(r11, th);
        }

        private boolean tryUnsubscribe() {
            if (this.hasTerminated == false) goto L5;
        L9:
            set(-1);
            doUnsubscribe();
            return true;
        L5:
            if (get() < (-1)) goto L9;
            return false;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            if (get() >= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (this.hasTerminated == true) goto L9;
            this.hasTerminated = true;
            if (this.actualSubscriber.isUnsubscribed() == true) goto L10;
            this.actualSubscriber.onCompleted();
            return;
        L10:
            return;
        L9:
            throw new IllegalStateException("Terminal event already emitted.");
        }

        @Override // rx.Observer
        public void onError(Throwable r10) {
            if (this.hasTerminated == true) goto L9;
            this.hasTerminated = true;
            if (this.actualSubscriber.isUnsubscribed() == true) goto L10;
            this.actualSubscriber.onError(r10);
            return;
        L10:
            return;
        L9:
            throw new IllegalStateException("Terminal event already emitted.");
        }

        @Override // rx.Observer
        public void onNext(T r10) {
            if (this.onNextCalled == true) goto L7;
            this.onNextCalled = true;
            this.actualSubscriber.onNext(r10);
            return;
        L7:
            throw new IllegalStateException("onNext called multiple times!");
        }

        @Override // rx.Producer
        public void request(long r10) {
            if (r10 > 0) goto L5;
            return;
        L5:
            if (rx.internal.operators.a.b(this, r10) == 0) goto L7;
            return;
        L7:
            if (r10 != Long.MAX_VALUE) goto L9;
            fastPath();
            return;
        L9:
            slowPath(r10);
        }

        @Override // rx.Subscription
        public void unsubscribe() {
        L2:
            long r10 = get();
            if (compareAndSet(0, -1) == true) goto L4;
            if (compareAndSet(r10, -2) == false) goto L2;
            return;
        L4:
            doUnsubscribe();
        }
    }
}
