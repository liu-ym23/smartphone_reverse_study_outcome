package com.bytedance.android.shopping.abscontainer.common_biz.custom_event;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes12.dex */
public final class w0<T> implements Comparator<T> {
    public w0() {
    }

    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        b43.c r102 = b43.c.f17507a;
        return ComparisonsKt.compareValues((Integer) m43.a.a(((z33.a) r101).e(), "__validate_conf__.validate_priority"), (Integer) m43.a.a(((z33.a) r100).e(), "__validate_conf__.validate_priority"));
    }
}
