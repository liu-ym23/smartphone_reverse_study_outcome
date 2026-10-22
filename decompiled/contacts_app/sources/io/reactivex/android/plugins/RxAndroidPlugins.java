package io.reactivex.android.plugins;

import io.reactivex.Scheduler;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes4.dex */
public final class RxAndroidPlugins {
    private static volatile Function<Callable<Scheduler>, Scheduler> onInitMainThreadHandler;
    private static volatile Function<Scheduler, Scheduler> onMainThreadHandler;

    public static void setInitMainThreadSchedulerHandler(Function<Callable<Scheduler>, Scheduler> r0) {
        onInitMainThreadHandler = r0;
    }

    public static Scheduler initMainThreadScheduler(Callable<Scheduler> r1) {
        if (r1 == null) goto L10;
        Function<Callable<Scheduler>, Scheduler> r0 = onInitMainThreadHandler;
        if (r0 != null) goto L8;
        return callRequireNonNull(r1);
    L8:
        return applyRequireNonNull(r0, r1);
    L10:
        throw new NullPointerException("scheduler == null");
    }

    public static void setMainThreadSchedulerHandler(Function<Scheduler, Scheduler> r0) {
        onMainThreadHandler = r0;
    }

    public static Scheduler onMainThreadScheduler(Scheduler r1) {
        if (r1 == null) goto L9;
        Function<Scheduler, Scheduler> r0 = onMainThreadHandler;
        if (r0 != null) goto L7;
        return r1;
    L7:
        return (Scheduler) apply(r0, r1);
    L9:
        throw new NullPointerException("scheduler == null");
    }

    public static Function<Callable<Scheduler>, Scheduler> getInitMainThreadSchedulerHandler() {
        return onInitMainThreadHandler;
    }

    public static Function<Scheduler, Scheduler> getOnMainThreadSchedulerHandler() {
        return onMainThreadHandler;
    }

    public static void reset() {
        setInitMainThreadSchedulerHandler(null);
        setMainThreadSchedulerHandler(null);
    }

    static Scheduler callRequireNonNull(Callable<Scheduler> r1) {
        Scheduler r2 = r1.call();     // Catch: Throwable -> L7
        if (r2 == null) goto L6;
        return r2;
    L6:
        throw new NullPointerException("Scheduler Callable returned null");     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw Exceptions.propagate(th);
    }

    static Scheduler applyRequireNonNull(Function<Callable<Scheduler>, Scheduler> r0, Callable<Scheduler> r1) {
        Scheduler r2 = (Scheduler) apply(r0, r1);
        if (r2 == null) goto L6;
        return r2;
    L6:
        throw new NullPointerException("Scheduler Callable returned null");
    }

    static <T, R> R apply(Function<T, R> r0, T r1) {
        return r0.apply(r1);
    L4:
        th = move-exception;
        throw Exceptions.propagate(th);
    }

    private RxAndroidPlugins() {
        throw new AssertionError("No instances.");
    }
}
