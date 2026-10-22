package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
interface LongAddable {
    void add(long r10);

    void increment();

    long sum();
}
