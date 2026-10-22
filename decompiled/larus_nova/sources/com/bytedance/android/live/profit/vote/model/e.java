package com.bytedance.android.live.profit.vote.model;

import com.bytedance.android.live.profit.vote.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e {
    public static final List<g> a(List<? extends com.bytedance.android.live.profit.vote.a> r110) {
        if (r110 == null) goto L8;
        List<? extends com.bytedance.android.live.profit.vote.a> r111 = r110;
        ArrayList r100 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator<T> r112 = r111.iterator();
    L5:
        if (r112.hasNext() == false) goto L10;
        com.bytedance.android.live.profit.vote.a r101 = (com.bytedance.android.live.profit.vote.a) r112.next();
        Intrinsics.checkNotNullParameter(r101, "$this$toVoteItem");
        r100.add(new g(r101.getCount(), r101.getGiftId(), r101.getGiftName(), r101.getText(), r101.getIcon()));
        goto L5
    L10:
        return r100;
    L8:
        return CollectionsKt.emptyList();
    }
}
