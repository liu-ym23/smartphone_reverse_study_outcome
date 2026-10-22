package com.bytedance.applet.aibridge.navigation;

import com.bytedance.applet.task.NavigationCardSessionState;
import com.bytedance.applet.task.NavigationMultitaskCard;
import com.google.gson.JsonObject;
import com.larus.navigation.api.NavigationService;
import com.larus.platform.api.f2;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public abstract class c implements com.larus.navigation.api.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.navigation.api.w f191302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f191303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f191304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final rv3.i f191305d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile NavigationCardSessionState.a f191306e;

    public abstract void l(String r100);

    public abstract void m(String r100);

    public final NavigationCardSessionState.a i(String r100) {
        NavigationCardSessionState.a r101 = this.f191306e;
        if (r101 == null) goto L14;
        String r102 = r101.f192207b;
        if (r102 != null) goto L7;
    L10:
        boolean r103 = true;
    L11:
        if (r103 == false) goto L14;
        return r101;
    L7:
        if (Intrinsics.areEqual(r102, r100) == true) goto L10;
        r103 = false;
    L14:
        return null;
    }

    public final List<rv3.l> k(JSONObject r110) {
        JSONArray r100 = r110.optJSONArray("routes");
        if (r100 != null) goto L5;
    L40:
        int r101 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.d(this.f191303b, "onNavigationRouteChange: routeInfo has no usable routes, keep cached waypoints");
        return null;
    L5:
        if (r100.length() == 0) goto L40;
        int r102 = 0;
        JSONObject r103 = r100.optJSONObject(0);
        if (r103 != null) goto L12;
        int r104 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.d(this.f191303b, "onNavigationRouteChange: routeInfo routes[0] is not object, keep cached waypoints");
        return null;
    L12:
        if (r103.has("waypoints") == true) goto L15;
        int r105 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.d(this.f191303b, "onNavigationRouteChange: routeInfo has no routes[0].waypoints, keep cached waypoints");
        return null;
    L15:
        JSONArray r106 = r103.optJSONArray("waypoints");
        if (r106 != null) goto L19;
        int r107 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.d(this.f191303b, "onNavigationRouteChange: routeInfo routes[0].waypoints is not array, keep cached waypoints");
        return null;
    L19:
        int r108 = r106.length();
        ArrayList r109 = new ArrayList(r108);
    L20:
        if (r102 >= r108) goto L33;
        JSONObject r111 = r106.optJSONObject(r102);
        if (r111 == null) goto L31;
        double r112 = r111.optDouble("latitude", Double.NaN);
        double r113 = r111.optDouble("longitude", Double.NaN);
        if (n.a(r112, r113) == true) goto L26;
        int r114 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.b(this.f191303b, "onNavigationRouteChange: routes[0].waypoints[" + r102 + "] invalid coordinate ");
        rv3.l r115 = null;
    L30:
        if (r115 == null) goto L31;
    L32:
        r109.add(r115);
        r102 = r102 + 1;
        goto L20
    L26:
        String r116 = o(r111, "poiName");
        if (r116 != null) goto L29;
        r116 = o(r111, "name");
    L29:
        r115 = new rv3.l(r112, r113, r116, o(r111, "poiId"), o(r111, "poiType"));
    L31:
        int r117 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.b(this.f191303b, "onNavigationRouteChange: skip invalid routes[0].waypoints[" + r102 + ']');
        r115 = null;
        goto L32
    L33:
        List<rv3.l> r118 = CollectionsKt.filterNotNull(r109);
        if (r106.length() > 0) goto L36;
    L39:
        return r118;
    L36:
        if (r118.isEmpty() == false) goto L39;
        int r119 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.b(this.f191303b, "onNavigationRouteChange: routeInfo waypoints all invalid, keep cached waypoints");
        return null;
    }

    public c(com.larus.navigation.api.w r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "subTag");
        this.f191302a = r100;
        this.f191303b = r101;
        this.f191304c = new AtomicBoolean(false);
        Object r102 = l.f191335a;
        this.f191305d = l.e(r100);
    }

    public static String o(JSONObject r100, String r101) {
        if (r100.has(r101) == true) goto L5;
    L10:
        return null;
    L5:
        if (r100.isNull(r101) == true) goto L10;
        String r102 = r100.optString(r101);
        if (Intrinsics.areEqual(r102, "null") == true) goto L10;
        return r102;
    }

    @Override // com.larus.navigation.api.i
    public final void d(String r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "navigationId");
        int r102 = g.f191318a;
        Intrinsics.checkNotNullParameter(r100, "navigationId");
        JsonObject r103 = new JsonObject();
        r103.addProperty("navigationId", r100);
        r103.addProperty("degree", Float.valueOf(r101));
        Unit r104 = Unit.INSTANCE;
        g.a("flow.onDeviceRotationChange", r103);
    }

    @Override // com.larus.navigation.api.i
    public final void e(String r100, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "navigationId");
        NavigationCardSessionState.a r101 = this.f191306e;
        if (r101 != null) goto L5;
        NavigationCardSessionState.a r102 = null;
    L11:
        if (r101 == null) goto L14;
        if (r102 != null) goto L14;
        int r103 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.d(this.f191303b, "onNavigationStart: skip canceled/superseded card update");
    L14:
        this.f191306e = r102;
        int r104 = 0;
        if (this.f191304c.compareAndSet(false, true) == false) goto L40;
        m(r100);
        if (this.f191302a == null) goto L35;
        Object r105 = l.f191335a;
        rv3.i r106 = this.f191305d;
        if (r106 == null) goto L31;
        Object r107 = l.f191335a;
        monitor-enter(r107);
        l.b r108 = l.f191338d;     // Catch: Throwable -> L32
        if (r108 == null) goto L26;
        rv3.i r109 = r108.f191344a;     // Catch: Throwable -> L32
    L27:
        if (r109 != r106) goto L29;
        l.f191338d = null;     // Catch: Throwable -> L32
    L29:
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L32
        monitor-exit(r107);
        goto L31
    L26:
        r109 = null;
    L32:
        th = move-exception;
        throw th;
    L31:
        String r112 = l.a(this.f191302a, r100, this.f191305d);
    L36:
        int r113 = com.larus.navigation.api.c.f359656a;
        String r114 = this.f191303b;
        StringBuilder r115 = new StringBuilder("onNavigationStart: first start, detailUrlLen=");
        if (r112 == null) goto L39;
        r104 = r112.length();
    L39:
        r115.append(r104);
        com.larus.navigation.api.c.d(r114, r115.toString());
    L41:
        int r116 = g.f191318a;
        Intrinsics.checkNotNullParameter(r100, "navigationId");
        JsonObject r117 = new JsonObject();
        r117.addProperty("navigationId", r100);
        r117.addProperty("enableTts", Boolean.valueOf(r110));
        Unit r118 = Unit.INSTANCE;
        g.a("flow.onNavigationStart", r117);
        if (r102 == null) goto L47;
        NavigationMultitaskCard r119 = NavigationMultitaskCard.f192208a;
        NavigationMultitaskCard.b r120 = new NavigationMultitaskCard.b("导航中", "正在规划路线", null, null);
        r119.getClass();
        NavigationMultitaskCard.o(r102, r120, true);
        return;
    L47:
        return;
    L35:
        int r121 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.b(this.f191303b, "onNavigationStart: navParam is null, cannot build detail URL");
        r112 = null;
        goto L36
    L40:
        int r122 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.d(this.f191303b, "onNavigationStart: subsequent start, keeping original detailPageData");
        goto L41
    L5:
        if (Intrinsics.areEqual(r101.f192207b, r100) == false) goto L9;
        NavigationMultitaskCard.f192208a.getClass();
        Intrinsics.checkNotNullParameter(r101, "owner");
        if (NavigationMultitaskCard.f192212e.a(r101) == false) goto L9;
        r102 = r101;
    L9:
        NavigationMultitaskCard.f192208a.getClass();
        r102 = NavigationMultitaskCard.b(r101, r100);
        goto L11
    }

    @Override // com.larus.navigation.api.i
    public final void f(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "navigationId");
        Intrinsics.checkNotNullParameter(r101, "infoJson");
        CoroutineScope r102 = NavigationAgentReporter.f191288a;
        Intrinsics.checkNotNullParameter(r100, "navigationId");
        Intrinsics.checkNotNullParameter(r101, "infoJson");
        if (f2.f365106a.o() == false) goto L10;
        int r103 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.d("nav_agent_report", "trip_end: navId=" + r100 + " len=" + r101.length());
        JSONObject r104 = NavigationAgentReporter.b("end_navigation", r101);
        if (r104 == null) goto L11;
        NavigationAgentReporter.c("end_navigation", r104);
        return;
    L11:
        return;
    }

    @Override // com.larus.navigation.api.i
    public final void g(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "navigationId");
        Intrinsics.checkNotNullParameter(r101, "infoJson");
        CoroutineScope r102 = NavigationAgentReporter.f191288a;
        Intrinsics.checkNotNullParameter(r100, "navigationId");
        Intrinsics.checkNotNullParameter(r101, "infoJson");
        if (f2.f365106a.o() == false) goto L10;
        int r103 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.d("nav_agent_report", "trip_start: navId=" + r100 + " len=" + r101.length());
        JSONObject r104 = NavigationAgentReporter.b("start_navigation", r101);
        if (r104 == null) goto L11;
        NavigationAgentReporter.c("start_navigation", r104);
        return;
    L11:
        return;
    }

    @Override // com.larus.navigation.api.i
    public final void h(String r110, JSONObject r111) {
        Intrinsics.checkNotNullParameter(r110, "navigationId");
        Intrinsics.checkNotNullParameter(r111, "guidanceJson");
        JSONObject r100 = r111.optJSONObject("bindRoutePoint");
        String r101 = null;
        if (r100 == null) goto L9;
        double r102 = r100.optDouble("latitude", Double.NaN);
        double r112 = r100.optDouble("longitude", Double.NaN);
        if (Double.isNaN(r102) == true) goto L9;
        if (Double.isNaN(r112) == true) goto L9;
        Pair<Double, Double> r103 = TuplesKt.to(Double.valueOf(r102), Double.valueOf(r112));
    L17:
        if (r103 == null) goto L19;
        Object r104 = l.f191335a;
        l.f191341g = r103;
    L19:
        String r105 = r111.optString("verbalInstructions");
        Intrinsics.checkNotNull(r105);
        boolean r106 = false;
        if (r105.length() <= 0) goto L22;
        boolean r107 = true;
    L23:
        if (r107 == false) goto L25;
        r101 = r105;
    L25:
        if (r101 == null) goto L37;
        CoroutineScope r108 = NavigationAgentReporter.f191288a;
        Intrinsics.checkNotNullParameter(r110, "navigationId");
        Intrinsics.checkNotNullParameter(r101, "text");
        if (f2.f365106a.o() == false) goto L37;
        String r109 = StringsKt.trim(r101).toString();
        if (r109.length() != 0) goto L32;
        r106 = true;
    L32:
        if (r106 == true) goto L37;
        if (StringsKt.equals(r109, "null", true) == true) goto L37;
        int r113 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.d("nav_agent_report", "voice_text: navId=" + r110 + " textLen=" + r101.length());
        JSONObject r114 = new JSONObject().put("text", r101).put("occurred_at", System.currentTimeMillis());
        Intrinsics.checkNotNull(r114);
        NavigationAgentReporter.c("maneuver_point", r114);
    L37:
        int r115 = g.f191318a;
        Intrinsics.checkNotNullParameter(r111, "guidanceJson");
        g.a("flow.onNavigationGuidance", h.a(r111));
        return;
    L22:
        r107 = false;
    L9:
        JSONObject r116 = r111.optJSONObject("realLocation");
        if (r116 == null) goto L16;
        double r117 = r116.optDouble("latitude", Double.NaN);
        double r118 = r116.optDouble("longitude", Double.NaN);
        if (Double.isNaN(r117) == true) goto L16;
        if (Double.isNaN(r118) == true) goto L16;
        r103 = TuplesKt.to(Double.valueOf(r117), Double.valueOf(r118));
    L16:
        r103 = null;
        goto L17
    }

    @Override // com.larus.navigation.api.i
    public final void j(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "navigationId");
        Intrinsics.checkNotNullParameter(r101, "notificationJson");
        int r102 = g.f191318a;
        Intrinsics.checkNotNullParameter(r100, "navigationId");
        Intrinsics.checkNotNullParameter(r101, "notificationJson");
        JsonObject r103 = new JsonObject();
        r103.addProperty("navigationId", r100);
        r103.add("notification", h.a(r101));
        Unit r104 = Unit.INSTANCE;
        g.a("flow.onNavigationNotification", r103);
    }

    public final boolean n(String r100, String r101) {
        NavigationService r102 = (NavigationService) ServiceManager.get().getService(NavigationService.class);
        if (r102 == null) goto L5;
        String r103 = r102.c();
    L7:
        if (Intrinsics.areEqual(r100, r103) == false) goto L10;
        return true;
    L10:
        int r104 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.d(this.f191303b, "onNavigationRouteChange/waypoint-update: drop stale callback stage=" + r101 + " navId=" + r100 + " activeNavId=" + r103);
        return false;
    L5:
        r103 = null;
        goto L7
    }

    @Override // com.larus.navigation.api.i
    public final void a(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "navigationId");
        if (this.f191304c.compareAndSet(false, true) == false) goto L11;
        NavigationCardSessionState.a r103 = i(r100);
        if (r103 == null) goto L7;
        NavigationMultitaskCard.f192208a.getClass();
        NavigationMultitaskCard.j("start_error_" + r101, r103);
    L7:
        if (r102 != null) goto L9;
        String r104 = "error_" + r101;
    L10:
        l(r104);
        goto L11
    L9:
        r104 = r102;
    L11:
        int r105 = g.f191318a;
        Intrinsics.checkNotNullParameter(r100, "navigationId");
        JsonObject r106 = new JsonObject();
        r106.addProperty("navigationId", r100);
        r106.addProperty("errorCode", Integer.valueOf(r101));
        r106.addProperty("errorMessage", r102);
        Unit r107 = Unit.INSTANCE;
        g.a("flow.onNavigationError", r106);
    }

    @Override // com.larus.navigation.api.i
    public final void b(String r110, int r111, JSONObject r112) {
        Intrinsics.checkNotNullParameter(r110, "navigationId");
        Intrinsics.checkNotNullParameter(r112, "routeInfoJson");
        if (r111 == 2050) goto L5;
    L7:
        boolean r100 = true;
        int r101 = 0;
        if (r111 != 2048) goto L38;
        Object r113 = l.f191335a;
        final Pair<Double, Double> r114 = l.f191341g;
        l.a r115 = l.f191337c;
        if (r115 == null) goto L12;
        rv3.i r116 = r115.f191343b;
    L13:
        if (r114 == null) goto L35;
        if (r116 == null) goto L35;
        final List<rv3.l> r117 = k(r112);
        rv3.i r118 = l.g(r110, new a(r114, r117));
        if (r118 == null) goto L34;
        int r119 = com.larus.navigation.api.c.f359656a;
        String r120 = this.f191303b;
        StringBuilder r121 = new StringBuilder("onNavigationRouteChange/yaw: detailPageData updated startPoint + waypoints hadStartPoint=");
        if (r116.g() == null) goto L20;
        boolean r102 = true;
    L21:
        r121.append(r102);
        r121.append(" oldCount=");
        List<rv3.l> r103 = r116.h();
        if (r103 == null) goto L24;
        int r104 = r103.size();
    L25:
        r121.append(r104);
        r121.append(" newCount=");
        List<rv3.l> r105 = r118.h();
        if (r105 == null) goto L28;
        int r106 = r105.size();
    L29:
        r121.append(r106);
        r121.append(" waypointsUpdated=");
        if (r117 == null) goto L32;
        boolean r107 = true;
    L33:
        r121.append(r107);
        com.larus.navigation.api.c.d(r120, r121.toString());
        goto L38
    L32:
        r107 = false;
        goto L33
    L28:
        r106 = 0;
        goto L29
    L24:
        r104 = 0;
        goto L25
    L20:
        r102 = false;
        goto L21
    L34:
        int r108 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.d(this.f191303b, "onNavigationRouteChange/yaw: skip cache update for non-owner navId=".concat(r110));
    L35:
        if (r114 != null) goto L37;
        int r109 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.d(this.f191303b, "onNavigationRouteChange/initial-routing: skip startPoint update (no guidance yet)");
        goto L38
    L37:
        int r122 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.b(this.f191303b, "onNavigationRouteChange/yaw: state-machine-error detailPageData=null, cannot update startPoint (hasLastKnownLocation=true)");
        goto L38
    L12:
        r116 = null;
    L38:
        if (r111 != 2050) goto L63;
        Object r123 = l.f191335a;
        l.a r124 = l.f191337c;
        if (r124 == null) goto L42;
        rv3.i r125 = r124.f191343b;
    L43:
        final List<rv3.l> r126 = k(r112);
        if (r125 == null) goto L54;
        if (r126 == null) goto L54;
        if (l.g(r110, new b(r126)) == null) goto L52;
        int r127 = com.larus.navigation.api.c.f359656a;
        String r128 = this.f191303b;
        StringBuilder r129 = new StringBuilder("onNavigationRouteChange/waypoint-update: detailPageData waypoints updated oldCount=");
        List<rv3.l> r130 = r125.h();
        if (r130 == null) goto L51;
        r101 = r130.size();
    L51:
        r129.append(r101);
        r129.append(" newCount=");
        r129.append(r126.size());
        com.larus.navigation.api.c.d(r128, r129.toString());
        goto L63
    L52:
        int r131 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.d(this.f191303b, "onNavigationRouteChange/waypoint-update: drop callback for non-owner navId=".concat(r110));
        return;
    L54:
        int r132 = com.larus.navigation.api.c.f359656a;
        String r133 = this.f191303b;
        StringBuilder r134 = new StringBuilder("onNavigationRouteChange/waypoint-update: keep cached waypoints hasPageData=");
        if (r125 == null) goto L57;
        boolean r135 = true;
    L58:
        r134.append(r135);
        r134.append(" hasUpdatedWaypoints=");
        if (r126 != null) goto L62;
        r100 = false;
    L62:
        r134.append(r100);
        com.larus.navigation.api.c.d(r133, r134.toString());
        goto L63
    L57:
        r135 = false;
        goto L58
    L42:
        r125 = null;
    L63:
        if (r111 == 2050) goto L65;
    L67:
        int r136 = g.f191318a;
        Intrinsics.checkNotNullParameter(r110, "navigationId");
        Intrinsics.checkNotNullParameter(r112, "routeInfoJson");
        JsonObject r137 = new JsonObject();
        r137.addProperty("navigationId", r110);
        r137.addProperty("reason", Integer.valueOf(r111));
        r137.add("routeInfo", h.a(r112));
        com.larus.navigation.api.c.d("js_event", "publishEvent: flow.onNavigationRouteChange");
        com.larus.navigation.api.c.a("nav_protocol_trace", "[H5_EVENT/flow.onNavigationRouteChange] navigationId=" + r110 + " reason=" + r111 + " fieldCount=" + r137.entrySet().size());
        Lazy r138 = l3.d.f507201a;
        l3.d.c(new l3.a("flow.onNavigationRouteChange", r137, 4));
        int r139 = com.larus.navigation.api.j.f359662a;
        String r140 = r112.toString();
        Intrinsics.checkNotNullParameter("flow.onNavigationRouteChange", "eventName");
        Intrinsics.checkNotNullParameter(r140, "params");
        return;
    L65:
        if (n(r110, "before_publish") == true) goto L67;
        return;
    L5:
        if (n(r110, "before_cache") == true) goto L7;
    }

    @Override // com.larus.navigation.api.i
    public final void c(String r100, int r101, String r110) {
        Intrinsics.checkNotNullParameter(r100, "navigationId");
        int r102 = com.larus.navigation.api.c.f359656a;
        String r103 = this.f191303b;
        StringBuilder r104 = new StringBuilder("onNavigationStop: reason=");
        r104.append(r101);
        r104.append(" descLen=");
        boolean r105 = false;
        if (r110 == null) goto L5;
        int r106 = r110.length();
    L6:
        r104.append(r106);
        r104.append(" navId=");
        r104.append(r100);
        r104.append(" thread=");
        r104.append(ThreadMethodProxy.currentThread().getName());
        com.larus.navigation.api.c.d(r103, r104.toString());
        if (this.f191304c.compareAndSet(false, true) == false) goto L15;
        if (r110 != null) goto L10;
        String r107 = "error_" + r101;
    L11:
        com.larus.navigation.api.c.e(this.f191303b, "onNavigationStop before start result: completing JSB failure reasonCode=" + r101);
        NavigationCardSessionState.a r108 = i(r100);
        if (r108 == null) goto L14;
        NavigationMultitaskCard.f192208a.getClass();
        NavigationMultitaskCard.j("stop_before_start", r108);
    L14:
        l(r107);
        goto L15
    L10:
        r107 = r110;
    L15:
        Object r109 = l.f191335a;
        l.a r111 = l.f191337c;
        if (r111 == null) goto L18;
        rv3.i r112 = r111.f191343b;
    L19:
        if (r112 == null) goto L21;
        boolean r113 = true;
    L22:
        boolean r114 = Intrinsics.areEqual(r110, "jsb_quick_restart");
        Intrinsics.checkNotNullParameter(r100, "navigationId");
        Object r115 = l.f191335a;
        monitor-enter(r115);
        l.a r116 = l.f191337c;     // Catch: Throwable -> L43
        if (r116 != null) goto L28;
    L31:
        r105 = true;
    L32:
        monitor-exit(r115);
        com.larus.navigation.api.c.d(this.f191303b, "cleanupAfterStop: clear detailPageData hadData=" + r113 + " canCleanup=" + r105 + " navId=" + r100 + " quickRestart=" + r114);
        if (r105 == false) goto L41;
        l.f191339e = null;
        l.f191341g = null;
        NavigationCardSessionState.a r117 = i(r100);
        if (r117 == null) goto L41;
        if (r114 == false) goto L40;
        NavigationMultitaskCard.f192208a.l(r117);
        goto L41
    L40:
        NavigationMultitaskCard.f192208a.getClass();
        NavigationMultitaskCard.j("navigation_stopped", r117);
    L41:
        int r118 = g.f191318a;
        Intrinsics.checkNotNullParameter(r100, "navigationId");
        JsonObject r119 = new JsonObject();
        r119.addProperty("navigationId", r100);
        r119.addProperty("reasonCode", Integer.valueOf(r101));
        r119.addProperty("reasonDesc", r110);
        Unit r120 = Unit.INSTANCE;
        g.a("flow.onNavigationStop", r119);
        return;
    L28:
        if (Intrinsics.areEqual(r116.f191342a, r100) == false) goto L32;
        l.f191337c = null;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        throw th;
    L21:
        r113 = false;
        goto L22
    L18:
        r112 = null;
        goto L19
    L5:
        r106 = 0;
        goto L6
    }
}
