package com.android.ttcjpaysdk.std.asset.view.base;

import com.android.ttcjpaysdk.std.asset.bean.StdAssetGroupBean;
import com.android.ttcjpaysdk.std.asset.bean.StdAssetItemBean;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0014J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0015"}, d2 = {"Lcom/android/ttcjpaysdk/std/asset/view/base/IAssetGroupView;", "", "clearItemCheckedStatus", "", "groupViewType", "", "hideLoading", "isLoading", "", "notifyDataChanged", "data", "Lcom/android/ttcjpaysdk/std/asset/bean/StdAssetGroupBean;", "requestItemsRelayout", "setItemChecked", "itemBean", "Lcom/android/ttcjpaysdk/std/asset/bean/StdAssetItemBean;", "setOnClickListener", "listener", "Lcom/android/ttcjpaysdk/std/asset/view/base/IAssetGroupView$ClickListener;", DyPayConstant.KEY_SHOW_LOADING, "ClickListener", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IAssetGroupView {

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J0\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/std/asset/view/base/IAssetGroupView$ClickListener;", "", SendEventContainerMethodParamModel.EventKinds.onClick, "", "groupView", "Lcom/android/ttcjpaysdk/std/asset/view/base/IAssetGroupView;", "groupData", "Lcom/android/ttcjpaysdk/std/asset/bean/StdAssetGroupBean;", "itemView", "Lcom/android/ttcjpaysdk/std/asset/view/base/IAssetItemView;", "itemData", "Lcom/android/ttcjpaysdk/std/asset/bean/StdAssetItemBean;", "onCollapseOrNot", "collapse", "", "subGroupType", "", "onOptionVoucherChanged", "checked", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ClickListener {
        void onClick(IAssetGroupView r100, StdAssetGroupBean r101, IAssetItemView r102, StdAssetItemBean r103);

        void onCollapseOrNot(boolean r100, String r101);

        void onOptionVoucherChanged(boolean r100, IAssetGroupView r101, StdAssetGroupBean r102, IAssetItemView r103, StdAssetItemBean r104);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void requestItemsRelayout(IAssetGroupView r100) {
        }
    }

    void clearItemCheckedStatus();

    String groupViewType();

    void hideLoading();

    boolean isLoading();

    void notifyDataChanged(StdAssetGroupBean r100);

    void requestItemsRelayout();

    void setItemChecked(StdAssetItemBean r100);

    void setOnClickListener(ClickListener r100);

    void showLoading(StdAssetItemBean r100);
}
