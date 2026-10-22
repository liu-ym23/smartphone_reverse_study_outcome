package com.bytedance.android.shopping.deepfeed.slice.action;

import java.util.Comparator;
import kotlin.Triple;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class l<T> implements Comparator<T> {
    public l() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues((Integer) ((Triple) r100).getFirst(), (Integer) ((Triple) r101).getFirst());
    }
}
