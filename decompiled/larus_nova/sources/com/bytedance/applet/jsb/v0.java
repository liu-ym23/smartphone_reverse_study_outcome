package com.bytedance.applet.jsb;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.google.gson.JsonObject;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.platform.model.LocationResult;
import hq9.z2;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class v0 implements z2 {
    public v0() {
    }

    @Override // hq9.z2
    public final void a(LocationResult r110, GeoLocationInfo r111) {
        Intrinsics.checkNotNullParameter(r110, "code");
        Intrinsics.checkNotNullParameter(r111, "location");
        Pair[] r100 = new Pair[2];
        r100[0] = TuplesKt.to("code", 1);
        Pair[] r101 = new Pair[5];
        Boolean r102 = Boolean.TRUE;
        r101[0] = TuplesKt.to("enable", r102);
        r101[1] = TuplesKt.to("latitude", Double.valueOf(r111.getLatitude()));
        r101[2] = TuplesKt.to("longitude", Double.valueOf(r111.getLongitude()));
        r101[3] = TuplesKt.to(LocationMonitorConst.ACCURACY, Integer.valueOf(r111.getAccuracyLevel()));
        String r103 = r111.getCity();
        String r104 = "";
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        r101[4] = TuplesKt.to("city", r103);
        r100[1] = TuplesKt.to("data", MapsKt.mutableMapOf(r101));
        JSONObject r112 = new JSONObject(MapsKt.mapOf(r100));
        EventCenter.enqueueEvent(new Event("appletLocationChange", System.currentTimeMillis(), new f66.d(r112)));
        Lazy r105 = l3.d.f507201a;
        JsonObject r106 = new JsonObject();
        r106.addProperty("enable", r102);
        r106.addProperty("latitude", Double.valueOf(r111.getLatitude()));
        r106.addProperty("longitude", Double.valueOf(r111.getLongitude()));
        r106.addProperty(LocationMonitorConst.ACCURACY, Integer.valueOf(r111.getAccuracyLevel()));
        String r113 = r111.getCity();
        if (r113 == null) goto L9;
        r104 = r113;
    L9:
        r106.addProperty("city", r104);
        Unit r114 = Unit.INSTANCE;
        l3.d.c(new l3.a("appletLocationChange", r106, 4));
    }

    @Override // hq9.z2
    public final void onError(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "code");
        Intrinsics.checkNotNullParameter(r101, "msg");
        EventCenter.enqueueEvent(new Event("appletLocationChange", System.currentTimeMillis(), new f66.d(new JSONObject(MapsKt.mapOf(new Pair[]{TuplesKt.to("code", r100), TuplesKt.to("msg", r101)})))));
        Lazy r102 = l3.d.f507201a;
        JsonObject r103 = new JsonObject();
        r103.addProperty("code", r100);
        r103.addProperty("msg", r101);
        Unit r104 = Unit.INSTANCE;
        l3.d.c(new l3.a("appletLocationChange", r103, 4));
    }
}
