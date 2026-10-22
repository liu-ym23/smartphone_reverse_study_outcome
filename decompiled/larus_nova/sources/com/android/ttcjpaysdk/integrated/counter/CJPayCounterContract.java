package com.android.ttcjpaysdk.integrated.counter;

import com.android.ttcjpaysdk.base.mvp.mvp.MvpView;
import com.android.ttcjpaysdk.bdpay.paymentmethod.ShareData;
import com.android.ttcjpaysdk.integrated.counter.data.CounterResponseBean;
import com.android.ttcjpaysdk.integrated.counter.data.CounterTradeConfirmResponseBean;
import com.android.ttcjpaysdk.integrated.counter.data.QuerySignInfo;
import com.android.ttcjpaysdk.integrated.counter.data.TradeQueryBean;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/CJPayCounterContract;", "", "CJPayConfirmView", "CJPayCounterView", "CJPayCreateView", "CJPayQueryView", "CJPaySignInfoView", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CJPayCounterContract {

    /* JADX INFO: loaded from: classes3.dex */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001e\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\rH&J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0010H&¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/CJPayCounterContract$CJPayConfirmView;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpView;", "tradeConfirmFailure", "", "message", "", "tradeConfirmSuccess", "result", "Lcom/android/ttcjpaysdk/integrated/counter/data/CounterTradeConfirmResponseBean;", "newCardParams", "Lorg/json/JSONObject;", "tradeCreateFailure", "tradeCreateSuccess", "Lcom/android/ttcjpaysdk/integrated/counter/data/CounterResponseBean;", "tradeQueryFailure", "tradeQuerySuccess", "Lcom/android/ttcjpaysdk/integrated/counter/data/TradeQueryBean;", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface CJPayConfirmView extends MvpView {

        /* JADX INFO: loaded from: classes28.dex */
        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class DefaultImpls {
            public static /* synthetic */ void tradeConfirmSuccess$default(CJPayConfirmView r100, CounterTradeConfirmResponseBean r101, JSONObject r102, int r103, Object r104) {
                if (r104 != null) goto L9;
                if ((r103 & 2) == 0) goto L6;
                r102 = null;
            L6:
                r100.tradeConfirmSuccess(r101, r102);
                return;
            L9:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tradeConfirmSuccess");
            }
        }

        void tradeConfirmFailure(String r100);

        void tradeConfirmSuccess(CounterTradeConfirmResponseBean r100, JSONObject r101);

        void tradeCreateFailure(String r100);

        void tradeCreateSuccess(CounterResponseBean r100);

        void tradeQueryFailure(String r100);

        void tradeQuerySuccess(TradeQueryBean r100);
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/CJPayCounterContract$CJPayCounterView;", "Lcom/android/ttcjpaysdk/integrated/counter/CJPayCounterContract$CJPayCreateView;", "Lcom/android/ttcjpaysdk/integrated/counter/CJPayCounterContract$CJPaySignInfoView;", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface CJPayCounterView extends CJPayCreateView, CJPaySignInfoView {
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&J,\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/CJPayCounterContract$CJPayCreateView;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpView;", "tradeCreateFailure", "", "message", "", "refer", ShareData.ISCOMBINEPAY, "", "isRefresh", "tradeCreateSuccess", "result", "Lcom/android/ttcjpaysdk/integrated/counter/data/CounterResponseBean;", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface CJPayCreateView extends MvpView {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class DefaultImpls {
            public static /* synthetic */ void tradeCreateFailure$default(CJPayCreateView r100, String r101, String r102, boolean r103, boolean r104, int r105, Object r106) {
                if (r106 != null) goto L9;
                if ((r105 & 2) == 0) goto L6;
                r102 = "";
            L6:
                r100.tradeCreateFailure(r101, r102, r103, r104);
                return;
            L9:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tradeCreateFailure");
            }

            public static /* synthetic */ void tradeCreateSuccess$default(CJPayCreateView r100, CounterResponseBean r101, String r102, boolean r103, boolean r104, int r105, Object r106) {
                if (r106 != null) goto L9;
                if ((r105 & 2) == 0) goto L6;
                r102 = "";
            L6:
                r100.tradeCreateSuccess(r101, r102, r103, r104);
                return;
            L9:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tradeCreateSuccess");
            }
        }

        void tradeCreateFailure(String r100, String r101, boolean r102, boolean r103);

        void tradeCreateSuccess(CounterResponseBean r100, String r101, boolean r102, boolean r103);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/CJPayCounterContract$CJPayQueryView;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpView;", "tradeQueryFailure", "", "message", "", "tradeQuerySuccess", "result", "Lcom/android/ttcjpaysdk/integrated/counter/data/TradeQueryBean;", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface CJPayQueryView extends MvpView {
        void tradeQueryFailure(String r100);

        void tradeQuerySuccess(TradeQueryBean r100);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/CJPayCounterContract$CJPaySignInfoView;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/MvpView;", "querySignInfoFailure", "", "message", "", "querySignInfoSuccess", "result", "Lcom/android/ttcjpaysdk/integrated/counter/data/QuerySignInfo;", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface CJPaySignInfoView extends MvpView {
        void querySignInfoFailure(String r100);

        void querySignInfoSuccess(QuerySignInfo r100);
    }
}
