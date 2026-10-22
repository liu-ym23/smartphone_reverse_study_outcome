package com.bytedance.android.shopping.api.image;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class y {
    public static final boolean a(List<e> r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$operationIn");
        if ((!r100.isEmpty()) == false) goto L16;
        Iterator<T> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        Object r103 = r102.next();
        if (((e) r103).a(r101) == false) goto L6;
    L12:
        if (((e) r103) != null) goto L20;
        return false;
    L20:
        return true;
    L10:
        r103 = null;
        goto L12
    L16:
        return false;
    }
}
