package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import com.airbnb.lottie.utils.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes.dex */
public class LottieTask<T> {
    public static Executor EXECUTOR;
    private final Set<LottieListener<Throwable>> failureListeners;
    private final Handler handler;
    private volatile LottieResult<T> result;
    private final Set<LottieListener<T>> successListeners;

    private class LottieFutureTask extends FutureTask<LottieResult<T>> {
        final /* synthetic */ LottieTask this$0;

        LottieFutureTask(LottieTask r1, Callable<LottieResult<T>> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            if (isCancelled() == false) goto L10;
            return;
        L10:
            LottieTask.access$000(this.this$0, get());     // Catch: Throwable -> L7
            return;
        L7:
            e = move-exception;
            LottieTask.access$000(this.this$0, new LottieResult(e));
        }
    }

    static /* synthetic */ void access$000(LottieTask r0, LottieResult r1) {
        r0.setResult(r1);
    }

    static {
        EXECUTOR = Executors.newCachedThreadPool();
    }

    public LottieTask(Callable<LottieResult<T>> r2) {
        this(r2, false);
    }

    LottieTask(Callable<LottieResult<T>> r3, boolean r4) {
        this.successListeners = new LinkedHashSet(1);
        this.failureListeners = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.result = null;
        if (r4 == true) goto L10;
        EXECUTOR.execute(new LottieFutureTask(this, r3));
        return;
    L10:
        setResult(r3.call());     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        setResult(new LottieResult(th));
    }

    private void setResult(LottieResult<T> r2) {
        if (this.result != null) goto L7;
        this.result = r2;
        notifyListeners();
        return;
    L7:
        throw new IllegalStateException("A task may only be set once.");
    }

    public synchronized LottieTask<T> addListener(LottieListener<T> r3) {
        monitor-enter(this);
        LottieResult<T> r0 = this.result;     // Catch: Throwable -> L11
        if (r0 != null) goto L6;
    L8:
        this.successListeners.add(r3);     // Catch: Throwable -> L11
        monitor-exit(this);
        return this;
    L6:
        if (r0.getValue() == null) goto L8;
        r3.onResult(r0.getValue());     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public synchronized LottieTask<T> removeListener(LottieListener<T> r2) {
        monitor-enter(this);
        this.successListeners.remove(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized LottieTask<T> addFailureListener(LottieListener<Throwable> r3) {
        monitor-enter(this);
        LottieResult<T> r0 = this.result;     // Catch: Throwable -> L11
        if (r0 != null) goto L6;
    L8:
        this.failureListeners.add(r3);     // Catch: Throwable -> L11
        monitor-exit(this);
        return this;
    L6:
        if (r0.getException() == null) goto L8;
        r3.onResult(r0.getException());     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public synchronized LottieTask<T> removeFailureListener(LottieListener<Throwable> r2) {
        monitor-enter(this);
        this.failureListeners.remove(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    private void notifyListeners() {
        this.handler.post(new LottieTask$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: renamed from: lambda$notifyListeners$0$com-airbnb-lottie-LottieTask, reason: not valid java name */
    /* synthetic */ void m119lambda$notifyListeners$0$comairbnblottieLottieTask() {
        LottieResult<T> r0 = this.result;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.getValue() == null) goto L8;
        notifySuccessListeners(r0.getValue());
        return;
    L8:
        notifyFailureListeners(r0.getException());
    }

    private synchronized void notifySuccessListeners(T r3) {
        monitor-enter(this);
        Iterator r0 = new ArrayList(this.successListeners).iterator();     // Catch: Throwable -> L10
    L5:
        if (r0.hasNext() == false) goto L8;
        ((LottieListener) r0.next()).onResult(r3);     // Catch: Throwable -> L10
        goto L5
    L8:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private synchronized void notifyFailureListeners(Throwable r3) {
        monitor-enter(this);
        ArrayList r0 = new ArrayList(this.failureListeners);     // Catch: Throwable -> L15
        if (r0.isEmpty() == false) goto L8;
        Logger.warning("Lottie encountered an error but no failure listener was added:", r3);     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L8:
        Iterator r1 = r0.iterator();     // Catch: Throwable -> L15
    L10:
        if (r1.hasNext() == false) goto L13;
        ((LottieListener) r1.next()).onResult(r3);     // Catch: Throwable -> L15
        goto L10
    L13:
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }
}
