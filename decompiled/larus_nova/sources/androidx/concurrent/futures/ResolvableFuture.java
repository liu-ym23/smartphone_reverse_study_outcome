package androidx.concurrent.futures;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes6.dex */
public final class ResolvableFuture<V> extends AbstractResolvableFuture<V> {
    public static <V> ResolvableFuture<V> create() {
        return new ResolvableFuture();
    }

    private ResolvableFuture() {
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    public boolean set(V r100) {
        return super.set(r100);
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    public boolean setException(Throwable r100) {
        return super.setException(r100);
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    public boolean setFuture(ListenableFuture<? extends V> r100) {
        return super.setFuture(r100);
    }
}
