package androidx.camera.core.impl.utils.futures;

import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
class ListFuture<V> implements ListenableFuture<List<V>> {
    private final boolean mAllMustSucceed;
    List<? extends ListenableFuture<? extends V>> mFutures;
    private final AtomicInteger mRemaining;
    private final ListenableFuture<List<V>> mResult;
    CallbackToFutureAdapter.Completer<List<V>> mResultNotifier;
    List<V> mValues;

    private void callAllGets() throws InterruptedException {
        List<? extends ListenableFuture<? extends V>> r100 = this.mFutures;
        if (r100 != null) goto L5;
        return;
    L5:
        if (isDone() == true) goto L30;
        Iterator<? extends ListenableFuture<? extends V>> r101 = r100.iterator();
    L8:
        if (r101.hasNext() == false) goto L31;
        ListenableFuture<? extends V> r102 = r101.next();
    L11:
        if (r102.isDone() == true) goto L8;
        r102.get();     // Catch: Throwable -> L14 InterruptedException -> L17 Error -> L19
    L19:
        e = move-exception;
        throw e;
    L17:
        e = move-exception;
        throw e;
    L15:
        if (this.mAllMustSucceed == false) goto L11;
        return;
    L31:
        return;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.mResult.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.mResult.isDone();
    }

    @Override // java.util.concurrent.Future
    public List<V> get() throws InterruptedException, ExecutionException {
        callAllGets();
        return this.mResult.get();
    }

    @Override // java.util.concurrent.Future
    public /* bridge */ /* synthetic */ Object get() throws ExecutionException, InterruptedException {
        return get();
    }

    private void init(Executor r100) {
        addListener(new AnonymousClass2(this), CameraXExecutors.directExecutor());
        if (this.mFutures.isEmpty() == false) goto L6;
        this.mResultNotifier.set(new ArrayList(this.mValues));
        return;
    L6:
        final int r101 = 0;
        int r102 = 0;
    L8:
        if (r102 >= this.mFutures.size()) goto L10;
        this.mValues.add(null);
        r102 = r102 + 1;
        goto L8
    L10:
        List<? extends ListenableFuture<? extends V>> r103 = this.mFutures;
    L12:
        if (r101 >= r103.size()) goto L14;
        final ListenableFuture r104 = (ListenableFuture) ListProtector.get(r103, r101);
        r104.addListener(new AnonymousClass3(this, r101, r104), r100);
        r101 = r101 + 1;
        goto L12
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean r100) {
        List<? extends ListenableFuture<? extends V>> r101 = this.mFutures;
        if (r101 == null) goto L9;
        Iterator<? extends ListenableFuture<? extends V>> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L9;
        r102.next().cancel(r100);
    L9:
        return this.mResult.cancel(r100);
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable r100, Executor r101) {
        this.mResult.addListener(r100, r101);
    }

    @Override // java.util.concurrent.Future
    public List<V> get(long r100, TimeUnit r101) throws InterruptedException, ExecutionException, TimeoutException {
        return this.mResult.get(r100, r101);
    }

