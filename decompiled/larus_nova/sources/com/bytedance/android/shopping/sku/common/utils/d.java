package com.bytedance.android.shopping.sku.common.utils;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d {
    public static final void b(List<? extends a> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$startSkuTaskList");
        Iterator<T> r101 = r100.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L9;
        Object r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        a r105 = (a) CollectionsKt.getOrNull(r100, r104);
        ((a) r103).f182778a = r105;
        r102 = r104;
        goto L4
    L9:
        a r106 = (a) CollectionsKt.firstOrNull(r100);
        if (r106 == null) goto L16;
        r106.a();
        return;
    }

    public static final SkuCommonTaskUtilsKt$newSkuTask$1 a(String r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "taskName");
        Intrinsics.checkNotNullParameter(r101, "action");
        return new SkuCommonTaskUtilsKt$newSkuTask$1(r100, r101);
    }
}
