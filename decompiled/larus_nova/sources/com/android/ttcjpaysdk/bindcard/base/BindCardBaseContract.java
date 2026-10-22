package com.android.ttcjpaysdk.bindcard.base;

import com.android.ttcjpaysdk.base.mvp.mvp.MvpView;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayNameAndIdentifyCodeBillBean;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayNewCardBean;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPaySetPasswordResponse;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayTwoAuthVerifyBean;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayVerifyPasswordResponse;
import com.android.ttcjpaysdk.bindcard.base.bean.QuickBindCardAdapterBean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class BindCardBaseContract {

    public interface BankCardListView extends MvpView {
        void onBindCardOrderFail(String r100, String r101);

        void onBindCardOrderSuccess(CJPayNameAndIdentifyCodeBillBean r100, QuickBindCardAdapterBean r101);

        void onTwoElementAuthFail(String r100, String r101);

        void onTwoElementAuthSuccess(CJPayTwoAuthVerifyBean r100, QuickBindCardAdapterBean r101, CJPayNameAndIdentifyCodeBillBean r102);

        void onTwoElementOrderFail(String r100, String r101);

        void onTwoElementOrderSuccess(CJPayNameAndIdentifyCodeBillBean r100, QuickBindCardAdapterBean r101);
    }

    public interface ISmsView extends MvpView {
        void onSendSmsFail(JSONObject r100);

        void onSendSmsSuccess(JSONObject r100);

        void onSmsConfirmFail(JSONObject r100);

        void onSmsConfirmSuccess(JSONObject r100);
    }

    public interface PayNewCardView extends MvpView {
        void onPayFail(String r100, String r101, boolean r102);

        void onPaySuccess(CJPayNewCardBean r100, boolean r101);
    }

    public interface SetPwdView extends MvpView {
        void onSetPwdFail(String r100, String r101);

        void onSetPwdSuccess(CJPaySetPasswordResponse r100);
    }

    public interface VerifyPwdView extends MvpView {
        void onVerifyPwdFail(String r100, String r101);

        void onVerifyPwdSuccess(CJPayVerifyPasswordResponse r100);
    }

    public BindCardBaseContract() {
    }
}
