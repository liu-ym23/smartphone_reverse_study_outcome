package com.stepos.ailauncher.foundation.appui.card.provider.travel;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\nR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0017\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/i;", "", "", "amount", "", "currency", "priceUnit", "<init>", "(Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Double;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/Double;", "Ljava/lang/String;", "getCurrency", Const.INTENT_KEY_PKGNAME, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.travel.i, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class HotelPrice {
    private final Double amount;
    private final String currency;
    private final String priceUnit;

    public HotelPrice() {
        this(null, null, null, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final Double getAmount() {
        return this.amount;
    }

    /* renamed from: b, reason: from getter */
    public final String getPriceUnit() {
        return this.priceUnit;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HotelPrice)) {
            return false;
        }
        HotelPrice hotelPrice = (HotelPrice) other;
        return kotlin.jvm.internal.p.d(this.amount, hotelPrice.amount) && kotlin.jvm.internal.p.d(this.currency, hotelPrice.currency) && kotlin.jvm.internal.p.d(this.priceUnit, hotelPrice.priceUnit);
    }

    public int hashCode() {
        Double d10 = this.amount;
        int iHashCode = (d10 == null ? 0 : d10.hashCode()) * 31;
        String str = this.currency;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.priceUnit;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "HotelPrice(amount=" + this.amount + ", currency=" + this.currency + ", priceUnit=" + this.priceUnit + ")";
    }

    public HotelPrice(Double d10, String str, String str2) {
        this.amount = d10;
        this.currency = str;
        this.priceUnit = str2;
    }

    public /* synthetic */ HotelPrice(Double d10, String str, String str2, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : d10, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : str2);
    }
}
