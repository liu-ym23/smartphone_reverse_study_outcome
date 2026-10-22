package io.reactivex.internal.fuseable;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface SimpleQueue<T> {
    void clear();

    boolean isEmpty();

    boolean offer(@NonNull T r10);

    boolean offer(@NonNull T r10, @NonNull T r11);

    @Nullable
    T poll() throws Exception;
}
