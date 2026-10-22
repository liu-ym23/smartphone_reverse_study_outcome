package com.android.ttcjpaysdk.thirdparty.payagain.utils;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.android.ttcjpaysdk.base.ui.data.CJPayPayInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayBalance;
import com.android.ttcjpaysdk.thirdparty.data.CJPayCard;
import com.android.ttcjpaysdk.thirdparty.data.CJPayCheckoutCounterResponseBean;
import com.android.ttcjpaysdk.thirdparty.data.CJPayCounterConstant;
import com.android.ttcjpaysdk.thirdparty.data.CJPayPayTypeInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayQuickPay;
import com.android.ttcjpaysdk.thirdparty.payagain.data.FrontPaymentMethodInfo;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0016\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u0014\u001a\u00020\u0004J\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0004J\u001a\u0010\u0017\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0018\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\n\u001a\u0004\u0018\u00010\u000b¨\u0006\u001a"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/payagain/utils/PayAgainSelectMethodUtils;", "", "()V", "bindPaymentMethodForBalance", "Lcom/android/ttcjpaysdk/thirdparty/payagain/data/FrontPaymentMethodInfo;", "payTypeInfo", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayPayTypeInfo;", "mobile", "", "bindPaymentMethodForBalanceV2", "info", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayCheckoutCounterResponseBean$UsePayTypeInfo;", "bindPaymentMethodForCombine", BrowserDependency.UrlClickType.CARD, "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayCard;", "bindPaymentMethodForCombineV2", "bindPaymentMethodForCreditPay", "payInfo", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayPayInfo;", "bindPaymentMethodForCreditPayV2", "bindPaymentMethodForFundPay", "bindPaymentMethodForIncome", "bindPaymentMethodForPayAfterUser", "bindPaymentMethodForQuickPay", "bindPaymentMethodForQuickPayV2", "bindPaymentMethodForSharePay", "bdpay-payagain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PayAgainSelectMethodUtils {
    public static final PayAgainSelectMethodUtils INSTANCE = null;

    static {
        INSTANCE = new PayAgainSelectMethodUtils();
    }

    private PayAgainSelectMethodUtils() {
    }

    public final FrontPaymentMethodInfo bindPaymentMethodForFundPay() {
        FrontPaymentMethodInfo r100 = new FrontPaymentMethodInfo();
        r100.paymentType = CJPayConstant.TT_CJ_PAY_KEY_FOR_FUND_PAY;
        return r100;
    }

    public final FrontPaymentMethodInfo bindPaymentMethodForIncome() {
        FrontPaymentMethodInfo r100 = new FrontPaymentMethodInfo();
        r100.paymentType = "income";
        return r100;
    }

    public final FrontPaymentMethodInfo bindPaymentMethodForPayAfterUser() {
        FrontPaymentMethodInfo r100 = new FrontPaymentMethodInfo();
        r100.paymentType = CJPayCounterConstant.CJ_PAY_KEY_FOR_PAY_AFTER_USE;
        return r100;
    }

    public final FrontPaymentMethodInfo bindPaymentMethodForBalanceV2(CJPayCheckoutCounterResponseBean.UsePayTypeInfo r100) {
        FrontPaymentMethodInfo r101 = new FrontPaymentMethodInfo();
        r101.bank_card_id = "balance";
        r101.paymentType = "balance";
        if (r100 == null) goto L6;
        String r102 = r100.mobile_mask;
        if (r102 == null) goto L6;
    L7:
        r101.mobile_mask = r102;
        return r101;
    L6:
        r102 = "";
        goto L7
    }

    public final FrontPaymentMethodInfo bindPaymentMethodForCombine(CJPayCard r100) {
        FrontPaymentMethodInfo r101 = new FrontPaymentMethodInfo();
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

    public final FrontPaymentMethodInfo bindPaymentMethodForCombineV2(CJPayCheckoutCounterResponseBean.UsePayTypeInfo r100) {
        FrontPaymentMethodInfo r101 = new FrontPaymentMethodInfo();
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

    public final FrontPaymentMethodInfo bindPaymentMethodForQuickPayV2(CJPayCheckoutCounterResponseBean.UsePayTypeInfo r100) {
        FrontPaymentMethodInfo r101 = new FrontPaymentMethodInfo();
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
        return r101;
    L16:
        r105 = "";
    L11:
        r104 = "";
    L6:
        r103 = "";
        goto L7
    }

    public final FrontPaymentMethodInfo bindPaymentMethodForBalance(CJPayPayTypeInfo r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "mobile");
        FrontPaymentMethodInfo r102 = new FrontPaymentMethodInfo();
        if (r100 != null) goto L5;
        return r102;
    L5:
        CJPayBalance r103 = r100.balance;
        r102.icon_url = r103.icon_url;
        r102.status = r103.status;
        r102.title = r103.title;
        r102.sub_title = r103.msg;
        r102.sub_title_icon = "";
        r102.mark = r103.mark;
        r102.bank_card_id = "balance";
        r102.paymentType = "balance";
        r102.need_pwd = r103.need_pwd;
        r102.need_send_sms = "";
        r102.mobile_mask = r101;
        r102.tt_mark = r103.tt_mark;
        r102.tt_title = r103.tt_title;
        r102.tt_sub_title = r103.tt_sub_title;
        r102.tt_icon_url = r103.tt_icon_url;
        return r102;
    }

    public final FrontPaymentMethodInfo bindPaymentMethodForCreditPay(CJPayPayInfo r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "payInfo");
        Intrinsics.checkNotNullParameter(r101, "mobile");
        FrontPaymentMethodInfo r102 = new FrontPaymentMethodInfo();
        r102.paymentType = "creditpay";
        r102.credit_pay_installment = r100.credit_pay_installment;
        r102.decision_id = r100.decision_id;
        r102.mobile_mask = r101;
        return r102;
    }

    public final FrontPaymentMethodInfo bindPaymentMethodForCreditPayV2(CJPayPayInfo r100, CJPayCheckoutCounterResponseBean.UsePayTypeInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "payInfo");
        FrontPaymentMethodInfo r102 = new FrontPaymentMethodInfo();
        r102.paymentType = "creditpay";
        r102.credit_pay_installment = r100.credit_pay_installment;
        r102.decision_id = r100.decision_id;
        if (r101 == null) goto L6;
        String r103 = r101.mobile_mask;
        if (r103 == null) goto L6;
    L7:
        r102.mobile_mask = r103;
        return r102;
    L6:
        r103 = "";
        goto L7
    }

    public final FrontPaymentMethodInfo bindPaymentMethodForQuickPay(CJPayPayTypeInfo r100, CJPayCard r101) {
        FrontPaymentMethodInfo r102 = new FrontPaymentMethodInfo();
        if (r101 == null) goto L18;
        if (r100 == null) goto L18;
        r102.icon_url = r101.icon_url;
        r102.card_level = r101.card_level;
        r102.status = r101.status;
        r102.title = "";
        if (TextUtils.isEmpty(r101.bank_name) == true) goto L10;
        r102.title += r101.bank_name;
    L10:
        if (TextUtils.isEmpty(r101.card_type_name) == true) goto L13;
        r102.title += r101.card_type_name;
    L13:
        if (TextUtils.isEmpty(r101.card_no_mask) == false) goto L15;
    L17:
        r102.sub_title = r101.msg;
        r102.bank_card_id = r101.bank_card_id;
        r102.paymentType = "quickpay";
        r102.need_pwd = r101.need_pwd;
        r102.need_send_sms = r101.need_send_sms;
        r102.mobile_mask = r101.mobile_mask;
        CJPayQuickPay r103 = r100.quick_pay;
        r102.tt_title = r103.tt_title;
        r102.tt_mark = r103.tt_mark;
        r102.tt_sub_title = r103.tt_sub_title;
        r102.tt_icon_url = r103.tt_icon_url;
        r102.card = r101;
        r102.user_agreement.clear();
        r102.user_agreement.addAll(r101.user_agreement);
        r102.bank_name = r101.bank_name;
        r102.card_no_mask = r101.card_no_mask;
        goto L18
    L15:
        if (r101.card_no_mask.length() <= 3) goto L17;
        StringBuilder r104 = new StringBuilder();
        r104.append(r102.title);
        r104.append('(');
        String r105 = r101.card_no_mask;
        r104.append(r105.substring(r105.length() - 4, r101.card_no_mask.length()));
        r104.append(')');
        r102.title = r104.toString();
    L18:
        return r102;
    }

    public final FrontPaymentMethodInfo bindPaymentMethodForSharePay(CJPayPayInfo r100, CJPayCheckoutCounterResponseBean.UsePayTypeInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "payInfo");
        FrontPaymentMethodInfo r102 = new FrontPaymentMethodInfo();
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
        r102.share_asset_code = CJPayConstant.CJ_PAY_SHARE_ASSET_CODE_BANK_CARD;
        r102.share_asset_id = r100.share_asset_id;
        return r102;
    L16:
        r106 = "";
    L11:
        r105 = "";
    L6:
        r104 = "";
        goto L7
    }
}
