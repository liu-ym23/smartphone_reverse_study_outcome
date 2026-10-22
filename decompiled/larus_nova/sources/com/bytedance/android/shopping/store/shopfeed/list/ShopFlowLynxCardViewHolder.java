package com.bytedance.android.shopping.store.shopfeed.list;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/store/shopfeed/list/ShopFlowLynxCardViewHolder;", "Lcom/bytedance/android/shopping/store/shopfeed/list/ShopFeedBaseViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopFlowLynxCardViewHolder extends ShopFeedBaseViewHolder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f186221b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ShopFlowLynxCardView f186222a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.shopping.store.shopfeed.list.ShopFeedBaseViewHolder
    public final void o() {
    }

    public ShopFlowLynxCardViewHolder(ShopFlowLynxCardView r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxCardView");
        super(r100);
        this.f186222a = r100;
    }

    @Override // com.bytedance.android.shopping.store.shopfeed.list.ShopFeedBaseViewHolder
    public final void T3(com.bytedance.android.shopping.store.shopfeed.list.a r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "vo");
        b r103 = (b) r100;
        ShopFlowLynxCardView r104 = this.f186222a;
        ShopFeedItemCard r105 = r103.f186232b;
        String r106 = r103.f186233c;
        if (r101 != r102) goto L5;
        boolean r107 = true;
    L6:
        r104.a(r105, r106, r101, r107);
        return;
    L5:
        r107 = false;
        goto L6
    }
}
