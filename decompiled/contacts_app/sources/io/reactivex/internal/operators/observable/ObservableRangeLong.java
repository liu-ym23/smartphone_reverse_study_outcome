package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.observers.BasicIntQueueDisposable;

/* JADX INFO: loaded from: classes4.dex */
public final class ObservableRangeLong extends Observable<Long> {
    private final long count;
    private final long start;

    static final class RangeDisposable extends BasicIntQueueDisposable<Long> {
        private static final long serialVersionUID = 396518478098735504L;
        final Observer<? super Long> downstream;
        final long end;
        boolean fused;
        long index;

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public /* bridge */ /* synthetic */ Object poll() throws Exception {
            return poll();
        }

        RangeDisposable(Observer<? super Long> r1, long r2, long r4) {
            this.downstream = r1;
            this.index = r2;
            this.end = r4;
        }

        void run() {
            if (this.fused == false) goto L5;
            return;
        L5:
            Observer<? super Long> r0 = this.downstream;
            long r1 = this.end;
            long r3 = this.index;
        L7:
            if (r3 == r1) goto L12;
            if (get() != 0) goto L12;
            r0.onNext(Long.valueOf(r3));
            r3 = r3 + 1;
        L12:
            if (get() != 0) goto L17;
            lazySet(1);
            r0.onComplete();
            return;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Long poll() throws Exception {
            long r0 = this.index;
            if (r0 == this.end) goto L6;
            this.index = 1 + r0;
            return Long.valueOf(r0);
        L6:
            lazySet(1);
            return null;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            if (this.index != this.end) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.index = this.end;
            lazySet(1);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            set(1);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int r2) {
            if ((r2 & 1) == 0) goto L6;
            this.fused = true;
            return 1;
        L6:
            return 0;
        }
    }

    public ObservableRangeLong(long r1, long r3) {
        this.start = r1;
        this.count = r3;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super Long> r8) {
        long r2 = this.start;
        RangeDisposable r6 = new RangeDisposable(r8, r2, r2 + this.count);
        r8.onSubscribe(r6);
        r6.run();
    }
}
