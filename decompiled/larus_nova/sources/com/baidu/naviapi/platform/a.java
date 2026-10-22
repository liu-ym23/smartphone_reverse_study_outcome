package com.baidu.naviapi.platform;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.alipay.sdk.m.u.i;
import com.baidu.naviapi.okhttp.log.BNLogUtil;
import com.baidu.naviapi.open.IBNAManager;
import com.baidu.naviapi.open.INaviMsgCallback;
import com.baidu.naviapi.open.IRouteResult;
import com.baidu.naviapi.open.LocInfo;
import com.baidu.naviapi.open.MsgBean;
import com.baidu.naviapi.open.RoutePlanParam;
import com.baidu.naviapi.open.StringUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public final enum a extends Enum<a> implements IBNAManager {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final a f32640u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ a[] f32641v = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<INaviMsgCallback> f32642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f32643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.baidu.naviapi.worker.a f32644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RoutePlanParam f32645d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f32646e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IRouteResult f32647f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f32648g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f32649h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f32650i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f32651j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f32652k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f32653l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f32654m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f32655n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f32656o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f32657p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Deque<LocInfo> f32658q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final com.baidu.naviapi.platform.net.a f32659r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final com.baidu.naviapi.platform.net.a f32660s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f32661t;

    /* JADX INFO: renamed from: com.baidu.naviapi.platform.a$a, reason: collision with other inner class name */
    public class C0660a implements com.baidu.naviapi.platform.net.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f32662a;

        public C0660a(a r100) {
            this.f32662a = r100;
        }

        @Override // com.baidu.naviapi.platform.net.a
        public void onSuccess(String r210) {
            String r100 = r210;
            String r101 = "BNAManager";
            BNLogUtil.logI("BNAManager", "LocResponse:" + r100);
            JSONObject r102 = new JSONObject(r100);     // Catch: Exception -> L107
            int r103 = JSONObjectProtectorUtils.getInt(r102, "status");     // Catch: Exception -> L107
            JSONObject r104 = r102.optJSONObject("result");     // Catch: Exception -> L107
            if (r103 == 4) goto L6;
            if (r104 != null) goto L114;
        L102:
            String r211 = "BNAManager";
            r100 = r210;
            a(r103, r100);     // Catch: Exception -> L105
            return;
        L105:
            e = e;
        L109:
            BNLogUtil.logE(r211, "JSONException ", e);
            a(1, "Exception:" + r100);
            return;
        L114:
        L99:
            e = e;
            r211 = r101;
        L101:
            r100 = r210;
            goto L109
        L16:
            if (r104.has("mm_location") == false) goto L102;
            MsgBean r110 = new MsgBean();     // Catch: Exception -> L99
            r110.setMsg(r102.optString("message"));     // Catch: Exception -> L99
            a.a(this.f32662a, r104.optInt("current_to_origin"));     // Catch: Exception -> L99
            r110.setCurrentToOrigin(a.b(this.f32662a));     // Catch: Exception -> L99
            r110.setMmDirection(r104.optInt("mm_direction"));     // Catch: Exception -> L99
            MsgBean.MmLocation r105 = new MsgBean.MmLocation();     // Catch: Exception -> L99
            JSONObject r106 = r104.optJSONObject("mm_location");     // Catch: Exception -> L99
            if (r106 == null) goto L20;
            r105.setLat(Double.valueOf(r106.optDouble("lat")));     // Catch: Exception -> L107
            r105.setLng(Double.valueOf(r106.optDouble("lng")));     // Catch: Exception -> L107
        L20:
            r110.setMmLocation(r105);     // Catch: Exception -> L99
            r110.setSessionId(r104.optString("session_id"));     // Catch: Exception -> L99
            ArrayList r107 = new ArrayList();     // Catch: Exception -> L99
            JSONArray r108 = r104.optJSONArray("routes");     // Catch: Exception -> L99
            if (r108 != null) goto L23;
        L89:
            r211 = "BNAManager";
            int r212 = r103;
        L90:
            r110.setRoutes(r107);     // Catch: Exception -> L97
            int r109 = r212;
            r110.setCode(r109);     // Catch: Exception -> L97
            if (a.a(this.f32662a) == false) goto L94;
            com.baidu.naviapi.worker.b.f32714c.a(r110);     // Catch: Exception -> L97
        L94:
            if (r109 != 9) goto L128;
            a.f(this.f32662a).onNaviEnd();     // Catch: Exception -> L97
            return;
        L97:
            e = e;
            goto L101
        L128:
            return;
        L23:
            if (r108.length() <= 0) goto L89;
            MsgBean.Routes r111 = new MsgBean.Routes();     // Catch: Exception -> L99
            JSONObject r112 = r108.optJSONObject(0);     // Catch: Exception -> L99
            r111.setRouteId(r112.optString("route_id"));     // Catch: Exception -> L99
            r111.setDistance(r112.optInt("distance"));     // Catch: Exception -> L99
            r111.setDuration(r112.optInt("duration"));     // Catch: Exception -> L99
            String r113 = "distance_to_origin";
            if (r112.has("visual_instructions") == false) goto L46;
            JSONArray r114 = r112.optJSONArray("visual_instructions");     // Catch: Exception -> L107
            ArrayList r115 = new ArrayList();     // Catch: Exception -> L107
            if (r114 == null) goto L42;
            if (r114.length() <= 0) goto L42;
            MsgBean.Routes.VisualInstructions r116 = new MsgBean.Routes.VisualInstructions();     // Catch: Exception -> L107
            JSONObject r117 = r114.optJSONObject(0);     // Catch: Exception -> L107
            String r118 = r117.optString("position");     // Catch: Exception -> L107
            if (TextUtils.isEmpty(r118) == true) goto L37;
            String[] r119 = r118.split(",");     // Catch: Exception -> L107
            if (r119.length <= 1) goto L37;
            r116.setPosition(new LocInfo.Point(CastDoubleProtector.parseDouble(r119[1]), CastDoubleProtector.parseDouble(r119[0]), AudioStats.AUDIO_AMPLITUDE_NONE));     // Catch: Exception -> L107
        L37:
            int r120 = r117.optInt("distance_to_origin");     // Catch: Exception -> L107
            r116.setDistanceToOrigin(r120);     // Catch: Exception -> L107
            MsgBean.Routes.VisualInstructions.TurnDescription r121 = new MsgBean.Routes.VisualInstructions.TurnDescription();     // Catch: Exception -> L107
            JSONObject r122 = r117.optJSONObject("turn_description");     // Catch: Exception -> L107
            if (r122 == null) goto L40;
            r121.setTurnKind(r122.optInt("turn_kind"));     // Catch: Exception -> L107
            r121.setTurnRoadName(r122.optString("turn_road_name"));     // Catch: Exception -> L107
        L40:
            r116.setDistanceToCurrent(r120 - a.b(this.f32662a));     // Catch: Exception -> L107
            r116.setTurnDescription(r121);     // Catch: Exception -> L107
            r115.add(r116);     // Catch: Exception -> L107
        L42:
            r111.setVisualInstructions(r115);     // Catch: Exception -> L107
        L46:
            if (r112.has("verbal_instructions") == false) goto L87;
            JSONArray r123 = r112.optJSONArray("verbal_instructions");     // Catch: Exception -> L99
            ArrayList r124 = new ArrayList();     // Catch: Exception -> L99
            int r125 = 0;
        L48:
            if (r123 == null) goto L83;
            if (r125 >= r123.length()) goto L83;
            MsgBean.Routes.VerbalInstructions r126 = new MsgBean.Routes.VerbalInstructions();     // Catch: Exception -> L99
            JSONObject r127 = r123.optJSONObject(r125);     // Catch: Exception -> L99
            r126.setRoadName(r127.optString("road_name"));     // Catch: Exception -> L99
            r126.setDistanceToOrigin(r127.optInt(r113));     // Catch: Exception -> L99
            JSONArray r128 = r127.optJSONArray("details");     // Catch: Exception -> L99
            ArrayList r129 = new ArrayList();     // Catch: Exception -> L99
            int r130 = 0;
        L52:
            if (r128 == null) goto L78;
            if (r130 >= r128.length()) goto L78;
            JSONObject r131 = r128.optJSONObject(r130);     // Catch: Exception -> L99
            JSONArray r132 = r123;
            MsgBean.Routes.VerbalInstructions.Details r133 = new MsgBean.Routes.VerbalInstructions.Details();     // Catch: Exception -> L99
            JSONArray r134 = r128;
            String r135 = r131.optString("index");     // Catch: Exception -> L99
            String r213 = r113;
            String r136 = r131.optString("speak_text");     // Catch: Exception -> L99
            r211 = r101;
            if (TextUtils.equals(r131.optString("version"), "v3") == false) goto L63;
            int r137 = r103;
            MsgBean.Routes r138 = r111;
            long r139 = SystemClock.elapsedRealtime() - a.c(this.f32662a);     // Catch: Exception -> L97
            if (r139 >= 60000) goto L62;
            r212 = r137;
        L77:
            r130 = r130 + 1;     // Catch: Exception -> L97
            r111 = r138;
            r123 = r132;
            r128 = r134;
            r113 = r213;
            r101 = r211;
            r103 = r212;
            goto L52
        L62:
            r212 = r137;
            StringBuffer r140 = new StringBuffer();     // Catch: Exception -> L97
            StringUtils.formatTime(((int) r139) / 1000, StringUtils.UnitLangEnum.ZH, r140);     // Catch: Exception -> L97
            r136 = r136.replace("{type=1}", r140);     // Catch: Exception -> L97
        L64:
            r133.setSpeakText(r136);     // Catch: Exception -> L97
            r133.setDistanceToGdpt(r131.optInt("distance_to_gdpt"));     // Catch: Exception -> L97
            int r141 = r131.optInt("distance_to_speakpt", 10086);     // Catch: Exception -> L97
            r133.setDistanceToSpeakpt(r141);     // Catch: Exception -> L97
            BNLogUtil.logI("distanceToSpeakpt: " + r141);     // Catch: Exception -> L97
            if (a.d(this.f32662a) == null) goto L76;
            int r142 = ((Integer) a.d(this.f32662a).getGuidanceRange().first).intValue();     // Catch: Exception -> L97
            int r143 = c.f32664a[a.d(this.f32662a).getRoutePlanType().ordinal()];     // Catch: Exception -> L97
            if (r143 != 1) goto L69;
            int r144 = 10;
        L73:
            if (r141 < r142) goto L77;
            if (r141 > r144) goto L77;
            r133.setSent(TextUtils.equals(a.e(this.f32662a), r135));     // Catch: Exception -> L97
            a.b(this.f32662a, r135);     // Catch: Exception -> L97
            r129.add(r133);     // Catch: Exception -> L97
        L80:
            if (r129.isEmpty() == false) goto L81;
            r125 = r125 + 1;     // Catch: Exception -> L97
            r111 = r138;
            r123 = r132;
            r113 = r213;
            r101 = r211;
            r103 = r212;
            goto L48
        L81:
            r126.setDetails(r129);     // Catch: Exception -> L97
            r124.add(r126);     // Catch: Exception -> L97
        L85:
            if (r124.isEmpty() == true) goto L88;
            r138.setVerbalInstructions(r124);     // Catch: Exception -> L97
        L88:
            r107.add(r138);     // Catch: Exception -> L97
            goto L90
        L69:
            if (r143 == 2) goto L71;
            r144 = 5;
            goto L73
        L71:
            r144 = 50;
            goto L73
        L76:
            r129.add(r133);     // Catch: Exception -> L97
            goto L77
        L63:
            r212 = r103;
            r138 = r111;
        L78:
            r132 = r123;
            r211 = r101;
            r212 = r103;
            r138 = r111;
            r213 = r113;
        L83:
            r211 = r101;
            r212 = r103;
            r138 = r111;
            goto L85
        L87:
            r211 = "BNAManager";
            r212 = r103;
            r138 = r111;
            goto L88
        L6:
            if (a.a(this.f32662a) == false) goto L12;
            MsgBean r145 = new MsgBean();     // Catch: Exception -> L107
            r145.setCode(r103);     // Catch: Exception -> L107
            if (r103 != 4) goto L10;
            r145.setMsg("当前已偏航");     // Catch: Exception -> L107
        L11:
            com.baidu.naviapi.worker.b.f32714c.a(r145);     // Catch: Exception -> L107
            goto L12
        L10:
            r145.setMsg(r100);     // Catch: Exception -> L107
        L12:
            a.a(this.f32662a, r100);     // Catch: Exception -> L107
            return;
        L107:
            e = e;
            r211 = "BNAManager";
            goto L109
        }

        @Override // com.baidu.naviapi.platform.net.a
        public void a(int r100, String r101) {
            BNLogUtil.logI("BNAManager", "LocResponse:" + r101);
            if (r101 == null) goto L8;
            if (r101.contains("Canceled") == false) goto L8;
            return;
        L8:
            if (a.a(this.f32662a) == false) goto L11;
            MsgBean r102 = new MsgBean();
            r102.setCode(r100);
            r102.setMsg(r101);
            com.baidu.naviapi.worker.b.f32714c.a(r102);
            return;
        }
    }

    public class b implements com.baidu.naviapi.platform.net.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f32663a;

        public b(a r100) {
            this.f32663a = r100;
        }

        @Override // com.baidu.naviapi.platform.net.a
        public void onSuccess(String r100) {
            a.a(this.f32663a, r100);
        }

        @Override // com.baidu.naviapi.platform.net.a
        public void a(int r100, String r101) {
            if (a.f(this.f32663a) != null) goto L6;
            BNLogUtil.logI("BNAManager", "onError:mIRouteResult == null");
            return;
        L6:
            BNLogUtil.logI("BNAManager", "RouteResponse:" + r101);
            a.f(this.f32663a).onFailed(r101);
        }
    }

    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f32664a = null;

        static {
            int[] r100 = new int[RoutePlanParam.RoutePlanType.values().length];
            f32664a = r100;
            r100[RoutePlanParam.RoutePlanType.RIDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f32664a[RoutePlanParam.RoutePlanType.DRIVING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static {
        a r100 = new a("INSTANCE", 0);
        f32640u = r100;
        f32641v = new a[]{r100};
    }

    public static a[] values() {
        return (a[]) f32641v.clone();
    }

    public String b() {
        if (TextUtils.isEmpty(this.f32649h) == false) goto L6;
        return this.f32645d.getRouteId();
    L6:
        return this.f32649h;
    }

    public RoutePlanParam c() {
        if (this.f32645d != null) goto L6;
        BNLogUtil.logI("BNAManager", "mRoutePlanParam == null");
        BNLogUtil.printStack("mRoutePlanParam is null why?");
        this.f32645d = new RoutePlanParam();
    L6:
        return this.f32645d;
    }

    @Override // com.baidu.naviapi.open.IBNAManager
    public void clearCallback() {
        BNLogUtil.logI("BNAManager", "clearCallback");
        List<INaviMsgCallback> r100 = this.f32642a;
        monitor-enter(r100);
        this.f32642a.clear();     // Catch: Throwable -> L7
        g();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public String d() {
        if (TextUtils.isEmpty(this.f32648g) == false) goto L6;
        return this.f32645d.getSessionId();
    L6:
        return this.f32648g.replace("\"", "\\\"");
    }

    public final void e() {
        BNLogUtil.logI("resetParam");
        com.baidu.naviapi.platform.net.c.a();
        com.baidu.naviapi.worker.b.f32714c.a();
        this.f32651j = null;
        this.f32658q.clear();
        this.f32649h = null;
        this.f32648g = null;
        this.f32650i = 0;
    }

    @Override // com.baidu.naviapi.open.IBNAManager
    public void exitNavi() {
        BNLogUtil.logI("BNAManager", "exitNavi");
        monitor-enter(a.class);
        e();     // Catch: Throwable -> L7
        this.f32646e = false;     // Catch: Throwable -> L7
        monitor-exit(a.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void f() {
        if (this.f32643b == false) goto L5;
        return;
    L5:
        com.baidu.naviapi.worker.a r100 = new com.baidu.naviapi.worker.a();
        this.f32644c = r100;
        r100.a(this.f32642a);
        this.f32644c.c();
        this.f32643b = true;
    }

    public final void g() {
        com.baidu.naviapi.worker.a r100 = this.f32644c;
        if (r100 == null) goto L6;
        r100.b();
        this.f32644c = null;
        this.f32643b = false;
        return;
    }

    public int a() {
        return this.f32650i;
    }

    public static /* synthetic */ long c(a r100) {
        return r100.f32652k;
    }

    public static /* synthetic */ RoutePlanParam d(a r100) {
        return r100.f32645d;
    }

    public static /* synthetic */ String e(a r100) {
        return r100.f32651j;
    }

    public static /* synthetic */ IRouteResult f(a r100) {
        return r100.f32647f;
    }

    public static a valueOf(String r100) {
        return (a) r27.a.a(a.class, r100);
    }

    public final synchronized String a(LocInfo r110) {
        monitor-enter(this);
        LocInfo r100 = this.f32658q.peekLast();     // Catch: Throwable -> L30
        this.f32658q.addLast(r110);     // Catch: Throwable -> L30
        if (this.f32658q.size() <= 25) goto L6;
        this.f32658q.poll();     // Catch: Throwable -> L30
    L6:
        if (r100 == null) goto L16;
        double r101 = r100.getGeoPoint().getLng();     // Catch: Throwable -> L30
        double r102 = r110.getGeoPoint().getLng();     // Catch: Throwable -> L30
        double r103 = r100.getGeoPoint().getLat();     // Catch: Throwable -> L30
        double r104 = r110.getGeoPoint().getLat();     // Catch: Throwable -> L30
        if (this.f32645d.getCoordType() == 4) goto L13;
        if (com.baidu.naviapi.platform.b.a(r101, r103, r102, r104) > 1.0d) goto L16;
    L15:
        boolean r111 = false;
    L17:
        StringBuilder r105 = new StringBuilder();     // Catch: Throwable -> L30
        Iterator<LocInfo> r106 = this.f32658q.iterator();     // Catch: Throwable -> L30
    L19:
        if (r106.hasNext() == false) goto L25;
        LocInfo r107 = r106.next();     // Catch: Throwable -> L30
        r105.append(r107.getGeoPoint().getLng());     // Catch: Throwable -> L30
        r105.append(",");     // Catch: Throwable -> L30
        r105.append(r107.getGeoPoint().getLat());     // Catch: Throwable -> L30
        r105.append(",");     // Catch: Throwable -> L30
        r105.append(r107.getMMPoint().getLng());     // Catch: Throwable -> L30
        r105.append(",");     // Catch: Throwable -> L30
        r105.append(r107.getMMPoint().getLat());     // Catch: Throwable -> L30
        r105.append(",");     // Catch: Throwable -> L30
        r105.append(r107.getGeoPoint().getAlt());     // Catch: Throwable -> L30
        r105.append(",");     // Catch: Throwable -> L30
        r105.append(r107.getSpeed());     // Catch: Throwable -> L30
        r105.append(",");     // Catch: Throwable -> L30
        if (r107.getSensorDir() != 0) goto L23;
        int r108 = r107.getGpsDir();     // Catch: Throwable -> L30
    L24:
        r105.append(r108);     // Catch: Throwable -> L30
        r105.append(",");     // Catch: Throwable -> L30
        r105.append(r107.getRadius());     // Catch: Throwable -> L30
        r105.append(",");     // Catch: Throwable -> L30
        r105.append(r107.getLocType());     // Catch: Throwable -> L30
        r105.append(",");     // Catch: Throwable -> L30
        r105.append(r107.getInRoom());     // Catch: Throwable -> L30
        r105.append(",");     // Catch: Throwable -> L30
        r105.append(r107.getSatelliteSize());     // Catch: Throwable -> L30
        r105.append(",");     // Catch: Throwable -> L30
        r105.append(r107.getGpsTime());     // Catch: Throwable -> L30
        r105.append(i.f25853b);     // Catch: Throwable -> L30
        goto L19
    L23:
        r108 = r107.getSensorDir();     // Catch: Throwable -> L30
        goto L24
    L25:
        if (r111 == true) goto L27;
        this.f32658q.pollLast();     // Catch: Throwable -> L30
    L27:
        String r112 = r105.toString();     // Catch: Throwable -> L30
        monitor-exit(this);
        return r112;
    L13:
        if (com.baidu.naviapi.platform.b.b(r101, r103, r102, r104) <= 1.0d) goto L15;
    L16:
        r111 = true;
    L30:
        th = move-exception;
        throw th;
    }

    @Override // com.baidu.naviapi.open.IBNAManager
    public void addCallback(INaviMsgCallback r100) {
        BNLogUtil.logI("BNAManager", "addCallback");
        if (r100 == null) goto L5;
        BNLogUtil.logI("BNAManager", "NaviMsgCallback " + r100.hashCode());
    L5:
        List<INaviMsgCallback> r101 = this.f32642a;
        monitor-enter(r101);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.f32642a.contains(r100) == true) goto L10;
        this.f32642a.add(r100);     // Catch: Throwable -> L13
    L10:
        f();     // Catch: Throwable -> L13
        monitor-exit(r101);     // Catch: Throwable -> L13
    }

    public final void b(LocInfo r100) throws com.baidu.naviapi.platform.ex.a {
        if (this.f32642a.isEmpty() == true) goto L14;
        if (r100 != null) goto L6;
    L12:
        BNLogUtil.logE("BNAManager", "BNAParamIllegal -> " + r100);
        throw new com.baidu.naviapi.platform.ex.b("定位参数异常");
    L6:
        if (r100.getGeoPoint() == null) goto L12;
        if (r100.getGeoPoint().getLat() == AudioStats.AUDIO_AMPLITUDE_NONE) goto L12;
        if (r100.getGeoPoint().getLng() == AudioStats.AUDIO_AMPLITUDE_NONE) goto L12;
        return;
    L14:
        BNLogUtil.logE("BNAManager", "msgCallbacks.isEmpty()");
        throw new com.baidu.naviapi.platform.ex.c("没有设置诱导数据的消息回调，addCallback(INaviMsgCallback iNaviMsgCallback)");
    }

    @Override // com.baidu.naviapi.open.IBNAManager
    public void removeCallback(INaviMsgCallback r100) {
        BNLogUtil.logI("BNAManager", "removeCallback");
        List<INaviMsgCallback> r101 = this.f32642a;
        monitor-enter(r101);
        this.f32642a.remove(r100);     // Catch: Throwable -> L9
        if (this.f32642a.isEmpty() == false) goto L7;
        BNLogUtil.logI("BNAManager", "stopConsumer");     // Catch: Throwable -> L9
        g();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.baidu.naviapi.open.IBNAManager
    public void sendLocData(LocInfo r100) throws com.baidu.naviapi.platform.ex.a {
        if (this.f32646e == true) goto L7;
        BNLogUtil.logI("BNAManager", "sendLocData navigating false");
        return;
    L7:
        if (this.f32645d == null) goto L17;
        if ((SystemClock.elapsedRealtime() - this.f32661t) >= 900) goto L11;
        return;
    L11:
        this.f32661t = SystemClock.elapsedRealtime();
        b(r100);
        String r101 = a(r100);
        if (this.f32653l == false) goto L14;
        this.f32653l = false;
        this.f32652k = SystemClock.elapsedRealtime();
    L14:
        com.baidu.naviapi.platform.net.c.a(new com.baidu.naviapi.platform.net.b(r101, r100.getState(), this.f32659r));
        return;
    L17:
        throw new com.baidu.naviapi.platform.ex.b("please invoke method routePlan first.");
    }

    public static /* synthetic */ int b(a r100) {
        return r100.f32650i;
    }

    public final void a(String r100) {
        if (this.f32647f != null) goto L6;
        BNLogUtil.logI("BNAManager", "calcRoute:mIRouteResult == null");
        return;
    L6:
        BNLogUtil.logI("BNAManager", "RouteResponse:" + r100);
        JSONObject r101 = new JSONObject(r100);     // Catch: Exception -> L18
        int r102 = r101.optInt("status", -1);     // Catch: Exception -> L18
        if (r101.has("result") == false) goto L16;
        if (r102 != 0) goto L11;
    L12:
        e();     // Catch: Exception -> L18
        JSONObject r103 = JSONObjectProtectorUtils.getJSONObject(r101, "result");     // Catch: Exception -> L18
        this.f32648g = JSONObjectProtectorUtils.getString(r103, "session_id");     // Catch: Exception -> L18
        if (r103.optInt("total", 0) <= 0) goto L15;
        this.f32649h = JSONObjectProtectorUtils.getString(JSONArrayProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONArray(r103, "routes"), 0), "route_id");     // Catch: Exception -> L18
    L15:
        com.baidu.naviapi.worker.b.f32714c.a();     // Catch: Exception -> L18
        this.f32647f.onSuccess(r103.toString());     // Catch: Exception -> L18
        return;
    L11:
        if (r102 == 4) goto L12;
    L16:
        this.f32647f.onFailed(r100);     // Catch: Exception -> L18
        return;
    L18:
        e = move-exception;
        BNLogUtil.logE("BNAManager", "json parse ex ", e);
        this.f32647f.onFailed("calcRoute" + e);
    }

    public final void a(RoutePlanParam r100) throws com.baidu.naviapi.platform.ex.a {
        if (r100 != null) goto L4;
        BNLogUtil.logI("route param cant be null.");
        throw new com.baidu.naviapi.platform.ex.b("route param cant be null.");
    L4:
        if (r100.getRoutePlanType() != null) goto L6;
        BNLogUtil.logI("route plan type cant be null.");
        throw new com.baidu.naviapi.platform.ex.b("route plan type cant be null.");
    L6:
        if (r100.getGuidanceRange() == null) goto L8;
        return;
    L8:
        BNLogUtil.logI("route plan range cant be null.");
        throw new com.baidu.naviapi.platform.ex.b("route plan range cant be null.");
    }

    public static /* synthetic */ boolean a(a r100) {
        return r100.f32643b;
    }

    public a(String r100, int r101) {
        super(r100, r101);
        this.f32642a = new ArrayList();
        this.f32643b = false;
        this.f32646e = false;
        this.f32650i = 0;
        this.f32654m = 5;
        this.f32655n = 10;
        this.f32656o = 50;
        this.f32657p = true;
        this.f32658q = new LinkedList();
        this.f32659r = new C0660a(this);
        this.f32660s = new b(this);
    }

    public static /* synthetic */ void a(a r100, String r101) {
        r100.a(r101);
    }

    public static /* synthetic */ String b(a r100, String r101) {
        r100.f32651j = r101;
        return r101;
    }

    @Override // com.baidu.naviapi.open.IBNAManager
    public void routePlan(RoutePlanParam r100, IRouteResult r101) throws com.baidu.naviapi.platform.ex.a {
        a(r100);
        monitor-enter(a.class);
        this.f32646e = true;     // Catch: Throwable -> L16
        monitor-exit(a.class);     // Catch: Throwable -> L16
        this.f32647f = r101;
        this.f32645d = r100;
        BNLogUtil.logI("BNAManager", "routePlan: " + r100);
        if (TextUtils.isEmpty(r100.getRouteId()) == false) goto L10;
    L13:
        com.baidu.naviapi.platform.net.c.a(new com.baidu.naviapi.platform.net.e(r100, this.f32660s));
    L14:
        this.f32653l = true;
        return;
    L10:
        if (TextUtils.isEmpty(r100.getSessionId()) == true) goto L13;
        e();
        r101.onSuccess("");
    L16:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ int a(a r100, int r101) {
        r100.f32650i = r101;
        return r101;
    }
}
