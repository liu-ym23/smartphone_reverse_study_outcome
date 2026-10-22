package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Notification;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.DisposableSubscriber;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: classes4.dex */
public final class BlockingFlowableLatest<T> implements Iterable<T> {
    final Publisher<? extends T> source;

    static final class LatestSubscriberIterator<T> extends DisposableSubscriber<Notification<T>> implements Iterator<T> {
        Notification<T> iteratorNotification;
        final Semaphore notify;
        final AtomicReference<Notification<T>> value;

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
        }

        LatestSubscriberIterator() {
            this.notify = new Semaphore(0);
            this.value = new AtomicReference();
        }

        @Override // org.reactivestreams.Subscriber
        public /* bridge */ /* synthetic */ void onNext(Object r1) {
            onNext((Notification) r1);
        }

        public void onNext(Notification<T> r2) {
            if (this.value.getAndSet(r2) != null) goto L5;
            boolean r3 = true;
        L6:
            if (r3 == false) goto L9;
            this.notify.release();
            return;
        L9:
            return;
        L5:
            r3 = false;
            goto L6
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r1) {
            RxJavaPlugins.onError(r1);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Notification<T> r0 = this.iteratorNotification;
            if (r0 != null) goto L5;
        L9:
            Notification<T> r1 = this.iteratorNotification;
            if (r1 == null) goto L14;
            if (r1.isOnNext() == true) goto L14;
        L25:
            return this.iteratorNotification.isOnNext();
        L14:
            if (this.iteratorNotification != null) goto L25;
            BlockingHelper.verifyNonBlocking();     // Catch: InterruptedException -> L21
            this.notify.acquire();     // Catch: InterruptedException -> L21
            Notification<T> r2 = this.value.getAndSet(null);
            this.iteratorNotification = r2;
            if (r2.isOnError() == false) goto L25;
            throw ExceptionHelper.wrapOrThrow(r2.getError());
        L21:
            e = move-exception;
            dispose();
            this.iteratorNotification = Notification.createOnError(e);
            throw ExceptionHelper.wrapOrThrow(e);
        L5:
            if (r0.isOnError() == false) goto L9;
            throw ExceptionHelper.wrapOrThrow(this.iteratorNotification.getError());
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext() == false) goto L9;
            if (this.iteratorNotification.isOnNext() == false) goto L9;
            T r0 = this.iteratorNotification.getValue();
            this.iteratorNotification = null;
            return r0;
        L9:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }
    }

    public BlockingFlowableLatest(Publisher<? extends T> r1) {
        this.source = r1;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        LatestSubscriberIterator r0 = new LatestSubscriberIterator();
        Flowable.fromPublisher(this.source).materialize().subscribe(r0);
        return r0;
    }
}
