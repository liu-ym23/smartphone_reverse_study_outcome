package androidx.camera.core.impl.utils.futures;

import androidx.arch.core.util.Function;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public class FutureChain<V> implements ListenableFuture<V> {
    CallbackToFutureAdapter.Completer<V> mCompleter;
    private final ListenableFuture<V> mDelegate;

    @Override // java.util.concurrent.Future
    public V get() throws InterruptedException, ExecutionException {
        return this.mDelegate.get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.mDelegate.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.mDelegate.isDone();
    }

    public FutureChain() {
        this.mDelegate = CallbackToFutureAdapter.getFuture(new AnonymousClass1(this));
    }

    public FutureChain(ListenableFuture<V> r100) {
        this.mDelegate = (ListenableFuture) Preconditions.checkNotNull(r100);
    }

    public static <V> FutureChain<V> from(ListenableFuture<V> r100) {
        if ((r100 instanceof FutureChain) == false) goto L6;
        return (FutureChain) r100;
    L6:
        return new FutureChain(r100);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean r100) {
        return this.mDelegate.cancel(r100);
    }

    boolean set(V r100) {
        CallbackToFutureAdapter.Completer<V> r101 = this.mCompleter;
        if (r101 != null) goto L5;
        return false;
    L5:
        return r101.set(r100);
    }

    boolean setException(Throwable r100) {
        CallbackToFutureAdapter.Completer<V> r101 = this.mCompleter;
        if (r101 != null) goto L5;
        return false;
    L5:
        return r101.setException(r100);
    }

    public final void addCallback(FutureCallback<? super V> r100, Executor r101) {
        Futures.addCallback(this, r100, r101);
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable r100, Executor r101) {
        this.mDelegate.addListener(r100, r101);
    }

    @Override // java.util.concurrent.Future
    public V get(long r100, TimeUnit r101) throws InterruptedException, ExecutionException, TimeoutException {
        return this.mDelegate.get(r100, r101);
    }

    public final <T> FutureChain<T> transform(Function<? super V, T> r100, Executor r101) {
        return (FutureChain) Futures.transform(this, r100, r101);
    }

    public final <T> FutureChain<T> transformAsync(AsyncFunction<? super V, T> r100, Executor r101) {
        return (FutureChain) Futures.transformAsync(this, r100, r101);
    }
}
