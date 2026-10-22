package androidx.camera.core.impl.utils.futures;

import androidx.arch.core.util.Function;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes2.dex */
public final class Futures {
    private static final Function<?, ?> IDENTITY_FUNCTION = null;

    public static final class CallbackListener<V> implements Runnable {
        final FutureCallback<? super V> mCallback;
        final Future<V> mFuture;

        @Override // java.lang.Runnable
        public void run() {
            androidx_camera_core_impl_utils_futures_Futures$CallbackListener_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void androidx_camera_core_impl_utils_futures_Futures$CallbackListener__run$___twin___() {
            Object r100 = Futures.getDone(this.mFuture);     // Catch: Error -> L5 RuntimeException -> L7 ExecutionException -> L10
            this.mCallback.onSuccess(r100);
            return;
        L5:
            e = e;
        L8:
            this.mCallback.onFailure(e);
            return;
        L7:
            e = e;
        L10:
            e = move-exception;
            Throwable r101 = e.getCause();
            if (r101 != null) goto L14;
            this.mCallback.onFailure(e);
            return;
        L14:
            this.mCallback.onFailure(r101);
        }

        public String toString() {
            return CallbackListener.class.getSimpleName() + "," + this.mCallback;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void androidx_camera_core_impl_utils_futures_Futures$CallbackListener_com_larus_apm_impl_protector_RunnableLancet_run(CallbackListener r100) {
            r100.androidx_camera_core_impl_utils_futures_Futures$CallbackListener__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public CallbackListener(Future<V> r100, FutureCallback<? super V> r101) {
            this.mFuture = r100;
            this.mCallback = r101;
        }
    }

    private Futures() {
    }

    public static /* synthetic */ Object a(ListenableFuture r100, ScheduledExecutorService r101, long r102, CallbackToFutureAdapter.Completer r103) {
        return lambda$makeTimeoutFuture$3(r100, r101, r102, r103);
    }

    public static /* synthetic */ Object b(ListenableFuture r100, CallbackToFutureAdapter.Completer r101) {
        return lambda$nonCancellationPropagating$0(r100, r101);
    }

    public static /* synthetic */ Object c(ListenableFuture r100, CallbackToFutureAdapter.Completer r101) {
        return lambda$transformAsyncOnCompletion$8(r100, r101);
    }

    public static /* synthetic */ void d(CallbackToFutureAdapter.Completer r100, Object r101, boolean r102, ListenableFuture r103) {
        lambda$makeTimeoutFuture$4(r100, r101, r102, r103);
    }

    public static /* synthetic */ void e(CallbackToFutureAdapter.Completer r100) {
        lambda$transformAsyncOnCompletion$7(r100);
    }

    public static /* synthetic */ void f(ScheduledFuture r100) {
        lambda$makeTimeoutFuture$5(r100);
    }

    public static /* synthetic */ Object g(ListenableFuture r100, ScheduledExecutorService r101, Object r102, boolean r103, long r104, CallbackToFutureAdapter.Completer r105) {
        return lambda$makeTimeoutFuture$6(r100, r101, r102, r103, r104, r105);
    }

    public static /* synthetic */ Boolean h(CallbackToFutureAdapter.Completer r100, ListenableFuture r101, long r102) {
        return lambda$makeTimeoutFuture$1(r100, r101, r102);
    }

    public static /* synthetic */ void i(ScheduledFuture r100) {
        lambda$makeTimeoutFuture$2(r100);
    }

    static {
        IDENTITY_FUNCTION = new AnonymousClass2();
    }

    public static <V> ListenableFuture<List<V>> allAsList(Collection<? extends ListenableFuture<? extends V>> r100) {
        return new ListFuture(new ArrayList(r100), true, CameraXExecutors.directExecutor());
    }

    public static <V> V getDone(Future<V> r100) throws ExecutionException {
        Preconditions.checkState(r100.isDone(), "Future was expected to be done, " + r100);
        return (V) getUninterruptibly(r100);
    }

    public static <V> V getUninterruptibly(Future<V> r100) throws ExecutionException {
        boolean r101 = false;
    L12:
        V r102 = r100.get();     // Catch: Throwable -> L7 InterruptedException -> L11
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

    public static <V> ListenableFuture<V> immediateFailedFuture(Throwable r100) {
        return new ImmediateFuture.ImmediateFailedFuture(r100);
    }

    public static <V> ScheduledFuture<V> immediateFailedScheduledFuture(Throwable r100) {
        return new ImmediateFuture.ImmediateFailedScheduledFuture(r100);
    }

    public static <V> ListenableFuture<V> immediateFuture(V r100) {
        if (r100 != null) goto L6;
        return ImmediateFuture.nullFuture();
    L6:
        return new ImmediateFuture.ImmediateSuccessfulFuture(r100);
    }

    private static /* synthetic */ void lambda$makeTimeoutFuture$2(ScheduledFuture r100) {
        r100.cancel(true);
    }

    private static /* synthetic */ void lambda$makeTimeoutFuture$5(ScheduledFuture r100) {
        r100.cancel(true);
    }

    private static /* synthetic */ void lambda$transformAsyncOnCompletion$7(CallbackToFutureAdapter.Completer r100) {
        r100.set(null);
    }

    public static <V> ListenableFuture<V> nonCancellationPropagating(final ListenableFuture<V> r100) {
        Preconditions.checkNotNull(r100);
        if (r100.isDone() == false) goto L6;
        return r100;
    L6:
        return CallbackToFutureAdapter.getFuture(new g(r100));
    }

    public static <V> ListenableFuture<List<V>> successfulAsList(Collection<? extends ListenableFuture<? extends V>> r100) {
        return new ListFuture(new ArrayList(r100), false, CameraXExecutors.directExecutor());
    }

    public static <V> ListenableFuture<Void> transformAsyncOnCompletion(final ListenableFuture<V> r100) {
        return CallbackToFutureAdapter.getFuture(new e(r100));
    }

    private static /* synthetic */ Object lambda$nonCancellationPropagating$0(ListenableFuture r100, CallbackToFutureAdapter.Completer r101) throws Exception {
        propagateTransform(false, r100, IDENTITY_FUNCTION, r101, CameraXExecutors.directExecutor());
        return "nonCancellationPropagating[" + r100 + "]";
    }

    private static /* synthetic */ Object lambda$transformAsyncOnCompletion$8(ListenableFuture r100, final CallbackToFutureAdapter.Completer r101) throws Exception {
        r100.addListener(new c(r101), CameraXExecutors.directExecutor());
        return "transformVoidFuture [" + r100 + "]";
    }

    public static <V> void propagate(ListenableFuture<V> r100, CallbackToFutureAdapter.Completer<V> r101) {
        propagateTransform(r100, IDENTITY_FUNCTION, r101, CameraXExecutors.directExecutor());
    }

    public static <V> void addCallback(ListenableFuture<V> r100, FutureCallback<? super V> r101, Executor r102) {
        Preconditions.checkNotNull(r101);
        r100.addListener(new CallbackListener(r100, r101), r102);
    }

    private static /* synthetic */ Boolean lambda$makeTimeoutFuture$1(CallbackToFutureAdapter.Completer r100, ListenableFuture r101, long r102) throws Exception {
        return Boolean.valueOf(r100.setException(new TimeoutException("Future[" + r101 + "] is not done within " + r102 + " ms.")));
    }

    public static <V> ListenableFuture<V> makeTimeoutFuture(final long r100, final ScheduledExecutorService r101, final ListenableFuture<V> r102) {
        return CallbackToFutureAdapter.getFuture(new d(r102, r101, r100));
    }

    public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> r100, final Function<? super I, ? extends O> r101, Executor r102) {
        Preconditions.checkNotNull(r101);
        return transformAsync(r100, new AnonymousClass1(r101), r102);
    }

    public static <I, O> ListenableFuture<O> transformAsync(ListenableFuture<I> r100, AsyncFunction<? super I, ? extends O> r101, Executor r102) {
        ChainingListenableFuture r103 = new ChainingListenableFuture(r101, r100);
        r100.addListener(r103, r102);
        return r103;
    }

    private static /* synthetic */ Object lambda$makeTimeoutFuture$3(final ListenableFuture r100, ScheduledExecutorService r101, final long r102, final CallbackToFutureAdapter.Completer r103) throws Exception {
        propagate(r100, r103);
        if (r100.isDone() == true) goto L6;
        final ScheduledFuture r104 = r101.schedule(new a(r103, r100, r102), r102, TimeUnit.MILLISECONDS);
        r100.addListener(new b(r104), CameraXExecutors.directExecutor());
    L6:
        return "TimeoutFuture[" + r100 + "]";
    }

    private static /* synthetic */ void lambda$makeTimeoutFuture$4(CallbackToFutureAdapter.Completer r100, Object r101, boolean r102, ListenableFuture r103) {
        r100.set(r101);
        if (r102 == false) goto L6;
        r103.cancel(true);
        return;
    }

    public static <I, O> void propagateTransform(ListenableFuture<I> r100, Function<? super I, ? extends O> r101, CallbackToFutureAdapter.Completer<O> r102, Executor r103) {
        propagateTransform(true, r100, r101, r102, r103);
    }

    public static <V> ListenableFuture<V> makeTimeoutFuture(final long r100, final ScheduledExecutorService r110, final V r111, final boolean r112, final ListenableFuture<V> r113) {
        return CallbackToFutureAdapter.getFuture(new f(r113, r110, r111, r112, r100));
    }

    private static <I, O> void propagateTransform(boolean r100, final ListenableFuture<I> r101, final Function<? super I, ? extends O> r102, final CallbackToFutureAdapter.Completer<O> r103, Executor r104) {
        Preconditions.checkNotNull(r101);
        Preconditions.checkNotNull(r102);
        Preconditions.checkNotNull(r103);
        Preconditions.checkNotNull(r104);
        addCallback(r101, new AnonymousClass3(r103, r102), r104);
        if (r100 == false) goto L6;
        r103.addCancellationListener(new AnonymousClass4(r101), CameraXExecutors.directExecutor());
        return;
    }

    private static /* synthetic */ Object lambda$makeTimeoutFuture$6(final ListenableFuture r100, ScheduledExecutorService r101, final Object r102, final boolean r103, long r104, final CallbackToFutureAdapter.Completer r105) throws Exception {
        propagate(r100, r105);
        if (r100.isDone() == true) goto L6;
        final ScheduledFuture<?> r106 = r101.schedule(new h(r105, r102, r103, r100), r104, TimeUnit.MILLISECONDS);
        r100.addListener(new i(r106), CameraXExecutors.directExecutor());
    L6:
        return "TimeoutFuture[" + r100 + "]";
    }
}
