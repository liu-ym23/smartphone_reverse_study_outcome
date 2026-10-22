package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.Sets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public final class SimpleTimeLimiter implements TimeLimiter {
    private final ExecutorService executor;

    private SimpleTimeLimiter(ExecutorService r10) {
        this.executor = (ExecutorService) Preconditions.checkNotNull(r10);
    }

    public static /* synthetic */ Exception access$000(Exception r10, boolean r11) throws Exception {
        return throwCause(r10, r11);
    }

    public static /* synthetic */ Object access$100(SimpleTimeLimiter r10, Callable r11, long r12, TimeUnit r13, boolean r14) throws Exception {
        return r10.callWithTimeout(r11, r12, r13, r14);
    }

    private <T> T callWithTimeout(Callable<T> r10, long r11, TimeUnit r12, boolean r13) throws Exception {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r12);
        checkPositiveTimeout(r11);
        Future<T> r14 = this.executor.submit(r10);
        if (r13 == false) goto L14;
        return r14.get(r11, r12);
    L10:
        e = move-exception;
        r14.cancel(true);     // Catch: TimeoutException -> L6 ExecutionException -> L8
        throw e;     // Catch: TimeoutException -> L6 ExecutionException -> L8
    L14:
        return (T) Uninterruptibles.getUninterruptibly(r14, r11, r12);
    L8:
        e = move-exception;
        throw throwCause(e, true);
    L6:
        e = move-exception;
        r14.cancel(true);
        throw new UncheckedTimeoutException(e);
    }

    private static void checkPositiveTimeout(long r10) {
        if (r10 <= 0) goto L5;
        boolean r11 = true;
    L6:
        Preconditions.checkArgument(r11, "timeout must be positive: %s", r10);
        return;
    L5:
        r11 = false;
        goto L6
    }

    public static SimpleTimeLimiter create(ExecutorService r10) {
        return new SimpleTimeLimiter(r10);
    }

    private static boolean declaresInterruptedEx(Method r10) {
        Class<?>[] r11 = r10.getExceptionTypes();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        if (r11[r13] == InterruptedException.class) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private static Set<Method> findInterruptibleMethods(Class<?> r10) {
        HashSet r11 = Sets.newHashSet();
        Method[] r12 = r10.getMethods();
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        Method r15 = r12[r14];
        if (declaresInterruptedEx(r15) == false) goto L7;
        r11.add(r15);
    L7:
        r14 = r14 + 1;
        goto L3
    L8:
        return r11;
    }

    private static Exception throwCause(Exception r10, boolean r11) throws Exception {
        Throwable r12 = r10.getCause();
        if (r12 == null) goto L15;
        if (r11 == false) goto L7;
        r12.setStackTrace((StackTraceElement[]) ObjectArrays.concat(r12.getStackTrace(), r10.getStackTrace(), StackTraceElement.class));
    L7:
        if ((r12 instanceof Exception) == true) goto L14;
        if ((r12 instanceof Error) == true) goto L11;
        throw r10;
    L11:
        throw ((Error) r12);
    L14:
        throw ((Exception) r12);
    L15:
        throw r10;
    }

    private void wrapAndThrowExecutionExceptionOrError(Throwable r10) throws ExecutionException {
        if ((r10 instanceof Error) == true) goto L11;
        if ((r10 instanceof RuntimeException) == false) goto L9;
        throw new UncheckedExecutionException(r10);
    L9:
        throw new ExecutionException(r10);
    L11:
        throw new ExecutionError((Error) r10);
    }

    private void wrapAndThrowRuntimeExecutionExceptionOrError(Throwable r10) {
        if ((r10 instanceof Error) == false) goto L7;
        throw new ExecutionError((Error) r10);
    L7:
        throw new UncheckedExecutionException(r10);
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    @CanIgnoreReturnValue
    public <T> T callUninterruptiblyWithTimeout(Callable<T> r10, long r11, TimeUnit r12) throws TimeoutException, ExecutionException {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r12);
        checkPositiveTimeout(r11);
        Future<T> r13 = this.executor.submit(r10);
        return (T) Uninterruptibles.getUninterruptibly(r13, r11, r12);
    L5:
        e = move-exception;
        wrapAndThrowExecutionExceptionOrError(e.getCause());
        throw new AssertionError();
    L8:
        e = move-exception;
        r13.cancel(true);
        throw e;
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public <T> T newProxy(final T r10, Class<T> r11, final long r12, final TimeUnit r14) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        Preconditions.checkNotNull(r14);
        checkPositiveTimeout(r12);
        Preconditions.checkArgument(r11.isInterface(), "interfaceType must be an interface type");
        final Set<Method> r13 = findInterruptibleMethods(r11);
        return (T) newProxy(r11, new AnonymousClass1(this, r10, r12, r14, r13));
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public void runUninterruptiblyWithTimeout(Runnable r10, long r11, TimeUnit r12) throws TimeoutException {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r12);
        checkPositiveTimeout(r11);
        Future<?> r13 = this.executor.submit(r10);
        Uninterruptibles.getUninterruptibly(r13, r11, r12);     // Catch: ExecutionException -> L5 TimeoutException -> L8
        return;
    L5:
        e = move-exception;
        wrapAndThrowRuntimeExecutionExceptionOrError(e.getCause());
        throw new AssertionError();
    L8:
        e = move-exception;
        r13.cancel(true);
        throw e;
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public void runWithTimeout(Runnable r10, long r11, TimeUnit r12) throws TimeoutException, InterruptedException {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r12);
        checkPositiveTimeout(r11);
        Future<?> r13 = this.executor.submit(r10);
        r13.get(r11, r12);     // Catch: ExecutionException -> L5 Throwable -> L8
        return;
    L8:
        e = move-exception;
        r13.cancel(true);
        throw e;
    L5:
        e = move-exception;
        wrapAndThrowRuntimeExecutionExceptionOrError(e.getCause());
        throw new AssertionError();
    }

    private static <T> T newProxy(Class<T> r10, InvocationHandler r11) {
        return r10.cast(Proxy.newProxyInstance(r10.getClassLoader(), new Class[]{r10}, r11));
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    @CanIgnoreReturnValue
    public <T> T callWithTimeout(Callable<T> r10, long r11, TimeUnit r12) throws TimeoutException, InterruptedException, ExecutionException {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r12);
        checkPositiveTimeout(r11);
        Future<T> r13 = this.executor.submit(r10);
        return r13.get(r11, r12);
    L8:
        e = move-exception;
        r13.cancel(true);
        throw e;
    L5:
        e = move-exception;
        wrapAndThrowExecutionExceptionOrError(e.getCause());
        throw new AssertionError();
    }
}
