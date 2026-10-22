package com.bytedance.android.livesdk.floatview.inner;

import java.util.Comparator;
import kotlin.Pair;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class a<T> implements Comparator<T> {
    public a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues((Integer) ((Pair) r101).getSecond(), (Integer) ((Pair) r100).getSecond());
    }
}
