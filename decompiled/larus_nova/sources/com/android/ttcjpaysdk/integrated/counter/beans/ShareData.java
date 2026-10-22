package com.android.ttcjpaysdk.integrated.counter.beans;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.ui.data.CJPayCreditPayMethods;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.integrated.counter.data.CounterResponseBean;
import com.android.ttcjpaysdk.integrated.counter.data.CounterTradeConfirmResponseBean;
import com.android.ttcjpaysdk.integrated.counter.data.GlobalPayTypeItemInfo;
import com.android.ttcjpaysdk.integrated.counter.data.PayTypeItemInfo;
import com.android.ttcjpaysdk.integrated.counter.data.PaymentMethodInfo;
import com.android.ttcjpaysdk.integrated.counter.data.SubPayTypeInfo;
import com.android.ttcjpaysdk.integrated.counter.data.TradeQueryBean;
import com.android.ttcjpaysdk.integrated.counter.data.TypeItems;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class ShareData {
    private static GlobalPayTypeItemInfo cJClobalPayPayTypeItemInfo;
    private static TypeItems cJPaCreditTypeItemInfo;
    private static PayTypeItemInfo cJPayPayTypeItemInfo;
    public static CounterResponseBean checkoutResponseBean;
    public static ArrayList<String> combineInsufficientCardIds;
    private static String combineType;
    public static List<Activity> counterActivities;
    public static String creditPayActivateCode;
    private static int creditPayVoucherScrollPos;
    public static CJPayHostInfo hostInfo;
    public static ArrayList<String> insufficientCardIds;
    private static boolean isCombinePay;
    public static boolean isUnionPayAvailable;
    public static boolean isUserActiveToMethod;
    private static PaymentMethodInfo mSelectMethodInfo;
    private static PaymentMethodInfo mSelectMethodInfoWithoutCheckbox;
    public static OuterPayInfo outerPayInfo;
    public static CounterTradeConfirmResponseBean tradeConfirmResponseBean;
    public static TradeQueryBean tradeQueryResponseBean;
    public JSONObject bindCardVoucher;
    public boolean isAddBankCard;
    public boolean isItemOnclickEnable;
    public boolean isMethodItemOnclickEnable;
    public boolean isShowInsufficient;
    public PaymentMethodInfo selectDetailMethodInfo;
    public PaymentMethodInfo selectPaymentMethodInfo;
    public PaymentMethodInfo unionPayMethodInfo;
    public boolean updateDataAndView;

    public static void clearCJPayCreditPayTypeItemInfo() {
        cJPaCreditTypeItemInfo = null;
    }

    public static void releaseSelectMethodInfoWithoutCheckbox() {
        mSelectMethodInfoWithoutCheckbox = null;
    }

    static {
        counterActivities = new ArrayList();
        cJPaCreditTypeItemInfo = null;
        tradeConfirmResponseBean = null;
        tradeQueryResponseBean = null;
        isUnionPayAvailable = true;
        insufficientCardIds = null;
        combineInsufficientCardIds = null;
        creditPayActivateCode = "";
        creditPayVoucherScrollPos = -1;
        isUserActiveToMethod = false;
        outerPayInfo = new OuterPayInfo();
        isCombinePay = false;
    }

    public static TypeItems getByteDanceTypeItems() {
        CounterResponseBean r100 = checkoutResponseBean;
        if (r100 == null) goto L10;
        Iterator<TypeItems> r101 = r100.data.paytype_items.iterator();
    L6:
        if (r101.hasNext() == false) goto L15;
        TypeItems r102 = r101.next();
        if (CJPayConstant.TT_CJ_PAY_KEY_FOR_BYTEPAY.equals(r102.ptcode) == false) goto L6;
        return r102;
    L15:
        return null;
    L10:
        return null;
    }

    public static GlobalPayTypeItemInfo getCJGlobalPayPayTypeItemInfo() {
        GlobalPayTypeItemInfo r100 = cJClobalPayPayTypeItemInfo;
        if (r100 == null) goto L5;
        return r100;
    L5:
        TypeItems r101 = getGlobalPayTypeItems();
        if (r101 == null) goto L12;
        if (r101.global_paytype_item == null) goto L12;
        GlobalPayTypeItemInfo r102 = (GlobalPayTypeItemInfo) CJPayJsonParser.fromJson(r101.paytype_item_info, GlobalPayTypeItemInfo.class);
        cJClobalPayPayTypeItemInfo = r102;
        return r102;
    L12:
        return new GlobalPayTypeItemInfo();
    }

    public static TypeItems getCJPayCreditItemInfo() {
        TypeItems r100 = cJPaCreditTypeItemInfo;
        if (r100 == null) goto L5;
        return r100;
    L5:
        CounterResponseBean r101 = checkoutResponseBean;
        if (r101 == null) goto L15;
        Iterator<TypeItems> r102 = r101.data.paytype_items.iterator();
    L9:
        if (r102.hasNext() == false) goto L15;
        TypeItems r103 = r102.next();
        if ("creditpay".equals(r103.ptcode) == false) goto L9;
        r103.creditPayTypeData = (SubPayTypeInfo) CJPayJsonParser.fromJson(r103.paytype_item_info, SubPayTypeInfo.class);
        cJPaCreditTypeItemInfo = r103;
        return r103;
    L15:
        return new TypeItems();
    }

    public static PayTypeItemInfo getCJPayPayTypeItemInfo() {
        PayTypeItemInfo r100 = cJPayPayTypeItemInfo;
        if (r100 == null) goto L5;
        return r100;
    L5:
        TypeItems r101 = getByteDanceTypeItems();
        if (r101 == null) goto L12;
        String r102 = r101.paytype_item_info;
        if (r102 == null) goto L12;
        PayTypeItemInfo r103 = (PayTypeItemInfo) CJPayJsonParser.fromJson(r102, PayTypeItemInfo.class);
        cJPayPayTypeItemInfo = r103;
        return r103;
    L12:
        return new PayTypeItemInfo();
    }

    public static TypeItems getGlobalPayTypeItems() {
        CounterResponseBean r100 = checkoutResponseBean;
        if (r100 == null) goto L10;
        Iterator<TypeItems> r101 = r100.data.paytype_items.iterator();
    L6:
        if (r101.hasNext() == false) goto L15;
        TypeItems r102 = r101.next();
        if (CJPayConstant.TT_CJ_PAY_KEY_FOR_OVERSEA_PAY.equals(r102.ptcode) == false) goto L6;
        return r102;
    L15:
        return null;
    L10:
        return null;
    }

    public static String getSelectCardName() {
        PaymentMethodInfo r100 = mSelectMethodInfo;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.card.bank_name;
    }

    public static String getSelectCardType() {
        PaymentMethodInfo r100 = mSelectMethodInfoWithoutCheckbox;
        if (r100 != null) goto L5;
        PaymentMethodInfo r101 = mSelectMethodInfo;
        if (r101 != null) goto L9;
        return null;
    L9:
        return r101.card.card_type;
    L5:
        return r100.card.card_type;
    }

    public static String getSelectMethod() {
        PaymentMethodInfo r100 = mSelectMethodInfoWithoutCheckbox;
        if (r100 == null) goto L7;
        String r101 = r100.paymentType;
        if (r101 == null) goto L7;
        return r101;
    L7:
        PaymentMethodInfo r102 = mSelectMethodInfo;
        if (r102 == null) goto L12;
        String r103 = r102.paymentType;
        if (r103 == null) goto L14;
        return r103;
    L14:
        return null;
    L12:
        return null;
    }

    public static String getSelectMethodForApplog() {
        PaymentMethodInfo r100 = mSelectMethodInfoWithoutCheckbox;
        if (r100 == null) goto L10;
        String r101 = r100.paymentType;
        if (r101 == null) goto L10;
        if (r100.is_foreign_card == false) goto L9;
        return CJPayConstant.TT_CJ_PAY_KEY_FOR_FOREIGN_CARD;
    L9:
        return r101;
    L10:
        PaymentMethodInfo r102 = mSelectMethodInfo;
        if (r102 == null) goto L18;
        String r103 = r102.paymentType;
        if (r103 != null) goto L15;
        return null;
    L15:
        if (r102.is_foreign_card == false) goto L17;
        return CJPayConstant.TT_CJ_PAY_KEY_FOR_FOREIGN_CARD;
    L17:
        return r103;
    L18:
        return null;
    }

    public static boolean isAssetStandard() {
        CounterResponseBean r100 = checkoutResponseBean;
        if (r100 != null) goto L6;
        return false;
    L6:
        if ("1".equals(r100.data.support_asset_standard) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean isAutoConfirm() {
        CounterResponseBean r100 = checkoutResponseBean;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.data.cashdesk_show_conf.auto_confirm;
    }

    public static boolean isConfirmPageCombineStyle() {
        CounterResponseBean r100 = checkoutResponseBean;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.data.cashdesk_show_conf.show_style != 7) goto L7;
        return true;
    }

    public static boolean isCreditActive() {
        return TextUtils.equals("0", creditPayActivateCode);
    }

    public static boolean isGameNewCounterStyle() {
        CJPayHostInfo r100 = hostInfo;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isGameNewCounterStyle == false) goto L7;
        return true;
    }

    public static boolean isLynxCardCounterStyle() {
        CounterResponseBean r100 = checkoutResponseBean;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.data.cashdesk_show_conf.show_style != 7) goto L7;
        return true;
    }

    public static boolean isNeedExtraJhTradeQuery() {
        CounterResponseBean r100 = checkoutResponseBean;
        if (r100 != null) goto L5;
        return false;
    L5:
        return TextUtils.equals("1", r100.data.cashdesk_show_conf.jh_result_page_style);
    }

    private static boolean isOnlyDyPayAvailable() {
        ArrayList<String> r100 = checkoutResponseBean.data.sorted_ptcodes;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.size() == 1) goto L8;
        return false;
    L8:
        String r101 = (String) ListProtector.get(r100, 0);
        if (r101.equals("dypay") == true) goto L11;
        return false;
    L11:
        if (r101.equals(checkoutResponseBean.data.default_ptcode) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public static void resetDataWhenCounterClose() {
        creditPayActivateCode = "";
        isUnionPayAvailable = true;
    }

    public String getBindCardVoucher() {
        JSONObject r100 = this.bindCardVoucher;
        if (r100 != null) goto L5;
        return "";
    L5:
        return r100.toString();
    }

    public ShareData() {
        this.unionPayMethodInfo = new PaymentMethodInfo();
        this.selectPaymentMethodInfo = new PaymentMethodInfo();
        this.selectDetailMethodInfo = new PaymentMethodInfo();
        this.isAddBankCard = false;
        this.isItemOnclickEnable = true;
        this.isMethodItemOnclickEnable = true;
        this.isShowInsufficient = false;
        this.updateDataAndView = false;
        this.bindCardVoucher = null;
    }

    public static boolean isEmptyWrapperAndAutoConfirmMode() {
        if (isAutoConfirm() == true) goto L5;
    L7:
        return false;
    L5:
        if (isOnlyDyPayAvailable() == false) goto L7;
        return true;
    }

    public static boolean isNoPwdMerge() {
        return getCJPayPayTypeItemInfo().paytype_info.nopwd_pay_params.isNoPwdCombineConfirm();
    }

    public static boolean isNoPwdPre() {
        return getCJPayPayTypeItemInfo().paytype_info.nopwd_pay_params.isNoPwdPreShow();
    }

    public static boolean isOuterPay() {
        return getCJPayPayTypeItemInfo().paytype_info.sub_pay_type_sum_info.isOuterPay();
    }

    public static PaymentMethodInfo getSelectPaymentMethodInfo() {
        return mSelectMethodInfo;
    }

    public static int getCreditPayVoucherScrollPos(Context r100) {
        int r101 = creditPayVoucherScrollPos;
        if (r101 != (-1)) goto L31;
        if (r100 == null) goto L31;
        PayTypeItemInfo r102 = getCJPayPayTypeItemInfo();
        int r103 = 0;
    L8:
        if (r103 >= r102.paytype_info.sub_pay_type_sum_info.sub_pay_type_info_list.size()) goto L25;
        SubPayTypeInfo r104 = (SubPayTypeInfo) ListProtector.get(r102.paytype_info.sub_pay_type_sum_info.sub_pay_type_info_list, r103);
        if ("credit_pay".equals(r104.sub_pay_type) == true) goto L11;
        r103 = r103 + 1;
        goto L8
    L11:
        int r105 = 0;
    L13:
        if (r105 >= r104.pay_type_data.credit_pay_methods.size()) goto L19;
        if (((CJPayCreditPayMethods) ListProtector.get(r104.pay_type_data.credit_pay_methods, r105)).choose == true) goto L16;
        r105 = r105 + 1;
        goto L13
    L16:
        creditPayVoucherScrollPos = getChooseCreditPayVoucherScrollPos(r100, r105, r104.pay_type_data.credit_pay_methods.size());
    L19:
        if (r105 != r104.pay_type_data.credit_pay_methods.size()) goto L21;
    L22:
        creditPayVoucherScrollPos = 0;
        goto L25
    L21:
        if (r104.pay_type_data.credit_pay_methods.size() == 0) goto L22;
    L25:
        if (r103 != r102.paytype_info.sub_pay_type_sum_info.sub_pay_type_info_list.size()) goto L27;
    L28:
        creditPayVoucherScrollPos = 0;
    L30:
        return creditPayVoucherScrollPos;
    L27:
        if (r102.paytype_info.sub_pay_type_sum_info.sub_pay_type_info_list.size() != 0) goto L30;
    L31:
        return r101;
    }

    public static void setCJGlobalPayPayTypeItemInfo(GlobalPayTypeItemInfo r100) {
        cJClobalPayPayTypeItemInfo = r100;
    }

    public static void setCJPayPayTypeItemInfo(PayTypeItemInfo r100) {
        cJPayPayTypeItemInfo = r100;
    }

    public static void setCJPayPaymentMethodInfo(PaymentMethodInfo r100) {
        mSelectMethodInfo = (PaymentMethodInfo) CJPayJsonParser.fromJson(CJPayJsonParser.toJsonObject(r100), PaymentMethodInfo.class);
    }

    public static void setCombineType(String r100) {
        combineType = r100;
    }

    public static void setCreditPayVoucherScrollPos(int r100) {
        creditPayVoucherScrollPos = r100;
    }

    public static void setIsCombinePay(boolean r100) {
        isCombinePay = r100;
    }

    public static void setSelectMethodInfoWithoutCheckbox(PaymentMethodInfo r100) {
        mSelectMethodInfoWithoutCheckbox = (PaymentMethodInfo) CJPayJsonParser.fromJson(CJPayJsonParser.toJsonObject(r100), PaymentMethodInfo.class);
    }

    public static int getChooseCreditPayVoucherScrollPos(Context r100, int r101, int r102) {
        int r103 = CJPayBasicUtils.getAbsolutePhysicalWidthOfScreen(r100) - CJPayBasicUtils.dipToPX(r100, 52.0f);
        if (r101 != 0) goto L6;
        return 0;
    L6:
        if (r101 != (r102 - 1)) goto L10;
        int r104 = (((r101 + 1) * CJPayBasicUtils.dipToPX(r100, 120.0f)) + (r101 * CJPayBasicUtils.dipToPX(r100, 8.0f))) + CJPayBasicUtils.dipToPX(r100, 16.0f);
        if (r104 > r103) goto L16;
        return 0;
    L16:
        return r104 - r103;
    L10:
        int r105 = (r101 * (CJPayBasicUtils.dipToPX(r100, 120.0f) + CJPayBasicUtils.dipToPX(r100, 8.0f))) + (CJPayBasicUtils.dipToPX(r100, 120.0f) / 2);
        int r106 = r103 / 2;
        if (r105 > r106) goto L14;
        return 0;
    L14:
        return r105 - r106;
    }

    public void setBindCardVoucher(String r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L4
        this.bindCardVoucher = r103;     // Catch: Exception -> L4
        r103.put("card_add_ext", r100);     // Catch: Exception -> L4
        this.bindCardVoucher.put("bank_code", r101);     // Catch: Exception -> L4
        this.bindCardVoucher.put(a.KEY_CARD_TYPE, r102);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("ShareData#setBindCardVoucher", e);
        CJBasicCommonUtils.logCatch("CJCatch", "ShareData#setBindCardVoucher", e);
        e.printStackTrace();
    }
}
