package androidx.camera.core.impl.utils.futures;

import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes2.dex */
class ChainingListenableFuture<I, O> extends FutureChain<O> implements Runnable {
    private AsyncFunction<? super I, ? extends O> mFunction;
    private ListenableFuture<? extends I> mInputFuture;
    private final BlockingQueue<Boolean> mMayInterruptIfRunningChannel;
    private final CountDownLatch mOutputCreated;
    volatile ListenableFuture<? extends O> mOutputFuture;

    public void androidx_camera_core_impl_utils_futures_ChainingListenableFuture__run$___twin___() {
        Object r100 = Futures.getUninterruptibly(this.mInputFuture);     // Catch: Throwable -> L10 Error -> L12 Exception -> L14 UndeclaredThrowableException -> L16 ExecutionException -> L18 CancellationException -> L20
        final ListenableFuture<? extends O> r101 = this.mFunction.apply(r100);     // Catch: Throwable -> L10 Error -> L12 Exception -> L14 UndeclaredThrowableException -> L16
        this.mOutputFuture = r101;     // Catch: Throwable -> L10 Error -> L12 Exception -> L14 UndeclaredThrowableException -> L16
        if (isCancelled() == false) goto L9;
        r101.cancel(((Boolean) takeUninterruptibly(this.mMayInterruptIfRunningChannel)).booleanValue());     // Catch: Throwable -> L10 Error -> L12 Exception -> L14 UndeclaredThrowableException -> L16
        this.mOutputFuture = null;     // Catch: Throwable -> L10 Error -> L12 Exception -> L14 UndeclaredThrowableException -> L16
    L7:
        this.mFunction = null;
        this.mInputFuture = null;
        this.mOutputCreated.countDown();
        return;
    L9:
        r101.addListener(new AnonymousClass1(this, r101), CameraXExecutors.directExecutor());     // Catch: Throwable -> L10 Error -> L12 Exception -> L14 UndeclaredThrowableException -> L16
    L24:
        this.mFunction = null;
        this.mInputFuture = null;
        this.mOutputCreated.countDown();
        return;
    L20:
        cancel(false);     // Catch: Throwable -> L10 Error -> L12 Exception -> L14 UndeclaredThrowableException -> L16
    L18:
        e = move-exception;
        setException(e.getCause());     // Catch: Throwable -> L10 Error -> L12 Exception -> L14 UndeclaredThrowableException -> L16
    L12:
        e = move-exception;
        setException(e);     // Catch: Throwable -> L10
    L16:
        e = move-exception;
        setException(e.getCause());     // Catch: Throwable -> L10
    L14:
        e = move-exception;
        setException(e);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mFunction = null;
        this.mInputFuture = null;
        this.mOutputCreated.countDown();
        throw th;
    }

    @Override // java.lang.Runnable
    public void run() {
        androidx_camera_core_impl_utils_futures_ChainingListenableFuture_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    @Override // androidx.camera.core.impl.utils.futures.FutureChain, java.util.concurrent.Future
    public O get() throws InterruptedException, ExecutionException {
        if (isDone() == true) goto L11;
        ListenableFuture<? extends I> r100 = this.mInputFuture;
        if (r100 == null) goto L7;
        r100.get();
    L7:
        this.mOutputCreated.await();
        ListenableFuture<? extends O> r101 = this.mOutputFuture;
        if (r101 == null) goto L11;
        r101.get();
    L11:
        return (O) super.get();
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void androidx_camera_core_impl_utils_futures_ChainingListenableFuture_com_larus_apm_impl_protector_RunnableLancet_run(ChainingListenableFuture r100) {
        r100.androidx_camera_core_impl_utils_futures_ChainingListenableFuture__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    private <E> E takeUninterruptibly(BlockingQueue<E> r100) {
        boolean r101 = false;
    L12:
        E r102 = r100.take();     // Catch: Throwable -> L7 InterruptedException -> L11
    L4:
        if (r101 == false) goto L6;
        ThreadMethodProxy.currentThread().interrupt();
    L6:
        return r102;
    L11:
        r101 = true;
    L7:
        th = move-exception;
        if (r101 == false) goto L10;
        ThreadMethodProxy.currentThread().interrupt();
    L10:
        throw th;
    }

    @Override // androidx.camera.core.impl.utils.futures.FutureChain, java.util.concurrent.Future
    public boolean cancel(boolean r100) {
        if (super.cancel(r100) == false) goto L6;
        putUninterruptibly(this.mMayInterruptIfRunningChannel, Boolean.valueOf(r100));
        cancel(this.mInputFuture, r100);
        cancel(this.mOutputFuture, r100);
        return true;
    L6:
        return false;
    }

    public ChainingListenableFuture(AsyncFunction<? super I, ? extends O> r100, ListenableFuture<? extends I> r101) {
        this.mMayInterruptIfRunningChannel = new LinkedBlockingQueue(1);
        this.mOutputCreated = new CountDownLatch(1);
        this.mFunction = (AsyncFunction) Preconditions.checkNotNull(r100);
        this.mInputFuture = (ListenableFuture) Preconditions.checkNotNull(r101);
    }

    private void cancel(Future<?> r100, boolean r101) {
        if (r100 == null) goto L5;
        r100.cancel(r101);
        return;
    }

    private <E> void putUninterruptibly(BlockingQueue<E> r100, E r101) {
        boolean r102 = false;
    L12:
        r100.put(r101);     // Catch: Throwable -> L7 InterruptedException -> L11
    L4:
        if (r102 == false) goto L15;
        ThreadMethodProxy.currentThread().interrupt();
        return;
    L15:
        return;
    L11:
        r102 = true;
    L7:
        th = move-exception;
        if (r102 == false) goto L10;
        ThreadMethodProxy.currentThread().interrupt();
    L10:
        throw th;
    }

    @Override // androidx.camera.core.impl.utils.futures.FutureChain, java.util.concurrent.Future
    public O get(long r100, TimeUnit r110) throws TimeoutException, ExecutionException, InterruptedException {
        if (isDone() == true) goto L18;
        TimeUnit r101 = TimeUnit.NANOSECONDS;
        if (r110 == r101) goto L7;
        r100 = r101.convert(r100, r110);
        r110 = r101;
    L7:
        ListenableFuture<? extends I> r102 = this.mInputFuture;
        if (r102 == null) goto L10;
        long r103 = System.nanoTime();
        r102.get(r100, r110);
        r100 = r100 - Math.max(0, System.nanoTime() - r103);
    L10:
        long r104 = System.nanoTime();
        if (this.mOutputCreated.await(r100, r110) == false) goto L16;
        r100 = r100 - Math.max(0, System.nanoTime() - r104);
        ListenableFuture<? extends O> r105 = this.mOutputFuture;
        if (r105 == null) goto L18;
        r105.get(r100, r110);
        goto L18
    L16:
        throw new TimeoutException();
    L18:
        return (O) super.get(r100, r110);
    }
}
