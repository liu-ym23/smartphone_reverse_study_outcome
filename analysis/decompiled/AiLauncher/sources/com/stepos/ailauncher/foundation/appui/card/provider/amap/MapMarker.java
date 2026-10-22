package com.stepos.ailauncher.foundation.appui.card.provider.amap;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0019\u0010\fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u001a\u0010\fR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u001b\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/A;", "", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/f;", "position", "", "label", "type", "color", "iconUrl", "<init>", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/f;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/f;", "getPosition", "()Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/f;", "Ljava/lang/String;", "getLabel", "getType", "getColor", "getIconUrl", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.amap.A, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class MapMarker {

    @SerializedName("color")
    private final String color;

    @SerializedName("iconUrl")
    private final String iconUrl;

    @SerializedName("label")
    private final String label;

    @SerializedName("position")
    private final LatLng position;

    @SerializedName("type")
    private final String type;

    public MapMarker() {
        this(null, null, null, null, null, 31, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MapMarker)) {
            return false;
        }
        MapMarker mapMarker = (MapMarker) other;
        return kotlin.jvm.internal.p.d(this.position, mapMarker.position) && kotlin.jvm.internal.p.d(this.label, mapMarker.label) && kotlin.jvm.internal.p.d(this.type, mapMarker.type) && kotlin.jvm.internal.p.d(this.color, mapMarker.color) && kotlin.jvm.internal.p.d(this.iconUrl, mapMarker.iconUrl);
    }

    public int hashCode() {
        LatLng latLng = this.position;
        int iHashCode = (latLng == null ? 0 : latLng.hashCode()) * 31;
        String str = this.label;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.type;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.color;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.iconUrl;
        return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "MapMarker(position=" + this.position + ", label=" + this.label + ", type=" + this.type + ", color=" + this.color + ", iconUrl=" + this.iconUrl + ")";
    }

    public MapMarker(LatLng latLng, String str, String str2, String str3, String str4) {
        this.position = latLng;
        this.label = str;
        this.type = str2;
        this.color = str3;
        this.iconUrl = str4;
    }

    public /* synthetic */ MapMarker(LatLng latLng, String str, String str2, String str3, String str4, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : latLng, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? null : str3, (i10 & 16) != 0 ? null : str4);
    }
}
