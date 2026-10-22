package io.reactivex.internal.schedulers;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import mf.f;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SchedulerWhen extends f implements Disposable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Disposable f20718b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Disposable f20719c = null;

    public static class DelayedAction extends ScheduledAction {
        private final Runnable action;
        private final long delayTime;
        private final TimeUnit unit;

        public DelayedAction(Runnable r10, long r11, TimeUnit r12) {
            this.action = r10;
            this.delayTime = r11;
            this.unit = r12;
        }

        @Override // io.reactivex.internal.schedulers.SchedulerWhen.ScheduledAction
        public Disposable callActual(f.a r10, CompletableObserver r11) {
            new a(this.action, r11);
            throw null;
        }
    }

    public static class ImmediateAction extends ScheduledAction {
        private final Runnable action;

        public ImmediateAction(Runnable r10) {
            this.action = r10;
        }

        @Override // io.reactivex.internal.schedulers.SchedulerWhen.ScheduledAction
        public Disposable callActual(f.a r10, CompletableObserver r11) {
            new a(this.action, r11);
            throw null;
        }
    }

    public static abstract class ScheduledAction extends AtomicReference<Disposable> implements Disposable {
        public ScheduledAction() {
            super(SchedulerWhen.f20718b);
        }

        public void call(f.a r10, CompletableObserver r11) {
            Disposable r12 = get();
            if (r12 != SchedulerWhen.f20719c) goto L5;
            return;
        L5:
            Disposable r13 = SchedulerWhen.f20718b;
            if (r12 == r13) goto L8;
            return;
        L8:
            Disposable r14 = callActual(r10, r11);
            if (compareAndSet(r13, r14) == true) goto L12;
            r14.dispose();
            return;
        }

        public abstract Disposable callActual(f.a r10, CompletableObserver r11);

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Disposable r10 = SchedulerWhen.f20719c;
        L3:
            Disposable r11 = get();
            if (r11 == SchedulerWhen.f20719c) goto L5;
            if (compareAndSet(r11, r10) == false) goto L3;
            if (r11 == SchedulerWhen.f20718b) goto L15;
            r11.dispose();
            return;
        L15:
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get().isDisposed();
        }
    }

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CompletableObserver f20720a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Runnable f20721b;

        public a(Runnable r10, CompletableObserver r11) {
            this.f20721b = r10;
            this.f20720a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f20721b.run();     // Catch: Throwable -> L5
            this.f20720a.onComplete();
            return;
        L5:
            th = move-exception;
            this.f20720a.onComplete();
            throw th;
        }
    }

    public static final class b implements Disposable {
        public b() {
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return false;
        }
    }

    static {
        f20718b = new b();
        f20719c = io.reactivex.disposables.b.a();
    }
}
