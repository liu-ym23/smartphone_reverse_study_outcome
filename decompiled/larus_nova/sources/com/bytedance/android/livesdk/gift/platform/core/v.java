package com.bytedance.android.livesdk.gift.platform.core;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class v<T> implements Comparator<T> {
    public v() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(((j) r100).f130722c), Integer.valueOf(((j) r101).f130722c));
    }
}
