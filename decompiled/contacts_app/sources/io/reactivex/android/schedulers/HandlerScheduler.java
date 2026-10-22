package io.reactivex.android.schedulers;

import android.os.Handler;
import android.os.Message;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
final class HandlerScheduler extends Scheduler {
    private final boolean async;
    private final Handler handler;

    private static final class HandlerWorker extends Scheduler.Worker {
        private final boolean async;
        private volatile boolean disposed;
        private final Handler handler;

        HandlerWorker(Handler r1, boolean r2) {
            this.handler = r1;
            this.async = r2;
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable schedule(Runnable r3, long r4, TimeUnit r6) {
            if (r3 == null) goto L19;
            if (r6 == null) goto L17;
            if (this.disposed == true) goto L7;
            Runnable r5 = RxJavaPlugins.onSchedule(r3);
            ScheduledRunnable r0 = new ScheduledRunnable(this.handler, r5);
            Message r7 = Message.obtain(this.handler, r0);
            r7.obj = this;
            if (this.async == false) goto L11;
            r7.setAsynchronous(true);
        L11:
            this.handler.sendMessageDelayed(r7, r6.toMillis(r4));
            if (this.disposed == false) goto L15;
            this.handler.removeCallbacks(r0);
            return Disposables.disposed();
        L15:
            return r0;
        L7:
            return Disposables.disposed();
        L17:
            throw new NullPointerException("unit == null");
        L19:
            throw new NullPointerException("run == null");
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.disposed = true;
            this.handler.removeCallbacksAndMessages(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }
    }

    private static final class ScheduledRunnable implements Runnable, Disposable {
        private final Runnable delegate;
        private volatile boolean disposed;
        private final Handler handler;

        ScheduledRunnable(Handler r1, Runnable r2) {
            this.handler = r1;
            this.delegate = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.delegate.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.handler.removeCallbacks(this);
            this.disposed = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }
    }

    HandlerScheduler(Handler r1, boolean r2) {
        this.handler = r1;
        this.async = r2;
    }

    @Override // io.reactivex.Scheduler
    public Disposable scheduleDirect(Runnable r3, long r4, TimeUnit r6) {
        if (r3 == null) goto L12;
        if (r6 == null) goto L10;
        Runnable r5 = RxJavaPlugins.onSchedule(r3);
        ScheduledRunnable r0 = new ScheduledRunnable(this.handler, r5);
        Message r7 = Message.obtain(this.handler, r0);
        if (this.async == false) goto L7;
        r7.setAsynchronous(true);
    L7:
        this.handler.sendMessageDelayed(r7, r6.toMillis(r4));
        return r0;
    L10:
        throw new NullPointerException("unit == null");
    L12:
        throw new NullPointerException("run == null");
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker createWorker() {
        return new HandlerWorker(this.handler, this.async);
    }
}
