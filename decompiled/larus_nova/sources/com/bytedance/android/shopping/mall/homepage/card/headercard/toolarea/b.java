package com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class b<T> implements Comparator<T> {
    public b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        a.C2638a r102 = (a.C2638a) r100;
        int r103 = 99;
        if (r102.f177857b == null) goto L7;
        Integer r104 = r102.f177858c;
        if (r104 == null) goto L7;
        int r105 = r104.intValue();
    L8:
        Integer r106 = Integer.valueOf(r105);
        a.C2638a r107 = (a.C2638a) r101;
        if (r107.f177857b == null) goto L14;
        Integer r108 = r107.f177858c;
        if (r108 == null) goto L14;
        r103 = r108.intValue();
    L14:
        return ComparisonsKt.compareValues(r106, Integer.valueOf(r103));
    L7:
        r105 = 99;
        goto L8
    }
}
