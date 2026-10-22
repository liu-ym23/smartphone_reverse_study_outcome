package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.Sets;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public final class SimpleTimeLimiter implements TimeLimiter {
    private final ExecutorService executor;

    static /* synthetic */ Exception access$000(Exception r0, boolean r1) throws Exception {
        return throwCause(r0, r1);
    }

    public SimpleTimeLimiter(ExecutorService r1) {
        this.executor = (ExecutorService) Preconditions.checkNotNull(r1);
    }

    public SimpleTimeLimiter() {
        this(Executors.newCachedThreadPool());
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public <T> T newProxy(final T r10, Class<T> r11, final long r12, final TimeUnit r14) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        Preconditions.checkNotNull(r14);
        if (r12 <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "bad timeout: %s", new Object[]{Long.valueOf(r12)});
        Preconditions.checkArgument(r11.isInterface(), "interfaceType must be an interface type");
        final Set<Method> r8 = findInterruptibleMethods(r11);
        return (T) newProxy(r11, new AnonymousClass1(this, r10, r12, r14, r8));
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public <T> T callWithTimeout(Callable<T> r6, long r7, TimeUnit r9, boolean r10) throws Exception {
        Preconditions.checkNotNull(r6);
        Preconditions.checkNotNull(r9);
        if (r7 <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "timeout must be positive: %s", new Object[]{Long.valueOf(r7)});
        Future<T> r5 = this.executor.submit(r6);
        if (r10 == false) goto L14;
        return r5.get(r7, r9);
    L10:
        e = move-exception;
        r5.cancel(true);     // Catch: TimeoutException -> L15 ExecutionException -> L18
        throw e;     // Catch: TimeoutException -> L15 ExecutionException -> L18
    L14:
        return (T) Uninterruptibles.getUninterruptibly(r5, r7, r9);
    L18:
        e = move-exception;
        throw throwCause(e, true);
    L15:
        e = move-exception;
        r5.cancel(true);
        throw new UncheckedTimeoutException(e);
    L5:
        r0 = false;
        goto L6
    }

    private static Exception throwCause(Exception r3, boolean r4) throws Exception {
        Throwable r0 = r3.getCause();
        if (r0 == null) goto L15;
        if (r4 == false) goto L7;
        r0.setStackTrace((StackTraceElement[]) ObjectArrays.concat(r0.getStackTrace(), r3.getStackTrace(), StackTraceElement.class));
    L7:
        if ((r0 instanceof Exception) == true) goto L14;
        if ((r0 instanceof Error) == true) goto L11;
        throw r3;
    L11:
        throw ((Error) r0);
    L14:
        throw ((Exception) r0);
    L15:
        throw r3;
    }

    private static Set<Method> findInterruptibleMethods(Class<?> r5) {
        HashSet r0 = Sets.newHashSet();
        Method[] r6 = r5.getMethods();
        int r1 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        Method r3 = r6[r2];
        if (declaresInterruptedEx(r3) == false) goto L7;
        r0.add(r3);
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        return r0;
    }

    private static boolean declaresInterruptedEx(Method r5) {
        Class<?>[] r6 = r5.getExceptionTypes();
        int r0 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (r6[r2] == InterruptedException.class) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private static <T> T newProxy(Class<T> r3, InvocationHandler r4) {
        return r3.cast(Proxy.newProxyInstance(r3.getClassLoader(), new Class[]{r3}, r4));
    }
}
