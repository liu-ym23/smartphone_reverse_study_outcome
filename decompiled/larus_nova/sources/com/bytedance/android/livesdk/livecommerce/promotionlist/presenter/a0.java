package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import com.bytedance.android.ec.model.live.ECPromotionInterationData;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class a0<T> implements Comparator<T> {
    public a0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(((ECPromotionInterationData) r100).getPriority()), Integer.valueOf(((ECPromotionInterationData) r101).getPriority()));
    }
}
