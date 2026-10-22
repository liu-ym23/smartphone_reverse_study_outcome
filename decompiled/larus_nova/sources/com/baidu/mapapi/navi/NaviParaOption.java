package com.baidu.mapapi.navi;

import android.text.TextUtils;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class NaviParaOption {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    LatLng f31674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f31675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f31676c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    LatLng f31677d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f31678e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    String f31679f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    WayPoint f31680g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    NaviRoutePolicy f31681h;

    public static final enum NaviRoutePolicy extends Enum<NaviRoutePolicy> {
        public static final NaviRoutePolicy BLK = null;
        public static final NaviRoutePolicy DEFAULT = null;
        public static final NaviRoutePolicy DIS = null;
        public static final NaviRoutePolicy FEE = null;
        public static final NaviRoutePolicy HIGHWAY = null;
        public static final NaviRoutePolicy TIME = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ NaviRoutePolicy[] f31682a = null;

        static {
            NaviRoutePolicy r100 = new NaviRoutePolicy("BLK", 0);
            BLK = r100;
            NaviRoutePolicy r101 = new NaviRoutePolicy("TIME", 1);
            TIME = r101;
            NaviRoutePolicy r102 = new NaviRoutePolicy("DIS", 2);
            DIS = r102;
            NaviRoutePolicy r103 = new NaviRoutePolicy("FEE", 3);
            FEE = r103;
            NaviRoutePolicy r104 = new NaviRoutePolicy("HIGHWAY", 4);
            HIGHWAY = r104;
            NaviRoutePolicy r105 = new NaviRoutePolicy("DEFAULT", 5);
            DEFAULT = r105;
            f31682a = new NaviRoutePolicy[]{r100, r101, r102, r103, r104, r105};
        }

        public static NaviRoutePolicy[] values() {
            return (NaviRoutePolicy[]) f31682a.clone();
        }

        public static NaviRoutePolicy valueOf(String r100) {
            return (NaviRoutePolicy) r27.a.a(NaviRoutePolicy.class, r100);
        }

        private NaviRoutePolicy(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f31683a = null;

        static {
            int[] r100 = new int[NaviRoutePolicy.values().length];
            f31683a = r100;
            r100[NaviRoutePolicy.BLK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f31683a[NaviRoutePolicy.TIME.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f31683a[NaviRoutePolicy.DIS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f31683a[NaviRoutePolicy.FEE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f31683a[NaviRoutePolicy.HIGHWAY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f31683a[NaviRoutePolicy.DEFAULT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public String getNaviRoutePolicy() {
        int r100 = a.f31683a[this.f31681h.ordinal()];
        if (r100 != 1) goto L5;
        return "BLK";
    L5:
        if (r100 != 2) goto L7;
        return "TIME";
    L7:
        if (r100 != 3) goto L9;
        return "DIS";
    L9:
        if (r100 != 4) goto L11;
        return "FEE";
    L11:
        if (r100 == 5) goto L14;
        return "DEFAULT";
    L14:
        return "HIGHWAY";
    }

    public JSONArray getWayPoint() {
        WayPoint r100 = this.f31680g;
        JSONArray r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        List<WayPointInfo> r102 = r100.getViaPoints();
        if (r102 != null) goto L8;
    L34:
        return r101;
    L8:
        if (r102.size() == 0) goto L34;
        r101 = new JSONArray();
        int r103 = 0;
    L12:
        if (r103 >= r102.size()) goto L34;
        JSONObject r104 = new JSONObject();
        WayPointInfo r105 = (WayPointInfo) ListProtector.get(r102, r103);
        if (r105 == null) goto L33;
        if (TextUtils.isEmpty(r105.getWayPointName()) == false) goto L19;
    L20:
        LatLng r106 = r105.getLatLng();     // Catch: JSONException -> L31
        if (r106 == null) goto L33;
        if (SDKInitializer.getCoordType() != CoordType.GCJ02) goto L27;
        r106 = CoordTrans.gcjToBaidu(r106);     // Catch: JSONException -> L31
    L27:
        r104.put("lng", r106.longitude);     // Catch: JSONException -> L31
        r104.put("lat", r106.latitude);     // Catch: JSONException -> L31
        r101.put(r104);     // Catch: JSONException -> L31
        goto L33
    L19:
        r104.put("name", r105.getWayPointName());     // Catch: JSONException -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
    L33:
        r103 = r103 + 1;
        goto L12
    }

    public NaviParaOption() {
        this.f31681h = NaviRoutePolicy.DEFAULT;
    }

    public String getEndName() {
        return this.f31678e;
    }

    public LatLng getEndPoint() {
        return this.f31677d;
    }

    public String getEndUid() {
        return this.f31679f;
    }

    public String getStartName() {
        return this.f31675b;
    }

    public LatLng getStartPoint() {
        return this.f31674a;
    }

    public String getStartUid() {
        return this.f31676c;
    }

    public NaviParaOption endName(String r100) {
        this.f31678e = r100;
        return this;
    }

    public NaviParaOption endPoint(LatLng r100) {
        this.f31677d = r100;
        return this;
    }

    public NaviParaOption endUid(String r100) {
        this.f31679f = r100;
        return this;
    }

    public NaviParaOption setNaviRoutePolicy(NaviRoutePolicy r100) {
        this.f31681h = r100;
        return this;
    }

    public NaviParaOption setWayPoint(WayPoint r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        this.f31680g = r100;
        return this;
    }

    public NaviParaOption startName(String r100) {
        this.f31675b = r100;
        return this;
    }

    public NaviParaOption startPoint(LatLng r100) {
        this.f31674a = r100;
        return this;
    }

    public NaviParaOption startUid(String r100) {
        this.f31676c = r100;
        return this;
    }
}
