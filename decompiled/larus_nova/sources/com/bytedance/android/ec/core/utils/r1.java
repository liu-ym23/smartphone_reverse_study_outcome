package com.bytedance.android.ec.core.utils;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class r1<T> implements Comparator<T> {
    public r1() {
    }

    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        boolean r102 = r100 instanceof m1;
        Integer r103 = null;
        Object r104 = r100;
        if (r102 == true) goto L5;
        r104 = (T) null;
    L5:
        m1 r105 = (m1) r104;
        if (r105 == null) goto L8;
        Integer r106 = Integer.valueOf(r105.f45644a);
    L9:
        boolean r107 = r101 instanceof m1;
        Object r108 = r101;
        if (r107 == true) goto L12;
        r108 = (T) null;
    L12:
        m1 r109 = (m1) r108;
        if (r109 == null) goto L16;
        r103 = Integer.valueOf(r109.f45644a);
    L16:
        return ComparisonsKt.compareValues(r106, r103);
    L8:
        r106 = null;
        goto L9
    }
}
