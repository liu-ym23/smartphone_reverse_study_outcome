package com.google.common.util.concurrent;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface FutureCallback<V> {
    void onFailure(Throwable r1);

    void onSuccess(@Nullable V r1);
}
