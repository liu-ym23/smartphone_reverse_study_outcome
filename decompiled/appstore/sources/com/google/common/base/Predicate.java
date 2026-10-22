package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public interface Predicate<T> {
    @CanIgnoreReturnValue
    boolean apply(@NullableDecl T r10);

    boolean equals(@NullableDecl Object r10);
}
