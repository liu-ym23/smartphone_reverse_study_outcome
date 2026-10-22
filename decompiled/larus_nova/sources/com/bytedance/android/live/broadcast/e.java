package com.bytedance.android.live.broadcast;

import com.bytedance.android.livesdkapi.depend.model.broadcast.CommonBubble;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class e<T> implements Comparator<T> {
    public e() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(((CommonBubble) r100).getPriority()), Long.valueOf(((CommonBubble) r101).getPriority()));
    }
}
