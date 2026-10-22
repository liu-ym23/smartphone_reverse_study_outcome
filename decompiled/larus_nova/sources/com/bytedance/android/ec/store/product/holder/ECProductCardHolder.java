package com.bytedance.android.ec.store.product.holder;

import android.view.View;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/ec/store/product/holder/ECProductCardHolder;", "Lcom/bytedance/android/ec/store/product/holder/BindableViewHolder;", "Lcom/bytedance/android/ec/store/repository/vo/StoreV2ProductItemVO;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ECProductCardHolder extends BindableViewHolder<StoreV2ProductItemVO> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final QUIManager f48291a;

    public ECProductCardHolder(QUIManager r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "uiManager");
        Intrinsics.checkNotNullParameter(r101, "itemView");
        super(r101);
        this.f48291a = r100;
    }
}
