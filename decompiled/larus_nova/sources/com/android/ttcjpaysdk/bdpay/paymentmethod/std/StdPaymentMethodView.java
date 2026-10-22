package com.android.ttcjpaysdk.bdpay.paymentmethod.std;

import com.android.ttcjpaysdk.base.mvp.mvp.MvpView;
import com.android.ttcjpaysdk.thirdparty.data.FrontPreTradeInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J$\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007H&J$\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0007H&J\u001a\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH&¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/paymentmethod/std/StdPaymentMethodView;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpView;", "onHideItemLoading", "", "onHidePageLoading", "onQueryPayTypeFailed", "errorCode", "", "errorMessage", "forceErrorMsg", "onQueryPayTypeSuccess", "result", "Lcom/android/ttcjpaysdk/thirdparty/data/FrontPreTradeInfo;", "isChangeChannel", "", "onShowPageLoading", "status", "onUpdateUI", "data", "bdpay-paymentmethod_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface StdPaymentMethodView extends MvpView {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void onUpdateUI$default(StdPaymentMethodView r100, FrontPreTradeInfo r101, boolean r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = false;
        L6:
            r100.onUpdateUI(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onUpdateUI");
        }

        public static /* synthetic */ void onQueryPayTypeFailed$default(StdPaymentMethodView r100, String r101, String r102, String r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L6;
            r103 = null;
        L6:
            r100.onQueryPayTypeFailed(r101, r102, r103);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onQueryPayTypeFailed");
        }

        public static /* synthetic */ void onQueryPayTypeSuccess$default(StdPaymentMethodView r100, FrontPreTradeInfo r101, boolean r102, String r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L6;
            r103 = null;
        L6:
            r100.onQueryPayTypeSuccess(r101, r102, r103);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onQueryPayTypeSuccess");
        }
    }

    void onHideItemLoading();

    void onHidePageLoading();

    void onQueryPayTypeFailed(String r100, String r101, String r102);

    void onQueryPayTypeSuccess(FrontPreTradeInfo r100, boolean r101, String r102);

    void onShowPageLoading(String r100);

    void onUpdateUI(FrontPreTradeInfo r100, boolean r101);
}
