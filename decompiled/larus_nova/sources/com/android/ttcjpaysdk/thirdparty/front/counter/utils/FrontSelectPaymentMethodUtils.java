package com.android.ttcjpaysdk.thirdparty.front.counter.utils;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.base.ui.data.CJPayPayInfo;
import com.android.ttcjpaysdk.base.ui.data.FrontPayTypeData;
import com.android.ttcjpaysdk.bdpay.paymentmethod.ShareData;
import com.android.ttcjpaysdk.thirdparty.data.CJPayBalance;
import com.android.ttcjpaysdk.thirdparty.data.CJPayCard;
import com.android.ttcjpaysdk.thirdparty.data.CJPayCheckoutCounterResponseBean;
import com.android.ttcjpaysdk.thirdparty.data.CJPayCounterConstant;
import com.android.ttcjpaysdk.thirdparty.data.CJPayPayTypeInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayPaymentMethodInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayQuickPay;
import com.android.ttcjpaysdk.thirdparty.data.CJPayUserInfo;
import com.android.ttcjpaysdk.thirdparty.data.FrontSubPayTypeInfo;
import com.android.ttcjpaysdk.thirdparty.utils.StdPaymentMethodUtils;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u001a\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u001a\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J\u0012\u0010\u001b\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010 \u001a\u00020\u0004H\u0002J,\u0010!\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\bH\u0002J\u0012\u0010#\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u001a\u0010$\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u001e\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00010&2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010'\u001a\u00020\u001d2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0012\u0010(\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0012\u0010)\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010*\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010+\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010,\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010-\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010.\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010/\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u00100\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u00101\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u00102\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u00103\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b¨\u00064"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/utils/FrontSelectPaymentMethodUtils;", "", "()V", "bindPaymentMethodForBalance", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayPaymentMethodInfo;", "payTypeInfo", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayPayTypeInfo;", "isInitialize", "", "isBalancePaymentExposed", "checkoutResponseBean", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayCheckoutCounterResponseBean;", "bindPaymentMethodForBalanceV2", "info", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayCheckoutCounterResponseBean$UsePayTypeInfo;", "bindPaymentMethodForCombine", BrowserDependency.UrlClickType.CARD, "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayCard;", "bindPaymentMethodForCombineV2", "bindPaymentMethodForCreditPay", "payInfo", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayPayInfo;", "bindPaymentMethodForCreditPayV2", "bindPaymentMethodForCreditScore", "bindPaymentMethodForECNY", "bindPaymentMethodForFundPay", "bindPaymentMethodForIncome", "bindPaymentMethodForLockCard", "bindCardId", "", "bindPaymentMethodForNewCard", "bean", "bindPaymentMethodForPayAfterUser", "bindPaymentMethodForQuickPay", "isFromMethodFragment", "bindPaymentMethodForQuickPayV2", "bindPaymentMethodForSharePay", "getLynxPageInitData", "", "getLynxPageScheme", "initSelectMethod", ShareData.ISCOMBINEPAY, "isCombinePayNewCard", "isCreditScore", "isLynxPageIsRealName", "isLynxPageNeedJump", "isNeedUnLockCard", "isNewBankCardShare", "isOrderShare", "isPayAfterUse", "isPayAfterUserNoSigned", "isPayNewCard", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FrontSelectPaymentMethodUtils {
    public static final FrontSelectPaymentMethodUtils INSTANCE = null;

    static {
        INSTANCE = new FrontSelectPaymentMethodUtils();
    }

    private FrontSelectPaymentMethodUtils() {
    }

    private final CJPayPaymentMethodInfo bindPaymentMethodForCreditScore() {
        CJPayPaymentMethodInfo r100 = new CJPayPaymentMethodInfo();
        r100.paymentType = CJPayCounterConstant.CJ_PAY_KEY_FOR_CREDIT_SCORE;
        return r100;
    }

    private final CJPayPaymentMethodInfo bindPaymentMethodForECNY() {
        CJPayPaymentMethodInfo r100 = new CJPayPaymentMethodInfo();
        r100.paymentType = "ecnypay";
        return r100;
    }

    private final CJPayPaymentMethodInfo bindPaymentMethodForFundPay() {
        CJPayPaymentMethodInfo r100 = new CJPayPaymentMethodInfo();
        r100.paymentType = CJPayConstant.TT_CJ_PAY_KEY_FOR_FUND_PAY;
        return r100;
    }

    private final CJPayPaymentMethodInfo bindPaymentMethodForIncome() {
        CJPayPaymentMethodInfo r100 = new CJPayPaymentMethodInfo();
        r100.paymentType = "income";
        return r100;
    }

    private final CJPayPaymentMethodInfo bindPaymentMethodForPayAfterUser() {
        CJPayPaymentMethodInfo r100 = new CJPayPaymentMethodInfo();
        r100.paymentType = CJPayCounterConstant.CJ_PAY_KEY_FOR_PAY_AFTER_USE;
        return r100;
    }

    private final CJPayPaymentMethodInfo bindPaymentMethodForBalanceV2(CJPayCheckoutCounterResponseBean.UsePayTypeInfo r100) {
        CJPayPaymentMethodInfo r101 = new CJPayPaymentMethodInfo();
        r101.bank_card_id = "balance";
        r101.paymentType = "balance";
        if (r100 == null) goto L6;
        String r102 = r100.mobile_mask;
        if (r102 == null) goto L6;
    L7:
        r101.mobile_mask = r102;
        if (r100 == null) goto L10;
        String r103 = r100.trade_confirm_button_label;
    L11:
        r101.trade_confirm_button_label = r103;
        return r101;
    L10:
        r103 = null;
    L6:
        r102 = "";
        goto L7
    }

    private final CJPayPaymentMethodInfo bindPaymentMethodForCombine(CJPayCard r100) {
        CJPayPaymentMethodInfo r101 = new CJPayPaymentMethodInfo();
        String r102 = "";
        if (r100 == null) goto L6;
        String r103 = r100.bank_card_id;
        if (r103 == null) goto L6;
    L7:
        r101.bank_card_id = r103;
        r101.paymentType = "combinepay";
        if (r100 == null) goto L11;
        String r104 = r100.mobile_mask;
        if (r104 == null) goto L11;
    L12:
        r101.mobile_mask = r104;
        if (r100 == null) goto L16;
        String r105 = r100.bank_name;
        if (r105 == null) goto L16;
    L17:
        r101.bank_name = r105;
        if (r100 == null) goto L23;
        String r106 = r100.card_no_mask;
        if (r106 == null) goto L23;
        r102 = r106;
    L23:
        r101.card_no_mask = r102;
        return r101;
    L16:
        r105 = "";
    L11:
        r104 = "";
    L6:
        r103 = "";
        goto L7
    }

    private final CJPayPaymentMethodInfo bindPaymentMethodForCombineV2(CJPayCheckoutCounterResponseBean.UsePayTypeInfo r100) {
        CJPayPaymentMethodInfo r101 = new CJPayPaymentMethodInfo();
        String r102 = "";
        if (r100 == null) goto L6;
        String r103 = r100.bank_card_id;
        if (r103 == null) goto L6;
    L7:
        r101.bank_card_id = r103;
        r101.paymentType = "combinepay";
        if (r100 == null) goto L11;
        String r104 = r100.mobile_mask;
        if (r104 == null) goto L11;
    L12:
        r101.mobile_mask = r104;
        if (r100 == null) goto L16;
        String r105 = r100.bank_name;
        if (r105 == null) goto L16;
    L17:
        r101.bank_name = r105;
        if (r100 == null) goto L23;
        String r106 = r100.card_no_mask;
        if (r106 == null) goto L23;
        r102 = r106;
    L23:
        r101.card_no_mask = r102;
        return r101;
    L16:
        r105 = "";
    L11:
        r104 = "";
    L6:
        r103 = "";
        goto L7
    }

    private final CJPayPaymentMethodInfo bindPaymentMethodForLockCard(String r100) {
        CJPayPaymentMethodInfo r101 = new CJPayPaymentMethodInfo();
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r101.bank_card_id = r100;
        r101.paymentType = "quickpay";
        return r101;
    }

    private final CJPayPaymentMethodInfo bindPaymentMethodForNewCard(CJPayCheckoutCounterResponseBean r100) {
        CJPayPaymentMethodInfo r101 = new CJPayPaymentMethodInfo();
        if (r100 == null) goto L19;
        Iterator<T> r102 = r100.paytype_info.sub_pay_type_sum_info.sub_pay_type_info_list.iterator();
    L6:
        if (r102.hasNext() == false) goto L15;
        Object r103 = r102.next();
        FrontSubPayTypeInfo r104 = (FrontSubPayTypeInfo) r103;
        if (r104.choose == true) goto L10;
    L12:
        boolean r105 = false;
    L13:
        if (r105 == false) goto L6;
    L16:
        FrontSubPayTypeInfo r106 = (FrontSubPayTypeInfo) r103;
        if (r106 == null) goto L19;
        r101.paymentType = "addcard";
        FrontPayTypeData r107 = r106.pay_type_data;
        r101.card_add_ext = r107.card_add_ext;
        r101.front_bank_code = r107.bank_code;
        r101.card_type_name = r107.card_type_name;
        r101.trade_confirm_button_label = r106.trade_confirm_button_label;
        goto L19
    L10:
        if (Intrinsics.areEqual(r104.sub_pay_type, "new_bank_card") == false) goto L12;
        r105 = true;
        goto L13
    L15:
        r103 = null;
    L19:
        return r101;
    }

    private final CJPayPaymentMethodInfo bindPaymentMethodForQuickPayV2(CJPayCheckoutCounterResponseBean.UsePayTypeInfo r100) {
        CJPayPaymentMethodInfo r101 = new CJPayPaymentMethodInfo();
        String r102 = "";
        if (r100 == null) goto L6;
        String r103 = r100.bank_card_id;
        if (r103 == null) goto L6;
    L7:
        r101.bank_card_id = r103;
        r101.paymentType = "quickpay";
        if (r100 == null) goto L11;
        String r104 = r100.mobile_mask;
        if (r104 == null) goto L11;
    L12:
        r101.mobile_mask = r104;
        if (r100 == null) goto L16;
        String r105 = r100.bank_name;
        if (r105 == null) goto L16;
    L17:
        r101.bank_name = r105;
        if (r100 == null) goto L23;
        String r106 = r100.card_no_mask;
        if (r106 == null) goto L23;
        r102 = r106;
    L23:
        r101.card_no_mask = r102;
        if (r100 == null) goto L26;
        String r107 = r100.trade_confirm_button_label;
    L27:
        r101.trade_confirm_button_label = r107;
        return r101;
    L26:
        r107 = null;
    L16:
        r105 = "";
    L11:
        r104 = "";
    L6:
        r103 = "";
        goto L7
    }

    private final boolean isCombinePay(CJPayCheckoutCounterResponseBean r100) {
        if (r100 == null) goto L6;
        CJPayPayInfo r101 = r100.pay_info;
        if (r101 == null) goto L6;
        String r102 = r101.business_scene;
    L8:
        if (Intrinsics.areEqual(r102, "Pre_Pay_Combine") == false) goto L11;
        return true;
    L11:
        return false;
    L6:
        r102 = null;
        goto L8
    }

    public final Map<String, Object> getLynxPageInitData(CJPayCheckoutCounterResponseBean r100) {
        if (r100 == null) goto L6;
        CJPayCheckoutCounterResponseBean.LynxShowInfo r101 = r100.lynx_show_info;
        if (r101 == null) goto L6;
        Map<String, Object> r102 = r101.exts;
    L7:
        if (r102 == null) goto L9;
        return r102;
    L9:
        return new LinkedHashMap();
    L6:
        r102 = null;
        goto L7
    }

    public final String getLynxPageScheme(CJPayCheckoutCounterResponseBean r100) {
        if (r100 == null) goto L6;
        CJPayCheckoutCounterResponseBean.LynxShowInfo r101 = r100.lynx_show_info;
        if (r101 == null) goto L6;
        String r102 = r101.url;
    L7:
        if (r102 != null) goto L10;
        return "";
    L10:
        return r102;
    L6:
        r102 = null;
        goto L7
    }

    public final CJPayPaymentMethodInfo initSelectMethod(CJPayCheckoutCounterResponseBean r100) {
        Object r101 = null;
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.isAssetStandard() == false) goto L11;
        AssetInfoBean r102 = r100.used_asset_info;
        if (r102 != null) goto L10;
        return null;
    L10:
        return StdPaymentMethodUtils.createPaymentMethod$default(StdPaymentMethodUtils.INSTANCE, r102, false, 2, null);
    L11:
        String r103 = r100.pay_info.business_scene;
        if (r103 != null) goto L14;
        return null;
    L14:
        switch(r103.hashCode()) {
            case -1694580976: goto L88;
            case -1524118967: goto L80;
            case -836325908: goto L72;
            case -668293988: goto L68;
            case -411732986: goto L64;
            case -234858324: goto L50;
            case 34796480: goto L46;
            case 62163359: goto L29;
            case 659760189: goto L25;
            case 1178008188: goto L21;
            case 1898614428: goto L17;
            default: goto L110;
        };
    L110:
        return null;
    L17:
        if (r103.equals(CJPayConstant.CJ_PAY_BUSINESS_SCENE_PRE_PAY_ECNY) == true) goto L100;
        return null;
    L100:
        return bindPaymentMethodForECNY();
    L21:
        if (r103.equals("Pre_Pay_SharePay") == true) goto L101;
        return null;
    L101:
        return bindPaymentMethodForSharePay(r100.pay_info, r100.used_paytype_info);
    L25:
        if (r103.equals("Pre_Pay_NewCard") == false) goto L113;
        CJPayPaymentMethodInfo r104 = bindPaymentMethodForNewCard(r100);
        r104.voucher_no_list = r100.pay_info.voucher_no_list;
        return r104;
    L113:
        return null;
    L29:
        if (r103.equals("Pre_Pay_BankCard") == true) goto L32;
        return null;
    L32:
        if (isNeedUnLockCard(r100) == false) goto L35;
        CJPayPaymentMethodInfo r105 = bindPaymentMethodForLockCard(r100.pay_info.bank_card_id);
    L44:
        CJPayPayInfo r106 = r100.pay_info;
        r105.voucher_no_list = r106.voucher_no_list;
        r105.is_foreign_card = r106.is_foreign_card;
        return r105;
    L35:
        if (r100.userPayTypeInfoV2() == false) goto L37;
        r105 = bindPaymentMethodForQuickPayV2(r100.used_paytype_info);
        goto L44
    L37:
        Iterator<T> r107 = r100.paytype_info.quick_pay.cards.iterator();
    L39:
        if (r107.hasNext() == false) goto L43;
        Object r108 = r107.next();
        if (Intrinsics.areEqual(((CJPayCard) r108).bank_card_id, r100.pay_info.bank_card_id) == false) goto L39;
        r101 = r108;
    L43:
        CJPayPayTypeInfo r109 = r100.paytype_info;
        r105 = bindPaymentMethodForQuickPay(r109, (CJPayCard) r101, false, false);
        goto L44
    L46:
        if (r103.equals(CJPayCounterConstant.CJ_PAY_KEY_PRE_PAY_PAY_AFTER_USE) == true) goto L104;
        return null;
    L104:
        return bindPaymentMethodForPayAfterUser();
    L50:
        if (r103.equals("Pre_Pay_Combine") == true) goto L53;
        return null;
    L53:
        if (r100.userPayTypeInfoV2() == false) goto L55;
        CJPayPaymentMethodInfo r110 = bindPaymentMethodForCombineV2(r100.used_paytype_info);
    L62:
        r110.voucher_no_list = r100.pay_info.voucher_no_list;
        return r110;
    L55:
        Iterator<T> r111 = r100.paytype_info.quick_pay.cards.iterator();
    L57:
        if (r111.hasNext() == false) goto L61;
        Object r112 = r111.next();
        if (Intrinsics.areEqual(((CJPayCard) r112).bank_card_id, r100.pay_info.bank_card_id) == false) goto L57;
        r101 = r112;
    L61:
        r110 = bindPaymentMethodForCombine((CJPayCard) r101);
        goto L62
    L64:
        if (r103.equals(CJPayCounterConstant.CJ_PAY_KET_PRE_PAY_CREDIT_SCORE) == true) goto L106;
        return null;
    L106:
        return bindPaymentMethodForCreditScore();
    L68:
        if (r103.equals("Pre_Pay_Income") == true) goto L107;
        return null;
    L107:
        return bindPaymentMethodForIncome();
    L72:
        if (r103.equals("Pre_Pay_Credit") == true) goto L75;
        return null;
    L75:
        if (r100.userPayTypeInfoV2() == false) goto L77;
        CJPayPaymentMethodInfo r113 = bindPaymentMethodForCreditPayV2(r100.pay_info, r100.used_paytype_info);
    L78:
        r113.voucher_no_list = r100.pay_info.voucher_no_list;
        return r113;
    L77:
        r113 = bindPaymentMethodForCreditPay(r100.pay_info, r100);
        goto L78
    L80:
        if (r103.equals("Pre_Pay_Balance") == true) goto L83;
        return null;
    L83:
        if (r100.userPayTypeInfoV2() == false) goto L85;
        CJPayPaymentMethodInfo r114 = bindPaymentMethodForBalanceV2(r100.used_paytype_info);
    L86:
        r114.voucher_no_list = r100.pay_info.voucher_no_list;
        return r114;
    L85:
        r114 = bindPaymentMethodForBalance(r100.paytype_info, false, false, r100);
        goto L86
    L88:
        if (r103.equals(CJPayCounterConstant.CJ_PAY_KEY_PRE_PAY_FUND) == true) goto L91;
        return null;
    L91:
        return bindPaymentMethodForFundPay();
    }

    public final boolean isCombinePayNewCard(CJPayCheckoutCounterResponseBean r100) {
        if (isCombinePay(r100) == false) goto L13;
        if (r100 == null) goto L8;
        CJPayPayInfo r101 = r100.pay_info;
        if (r101 == null) goto L8;
        String r102 = r101.primary_pay_type;
    L10:
        if (Intrinsics.areEqual("new_bank_card", r102) == false) goto L15;
        return true;
    L15:
        return false;
    L8:
        r102 = null;
        goto L10
    L13:
        return false;
    }

    public final boolean isCreditScore(CJPayCheckoutCounterResponseBean r100) {
        if (r100 == null) goto L6;
        CJPayPayInfo r101 = r100.pay_info;
        if (r101 == null) goto L6;
        String r102 = r101.business_scene;
    L8:
        return Intrinsics.areEqual(r102, CJPayCounterConstant.CJ_PAY_KET_PRE_PAY_CREDIT_SCORE);
    L6:
        r102 = null;
        goto L8
    }

    public final boolean isLynxPageIsRealName(CJPayCheckoutCounterResponseBean r100) {
        if (r100 == null) goto L17;
        CJPayCheckoutCounterResponseBean.LynxShowInfo r101 = r100.lynx_show_info;
        if (r101 == null) goto L17;
        String r102 = r101.url;
        if (r102 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == false) goto L16;
        return false;
    L16:
        return Intrinsics.areEqual(r101.type, CJPayConstant.CJ_PAY_REAL_NAME_LYNX_PAGE);
    L9:
        if (r102.length() == 0) goto L12;
        r103 = false;
    L17:
        return false;
    }

    public final boolean isLynxPageNeedJump(CJPayCheckoutCounterResponseBean r100) {
        if (r100 == null) goto L6;
        CJPayCheckoutCounterResponseBean.LynxShowInfo r101 = r100.lynx_show_info;
        if (r101 == null) goto L6;
        Boolean r102 = Boolean.valueOf(r101.need_jump);
    L7:
        if (r102 != null) goto L11;
        return false;
    L11:
        return r102.booleanValue();
    L6:
        r102 = null;
        goto L7
    }

    public final boolean isNeedUnLockCard(CJPayCheckoutCounterResponseBean r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Object r101 = r100.lynx_show_info.exts.get("lockedCardList");
        if ((r101 instanceof String) == false) goto L8;
        String r102 = (String) r101;
    L9:
        String r103 = r102;
        if (r103 == null) goto L13;
        List r104 = StringsKt.split$default(r103, new String[]{","}, false, 0, 6, null);
        if (r104 == null) goto L13;
    L15:
        if ((!r104.isEmpty()) == true) goto L17;
        return false;
    L17:
        return r104.contains(r100.pay_info.bank_card_id);
    L13:
        r104 = new ArrayList();
        goto L15
    L8:
        r102 = null;
        goto L9
    }

    public final boolean isNewBankCardShare(CJPayCheckoutCounterResponseBean r100) {
        Boolean r101 = null;
        if (r100 == null) goto L7;
        CJPayPayInfo r102 = r100.pay_info;
        if (r102 == null) goto L7;
        String r103 = r102.business_scene;
    L9:
        if (Intrinsics.areEqual(r103, "Pre_Pay_SharePay") == false) goto L20;
        if (r100 == null) goto L14;
        CJPayPayInfo r104 = r100.pay_info;
        if (r104 == null) goto L14;
        r101 = Boolean.valueOf(r104.isNewBankCardShare());
    L14:
        if (r101 == null) goto L16;
        boolean r105 = r101.booleanValue();
    L17:
        if (r105 == false) goto L21;
        return true;
    L21:
        return false;
    L16:
        r105 = false;
        goto L17
    L20:
        return false;
    L7:
        r103 = null;
        goto L9
    }

    public final boolean isOrderShare(CJPayCheckoutCounterResponseBean r100) {
        Boolean r101 = null;
        if (r100 == null) goto L7;
        CJPayPayInfo r102 = r100.pay_info;
        if (r102 == null) goto L7;
        String r103 = r102.business_scene;
    L9:
        if (Intrinsics.areEqual(r103, "Pre_Pay_SharePay") == false) goto L20;
        if (r100 == null) goto L14;
        CJPayPayInfo r104 = r100.pay_info;
        if (r104 == null) goto L14;
        r101 = Boolean.valueOf(r104.isOrderShare());
    L14:
        if (r101 == null) goto L16;
        boolean r105 = r101.booleanValue();
    L17:
        if (r105 == false) goto L21;
        return true;
    L21:
        return false;
    L16:
        r105 = false;
        goto L17
    L20:
        return false;
    L7:
        r103 = null;
        goto L9
    }

    public final boolean isPayAfterUse(CJPayCheckoutCounterResponseBean r100) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (Intrinsics.areEqual(r100.pay_info.business_scene, CJPayCounterConstant.CJ_PAY_KEY_PRE_PAY_PAY_AFTER_USE) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean isPayAfterUserNoSigned(CJPayCheckoutCounterResponseBean r100) {
        if (isPayAfterUse(r100) == true) goto L5;
    L12:
        return false;
    L5:
        if (r100 == null) goto L9;
        CJPayUserInfo r101 = r100.user_info;
        if (r101 == null) goto L9;
        boolean r102 = r101.has_signed_cards;
    L10:
        if (r102 == true) goto L12;
        return true;
    L9:
        r102 = true;
        goto L10
    }

    public final boolean isPayNewCard(CJPayCheckoutCounterResponseBean r100) {
        if (r100 == null) goto L6;
        CJPayPayInfo r101 = r100.pay_info;
        if (r101 == null) goto L6;
        String r102 = r101.business_scene;
    L8:
        return Intrinsics.areEqual(r102, "Pre_Pay_NewCard");
    L6:
        r102 = null;
        goto L8
    }

    private final CJPayPaymentMethodInfo bindPaymentMethodForCreditPay(CJPayPayInfo r100, CJPayCheckoutCounterResponseBean r101) {
        CJPayPaymentMethodInfo r102 = new CJPayPaymentMethodInfo();
        r102.paymentType = "creditpay";
        r102.credit_pay_installment = r100.credit_pay_installment;
        r102.decision_id = r100.decision_id;
        if (r101 != null) goto L5;
        String r103 = "";
    L6:
        r102.mobile_mask = r103;
        return r102;
    L5:
        r103 = r101.user_info.mobile;
        goto L6
    }

    private final CJPayPaymentMethodInfo bindPaymentMethodForCreditPayV2(CJPayPayInfo r100, CJPayCheckoutCounterResponseBean.UsePayTypeInfo r101) {
        CJPayPaymentMethodInfo r102 = new CJPayPaymentMethodInfo();
        r102.paymentType = "creditpay";
        r102.credit_pay_installment = r100.credit_pay_installment;
        r102.decision_id = r100.decision_id;
        if (r101 == null) goto L6;
        String r103 = r101.mobile_mask;
        if (r103 == null) goto L6;
    L7:
        r102.mobile_mask = r103;
        if (r101 == null) goto L10;
        String r104 = r101.trade_confirm_button_label;
    L11:
        r102.trade_confirm_button_label = r104;
        return r102;
    L10:
        r104 = null;
    L6:
        r103 = "";
        goto L7
    }

    private final CJPayPaymentMethodInfo bindPaymentMethodForSharePay(CJPayPayInfo r100, CJPayCheckoutCounterResponseBean.UsePayTypeInfo r101) {
        CJPayPaymentMethodInfo r102 = new CJPayPaymentMethodInfo();
        String r103 = "";
        if (r101 == null) goto L6;
        String r104 = r101.bank_card_id;
        if (r104 == null) goto L6;
    L7:
        r102.bank_card_id = r104;
        r102.paymentType = "share_pay";
        if (r101 == null) goto L11;
        String r105 = r101.mobile_mask;
        if (r105 == null) goto L11;
    L12:
        r102.mobile_mask = r105;
        if (r101 == null) goto L16;
        String r106 = r101.bank_name;
        if (r106 == null) goto L16;
    L17:
        r102.bank_name = r106;
        if (r101 == null) goto L23;
        String r107 = r101.card_no_mask;
        if (r107 == null) goto L23;
        r103 = r107;
    L23:
        r102.card_no_mask = r103;
        if (r101 == null) goto L26;
        String r108 = r101.trade_confirm_button_label;
    L27:
        r102.trade_confirm_button_label = r108;
        r102.share_asset_code = CJPayConstant.CJ_PAY_SHARE_ASSET_CODE_BANK_CARD;
        r102.share_asset_id = r100.share_asset_id;
        return r102;
    L26:
        r108 = null;
    L16:
        r106 = "";
    L11:
        r105 = "";
    L6:
        r104 = "";
        goto L7
    }

    private final CJPayPaymentMethodInfo bindPaymentMethodForBalance(CJPayPayTypeInfo r100, boolean r101, boolean r102, CJPayCheckoutCounterResponseBean r103) {
        CJPayPaymentMethodInfo r104 = new CJPayPaymentMethodInfo();
        if (r100 != null) goto L5;
        return r104;
    L5:
        CJPayBalance r105 = r100.balance;
        r104.icon_url = r105.icon_url;
        r104.status = r105.status;
        r104.title = r105.title;
        r104.sub_title = r105.msg;
        String r106 = "";
        r104.sub_title_icon = "";
        r104.mark = r105.mark;
        r104.bank_card_id = "balance";
        r104.paymentType = "balance";
        r104.need_pwd = r105.need_pwd;
        r104.need_send_sms = "";
        if (r103 == null) goto L9;
        r106 = r103.user_info.mobile;
    L9:
        r104.mobile_mask = r106;
        r104.tt_mark = r105.tt_mark;
        r104.tt_title = r105.tt_title;
        r104.tt_sub_title = r105.tt_sub_title;
        r104.tt_icon_url = r105.tt_icon_url;
        return r104;
    }

    private final CJPayPaymentMethodInfo bindPaymentMethodForQuickPay(CJPayPayTypeInfo r100, CJPayCard r101, boolean r102, boolean r103) {
        CJPayPaymentMethodInfo r104 = new CJPayPaymentMethodInfo();
        if (r101 == null) goto L18;
        if (r100 == null) goto L18;
        r104.icon_url = r101.icon_url;
        r104.card_level = r101.card_level;
        r104.status = r101.status;
        r104.title = "";
        if (TextUtils.isEmpty(r101.bank_name) == true) goto L10;
        r104.title += r101.bank_name;
    L10:
        if (TextUtils.isEmpty(r101.card_type_name) == true) goto L13;
        r104.title += r101.card_type_name;
    L13:
        if (TextUtils.isEmpty(r101.card_no_mask) == false) goto L15;
    L17:
        r104.sub_title = r101.msg;
        r104.bank_card_id = r101.bank_card_id;
        r104.paymentType = "quickpay";
        r104.need_pwd = r101.need_pwd;
        r104.need_send_sms = r101.need_send_sms;
        r104.mobile_mask = r101.mobile_mask;
        CJPayQuickPay r105 = r100.quick_pay;
        r104.tt_title = r105.tt_title;
        r104.tt_mark = r105.tt_mark;
        r104.tt_sub_title = r105.tt_sub_title;
        r104.tt_icon_url = r105.tt_icon_url;
        r104.card = r101;
        r104.user_agreement.clear();
        r104.user_agreement.addAll(r101.user_agreement);
        r104.bank_name = r101.bank_name;
        r104.card_no_mask = r101.card_no_mask;
        goto L18
    L15:
        if (r101.card_no_mask.length() <= 3) goto L17;
        StringBuilder r106 = new StringBuilder();
        r106.append(r104.title);
        r106.append('(');
        String r107 = r101.card_no_mask;
        r106.append(r107.substring(r107.length() - 4, r101.card_no_mask.length()));
        r106.append(')');
        r104.title = r106.toString();
    L18:
        return r104;
    }
}
