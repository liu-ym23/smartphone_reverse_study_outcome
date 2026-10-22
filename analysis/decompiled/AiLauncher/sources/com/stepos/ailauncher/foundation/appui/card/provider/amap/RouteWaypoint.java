package com.stepos.ailauncher.foundation.appui.card.provider.amap;

import N5.CardAction;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u001a\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u001e\u0010\u0010R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u001f\u0010\u0010R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010#\u001a\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/J0;", "", "", "type", "name", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/f;", "location", "timeText", "segmentText", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/b;", "badge", "LN5/f;", "action", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/f;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/b;LN5/f;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_UMID, "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/f;", "c", "()Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/f;", "f", "e", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/b;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/b;", "LN5/f;", Const.INTENT_KEY_APIKEY, "()LN5/f;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.amap.J0, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class RouteWaypoint {

    @SerializedName("action")
    private final CardAction action;

    @SerializedName("badge")
    private final CardTag badge;

    @SerializedName("location")
    private final LatLng location;

    @SerializedName("name")
    private final String name;

    @SerializedName("segmentText")
    private final String segmentText;

    @SerializedName("timeText")
    private final String timeText;

    @SerializedName("type")
    private final String type;

    public RouteWaypoint() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    /* renamed from: a, reason: from getter */
    public final CardAction getAction() {
        return this.action;
    }

    /* renamed from: b, reason: from getter */
    public final CardTag getBadge() {
        return this.badge;
    }

    /* renamed from: c, reason: from getter */
    public final LatLng getLocation() {
        return this.location;
    }

    /* renamed from: d, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: e, reason: from getter */
    public final String getSegmentText() {
        return this.segmentText;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RouteWaypoint)) {
            return false;
        }
        RouteWaypoint routeWaypoint = (RouteWaypoint) other;
        return kotlin.jvm.internal.p.d(this.type, routeWaypoint.type) && kotlin.jvm.internal.p.d(this.name, routeWaypoint.name) && kotlin.jvm.internal.p.d(this.location, routeWaypoint.location) && kotlin.jvm.internal.p.d(this.timeText, routeWaypoint.timeText) && kotlin.jvm.internal.p.d(this.segmentText, routeWaypoint.segmentText) && kotlin.jvm.internal.p.d(this.badge, routeWaypoint.badge) && kotlin.jvm.internal.p.d(this.action, routeWaypoint.action);
    }

    /* renamed from: f, reason: from getter */
    public final String getTimeText() {
        return this.timeText;
    }

    /* renamed from: g, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.type;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        LatLng latLng = this.location;
        int iHashCode3 = (iHashCode2 + (latLng == null ? 0 : latLng.hashCode())) * 31;
        String str3 = this.timeText;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.segmentText;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        CardTag cardTag = this.badge;
        int iHashCode6 = (iHashCode5 + (cardTag == null ? 0 : cardTag.hashCode())) * 31;
        CardAction cardAction = this.action;
        return iHashCode6 + (cardAction != null ? cardAction.hashCode() : 0);
    }

    public String toString() {
        return "RouteWaypoint(type=" + this.type + ", name=" + this.name + ", location=" + this.location + ", timeText=" + this.timeText + ", segmentText=" + this.segmentText + ", badge=" + this.badge + ", action=" + this.action + ")";
    }

    public RouteWaypoint(String str, String str2, LatLng latLng, String str3, String str4, CardTag cardTag, CardAction cardAction) {
        this.type = str;
        this.name = str2;
        this.location = latLng;
        this.timeText = str3;
        this.segmentText = str4;
        this.badge = cardTag;
        this.action = cardAction;
    }

    public /* synthetic */ RouteWaypoint(String str, String str2, LatLng latLng, String str3, String str4, CardTag cardTag, CardAction cardAction, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : latLng, (i10 & 8) != 0 ? null : str3, (i10 & 16) != 0 ? null : str4, (i10 & 32) != 0 ? null : cardTag, (i10 & 64) != 0 ? null : cardAction);
    }
}
