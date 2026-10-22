package com.bytedance.android.anniex.scene.next.strategy;

import java.util.Comparator;
import kotlin.Pair;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class b<T> implements Comparator<T> {
    public b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues((Double) ((Pair) r101).getSecond(), (Double) ((Pair) r100).getSecond());
    }
}
