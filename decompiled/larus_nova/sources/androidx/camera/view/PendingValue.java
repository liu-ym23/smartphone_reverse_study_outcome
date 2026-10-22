package androidx.camera.view;

import androidx.arch.core.util.Function;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Pair;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
class PendingValue<T> {
    private Pair<CallbackToFutureAdapter.Completer<Void>, T> mCompleterAndValue;

    public PendingValue() {
    }

    public static /* synthetic */ Object a(PendingValue r100, Object r101, CallbackToFutureAdapter.Completer r102) {
        return r100.lambda$setValue$0(r101, r102);
    }

    public void propagateIfHasValue(Function<T, ListenableFuture<Void>> r100) {
        Threads.checkMainThread();
        Pair<CallbackToFutureAdapter.Completer<Void>, T> r101 = this.mCompleterAndValue;
        if (r101 == null) goto L6;
        ListenableFuture<Void> r102 = r100.apply(r101.second);
        CallbackToFutureAdapter.Completer<Void> r103 = this.mCompleterAndValue.first;
        Objects.requireNonNull(r103);
        Futures.propagate(r102, r103);
        this.mCompleterAndValue = null;
        return;
    }

    public ListenableFuture<Void> setValue(final T r100) {
        Threads.checkMainThread();
        return CallbackToFutureAdapter.getFuture(new k(this, r100));
    }

    private /* synthetic */ Object lambda$setValue$0(Object r100, CallbackToFutureAdapter.Completer r101) throws Exception {
        Pair<CallbackToFutureAdapter.Completer<Void>, T> r102 = this.mCompleterAndValue;
        if (r102 == null) goto L5;
        CallbackToFutureAdapter.Completer<Void> r103 = r102.first;
        Objects.requireNonNull(r103);
        r103.setCancelled();
    L5:
        this.mCompleterAndValue = new Pair(r101, r100);
        return "PendingValue " + r100;
    }
}
