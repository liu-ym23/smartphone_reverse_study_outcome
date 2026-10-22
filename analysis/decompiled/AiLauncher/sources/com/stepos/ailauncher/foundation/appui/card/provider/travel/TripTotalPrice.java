package com.stepos.ailauncher.foundation.appui.card.provider.travel;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/C;", "", "", "amount", "", "currency", "<init>", "(Ljava/lang/Double;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Double;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/Double;", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.travel.C, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class TripTotalPrice {
    private final Double amount;
    private final String currency;

    /* JADX WARN: Multi-variable type inference failed */
    public TripTotalPrice() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: a, reason: from getter */
    public final Double getAmount() {
        return this.amount;
    }

    /* renamed from: b, reason: from getter */
    public final String getCurrency() {
        return this.currency;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TripTotalPrice)) {
            return false;
        }
        TripTotalPrice tripTotalPrice = (TripTotalPrice) other;
        return kotlin.jvm.internal.p.d(this.amount, tripTotalPrice.amount) && kotlin.jvm.internal.p.d(this.currency, tripTotalPrice.currency);
    }

    public int hashCode() {
        Double d10 = this.amount;
        int iHashCode = (d10 == null ? 0 : d10.hashCode()) * 31;
        String str = this.currency;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "TripTotalPrice(amount=" + this.amount + ", currency=" + this.currency + ")";
    }

    public TripTotalPrice(Double d10, String str) {
        this.amount = d10;
        this.currency = str;
    }

    public /* synthetic */ TripTotalPrice(Double d10, String str, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : d10, (i10 & 2) != 0 ? null : str);
    }
}
