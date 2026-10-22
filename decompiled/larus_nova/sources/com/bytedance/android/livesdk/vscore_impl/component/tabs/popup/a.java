package com.bytedance.android.livesdk.vscore_impl.component.tabs.popup;

import com.bytedance.android.livesdkapi.depend.model.live.vs.MultiTab;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class a<T> implements Comparator<T> {
    public a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(((MultiTab.Bubble) r100).getDelay()), Long.valueOf(((MultiTab.Bubble) r101).getDelay()));
    }
}
