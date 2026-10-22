package com.bytedance.ai.applet.grantingV2;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class u<T> implements Comparator {
    public u() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(((u2.f) r100).d()), Integer.valueOf(((u2.f) r101).d()));
    }
}
