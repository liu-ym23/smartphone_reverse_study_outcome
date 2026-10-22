package com.android.ttcjpaysdk.bdpay.counter.outer.bean;

import com.bytedance.android.livesdkapi.app.AppConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001BI\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/CJSignInfoReqBean;", "", "token", "", "merchantId", "invokeFromInner", "", "callerApp", "processInfo", AppConstants.BUNDLE_REFERER, "callerRiskInfo", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCallerApp", "()Ljava/lang/String;", "getCallerRiskInfo", "getInvokeFromInner", "()Z", "getMerchantId", "getProcessInfo", "getReferer", "getToken", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJSignInfoReqBean {
    private final String callerApp;
    private final String callerRiskInfo;
    private final boolean invokeFromInner;
    private final String merchantId;
    private final String processInfo;
    private final String referer;
    private final String token;

    public final String getCallerApp() {
        return this.callerApp;
    }

    public final String getCallerRiskInfo() {
        return this.callerRiskInfo;
    }

    public final boolean getInvokeFromInner() {
        return this.invokeFromInner;
    }

    public final String getMerchantId() {
        return this.merchantId;
    }

    public final String getProcessInfo() {
        return this.processInfo;
    }

    public final String getReferer() {
        return this.referer;
    }

    public final String getToken() {
        return this.token;
    }

    public CJSignInfoReqBean(String r100, String r101, boolean r102, String r103, String r104, String r105, String r106) {
        this.token = r100;
        this.merchantId = r101;
        this.invokeFromInner = r102;
        this.callerApp = r103;
        this.processInfo = r104;
        this.referer = r105;
        this.callerRiskInfo = r106;
    }
}
