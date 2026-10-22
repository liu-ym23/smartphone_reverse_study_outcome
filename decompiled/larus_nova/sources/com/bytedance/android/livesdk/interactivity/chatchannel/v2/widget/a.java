package com.bytedance.android.livesdk.interactivity.chatchannel.v2.widget;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class a<T> implements Comparator<T> {
    public a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(((p62.a) r101).f527875j), Long.valueOf(((p62.a) r100).f527875j));
    }
}
