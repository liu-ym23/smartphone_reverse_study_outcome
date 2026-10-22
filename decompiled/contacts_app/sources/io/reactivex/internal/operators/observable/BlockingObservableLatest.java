package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class BlockingObservableLatest<T> implements Iterable<T> {
    final ObservableSource<T> source;

    static final class BlockingObservableLatestIterator<T> extends DisposableObserver<Notification<T>> implements Iterator<T> {
        Notification<T> iteratorNotification;
        final Semaphore notify;
        final AtomicReference<Notification<T>> value;

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        BlockingObservableLatestIterator() {
            this.notify = new Semaphore(0);
            this.value = new AtomicReference();
        }

        @Override // io.reactivex.Observer
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

        @Override // io.reactivex.Observer
        public void onError(Throwable r1) {
            RxJavaPlugins.onError(r1);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Notification<T> r0 = this.iteratorNotification;
            if (r0 == null) goto L10;
            if (r0.isOnError() == false) goto L10;
            throw ExceptionHelper.wrapOrThrow(this.iteratorNotification.getError());
        L10:
            if (this.iteratorNotification != null) goto L21;
            BlockingHelper.verifyNonBlocking();     // Catch: InterruptedException -> L17
            this.notify.acquire();     // Catch: InterruptedException -> L17
            Notification<T> r1 = this.value.getAndSet(null);
            this.iteratorNotification = r1;
            if (r1.isOnError() == false) goto L21;
            throw ExceptionHelper.wrapOrThrow(r1.getError());
        L17:
            e = move-exception;
            dispose();
            this.iteratorNotification = Notification.createOnError(e);
            throw ExceptionHelper.wrapOrThrow(e);
        L21:
            return this.iteratorNotification.isOnNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext() == false) goto L7;
            T r0 = this.iteratorNotification.getValue();
            this.iteratorNotification = null;
            return r0;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }
    }

    public BlockingObservableLatest(ObservableSource<T> r1) {
        this.source = r1;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        BlockingObservableLatestIterator r0 = new BlockingObservableLatestIterator();
        Observable.wrap(this.source).materialize().subscribe(r0);
        return r0;
    }
}
