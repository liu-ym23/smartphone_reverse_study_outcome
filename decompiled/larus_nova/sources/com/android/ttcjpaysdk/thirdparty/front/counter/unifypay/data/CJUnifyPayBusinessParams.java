package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data;

import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.ui.Utils.AssetLogUtils;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.homepage.UnifyPayHomepageState;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.method.data.CJUnifyPayMethodTuple;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.standard.core.CJStandardBusinessParams;
import com.android.ttcjpaysdk.thirdparty.front.counter.utils.CJUnifyPayAssetInfoUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J@\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2\u0006\u0010/\u001a\u000200J\u0016\u00101\u001a\u00020\u00042\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010-J\u0018\u00103\u001a\u00020\u00042\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010-H\u0002J\b\u00104\u001a\u000205H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u0010\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\u001a\u0010\u0013\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0018\"\u0004\b!\u0010\u001aR\u001c\u0010\"\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\b¨\u00066"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/CJUnifyPayBusinessParams;", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/standard/core/CJStandardBusinessParams;", "()V", "cashierEnterFromMethod", "", "getCashierEnterFromMethod", "()Ljava/lang/String;", "setCashierEnterFromMethod", "(Ljava/lang/String;)V", "cashierInvokeMethod", "getCashierInvokeMethod", "setCashierInvokeMethod", "discountAmount", "dyUid", "getDyUid", "setDyUid", "extUid", "getExtUid", "setExtUid", "inAppCashierInvokeType", "getInAppCashierInvokeType", "setInAppCashierInvokeType", "isHomepageShow", "Lkotlin/Function0;", "()Lkotlin/jvm/functions/Function0;", "setHomepageShow", "(Lkotlin/jvm/functions/Function0;)V", "jhMerchantId", "getJhMerchantId", "setJhMerchantId", "originalAmount", "unifyCashierShowStyle", "getUnifyCashierShowStyle", "setUnifyCashierShowStyle", "zgMerchantId", "getZgMerchantId", "setZgMerchantId", "genMethodParams", "", "amount", "curPaymentMethodInfo", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/method/data/CJUnifyPayMethodTuple;", "curShowState", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/homepage/UnifyPayHomepageState;", "unfoldList", "", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;", "useDisplayIndex", "", "genMethodTypeList", "subAsset", "genOrderedMethodTypeList", "toJsonObj", "Lorg/json/JSONObject;", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJUnifyPayBusinessParams extends CJStandardBusinessParams {
    private String cashierEnterFromMethod;
    private String cashierInvokeMethod;
    private String discountAmount;
    private String dyUid;
    private String extUid;
    private String inAppCashierInvokeType;
    private Function0<String> isHomepageShow;
    private String jhMerchantId;
    private String originalAmount;
    private Function0<String> unifyCashierShowStyle;
    private String zgMerchantId;

    public CJUnifyPayBusinessParams() {
        this.inAppCashierInvokeType = "";
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.standard.core.CJStandardBusinessParams
    public JSONObject toJsonObj() {
        JSONObject r100 = super.toJsonObj();
        KtSafeMethodExtensionKt.safePut(r100, "unify_cashier_type", "unify_cashier");
        KtSafeMethodExtensionKt.safePut(r100, "show_style", "unify");
        String r101 = this.jhMerchantId;
        if (r101 == null) goto L5;
        KtSafeMethodExtensionKt.safePut(r100, "jh_merchant_id", r101);
    L5:
        String r102 = this.zgMerchantId;
        if (r102 == null) goto L8;
        KtSafeMethodExtensionKt.safePut(r100, "zg_merchant_id", r102);
    L8:
        String r103 = this.originalAmount;
        if (r103 == null) goto L11;
        KtSafeMethodExtensionKt.safePut(r100, "original_amount", r103);
    L11:
        String r104 = this.discountAmount;
        if (r104 == null) goto L14;
        KtSafeMethodExtensionKt.safePut(r100, "discount_amount", r104);
    L14:
        String r105 = this.cashierEnterFromMethod;
        if (r105 == null) goto L17;
        KtSafeMethodExtensionKt.safePut(r100, "cashier_enter_from_method", r105);
    L17:
        String r106 = this.cashierInvokeMethod;
        if (r106 == null) goto L20;
        KtSafeMethodExtensionKt.safePut(r100, "cashier_invoke_method", r106);
    L20:
        Function0<String> r107 = this.unifyCashierShowStyle;
        if (r107 == null) goto L23;
        KtSafeMethodExtensionKt.safePut(r100, "unify_cashier_show_style", r107.invoke());
    L23:
        String r108 = this.extUid;
        if (r108 == null) goto L26;
        KtSafeMethodExtensionKt.safePut(r100, "ext_uid", r108);
    L26:
        String r109 = this.dyUid;
        if (r109 == null) goto L29;
        KtSafeMethodExtensionKt.safePut(r100, "dy_uid", r109);
    L29:
        KtSafeMethodExtensionKt.safePut(r100, "inapp_cashier_invoke_type", this.inAppCashierInvokeType);
        Function0<String> r110 = this.isHomepageShow;
        if (r110 == null) goto L32;
        KtSafeMethodExtensionKt.safePut(r100, "is_homepage_show", r110.invoke());
    L32:
        return r100;
    }

    public final String getCashierEnterFromMethod() {
        return this.cashierEnterFromMethod;
    }

    public final String getCashierInvokeMethod() {
        return this.cashierInvokeMethod;
    }

    public final String getDyUid() {
        return this.dyUid;
    }

    public final String getExtUid() {
        return this.extUid;
    }

    public final String getInAppCashierInvokeType() {
        return this.inAppCashierInvokeType;
    }

    public final String getJhMerchantId() {
        return this.jhMerchantId;
    }

    public final Function0<String> getUnifyCashierShowStyle() {
        return this.unifyCashierShowStyle;
    }

    public final String getZgMerchantId() {
        return this.zgMerchantId;
    }

    public final Function0<String> isHomepageShow() {
        return this.isHomepageShow;
    }

    private final String genOrderedMethodTypeList(List<AssetInfoBean> r110) {
        if (r110 == null) goto L5;
        String r111 = CollectionsKt.joinToString$default(r110, ",", null, null, 0, null, C94051.INSTANCE, 30, null);
        if (r111 == null) goto L5;
        return r111;
    L5:
        return "";
    }

    public final String genMethodTypeList(List<AssetInfoBean> r110) {
        LinkedHashSet r100 = new LinkedHashSet();
        if (r110 == null) goto L20;
        Iterator<T> r111 = r110.iterator();
    L6:
        if (r111.hasNext() == false) goto L20;
        AssetInfoBean r101 = (AssetInfoBean) r111.next();
        r100.add(r101.asset_meta_info.asset_type);
        Iterator<T> r102 = r101.sub_asset_info_list.iterator();
    L9:
        if (r102.hasNext() == false) goto L6;
        String r103 = ((AssetInfoBean) r102.next()).asset_meta_info.asset_type;
        if (r103.length() <= 0) goto L13;
        boolean r104 = true;
    L14:
        if (r104 == true) goto L17;
        r103 = null;
    L17:
        if (r103 == null) goto L9;
        r100.add(r103);
        goto L9
    L13:
        r104 = false;
    L20:
        return CollectionsKt.joinToString$default(r100, ",", null, null, 0, null, null, 62, null);
    }

    public final void setCashierEnterFromMethod(String r100) {
        this.cashierEnterFromMethod = r100;
    }

    public final void setCashierInvokeMethod(String r100) {
        this.cashierInvokeMethod = r100;
    }

    public final void setDyUid(String r100) {
        this.dyUid = r100;
    }

    public final void setExtUid(String r100) {
        this.extUid = r100;
    }

    public final void setHomepageShow(Function0<String> r100) {
        this.isHomepageShow = r100;
    }

    public final void setInAppCashierInvokeType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.inAppCashierInvokeType = r100;
    }

    public final void setJhMerchantId(String r100) {
        this.jhMerchantId = r100;
    }

    public final void setUnifyCashierShowStyle(Function0<String> r100) {
        this.unifyCashierShowStyle = r100;
    }

    public final void setZgMerchantId(String r100) {
        this.zgMerchantId = r100;
    }

    public final void genMethodParams(String r110, String r111, CJUnifyPayMethodTuple r210, UnifyPayHomepageState r211, List<AssetInfoBean> r212, boolean r213) {
        Intrinsics.checkNotNullParameter(r110, "amount");
        Intrinsics.checkNotNullParameter(r211, "curShowState");
        Intrinsics.checkNotNullParameter(r212, "unfoldList");
        setAmount(r110);
        if (r111 != null) goto L5;
        String r100 = r110;
    L6:
        this.originalAmount = r100;
        this.discountAmount = r110;
        String r101 = null;
        if (r210 == null) goto L11;
        ArrayList<AssetInfoBean.AssetMetaInfoBean> r102 = r210.getAssetMetaInfoListShow();
        if (r102 == null) goto L11;
        String r103 = CollectionsKt.joinToString$default(r102, Marker.ANY_NON_NULL_MARKER, null, null, 0, null, AnonymousClass1.INSTANCE, 30, null);
    L12:
        setMethod(r103);
        if (r210 == null) goto L17;
        AssetInfoBean r104 = r210.getRealAssetInfo();
        if (r104 == null) goto L17;
        String r105 = r104.getTitle();
    L18:
        setMethodTitle(r105);
        if (r211 == UnifyPayHomepageState.EXPAND_STATE) goto L21;
        String r106 = getMethod();
    L24:
        setUnfoldMethodList(r106);
        if (r210 == null) goto L27;
        AssetInfoBean r107 = r210.getRealAssetInfo();
    L28:
        boolean r108 = false;
        if (r107 != null) goto L31;
    L33:
        if (r108 == false) goto L35;
        String r109 = "1";
    L36:
        setChooseDirectBank(r109);
        if (r108 == false) goto L40;
        if (r107 == null) goto L40;
        String r112 = r107.getTitle();
    L41:
        setDirectBankName(r112);
        if (r107 == null) goto L47;
        AssetInfoBean r113 = CJUnifyPayAssetInfoUtils.INSTANCE.getRealSelect(r107);
        if (r113 == null) goto L47;
        String r114 = buildChoosedDirectBankCampignInfo(r113);
        if (r114 == null) goto L47;
    L48:
        setChoosedDirectBankCampaignInfo(r114);
        ArrayList r115 = new ArrayList();
        Iterator<T> r116 = r212.iterator();
    L50:
        if (r116.hasNext() == false) goto L54;
        Object r117 = r116.next();
        if (((AssetInfoBean) r117).isRealDirectBank() == false) goto L50;
        r115.add(r117);
        goto L50
    L54:
        ArrayList r118 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r115, 10));
        Iterator r119 = r115.iterator();
    L56:
        if (r119.hasNext() == false) goto L59;
        r118.add(((AssetInfoBean) r119.next()).getTitle());
        goto L56
    L59:
        if ((!r118.isEmpty()) == false) goto L61;
        r101 = CollectionsKt.joinToString$default(r118, ",", null, null, 0, null, null, 62, null);
    L61:
        setDirectBankList(r101);
        setSelectedByteSubPay(AssetLogUtils.INSTANCE.parseAssetInfo(r107));
        return;
    L47:
        r114 = "";
    L40:
        r112 = null;
        goto L41
    L35:
        r109 = "0";
        goto L36
    L31:
        if (r107.isRealDirectBank() != true) goto L33;
        r108 = true;
        goto L33
    L27:
        r107 = null;
        goto L28
    L21:
        if (r213 == false) goto L23;
        r106 = genOrderedMethodTypeList(r212);
        goto L24
    L23:
        r106 = genMethodTypeList(r212);
    L17:
        r105 = null;
    L11:
        r103 = null;
        goto L12
    L5:
        r100 = r111;
        goto L6
    }
}
