package com.bytedance.android.live.wallet.model;

import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/wallet/model/d;", "Lcom/bytedance/android/live/recharge/model/c;", "", "mOrderId", "Ljava/lang/String;", "getMOrderId", "()Ljava/lang/String;", "setMOrderId", "(Ljava/lang/String;)V", "mParams", "getMParams", "setMParams", "mPayType", "getMPayType", "setMPayType", "message", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setMessage", "prompts", "d", "setPrompts", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class d implements com.bytedance.android.live.recharge.model.c, vh7.h {

    @SerializedName("order_id")
    protected String mOrderId;

    @SerializedName("params")
    protected String mParams;

    @SerializedName("pay_type")
    protected String mPayType;

    @IgnoreProtoFieldCheck
    @SerializedName("message")
    private String message;

    @IgnoreProtoFieldCheck
    @SerializedName("prompts")
    private String prompts;

    public d() {
    }

    public d(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.mOrderId = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.mParams = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.mPayType = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }

    public final String toString() {
        return "CJOrderInfo{orderId='" + this.mOrderId + "', params='" + this.mParams + "', payType='" + this.mPayType + "', message='" + this.message + "', prompts='" + this.prompts + "'}";
    }

    public final String a() {
        return this.message;
    }

    public final String b() {
        return this.mOrderId;
    }

    public final String c() {
        return this.mParams;
    }

    public final String d() {
        return this.prompts;
    }
}
