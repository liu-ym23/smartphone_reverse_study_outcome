package com.stepos.ailauncher.foundation.appui.card.provider.amap;

import N5.CardAction;
import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.taskstore.provider.c;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001d\u0010\u0014R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b!\u0010\u0014R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010%\u001a\u0004\b&\u0010'R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010(\u001a\u0004\b)\u0010*R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010+\u001a\u0004\b,\u0010-¨\u0006."}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/H0;", "", "", "key", "label", "", x5.d.EXTRA_ENABLED, "originText", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/C;", "mapPreview", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/I0;", c.a.COL_SUMMARY, "", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/J0;", "waypoints", "LN5/f;", "action", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/C;Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/I0;Ljava/util/List;LN5/f;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "c", Const.INTENT_KEY_UMID, "Ljava/lang/Boolean;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/Boolean;", "e", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/C;", "getMapPreview", "()Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/C;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/I0;", "f", "()Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/I0;", "Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/util/List;", "LN5/f;", Const.INTENT_KEY_APIKEY, "()LN5/f;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.amap.H0, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class RouteMode {

    @SerializedName("action")
    private final CardAction action;

    @SerializedName(x5.d.EXTRA_ENABLED)
    private final Boolean enabled;

    @SerializedName("key")
    private final String key;

    @SerializedName("label")
    private final String label;

    @SerializedName("mapPreview")
    private final MapPreview mapPreview;

    @SerializedName("originText")
    private final String originText;

    @SerializedName(c.a.COL_SUMMARY)
    private final RouteSummary summary;

    @SerializedName("waypoints")
    private final List<RouteWaypoint> waypoints;

    public RouteMode() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    /* renamed from: a, reason: from getter */
    public final CardAction getAction() {
        return this.action;
    }

    /* renamed from: b, reason: from getter */
    public final Boolean getEnabled() {
        return this.enabled;
    }

    /* renamed from: c, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* renamed from: d, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* renamed from: e, reason: from getter */
    public final String getOriginText() {
        return this.originText;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RouteMode)) {
            return false;
        }
        RouteMode routeMode = (RouteMode) other;
        return kotlin.jvm.internal.p.d(this.key, routeMode.key) && kotlin.jvm.internal.p.d(this.label, routeMode.label) && kotlin.jvm.internal.p.d(this.enabled, routeMode.enabled) && kotlin.jvm.internal.p.d(this.originText, routeMode.originText) && kotlin.jvm.internal.p.d(this.mapPreview, routeMode.mapPreview) && kotlin.jvm.internal.p.d(this.summary, routeMode.summary) && kotlin.jvm.internal.p.d(this.waypoints, routeMode.waypoints) && kotlin.jvm.internal.p.d(this.action, routeMode.action);
    }

    /* renamed from: f, reason: from getter */
    public final RouteSummary getSummary() {
        return this.summary;
    }

    public final List<RouteWaypoint> g() {
        return this.waypoints;
    }

    public int hashCode() {
        String str = this.key;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.label;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.enabled;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str3 = this.originText;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        MapPreview mapPreview = this.mapPreview;
        int iHashCode5 = (iHashCode4 + (mapPreview == null ? 0 : mapPreview.hashCode())) * 31;
        RouteSummary routeSummary = this.summary;
        int iHashCode6 = (((iHashCode5 + (routeSummary == null ? 0 : routeSummary.hashCode())) * 31) + this.waypoints.hashCode()) * 31;
        CardAction cardAction = this.action;
        return iHashCode6 + (cardAction != null ? cardAction.hashCode() : 0);
    }

    public String toString() {
        return "RouteMode(key=" + this.key + ", label=" + this.label + ", enabled=" + this.enabled + ", originText=" + this.originText + ", mapPreview=" + this.mapPreview + ", summary=" + this.summary + ", waypoints=" + this.waypoints + ", action=" + this.action + ")";
    }

    public RouteMode(String str, String str2, Boolean bool, String str3, MapPreview mapPreview, RouteSummary routeSummary, List<RouteWaypoint> waypoints, CardAction cardAction) {
        kotlin.jvm.internal.p.i(waypoints, "waypoints");
        this.key = str;
        this.label = str2;
        this.enabled = bool;
        this.originText = str3;
        this.mapPreview = mapPreview;
        this.summary = routeSummary;
        this.waypoints = waypoints;
        this.action = cardAction;
    }

    public /* synthetic */ RouteMode(String str, String str2, Boolean bool, String str3, MapPreview mapPreview, RouteSummary routeSummary, List list, CardAction cardAction, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : bool, (i10 & 8) != 0 ? null : str3, (i10 & 16) != 0 ? null : mapPreview, (i10 & 32) != 0 ? null : routeSummary, (i10 & 64) != 0 ? C1173v.m() : list, (i10 & 128) != 0 ? null : cardAction);
    }
}
