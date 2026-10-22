package com.stepos.ailauncher.amap.route;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0014\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/stepos/ailauncher/amap/route/x;", "", "", Const.JSON_KEY_LAT, "lng", "<init>", "(DD)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "D", Const.INTENT_KEY_APIKEY, "()D", Const.INTENT_KEY_PKGNAME, "amap_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.amap.route.x, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class GeoPoint {
    private final double lat;
    private final double lng;

    public GeoPoint(double d10, double d11) {
        this.lat = d10;
        this.lng = d11;
    }

    /* renamed from: a, reason: from getter */
    public final double getLat() {
        return this.lat;
    }

    /* renamed from: b, reason: from getter */
    public final double getLng() {
        return this.lng;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GeoPoint)) {
            return false;
        }
        GeoPoint geoPoint = (GeoPoint) other;
        return Double.compare(this.lat, geoPoint.lat) == 0 && Double.compare(this.lng, geoPoint.lng) == 0;
    }

    public int hashCode() {
        return (Double.hashCode(this.lat) * 31) + Double.hashCode(this.lng);
    }

    public String toString() {
        return "GeoPoint(lat=" + this.lat + ", lng=" + this.lng + ")";
    }
}
