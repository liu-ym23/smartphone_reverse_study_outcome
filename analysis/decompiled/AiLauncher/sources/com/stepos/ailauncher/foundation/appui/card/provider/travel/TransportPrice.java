package com.stepos.ailauncher.foundation.appui.card.provider.travel;

import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u000eR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001b\u0010\u000eR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001d\u0010\u000eR\u001f\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/t;", "", "", "amount", "", "currency", "discountText", "discountAmount", "lowStockHint", "", "tiers", "<init>", "(Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Double;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/Double;", "Ljava/lang/String;", "getCurrency", "getDiscountText", "getDiscountAmount", "getLowStockHint", "Ljava/util/List;", "getTiers", "()Ljava/util/List;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.travel.t, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class TransportPrice {
    private final Double amount;
    private final String currency;
    private final Double discountAmount;
    private final String discountText;
    private final String lowStockHint;
    private final List<Object> tiers;

    public TransportPrice() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* renamed from: a, reason: from getter */
    public final Double getAmount() {
        return this.amount;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TransportPrice)) {
            return false;
        }
        TransportPrice transportPrice = (TransportPrice) other;
        return kotlin.jvm.internal.p.d(this.amount, transportPrice.amount) && kotlin.jvm.internal.p.d(this.currency, transportPrice.currency) && kotlin.jvm.internal.p.d(this.discountText, transportPrice.discountText) && kotlin.jvm.internal.p.d(this.discountAmount, transportPrice.discountAmount) && kotlin.jvm.internal.p.d(this.lowStockHint, transportPrice.lowStockHint) && kotlin.jvm.internal.p.d(this.tiers, transportPrice.tiers);
    }

    public int hashCode() {
        Double d10 = this.amount;
        int iHashCode = (d10 == null ? 0 : d10.hashCode()) * 31;
        String str = this.currency;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.discountText;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Double d11 = this.discountAmount;
        int iHashCode4 = (iHashCode3 + (d11 == null ? 0 : d11.hashCode())) * 31;
        String str3 = this.lowStockHint;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<Object> list = this.tiers;
        return iHashCode5 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "TransportPrice(amount=" + this.amount + ", currency=" + this.currency + ", discountText=" + this.discountText + ", discountAmount=" + this.discountAmount + ", lowStockHint=" + this.lowStockHint + ", tiers=" + this.tiers + ")";
    }

    public TransportPrice(Double d10, String str, String str2, Double d11, String str3, List<Object> list) {
        this.amount = d10;
        this.currency = str;
        this.discountText = str2;
        this.discountAmount = d11;
        this.lowStockHint = str3;
        this.tiers = list;
    }

    public /* synthetic */ TransportPrice(Double d10, String str, String str2, Double d11, String str3, List list, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : d10, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? null : d11, (i10 & 16) != 0 ? null : str3, (i10 & 32) != 0 ? null : list);
    }
}
