package com.bytedance.android.shopping.anchorv4.video;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes12.dex */
public final class b<T> implements Comparator<T> {
    public b() {
    }

    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(((e) r100).d(), ((e) r101).d());
    }
}
