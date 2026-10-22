package com.bytedance.android.shopping.store.search.presenter;

import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.shopping.store.home.presenter.ShopSearchBasePresenter;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/store/search/presenter/ShopSearchGroupPresenter;", "Lcom/bytedance/android/shopping/store/home/presenter/ShopSearchBasePresenter;", "Landroidx/lifecycle/LifecycleObserver;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopSearchGroupPresenter extends ShopSearchBasePresenter {
    public ShopSearchGroupPresenter() {
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        ECQuickUtilKt.a(u()).getLifecycle().addObserver(this);
        LinearLayout r101 = (LinearLayout) w().b(R.id.search_middle_page_container).f();
        if (ECShopABSettings.getEC_SHOP_SEARCH_GUIDE_STYLE() == 0) goto L5;
        qc3.a.i(r101, 20.0f, 20.0f);
    L5:
        RecyclerView r102 = (RecyclerView) w().b(R.id.search_sug_list).f();
        E().getSearchContent().b(ECQuickUtilKt.a(u()), new a(this, r101, r102));
    }
}
