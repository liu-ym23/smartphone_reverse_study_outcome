package com.bytedance.android.live.v3;

import com.bytedance.android.live.strategy.api.CombineInfo;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes7.dex */
public final class a<T> implements Comparator<T> {
    public a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(((CombineInfo) r101).getPriority(), ((CombineInfo) r100).getPriority());
    }
}
