package com.bytedance.android.live.profile.monitor;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.trace.c;
import com.bytedance.android.live.core.utils.m2;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.user.e;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.json.JSONObject;
import rs0.a0;
import rs0.q0;

/* JADX INFO: loaded from: classes47.dex */
public final class ProfileMonitor {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f86091g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f86092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f86093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f86094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<ComponentType, Map<LifecycleType, Long>> f86095d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f86096e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final IRoom f86097f;

    public static final class a {
        public a() {
        }

        public static void a(Map r100) {
            q0 r101 = q0.f539075a;
            r100.put("delay_time", String.valueOf(r101.getValue().a()));
            r100.put("sampling", String.valueOf(r101.getValue().h()));
            r100.put("predict_pre_request", m2.b(r101.getValue().f()));
            r100.put("predict_delay_time", String.valueOf(r101.getValue().e()));
        }

        @JvmStatic
        public static void c(ProfileMonitor r100, ComponentType r101, LifecycleType r102, Function0 r103) {
            Intrinsics.checkNotNullParameter(r101, "componentType");
            Intrinsics.checkNotNullParameter(r102, "lifecycleType");
            Intrinsics.checkNotNullParameter(r103, "action");
            if (r100 == null) goto L8;
            Intrinsics.checkNotNullParameter(r101, "componentType");
            Intrinsics.checkNotNullParameter(r102, "lifecycleType");
            Intrinsics.checkNotNullParameter(r103, "action");
            long r104 = System.currentTimeMillis();
            r103.invoke();
            long r105 = System.currentTimeMillis();
            Map r106 = (Map) ((LinkedHashMap) r100.f86095d).get(r101);
            if (r106 != null) goto L7;
            r100.f86095d.put(r101, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(r102, Long.valueOf(r105 - r104))}));
            return;
        L7:
            r106.put(r102, Long.valueOf(r105 - r104));
            return;
        L8:
            Unit r107 = (Unit) r103.invoke();
        }

        public static void b(String r100, String r101, String r102, long r103, String r104) {
            Intrinsics.checkNotNullParameter(r100, "preRequestUid");
            Intrinsics.checkNotNullParameter(r101, "currentId");
            Intrinsics.checkNotNullParameter(r102, "anchorId");
            Intrinsics.checkNotNullParameter(r104, "logId");
            Map<String, String> r105 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("pre_uid", String.valueOf(r100)), TuplesKt.to("current_id", r101), TuplesKt.to("anchor_id", r102), TuplesKt.to("room_id", String.valueOf(r103)), TuplesKt.to("log_id", r104)});
            a(r105);
            j0.l().sendLog("livesdk_profile_pre_request_success", r105, new Object[0]);
        }
    }

    public final IRoom c() {
        return (IRoom) this.f86092a.getValue();
    }

    static {
        f86091g = new a();
    }

    public ProfileMonitor(IRoom r100) {
        this.f86097f = r100;
        this.f86092a = LazyKt.lazy(new ProfileMonitor$room$2(this));
        this.f86093b = new LinkedHashMap();
        this.f86095d = new LinkedHashMap();
        this.f86096e = LazyKt.lazy(new ProfileMonitor$processedComponentCost$2(this));
    }

    public final void g(EventType r100) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        h(r100.getKey(), GXTemplateKey.GAIAX_PLACEHOLDER);
    }

    public final void i(TimeType r100) {
        Intrinsics.checkNotNullParameter(r100, "timeType");
        String r101 = String.valueOf(System.currentTimeMillis());
        h(r100.getKey(), r101);
    }

    public static /* synthetic */ void b(ProfileMonitor r100, EndType r101) {
        r100.a(r101, "");
    }

    public final void a(EndType r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "endType");
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (this.f86094c == false) goto L5;
        return;
    L5:
        DataType r102 = DataType.SelfUid;
        IMiddlewareUserService r103 = (IMiddlewareUserService) k.f(IMiddlewareUserService.class);
        if (r103 == null) goto L11;
        e r104 = r103.user();
        if (r104 == null) goto L11;
        String r105 = r104.n();
        if (r105 == null) goto L11;
    L12:
        d(r102, r105);
        DataType r106 = DataType.RoomId;
        IRoom r107 = c();
        String r108 = null;
        if (r107 == null) goto L15;
        String r109 = r107.getIdStr();
    L16:
        d(r106, r109);
        DataType r110 = DataType.AnchorId;
        IRoom r111 = c();
        if (r111 == null) goto L19;
        String r112 = r111.getOwnerUserIdString();
    L20:
        d(r110, r112);
        d(DataType.State, Integer.valueOf(r100.getStateCode()));
        d(DataType.StateMsg, r101);
        j0.l().sendLog("livesdk_profile_monitor_info", this.f86093b, new Object[]{IRoom.class});
        if (Random.Default.nextInt(0, 10000) > a0.f539043a.getValue().intValue()) goto L23;
        boolean r113 = true;
    L24:
        if (r113 == false) goto L26;
    L27:
        Iterator r114 = ((Map) this.f86096e.getValue()).entrySet().iterator();
    L29:
        if (r114.hasNext() == false) goto L31;
        Map.Entry r115 = (Map.Entry) r114.next();
        Map<String, String> r116 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("data_component_type", r115.getKey())});
        r116.putAll((Map) r115.getValue());
        j0.l().sendLog("livesdk_profile_component_cost_monitor_info", r116, new Object[0]);
    L31:
        int r117 = com.bytedance.android.live.core.monitor.trace.e.f64997m;
        com.bytedance.android.live.core.monitor.trace.e.a r118 = com.bytedance.android.live.core.monitor.trace.e.b.a("livesdk_profile_monitor_info", "live_profile");
        r118.f65012c = "webcast_client_community";
        IRoom r119 = c();
        if (r119 == null) goto L34;
        String r120 = r119.getIdStr();
    L35:
        r118.f65014e = r120;
        IRoom r121 = c();
        if (r121 == null) goto L38;
        String r122 = r121.getOwnerUserIdString();
    L39:
        r118.f65015f = r122;
        IRoom r123 = c();
        if (r123 == null) goto L42;
        String r124 = r123.getEnterLogId();
    L43:
        r118.f65011b = r124;
        IMiddlewareUserService r125 = (IMiddlewareUserService) k.f(IMiddlewareUserService.class);
        if (r125 == null) goto L50;
        e r126 = r125.user();
        if (r126 == null) goto L50;
        String r127 = r126.n();
        if (r127 == null) goto L50;
        r108 = r127;
    L50:
        r118.f65016g = r108;
        r118.b("target_uid", ((LinkedHashMap) this.f86093b).get(DataType.TargetUid.getKey()));
        r118.b("source", ((LinkedHashMap) this.f86093b).get(DataType.Source.getKey()));
        r118.b("click_user_position", ((LinkedHashMap) this.f86093b).get(DataType.ClickUserPosition.getKey()));
        r118.b("error_code", ((LinkedHashMap) this.f86093b).get(DataType.ErrorCode.getKey()));
        r118.b("request_log_id", ((LinkedHashMap) this.f86093b).get(DataType.RequestLogId.getKey()));
        com.bytedance.android.live.core.monitor.trace.e r128 = r118.a();
        JSONObject r129 = new JSONObject();     // Catch: Exception -> L53
        r129.put("message", this.f86093b.toString());     // Catch: Exception -> L53
        r129.put("component_cost", ((Map) this.f86096e.getValue()).toString());     // Catch: Exception -> L53
        c.b(r128, r129);     // Catch: Exception -> L53
        return;
    L53:
        e = move-exception;
        ALogger.e("livesdk_profile_monitor_info", "reportTrace error: " + e.getMessage());
        return;
    L42:
        r124 = null;
        goto L43
    L38:
        r122 = null;
        goto L39
    L34:
        r120 = null;
        goto L35
    L26:
        if (v.a() == false) goto L31;
    L23:
        r113 = false;
        goto L24
    L19:
        r112 = null;
        goto L20
    L15:
        r109 = null;
    L11:
        r105 = "0";
        goto L12
    }

    public final void d(DataType r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "dataType");
        if ((r101 instanceof Boolean) == false) goto L10;
        String r102 = r100.getKey();
        DataType.a r103 = DataType.Companion;
        boolean r104 = ((Boolean) r101).booleanValue();
        r103.getClass();
        if (r104 == false) goto L7;
        String r105 = "1";
    L8:
        h(r102, r105);
        return;
    L7:
        r105 = "0";
        goto L8
    L10:
        if ((r101 instanceof Number) == false) goto L13;
        h(r100.getKey(), r101.toString());
        return;
    L13:
        if ((r101 instanceof String) == false) goto L15;
        h(r100.getKey(), (String) r101);
        return;
    L15:
        if (r101 != null) goto L17;
        h(r100.getKey(), "");
        return;
    L17:
        h(r100.getKey(), r101.toString());
    }

    public final void h(String r100, String r101) {
        this.f86093b.put(r100, r101);
    }

    public final void f(boolean r100, boolean r101, String r102, boolean r103, String r104) {
        d(DataType.IsForceSecret, Boolean.valueOf(r100));
        d(DataType.IsIntercomHideUserCard, Boolean.valueOf(r101));
        d(DataType.ClickUserPosition, r102);
        d(DataType.IsSkipPrivacyCheck, Boolean.valueOf(r103));
        d(DataType.Source, r104);
    }

    public final void e(String r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "targetUserId");
        d(DataType.TargetUid, r100);
        d(DataType.IsAdmin, Boolean.valueOf(r101));
        d(DataType.IsToSelf, Boolean.valueOf(r102));
        d(DataType.IsToAnchor, Boolean.valueOf(r103));
        d(DataType.IsToUnionAnchor, Boolean.valueOf(r104));
        d(DataType.SelfIsAnchor, Boolean.valueOf(r105));
        DataType r106 = DataType.IsRoomHideProfile;
        IRoom r107 = c();
        if (r107 == null) goto L7;
        IRoomAuthStatus r108 = r107.getRoomAuthStatus();
        if (r108 == null) goto L7;
        Boolean r109 = Boolean.valueOf(r108.getEnableUserCard());
    L8:
        d(r106, r109);
        return;
    L7:
        r109 = null;
        goto L8
    }
}
