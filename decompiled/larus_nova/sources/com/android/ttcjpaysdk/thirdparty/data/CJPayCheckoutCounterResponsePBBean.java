package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/CJPayCheckoutCounterResponsePBBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "response", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayCheckoutCounterResponseBean;", "getResponse", "()Lcom/android/ttcjpaysdk/thirdparty/data/CJPayCheckoutCounterResponseBean;", "setResponse", "(Lcom/android/ttcjpaysdk/thirdparty/data/CJPayCheckoutCounterResponseBean;)V", "sign", "", "getSign", "()Ljava/lang/String;", "setSign", "(Ljava/lang/String;)V", "sign_type", "getSign_type", "setSign_type", "version", "getVersion", "setVersion", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayCheckoutCounterResponsePBBean implements CJPayObject {
    private CJPayCheckoutCounterResponseBean response;
    private String sign;
    private String sign_type;
    private String version;

    public CJPayCheckoutCounterResponsePBBean() {
        this.sign = "";
        this.sign_type = "";
        this.version = "";
    }

    public final CJPayCheckoutCounterResponseBean getResponse() {
        return this.response;
    }

    public final String getSign() {
        return this.sign;
    }

    public final String getSign_type() {
        return this.sign_type;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setResponse(CJPayCheckoutCounterResponseBean r100) {
        this.response = r100;
    }

    public final void setSign(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.sign = r100;
    }

    public final void setSign_type(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.sign_type = r100;
    }

    public final void setVersion(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.version = r100;
    }
}
