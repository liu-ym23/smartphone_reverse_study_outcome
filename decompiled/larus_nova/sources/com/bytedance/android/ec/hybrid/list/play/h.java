package com.bytedance.android.ec.hybrid.list.play;

import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class h<T> implements Comparator<T> {
    public h() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        BaseViewHolder r102 = (BaseViewHolder) r100;
        ECHybridListItemVO r103 = r102.f47152c;
        int r104 = 0;
        if (r103 == null) goto L5;
        int r105 = r103.f47039m;
    L6:
        int r106 = r105 * 1000;
        Integer r107 = Integer.valueOf(r106 + r102.getLayoutPosition());
        BaseViewHolder r108 = (BaseViewHolder) r101;
        ECHybridListItemVO r109 = r108.f47152c;
        if (r109 == null) goto L9;
        r104 = r109.f47039m;
    L9:
        int r110 = r104 * 1000;
        return ComparisonsKt.compareValues(r107, Integer.valueOf(r110 + r108.getLayoutPosition()));
    L5:
        r105 = 0;
        goto L6
    }
}
