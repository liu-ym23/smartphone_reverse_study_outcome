package com.bytedance.android.shopping.store.shopfeed.router;

import android.content.Context;
import android.net.Uri;
import bf.c;
import com.bytedance.android.ec.core.utils.n;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class ECShopFeedRouter implements c {
    public ECShopFeedRouter() {
    }

    @Override // bf.c
    public final void a() {
    }

    @Override // bf.c
    public final String b() {
        return "goods/shop_feed";
    }

    @Override // bf.c
    public final boolean c(final Context r100, final Uri r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        n.b(r100, r102, null, new ECShopFeedRouter$open$1(r100, r101), ECShopFeedRouter$open$2.INSTANCE);
        return true;
    }
}
