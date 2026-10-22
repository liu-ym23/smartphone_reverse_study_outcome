package io.reactivex.internal.schedulers;

import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes4.dex */
public final class ScheduledDirectPeriodicTask extends AbstractDirectTask implements Runnable {
    private static final long serialVersionUID = 1811839108042568751L;

    @Override // io.reactivex.internal.schedulers.AbstractDirectTask, io.reactivex.schedulers.SchedulerRunnableIntrospection
    public /* bridge */ /* synthetic */ Runnable getWrappedRunnable() {
        return super.getWrappedRunnable();
    }

    public ScheduledDirectPeriodicTask(Runnable r1) {
        super(r1);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.runner = Thread.currentThread();
        this.runnable.run();     // Catch: Throwable -> L5
        this.runner = null;     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        this.runner = null;
        lazySet(FINISHED);
        RxJavaPlugins.onError(th);
    }
}
