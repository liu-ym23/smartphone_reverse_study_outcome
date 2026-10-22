package com.stepos.ailauncher.foundation.appui.card.provider.amap;

import N5.CardAction;
import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2.FastDoubleMath;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u0015R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001d\u001a\u0004\b\u001f\u0010\u0015R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b#\u0010\u0015R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b$\u0010\u0015R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b%\u0010\u0015R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001d\u001a\u0004\b&\u0010\u0015R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010'\u001a\u0004\b(\u0010)R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010*\u001a\u0004\b+\u0010,R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010-\u001a\u0004\b.\u0010/¨\u00060"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/L;", "", "", "poiId", "name", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/f;", "location", "markerLabel", "markerColor", "rating", "distanceText", "", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/b;", "tags", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/N;", "detail", "LN5/f;", "action", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/f;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/N;LN5/f;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "f", "e", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/f;", Const.INTENT_KEY_UMID, "()Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/f;", "getMarkerLabel", "getMarkerColor", Const.INTENT_KEY_BACKGROUND_COMMAND, "c", "Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Ljava/util/List;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/N;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/N;", "LN5/f;", Const.INTENT_KEY_APIKEY, "()LN5/f;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.amap.L, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class PoiBrief {

    @SerializedName("action")
    private final CardAction action;

    @SerializedName("detail")
    private final PoiDetailCardItem detail;

    @SerializedName("distanceText")
    private final String distanceText;

    @SerializedName("location")
    private final LatLng location;

    @SerializedName("markerColor")
    private final String markerColor;

    @SerializedName("markerLabel")
    private final String markerLabel;

    @SerializedName("name")
    private final String name;

    @SerializedName("poiId")
    private final String poiId;

    @SerializedName("rating")
    private final String rating;

    @SerializedName("tags")
    private final List<CardTag> tags;

    public PoiBrief() {
        this(null, null, null, null, null, null, null, null, null, null, FastDoubleMath.DOUBLE_EXPONENT_BIAS, null);
    }

    /* renamed from: a, reason: from getter */
    public final CardAction getAction() {
        return this.action;
    }

    /* renamed from: b, reason: from getter */
    public final PoiDetailCardItem getDetail() {
        return this.detail;
    }

    /* renamed from: c, reason: from getter */
    public final String getDistanceText() {
        return this.distanceText;
    }

    /* renamed from: d, reason: from getter */
    public final LatLng getLocation() {
        return this.location;
    }

    /* renamed from: e, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PoiBrief)) {
            return false;
        }
        PoiBrief poiBrief = (PoiBrief) other;
        return kotlin.jvm.internal.p.d(this.poiId, poiBrief.poiId) && kotlin.jvm.internal.p.d(this.name, poiBrief.name) && kotlin.jvm.internal.p.d(this.location, poiBrief.location) && kotlin.jvm.internal.p.d(this.markerLabel, poiBrief.markerLabel) && kotlin.jvm.internal.p.d(this.markerColor, poiBrief.markerColor) && kotlin.jvm.internal.p.d(this.rating, poiBrief.rating) && kotlin.jvm.internal.p.d(this.distanceText, poiBrief.distanceText) && kotlin.jvm.internal.p.d(this.tags, poiBrief.tags) && kotlin.jvm.internal.p.d(this.detail, poiBrief.detail) && kotlin.jvm.internal.p.d(this.action, poiBrief.action);
    }

    /* renamed from: f, reason: from getter */
    public final String getPoiId() {
        return this.poiId;
    }

    /* renamed from: g, reason: from getter */
    public final String getRating() {
        return this.rating;
    }

    public final List<CardTag> h() {
        return this.tags;
    }

    public int hashCode() {
        String str = this.poiId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        LatLng latLng = this.location;
        int iHashCode3 = (iHashCode2 + (latLng == null ? 0 : latLng.hashCode())) * 31;
        String str3 = this.markerLabel;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.markerColor;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.rating;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.distanceText;
        int iHashCode7 = (((iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31) + this.tags.hashCode()) * 31;
        PoiDetailCardItem poiDetailCardItem = this.detail;
        int iHashCode8 = (iHashCode7 + (poiDetailCardItem == null ? 0 : poiDetailCardItem.hashCode())) * 31;
        CardAction cardAction = this.action;
        return iHashCode8 + (cardAction != null ? cardAction.hashCode() : 0);
    }

    public String toString() {
        return "PoiBrief(poiId=" + this.poiId + ", name=" + this.name + ", location=" + this.location + ", markerLabel=" + this.markerLabel + ", markerColor=" + this.markerColor + ", rating=" + this.rating + ", distanceText=" + this.distanceText + ", tags=" + this.tags + ", detail=" + this.detail + ", action=" + this.action + ")";
    }

    public PoiBrief(String str, String str2, LatLng latLng, String str3, String str4, String str5, String str6, List<CardTag> tags, PoiDetailCardItem poiDetailCardItem, CardAction cardAction) {
        kotlin.jvm.internal.p.i(tags, "tags");
        this.poiId = str;
        this.name = str2;
        this.location = latLng;
        this.markerLabel = str3;
        this.markerColor = str4;
        this.rating = str5;
        this.distanceText = str6;
        this.tags = tags;
        this.detail = poiDetailCardItem;
        this.action = cardAction;
    }

    public /* synthetic */ PoiBrief(String str, String str2, LatLng latLng, String str3, String str4, String str5, String str6, List list, PoiDetailCardItem poiDetailCardItem, CardAction cardAction, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : latLng, (i10 & 8) != 0 ? null : str3, (i10 & 16) != 0 ? null : str4, (i10 & 32) != 0 ? null : str5, (i10 & 64) != 0 ? null : str6, (i10 & 128) != 0 ? C1173v.m() : list, (i10 & 256) != 0 ? null : poiDetailCardItem, (i10 & 512) != 0 ? null : cardAction);
    }
}
