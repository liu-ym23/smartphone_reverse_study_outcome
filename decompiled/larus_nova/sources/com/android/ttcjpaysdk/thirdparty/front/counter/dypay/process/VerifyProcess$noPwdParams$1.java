package com.android.ttcjpaysdk.thirdparty.front.counter.dypay.process;

import com.android.ttcjpaysdk.base.service.bean.DyPayProcessConfig;
import com.android.ttcjpaysdk.base.service.bean.IntegratedCounterParams;
import com.android.ttcjpaysdk.base.ui.data.CJPayNoPwdPayInfo;
import com.android.ttcjpaysdk.base.ui.data.CJPayPayInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayCheckoutCounterResponseBean;
import com.android.ttcjpaysdk.thirdparty.data.CJPayTradeInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayUserInfo;
import com.android.ttcjpaysdk.thirdparty.front.counter.dypay.bean.DyPayData;
import com.android.ttcjpaysdk.thirdparty.verify.params.VerifyNoPwdPayParams;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016¨\u0006\u000f"}, d2 = {"com/android/ttcjpaysdk/thirdparty/front/counter/dypay/process/VerifyProcess$noPwdParams$1", "Lcom/android/ttcjpaysdk/thirdparty/verify/params/VerifyNoPwdPayParams;", "getNoPwdPayInfo", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayNoPwdPayInfo;", "getNoPwdPayStyle", "", "getPayInfo", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayPayInfo;", "getShowNoPwdButton", "getSkipNoPwdConfirm", "", "getTradeNo", "", "getUid", "isLiveCounter", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VerifyProcess$noPwdParams$1 implements VerifyNoPwdPayParams {
    final /* synthetic */ DyPayData $data;

    @Override // com.android.ttcjpaysdk.thirdparty.verify.params.VerifyNoPwdPayParams
    public boolean getSkipNoPwdConfirm() {
        return false;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.verify.params.VerifyNoPwdPayParams
    public boolean isLiveCounter() {
        return false;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.verify.params.VerifyNoPwdPayParams
    public CJPayNoPwdPayInfo getNoPwdPayInfo() {
        CJPayCheckoutCounterResponseBean r100 = this.$data.checkoutResponseBean;
        if (r100 == null) goto L8;
        CJPayNoPwdPayInfo r101 = r100.secondary_confirm_info;
        if (r101 == null) goto L8;
        CJPayNoPwdPayInfo r102 = r101.getInfoByConfirmType("nopwd");
        if (r102 == null) goto L8;
        return r102;
    L8:
        CJPayCheckoutCounterResponseBean r103 = this.$data.checkoutResponseBean;
        if (r103 == null) goto L13;
        CJPayNoPwdPayInfo r104 = r103.secondary_confirm_info;
        if (r104 == null) goto L13;
        return r104.getInfoByConfirmType("nopwd_agreement");
    L13:
        return null;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.verify.params.VerifyNoPwdPayParams
    public int getNoPwdPayStyle() {
        CJPayCheckoutCounterResponseBean r100 = this.$data.checkoutResponseBean;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.show_no_pwd_confirm_page;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.verify.params.VerifyNoPwdPayParams
    public CJPayPayInfo getPayInfo() {
        CJPayCheckoutCounterResponseBean r100 = this.$data.checkoutResponseBean;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.pay_info;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.verify.params.VerifyNoPwdPayParams
    public int getShowNoPwdButton() {
        CJPayCheckoutCounterResponseBean r100 = this.$data.checkoutResponseBean;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.show_no_pwd_button;
    }

    @Override // com.android.ttcjpaysdk.thirdparty.verify.params.VerifyNoPwdPayParams
    public String getTradeNo() {
        DyPayData r100 = this.$data;
        DyPayProcessConfig r101 = r100.config;
        DyPayProcessConfig.Scenes r102 = r101.scenes;
        if (r102 != DyPayProcessConfig.Scenes.INTEGRATED) goto L5;
    L15:
        IntegratedCounterParams r103 = r101.integratedCounterParams;
        if (r103 == null) goto L22;
        String r104 = r103.tradeNoSp;
        if (r104 != null) goto L21;
        return "";
    L21:
        return r104;
    L22:
        return "";
    L5:
        if (r102 == DyPayProcessConfig.Scenes.INTEGRATED_OUTER) goto L15;
        CJPayCheckoutCounterResponseBean r105 = r100.checkoutResponseBean;
        if (r105 == null) goto L12;
        CJPayTradeInfo r106 = r105.trade_info;
        if (r106 == null) goto L12;
        r104 = r106.trade_no;
    L13:
        if (r104 != null) goto L21;
        return "";
    L12:
        r104 = null;
        goto L13
    }

    @Override // com.android.ttcjpaysdk.thirdparty.verify.params.VerifyNoPwdPayParams
    public String getUid() {
        CJPayCheckoutCounterResponseBean r100 = this.$data.checkoutResponseBean;
        if (r100 == null) goto L7;
        CJPayUserInfo r101 = r100.user_info;
        if (r101 == null) goto L7;
        String r102 = r101.uid;
    L8:
        if (r102 != null) goto L11;
        return "";
    L11:
        return r102;
    L7:
        r102 = null;
        goto L8
    }

    public VerifyProcess$noPwdParams$1(DyPayData r100) {
        this.$data = r100;
    }
}
