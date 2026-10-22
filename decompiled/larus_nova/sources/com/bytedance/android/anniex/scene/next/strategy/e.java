package com.bytedance.android.anniex.scene.next.strategy;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class e<T> implements Comparator<T> {
    public e() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Double.valueOf(((xa.c) r101).f563025b), Double.valueOf(((xa.c) r100).f563025b));
    }
}
