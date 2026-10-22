package com.stepos.ailauncher.foundation.appui.card.provider.amap;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0014\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/f;", "", "", Const.JSON_KEY_LAT, "lng", "<init>", "(Ljava/lang/Double;Ljava/lang/Double;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Double;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/Double;", Const.INTENT_KEY_PKGNAME, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.amap.f, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class LatLng {

    @SerializedName(Const.JSON_KEY_LAT)
    private final Double lat;

    @SerializedName("lng")
    private final Double lng;

    /* JADX WARN: Multi-variable type inference failed */
    public LatLng() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: a, reason: from getter */
    public final Double getLat() {
        return this.lat;
    }

    /* renamed from: b, reason: from getter */
    public final Double getLng() {
        return this.lng;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LatLng)) {
            return false;
        }
        LatLng latLng = (LatLng) other;
        return kotlin.jvm.internal.p.d(this.lat, latLng.lat) && kotlin.jvm.internal.p.d(this.lng, latLng.lng);
    }

    public int hashCode() {
        Double d10 = this.lat;
        int iHashCode = (d10 == null ? 0 : d10.hashCode()) * 31;
        Double d11 = this.lng;
        return iHashCode + (d11 != null ? d11.hashCode() : 0);
    }

    public String toString() {
        return "LatLng(lat=" + this.lat + ", lng=" + this.lng + ")";
    }

    public LatLng(Double d10, Double d11) {
        this.lat = d10;
        this.lng = d11;
    }

    public /* synthetic */ LatLng(Double d10, Double d11, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : d10, (i10 & 2) != 0 ? null : d11);
    }
}
