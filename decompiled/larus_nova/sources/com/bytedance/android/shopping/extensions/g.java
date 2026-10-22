package com.bytedance.android.shopping.extensions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class g {
    public static String a(List r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toSplitString");
        Intrinsics.checkNotNullParameter(",", "split");
        StringBuilder r101 = new StringBuilder();
        Iterator r102 = r100.iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L13;
        Object r104 = r102.next();
        int r105 = r103 + 1;
        if (r103 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        r101.append((String) r104);
        if (r103 == (((ArrayList) r100).size() - 1)) goto L11;
        r101.append(",");
    L11:
        r103 = r105;
        goto L4
    L13:
        return r101.toString();
    }
}
