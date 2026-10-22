package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public interface Weigher<K, V> {
    int weigh(K r10, V r11);
}
