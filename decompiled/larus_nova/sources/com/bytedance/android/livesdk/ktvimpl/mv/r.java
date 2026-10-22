package com.bytedance.android.livesdk.ktvimpl.mv;

import java.io.File;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class r<T> implements Comparator<T> {
    public r() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(((File) r101).lastModified()), Long.valueOf(((File) r100).lastModified()));
    }
}
