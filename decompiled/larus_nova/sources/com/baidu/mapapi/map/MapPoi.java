package com.baidu.mapapi.map;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public final class MapPoi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f31025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    LatLng f31026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f31027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    TrafficUGCType f31028d;

    public static final enum TrafficUGCType extends Enum<TrafficUGCType> {
        public static final TrafficUGCType NoTrafficUGC = null;
        public static final TrafficUGCType TrafficBlocking = null;
        public static final TrafficUGCType TrafficConstruction = null;
        public static final TrafficUGCType TrafficEmergency = null;
        public static final TrafficUGCType TrafficJam = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ TrafficUGCType[] f31029a = null;

        static {
            TrafficUGCType r100 = new TrafficUGCType("NoTrafficUGC", 0);
            NoTrafficUGC = r100;
            TrafficUGCType r101 = new TrafficUGCType("TrafficConstruction", 1);
            TrafficConstruction = r101;
            TrafficUGCType r102 = new TrafficUGCType("TrafficJam", 2);
            TrafficJam = r102;
            TrafficUGCType r103 = new TrafficUGCType("TrafficBlocking", 3);
            TrafficBlocking = r103;
            TrafficUGCType r104 = new TrafficUGCType("TrafficEmergency", 4);
            TrafficEmergency = r104;
            f31029a = new TrafficUGCType[]{r100, r101, r102, r103, r104};
        }

        public static TrafficUGCType[] values() {
            return (TrafficUGCType[]) f31029a.clone();
        }

        public static TrafficUGCType valueOf(String r100) {
            return (TrafficUGCType) r27.a.a(TrafficUGCType.class, r100);
        }

        private TrafficUGCType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public MapPoi() {
        this.f31028d = TrafficUGCType.NoTrafficUGC;
    }

    public String getName() {
        return this.f31025a;
    }

    public LatLng getPosition() {
        return this.f31026b;
    }

    public TrafficUGCType getTrafficUGCType() {
        return this.f31028d;
    }

    public String getUid() {
        return this.f31027c;
    }

    public void a(JSONObject r100) throws JSONException {
        if (r100 != null) goto L4;
        return;
    L4:
        String r101 = r100.optString(MapBundleKey.MapObjKey.OBJ_TEXT);
        this.f31025a = r101;
        if (r101 != null) goto L7;
    L9:
        this.f31026b = CoordUtil.decodeNodeLocation(r100.optString(MapBundleKey.MapObjKey.OBJ_GEO));
        this.f31027c = r100.optString("ud");
        int r102 = JSONObjectProtectorUtils.getInt(r100, MapBundleKey.MapObjKey.OBJ_STATISTIC_VALUE);
        if (r102 != 0) goto L13;
        this.f31028d = TrafficUGCType.TrafficConstruction;
        return;
    L13:
        if (r102 != 2040) goto L16;
        this.f31028d = TrafficUGCType.TrafficJam;
        return;
    L16:
        if (r102 != 2041) goto L19;
        this.f31028d = TrafficUGCType.TrafficBlocking;
        return;
    L19:
        if (r102 != 2042) goto L21;
        this.f31028d = TrafficUGCType.TrafficEmergency;
        return;
    L21:
        this.f31028d = TrafficUGCType.NoTrafficUGC;
        return;
    L7:
        if (r101.equals("") == true) goto L9;
        this.f31025a = this.f31025a.replaceAll("\\\\", "").replaceAll("/?[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "").replaceAll("[(/>)<]", "");
        goto L9
    }
}
