package com.bytedance.android.livesdk.announce;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.appointment.RedPacket")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/announce/RedPacket;", "", "()V", "amount", "", "getAmount", "()Ljava/lang/Long;", "setAmount", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "currency", "", "getCurrency", "()Ljava/lang/String;", "setCurrency", "(Ljava/lang/String;)V", "orderNo", EventConstant.Key.RETAIN_PROMPT, "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RedPacket implements h {

    @SerializedName("amount")
    protected Long amount;

    @SerializedName("currency")
    protected String currency;

    @SerializedName("orderNo")
    public String orderNo;

    @SerializedName(EventConstant.Key.RETAIN_PROMPT)
    public String prompt;

    public RedPacket() {
    }

    public final Long getAmount() {
        return this.amount;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public RedPacket(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.orderNo = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.amount = Long.valueOf(r100.j());
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.currency = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.prompt = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }

    public final void setAmount(Long r100) {
        this.amount = r100;
    }

    public final void setCurrency(String r100) {
        this.currency = r100;
    }
}
