package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public interface FutureCallback<V> {
    void onFailure(Throwable r10);

    void onSuccess(@NullableDecl V r10);
}
