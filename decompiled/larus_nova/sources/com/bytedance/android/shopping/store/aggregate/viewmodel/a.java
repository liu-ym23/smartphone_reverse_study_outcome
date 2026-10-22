package com.bytedance.android.shopping.store.aggregate.viewmodel;

import com.bytedance.android.shopping.store.aggregate.ShopAggregateParam;
import com.bytedance.android.shopping.store.utils.z;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a {
    public static final Pair<String, String>[] a(ShopAggregateParam r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "storeParam");
        return z.a(r110.getStoreAccountParam().getUserId(), r110.getEnterFrom(), r110.getStoreSourcePage(), r110.getStoreSourceMethod(), r110.getStoreGroupType(), r110.getEntranceLocation(), r110.getPageName(), r110.getFollowStatus(), r110.isPreview(), r110.getTempId(), r111, new Pair[0]);
    }
}
