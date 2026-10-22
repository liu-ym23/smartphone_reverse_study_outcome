package com.android.internal.util.jobs;

import android.os.RemoteException;
import android.util.ExceptionUtils;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public class FunctionalUtils {

    @FunctionalInterface
    public interface RemoteExceptionIgnoringConsumer<T> extends Consumer<T> {
        void acceptOrThrow(T r1) throws RemoteException;

        @Override // java.util.function.Consumer
        default void accept(T t) {
            acceptOrThrow(t);     // Catch: RemoteException -> L4
            return;
        }
    }

    @FunctionalInterface
    public interface ThrowingBiConsumer<A, B> extends BiConsumer<A, B> {
        void acceptOrThrow(A r1, B r2) throws Exception;

        @Override // java.util.function.BiConsumer
        default void accept(A a, B b) {
            acceptOrThrow(a, b);     // Catch: Exception -> L4
            return;
        L4:
            ex = move-exception;
            throw ExceptionUtils.propagate(ex);
        }
    }

    @FunctionalInterface
    public interface ThrowingBiFunction<T, U, R> extends BiFunction<T, U, R> {
        R applyOrThrow(T r1, U r2) throws Exception;

        @Override // java.util.function.BiFunction
        default R apply(T t, U u) {
            return applyOrThrow(t, u);
        L4:
            ex = move-exception;
            throw ExceptionUtils.propagate(ex);
        }
    }

    @FunctionalInterface
    public interface ThrowingChecked2Consumer<Input, ExceptionOne extends Exception, ExceptionTwo extends Exception> {
        void accept(Input r1) throws Exception, Exception;
    }

    @FunctionalInterface
    public interface ThrowingCheckedConsumer<Input, ExceptionType extends Exception> {
        void accept(Input r1) throws Exception;
    }

    @FunctionalInterface
    public interface ThrowingCheckedFunction<Input, Output, ExceptionType extends Exception> {
        Output apply(Input r1) throws Exception;
    }

    @FunctionalInterface
    public interface ThrowingCheckedSupplier<Output, ExceptionType extends Exception> {
        Output get() throws Exception;
    }

    @FunctionalInterface
    public interface ThrowingConsumer<T> extends Consumer<T> {
        void acceptOrThrow(T r1) throws Exception;

        @Override // java.util.function.Consumer
        default void accept(T t) {
            acceptOrThrow(t);     // Catch: Exception -> L4
            return;
        L4:
            ex = move-exception;
            throw ExceptionUtils.propagate(ex);
        }
    }

    @FunctionalInterface
    public interface ThrowingFunction<T, R> extends Function<T, R> {
        R applyOrThrow(T r1) throws Exception;

        @Override // java.util.function.Function
        default R apply(T t) {
            return applyOrThrow(t);
        L4:
            ex = move-exception;
            throw ExceptionUtils.propagate(ex);
        }
    }

    @FunctionalInterface
    public interface ThrowingRunnable extends Runnable {
        void runOrThrow() throws Exception;

        @Override // java.lang.Runnable
        default void run() {
            runOrThrow();     // Catch: Exception -> L4
            return;
        L4:
            ex = move-exception;
            throw ExceptionUtils.propagate(ex);
        }
    }

    @FunctionalInterface
    public interface ThrowingSupplier<T> extends Supplier<T> {
        T getOrThrow() throws Exception;

        @Override // java.util.function.Supplier
        default T get() {
            return getOrThrow();
        L4:
            ex = move-exception;
            throw ExceptionUtils.propagate(ex);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$ei4-Zcd7p4KqBNqg3n_kB4-vB8A, reason: not valid java name */
    public static /* synthetic */ void m47$r8$lambda$ei4Zcd7p4KqBNqg3n_kB4vB8A(ThrowingRunnable r0, Consumer r1) {
        lambda$handleExceptions$0(r0, r1);
    }

    private FunctionalUtils() {
    }

    public static <T> Consumer<T> uncheckExceptions(ThrowingConsumer<T> action) {
        return action;
    }

    public static <I, O> Function<I, O> uncheckExceptions(ThrowingFunction<I, O> action) {
        return action;
    }

    public static Runnable uncheckExceptions(ThrowingRunnable action) {
        return action;
    }

    public static <A, B> BiConsumer<A, B> uncheckExceptions(ThrowingBiConsumer<A, B> action) {
        return action;
    }

    public static <T> Supplier<T> uncheckExceptions(ThrowingSupplier<T> action) {
        return action;
    }

    public static <T> Consumer<T> ignoreRemoteException(RemoteExceptionIgnoringConsumer<T> action) {
        return action;
    }

    public static Runnable handleExceptions(final ThrowingRunnable r, final Consumer<Throwable> handler) {
        return new FunctionalUtils$$ExternalSyntheticLambda0(r, handler);
    }

    private static /* synthetic */ void lambda$handleExceptions$0(ThrowingRunnable r, Consumer handler) {
        r.run();     // Catch: Throwable -> L4
        return;
    L4:
        t = move-exception;
        handler.accept(t);
    }

    public static String getLambdaName(Object function) {
        String fullFunction = function.toString();
        int endPkgIdx = fullFunction.indexOf("-$$");
        if (endPkgIdx != (-1)) goto L5;
        return fullFunction;
    L5:
        int firstDollarIdx = fullFunction.indexOf(36, endPkgIdx + 3);
        if (firstDollarIdx != (-1)) goto L8;
        return fullFunction;
    L8:
        int endClassIdx = fullFunction.indexOf(36, firstDollarIdx + 1);
        if (endClassIdx != (-1)) goto L13;
        return fullFunction.substring(0, endPkgIdx - 1) + "$Lambda";
    L13:
        return fullFunction.substring(0, endPkgIdx) + fullFunction.substring(firstDollarIdx + 1, endClassIdx) + "$Lambda";
    }
}
