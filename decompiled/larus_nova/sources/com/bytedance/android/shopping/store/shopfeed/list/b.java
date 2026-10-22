package com.bytedance.android.shopping.store.shopfeed.list;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b extends com.bytedance.android.shopping.store.shopfeed.list.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f186231d = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ShopFeedItemCard f186232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f186233c;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.ugc.aweme.kiwi.model.QModel
    public final int modelType() {
        return ShopFeedItemType.LYNX_CARD.getTypeValue();
    }

    public b(ShopFeedItemCard r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "shopFlowShopCard");
        Intrinsics.checkNotNullParameter(r101, "passThroughParams");
        super(ShopFeedItemType.LYNX_CARD);
        this.f186232b = r100;
        this.f186233c = r101;
    }
}
