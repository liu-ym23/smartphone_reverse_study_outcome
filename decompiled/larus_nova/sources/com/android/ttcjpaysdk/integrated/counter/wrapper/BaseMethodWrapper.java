package com.android.ttcjpaysdk.integrated.counter.wrapper;

import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.android.ttcjpaysdk.base.framework.BaseWrapper;
import com.android.ttcjpaysdk.base.service.ICJPayCombineService;
import com.android.ttcjpaysdk.base.ui.data.IconTips;
import com.android.ttcjpaysdk.base.ui.data.VoucherInfo;
import com.android.ttcjpaysdk.base.ui.widget.ExtendRecyclerView;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.integrated.counter.beans.ShareData;
import com.android.ttcjpaysdk.integrated.counter.data.Card;
import com.android.ttcjpaysdk.integrated.counter.data.CounterResponseBean;
import com.android.ttcjpaysdk.integrated.counter.data.PaymentMethodInfo;
import com.android.ttcjpaysdk.integrated.counter.data.TypeItems;
import com.android.ttcjpaysdk.integrated.counter.utils.CJPayCommonParamsBuildUtils;
import com.android.ttcjpaysdk.integrated.counter.utils.CJPayDiscountUtils;
import com.android.ttcjpaysdk.integrated.counter.utils.CJPayPaymentMethodUtils;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001:\u0001XB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107H&J\u0012\u00108\u001a\u0002052\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\b\u0010;\u001a\u00020/H\u0016J*\u0010<\u001a\u0012\u0012\u0004\u0012\u00020\f0=j\b\u0012\u0004\u0012\u00020\f`>2\b\u00106\u001a\u0004\u0018\u0001072\u0006\u0010?\u001a\u00020\fH\u0016J\b\u0010@\u001a\u00020\u0012H\u0002J\b\u0010A\u001a\u00020\u0018H\u0016J \u0010B\u001a\u00020C2\u0016\u0010D\u001a\u0012\u0012\u0004\u0012\u00020\f0=j\b\u0012\u0004\u0012\u00020\f`>H\u0002J\u0012\u0010E\u001a\u00020\u00122\b\u0010F\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010G\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010H\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010I\u001a\u00020JH&J\b\u0010K\u001a\u00020)H&J\b\u0010L\u001a\u000205H&J\u0012\u0010M\u001a\u00020\u00182\b\u0010N\u001a\u0004\u0018\u00010\u0012H\u0016J*\u0010O\u001a\u0002052\u0016\u0010P\u001a\u0012\u0012\u0004\u0012\u00020\f0=j\b\u0012\u0004\u0012\u00020\f`>2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0016J\b\u0010S\u001a\u000205H\u0016J\u0010\u0010T\u001a\u0002052\u0006\u0010U\u001a\u00020\u0018H\u0016J\u0010\u0010V\u001a\u0002052\u0006\u0010W\u001a\u00020\u0018H&R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0018X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001a\u0010\u001e\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\u001a\u0010 \u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020/X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u0006Y"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/wrapper/BaseMethodWrapper;", "Lcom/android/ttcjpaysdk/base/framework/BaseWrapper;", "contentView", "Landroid/view/View;", "(Landroid/view/View;)V", "combineType", "Lcom/android/ttcjpaysdk/base/service/ICJPayCombineService$CombineType;", "getCombineType", "()Lcom/android/ttcjpaysdk/base/service/ICJPayCombineService$CombineType;", "setCombineType", "(Lcom/android/ttcjpaysdk/base/service/ICJPayCombineService$CombineType;)V", "currentSelectedPaymentMethod", "Lcom/android/ttcjpaysdk/integrated/counter/data/PaymentMethodInfo;", "getCurrentSelectedPaymentMethod", "()Lcom/android/ttcjpaysdk/integrated/counter/data/PaymentMethodInfo;", "setCurrentSelectedPaymentMethod", "(Lcom/android/ttcjpaysdk/integrated/counter/data/PaymentMethodInfo;)V", "incomePayNotAvailableTips", "", "getIncomePayNotAvailableTips", "()Ljava/lang/String;", "setIncomePayNotAvailableTips", "(Ljava/lang/String;)V", "isBanlanceLimit", "", "()Z", "setBanlanceLimit", "(Z)V", "isCollapse", "setCollapse", "isIncomePayFailStatus", "setIncomePayFailStatus", "isShowInsufficient", "setShowInsufficient", "onMethodWrapperListener", "Lcom/android/ttcjpaysdk/integrated/counter/wrapper/BaseMethodWrapper$OnMethodWrapperListener;", "getOnMethodWrapperListener", "()Lcom/android/ttcjpaysdk/integrated/counter/wrapper/BaseMethodWrapper$OnMethodWrapperListener;", "setOnMethodWrapperListener", "(Lcom/android/ttcjpaysdk/integrated/counter/wrapper/BaseMethodWrapper$OnMethodWrapperListener;)V", "outAnim", "", "getOutAnim", "()I", "setOutAnim", "(I)V", "reportingData", "Lorg/json/JSONObject;", "getReportingData", "()Lorg/json/JSONObject;", "setReportingData", "(Lorg/json/JSONObject;)V", "bindData", "", "checkoutResponseBean", "Lcom/android/ttcjpaysdk/integrated/counter/data/CounterResponseBean;", "executeAdjustOnScreenChanged", "newConfig", "Landroid/content/res/Configuration;", "fetchReportingData", "getCardInfoList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "selectCardInfo", "getCardListInfo", "getCollapseState", "getDiscountReportInfo", "Lorg/json/JSONArray;", "methods", "getFrontBankCode", "methodInfo", "getHorizontalAnimationClipHostView", "getHorizontalAnimationTargetView", "getRecyclerView", "Lcom/android/ttcjpaysdk/base/ui/widget/ExtendRecyclerView;", "getResId", "initActions", "isInsufficient", "cardNo", "logPageShow", "cardMethods", "tipsInfo", "Lcom/android/ttcjpaysdk/base/ui/data/IconTips;", "reverseCollapseState", "setCollapseState", "state", DyPayConstant.KEY_SHOW_LOADING, "show", "OnMethodWrapperListener", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class BaseMethodWrapper extends BaseWrapper {
    private ICJPayCombineService.CombineType combineType;
    private PaymentMethodInfo currentSelectedPaymentMethod;
    private String incomePayNotAvailableTips;
    private boolean isBanlanceLimit;
    private boolean isCollapse;
    private boolean isIncomePayFailStatus;
    private boolean isShowInsufficient;
    private OnMethodWrapperListener onMethodWrapperListener;
    private int outAnim;
    private JSONObject reportingData;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/wrapper/BaseMethodWrapper$OnMethodWrapperListener;", "", "onExitClick", "", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnMethodWrapperListener {
        void onExitClick();
    }

    public abstract void bindData(CounterResponseBean r100);

    public void executeAdjustOnScreenChanged(Configuration r100) {
    }

    public View getHorizontalAnimationClipHostView() {
        return null;
    }

    public View getHorizontalAnimationTargetView() {
        return null;
    }

    public abstract ExtendRecyclerView getRecyclerView();

    public abstract int getResId();

    public abstract void initActions();

    public abstract void showLoading(boolean r100);

    private final String getCardListInfo() {
        StringBuilder r100 = new StringBuilder();
        CounterResponseBean r101 = ShareData.checkoutResponseBean;
        if (r101 == null) goto L14;
        Iterator<T> r102 = r101.data.paytype_items.iterator();
    L6:
        if (r102.hasNext() == false) goto L14;
        TypeItems r103 = (TypeItems) r102.next();
        if (Intrinsics.areEqual(r103.ptcode, CJPayConstant.TT_CJ_PAY_KEY_FOR_BYTEPAY) == false) goto L6;
        Iterator<T> r104 = r103.paytype_item.paytype_info.quick_pay.cards.iterator();
    L11:
        if (r104.hasNext() == false) goto L6;
        Card r105 = (Card) r104.next();
        r100.append(r105.bank_name);
        r100.append(r105.card_type_name);
        r100.append(",");
    L14:
        if (r100.length() <= 0) goto L16;
        boolean r106 = true;
    L17:
        if (r106 == true) goto L26;
        return "";
    L26:
        return r100.substring(0, r100.length() - 1);
    L16:
        r106 = false;
        goto L17
    }

    public void reverseCollapseState() {
        this.isCollapse = !this.isCollapse;
    }

    public JSONObject fetchReportingData() {
        return this.reportingData;
    }

    public boolean getCollapseState() {
        return this.isCollapse;
    }

    public final ICJPayCombineService.CombineType getCombineType() {
        return this.combineType;
    }

    public final PaymentMethodInfo getCurrentSelectedPaymentMethod() {
        return this.currentSelectedPaymentMethod;
    }

    public final String getIncomePayNotAvailableTips() {
        return this.incomePayNotAvailableTips;
    }

    public final OnMethodWrapperListener getOnMethodWrapperListener() {
        return this.onMethodWrapperListener;
    }

    public final int getOutAnim() {
        return this.outAnim;
    }

    public final JSONObject getReportingData() {
        return this.reportingData;
    }

    public final boolean isBanlanceLimit() {
        return this.isBanlanceLimit;
    }

    public final boolean isCollapse() {
        return this.isCollapse;
    }

    public final boolean isIncomePayFailStatus() {
        return this.isIncomePayFailStatus;
    }

    public final boolean isShowInsufficient() {
        return this.isShowInsufficient;
    }

    public BaseMethodWrapper(View r100) {
        Intrinsics.checkNotNullParameter(r100, "contentView");
        super(r100);
        this.outAnim = -1;
        this.incomePayNotAvailableTips = "";
        LayoutInflater.from(getContext()).inflate(getResId(), (ViewGroup) r100);
        this.isCollapse = true;
        this.reportingData = new JSONObject();
    }

    private final JSONArray getDiscountReportInfo(ArrayList<PaymentMethodInfo> r100) {
        JSONArray r101 = new JSONArray();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L13;
        PaymentMethodInfo r103 = (PaymentMethodInfo) r102.next();
        Iterator<T> r104 = r103.voucher_info.vouchers.iterator();
    L7:
        if (r104.hasNext() == false) goto L4;
        VoucherInfo.Voucher r105 = (VoucherInfo.Voucher) r104.next();
        r101.put(CJPayDiscountUtils.Companion.createReportDiscountInfo(r105, r103.card.front_bank_code));     // Catch: Exception -> L11
    L11:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("BaseMethodWrapper#getDiscountReportInfo", e);
        CJBasicCommonUtils.logCatch("CJCatch", "BaseMethodWrapper#getDiscountReportInfo", e);
        goto L7
    L13:
        return r101;
    }

    public String getFrontBankCode(PaymentMethodInfo r100) {
        if (r100 == null) goto L6;
        Card r101 = r100.card;
        if (r101 == null) goto L6;
        String r102 = r101.front_bank_code;
    L7:
        if (r102 != null) goto L10;
        return "";
    L10:
        return r102;
    L6:
        r102 = null;
        goto L7
    }

    public boolean isInsufficient(String r100) {
        return CJPayPaymentMethodUtils.Companion.getIsInsufficient(r100);
    }

    public final void setBanlanceLimit(boolean r100) {
        this.isBanlanceLimit = r100;
    }

    public final void setCollapse(boolean r100) {
        this.isCollapse = r100;
    }

    public void setCollapseState(boolean r100) {
        this.isCollapse = r100;
    }

    public final void setCombineType(ICJPayCombineService.CombineType r100) {
        this.combineType = r100;
    }

    public final void setCurrentSelectedPaymentMethod(PaymentMethodInfo r100) {
        this.currentSelectedPaymentMethod = r100;
    }

    public final void setIncomePayFailStatus(boolean r100) {
        this.isIncomePayFailStatus = r100;
    }

    public final void setIncomePayNotAvailableTips(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.incomePayNotAvailableTips = r100;
    }

    public final void setOnMethodWrapperListener(OnMethodWrapperListener r100) {
        this.onMethodWrapperListener = r100;
    }

    public final void setOutAnim(int r100) {
        this.outAnim = r100;
    }

    public final void setReportingData(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.reportingData = r100;
    }

    public final void setShowInsufficient(boolean r100) {
        this.isShowInsufficient = r100;
    }

    public ArrayList<PaymentMethodInfo> getCardInfoList(CounterResponseBean r100, PaymentMethodInfo r110) {
        Intrinsics.checkNotNullParameter(r110, "selectCardInfo");
        ArrayList<PaymentMethodInfo> r101 = new ArrayList();
        ArrayList r102 = new ArrayList();
        if (r100 != null) goto L5;
    L28:
        return r101;
    L5:
        if (r100.data.paytype_items.size() == 0) goto L28;
        Iterator<T> r103 = r100.data.paytype_items.iterator();
    L9:
        if (r103.hasNext() == false) goto L27;
        TypeItems r104 = (TypeItems) r103.next();
        if (Intrinsics.areEqual(r104.ptcode, CJPayConstant.TT_CJ_PAY_KEY_FOR_BYTEPAY) == false) goto L9;
        JSONObject r105 = r104.retain_info_v2;
        Iterator<Card> r106 = r104.paytype_item.paytype_info.quick_pay.cards.iterator();
    L14:
        if (r106.hasNext() == false) goto L23;
        Card r107 = r106.next();
        if (TextUtils.isEmpty(r107.bank_card_id) == true) goto L18;
        PaymentMethodInfo r108 = CJPayPaymentMethodUtils.Companion.createCardMethodForQuickPay(r104.paytype_item.paytype_info, r107, r110);
    L20:
        if (isInsufficient(r107.card_no) == false) goto L21;
        r102.add(r108);
        goto L14
    L21:
        r101.add(r108);
        goto L14
    L18:
        r108 = CJPayPaymentMethodUtils.Companion.createPaymentMethodForAddSpecificCard(r107);
        goto L20
    L23:
        r101.add(CJPayPaymentMethodUtils.Companion.createCardMethodForAddNormalCard(r104.paytype_item.paytype_info));
        Iterator r109 = r101.iterator();
    L25:
        if (r109.hasNext() == false) goto L9;
        ((PaymentMethodInfo) r109.next()).retainInfoV2 = r105;
        goto L25
    L27:
        r101.addAll(r102);
        goto L28
    }

    public void logPageShow(ArrayList<PaymentMethodInfo> r100, IconTips r101) {
        Intrinsics.checkNotNullParameter(r100, "cardMethods");
        JSONObject r102 = new JSONObject();
        r102.put("bank_list", getCardListInfo());     // Catch: Exception -> L5
        r102.put("campaign_info", getDiscountReportInfo(r100));     // Catch: Exception -> L5
    L7:
        CJPayCommonParamsBuildUtils.Companion.onEvent("wallet_cashier_method_page_imp", r102);
        return;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("BaseMethodWrapper#logPageShow", e);
        CJBasicCommonUtils.logCatch("CJCatch", "BaseMethodWrapper#logPageShow", e);
        goto L7
    }
}
