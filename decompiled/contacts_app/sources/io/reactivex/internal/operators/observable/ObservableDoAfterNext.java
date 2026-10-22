package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.observers.BasicFuseableObserver;

/* JADX INFO: loaded from: classes4.dex */
public final class ObservableDoAfterNext<T> extends AbstractObservableWithUpstream<T, T> {
    final Consumer<? super T> onAfterNext;

    static final class DoAfterObserver<T> extends BasicFuseableObserver<T, T> {
        final Consumer<? super T> onAfterNext;

        DoAfterObserver(Observer<? super T> r1, Consumer<? super T> r2) {
            super(r1);
            this.onAfterNext = r2;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.Observer
        public void onNext(T r2) {
            this.downstream.onNext((Object) r2);
            if (this.sourceMode != 0) goto L11;
            this.onAfterNext.accept(r2);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            fail(th);
            return;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int r1) {
            return transitiveBoundaryFusion(r1);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public T poll() throws Exception {
            T r0 = this.qd.poll();
            if (r0 == null) goto L5;
            this.onAfterNext.accept(r0);
        L5:
            return r0;
        }
    }

    public ObservableDoAfterNext(ObservableSource<T> r1, Consumer<? super T> r2) {
        super(r1);
        this.onAfterNext = r2;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> r3) {
        this.source.subscribe(new DoAfterObserver(r3, this.onAfterNext));
    }
}
