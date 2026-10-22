package com.bytedance.android.shopping.store.recommend.holder;

import com.bytedance.android.ec.store.product.holder.BindableViewHolder;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pj3.b;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/store/recommend/holder/ShopAggregateDividerHolder;", "Lcom/bytedance/android/ec/store/product/holder/BindableViewHolder;", "Lpj3/b;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopAggregateDividerHolder extends BindableViewHolder<b> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f185764b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final QUIManager f185765a;

    public static final class a {
    }

    static {
    }

    public ShopAggregateDividerHolder(QUIManager r100, qj3.a r101) {
        Intrinsics.checkNotNullParameter(r100, "uiManager");
        Intrinsics.checkNotNullParameter(r101, "dividerView");
        super(r101);
        this.f185765a = r100;
    }
}
