package com.bytedance.android.ec.window.base.common.bubble;

import java.util.Comparator;
import kotlin.Pair;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class c<T> implements Comparator<T> {
    public c() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues((t) ((Pair) r100).getFirst(), (t) ((Pair) r101).getFirst());
    }
}
