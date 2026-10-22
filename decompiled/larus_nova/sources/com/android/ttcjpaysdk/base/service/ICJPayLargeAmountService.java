package com.android.ttcjpaysdk.base.service;

import android.content.Context;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u0000 \u00142\u00020\u0001:\u0003\u0014\u0015\u0016J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&JP\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0013\u001a\u00020\u0007H&¨\u0006\u0017"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayLargeAmountService;", "Lcom/android/ttcjpaysdk/base/service/ICJPayService;", "getCallback", "Lcom/android/ttcjpaysdk/base/service/ICJPayLargeAmountService$ICJPayLargeAmountCallback;", "getExternalLoadingAdapter", "Lcom/android/ttcjpaysdk/base/service/ICJPayLargeAmountService$ICJPayExternalLoadingAdapter;", "largeAmountPay", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "type", "", "transferPayInfo", "", "trackInfo", "Lorg/json/JSONObject;", "hostInfo", "largeAmountCallback", "loadingAdapter", "release", "Companion", "ICJPayExternalLoadingAdapter", "ICJPayLargeAmountCallback", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJPayLargeAmountService extends ICJPayService {
    public static final Companion Companion = null;
    public static final int LARGE_AMOUNT_PAY = 0;
    public static final int TRANSFER_PAY = 1;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayLargeAmountService$Companion;", "", "()V", "LARGE_AMOUNT_PAY", "", "TRANSFER_PAY", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int LARGE_AMOUNT_PAY = 0;
        public static final int TRANSFER_PAY = 1;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void largeAmountPay$default(ICJPayLargeAmountService r110, Context r111, int r112, String r113, JSONObject r114, JSONObject r115, ICJPayLargeAmountCallback r116, ICJPayExternalLoadingAdapter r117, int r118, Object r119) {
            if (r119 != null) goto L14;
            if ((r118 & 32) == 0) goto L6;
            ICJPayLargeAmountCallback r100 = null;
        L8:
            if ((r118 & 64) == 0) goto L10;
            ICJPayExternalLoadingAdapter r101 = null;
        L11:
            r110.largeAmountPay(r111, r112, r113, r114, r115, r100, r101);
            return;
        L10:
            r101 = r117;
            goto L11
        L6:
            r100 = r116;
            goto L8
        L14:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: largeAmountPay");
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayLargeAmountService$ICJPayExternalLoadingAdapter;", "", "hideLoading", "", DyPayConstant.KEY_SHOW_LOADING, "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ICJPayExternalLoadingAdapter {
        void hideLoading();

        void showLoading();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayLargeAmountService$ICJPayLargeAmountCallback;", "", "onPayResult", "", "code", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ICJPayLargeAmountCallback {
        void onPayResult(int r100);
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    ICJPayLargeAmountCallback getCallback();

    ICJPayExternalLoadingAdapter getExternalLoadingAdapter();

    void largeAmountPay(Context r100, int r101, String r102, JSONObject r103, JSONObject r104, ICJPayLargeAmountCallback r105, ICJPayExternalLoadingAdapter r106);

    void release();
}
