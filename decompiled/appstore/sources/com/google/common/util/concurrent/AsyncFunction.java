package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public interface AsyncFunction<I, O> {
    ListenableFuture<O> apply(@NullableDecl I r10) throws Exception;
}
