package com.bytedance.android.shopping.store.hybridproduct.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.widget.LoadMoreStatusView;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.ec.hybrid.list.holder.ECLoadMoreViewHolder;
import com.bytedance.android.shopping.store.hybridproduct.module.g;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopHybridProductLoadMoreViewHolder;", "Lcom/bytedance/android/ec/hybrid/list/holder/ECLoadMoreViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopHybridProductLoadMoreViewHolder extends ECLoadMoreViewHolder {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f185051q = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final QUIManager f185052o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final View f185053p;

    public static final class a {
        public static ECShopHybridProductLoadMoreViewHolder a(ViewGroup r100, Fragment r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
            QUIManager r102 = new QUIManager();
            ShoppingAsyncInflater.a r103 = ShoppingAsyncInflater.f45268e;
            Context r104 = r100.getContext();
            r103.getClass();
            View r105 = ShoppingAsyncInflater.a.a(r104).aU(R.layout.shopping_layout_ec_store_tab_footer, null, false);
            LoadMoreStatusView r106 = (LoadMoreStatusView) r105.findViewById(R.id.sv_product_load_more);
            r106.setLayoutParams(new LinearLayout.LayoutParams(-1, vf4.a.b(44)));
            r106.setPadding(0, vf4.a.b(12), 0, vf4.a.b(12));
            r105.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            r102.k(new g(r105, r101), r100.getContext(), r101);
            return new ECShopHybridProductLoadMoreViewHolder(r102, r105);
        }
    }

    static {
    }

    public ECShopHybridProductLoadMoreViewHolder(QUIManager r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "uiManager");
        Intrinsics.checkNotNullParameter(r101, "itemView");
        super(r101);
        this.f185052o = r100;
        this.f185053p = r101;
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder
    public final void b4(Object r100, String r101, k.a r102) {
        Intrinsics.checkNotNullParameter(r101, "itemId");
        super.b4(r100, r101, r102);
        this.f185052o.c(g.class, null);
    }
}
