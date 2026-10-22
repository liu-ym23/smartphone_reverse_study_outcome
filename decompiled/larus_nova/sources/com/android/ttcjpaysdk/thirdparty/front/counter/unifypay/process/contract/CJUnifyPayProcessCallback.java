package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.process.contract;

import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.CJUnifyPayProcessParams;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.response.ICJUnifyPayTradeConfirmResp;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J2\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH&J(\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H&J*\u0010\u0016\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH&J@\u0010\u0018\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\f\u001a\u00020\rH&¨\u0006\u001d"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/process/contract/CJUnifyPayProcessCallback;", "", "getActualCheckType", "", "onBackToCashierHomeFromEvent", "", "onDoubleCheckFail", "result", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/process/contract/CJUnifyDoubleCheckResult;", "msg", "tradeConfirmResp", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/response/ICJUnifyPayTradeConfirmResp;", "prePayContext", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/process/contract/CJUnifyPrePayContext;", "onQueryResult", "code", "", "callBackInfo", "", "onStateChange", "state", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/process/contract/CJUnifyPayProcessState;", "onTradeConfirmIntegratedFail", "response", "onTradeConfirmResponse", "hasHandled", "", "buttonInfoSessionParams", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/CJUnifyPayProcessParams;", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CJUnifyPayProcessCallback {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getActualCheckType(CJUnifyPayProcessCallback r100) {
            return null;
        }

        public static void onBackToCashierHomeFromEvent(CJUnifyPayProcessCallback r100) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void onQueryResult$default(CJUnifyPayProcessCallback r100, int r101, Map r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = null;
        L6:
            r100.onQueryResult(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onQueryResult");
        }

        public static /* synthetic */ void onTradeConfirmIntegratedFail$default(CJUnifyPayProcessCallback r100, String r101, ICJUnifyPayTradeConfirmResp r102, CJUnifyPrePayContext r103, int r104, Object r105) {
            if (r105 != null) goto L15;
            if ((r104 & 1) == 0) goto L7;
            r101 = null;
        L7:
            if ((r104 & 2) == 0) goto L10;
            r102 = null;
        L10:
            if ((r104 & 4) == 0) goto L12;
            r103 = CJUnifyPrePayContext.NORMAL;
        L12:
            r100.onTradeConfirmIntegratedFail(r101, r102, r103);
            return;
        L15:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onTradeConfirmIntegratedFail");
        }

        public static /* synthetic */ void onDoubleCheckFail$default(CJUnifyPayProcessCallback r100, CJUnifyDoubleCheckResult r101, String r102, ICJUnifyPayTradeConfirmResp r103, CJUnifyPrePayContext r104, int r105, Object r106) {
            if (r106 != null) goto L15;
            if ((r105 & 2) == 0) goto L7;
            r102 = null;
        L7:
            if ((r105 & 4) == 0) goto L10;
            r103 = null;
        L10:
            if ((r105 & 8) == 0) goto L12;
            r104 = CJUnifyPrePayContext.NORMAL;
        L12:
            r100.onDoubleCheckFail(r101, r102, r103, r104);
            return;
        L15:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onDoubleCheckFail");
        }

        public static /* synthetic */ void onTradeConfirmResponse$default(CJUnifyPayProcessCallback r100, String r101, ICJUnifyPayTradeConfirmResp r102, boolean r103, CJUnifyPayProcessParams r104, CJUnifyPrePayContext r105, int r106, Object r107) {
            if (r107 != null) goto L21;
            if ((r106 & 1) == 0) goto L7;
            r101 = null;
        L7:
            if ((r106 & 2) == 0) goto L10;
            r102 = null;
        L10:
            if ((r106 & 4) == 0) goto L13;
            r103 = false;
        L13:
            if ((r106 & 8) == 0) goto L16;
            r104 = null;
        L16:
            if ((r106 & 16) == 0) goto L18;
            r105 = CJUnifyPrePayContext.NORMAL;
        L18:
            r100.onTradeConfirmResponse(r101, r102, r103, r104, r105);
            return;
        L21:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onTradeConfirmResponse");
        }
    }

    String getActualCheckType();

    void onBackToCashierHomeFromEvent();

    void onDoubleCheckFail(CJUnifyDoubleCheckResult r100, String r101, ICJUnifyPayTradeConfirmResp r102, CJUnifyPrePayContext r103);

    void onQueryResult(int r100, Map<String, String> r101);

    void onStateChange(CJUnifyPayProcessState r100);

    void onTradeConfirmIntegratedFail(String r100, ICJUnifyPayTradeConfirmResp r101, CJUnifyPrePayContext r102);

    void onTradeConfirmResponse(String r100, ICJUnifyPayTradeConfirmResp r101, boolean r102, CJUnifyPayProcessParams r103, CJUnifyPrePayContext r104);
}
