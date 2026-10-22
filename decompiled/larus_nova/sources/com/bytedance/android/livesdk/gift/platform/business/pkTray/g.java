package com.bytedance.android.livesdk.gift.platform.business.pkTray;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class g<T> implements Comparator<T> {
    public g() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(((d) r101).f130040a), Integer.valueOf(((d) r100).f130040a));
    }
}
