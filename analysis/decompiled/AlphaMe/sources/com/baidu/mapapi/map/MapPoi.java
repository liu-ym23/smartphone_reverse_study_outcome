package com.baidu.mapapi.map;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.map.MapBundleKey;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class MapPoi {

    /* renamed from: a, reason: collision with root package name */
    String f6510a;

    /* renamed from: b, reason: collision with root package name */
    LatLng f6511b;

    /* renamed from: c, reason: collision with root package name */
    String f6512c;

    /* renamed from: d, reason: collision with root package name */
    TrafficUGCType f6513d = TrafficUGCType.NoTrafficUGC;

    public enum TrafficUGCType {
        NoTrafficUGC,
        TrafficConstruction,
        TrafficJam,
        TrafficBlocking,
        TrafficEmergency
    }

    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString(MapBundleKey.MapObjKey.OBJ_TEXT);
        this.f6510a = strOptString;
        if (strOptString != null && !strOptString.equals("")) {
            this.f6510a = this.f6510a.replaceAll("\\\\", "").replaceAll("/?[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "").replaceAll("[(/>)<]", "");
        }
        this.f6511b = CoordUtil.decodeNodeLocation(jSONObject.optString(MapBundleKey.MapObjKey.OBJ_GEO));
        this.f6512c = jSONObject.optString("ud");
        int i4 = jSONObject.getInt(MapBundleKey.MapObjKey.OBJ_STATISTIC_VALUE);
        if (i4 == 0) {
            this.f6513d = TrafficUGCType.TrafficConstruction;
            return;
        }
        if (i4 == 2040) {
            this.f6513d = TrafficUGCType.TrafficJam;
            return;
        }
        if (i4 == 2041) {
            this.f6513d = TrafficUGCType.TrafficBlocking;
        } else if (i4 == 2042) {
            this.f6513d = TrafficUGCType.TrafficEmergency;
        } else {
            this.f6513d = TrafficUGCType.NoTrafficUGC;
        }
    }

    public String getName() {
        return this.f6510a;
    }

    public LatLng getPosition() {
        return this.f6511b;
    }

    public TrafficUGCType getTrafficUGCType() {
        return this.f6513d;
    }

    public String getUid() {
        return this.f6512c;
    }
}
