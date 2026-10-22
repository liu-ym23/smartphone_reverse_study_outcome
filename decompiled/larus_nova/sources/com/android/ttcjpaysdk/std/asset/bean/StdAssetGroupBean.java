package com.android.ttcjpaysdk.std.asset.bean;

import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015R.\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/android/ttcjpaysdk/std/asset/bean/StdAssetGroupBean;", "", "()V", "assetItemList", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/std/asset/bean/StdAssetItemBean;", "Lkotlin/collections/ArrayList;", "getAssetItemList", "()Ljava/util/ArrayList;", "setAssetItemList", "(Ljava/util/ArrayList;)V", "groupInfoAssetSelectPageGroupInfoBean", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetSelectPageGroupInfoBean;", "getGroupInfoAssetSelectPageGroupInfoBean", "()Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetSelectPageGroupInfoBean;", "setGroupInfoAssetSelectPageGroupInfoBean", "(Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetSelectPageGroupInfoBean;)V", "getGroupTitle", "", "getGroupType", "hideGroupTitle", "", "showTitleSplitLIne", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StdAssetGroupBean {
    private ArrayList<StdAssetItemBean> assetItemList;
    private AssetInfoBean.AssetSelectPageGroupInfoBean groupInfoAssetSelectPageGroupInfoBean;

    public StdAssetGroupBean() {
    }

    public final String getGroupTitle() {
        AssetInfoBean.AssetSelectPageGroupInfoBean r100 = this.groupInfoAssetSelectPageGroupInfoBean;
        if (r100 == null) goto L6;
        String r101 = r100.group_title;
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public final String getGroupType() {
        AssetInfoBean.AssetSelectPageGroupInfoBean r100 = this.groupInfoAssetSelectPageGroupInfoBean;
        if (r100 == null) goto L6;
        String r101 = r100.group_type;
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public final boolean hideGroupTitle() {
        AssetInfoBean.AssetSelectPageGroupInfoBean r100 = this.groupInfoAssetSelectPageGroupInfoBean;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.hide_group_tile;
    }

    public final boolean showTitleSplitLIne() {
        AssetInfoBean.AssetSelectPageGroupInfoBean r100 = this.groupInfoAssetSelectPageGroupInfoBean;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.show_group_title_split_line;
    }

    public final ArrayList<StdAssetItemBean> getAssetItemList() {
        return this.assetItemList;
    }

    public final AssetInfoBean.AssetSelectPageGroupInfoBean getGroupInfoAssetSelectPageGroupInfoBean() {
        return this.groupInfoAssetSelectPageGroupInfoBean;
    }

    public final void setAssetItemList(ArrayList<StdAssetItemBean> r100) {
        this.assetItemList = r100;
    }

    public final void setGroupInfoAssetSelectPageGroupInfoBean(AssetInfoBean.AssetSelectPageGroupInfoBean r100) {
        this.groupInfoAssetSelectPageGroupInfoBean = r100;
    }
}
