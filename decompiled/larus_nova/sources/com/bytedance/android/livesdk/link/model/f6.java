package com.bytedance.android.livesdk.link.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class f6 {
    public static final List<p> a(e6 r100) {
        if (r100 == null) goto L9;
        List<com.bytedance.android.livesdk.link.model.bridge.k> r101 = r100.getInviteeFollowUsers();
        if (r101 == null) goto L9;
        List<com.bytedance.android.livesdk.link.model.bridge.k> r102 = r101;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L7:
        if (r104.hasNext() == false) goto L12;
        r103.add((p) ((com.bytedance.android.livesdk.link.model.bridge.k) r104.next()).castTo(p.class));
        goto L7
    L12:
        return r103;
    L9:
        return null;
    }

    public static final List<p> b(e6 r100) {
        List<com.bytedance.android.livesdk.link.model.bridge.k> r101 = r100.getInviterUsers();
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
