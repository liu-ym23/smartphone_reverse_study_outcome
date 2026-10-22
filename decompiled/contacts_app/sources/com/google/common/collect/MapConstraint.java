package com.google.common.collect;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface MapConstraint<K, V> {
    void checkKeyValue(@Nullable K r1, @Nullable V r2);

    String toString();
}
