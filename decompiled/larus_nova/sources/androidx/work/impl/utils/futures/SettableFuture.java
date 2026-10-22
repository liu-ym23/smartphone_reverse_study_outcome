package androidx.work.impl.utils.futures;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes28.dex */
public final class SettableFuture<V> extends AbstractFuture<V> {
    public static <V> SettableFuture<V> create() {
        return new SettableFuture();
    }

    private SettableFuture() {
    }

    @Override // androidx.work.impl.utils.futures.AbstractFuture
    public boolean set(V r100) {
        return super.set(r100);
    }

    @Override // androidx.work.impl.utils.futures.AbstractFuture
    public boolean setException(Throwable r100) {
        return super.setException(r100);
    }

    @Override // androidx.work.impl.utils.futures.AbstractFuture
    public boolean setFuture(ListenableFuture<? extends V> r100) {
        return super.setFuture(r100);
    }
}
