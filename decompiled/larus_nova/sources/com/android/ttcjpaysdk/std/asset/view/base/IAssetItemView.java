package com.android.ttcjpaysdk.std.asset.view.base;

import com.android.ttcjpaysdk.std.asset.bean.StdAssetItemBean;
import com.android.ttcjpaysdk.std.asset.view.StdAssetItemView;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/std/asset/view/base/IAssetItemView;", "", "hideLoading", "", "setOnClickListener", "listener", "Lcom/android/ttcjpaysdk/std/asset/view/StdAssetItemView$ClickListener;", DyPayConstant.KEY_SHOW_LOADING, "updateData", "d", "Lcom/android/ttcjpaysdk/std/asset/bean/StdAssetItemBean;", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IAssetItemView {
    void hideLoading();

    void setOnClickListener(StdAssetItemView.ClickListener r100);

    void showLoading();

    void updateData(StdAssetItemBean r100);
}
