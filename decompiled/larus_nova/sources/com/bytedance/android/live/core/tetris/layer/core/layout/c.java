package com.bytedance.android.live.core.tetris.layer.core.layout;

import java.util.Comparator;
import kotlin.Pair;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class c<T> implements Comparator<T> {
    public c() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues((Integer) ((Pair) r100).getSecond(), (Integer) ((Pair) r101).getSecond());
    }
}
