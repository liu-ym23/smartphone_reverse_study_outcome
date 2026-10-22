package com.android.ttcjpaysdk.bdpay.counter.outer.independent.ultra;

import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.bdpay.paymentmethod.ShareData;
import com.facebook.common.util.UriUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004J\b\u0010\u000f\u001a\u0004\u0018\u00010\fJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\b\u0010\u0012\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014J\u0006\u0010\u0016\u001a\u00020\u0017R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/independent/ultra/OPayMethodTuple;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", UriUtil.LOCAL_ASSET_SCHEME, "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;", "choice", "(Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;)V", "assetInfo", "choiceAssetInfo", "combineAssetInfo", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetToCombineAssetInfoBean;", "getMethodButtonLabel", "", "getPromotionScene", "getRealAssetInfo", "getUsedCrossedPrice", "getUsedPromotionShowPriority", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$PromotionShowPriority;", "getUsedStandardShowAmount", "getUsedVoucherMsgInfoMap", "", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$VoucherMsgInfo;", ShareData.ISCOMBINEPAY, "", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPayMethodTuple implements CJPayObject, Serializable {
    public final AssetInfoBean assetInfo;
    public final AssetInfoBean choiceAssetInfo;
    public final AssetInfoBean.AssetToCombineAssetInfoBean combineAssetInfo;

    public final boolean isCombinePay() {
        if (this.choiceAssetInfo != null) goto L5;
    L7:
        return false;
    L5:
        if (this.combineAssetInfo == null) goto L7;
        return true;
    }

    public final String getMethodButtonLabel() {
        AssetInfoBean r100 = getRealAssetInfo();
        if (r100 == null) goto L7;
        AssetInfoBean.AssetExtensionShowInfo r101 = r100.asset_extension_show_info;
        if (r101 == null) goto L7;
        String r102 = r101.trade_confirm_button_label;
    L8:
        if (r102 != null) goto L11;
        return "";
    L11:
        return r102;
    L7:
        r102 = null;
        goto L8
    }

    public final String getPromotionScene() {
        AssetInfoBean r100 = getRealAssetInfo();
        if (r100 == null) goto L5;
        String r101 = r100.getPromotionScene();
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public final AssetInfoBean getRealAssetInfo() {
        if (isCombinePay() == false) goto L6;
        return this.choiceAssetInfo;
    L6:
        return this.assetInfo;
    }

    public final String getUsedCrossedPrice() {
        if (isCombinePay() == false) goto L8;
        AssetInfoBean.AssetToCombineAssetInfoBean r100 = this.combineAssetInfo;
        if (r100 == null) goto L7;
        HashMap<String, String> r101 = r100.crossed_price_map;
    L9:
        if (r101 != null) goto L11;
        return null;
    L11:
        return r101.get(getPromotionScene());
    L7:
        r101 = null;
        goto L9
    L8:
        r101 = this.assetInfo.asset_extension_show_info.crossed_price_map;
        goto L9
    }

    public final AssetInfoBean.PromotionShowPriority getUsedPromotionShowPriority() {
        if (isCombinePay() == false) goto L9;
        AssetInfoBean.AssetToCombineAssetInfoBean r100 = this.combineAssetInfo;
        if (r100 != null) goto L10;
        return null;
    L10:
        return r100.promotion_show_priority;
    L9:
        return this.assetInfo.asset_extension_show_info.promotion_show_priority;
    }

    public final String getUsedStandardShowAmount() {
        if (isCombinePay() == false) goto L8;
        AssetInfoBean.AssetToCombineAssetInfoBean r100 = this.combineAssetInfo;
        if (r100 == null) goto L7;
        HashMap<String, String> r101 = r100.standard_show_amount_map;
    L9:
        if (r101 != null) goto L11;
        return null;
    L11:
        return r101.get(getPromotionScene());
    L7:
        r101 = null;
        goto L9
    L8:
        r101 = this.assetInfo.asset_extension_show_info.standard_show_amount_map;
        goto L9
    }

    public final List<AssetInfoBean.VoucherMsgInfo> getUsedVoucherMsgInfoMap() {
        ArrayList r100 = null;
        if (isCombinePay() == false) goto L8;
        AssetInfoBean.AssetToCombineAssetInfoBean r101 = this.combineAssetInfo;
        if (r101 == null) goto L7;
        HashMap<String, String> r102 = r101.voucher_msg_info_map;
    L9:
        if (r102 == null) goto L30;
        String r103 = r102.get(getPromotionScene());
        if (r103 == null) goto L30;
        JSONArray r104 = KtSafeMethodExtensionKt.safeCreateJsonArray(r103);
        if (r104 == null) goto L30;
        ArrayList r105 = new ArrayList();     // Catch: Exception -> L20
        int r106 = r104.length();     // Catch: Exception -> L20
        int r107 = 0;
    L15:
        if (r107 >= r106) goto L22;
        Object r108 = r104.opt(r107);     // Catch: Exception -> L20
        if ((r108 instanceof JSONObject) == false) goto L19;
        r105.add(r108);     // Catch: Exception -> L20
    L19:
        r107 = r107 + 1;
    L22:
        if (r105 == null) goto L30;
        r100 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator r109 = r105.iterator();
    L25:
        if (r109.hasNext() == false) goto L30;
        AssetInfoBean.VoucherMsgInfo r110 = (AssetInfoBean.VoucherMsgInfo) CJPayJsonParser.fromJson((JSONObject) r109.next(), AssetInfoBean.VoucherMsgInfo.class);
        if (r110 != null) goto L29;
        r110 = new AssetInfoBean.VoucherMsgInfo();
    L29:
        r100.add(r110);
    L20:
        e = move-exception;
        e.printStackTrace();
        r105 = null;
    L30:
        return r100;
    L7:
        r102 = null;
        goto L9
    L8:
        r102 = this.assetInfo.asset_extension_show_info.voucher_msg_info_map;
        goto L9
    }

    public OPayMethodTuple(AssetInfoBean r100, AssetInfoBean r101) {
        Intrinsics.checkNotNullParameter(r100, UriUtil.LOCAL_ASSET_SCHEME);
        this.assetInfo = r100.getSelectedAsset();
        this.choiceAssetInfo = r101;
        AssetInfoBean.AssetToCombineAssetInfoBean r102 = null;
        Object r103 = null;
        r102 = null;
        r102 = null;
        if (r101 == null) goto L18;
        AssetInfoBean.AssetCombinePayInfoBean r104 = r101.asset_combine_pay_info;
        if (r104 == null) goto L18;
        ArrayList<AssetInfoBean.AssetToCombineAssetInfoBean> r105 = r104.asset_to_combine_asset_info_list;
        if (r105 == null) goto L18;
        Iterator<T> r106 = r105.iterator();
    L10:
        if (r106.hasNext() == false) goto L17;
        Object r107 = r106.next();
        if (((AssetInfoBean.AssetToCombineAssetInfoBean) r107).to_combine_asset_index != this.assetInfo.asset_basic_show_info.index) goto L14;
        boolean r108 = true;
    L15:
        if (r108 == false) goto L10;
        r103 = r107;
        goto L17
    L14:
        r108 = false;
    L17:
        r102 = (AssetInfoBean.AssetToCombineAssetInfoBean) r103;
    L18:
        this.combineAssetInfo = r102;
    }

    public /* synthetic */ OPayMethodTuple(AssetInfoBean r100, AssetInfoBean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}
