package com.bytedance.android.livesdk.livecommerce.room.coupon;

import com.bytedance.android.ec.model.response.IconItem;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class d<T> implements Comparator<T> {
    public d() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(((IconItem) r100).getPriority()), Integer.valueOf(((IconItem) r101).getPriority()));
    }
}
