package com.bytedance.android.livesdk.link.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b6 {
    public static final List<p> a(a6 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$linkUsersEx");
        List<com.bytedance.android.livesdk.link.model.bridge.k> r101 = r100.getLinkUsers();
        if (r101 == null) goto L8;
        List<com.bytedance.android.livesdk.link.model.bridge.k> r102 = r101;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L11;
        r103.add((p) ((com.bytedance.android.livesdk.link.model.bridge.k) r104.next()).castTo(p.class));
        goto L6
    L11:
        return r103;
    L8:
        return null;
    }
}
