package com.android.ttcjpaysdk.bdpay.counter.outer.sign.deposit.contract;

import com.android.ttcjpaysdk.bdpay.counter.outer.bean.CJPaySignInfoQueryResponse;
import com.android.ttcjpaysdk.bdpay.counter.outer.sign.deposit.state.CJDepositState;
import com.android.ttcjpaysdk.bdpay.counter.outer.sign.deposit.state.CJDepositUIEvent;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/contract/CJDepositContract;", "", "Presenter", "View", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CJDepositContract {

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/contract/CJDepositContract$Presenter;", "", "attachView", "", "view", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/contract/CJDepositContract$View;", "detachView", "handleEvent", "event", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositUIEvent;", "initDepositBusiness", "signInfoResponse", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/CJPaySignInfoQueryResponse;", "onBackPressed", "", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Presenter {
        void attachView(View r100);

        void detachView();

        void handleEvent(CJDepositUIEvent r100);

        void initDepositBusiness(CJPaySignInfoQueryResponse r100);

        boolean onBackPressed();
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/contract/CJDepositContract$View;", "", "bindPresenter", "", "presenter", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/contract/CJDepositContract$Presenter;", LiveCommonConstants.REASON_ON_DEDTROY, ChameleonOpenTracker.Stage.RENDER, "depositInfo", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/CJPaySignInfoQueryResponse;", "showError", "message", "", "updateState", "state", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/state/CJDepositState;", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface View {
        void bindPresenter(Presenter r100);

        void onDestroy();

        void render(CJPaySignInfoQueryResponse r100);

        void showError(String r100);

        void updateState(CJDepositState r100);
    }
}