    public void setOneValue(int r100, Future<? extends V> r101) {
        List<V> r102 = this.mValues;
        if (isDone() == true) goto L82;
        if (r102 == null) goto L82;
        boolean r103 = true;
        Preconditions.checkState(r101.isDone(), "Tried to set value from future which is not done");     // Catch: Throwable -> L19 Error -> L21 RuntimeException -> L32 ExecutionException -> L45 CancellationException -> L58
        r102.set(r100, (V) Futures.getUninterruptibly(r101));     // Catch: Throwable -> L19 Error -> L21 RuntimeException -> L32 ExecutionException -> L45 CancellationException -> L58
        int r104 = this.mRemaining.decrementAndGet();
        if (r104 >= 0) goto L12;
        r103 = false;
    L12:
        Preconditions.checkState(r103, "Less than 0 remaining futures");
        if (r104 != 0) goto L70;
        List<V> r105 = this.mValues;
        if (r105 == null) goto L18;
        CallbackToFutureAdapter.Completer<List<V>> r106 = this.mResultNotifier;
        ArrayList r107 = new ArrayList(r105);
    L17:
        r106.set(r107);
        return;
    L18:
        Preconditions.checkState(isDone());
        return;
    L70:
        return;
    L19:
        th = move-exception;
        int r108 = this.mRemaining.decrementAndGet();
        if (r108 >= 0) goto L75;
        r103 = false;
    L75:
        Preconditions.checkState(r103, "Less than 0 remaining futures");
        if (r108 != 0) goto L81;
        List<V> r109 = this.mValues;
        if (r109 == null) goto L80;
        this.mResultNotifier.set(new ArrayList(r109));
        goto L81
    L80:
        Preconditions.checkState(isDone());
    L81:
        throw th;
    L45:
        e = move-exception;
        if (this.mAllMustSucceed == false) goto L49;
        this.mResultNotifier.setException(e.getCause());     // Catch: Throwable -> L19
    L49:
        int r110 = this.mRemaining.decrementAndGet();
        if (r110 >= 0) goto L53;
        r103 = false;
    L53:
        Preconditions.checkState(r103, "Less than 0 remaining futures");
        if (r110 != 0) goto L90;
        List<V> r111 = this.mValues;
        if (r111 == null) goto L18;
        r106 = this.mResultNotifier;
        r107 = new ArrayList(r111);
        goto L17
    L90:
        return;
    L32:
        e = move-exception;
        if (this.mAllMustSucceed == false) goto L36;
        this.mResultNotifier.setException(e);     // Catch: Throwable -> L19
    L36:
        int r112 = this.mRemaining.decrementAndGet();
        if (r112 >= 0) goto L40;
        r103 = false;
    L40:
        Preconditions.checkState(r103, "Less than 0 remaining futures");
        if (r112 != 0) goto L89;
        List<V> r113 = this.mValues;
        if (r113 == null) goto L18;
        r106 = this.mResultNotifier;
        r107 = new ArrayList(r113);
        goto L17
    L89:
        return;
    L21:
        e = move-exception;
        this.mResultNotifier.setException(e);     // Catch: Throwable -> L19
        int r114 = this.mRemaining.decrementAndGet();
        if (r114 >= 0) goto L27;
        r103 = false;
    L27:
        Preconditions.checkState(r103, "Less than 0 remaining futures");
        if (r114 != 0) goto L88;
        List<V> r115 = this.mValues;
        if (r115 == null) goto L18;
        r106 = this.mResultNotifier;
        r107 = new ArrayList(r115);
        goto L17
    L88:
        return;
    L59:
        if (this.mAllMustSucceed == false) goto L61;
        cancel(false);     // Catch: Throwable -> L19
    L61:
        int r116 = this.mRemaining.decrementAndGet();
        if (r116 >= 0) goto L65;
        r103 = false;
    L65:
        Preconditions.checkState(r103, "Less than 0 remaining futures");
        if (r116 != 0) goto L91;
        List<V> r117 = this.mValues;
        if (r117 == null) goto L18;
        r106 = this.mResultNotifier;
        r107 = new ArrayList(r117);
        goto L17
    L91:
        return;
    L82:
        Preconditions.checkState(this.mAllMustSucceed, "Future was done before all dependencies completed");
    }

    @Override // java.util.concurrent.Future
    public /* bridge */ /* synthetic */ Object get(long r100, TimeUnit r101) throws ExecutionException, InterruptedException, TimeoutException {
        return get(r100, r101);
    }

    public ListFuture(List<? extends ListenableFuture<? extends V>> r100, boolean r101, Executor r102) {
        this.mFutures = (List) Preconditions.checkNotNull(r100);
        this.mValues = new ArrayList(r100.size());
        this.mAllMustSucceed = r101;
        this.mRemaining = new AtomicInteger(r100.size());
        this.mResult = CallbackToFutureAdapter.getFuture(new AnonymousClass1(this));
        init(r102);
    }
}
