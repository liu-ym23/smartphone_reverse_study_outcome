package com.android.ttcjpaysdk.bdpay.counter.outer.utils;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.p.e;
import com.android.ttcjpaysdk.asset.bean.CashierPageInfoBean;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.base.ui.data.CJPayAddiItemInfo;
import com.android.ttcjpaysdk.base.ui.data.CJPayCreditPayMethods;
import com.android.ttcjpaysdk.base.ui.data.FrontPayTypeData;
import com.android.ttcjpaysdk.base.ui.data.VoucherRetainInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayCheckoutCounterResponseBean;
import com.android.ttcjpaysdk.thirdparty.data.CJPayPayTypeInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayPaymentMethodInfo;
import com.android.ttcjpaysdk.thirdparty.data.FrontSubPayTypeInfo;
import com.android.ttcjpaysdk.thirdparty.data.FrontSubPayTypeSumInfo;
import com.android.ttcjpaysdk.thirdparty.utils.StdPaymentMethodUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001+B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J.\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u0004H\u0002J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0004J,\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u0004J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0004J,\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u0004J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0004J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0004JJ\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0016j\b\u0012\u0004\u0012\u00020\b`\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\b\b\u0002\u0010\r\u001a\u00020\u0004J\u001a\u0010\u001e\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u0004J\u0018\u0010\u001f\u001a\u0004\u0018\u00010\b2\u0006\u0010 \u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J \u0010!\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0006\u0012\u0004\u0018\u00010$0\"*\u00020\b2\u0006\u0010%\u001a\u00020&J$\u0010'\u001a\u00020#*\u00020\b2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0004H\u0002¨\u0006,"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/utils/CJPayPaymentMethodUtils;", "", "()V", "containsAvailableForeignCard", "", "counterResponse", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayCheckoutCounterResponseBean;", "createCommonMethod", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayPaymentMethodInfo;", "typeInfo", "Lcom/android/ttcjpaysdk/thirdparty/data/FrontSubPayTypeInfo;", "isSelect", "isCombineCardSelect", "hasCombine", "createPaymentMethodForBalance", "createPaymentMethodForBankCard", "createPaymentMethodForCreditPay", "createPaymentMethodForNewCard", "createPaymentMethodForSharePay", "getDefaultPaymentMethod", "getPaymentMethodFromTypeInfo", "getPaymentMethodList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "selectedMethod", "unavailableCardIds", "", "", "getUsableCard", "transCombineMethod", e.f25671s, "buildVoucherShowInfo", "Lkotlin/Pair;", "", "Lcom/android/ttcjpaysdk/base/ui/data/FrontPayTypeData$VoucherShowInfo;", "retainRewardBean", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/utils/CJPayPaymentMethodUtils$RetainRewardBean;", "getVoucherShowInfoType", "useRetainReward", "hasRetainRewardChange", "isUseAddiVoucher", "RetainRewardBean", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayPaymentMethodUtils {
    public static final CJPayPaymentMethodUtils INSTANCE = null;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J'\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/utils/CJPayPaymentMethodUtils$RetainRewardBean;", "", "useRetainReward", "", "hasRetainRewardChange", "isUseAddiVoucher", "(ZZZ)V", "getHasRetainRewardChange", "()Z", "getUseRetainReward", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class RetainRewardBean {
        private final boolean hasRetainRewardChange;
        private final boolean isUseAddiVoucher;
        private final boolean useRetainReward;

        public static /* synthetic */ RetainRewardBean copy$default(RetainRewardBean r100, boolean r101, boolean r102, boolean r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.useRetainReward;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.hasRetainRewardChange;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.isUseAddiVoucher;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final boolean component1() {
            return this.useRetainReward;
        }

        public final boolean component2() {
            return this.hasRetainRewardChange;
        }

        public final boolean component3() {
            return this.isUseAddiVoucher;
        }

        public final RetainRewardBean copy(boolean r100, boolean r101, boolean r102) {
            return new RetainRewardBean(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof RetainRewardBean) == true) goto L8;
            return false;
        L8:
            RetainRewardBean r101 = (RetainRewardBean) r100;
            if (this.useRetainReward == r101.useRetainReward) goto L12;
            return false;
        L12:
            if (this.hasRetainRewardChange == r101.hasRetainRewardChange) goto L15;
            return false;
        L15:
            if (this.isUseAddiVoucher == r101.isUseAddiVoucher) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r100 = 1231;
            if (this.useRetainReward == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.hasRetainRewardChange == false) goto L9;
            int r103 = 1231;
        L10:
            int r104 = (r102 + r103) * 31;
            if (this.isUseAddiVoucher == true) goto L15;
            r100 = 1237;
        L15:
            return r104 + r100;
        L9:
            r103 = 1237;
            goto L10
        L5:
            r101 = 1237;
            goto L6
        }

        public String toString() {
            return "RetainRewardBean(useRetainReward=" + this.useRetainReward + ", hasRetainRewardChange=" + this.hasRetainRewardChange + ", isUseAddiVoucher=" + this.isUseAddiVoucher + ')';
        }

        public final boolean getHasRetainRewardChange() {
            return this.hasRetainRewardChange;
        }

        public final boolean getUseRetainReward() {
            return this.useRetainReward;
        }

        public final boolean isUseAddiVoucher() {
            return this.isUseAddiVoucher;
        }

        public RetainRewardBean(boolean r100, boolean r101, boolean r102) {
            this.useRetainReward = r100;
            this.hasRetainRewardChange = r101;
            this.isUseAddiVoucher = r102;
        }
    }

    static {
        INSTANCE = new CJPayPaymentMethodUtils();
    }

    private CJPayPaymentMethodUtils() {
    }

    public final boolean containsAvailableForeignCard(CJPayCheckoutCounterResponseBean r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        CashierPageInfoBean r101 = r100.cashier_page_info;
        Object r102 = null;
        if (r101 == null) goto L10;
        AssetInfoBean r103 = r101.asset_info;
        if (r103 == null) goto L10;
        ArrayList<AssetInfoBean> r104 = r103.sub_asset_info_list;
    L11:
        if (r104 == null) goto L26;
        Iterator<T> r105 = r104.iterator();
    L14:
        if (r105.hasNext() == false) goto L24;
        Object r106 = r105.next();
        AssetInfoBean r107 = (AssetInfoBean) r106;
        if (Intrinsics.areEqual("1", r107.asset_basic_show_info.status) == true) goto L18;
    L20:
        boolean r108 = false;
    L21:
        if (r108 == false) goto L14;
        r102 = r106;
        goto L24
    L18:
        if (Intrinsics.areEqual(r107.ext_info.is_foreign_card, "1") == false) goto L20;
        r108 = true;
    L24:
        if (((AssetInfoBean) r102) == null) goto L26;
        return true;
    L26:
        return false;
    L10:
        r104 = null;
        goto L11
    }

    public final CJPayPaymentMethodInfo getDefaultPaymentMethod(CJPayCheckoutCounterResponseBean r110) {
        if (r110 == null) goto L5;
        Boolean r100 = Boolean.valueOf(r110.isAssetStandard());
    L7:
        if (r100 == null) goto L9;
        boolean r101 = r100.booleanValue();
    L10:
        if (r101 == false) goto L20;
        if (r110 == null) goto L65;
        CashierPageInfoBean r111 = r110.cashier_page_info;
        if (r111 == null) goto L66;
        AssetInfoBean r112 = r111.asset_info;
        if (r112 == null) goto L67;
        AssetInfoBean r113 = r112.getChoosedSubAssetInfo();
        if (r113 != null) goto L19;
        return null;
    L19:
        return StdPaymentMethodUtils.createPaymentMethod$default(StdPaymentMethodUtils.INSTANCE, r113, false, 2, null);
    L67:
        return null;
    L66:
        return null;
    L65:
        return null;
    L20:
        if (r110 == null) goto L69;
        CJPayPayTypeInfo r114 = r110.paytype_info;
        if (r114 == null) goto L70;
        FrontSubPayTypeSumInfo r115 = r114.sub_pay_type_sum_info;
        if (r115 == null) goto L71;
        ArrayList<FrontSubPayTypeInfo> r116 = r115.sub_pay_type_info_list;
        if (r116 == null) goto L72;
        Iterator<T> r117 = r116.iterator();
    L29:
        if (r117.hasNext() == false) goto L33;
        Object r102 = r117.next();
        if (((FrontSubPayTypeInfo) r102).choose == false) goto L29;
    L34:
        FrontSubPayTypeInfo r103 = (FrontSubPayTypeInfo) r102;
        if (r103 == null) goto L73;
        String r118 = r103.sub_pay_type;
        if (r118 != null) goto L39;
        return null;
    L39:
        switch(r118.hashCode()) {
            case -1787710669: goto L57;
            case -1581701048: goto L53;
            case -563976606: goto L49;
            case -339185956: goto L46;
            case -127611052: goto L42;
            default: goto L76;
        };
    L76:
        return null;
    L42:
        if (r118.equals("new_bank_card") == false) goto L77;
        CJPayPaymentMethodInfo r119 = createPaymentMethodForNewCard$default(INSTANCE, r103, true, false, false, 12, null);
    L61:
        return r119;
    L77:
        return null;
    L46:
        if (r118.equals("balance") == false) goto L75;
        r119 = INSTANCE.createPaymentMethodForBalance(r103, true);
        goto L61
    L75:
        return null;
    L49:
        if (r118.equals("credit_pay") == false) goto L78;
        r119 = INSTANCE.createPaymentMethodForCreditPay(r103, true);
        goto L61
    L78:
        return null;
    L53:
        if (r118.equals("share_pay") == false) goto L79;
        r119 = INSTANCE.createPaymentMethodForSharePay(r103, true);
        goto L61
    L79:
        return null;
    L57:
        if (r118.equals("bank_card") == false) goto L80;
        r119 = createPaymentMethodForBankCard$default(INSTANCE, r103, true, false, false, 12, null);
        goto L61
    L80:
        return null;
    L73:
        return null;
    L33:
        r102 = null;
        goto L34
    L72:
        return null;
    L71:
        return null;
    L70:
        return null;
    L69:
        return null;
    L9:
        r101 = false;
        goto L10
    L5:
        r100 = null;
        goto L7
    }

    public final Pair<String, FrontPayTypeData.VoucherShowInfo> buildVoucherShowInfo(CJPayPaymentMethodInfo r100, RetainRewardBean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "retainRewardBean");
        HashMap<String, FrontPayTypeData.VoucherShowInfo> r102 = r100.voucher_show_info;
        if (Intrinsics.areEqual(r100.paymentType, "creditpay") == false) goto L9;
        CJPayCreditPayMethods r103 = CJPayOuterPayMethodUtils.INSTANCE.getChoseCreditMethod(r100);
        if (r103 == null) goto L9;
        HashMap<String, FrontPayTypeData.VoucherShowInfo> r104 = r103.voucher_show_info;
        if (r104 == null) goto L9;
        r102 = r104;
    L9:
        String r105 = getVoucherShowInfoType(r100, r101.getUseRetainReward(), r101.getHasRetainRewardChange(), r101.isUseAddiVoucher());
        FrontPayTypeData.VoucherShowInfo r106 = r102.get(r105);
        if (r106 != null) goto L17;
        r106 = r102.get("promotion_retain_normal");
        if (r101.getUseRetainReward() == false) goto L15;
        if (r106 != null) goto L17;
    L15:
        r106 = r102.get("default_voucher");
    L17:
        return TuplesKt.to(r105, r106);
    }

    public final CJPayPaymentMethodInfo createPaymentMethodForBalance(FrontSubPayTypeInfo r100, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "typeInfo");
        CJPayPaymentMethodInfo r101 = createCommonMethod$default(this, r100, r110, false, false, 12, null);
        r101.index = r100.index;
        r101.icon_url = r100.icon_url;
        r101.status = r100.status;
        r101.title = r100.title;
        r101.sub_title = r100.sub_title;
        String r102 = "";
        r101.sub_title_icon = "";
        r101.mark = r100.mark;
        FrontPayTypeData r103 = r100.pay_type_data;
        r101.mobile_mask = r103.mobile_mask;
        r101.voucher_info = r103.voucher_info;
        r101.voucher_msg_list = r103.voucher_msg_list;
        r101.identity_verify_way = r100.identity_verify_way;
        r101.show_combine_pay = r103.show_combine_pay;
        r101.isChecked = r110;
        r101.paymentType = "balance";
        r101.card_no = "balance";
        r101.pay_type_data = (FrontPayTypeData) CJPayJsonParser.fromJson(CJPayJsonParser.toJsonObject(r103), FrontPayTypeData.class);
        FrontPayTypeData r111 = r100.pay_type_data;
        r101.standardRecDesc = r111.standard_rec_desc;
        r101.amount_area_list = r111.amount_area_list;
        r101.standard_voucher_label = r111.standard_voucher_label;
        r101.standard_retain_voucher_label = r111.standard_retain_voucher_label;
        r101.fold_voucher_info = r111.fold_voucher_info;
        r101.standardShowAmount = r111.standard_show_amount;
        r101.trade_confirm_button_label = r100.trade_confirm_button_label;
        ArrayList<CJPayAddiItemInfo> r104 = null;
        if (r111 == null) goto L5;
        VoucherRetainInfo r105 = r111.voucher_retain_info;
    L6:
        r101.voucher_retain_info = r105;
        if (r111 == null) goto L9;
        VoucherRetainInfo r106 = r111.superimposed_retain_info;
    L10:
        r101.superimposed_retain_info = r106;
        r101.out_display_info = r111.out_display_info;
        if (r111 == null) goto L13;
        String r107 = r111.crossed_price;
    L14:
        r101.crossed_price = r107;
        if (r111 == null) goto L17;
        r104 = r111.pay_addi_item_list;
    L17:
        r101.pay_addi_item_list = r104;
        if (r111 == null) goto L20;
        boolean r108 = r111.need_show_voucher_enhance;
    L21:
        r101.need_show_voucher_enhance = r108;
        if (r111 == null) goto L27;
        String r109 = r111.trade_confirm_voucher_enhance_msg;
        if (r109 == null) goto L27;
        r102 = r109;
    L27:
        r101.trade_confirm_voucher_enhance_msg = r102;
        return r101;
    L20:
        r108 = false;
        goto L21
    L13:
        r107 = null;
        goto L14
    L9:
        r106 = null;
        goto L10
    L5:
        r105 = null;
        goto L6
    }

    public final CJPayPaymentMethodInfo createPaymentMethodForCreditPay(FrontSubPayTypeInfo r100, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "typeInfo");
        CJPayPaymentMethodInfo r101 = createCommonMethod$default(this, r100, r110, false, false, 12, null);
        r101.index = r100.index;
        r101.icon_url = r100.icon_url;
        r101.status = r100.status;
        r101.title = r100.title;
        r101.sub_title = r100.sub_title;
        String r102 = "";
        r101.sub_title_icon = "";
        r101.mark = r100.mark;
        r101.card_no = "creditpay";
        r101.isChecked = r110;
        r101.paymentType = "creditpay";
        r101.identity_verify_way = r100.identity_verify_way;
        r101.pay_type_data = (FrontPayTypeData) CJPayJsonParser.fromJson(CJPayJsonParser.toJsonObject(r100.pay_type_data), FrontPayTypeData.class);
        FrontPayTypeData r111 = r100.pay_type_data;
        r101.standardRecDesc = r111.standard_rec_desc;
        r101.amount_area_list = r111.amount_area_list;
        r101.standard_voucher_label = r111.standard_voucher_label;
        r101.standard_retain_voucher_label = r111.standard_retain_voucher_label;
        r101.fold_voucher_info = r111.fold_voucher_info;
        r101.voucher_info = r111.voucher_info;
        r101.standardShowAmount = r111.standard_show_amount;
        boolean r103 = false;
        r101.selectedInstallmentIndex = 0;
        r101.trade_confirm_button_label = r100.trade_confirm_button_label;
        r101.voucher_retain_info = r111.voucher_retain_info;
        r101.superimposed_retain_info = r111.superimposed_retain_info;
        r101.out_display_info = r111.out_display_info;
        ArrayList<CJPayAddiItemInfo> r104 = null;
        if (r111 == null) goto L5;
        String r105 = r111.crossed_price;
    L6:
        r101.crossed_price = r105;
        if (r111 == null) goto L9;
        r104 = r111.pay_addi_item_list;
    L9:
        r101.pay_addi_item_list = r104;
        if (r111 == null) goto L12;
        r103 = r111.need_show_voucher_enhance;
    L12:
        r101.need_show_voucher_enhance = r103;
        if (r111 == null) goto L18;
        String r106 = r111.trade_confirm_voucher_enhance_msg;
        if (r106 == null) goto L18;
        r102 = r106;
    L18:
        r101.trade_confirm_voucher_enhance_msg = r102;
        return r101;
    L5:
        r105 = null;
        goto L6
    }

    public final CJPayPaymentMethodInfo createPaymentMethodForSharePay(FrontSubPayTypeInfo r100, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "typeInfo");
        CJPayPaymentMethodInfo r101 = createCommonMethod$default(this, r100, r110, false, false, 12, null);
        r101.index = r100.index;
        r101.icon_url = r100.icon_url;
        FrontPayTypeData r102 = r100.pay_type_data;
        r101.bank_card_id = r102.bank_card_id;
        r101.card_level = r102.card_level;
        r101.status = r100.status;
        r101.title = r100.title;
        r101.sub_title = r100.msg;
        r101.card_no = "share_pay";
        r101.paymentType = "share_pay";
        r101.mobile_mask = r102.mobile_mask;
        String r103 = "";
        r101.sub_title_icon = "";
        if (TextUtils.isEmpty(r100.mark) == true) goto L5;
        r101.mark = r100.mark;
    L5:
        FrontPayTypeData r104 = r100.pay_type_data;
        r101.front_bank_code_name = r104.bank_name;
        r101.front_bank_code = r104.bank_code;
        r101.card_no_mask = r104.card_no_mask;
        r101.card_show_name = r104.card_show_name;
        r101.isChecked = r110;
        r101.standardRecDesc = r104.standard_rec_desc;
        r101.standard_voucher_label = r104.standard_voucher_label;
        r101.standard_retain_voucher_label = r104.standard_retain_voucher_label;
        r101.fold_voucher_info = r104.fold_voucher_info;
        r101.standardShowAmount = r104.standard_show_amount;
        r101.voucher_info = r104.voucher_info;
        r101.voucher_msg_list = r104.voucher_msg_list;
        r101.pay_type_data = (FrontPayTypeData) CJPayJsonParser.fromJson(CJPayJsonParser.toJsonObject(r104), FrontPayTypeData.class);
        r101.identity_verify_way = r100.identity_verify_way;
        r101.trade_confirm_button_label = r100.trade_confirm_button_label;
        FrontPayTypeData r105 = r100.pay_type_data;
        ArrayList<CJPayAddiItemInfo> r111 = null;
        if (r105 == null) goto L8;
        VoucherRetainInfo r106 = r105.voucher_retain_info;
    L9:
        r101.voucher_retain_info = r106;
        if (r105 == null) goto L12;
        String r107 = r105.crossed_price;
    L13:
        r101.crossed_price = r107;
        r101.out_display_info = r105.out_display_info;
        if (r105 == null) goto L16;
        String r108 = r105.share_asset_code;
    L17:
        r101.share_asset_code = r108;
        if (r105 == null) goto L20;
        String r109 = r105.share_asset_id;
    L21:
        r101.share_asset_id = r109;
        if (r105 == null) goto L24;
        r111 = r105.pay_addi_item_list;
    L24:
        r101.pay_addi_item_list = r111;
        if (r105 == null) goto L27;
        boolean r112 = r105.need_show_voucher_enhance;
    L28:
        r101.need_show_voucher_enhance = r112;
        if (r105 == null) goto L34;
        String r113 = r105.trade_confirm_voucher_enhance_msg;
        if (r113 == null) goto L34;
        r103 = r113;
    L34:
        r101.trade_confirm_voucher_enhance_msg = r103;
        r101.superimposed_retain_info = r105.superimposed_retain_info;
        return r101;
    L27:
        r112 = false;
        goto L28
    L20:
        r109 = null;
        goto L21
    L16:
        r108 = null;
        goto L17
    L12:
        r107 = null;
        goto L13
    L8:
        r106 = null;
        goto L9
    }

    public final CJPayPaymentMethodInfo getPaymentMethodFromTypeInfo(FrontSubPayTypeInfo r100, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "typeInfo");
        String r101 = r100.sub_pay_type;
        if (r101 != null) goto L5;
    L26:
        return null;
    L5:
        switch(r101.hashCode()) {
            case -1787710669: goto L23;
            case -1581701048: goto L19;
            case -563976606: goto L15;
            case -339185956: goto L12;
            case -127611052: goto L8;
            default: goto L26;
        };
    L8:
        if (r101.equals("new_bank_card") == false) goto L26;
        return createPaymentMethodForNewCard$default(this, r100, true, false, r110, 4, null);
    L12:
        if (r101.equals("balance") == false) goto L26;
        return createPaymentMethodForBalance(r100, true);
    L15:
        if (r101.equals("credit_pay") == false) goto L26;
        return createPaymentMethodForCreditPay(r100, true);
    L19:
        if (r101.equals("share_pay") == false) goto L26;
        return createPaymentMethodForSharePay(r100, true);
    L23:
        if (r101.equals("bank_card") == false) goto L26;
        return createPaymentMethodForBankCard$default(this, r100, true, false, r110, 4, null);
    }

    public final CJPayPaymentMethodInfo getUsableCard(CJPayCheckoutCounterResponseBean r100, boolean r110) {
        CJPayPaymentMethodInfo r101 = null;
        if (r100 == null) goto L25;
        CJPayPayTypeInfo r102 = r100.paytype_info;
        if (r102 == null) goto L25;
        FrontSubPayTypeSumInfo r103 = r102.sub_pay_type_sum_info;
        if (r103 == null) goto L25;
        ArrayList<FrontSubPayTypeInfo> r104 = r103.sub_pay_type_info_list;
        if (r104 == null) goto L25;
        Iterator<T> r105 = r104.iterator();
    L12:
        if (r105.hasNext() == false) goto L21;
        Object r106 = r105.next();
        FrontSubPayTypeInfo r107 = (FrontSubPayTypeInfo) r106;
        if (Intrinsics.areEqual(r107.status, "1") == true) goto L16;
    L18:
        boolean r108 = false;
    L19:
        if (r108 == false) goto L12;
    L22:
        FrontSubPayTypeInfo r109 = (FrontSubPayTypeInfo) r106;
        if (r109 == null) goto L25;
        CJPayPaymentMethodInfo r111 = INSTANCE.createPaymentMethodForBankCard(r109, true, true, r110);
    L26:
        if (r111 != null) goto L61;
        if (r100 == null) goto L50;
        CJPayPayTypeInfo r112 = r100.paytype_info;
        if (r112 == null) goto L50;
        FrontSubPayTypeSumInfo r113 = r112.sub_pay_type_sum_info;
        if (r113 == null) goto L50;
        ArrayList<FrontSubPayTypeInfo> r114 = r113.sub_pay_type_info_list;
        if (r114 == null) goto L50;
        Iterator<T> r115 = r114.iterator();
    L36:
        if (r115.hasNext() == false) goto L45;
        Object r116 = r115.next();
        FrontSubPayTypeInfo r117 = (FrontSubPayTypeInfo) r116;
        if (Intrinsics.areEqual(r117.status, "1") == true) goto L40;
    L42:
        boolean r118 = false;
    L43:
        if (r118 == false) goto L36;
    L46:
        FrontSubPayTypeInfo r119 = (FrontSubPayTypeInfo) r116;
        if (r119 == null) goto L50;
        r101 = INSTANCE.createPaymentMethodForNewCard(r119, true, true, r110);
        goto L50
    L40:
        if (Intrinsics.areEqual(r117.sub_pay_type, "new_bank_card") == false) goto L42;
        r118 = true;
        goto L43
    L45:
        r116 = null;
    L50:
        return r101;
    L61:
        return r111;
    L16:
        if (Intrinsics.areEqual(r107.sub_pay_type, "bank_card") == false) goto L18;
        r108 = true;
        goto L19
    L21:
        r106 = null;
    L25:
        r111 = null;
        goto L26
    }

    public final CJPayPaymentMethodInfo transCombineMethod(CJPayPaymentMethodInfo r110, CJPayCheckoutCounterResponseBean r111) {
        Intrinsics.checkNotNullParameter(r110, e.f25671s);
        Intrinsics.checkNotNullParameter(r111, "counterResponse");
        CJPayPayTypeInfo r112 = r111.paytype_info;
        if (r112 == null) goto L19;
        FrontSubPayTypeSumInfo r113 = r112.sub_pay_type_sum_info;
        if (r113 == null) goto L19;
        ArrayList<FrontSubPayTypeInfo> r114 = r113.sub_pay_type_info_list;
        if (r114 == null) goto L19;
        Iterator<T> r115 = r114.iterator();
    L10:
        if (r115.hasNext() == false) goto L17;
        Object r100 = r115.next();
        if (((FrontSubPayTypeInfo) r100).index != r110.index) goto L14;
        boolean r101 = true;
    L15:
        if (r101 == false) goto L10;
    L18:
        FrontSubPayTypeInfo r102 = (FrontSubPayTypeInfo) r100;
    L20:
        if (r102 == null) goto L22;
        String r116 = r102.sub_pay_type;
    L24:
        if (Intrinsics.areEqual(r116, "bank_card") == false) goto L27;
        return createPaymentMethodForBankCard$default(this, r102, true, false, true, 4, null);
    L27:
        if (Intrinsics.areEqual(r116, "new_bank_card") == true) goto L29;
        return null;
    L29:
        return createPaymentMethodForNewCard$default(this, r102, true, false, true, 4, null);
    L22:
        r116 = null;
        goto L24
    L14:
        r101 = false;
        goto L15
    L17:
        r100 = null;
    L19:
        r102 = null;
        goto L20
    }

    private final CJPayPaymentMethodInfo createCommonMethod(FrontSubPayTypeInfo r100, boolean r101, boolean r102, boolean r103) {
        CJPayPaymentMethodInfo r104 = new CJPayPaymentMethodInfo();
        String r105 = null;
        if (r103 == false) goto L17;
        FrontPayTypeData r106 = r100.pay_type_data;
        if (r106 == null) goto L9;
        FrontPayTypeData.CombinePayInfo r107 = r106.combine_pay_info;
        if (r107 == null) goto L9;
        FrontPayTypeData.PromotionShowPriority r108 = r107.promotion_show_priority;
    L10:
        r104.promotion_show_priority = r108;
        if (r106 == null) goto L15;
        FrontPayTypeData.CombinePayInfo r109 = r106.combine_pay_info;
        if (r109 == null) goto L15;
        HashMap<String, FrontPayTypeData.VoucherShowInfo> r110 = r109.voucher_show_info;
    L16:
        r104.voucher_show_info = r110;
    L26:
        FrontPayTypeData r111 = r100.pay_type_data;
        if (r111 == null) goto L31;
        FrontPayTypeData.CombinePayInfo r112 = r111.combine_pay_info;
        if (r112 == null) goto L31;
        String r113 = r112.right_top_button;
    L32:
        r104.combine_right_top_button = r113;
        if (r111 == null) goto L37;
        FrontPayTypeData.CombinePayInfo r114 = r111.combine_pay_info;
        if (r114 == null) goto L37;
        r105 = r114.combine_pay_title;
    L37:
        r104.combine_pay_title = r105;
        return r104;
    L31:
        r113 = null;
    L15:
        r110 = null;
    L9:
        r108 = null;
        goto L10
    L17:
        FrontPayTypeData r115 = r100.pay_type_data;
        if (r115 == null) goto L20;
        FrontPayTypeData.PromotionShowPriority r116 = r115.promotion_show_priority;
    L21:
        r104.promotion_show_priority = r116;
        if (r115 == null) goto L24;
        HashMap<String, FrontPayTypeData.VoucherShowInfo> r117 = r115.voucher_show_info;
    L25:
        r104.voucher_show_info = r117;
        goto L26
    L24:
        r117 = null;
        goto L25
    L20:
        r116 = null;
        goto L21
    }

    private final String getVoucherShowInfoType(CJPayPaymentMethodInfo r100, boolean r101, boolean r102, boolean r103) {
        FrontPayTypeData.PromotionShowPriority r104 = r100.promotion_show_priority;
        if (Intrinsics.areEqual(r100.paymentType, "creditpay") == false) goto L10;
        CJPayCreditPayMethods r105 = CJPayOuterPayMethodUtils.INSTANCE.getChoseCreditMethod(r100);
        if (r105 == null) goto L10;
        FrontPayTypeData.PromotionShowPriority r106 = r105.promotion_show_priority;
        if (r106 == null) goto L10;
        r104 = r106;
    L10:
        if (r101 == false) goto L18;
        if (r102 == false) goto L15;
        if (r103 == false) goto L14;
        String r107 = r104.first_retain_type;
    L22:
        return KtSafeMethodExtensionKt.or(r107, "default_voucher");
    L14:
        r107 = r104.second_retain_type;
        goto L22
    L15:
        if (r103 == false) goto L17;
        r107 = r104.first_retain_type;
        goto L22
    L17:
        r107 = "promotion_retain_normal";
        goto L22
    L18:
        if (r103 == false) goto L20;
        r107 = "default_pay_and_x";
        goto L22
    L20:
        r107 = "default_voucher";
        goto L22
    }

    public final CJPayPaymentMethodInfo createPaymentMethodForBankCard(FrontSubPayTypeInfo r100, boolean r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "typeInfo");
        CJPayPaymentMethodInfo r104 = createCommonMethod(r100, r101, r102, r103);
        r104.index = r100.index;
        r104.icon_url = r100.icon_url;
        FrontPayTypeData r105 = r100.pay_type_data;
        r104.bank_card_id = r105.bank_card_id;
        int r106 = r105.card_level;
        r104.card_level = r106;
        r104.status = r100.status;
        r104.title = r100.title;
        r104.sub_title = r100.msg;
        r104.card_no = r105.card_no;
        r104.mobile_mask = r105.mobile_mask;
        String r107 = "";
        r104.sub_title_icon = "";
        if (2 != r106) goto L6;
        r104.mark = r100.mark;
    L8:
        FrontPayTypeData r108 = r100.pay_type_data;
        r104.front_bank_code_name = r108.bank_name;
        r104.front_bank_code = r108.bank_code;
        r104.card_no_mask = r108.card_no_mask;
        r104.card_show_name = r108.card_show_name;
        boolean r109 = false;
        ArrayList<CJPayAddiItemInfo> r110 = null;
        if (r103 == false) goto L42;
        r104.paymentType = "combinepay";
        if (r102 == true) goto L15;
        if (r101 == true) goto L15;
        boolean r111 = false;
    L16:
        r104.isChecked = r111;
        FrontPayTypeData.CombinePayInfo r112 = r108.combine_pay_info;
        r104.standardRecDesc = r112.standard_rec_desc;
        r104.amount_area_list = r112.amount_area_list;
        r104.standard_voucher_label = r112.standard_voucher_label;
        r104.standard_retain_voucher_label = r112.standard_retain_voucher_label;
        r104.fold_voucher_info = r112.fold_voucher_info;
        r104.standardShowAmount = r112.standard_show_amount;
        r104.voucher_info = r112.voucher_info;
        r104.voucher_msg_list = r112.voucher_msg_list;
        r104.crossed_price = r112.crossed_price;
        if (r108 == null) goto L20;
        if (r112 == null) goto L20;
        VoucherRetainInfo r113 = r112.voucher_retain_info;
    L21:
        r104.voucher_retain_info = r113;
        if (r108 == null) goto L25;
        if (r112 == null) goto L25;
        VoucherRetainInfo r114 = r112.superimposed_retain_info;
    L26:
        r104.superimposed_retain_info = r114;
        if (r108 == null) goto L30;
        if (r112 == null) goto L30;
        r110 = r112.pay_addi_item_list;
    L30:
        r104.pay_addi_item_list = r110;
        if (r108 == null) goto L34;
        if (r112 == null) goto L34;
        r109 = r112.need_show_voucher_enhance;
    L34:
        r104.need_show_voucher_enhance = r109;
        if (r108 == null) goto L41;
        if (r112 == null) goto L41;
        String r115 = r112.trade_confirm_voucher_enhance_msg;
        if (r115 == null) goto L41;
        r107 = r115;
    L41:
        r104.trade_confirm_voucher_enhance_msg = r107;
    L67:
        r104.pay_type_data = (FrontPayTypeData) CJPayJsonParser.fromJson(CJPayJsonParser.toJsonObject(r108), FrontPayTypeData.class);
        r104.identity_verify_way = r100.identity_verify_way;
        r104.trade_confirm_button_label = r100.trade_confirm_button_label;
        r104.out_display_info = r100.pay_type_data.out_display_info;
        return r104;
    L25:
        r114 = null;
    L20:
        r113 = null;
    L15:
        r111 = true;
        goto L16
    L42:
        r104.paymentType = "quickpay";
        r104.isChecked = r101;
        r104.standardRecDesc = r108.standard_rec_desc;
        r104.amount_area_list = r108.amount_area_list;
        r104.standard_voucher_label = r108.standard_voucher_label;
        r104.standard_retain_voucher_label = r108.standard_retain_voucher_label;
        r104.fold_voucher_info = r108.fold_voucher_info;
        r104.standardShowAmount = r108.standard_show_amount;
        r104.voucher_info = r108.voucher_info;
        r104.voucher_msg_list = r108.voucher_msg_list;
        if (r108 == null) goto L45;
        String r116 = r108.crossed_price;
    L46:
        r104.crossed_price = r116;
        if (r108 == null) goto L49;
        VoucherRetainInfo r117 = r108.voucher_retain_info;
    L50:
        r104.voucher_retain_info = r117;
        if (r108 == null) goto L53;
        VoucherRetainInfo r118 = r108.superimposed_retain_info;
    L54:
        r104.superimposed_retain_info = r118;
        if (r108 == null) goto L57;
        r110 = r108.pay_addi_item_list;
    L57:
        r104.pay_addi_item_list = r110;
        if (r108 == null) goto L60;
        r109 = r108.need_show_voucher_enhance;
    L60:
        r104.need_show_voucher_enhance = r109;
        if (r108 == null) goto L66;
        String r119 = r108.trade_confirm_voucher_enhance_msg;
        if (r119 == null) goto L66;
        r107 = r119;
    L66:
        r104.trade_confirm_voucher_enhance_msg = r107;
        goto L67
    L53:
        r118 = null;
        goto L54
    L49:
        r117 = null;
        goto L50
    L45:
        r116 = null;
        goto L46
    L6:
        if (TextUtils.isEmpty(r100.mark) == true) goto L8;
        r104.mark = r100.mark;
        goto L8
    }

    public final CJPayPaymentMethodInfo createPaymentMethodForNewCard(FrontSubPayTypeInfo r100, boolean r101, boolean r102, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "typeInfo");
        CJPayPaymentMethodInfo r103 = createCommonMethod(r100, r101, r102, r110);
        r103.index = r100.index;
        r103.icon_url = r100.icon_url;
        r103.status = r100.status;
        r103.title = r100.title;
        r103.sub_title = r100.sub_title;
        r103.mark = r100.mark;
        r103.card_no = "addcard";
        FrontPayTypeData r104 = r100.pay_type_data;
        r103.front_bank_code = r104.bank_code;
        String r105 = "";
        boolean r106 = false;
        ArrayList<CJPayAddiItemInfo> r107 = null;
        if (r110 == false) goto L36;
        r103.paymentType = "combinepay";
        if (r101 == true) goto L9;
        if (r102 == true) goto L9;
        boolean r108 = false;
    L10:
        r103.isChecked = r108;
        FrontPayTypeData.CombinePayInfo r109 = r104.combine_pay_info;
        r103.standardRecDesc = r109.standard_rec_desc;
        r103.amount_area_list = r109.amount_area_list;
        r103.standard_voucher_label = r109.standard_voucher_label;
        r103.standard_retain_voucher_label = r109.standard_retain_voucher_label;
        r103.fold_voucher_info = r109.fold_voucher_info;
        r103.standardShowAmount = r109.standard_show_amount;
        r103.voucher_info = r109.voucher_info;
        r103.voucher_msg_list = r109.voucher_msg_list;
        r103.crossed_price = r109.crossed_price;
        if (r104 == null) goto L14;
        if (r109 == null) goto L14;
        VoucherRetainInfo r111 = r109.voucher_retain_info;
    L15:
        r103.voucher_retain_info = r111;
        if (r104 == null) goto L19;
        if (r109 == null) goto L19;
        VoucherRetainInfo r112 = r109.superimposed_retain_info;
    L20:
        r103.superimposed_retain_info = r112;
        if (r104 == null) goto L24;
        if (r109 == null) goto L24;
        r107 = r109.pay_addi_item_list;
    L24:
        r103.pay_addi_item_list = r107;
        if (r104 == null) goto L28;
        if (r109 == null) goto L28;
        r106 = r109.need_show_voucher_enhance;
    L28:
        r103.need_show_voucher_enhance = r106;
        if (r104 == null) goto L35;
        if (r109 == null) goto L35;
        String r113 = r109.trade_confirm_voucher_enhance_msg;
        if (r113 == null) goto L35;
        r105 = r113;
    L35:
        r103.trade_confirm_voucher_enhance_msg = r105;
    L61:
        r103.pay_type_data = (FrontPayTypeData) CJPayJsonParser.fromJson(CJPayJsonParser.toJsonObject(r104), FrontPayTypeData.class);
        r103.identity_verify_way = r100.identity_verify_way;
        FrontPayTypeData r114 = r100.pay_type_data;
        r103.card_add_ext = r114.card_add_ext;
        r103.card_type_name = r114.card_type;
        r103.trade_confirm_button_label = r100.trade_confirm_button_label;
        r103.out_display_info = r114.out_display_info;
        return r103;
    L19:
        r112 = null;
    L14:
        r111 = null;
    L9:
        r108 = true;
        goto L10
    L36:
        r103.paymentType = "addcard";
        r103.isChecked = r101;
        r103.standardRecDesc = r104.standard_rec_desc;
        r103.amount_area_list = r104.amount_area_list;
        r103.standard_voucher_label = r104.standard_voucher_label;
        r103.standard_retain_voucher_label = r104.standard_retain_voucher_label;
        r103.fold_voucher_info = r104.fold_voucher_info;
        r103.standardShowAmount = r104.standard_show_amount;
        r103.voucher_info = r104.voucher_info;
        r103.voucher_msg_list = r104.voucher_msg_list;
        if (r104 == null) goto L39;
        String r115 = r104.crossed_price;
    L40:
        r103.crossed_price = r115;
        if (r104 == null) goto L43;
        VoucherRetainInfo r116 = r104.voucher_retain_info;
    L44:
        r103.voucher_retain_info = r116;
        if (r104 == null) goto L47;
        VoucherRetainInfo r117 = r104.superimposed_retain_info;
    L48:
        r103.superimposed_retain_info = r117;
        if (r104 == null) goto L51;
        r107 = r104.pay_addi_item_list;
    L51:
        r103.pay_addi_item_list = r107;
        if (r104 == null) goto L54;
        r106 = r104.need_show_voucher_enhance;
    L54:
        r103.need_show_voucher_enhance = r106;
        if (r104 == null) goto L60;
        String r118 = r104.trade_confirm_voucher_enhance_msg;
        if (r118 == null) goto L60;
        r105 = r118;
    L60:
        r103.trade_confirm_voucher_enhance_msg = r105;
        goto L61
    L47:
        r117 = null;
        goto L48
    L43:
        r116 = null;
        goto L44
    L39:
        r115 = null;
        goto L40
    }

    public static /* synthetic */ CJPayPaymentMethodInfo createPaymentMethodForBalance$default(CJPayPaymentMethodUtils r100, FrontSubPayTypeInfo r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return r100.createPaymentMethodForBalance(r101, r102);
    }

    public static /* synthetic */ CJPayPaymentMethodInfo createPaymentMethodForCreditPay$default(CJPayPaymentMethodUtils r100, FrontSubPayTypeInfo r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return r100.createPaymentMethodForCreditPay(r101, r102);
    }

    public static /* synthetic */ CJPayPaymentMethodInfo createPaymentMethodForSharePay$default(CJPayPaymentMethodUtils r100, FrontSubPayTypeInfo r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return r100.createPaymentMethodForSharePay(r101, r102);
    }

    public final ArrayList<CJPayPaymentMethodInfo> getPaymentMethodList(Context r110, CJPayCheckoutCounterResponseBean r210, CJPayPaymentMethodInfo r211, List<Integer> r212, boolean r213) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r212, "unavailableCardIds");
        ArrayList<CJPayPaymentMethodInfo> r100 = new ArrayList();
        ArrayList r101 = new ArrayList();
        if (r210 == null) goto L65;
        CJPayPayTypeInfo r102 = r210.paytype_info;
        if (r102 == null) goto L65;
        FrontSubPayTypeSumInfo r103 = r102.sub_pay_type_sum_info;
        if (r103 == null) goto L65;
        ArrayList<FrontSubPayTypeInfo> r104 = r103.sub_pay_type_info_list;
        if (r104 == null) goto L65;
        Iterator<T> r105 = r104.iterator();
        int r106 = 0;
    L12:
        if (r105.hasNext() == false) goto L65;
        Object r107 = r105.next();
        int r111 = r106 + 1;
        if (r106 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        FrontSubPayTypeInfo r112 = (FrontSubPayTypeInfo) r107;
        boolean r108 = true;
        if (r211 != null) goto L19;
        if (r106 != 0) goto L25;
        boolean r113 = true;
    L26:
        if (r211 != null) goto L28;
    L30:
        r108 = false;
    L31:
        String r109 = r112.sub_pay_type;
        if (r109 == null) goto L64;
        switch(r109.hashCode()) {
            case -1787710669: goto L58;
            case -1581701048: goto L51;
            case -563976606: goto L47;
            case -339185956: goto L41;
            case -127611052: goto L37;
            default: goto L64;
        };
    L37:
        if (r109.equals("new_bank_card") == false) goto L64;
        r100.add(INSTANCE.createPaymentMethodForNewCard(r112, r113, r108, r213));
        goto L64
    L41:
        if (r109.equals("balance") == false) goto L64;
        if (r212.contains(Integer.valueOf(r112.index)) == false) goto L45;
        CJPayPaymentMethodInfo r114 = INSTANCE.createPaymentMethodForBalance(r112, r113);
        r114.sub_title = r110.getString(R.string.cj_pay_insufficient_balance);
        r114.localEnable = false;
        r101.add(r114);
        goto L64
    L45:
        r100.add(INSTANCE.createPaymentMethodForBalance(r112, r113));
        goto L64
    L47:
        if (r109.equals("credit_pay") == false) goto L64;
        r100.add(INSTANCE.createPaymentMethodForCreditPay(r112, r113));
        goto L64
    L51:
        if (r109.equals("share_pay") == false) goto L64;
        if (r212.contains(Integer.valueOf(r112.index)) == false) goto L56;
        CJPayPaymentMethodInfo r115 = INSTANCE.createPaymentMethodForSharePay(r112, r113);
        r115.sub_title = r110.getString(R.string.cj_pay_bank_card_insufficent);
        r115.localEnable = false;
        r101.add(r115);
        goto L64
    L56:
        r100.add(INSTANCE.createPaymentMethodForSharePay(r112, r113));
        goto L64
    L58:
        if (r109.equals("bank_card") == false) goto L64;
        if (r212.contains(Integer.valueOf(r112.index)) == false) goto L63;
        CJPayPaymentMethodInfo r116 = createPaymentMethodForBankCard$default(INSTANCE, r112, r113, false, false, 12, null);
        r116.sub_title = r110.getString(R.string.cj_pay_bank_card_insufficent);
        r116.localEnable = false;
        r101.add(r116);
        goto L64
    L63:
        r100.add(INSTANCE.createPaymentMethodForBankCard(r112, r113, r108, r213));
    L64:
        r106 = r111;
        goto L12
    L28:
        if (r211.selectedCombineCardIndex != r112.index) goto L30;
    L25:
        r113 = false;
        goto L26
    L19:
        if (r211.index != r112.index) goto L21;
        boolean r117 = true;
    L22:
        r113 = r117;
        goto L26
    L21:
        r117 = false;
    L65:
        r100.addAll(r101);
        return r100;
    }

    public static /* synthetic */ CJPayPaymentMethodInfo createCommonMethod$default(CJPayPaymentMethodUtils r100, FrontSubPayTypeInfo r101, boolean r102, boolean r103, boolean r104, int r105, Object r106) {
        if ((r105 & 2) == 0) goto L6;
        r102 = false;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r103 = false;
    L9:
        if ((r105 & 8) == 0) goto L12;
        r104 = false;
    L12:
        return r100.createCommonMethod(r101, r102, r103, r104);
    }

    public static /* synthetic */ CJPayPaymentMethodInfo createPaymentMethodForBankCard$default(CJPayPaymentMethodUtils r100, FrontSubPayTypeInfo r101, boolean r102, boolean r103, boolean r104, int r105, Object r106) {
        if ((r105 & 2) == 0) goto L6;
        r102 = false;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r103 = false;
    L9:
        if ((r105 & 8) == 0) goto L12;
        r104 = false;
    L12:
        return r100.createPaymentMethodForBankCard(r101, r102, r103, r104);
    }

    public static /* synthetic */ CJPayPaymentMethodInfo createPaymentMethodForNewCard$default(CJPayPaymentMethodUtils r100, FrontSubPayTypeInfo r101, boolean r102, boolean r103, boolean r104, int r105, Object r106) {
        if ((r105 & 2) == 0) goto L6;
        r102 = false;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r103 = false;
    L9:
        if ((r105 & 8) == 0) goto L12;
        r104 = false;
    L12:
        return r100.createPaymentMethodForNewCard(r101, r102, r103, r104);
    }

    public static /* synthetic */ ArrayList getPaymentMethodList$default(CJPayPaymentMethodUtils r100, Context r101, CJPayCheckoutCounterResponseBean r102, CJPayPaymentMethodInfo r103, List r110, boolean r111, int r112, Object r113) {
        if ((r112 & 16) == 0) goto L5;
        boolean r104 = false;
    L7:
        return r100.getPaymentMethodList(r101, r102, r103, r110, r104);
    L5:
        r104 = r111;
        goto L7
    }
}
