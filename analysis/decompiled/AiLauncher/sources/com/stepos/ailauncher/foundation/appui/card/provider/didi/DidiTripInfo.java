package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0080\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u000bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0019\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/b0;", "", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/L;", "pickup", "dropoff", "", "durationText", "productName", "<init>", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/L;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/L;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/L;", "c", "()Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/L;", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.didi.b0, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class DidiTripInfo {

    @SerializedName("dropoff")
    private final DidiLocation dropoff;

    @SerializedName("durationText")
    private final String durationText;

    @SerializedName("pickup")
    private final DidiLocation pickup;

    @SerializedName("productName")
    private final String productName;

    public DidiTripInfo() {
        this(null, null, null, null, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final DidiLocation getDropoff() {
        return this.dropoff;
    }

    /* renamed from: b, reason: from getter */
    public final String getDurationText() {
        return this.durationText;
    }

    /* renamed from: c, reason: from getter */
    public final DidiLocation getPickup() {
        return this.pickup;
    }

    /* renamed from: d, reason: from getter */
    public final String getProductName() {
        return this.productName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DidiTripInfo)) {
            return false;
        }
        DidiTripInfo didiTripInfo = (DidiTripInfo) other;
        return kotlin.jvm.internal.p.d(this.pickup, didiTripInfo.pickup) && kotlin.jvm.internal.p.d(this.dropoff, didiTripInfo.dropoff) && kotlin.jvm.internal.p.d(this.durationText, didiTripInfo.durationText) && kotlin.jvm.internal.p.d(this.productName, didiTripInfo.productName);
    }

    public int hashCode() {
        DidiLocation didiLocation = this.pickup;
        int iHashCode = (didiLocation == null ? 0 : didiLocation.hashCode()) * 31;
        DidiLocation didiLocation2 = this.dropoff;
        int iHashCode2 = (iHashCode + (didiLocation2 == null ? 0 : didiLocation2.hashCode())) * 31;
        String str = this.durationText;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.productName;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "DidiTripInfo(pickup=" + this.pickup + ", dropoff=" + this.dropoff + ", durationText=" + this.durationText + ", productName=" + this.productName + ")";
    }

    public DidiTripInfo(DidiLocation didiLocation, DidiLocation didiLocation2, String str, String str2) {
        this.pickup = didiLocation;
        this.dropoff = didiLocation2;
        this.durationText = str;
        this.productName = str2;
    }

    public /* synthetic */ DidiTripInfo(DidiLocation didiLocation, DidiLocation didiLocation2, String str, String str2, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : didiLocation, (i10 & 2) != 0 ? null : didiLocation2, (i10 & 4) != 0 ? null : str, (i10 & 8) != 0 ? null : str2);
    }
}
