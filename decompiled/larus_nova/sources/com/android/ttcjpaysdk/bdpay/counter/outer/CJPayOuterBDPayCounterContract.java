package com.android.ttcjpaysdk.bdpay.counter.outer;

import com.android.ttcjpaysdk.base.mvp.mvp.MvpView;
import com.android.ttcjpaysdk.thirdparty.data.CJPayCheckoutCounterResponseBean;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/CJPayOuterBDPayCounterContract;", "", "CJPayOuterBDPayConfirmView", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CJPayOuterBDPayCounterContract {

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J0\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\fH\u0016J$\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/CJPayOuterBDPayCounterContract$CJPayOuterBDPayConfirmView;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpView;", "onLogEvent", "", "action", "", "params", "Lorg/json/JSONObject;", "tradeCreateFailure", "code", "message", "isSilentReload", "", "scene", "tradeCreateStart", "isFirstRequest", "tradeCreateSuccess", "result", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayCheckoutCounterResponseBean;", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface CJPayOuterBDPayConfirmView extends MvpView {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class DefaultImpls {
            public static void tradeCreateStart(CJPayOuterBDPayConfirmView r100, boolean r101) {
            }

            public static /* synthetic */ void tradeCreateSuccess$default(CJPayOuterBDPayConfirmView r100, CJPayCheckoutCounterResponseBean r101, boolean r102, String r103, int r104, Object r105) {
                if (r105 != null) goto L9;
                if ((r104 & 4) == 0) goto L6;
                r103 = null;
            L6:
                r100.tradeCreateSuccess(r101, r102, r103);
                return;
            L9:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tradeCreateSuccess");
            }

            public static /* synthetic */ void tradeCreateFailure$default(CJPayOuterBDPayConfirmView r100, String r101, String r102, boolean r103, String r104, int r105, Object r106) {
                if (r106 != null) goto L9;
                if ((r105 & 8) == 0) goto L6;
                r104 = null;
            L6:
                r100.tradeCreateFailure(r101, r102, r103, r104);
                return;
            L9:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tradeCreateFailure");
            }
        }

        void onLogEvent(String r100, JSONObject r101);

        void tradeCreateFailure(String r100, String r101, boolean r102, String r103);

        void tradeCreateStart(boolean r100);

        void tradeCreateSuccess(CJPayCheckoutCounterResponseBean r100, boolean r101, String r102);
    }
}
