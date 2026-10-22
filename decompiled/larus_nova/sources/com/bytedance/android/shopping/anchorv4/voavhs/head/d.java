package com.bytedance.android.shopping.anchorv4.voavhs.head;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d {
    public static final List<c> a(List<b> r100) {
        Intrinsics.checkNotNullParameter(r100, "headNodeGroupList");
        ArrayList r101 = new ArrayList();
        Iterator<b> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.addAll(r102.next().f168486c);
        goto L4
    L6:
        return r101;
    }
}
