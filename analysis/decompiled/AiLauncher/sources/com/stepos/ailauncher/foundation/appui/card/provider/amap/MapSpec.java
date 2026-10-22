package com.stepos.ailauncher.foundation.appui.card.provider.amap;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/K;", "", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/f;", "center", "", "zoom", "", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/A;", "markers", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/D;", M5.a.CARD_TYPE_ROUTE, "<init>", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/f;Ljava/lang/Float;Ljava/util/List;Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/D;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/f;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/f;", "Ljava/lang/Float;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/Float;", "Ljava/util/List;", "getMarkers", "()Ljava/util/List;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/D;", "getRoute", "()Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/D;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.amap.K, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class MapSpec {

    @SerializedName("center")
    private final LatLng center;

    @SerializedName("markers")
    private final List<MapMarker> markers;

    @SerializedName(M5.a.CARD_TYPE_ROUTE)
    private final MapRoute route;

    @SerializedName("zoom")
    private final Float zoom;

    public MapSpec() {
        this(null, null, null, null, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final LatLng getCenter() {
        return this.center;
    }

    /* renamed from: b, reason: from getter */
    public final Float getZoom() {
        return this.zoom;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MapSpec)) {
            return false;
        }
        MapSpec mapSpec = (MapSpec) other;
        return kotlin.jvm.internal.p.d(this.center, mapSpec.center) && kotlin.jvm.internal.p.d(this.zoom, mapSpec.zoom) && kotlin.jvm.internal.p.d(this.markers, mapSpec.markers) && kotlin.jvm.internal.p.d(this.route, mapSpec.route);
    }

    public int hashCode() {
        LatLng latLng = this.center;
        int iHashCode = (latLng == null ? 0 : latLng.hashCode()) * 31;
        Float f10 = this.zoom;
        int iHashCode2 = (((iHashCode + (f10 == null ? 0 : f10.hashCode())) * 31) + this.markers.hashCode()) * 31;
        MapRoute mapRoute = this.route;
        return iHashCode2 + (mapRoute != null ? mapRoute.hashCode() : 0);
    }

    public String toString() {
        return "MapSpec(center=" + this.center + ", zoom=" + this.zoom + ", markers=" + this.markers + ", route=" + this.route + ")";
    }

    public MapSpec(LatLng latLng, Float f10, List<MapMarker> markers, MapRoute mapRoute) {
        kotlin.jvm.internal.p.i(markers, "markers");
        this.center = latLng;
        this.zoom = f10;
        this.markers = markers;
        this.route = mapRoute;
    }

    public /* synthetic */ MapSpec(LatLng latLng, Float f10, List list, MapRoute mapRoute, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : latLng, (i10 & 2) != 0 ? null : f10, (i10 & 4) != 0 ? C1173v.m() : list, (i10 & 8) != 0 ? null : mapRoute);
    }
}
