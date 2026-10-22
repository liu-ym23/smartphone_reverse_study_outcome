package com.bytedance.android.shopping.store.shopfeed;

import com.bytedance.android.shopping.store.shopfeed.list.ShopMomentFlowLynxCardView;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f186161a = 0;

    static {
    }

    public static void a(ShopMomentFlowLynxCardView r100, boolean r101) {
        if (r100 == null) goto L10;
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L5
        r102.put("is_current_show", r101);     // Catch: Exception -> L5
        Unit r103 = Unit.INSTANCE;     // Catch: Exception -> L5
        r100.c("ecom.shop_feed.card_show", r102);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        dm.a.a("ShopFeedJsEvent").b("sendShowEvent", e);
        return;
    }
}
