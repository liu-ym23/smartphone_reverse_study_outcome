package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subscribers.DefaultSubscriber;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes4.dex */
public final class BlockingFlowableMostRecent<T> implements Iterable<T> {
    final T initialValue;
    final Flowable<T> source;

    static final class MostRecentSubscriber<T> extends DefaultSubscriber<T> {
        volatile Object value;

        final class Iterator implements java.util.Iterator<T> {
            private Object buf;
            final /* synthetic */ MostRecentSubscriber this$0;

            Iterator(MostRecentSubscriber r1) {
                this.this$0 = r1;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                Object r0 = this.this$0.value;
                this.buf = r0;
                return !NotificationLite.isComplete(r0);
            }

            @Override // java.util.Iterator
            public T next() {
            L17:
                th = move-exception;
                this.buf = null;
                throw th;
            L4:
                if (this.buf != null) goto L7;
                this.buf = this.this$0.value;     // Catch: Throwable -> L17
            L7:
                if (NotificationLite.isComplete(this.buf) == true) goto L16;
                if (NotificationLite.isError(this.buf) == true) goto L14;
                T r1 = (T) NotificationLite.getValue(this.buf);
                this.buf = null;
                return r1;
            L14:
                throw ExceptionHelper.wrapOrThrow(NotificationLite.getError(this.buf));     // Catch: Throwable -> L17
            L16:
                throw new NoSuchElementException();     // Catch: Throwable -> L17
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }

        MostRecentSubscriber(T r1) {
            this.value = NotificationLite.next(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.value = NotificationLite.complete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable r1) {
            this.value = NotificationLite.error(r1);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T r1) {
            this.value = NotificationLite.next(r1);
        }

        public MostRecentSubscriber<T>.Iterator getIterable() {
            return new Iterator(this);
        }
    }

    public BlockingFlowableMostRecent(Flowable<T> r1, T r2) {
        this.source = r1;
        this.initialValue = r2;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        MostRecentSubscriber r0 = new MostRecentSubscriber(this.initialValue);
        this.source.subscribe(r0);
        return r0.getIterable();
    }
}
