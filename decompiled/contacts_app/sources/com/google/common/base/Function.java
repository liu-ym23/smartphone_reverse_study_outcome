package com.google.common.base;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface Function<F, T> {
    @Nullable
    T apply(@Nullable F r1);

    boolean equals(@Nullable Object r1);
}
