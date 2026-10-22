package com.bytedance.android.live.liveinteract.enlarge.dialog;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes46.dex */
public final class f<T> implements Comparator<T> {
    public f() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(((ch0.e) r101).f23724a.getFanTicket()), Long.valueOf(((ch0.e) r100).f23724a.getFanTicket()));
    }
}
