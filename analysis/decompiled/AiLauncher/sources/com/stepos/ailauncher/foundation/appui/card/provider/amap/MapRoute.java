package com.stepos.ailauncher.foundation.appui.card.provider.amap;

import Z8.C1173v;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u000bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0018\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/D;", "", "", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/f;", "points", "", "polyline", "color", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getPoints", "()Ljava/util/List;", "Ljava/lang/String;", "getPolyline", "getColor", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.amap.D, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class MapRoute {

    @SerializedName("color")
    private final String color;

    @SerializedName("points")
    private final List<LatLng> points;

    @SerializedName("polyline")
    private final String polyline;

    public MapRoute() {
        this(null, null, null, 7, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MapRoute)) {
            return false;
        }
        MapRoute mapRoute = (MapRoute) other;
        return kotlin.jvm.internal.p.d(this.points, mapRoute.points) && kotlin.jvm.internal.p.d(this.polyline, mapRoute.polyline) && kotlin.jvm.internal.p.d(this.color, mapRoute.color);
    }

    public int hashCode() {
        int iHashCode = this.points.hashCode() * 31;
        String str = this.polyline;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.color;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "MapRoute(points=" + this.points + ", polyline=" + this.polyline + ", color=" + this.color + ")";
    }

    public MapRoute(List<LatLng> points, String str, String str2) {
        kotlin.jvm.internal.p.i(points, "points");
        this.points = points;
        this.polyline = str;
        this.color = str2;
    }

    public /* synthetic */ MapRoute(List list, String str, String str2, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? C1173v.m() : list, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : str2);
    }
}
