package com.bytedance.android.shopping.store.tabkit;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class l<T> implements Comparator<T> {
    public l() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(((com.bytedance.android.shopping.store.tabkit.model.i) r100).c(), ((com.bytedance.android.shopping.store.tabkit.model.i) r101).c());
    }
}
