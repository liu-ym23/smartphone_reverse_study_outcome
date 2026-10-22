package com.android.ttcjpaysdk.fastpay.data;

import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.service.IFastPayFailureCallback;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.fastpay.data.bean.FastPayResponseBean;
import com.android.ttcjpaysdk.fastpay.data.bean.FastPayTradeErrorBean;
import com.ss.android.dypay.api.DyPayConstant;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u000267B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u00103\u001a\u0004\u0018\u00010.J\u0006\u00104\u001a\u000205R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u00068"}, d2 = {"Lcom/android/ttcjpaysdk/fastpay/data/ShareData;", "", "()V", "sFailureCallback", "Lcom/android/ttcjpaysdk/base/service/IFastPayFailureCallback;", "getSFailureCallback", "()Lcom/android/ttcjpaysdk/base/service/IFastPayFailureCallback;", "setSFailureCallback", "(Lcom/android/ttcjpaysdk/base/service/IFastPayFailureCallback;)V", "sFastPayParams", "", "", "getSFastPayParams", "()Ljava/util/Map;", "setSFastPayParams", "(Ljava/util/Map;)V", "sHostInfo", "Lcom/android/ttcjpaysdk/base/CJPayHostInfo;", "getSHostInfo", "()Lcom/android/ttcjpaysdk/base/CJPayHostInfo;", "setSHostInfo", "(Lcom/android/ttcjpaysdk/base/CJPayHostInfo;)V", "sResponseBean", "Lcom/android/ttcjpaysdk/fastpay/data/bean/FastPayResponseBean;", "getSResponseBean", "()Lcom/android/ttcjpaysdk/fastpay/data/bean/FastPayResponseBean;", "setSResponseBean", "(Lcom/android/ttcjpaysdk/fastpay/data/bean/FastPayResponseBean;)V", "sSuperPayCallBack", "Lcom/android/ttcjpaysdk/fastpay/data/ShareData$ISuperPayCallBack;", "getSSuperPayCallBack", "()Lcom/android/ttcjpaysdk/fastpay/data/ShareData$ISuperPayCallBack;", "setSSuperPayCallBack", "(Lcom/android/ttcjpaysdk/fastpay/data/ShareData$ISuperPayCallBack;)V", "superPayAgainCallback", "Lcom/android/ttcjpaysdk/fastpay/data/ShareData$ISuperPayAgainCallBack;", "getSuperPayAgainCallback", "()Lcom/android/ttcjpaysdk/fastpay/data/ShareData$ISuperPayAgainCallBack;", "setSuperPayAgainCallback", "(Lcom/android/ttcjpaysdk/fastpay/data/ShareData$ISuperPayAgainCallBack;)V", "tradeNo", "getTradeNo", "()Ljava/lang/String;", "setTradeNo", "(Ljava/lang/String;)V", "verifyJson", "Lorg/json/JSONObject;", "getVerifyJson", "()Lorg/json/JSONObject;", "setVerifyJson", "(Lorg/json/JSONObject;)V", "getVerificationJSON", "release", "", "ISuperPayAgainCallBack", "ISuperPayCallBack", "fastpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShareData {
    public static final ShareData INSTANCE = null;
    private static IFastPayFailureCallback sFailureCallback;
    private static Map<String, String> sFastPayParams;
    private static CJPayHostInfo sHostInfo;
    private static FastPayResponseBean sResponseBean;
    private static ISuperPayCallBack sSuperPayCallBack;
    private static ISuperPayAgainCallBack superPayAgainCallback;
    private static String tradeNo;
    private static JSONObject verifyJson;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\u0003H&¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/fastpay/data/ShareData$ISuperPayAgainCallBack;", "", "onFailure", "", "errorMsg", "", "tips", "isShowLoading", "", "onSuccess", "tradeNo", DyPayConstant.KEY_SHOW_LOADING, "fastpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ISuperPayAgainCallBack {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class DefaultImpls {
            public static /* synthetic */ void onFailure$default(ISuperPayAgainCallBack r100, String r101, String r102, boolean r103, int r104, Object r105) {
                if (r105 != null) goto L15;
                if ((r104 & 1) == 0) goto L7;
                r101 = null;
            L7:
                if ((r104 & 2) == 0) goto L10;
                r102 = null;
            L10:
                if ((r104 & 4) == 0) goto L12;
                r103 = true;
            L12:
                r100.onFailure(r101, r102, r103);
                return;
            L15:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onFailure");
            }
        }

        void onFailure(String r100, String r101, boolean r102);

        void onSuccess(String r100);

        void showLoading();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/fastpay/data/ShareData$ISuperPayCallBack;", "Ljava/io/Serializable;", "hideLoading", "", "onFailure", "onSuccess", DyPayConstant.KEY_SHOW_LOADING, "fastpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ISuperPayCallBack extends Serializable {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class DefaultImpls {
            public static void hideLoading(ISuperPayCallBack r100) {
            }

            public static void onFailure(ISuperPayCallBack r100) {
            }

            public static void onSuccess(ISuperPayCallBack r100) {
            }

            public static void showLoading(ISuperPayCallBack r100) {
            }
        }

        void hideLoading();

        void onFailure();

        void onSuccess();

        void showLoading();
    }

    private ShareData() {
    }

    public final void release() {
        sHostInfo = null;
        sFastPayParams = null;
        sFailureCallback = null;
        sResponseBean = null;
        verifyJson = null;
        sSuperPayCallBack = null;
        superPayAgainCallback = null;
    }

    static {
        INSTANCE = new ShareData();
        tradeNo = "";
    }

    public final JSONObject getVerificationJSON() {
        JSONObject r100 = verifyJson;
        if (r100 == null) goto L18;
        return r100;
    L18:
        FastPayResponseBean r101 = sResponseBean;     // Catch: Exception -> L15
        if (r101 == null) goto L14;
        FastPayTradeErrorBean r102 = r101.error;     // Catch: Exception -> L15
        if (r102 == null) goto L14;
        String r103 = r102.data;     // Catch: Exception -> L15
        if (r103 == null) goto L14;
        JSONObject r104 = new JSONObject(r103);     // Catch: Exception -> L15
        verifyJson = r104;     // Catch: Exception -> L15
        return r104;
    L14:
        return null;
    L15:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("ShareData#getVerificationJSON", e);
        CJBasicCommonUtils.logCatch("CJCatch", "ShareData#getVerificationJSON", e);
        return null;
    }

    public final IFastPayFailureCallback getSFailureCallback() {
        return sFailureCallback;
    }

    public final Map<String, String> getSFastPayParams() {
        return sFastPayParams;
    }

    public final CJPayHostInfo getSHostInfo() {
        return sHostInfo;
    }

    public final FastPayResponseBean getSResponseBean() {
        return sResponseBean;
    }

    public final ISuperPayCallBack getSSuperPayCallBack() {
        return sSuperPayCallBack;
    }

    public final ISuperPayAgainCallBack getSuperPayAgainCallback() {
        return superPayAgainCallback;
    }

    public final String getTradeNo() {
        return tradeNo;
    }

    public final JSONObject getVerifyJson() {
        return verifyJson;
    }

    public final void setSFailureCallback(IFastPayFailureCallback r100) {
        sFailureCallback = r100;
    }

    public final void setSFastPayParams(Map<String, String> r100) {
        sFastPayParams = r100;
    }

    public final void setSHostInfo(CJPayHostInfo r100) {
        sHostInfo = r100;
    }

    public final void setSResponseBean(FastPayResponseBean r100) {
        sResponseBean = r100;
    }

    public final void setSSuperPayCallBack(ISuperPayCallBack r100) {
        sSuperPayCallBack = r100;
    }

    public final void setSuperPayAgainCallback(ISuperPayAgainCallBack r100) {
        superPayAgainCallback = r100;
    }

    public final void setTradeNo(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        tradeNo = r100;
    }

    public final void setVerifyJson(JSONObject r100) {
        verifyJson = r100;
    }
}
