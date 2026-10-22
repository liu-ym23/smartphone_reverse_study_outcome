package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.method.data;

import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.base.ui.data.CJOptionShowInfo;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.bdpay.paymentmethod.ShareData;
import com.android.ttcjpaysdk.thirdparty.front.counter.utils.CJUnifyPayAssetInfoUtils;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.facebook.common.util.UriUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u0006\u0010\f\u001a\u00020\u0004J\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010J\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\u0013J\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017J\u0006\u0010\u0019\u001a\u00020\u0013J\u0006\u0010\u001a\u001a\u00020\u0004J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001e\u001a\u00020\u001cJ\u0006\u0010\u001f\u001a\u00020\u001cJ\u0006\u0010 \u001a\u00020\u001cJ\b\u0010!\u001a\u00020\u0013H\u0016R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/data/CJUnifyPayMethodTuple;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", UriUtil.LOCAL_ASSET_SCHEME, "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;", "choice", "(Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;)V", "assetInfo", "choiceAssetInfo", "combineAssetInfo", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetToCombineAssetInfoBean;", "superAssetInfo", "buildUsedAssetInfo", "getAssetMetaInfoList", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetMetaInfoBean;", "Lkotlin/collections/ArrayList;", "getAssetMetaInfoListShow", "getMethodButtonExpandLabel", "", "getMethodButtonLabel", "getMethodButtonPayAndXLabel", "getOptionShowInfoList", "", "Lcom/android/ttcjpaysdk/base/ui/data/CJOptionShowInfo;", "getPTCode", "getRealAssetInfo", ShareData.ISCOMBINEPAY, "", "isForeignCard", "isNeedSignPay", "isThirdPayment", "needSwitchThirdPaymentInteraction", "toString", "Companion", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJUnifyPayMethodTuple implements CJPayObject, Serializable {
    public static final Companion Companion = null;
    private static final String TAG = "CJUnifyPayMethodTuple";
    public final AssetInfoBean assetInfo;
    public final AssetInfoBean choiceAssetInfo;
    public final AssetInfoBean.AssetToCombineAssetInfoBean combineAssetInfo;
    public final AssetInfoBean superAssetInfo;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/data/CJUnifyPayMethodTuple$Companion;", "", "()V", "TAG", "", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final ArrayList<AssetInfoBean.AssetMetaInfoBean> getAssetMetaInfoList() {
        ArrayList<AssetInfoBean.AssetMetaInfoBean> r100 = new ArrayList();
        if (isCombinePay() == false) goto L5;
        AssetInfoBean.AssetToCombineAssetInfoBean r101 = this.combineAssetInfo;
        Intrinsics.checkNotNull(r101);
        r100.add(r101.asset_meta_info);
    L6:
        return r100;
    L5:
        r100.add(getRealAssetInfo().asset_meta_info);
        goto L6
    }

    public final ArrayList<AssetInfoBean.AssetMetaInfoBean> getAssetMetaInfoListShow() {
        ArrayList<AssetInfoBean.AssetMetaInfoBean> r100 = new ArrayList();
        if (isCombinePay() == false) goto L5;
        AssetInfoBean.AssetToCombineAssetInfoBean r101 = this.combineAssetInfo;
        Intrinsics.checkNotNull(r101);
        r100.add(r101.asset_meta_info);
        CJUnifyPayAssetInfoUtils r102 = CJUnifyPayAssetInfoUtils.INSTANCE;
        AssetInfoBean r103 = this.choiceAssetInfo;
        Intrinsics.checkNotNull(r103);
        r100.add(r102.getRealSelect(r103).asset_meta_info);
    L6:
        return r100;
    L5:
        r100.add(CJUnifyPayAssetInfoUtils.INSTANCE.getRealSelect(this.assetInfo).asset_meta_info);
        goto L6
    }

    public final boolean isCombinePay() {
        if (this.choiceAssetInfo != null) goto L5;
    L7:
        return false;
    L5:
        if (this.combineAssetInfo == null) goto L7;
        return true;
    }

    public final boolean isForeignCard() {
        return this.assetInfo.isForeignCard();
    }

    public final boolean isThirdPayment() {
        return this.assetInfo.isThirdPayment();
    }

    public final boolean needSwitchThirdPaymentInteraction() {
        if (this.assetInfo.asset_extension_show_info.jump_info.action.length() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return "CJUnifyPayMethodTuple(assetInfo=" + this.assetInfo + ", choiceAssetInfo=" + this.choiceAssetInfo + ", combineAssetInfo=" + this.combineAssetInfo + ", superAssetInfo=" + this.superAssetInfo + ')';
    }

    public final AssetInfoBean buildUsedAssetInfo() {
    L21:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJUnifyPayMethodTuple#buildUsedAssetInfo", th);
        CJLogger.c(TAG, "buildUsedAssetInfo exp: ", th);
        return getRealAssetInfo();
    L3:
        if (isCombinePay() == false) goto L20;
        Iterator<T> r100 = this.assetInfo.asset_combine_pay_info.asset_to_combine_asset_info_list.iterator();     // Catch: Throwable -> L21
    L5:
        Object r101 = null;
        if (r100.hasNext() == false) goto L15;
        Object r102 = r100.next();     // Catch: Throwable -> L21
        String r103 = ((AssetInfoBean.AssetToCombineAssetInfoBean) r102).asset_meta_info.getUniqueSymbol();     // Catch: Throwable -> L21
        AssetInfoBean r104 = this.choiceAssetInfo;     // Catch: Throwable -> L21
        if (r104 == null) goto L13;
        AssetInfoBean.AssetMetaInfoBean r105 = r104.asset_meta_info;     // Catch: Throwable -> L21
        if (r105 == null) goto L13;
        r101 = r105.getUniqueSymbol();     // Catch: Throwable -> L21
    L13:
        if (Intrinsics.areEqual(r103, r101) == false) goto L5;
        r101 = r102;
    L15:
        AssetInfoBean.AssetToCombineAssetInfoBean r106 = (AssetInfoBean.AssetToCombineAssetInfoBean) r101;     // Catch: Throwable -> L21
        AssetInfoBean r107 = (AssetInfoBean) CJPayJsonParser.fromJson(CJPayJsonParser.toJsonObject(this.assetInfo).toString(), AssetInfoBean.class);     // Catch: Throwable -> L21
        AssetInfoBean.AssetCombinePayInfoBean r108 = r107.asset_combine_pay_info;     // Catch: Throwable -> L21
        ArrayList<AssetInfoBean.AssetToCombineAssetInfoBean> r109 = new ArrayList();     // Catch: Throwable -> L21
        if (r106 == null) goto L18;
        r109.add(r106);     // Catch: Throwable -> L21
    L18:
        r108.asset_to_combine_asset_info_list = r109;     // Catch: Throwable -> L21
        return r107;
    L20:
        return this.assetInfo;
    }

    public final String getMethodButtonExpandLabel() {
        if (isCombinePay() == false) goto L10;
        AssetInfoBean.AssetToCombineAssetInfoBean r100 = this.combineAssetInfo;
        if (r100 == null) goto L12;
        String r101 = r100.default_expand_confirm_btn_label;
        if (r101 == null) goto L12;
        return r101;
    L12:
        return getRealAssetInfo().asset_extension_show_info.default_expand_confirm_btn_label;
    L10:
        return getRealAssetInfo().asset_extension_show_info.default_expand_confirm_btn_label;
    }

    public final String getMethodButtonLabel() {
        if (isCombinePay() == false) goto L10;
        AssetInfoBean.AssetToCombineAssetInfoBean r100 = this.combineAssetInfo;
        if (r100 == null) goto L12;
        String r101 = r100.trade_confirm_button_label;
        if (r101 == null) goto L12;
        return r101;
    L12:
        return getRealAssetInfo().asset_extension_show_info.trade_confirm_button_label;
    L10:
        return getRealAssetInfo().asset_extension_show_info.trade_confirm_button_label;
    }

    public final String getMethodButtonPayAndXLabel() {
        if (isCombinePay() == false) goto L10;
        AssetInfoBean.AssetToCombineAssetInfoBean r100 = this.combineAssetInfo;
        if (r100 == null) goto L12;
        String r101 = r100.pay_and_x_confirm_btn_label;
        if (r101 == null) goto L12;
        return r101;
    L12:
        return getRealAssetInfo().asset_extension_show_info.pay_and_x_confirm_btn_label;
    L10:
        return getRealAssetInfo().asset_extension_show_info.pay_and_x_confirm_btn_label;
    }

    public final List<CJOptionShowInfo> getOptionShowInfoList() {
        if (isCombinePay() == false) goto L9;
        AssetInfoBean.AssetToCombineAssetInfoBean r100 = this.combineAssetInfo;
        if (r100 != null) goto L10;
        return null;
    L10:
        return r100.option_show_info_list;
    L9:
        return this.assetInfo.asset_extension_show_info.option_show_info_list;
    }

    public final String getPTCode() {
        return getRealAssetInfo().asset_basic_show_info.primary_category;
    }

    public final AssetInfoBean getRealAssetInfo() {
        if (isCombinePay() == false) goto L6;
        AssetInfoBean r100 = this.choiceAssetInfo;
        Intrinsics.checkNotNull(r100);
        return r100;
    L6:
        return this.assetInfo;
    }

    public final boolean isNeedSignPay() {
        return getRealAssetInfo().asset_extension_show_info.need_resign;
    }

    public CJUnifyPayMethodTuple(AssetInfoBean r100, AssetInfoBean r101) {
        Intrinsics.checkNotNullParameter(r100, UriUtil.LOCAL_ASSET_SCHEME);
        this.assetInfo = r100.getSelectedAsset();
        this.choiceAssetInfo = r101;
        if (r101 == null) goto L16;
        AssetInfoBean.AssetCombinePayInfoBean r102 = r101.asset_combine_pay_info;
        if (r102 == null) goto L16;
        ArrayList<AssetInfoBean.AssetToCombineAssetInfoBean> r103 = r102.asset_to_combine_asset_info_list;
        if (r103 == null) goto L16;
        Iterator<T> r104 = r103.iterator();
    L10:
        if (r104.hasNext() == false) goto L14;
        Object r105 = r104.next();
        if (Intrinsics.areEqual(((AssetInfoBean.AssetToCombineAssetInfoBean) r105).asset_meta_info.getUniqueSymbol(), this.assetInfo.asset_meta_info.getUniqueSymbol()) == false) goto L10;
    L15:
        AssetInfoBean.AssetToCombineAssetInfoBean r106 = (AssetInfoBean.AssetToCombineAssetInfoBean) r105;
    L17:
        this.combineAssetInfo = r106;
        if ((!r100.sub_asset_info_list.isEmpty()) == true) goto L21;
        r100 = null;
    L21:
        this.superAssetInfo = r100;
        return;
    L14:
        r105 = null;
    L16:
        r106 = null;
        goto L17
    }

    public /* synthetic */ CJUnifyPayMethodTuple(AssetInfoBean r100, AssetInfoBean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}
