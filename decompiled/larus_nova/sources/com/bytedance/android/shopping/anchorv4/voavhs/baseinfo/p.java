package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class p<T> implements Comparator<T> {
    public p() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(((w.b) r100).f167991a), Integer.valueOf(((w.b) r101).f167991a));
    }
}
