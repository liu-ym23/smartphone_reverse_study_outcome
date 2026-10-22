package com.bytedance.android.live.liveinteract.videotalk.avatarmix;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes46.dex */
public final class b<T> implements Comparator<T> {
    public b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(((d) r100).f79075a, ((d) r101).f79075a);
    }
}
