package com.android.ttcjpaysdk.base.ui.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import java.io.Serializable;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/CombinePayTuple;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;", "choice", "(Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;)V", "choiceAssetInfo", "combineAssetInfo", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetToCombineAssetInfoBean;", "combineAssetInfoFromLimit", "getCombineAssetInfoFromLimit", "()Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetToCombineAssetInfoBean;", "limitAssetInfo", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CombinePayTuple implements CJPayObject, Serializable {
    public final AssetInfoBean choiceAssetInfo;
    public final AssetInfoBean.AssetToCombineAssetInfoBean combineAssetInfo;
    private final AssetInfoBean.AssetToCombineAssetInfoBean combineAssetInfoFromLimit;
    public final AssetInfoBean limitAssetInfo;

    public final AssetInfoBean.AssetToCombineAssetInfoBean getCombineAssetInfoFromLimit() {
        return this.combineAssetInfoFromLimit;
    }

    public CombinePayTuple(AssetInfoBean r100, AssetInfoBean r101) {
        Intrinsics.checkNotNullParameter(r100, VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT);
        Intrinsics.checkNotNullParameter(r101, "choice");
        this.limitAssetInfo = r100;
        this.choiceAssetInfo = r101;
        Iterator<T> r102 = r101.asset_combine_pay_info.asset_to_combine_asset_info_list.iterator();
    L3:
        Object r103 = null;
        if (r102.hasNext() == false) goto L11;
        Object r104 = r102.next();
        if (((AssetInfoBean.AssetToCombineAssetInfoBean) r104).to_combine_asset_index != r100.asset_basic_show_info.index) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == false) goto L3;
    L12:
        this.combineAssetInfo = (AssetInfoBean.AssetToCombineAssetInfoBean) r104;
        Iterator<T> r106 = r100.asset_combine_pay_info.asset_to_combine_asset_info_list.iterator();
    L14:
        if (r106.hasNext() == false) goto L21;
        Object r107 = r106.next();
        if (((AssetInfoBean.AssetToCombineAssetInfoBean) r107).to_combine_asset_index != r101.asset_basic_show_info.index) goto L18;
        boolean r108 = true;
    L19:
        if (r108 == false) goto L14;
        r103 = r107;
        goto L21
    L18:
        r108 = false;
    L21:
        this.combineAssetInfoFromLimit = (AssetInfoBean.AssetToCombineAssetInfoBean) r103;
        return;
    L8:
        r105 = false;
        goto L9
    L11:
        r104 = null;
        goto L12
    }
}
