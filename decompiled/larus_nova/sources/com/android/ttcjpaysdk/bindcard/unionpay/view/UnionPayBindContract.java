package com.android.ttcjpaysdk.bindcard.unionpay.view;

import android.app.Activity;
import com.android.ttcjpaysdk.base.mvp.mvp.MvpView;
import com.android.ttcjpaysdk.base.service.ICJPayServiceCallBack;
import com.android.ttcjpaysdk.base.ui.data.CJPayProtocolGroupContentsBean;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayNameAndIdentifyCodeBillBean;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayRealNameBean;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPaySmsTokenBean;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayTwoAuthVerifyBean;
import com.android.ttcjpaysdk.bindcard.unionpay.bean.UnionPayAuthResponseBean;
import com.android.ttcjpaysdk.bindcard.unionpay.bean.UnionPayBindCardBean;
import com.android.ttcjpaysdk.bindcard.unionpay.bean.UnionPayCreateOrderBean;
import com.android.ttcjpaysdk.bindcard.unionpay.bean.UnionPayGetBankListResponseBean;
import com.android.ttcjpaysdk.bindcard.unionpay.bean.UnionPaySignBean;
import com.android.ttcjpaysdk.bindcard.unionpay.bean.UnionPaySignInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/unionpay/view/UnionPayBindContract;", "", "()V", "TwoElementAuthView", "UnionPayAuthView", "UnionPayBaseView", "UnionPayBindCardView", "UnionPaySmsBindCardView", "bdpay-bindcard-unionpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UnionPayBindContract {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u001c\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\fH&¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/unionpay/view/UnionPayBindContract$TwoElementAuthView;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpView;", "onFetchAuthProtocolFail", "", "errorCode", "", "errorMessage", "onFetchAuthProtocolSuccess", "result", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayProtocolGroupContentsBean;", "onTwoElementVerifyFail", "onTwoElementVerifySuccess", "Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPayTwoAuthVerifyBean;", "bdpay-bindcard-unionpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface TwoElementAuthView extends MvpView {
        void onFetchAuthProtocolFail(String r100, String r101);

        void onFetchAuthProtocolSuccess(CJPayProtocolGroupContentsBean r100);

        void onTwoElementVerifyFail(String r100, String r101);

        void onTwoElementVerifySuccess(CJPayTwoAuthVerifyBean r100);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/unionpay/view/UnionPayBindContract$UnionPayAuthView;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpView;", "onUnionPaySignFail", "", "errorCode", "", "errorMessage", "onUnionPaySignSuccess", "result", "Lcom/android/ttcjpaysdk/bindcard/unionpay/bean/UnionPaySignBean;", "bdpay-bindcard-unionpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface UnionPayAuthView extends MvpView {
        void onUnionPaySignFail(String r100, String r101);

        void onUnionPaySignSuccess(UnionPaySignBean r100);
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J.\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J&\u0010\u000f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J&\u0010\u0010\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J&\u0010\u0012\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J.\u0010\u0013\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\f\u001a\u0004\u0018\u00010\u00162\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J&\u0010\u0017\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J.\u0010\u0018\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\f\u001a\u0004\u0018\u00010\u00192\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\u001a"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/unionpay/view/UnionPayBindContract$UnionPayBaseView;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpView;", "onCreateUnionPayOrderFail", "", "errorCode", "", "errorMessage", "callBack", "Lcom/android/ttcjpaysdk/base/service/ICJPayServiceCallBack;", "onCreateUnionPayOrderSuccess", "activity", "Landroid/app/Activity;", "result", "Lcom/android/ttcjpaysdk/bindcard/unionpay/bean/UnionPayCreateOrderBean;", "voucherLabel", "onFetchUnionBizOrderFail", "onFetchUnionBizOrderSuccess", "Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPayNameAndIdentifyCodeBillBean;", "onFetchUnionPayAuthInfoFail", "onFetchUnionPayAuthInfoSuccess", "unionPaySignInfo", "Lcom/android/ttcjpaysdk/bindcard/unionpay/bean/UnionPaySignInfo;", "Lcom/android/ttcjpaysdk/bindcard/unionpay/bean/UnionPayAuthResponseBean;", "onFetchUnionPayBankListFail", "onFetchUnionPayBankListSuccess", "Lcom/android/ttcjpaysdk/bindcard/unionpay/bean/UnionPayGetBankListResponseBean;", "bdpay-bindcard-unionpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface UnionPayBaseView extends MvpView {
        void onCreateUnionPayOrderFail(String r100, String r101, ICJPayServiceCallBack r102);

        void onCreateUnionPayOrderSuccess(Activity r100, UnionPayCreateOrderBean r101, String r102, ICJPayServiceCallBack r103);

        void onFetchUnionBizOrderFail(String r100, String r101, ICJPayServiceCallBack r102);

        void onFetchUnionBizOrderSuccess(Activity r100, CJPayNameAndIdentifyCodeBillBean r101, ICJPayServiceCallBack r102);

        void onFetchUnionPayAuthInfoFail(String r100, String r101, ICJPayServiceCallBack r102);

        void onFetchUnionPayAuthInfoSuccess(Activity r100, UnionPaySignInfo r101, UnionPayAuthResponseBean r102, ICJPayServiceCallBack r103);

        void onFetchUnionPayBankListFail(String r100, String r101, ICJPayServiceCallBack r102);

        void onFetchUnionPayBankListSuccess(Activity r100, UnionPaySignInfo r101, UnionPayGetBankListResponseBean r102, ICJPayServiceCallBack r103);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u001c\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u000eH&¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/unionpay/view/UnionPayBindContract$UnionPayBindCardView;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpView;", "onSendSmsFail", "", "errorCode", "", "errorMessage", "onSendSmsSuccess", "result", "Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPaySmsTokenBean;", "realNameBean", "Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPayRealNameBean;", "onUnionBindCardFail", "onUnionBindCardSuccess", "Lcom/android/ttcjpaysdk/bindcard/unionpay/bean/UnionPayBindCardBean;", "bdpay-bindcard-unionpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface UnionPayBindCardView extends MvpView {
        void onSendSmsFail(String r100, String r101);

        void onSendSmsSuccess(CJPaySmsTokenBean r100, CJPayRealNameBean r101);

        void onUnionBindCardFail(String r100, String r101);

        void onUnionBindCardSuccess(UnionPayBindCardBean r100);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u001c\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010\u000b\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/unionpay/view/UnionPayBindContract$UnionPaySmsBindCardView;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpView;", "onUnionCreateBizOrderFail", "", "errorCode", "", "errorMessage", "onUnionCreateBizOrderSuccess", "result", "Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPayNameAndIdentifyCodeBillBean;", "onUnionSendSignSmsFail", "onUnionSendSignSmsSuccess", "Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPaySmsTokenBean;", "realNameBean", "Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPayRealNameBean;", "bdpay-bindcard-unionpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface UnionPaySmsBindCardView extends MvpView {
        void onUnionCreateBizOrderFail(String r100, String r101);

        void onUnionCreateBizOrderSuccess(CJPayNameAndIdentifyCodeBillBean r100);

        void onUnionSendSignSmsFail(String r100, String r101);

        void onUnionSendSignSmsSuccess(CJPaySmsTokenBean r100, CJPayRealNameBean r101);
    }

    public UnionPayBindContract() {
    }
}
