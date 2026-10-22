package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.base.ui.data.UIComponent;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R&\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R2\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R&\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R&\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/RecommendPopup;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "active_button", "", "asset_block", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/thirdparty/data/RecommendPopupAssetBlock;", "Lkotlin/collections/ArrayList;", "ext_info", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "function_guidance_material", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$FunctionGuidanceMaterial;", "negative_button", BdpAppEventConstant.PARAMS_SUB_TITLE, "Lcom/android/ttcjpaysdk/base/ui/data/UIComponent;", "tips", "Lcom/android/ttcjpaysdk/thirdparty/data/Tips;", "title", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RecommendPopup implements CJPayObject, Serializable {
    public String active_button;
    public ArrayList<RecommendPopupAssetBlock> asset_block;
    public HashMap<String, String> ext_info;
    public AssetInfoBean.FunctionGuidanceMaterial function_guidance_material;
    public String negative_button;
    public ArrayList<UIComponent> sub_title;
    public Tips tips;
    public ArrayList<UIComponent> title;

    public RecommendPopup() {
    }
}
