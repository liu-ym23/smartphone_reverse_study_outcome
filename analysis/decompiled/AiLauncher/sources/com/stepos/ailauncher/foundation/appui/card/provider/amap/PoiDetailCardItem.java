package com.stepos.ailauncher.foundation.appui.card.provider.amap;

import N5.CardAction;
import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001BË\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010\u001aR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\"\u001a\u0004\b$\u0010\u001aR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010(\u001a\u0004\b)\u0010*R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010+\u001a\u0004\b,\u0010-R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\"\u001a\u0004\b.\u0010\u001aR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\"\u001a\u0004\b/\u0010\u001aR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\"\u001a\u0004\b0\u0010\u001aR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\"\u001a\u0004\b1\u0010\u001aR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\"\u001a\u0004\b2\u0010\u001aR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b3\u0010\u001aR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b4\u0010\u001aR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b5\u0010\u001aR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b6\u0010\u001aR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\"\u001a\u0004\b7\u0010\u001aR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u00108\u001a\u0004\b9\u0010:¨\u0006;"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/N;", "", "", "itemId", "poiId", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/f;", "location", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/C;", "mapPreview", "", "gallery", "name", "rating", "reviewCountText", "distanceText", "statusText", "businessHoursText", "addressText", "priceText", "tipText", "description", "LN5/f;", "action", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/f;Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/C;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;LN5/f;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_COMMAND, "k", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/f;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/f;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/C;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/C;", "Ljava/util/List;", "f", "()Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "m", "n", "e", "o", "c", Const.INTENT_KEY_PKGNAME, "l", "p", Const.INTENT_KEY_UMID, "LN5/f;", Const.INTENT_KEY_APIKEY, "()LN5/f;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.amap.N, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class PoiDetailCardItem {

    @SerializedName("action")
    private final CardAction action;

    @SerializedName(Const.JSON_KEY_ADDRESS)
    private final String addressText;

    @SerializedName("businessHoursText")
    private final String businessHoursText;

    @SerializedName("description")
    private final String description;

    @SerializedName("distanceText")
    private final String distanceText;

    @SerializedName("gallery")
    @JsonAdapter(C3259e.class)
    private final List<String> gallery;

    @SerializedName("itemId")
    private final String itemId;

    @SerializedName("location")
    private final LatLng location;

    @SerializedName("mapPreview")
    private final MapPreview mapPreview;

    @SerializedName("name")
    private final String name;

    @SerializedName("poiId")
    private final String poiId;

    @SerializedName("priceText")
    private final String priceText;

    @SerializedName("rating")
    private final String rating;

    @SerializedName("reviewCountText")
    private final String reviewCountText;

    @SerializedName("statusText")
    private final String statusText;

    @SerializedName("tipText")
    private final String tipText;

    public PoiDetailCardItem() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null);
    }

    /* renamed from: a, reason: from getter */
    public final CardAction getAction() {
        return this.action;
    }

    /* renamed from: b, reason: from getter */
    public final String getAddressText() {
        return this.addressText;
    }

    /* renamed from: c, reason: from getter */
    public final String getBusinessHoursText() {
        return this.businessHoursText;
    }

    /* renamed from: d, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: e, reason: from getter */
    public final String getDistanceText() {
        return this.distanceText;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PoiDetailCardItem)) {
            return false;
        }
        PoiDetailCardItem poiDetailCardItem = (PoiDetailCardItem) other;
        return kotlin.jvm.internal.p.d(this.itemId, poiDetailCardItem.itemId) && kotlin.jvm.internal.p.d(this.poiId, poiDetailCardItem.poiId) && kotlin.jvm.internal.p.d(this.location, poiDetailCardItem.location) && kotlin.jvm.internal.p.d(this.mapPreview, poiDetailCardItem.mapPreview) && kotlin.jvm.internal.p.d(this.gallery, poiDetailCardItem.gallery) && kotlin.jvm.internal.p.d(this.name, poiDetailCardItem.name) && kotlin.jvm.internal.p.d(this.rating, poiDetailCardItem.rating) && kotlin.jvm.internal.p.d(this.reviewCountText, poiDetailCardItem.reviewCountText) && kotlin.jvm.internal.p.d(this.distanceText, poiDetailCardItem.distanceText) && kotlin.jvm.internal.p.d(this.statusText, poiDetailCardItem.statusText) && kotlin.jvm.internal.p.d(this.businessHoursText, poiDetailCardItem.businessHoursText) && kotlin.jvm.internal.p.d(this.addressText, poiDetailCardItem.addressText) && kotlin.jvm.internal.p.d(this.priceText, poiDetailCardItem.priceText) && kotlin.jvm.internal.p.d(this.tipText, poiDetailCardItem.tipText) && kotlin.jvm.internal.p.d(this.description, poiDetailCardItem.description) && kotlin.jvm.internal.p.d(this.action, poiDetailCardItem.action);
    }

    public final List<String> f() {
        return this.gallery;
    }

    /* renamed from: g, reason: from getter */
    public final String getItemId() {
        return this.itemId;
    }

    /* renamed from: h, reason: from getter */
    public final LatLng getLocation() {
        return this.location;
    }

    public int hashCode() {
        String str = this.itemId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.poiId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        LatLng latLng = this.location;
        int iHashCode3 = (iHashCode2 + (latLng == null ? 0 : latLng.hashCode())) * 31;
        MapPreview mapPreview = this.mapPreview;
        int iHashCode4 = (((iHashCode3 + (mapPreview == null ? 0 : mapPreview.hashCode())) * 31) + this.gallery.hashCode()) * 31;
        String str3 = this.name;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.rating;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.reviewCountText;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.distanceText;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.statusText;
        int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.businessHoursText;
        int iHashCode10 = (iHashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.addressText;
        int iHashCode11 = (iHashCode10 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.priceText;
        int iHashCode12 = (iHashCode11 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.tipText;
        int iHashCode13 = (iHashCode12 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.description;
        int iHashCode14 = (iHashCode13 + (str12 == null ? 0 : str12.hashCode())) * 31;
        CardAction cardAction = this.action;
        return iHashCode14 + (cardAction != null ? cardAction.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final MapPreview getMapPreview() {
        return this.mapPreview;
    }

    /* renamed from: j, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: k, reason: from getter */
    public final String getPoiId() {
        return this.poiId;
    }

    /* renamed from: l, reason: from getter */
    public final String getPriceText() {
        return this.priceText;
    }

    /* renamed from: m, reason: from getter */
    public final String getRating() {
        return this.rating;
    }

    /* renamed from: n, reason: from getter */
    public final String getReviewCountText() {
        return this.reviewCountText;
    }

    /* renamed from: o, reason: from getter */
    public final String getStatusText() {
        return this.statusText;
    }

    /* renamed from: p, reason: from getter */
    public final String getTipText() {
        return this.tipText;
    }

    public String toString() {
        return "PoiDetailCardItem(itemId=" + this.itemId + ", poiId=" + this.poiId + ", location=" + this.location + ", mapPreview=" + this.mapPreview + ", gallery=" + this.gallery + ", name=" + this.name + ", rating=" + this.rating + ", reviewCountText=" + this.reviewCountText + ", distanceText=" + this.distanceText + ", statusText=" + this.statusText + ", businessHoursText=" + this.businessHoursText + ", addressText=" + this.addressText + ", priceText=" + this.priceText + ", tipText=" + this.tipText + ", description=" + this.description + ", action=" + this.action + ")";
    }

    public PoiDetailCardItem(String str, String str2, LatLng latLng, MapPreview mapPreview, List<String> gallery, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, CardAction cardAction) {
        kotlin.jvm.internal.p.i(gallery, "gallery");
        this.itemId = str;
        this.poiId = str2;
        this.location = latLng;
        this.mapPreview = mapPreview;
        this.gallery = gallery;
        this.name = str3;
        this.rating = str4;
        this.reviewCountText = str5;
        this.distanceText = str6;
        this.statusText = str7;
        this.businessHoursText = str8;
        this.addressText = str9;
        this.priceText = str10;
        this.tipText = str11;
        this.description = str12;
        this.action = cardAction;
    }

    public /* synthetic */ PoiDetailCardItem(String str, String str2, LatLng latLng, MapPreview mapPreview, List list, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, CardAction cardAction, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : latLng, (i10 & 8) != 0 ? null : mapPreview, (i10 & 16) != 0 ? C1173v.m() : list, (i10 & 32) != 0 ? null : str3, (i10 & 64) != 0 ? null : str4, (i10 & 128) != 0 ? null : str5, (i10 & 256) != 0 ? null : str6, (i10 & 512) != 0 ? null : str7, (i10 & 1024) != 0 ? null : str8, (i10 & 2048) != 0 ? null : str9, (i10 & 4096) != 0 ? null : str10, (i10 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? null : str11, (i10 & 16384) != 0 ? null : str12, (i10 & 32768) != 0 ? null : cardAction);
    }
}
