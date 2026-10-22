package com.bytedance.applet.aibridge.navigation;

import androidx.camera.video.AudioStats;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.JsonObject;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.platform.model.LocationResult;
import hq9.z2;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class g0 implements z2 {
    public g0() {
    }

    @Override // hq9.z2
    public final void a(LocationResult r100, GeoLocationInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "code");
        Intrinsics.checkNotNullParameter(r101, "location");
        JSONObject r102 = new JSONObject();
        r102.put("latitude", r101.getLatitude());
        r102.put("longitude", r101.getLongitude());
        r102.put("altitude", r101.getAltitude());
        r102.put(LocationMonitorConst.ACCURACY, r101.getRadius());
        r102.put("speed", r101.getSpeed());
        Float r103 = r101.getGpsDir();
        if (r103 == null) goto L5;
        double r104 = r103.floatValue();
    L6:
        r102.put("bearing", r104);
        r102.put("timestamp", r101.getGpsTime());
        int r105 = g.f191318a;
        Intrinsics.checkNotNullParameter(r102, "locationJson");
        g.a("flow.onLocationChange", h.a(r102));
        return;
    L5:
        r104 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L6
    }

    @Override // hq9.z2
    public final void onError(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "code");
        Intrinsics.checkNotNullParameter(r101, "msg");
        int r102 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.b("jsb_start_location", "location error: code=" + r100 + ", msg=" + r101);
        int r103 = g.f191318a;
        Intrinsics.checkNotNullParameter(r100, "code");
        Intrinsics.checkNotNullParameter(r101, "msg");
        JsonObject r104 = new JsonObject();
        r104.addProperty("errorCode", r100);
        r104.addProperty("message", r101);
        Unit r105 = Unit.INSTANCE;
        g.a("flow.onLocationError", r104);
    }
}
