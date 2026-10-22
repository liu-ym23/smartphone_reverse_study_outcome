package com.bytedance.android.annie.debug.ui;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class h<T> implements Comparator<T> {
    public h() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(((g) r100).f39472c, ((g) r101).f39472c);
    }
}
