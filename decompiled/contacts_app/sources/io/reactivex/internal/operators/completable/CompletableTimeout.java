package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public final class CompletableTimeout extends Completable {
    final CompletableSource other;
    final Scheduler scheduler;
    final CompletableSource source;
    final long timeout;
    final TimeUnit unit;

    final class DisposeTask implements Runnable {
        final CompletableObserver downstream;
        private final AtomicBoolean once;
        final CompositeDisposable set;
        final /* synthetic */ CompletableTimeout this$0;

        final class DisposeObserver implements CompletableObserver {
            final /* synthetic */ DisposeTask this$1;

            DisposeObserver(DisposeTask r1) {
                this.this$1 = r1;
            }

            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(Disposable r1) {
                this.this$1.set.add(r1);
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable r2) {
                this.this$1.set.dispose();
                this.this$1.downstream.onError(r2);
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                this.this$1.set.dispose();
                this.this$1.downstream.onComplete();
            }
        }

        DisposeTask(CompletableTimeout r1, AtomicBoolean r2, CompositeDisposable r3, CompletableObserver r4) {
            this.this$0 = r1;
            this.once = r2;
            this.set = r3;
            this.downstream = r4;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.once.compareAndSet(false, true) == false) goto L9;
            this.set.clear();
            if (this.this$0.other != null) goto L7;
            this.downstream.onError(new TimeoutException(ExceptionHelper.timeoutMessage(this.this$0.timeout, this.this$0.unit)));
            return;
        L7:
            this.this$0.other.subscribe(new DisposeObserver(this));
            return;
        }
    }

    static final class TimeOutObserver implements CompletableObserver {
        private final CompletableObserver downstream;
        private final AtomicBoolean once;
        private final CompositeDisposable set;

        TimeOutObserver(CompositeDisposable r1, AtomicBoolean r2, CompletableObserver r3) {
            this.set = r1;
            this.once = r2;
            this.downstream = r3;
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable r1) {
            this.set.add(r1);
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable r4) {
            if (this.once.compareAndSet(false, true) == false) goto L5;
            this.set.dispose();
            this.downstream.onError(r4);
            return;
        L5:
            RxJavaPlugins.onError(r4);
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            if (this.once.compareAndSet(false, true) == false) goto L6;
            this.set.dispose();
            this.downstream.onComplete();
            return;
        }
    }

    public CompletableTimeout(CompletableSource r1, long r2, TimeUnit r4, Scheduler r5, CompletableSource r6) {
        this.source = r1;
        this.timeout = r2;
        this.unit = r4;
        this.scheduler = r5;
        this.other = r6;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver r8) {
        CompositeDisposable r0 = new CompositeDisposable();
        r8.onSubscribe(r0);
        AtomicBoolean r1 = new AtomicBoolean();
        r0.add(this.scheduler.scheduleDirect(new DisposeTask(this, r1, r0, r8), this.timeout, this.unit));
        this.source.subscribe(new TimeOutObserver(r0, r1, r8));
    }
}
