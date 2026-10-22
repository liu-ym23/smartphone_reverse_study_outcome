package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0080\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/Q;", "", "", "prepayAmount", "actualPay", "", "currency", "<init>", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Double;", "c", "()Ljava/lang/Double;", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.didi.Q, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class DidiPaymentInfo {

    @SerializedName("actualPay")
    private final Double actualPay;

    @SerializedName("currency")
    private final String currency;

    @SerializedName("prepayAmount")
    private final Double prepayAmount;

    public DidiPaymentInfo() {
        this(null, null, null, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final Double getActualPay() {
        return this.actualPay;
    }

    /* renamed from: b, reason: from getter */
    public final String getCurrency() {
        return this.currency;
    }

    /* renamed from: c, reason: from getter */
    public final Double getPrepayAmount() {
        return this.prepayAmount;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DidiPaymentInfo)) {
            return false;
        }
        DidiPaymentInfo didiPaymentInfo = (DidiPaymentInfo) other;
        return kotlin.jvm.internal.p.d(this.prepayAmount, didiPaymentInfo.prepayAmount) && kotlin.jvm.internal.p.d(this.actualPay, didiPaymentInfo.actualPay) && kotlin.jvm.internal.p.d(this.currency, didiPaymentInfo.currency);
    }

    public int hashCode() {
        Double d10 = this.prepayAmount;
        int iHashCode = (d10 == null ? 0 : d10.hashCode()) * 31;
        Double d11 = this.actualPay;
        int iHashCode2 = (iHashCode + (d11 == null ? 0 : d11.hashCode())) * 31;
        String str = this.currency;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "DidiPaymentInfo(prepayAmount=" + this.prepayAmount + ", actualPay=" + this.actualPay + ", currency=" + this.currency + ")";
    }

    public DidiPaymentInfo(Double d10, Double d11, String str) {
        this.prepayAmount = d10;
        this.actualPay = d11;
        this.currency = str;
    }

    public /* synthetic */ DidiPaymentInfo(Double d10, Double d11, String str, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : d10, (i10 & 2) != 0 ? null : d11, (i10 & 4) != 0 ? null : str);
    }
}
