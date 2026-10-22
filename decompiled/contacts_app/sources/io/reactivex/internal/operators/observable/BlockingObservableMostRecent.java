package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.DefaultObserver;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes4.dex */
public final class BlockingObservableMostRecent<T> implements Iterable<T> {
    final T initialValue;
    final ObservableSource<T> source;

    static final class MostRecentObserver<T> extends DefaultObserver<T> {
        volatile Object value;

        final class Iterator implements java.util.Iterator<T> {
            private Object buf;
            final /* synthetic */ MostRecentObserver this$0;

            Iterator(MostRecentObserver r1) {
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

        MostRecentObserver(T r1) {
            this.value = NotificationLite.next(r1);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.value = NotificationLite.complete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r1) {
            this.value = NotificationLite.error(r1);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r1) {
            this.value = NotificationLite.next(r1);
        }

        public MostRecentObserver<T>.Iterator getIterable() {
            return new Iterator(this);
        }
    }

    public BlockingObservableMostRecent(ObservableSource<T> r1, T r2) {
        this.source = r1;
        this.initialValue = r2;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        MostRecentObserver r0 = new MostRecentObserver(this.initialValue);
        this.source.subscribe(r0);
        return r0.getIterable();
    }
}
