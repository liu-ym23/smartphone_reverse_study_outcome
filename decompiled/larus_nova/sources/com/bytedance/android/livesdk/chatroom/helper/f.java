package com.bytedance.android.livesdk.chatroom.helper;

import am2.x;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.live.ai.api.IAiService;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livehostapi.foundation.depend.ITTNetNQEConfigHelper;
import com.bytedance.android.livehostapi.foundation.depend.TTNetNetworkQuality;
import com.bytedance.android.livehostapi.platform.IHostLog;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.room.RoomSession;
import com.bytedance.android.livesdk.config.cn;
import com.bytedance.android.livesdk.config.et;
import com.bytedance.android.livesdk.config.y3;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.room.data.EndReason;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.VrBgLogData;
import com.bytedance.android.livesdkapi.service.ILiveNetworkPredict;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.android.livesdkapi.service.com.bytedance.android.livesdkapi.depend.model.live.RoomPreloadStage;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.dtf.face.api.IDTResponseCode;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.batterymonitor.stragety.AbsBatteryStrategy;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class f {
    public static boolean B = true;
    public static String C = "";
    public static final Map<String, Long> D = null;
    public static final Map<String, Long> E = null;
    public static final Map<String, String> F = null;
    public String A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Long> f106438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f106439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f106440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f106441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f106442e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f106443f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f106444g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f106445h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f106446i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f106447j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f106448k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f106449l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f106450m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f106451n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f106452o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f106453p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f106454q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f106455r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f106456s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f106457t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f106458u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f106459v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f106460w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f106461x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f106462y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f106463z;

    static {
        D = new HashMap();
        E = new HashMap();
        F = new HashMap();
    }

    public final void e() {
        if (this.f106446i == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(this.f106451n) == true) goto L17;
        String r100 = (String) ((HashMap) F).get(this.f106451n);
        if (TextUtils.isEmpty(this.f106451n) == true) goto L17;
        Long r101 = (Long) ((HashMap) E).get(r100);
        if (r101 == null) goto L17;
        if (r101.longValue() < 0) goto L17;
        long r102 = System.currentTimeMillis() - r101.longValue();
    L19:
        if (TextUtils.isEmpty(this.f106451n) == true) goto L30;
        HashMap r103 = (HashMap) F;
        String r110 = (String) r103.get(this.f106451n);
        r103.remove(this.f106451n);
        if (TextUtils.isEmpty(r110) == true) goto L30;
        HashMap r104 = (HashMap) E;
        Long r111 = (Long) r104.get(r110);
        r104.remove(r110);
        if (r111 == null) goto L30;
        if (r111.longValue() < 0) goto L30;
        ((HashMap) this.f106438a).put(b("duration"), r111);
        ((HashMap) this.f106438a).put(b("innerDuration"), r111);
    L30:
        JSONObject r105 = new JSONObject();
        if (((HashMap) this.f106438a).isEmpty() == false) goto L33;
        long r112 = r102;
    L38:
        r105 = null;
    L49:
        if (r105 != null) goto L120;
        ((HashMap) this.f106438a).clear();
        return;
    L120:
        r105.put("room_id", Long.valueOf(this.f106445h));     // Catch: Exception -> L87
    L130:
        r105.put("enter_room_type", this.f106440c);     // Catch: Exception -> L88
    L106:
        r105.put("enter_room_merge_type", this.f106441d);     // Catch: Exception -> L89
    L100:
        r105.put("enter_room_method_type", this.f106442e);     // Catch: Exception -> L90
    L118:
        r105.put("enterRoomStage", Integer.valueOf(this.f106439b));     // Catch: Exception -> L91
    L126:
        r105.put("playerStatus", Integer.valueOf(this.f106444g));     // Catch: Exception -> L65
    L67:
        if (B == false) goto L69;
        int r106 = 1;
    L122:
        r105.put(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r106));     // Catch: Exception -> L92
    L114:
        r105.put(MonitorConstants.EXTRA_MONITOR_VERSION, EventConstant.Value.AUTH_VERSION_2);     // Catch: Exception -> L93
    L124:
        r105.put("stopDuration", Long.valueOf(this.f106447j));     // Catch: Exception -> L94
    L104:
        r105.put(MonitorConstants.EXTRA_MONITOR_VERSION, EventConstant.Value.AUTH_VERSION_2);     // Catch: Exception -> L95
    L110:
        r105.put("enter_room_sub_type", this.f106443f);     // Catch: Exception -> L96
    L112:
        r105.put("callback_duration", Long.valueOf(r112));     // Catch: Exception -> L81
    L82:
        long r107 = Long.valueOf(r105.optLong("duration", 0)).longValue();
        if (StringUtils.equal(this.f106440c, "slide") == false) goto L85;
        HashMap r108 = new HashMap();
        r108.put("enter_method", "slide");
        r108.put("enter_from_merge", this.f106441d);
        r108.put("duration", String.valueOf(this.f106450m + r107));
        ((IHostLog) jc1.k.f(IHostLog.class)).logV3("livesdk_slide_loading_time", r108);
    L85:
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_audience_enter_room_full_new_all", 0, r107, r105);
        ((HashMap) this.f106438a).clear();
        this.f106446i = true;
        B = false;
        return;
    L69:
        r106 = 2;
        goto L122
    L33:
        long r113 = a("duration");
        long r114 = a("innerDuration");
        long r115 = a("apiDuration");
        r112 = r102;
        long r109 = g(this.f106438a, h("apiDuration")) - g(this.f106438a, h("duration"));
        if (r109 > 0) goto L37;
        r109 = 0;
    L37:
        if (r113 < (0 + r115)) goto L38;
        r105.put("duration", Long.valueOf(r113));     // Catch: Exception -> L97
    L108:
        r105.put("innerDuration", Long.valueOf(r114));     // Catch: Exception -> L98
    L116:
        r105.put("apiDuration", Long.valueOf(r115));     // Catch: Exception -> L99
    L128:
        r105.put("beginToApiReDuration", Long.valueOf(r109));     // Catch: Exception -> L48
    L17:
        r102 = 0;
        goto L19
    }

    public final void i() {
        if (this.f106458u == true) goto L5;
        return;
    L5:
        if (this.f106457t == true) goto L8;
        return;
    L8:
        if (this.f106452o != 0) goto L10;
        long r100 = 0;
    L11:
        this.f106452o = 0;
        JSONObject r101 = new JSONObject();
        r101.put("user_feed_duration", Long.valueOf(r100));     // Catch: Exception -> L23
    L34:
        r101.put("room_id", Long.valueOf(this.f106445h));     // Catch: Exception -> L24
    L28:
        r101.put("enter_room_type", this.f106440c);     // Catch: Exception -> L25
    L36:
        r101.put("slide_opt_enable", Integer.valueOf(et.f120152a.getValue().booleanValue() ? 1 : 0));     // Catch: Exception -> L26
    L32:
        r101.put("multi_player_enable", Integer.valueOf(y3.f121651a.getValue().booleanValue() ? 1 : 0));     // Catch: Exception -> L27
    L21:
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_audience_enter_room_feel_time_all", 0, r100, r101);
        return;
    L10:
        r100 = System.currentTimeMillis() - this.f106452o;
        goto L11
    }

    public f() {
        this.f106438a = new HashMap(6);
        this.f106446i = false;
        this.f106447j = 0;
        this.f106448k = 0;
        this.f106449l = 0;
        this.f106450m = 0;
    }

    public static String b(String r100) {
        return r100 + "_end";
    }

    public static String h(String r100) {
        return r100 + "_start";
    }

    public final long a(String r100) {
        long r101 = g(this.f106438a, h(r100));
        long r102 = g(this.f106438a, b(r100)) - r101;
        if (r102 <= 0) goto L5;
        return r102;
    L5:
        return 0;
    }

    public final void d(String r100) {
        c(r100, false);
        if ("apiDuration".equals(r100) == false) goto L6;
        this.f106456s = System.currentTimeMillis();
        return;
    }

    public static long g(Map r100, String r101) {
        Long r102 = (Long) ((HashMap) r100).get(r101);
        if (r102 != null) goto L5;
        return 0;
    L5:
        return r102.longValue();
    }

    public final void c(String r100, boolean r101) {
        if (this.f106439b == 1) goto L5;
    L7:
        if (r101 == false) goto L9;
        String r102 = h(r100);
    L10:
        Map<String, Long> r103 = this.f106438a;
        HashMap r104 = (HashMap) r103;
        r104.put(r102, Long.valueOf(System.currentTimeMillis()));
        return;
    L9:
        r102 = b(r100);
        goto L10
    L5:
        if (TextUtils.equals(r100, "apiDuration") == false) goto L7;
    }

    public final void f(ls2.e r410, String r510, String r511, RoomSession r512, Bundle r513, e r514) {
        if (r410 != null) goto L5;
        return;
    L5:
        if (this.f106459v == true) goto L476;
        boolean r100 = r512.N;
        EndReason r101 = r410.getReasonV2();
        if (cn.f119965a.getValue().booleanValue() == false) goto L13;
        if (r100 == false) goto L13;
        if ((r101 instanceof EndReason.STOP_WITHOUT_RELEASE_PLAYER) == false) goto L13;
        return;
    L13:
        if ((r101 instanceof EndReason.FINAL_CLEANUP) == false) goto L17;
        if (r511 != null) goto L16;
        return;
    L16:
        if (r511.contains("DetailActivity") == true) goto L17;
        return;
    L17:
        int r102 = RoomNotFirstFrameHelper.f106433a;
        Intrinsics.checkNotNullParameter(r410, "roomError");
        EndReason r103 = r410.getReasonV2();
        if (Intrinsics.areEqual(r103, EndReason.PLAYER_ERROR.INSTANCE) == false) goto L21;
    L47:
        String r104 = "4003";
    L83:
        HashMap r105 = new HashMap();
        String r110 = "0";
        if (this.f106458u == false) goto L86;
        Object r106 = "1";
    L87:
        r105.put("is_first_frame_play", r106);
        r105.put("scene_error_code", r104);
        r105.put("room_id", String.valueOf(this.f106445h));
        r105.put("log_id", r510);
        if (this.f106458u == false) goto L102;
        String r107 = "2004";
        long r111 = this.f106453p;
        if (r111 <= 0) goto L96;
        String r210 = "9999";
        long r108 = this.f106454q;
        if (r108 > 0) goto L94;
    L97:
        long r109 = 0;
    L98:
        r105.put("duration", String.valueOf(r109));
        long r112 = this.f106455r - r513.getLong(ILiveRoomPlayFragmentConstant.EXTRA_USER_ACTION_ENTER_ROOM_START_TIME, -1);
        if (r112 >= 0) goto L101;
        r112 = 0;
    L101:
        r105.put("enter_room_duration", String.valueOf(r112));
    L109:
        Intrinsics.checkNotNullParameter(r105, "logParams");
        if (r513 == null) goto L113;
        long r211 = r513.getLong(ILiveRoomPlayFragmentConstant.EXTRA_USER_ACTION_ENTER_ROOM_START_TIME, -1);
        long r113 = r513.getLong(ILiveRoomPlayFragmentConstant.EXTRA_FEED_REQUEST_START_TIME);
        long r310 = r513.getLong(ILiveRoomPlayFragmentConstant.EXTRA_FEED_REQUEST_END_TIME);
        long r311 = r513.getLong(ILiveRoomPlayFragmentConstant.EXTRA_BEGIN_START_ACTIVITY_TIME);
        long r312 = r513.getLong(ILiveRoomPlayFragmentConstant.EXTRA_START_PULL_STREAM);
        long r313 = r513.getLong(ILiveRoomPlayFragmentConstant.EXTRA_ACTIVITY_ON_CREATE_TIME);
        long r314 = r513.getLong(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_ROOM_FRAGMENT_CREATE);
        long r411 = r513.getLong(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_PLAY_FRAGMENT_CREATE);
        long r412 = r513.getLong(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_PLAY_FRAGMENT_END);
        r105.put("duration_param_build", String.valueOf(r311 - r211));
        r105.put("duration_feed_request", String.valueOf(r310 - r113));
        r105.put("duration_start_page", String.valueOf(r313 - r311));
        r105.put("duration_page_init", String.valueOf(r314 - r313));
        r105.put("duration_room_container_build", String.valueOf(r411 - r314));
        r105.put("duration_play_container_build", String.valueOf(r412 - r411));
        r105.put("start_pull_stream", String.valueOf(r312));
        r105.put("duration_start_pull_stream", String.valueOf(System.currentTimeMillis() - r312));
    L113:
        Intrinsics.checkNotNullParameter(r105, "logParams");
        Bundle r114 = r512.getExtra();
        if (r114 == null) goto L116;
        String r115 = r114.getString("first_frame_block_info");
    L118:
        if (r115 == null) goto L152;
        JSONObject r116 = new JSONObject(r115);
        long r212 = r116.optLong("start_play_time", -1);
        long r315 = r116.optLong("sdk_dns_analysis_end", -1);
        long r316 = r116.optLong("player_dns_analysis_end", -1);
        long r317 = r116.optLong("tcp_connect_end", -1);
        long r318 = r116.optLong("tcp_first_package_end", -1);
        long r319 = r116.optLong("first_video_package_end", -1);
        long r413 = r116.optLong("first_video_frame_decode_end", -1);
        long r414 = r116.optLong("first_frame_render_end", -1);
        r105.put("retry_count", String.valueOf(r116.optInt("retry_count", -1)));
        if (r212 <= 0) goto L129;
        long r415 = System.currentTimeMillis() - r212;
        long r416 = r512.getExtra().getLong("client_pull_stream_time", -1);
        if (r416 <= 0) goto L128;
        long r117 = r212 - r416;
        if (r117 >= 0) goto L126;
        String r118 = "0";
    L127:
        r105.put("duration_player_start", r118);
        goto L128
    L126:
        r118 = String.valueOf(r117);
    L128:
        String r119 = "sdk_dns_analysis";
        long r213 = r415;
        long r120 = 0;
    L131:
        if (r315 <= r120) goto L134;
        r105.put("duration_sdk_dns", String.valueOf(r315 - r212));
        r213 = System.currentTimeMillis() - r315;
        r119 = "player_dns_analysis";
    L134:
        if (r316 <= r120) goto L137;
        r105.put("duration_player_dns", String.valueOf(r316 - r315));
        r213 = System.currentTimeMillis() - r316;
        r119 = "tcp_connect";
    L137:
        if (r317 <= r120) goto L140;
        r105.put("duration_tcp_connect", String.valueOf(r317 - r316));
        r213 = System.currentTimeMillis() - r317;
        r119 = "tcp_first_package";
    L140:
        if (r318 <= r120) goto L143;
        long r214 = r318 - r317;
        r105.put("duration_tcp_first_package", String.valueOf(r214));
        r213 = System.currentTimeMillis() - r214;
        r119 = "first_video_package";
    L143:
        if (r319 <= r120) goto L146;
        r105.put("duration_first_video_package", String.valueOf(r319 - r318));
        r213 = System.currentTimeMillis() - r319;
        r119 = "first_video_decode";
    L146:
        if (r413 <= r120) goto L148;
        r105.put("duration_first_video_decode", String.valueOf(r413 - r319));
        r213 = System.currentTimeMillis() - r413;
        r119 = "first_frame_render";
    L148:
        long r320 = r213;
        if (r414 <= r120) goto L151;
        r105.put("duration_first_frame_render", String.valueOf(r414 - r413));
        r320 = System.currentTimeMillis() - r414;
        r119 = "first_frame_ready";
    L151:
        r105.put("first_frame_current_section", r119);
        r105.put("first_frame_current_section_duration", String.valueOf(r320));
        r105.put("first_frame_total_duration", String.valueOf(r414 - r212));
        goto L152
    L129:
        r119 = "idel";
        r120 = 0;
        r213 = 0;
    L152:
        boolean r121 = this.f106458u;
        Intrinsics.checkNotNullParameter(r410, "roomError");
        Intrinsics.checkNotNullParameter(r105, "mLogParams");
        if ((r410.getReasonV2() instanceof EndReason.LIVE_END) == false) goto L155;
    L373:
        Object r321 = "1";
        Object r215 = "room_id";
        String r322 = ILiveRoomPlayFragmentConstant.EXTRA_LIVE_PRE_PULL_STREAM;
        String r323 = ILiveRoomPlayFragmentConstant.EXTRA_USER_ACTION_ENTER_ROOM_START_TIME;
        String r324 = "";
        String r122 = AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF;
    L375:
        if (r122.isEmpty() == true) goto L377;
        r105.put("scene_error_code_v2", r122);
    L377:
        r105.put(ILoadStallMonitor.MONITOR_DURATION, String.valueOf(System.currentTimeMillis() - this.f106453p));
        if (r513 == null) goto L380;
        r105.put("is_pre_pull_stream", String.valueOf(r513.getBoolean(r322, this.f106460w)));
        r105.put("position", String.valueOf(r513.getInt(ILiveRoomPlayFragmentConstant.EXTRA_DRAW_LIST_POSITION, 0)));
    L380:
        r105.put("stream_type", String.valueOf(r512.getStreamType().ordinal()));
        if (this.f106461x == false) goto L383;
        Object r123 = r321;
    L384:
        r105.put("has_share_player", r123);
        if (r512.O == false) goto L387;
        Object r124 = r321;
    L388:
        r105.put("request_share_player", r124);
        if (r512.P == false) goto L391;
        Object r125 = r321;
    L392:
        r105.put("has_preview_first_frame", r125);
        r105.put("enter_action", r512.Q);
        if (r512.R == false) goto L395;
        Object r126 = r321;
    L396:
        r105.put("is_return", r126);
        if (r512.f110610w == null) goto L399;
        String r127 = r512.f110610w.getVRType() + r324;
    L400:
        r105.put(VrBgLogData.KEY_VR_TYPE, r127);
        r105.put(IPerformanceManager.Stream.stream_cdn_ip, this.f106462y);
        r105.put(IPerformanceManager.Stream.stream_cdn_play_url, this.f106463z);
        r105.put("trigger_type", this.A);
        r105.put("enter_room_api_status", String.valueOf(r514.f106436a));
        r105.put("is_pre_enter", String.valueOf(r512.isPreEnter()));
        long r128 = r513.getLong(r323, -1);
        if (r514.f106436a != 2) goto L404;
        r105.put("duration_enter_room_api_cost", String.valueOf(this.f106456s - r128));
    L404:
        if (r514.f106436a != 1) goto L408;
        hl0.a r129 = r514.f106437b;
        if (r129 == null) goto L408;
        r105.put("enter_room_error_code", String.valueOf(r129.f485661a));
    L408:
        MiddlewareRoomContext r130 = MiddlewareRoomContext.getShared();
        if (r130 == null) goto L420;
        Map<String, String> r131 = r130.getEnterRoomParams().getValue();
        if (r131 == null) goto L419;
        String r132 = r131.get(r215);
        String r133 = r131.get("enter_api_time_stamp");
        String r134 = r131.get("enter_api_time_cost");
        if (TextUtils.equals(r132, String.valueOf(r512.getRoomId())) == false) goto L419;
        if (TextUtils.isEmpty(r133) == true) goto L419;
        if (TextUtils.isEmpty(r134) == true) goto L419;
        long r135 = CastLongProtector.parseLong(r133);
        r105.put("duration_enter_room_api_start", String.valueOf(r135 - r128));
        r105.put("duration_enter_room_api_net", r134);
        r105.put("duration_enter_room_api_invoke", String.valueOf((this.f106456s - r135) - CastLongProtector.parseLong(r134)));
    L419:
        r105.put("enter_api_socket_reuse", r131.get("enter_api_socket_reuse"));
    L420:
        this.f106456s = 0;
        Intrinsics.checkNotNullParameter(r105, "logMap");
        ILiveNetworkPredict r136 = (ILiveNetworkPredict) jc1.k.f(ILiveNetworkPredict.class);
        if (r136 == null) goto L423;
        r105.put("network_predict_net", String.valueOf(r136.obtainNetPredictValue()));
        r105.put("network_predict_stream", String.valueOf(r136.obtainStreamPredict()));
        r105.put("network_predict_synthesize", String.valueOf(r136.obtainSynthesizePredictValue()));
    L423:
        ITTNetNQEConfigHelper r137 = ((IHostApp) jc1.k.n(IHostApp.class)).getTTNetNQEConfigHelper();
        if (r137 != null) goto L473;
    L430:
        IAiService r138 = (IAiService) jc1.k.f(IAiService.class);
        if (r138 == null) goto L433;
        r138.getHarService();
    L433:
        Intrinsics.checkNotNullParameter(r105, "logMap");
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == false) goto L436;
        Object r139 = r321;
    L437:
        r105.put("enable_room_preload", r139);
        DataCenter r140 = r512.getDataCenter();
        if (r140 == null) goto L443;
        RoomPreloadStage r141 = z.p(r140);
        if (r141 == null) goto L443;
        String r142 = String.valueOf(r141.preloadStage());
        if (r142 == null) goto L443;
    L444:
        r105.put("room_preload_stage", r142);
        DataCenter r143 = r512.getDataCenter();
        if (r143 == null) goto L450;
        RoomPreloadStage r144 = z.p(r143);
        if (r144 == null) goto L450;
        String r145 = String.valueOf(r144.roomApiStage());
        if (r145 == null) goto L450;
    L451:
        r105.put("room_preload_api_stage", r145);
        DataCenter r146 = r512.getDataCenter();
        if (r146 == null) goto L457;
        RoomPreloadStage r147 = z.p(r146);
        if (r147 == null) goto L457;
        String r148 = String.valueOf(r147.backendApiStage());
        if (r148 == null) goto L457;
    L458:
        r105.put("room_backend_api_stage", r148);
        DataCenter r149 = r512.getDataCenter();
        if (r149 == null) goto L466;
        RoomPreloadStage r150 = z.p(r149);
        if (r150 == null) goto L466;
        String r151 = String.valueOf(r150.lastEnterRoom2PreloadCost());
        if (r151 == null) goto L466;
        r110 = r151;
    L466:
        r105.put("last_enter_to_preload_start_time", r110);
        this.f106454q = 0;
        this.f106455r = 0;
        this.f106453p = 0;
        this.f106460w = false;
        this.f106459v = true;
        u.l().sendLog("livesdk_first_frame_duration", r105, new Object[]{new x(), am2.n.f(), Room.class});
        ILiveNetworkPredict r152 = (ILiveNetworkPredict) jc1.k.f(ILiveNetworkPredict.class);
        if (r152 != null) goto L469;
        return;
    L469:
        if (this.f106458u == false) goto L471;
        r152.onStreamOvv(-1, "draw has first frame");
        return;
    L471:
        r152.onStreamOvv(0, "draw 0vv");
        return;
    L457:
        r148 = "0";
    L450:
        r145 = "0";
    L443:
        r142 = "0";
        goto L444
    L436:
        r139 = "0";
        goto L437
    L473:
        TTNetNetworkQuality r153 = r137.getNetworkQuality();     // Catch: Exception -> L427
        r105.put("network_quality", String.valueOf(r137.getEffectiveConnectionType()));     // Catch: Exception -> L427
        r105.put("httpRtt", String.valueOf(r153.getHttpRtt()));     // Catch: Exception -> L427
        r105.put("transportRtt", String.valueOf(r153.getTransportRtt()));     // Catch: Exception -> L427
        r105.put("downstream_throughput", String.valueOf(r153.getDownstreamThroughput()));     // Catch: Exception -> L427
    L429:
        r105.put("video_download_speed", String.valueOf(r137.getAverageSpeedInKBps()));
    L427:
        e = move-exception;
        e.printStackTrace();
        Objects.toString(Unit.INSTANCE);
        goto L429
    L399:
        r127 = r324;
        goto L400
    L395:
        r126 = "0";
        goto L396
    L391:
        r125 = "0";
        goto L392
    L387:
        r124 = "0";
        goto L388
    L383:
        r123 = "0";
        goto L384
    L155:
        if ((r410.getReasonV2() instanceof EndReason.LIVE_END_NO_INTERCEPT) == true) goto L373;
        Bundle r154 = r512.getExtra();
        if (r154 == null) goto L161;
        String r155 = r154.getString("has_player_View");
        if (r155 == null) goto L161;
    L162:
        r105.put("has_player_View", r155);
        Bundle r156 = r512.getExtra();
        if (r156 == null) goto L166;
        String r157 = r156.getString("visible_check_player_view");
        if (r157 == null) goto L166;
    L167:
        r105.put("visible_check_player_view", r157);
        Bundle r158 = r512.getExtra();
        if (r158 == null) goto L171;
        String r159 = r158.getString("visible_check_render_view");
        if (r159 == null) goto L171;
    L172:
        r105.put("visible_check_render_view", r159);
        Bundle r160 = r512.getExtra();
        if (r160 == null) goto L176;
        String r161 = r160.getString("render_view_visible");
        if (r161 == null) goto L176;
    L177:
        r105.put("render_view_visible", r161);
        Bundle r162 = r512.getExtra();
        if (r162 == null) goto L181;
        String r163 = r162.getString("render_view_position");
        if (r163 == null) goto L181;
    L182:
        r105.put("render_view_position", r163);
        boolean r164 = Intrinsics.areEqual((String) r105.get("render_view_visible"), "1");
        boolean r165 = Intrinsics.areEqual((String) r105.get("render_view_position"), "1");
        if (r164 == false) goto L186;
        if (r165 == false) goto L186;
        boolean r166 = true;
    L187:
        Bundle r167 = r512.getExtra();
        if (r167 == null) goto L190;
        String r168 = r167.getString("stream_cover");
    L191:
        boolean r169 = Intrinsics.areEqual(r168, "1");
        r215 = "room_id";
        if (r169 == false) goto L194;
        Object r170 = "1";
    L195:
        r105.put("stream_cover", r170);
        Bundle r171 = r512.getExtra();
        if (r171 == null) goto L199;
        String r172 = r171.getString("surface_available");
        if (r172 == null) goto L199;
    L200:
        r105.put("surface_available", r172);
        Bundle r173 = r512.getExtra();
        r323 = ILiveRoomPlayFragmentConstant.EXTRA_USER_ACTION_ENTER_ROOM_START_TIME;
        if (r173 == null) goto L204;
        String r174 = r173.getString("surface_bind");
        if (r174 == null) goto L204;
    L205:
        r105.put("surface_bind", r174);
        Bundle r175 = r512.getExtra();
        if (r175 == null) goto L209;
        String r176 = r175.getString("same_surface");
        if (r176 == null) goto L209;
    L210:
        r105.put("same_surface", r176);
        Bundle r177 = r512.getExtra();
        r324 = "";
        if (r177 == null) goto L214;
        String r178 = r177.getString("live_player_state");
        if (r178 == null) goto L214;
    L215:
        r105.put("live_player_state", r178);
        Bundle r179 = r512.getExtra();
        if (r179 == null) goto L219;
        String r180 = r179.getString("player_state");
        if (r180 == null) goto L219;
    L220:
        r105.put("player_state", r180);
        if (Intrinsics.areEqual("1", (String) r105.get("surface_available")) == true) goto L223;
    L225:
        boolean r181 = false;
    L226:
        Bundle r182 = r512.getExtra();
        r321 = "1";
        if (r182 == null) goto L230;
        String r183 = r182.getString("has_player_client");
        if (r183 == null) goto L230;
    L231:
        r105.put("has_player_client", r183);
        Bundle r184 = r512.getExtra();
        if (r184 == null) goto L235;
        String r185 = r184.getString("client_state_playing");
        if (r185 == null) goto L235;
    L236:
        r105.put("client_state_playing", r185);
        Bundle r186 = r512.getExtra();
        if (r186 == null) goto L240;
        String r187 = r186.getString("client_state_release");
        if (r187 == null) goto L240;
    L241:
        r105.put("client_state_release", r187);
        Bundle r188 = r512.getExtra();
        if (r188 == null) goto L245;
        String r189 = r188.getString("client_state_stopped");
        if (r189 == null) goto L245;
    L246:
        r105.put("client_state_stopped", r189);
        Bundle r190 = r512.getExtra();
        if (r190 == null) goto L250;
        String r191 = r190.getString("client_state_startPullStream");
        if (r191 == null) goto L250;
    L251:
        r105.put("client_state_startPullStream", r191);
        Bundle r192 = r512.getExtra();
        if (r192 == null) goto L255;
        String r193 = r192.getString("ttlive_player");
        if (r193 == null) goto L255;
    L256:
        r105.put("ttlive_player", r193);
        Bundle r194 = r512.getExtra();
        if (r194 == null) goto L260;
        String r195 = r194.getString("video_live_manager");
        if (r195 == null) goto L260;
    L261:
        r105.put("video_live_manager", r195);
        Bundle r196 = r512.getExtra();
        r322 = ILiveRoomPlayFragmentConstant.EXTRA_LIVE_PRE_PULL_STREAM;
        if (r196 == null) goto L265;
        String r197 = r196.getString("client_stream_played");
        if (r197 == null) goto L265;
    L266:
        r105.put("client_stream_played", r197);
        Bundle r198 = r512.getExtra();
        if (r198 == null) goto L270;
        String r199 = r198.getString("video_live_manager");
        if (r199 == null) goto L270;
    L271:
        r105.put("video_live_manager", r199);
        Bundle r200 = r512.getExtra();
        if (r200 == null) goto L275;
        String r201 = r200.getString("client_stream_played");
        if (r201 == null) goto L275;
    L276:
        r105.put("client_stream_played", r201);
        Bundle r202 = r512.getExtra();
        if (r202 == null) goto L280;
        String r203 = r202.getString("duration_client_stream_play");
        if (r203 == null) goto L280;
    L281:
        r105.put("duration_client_stream_play", r203);
        Bundle r204 = r512.getExtra();
        if (r204 == null) goto L285;
        String r205 = r204.getString("duration_client_start_pull_stream");
        if (r205 == null) goto L285;
    L286:
        r105.put("duration_client_start_pull_stream", r205);
        Bundle r206 = r512.getExtra();
        if (r206 == null) goto L290;
        String r207 = r206.getString("render_view_translationX");
        if (r207 == null) goto L290;
    L291:
        r105.put("render_view_translationX", r207);
        Bundle r208 = r512.getExtra();
        if (r208 == null) goto L295;
        String r209 = r208.getString("render_view_translationY");
        if (r209 == null) goto L295;
    L296:
        r105.put("render_view_translationY", r209);
        Bundle r216 = r512.getExtra();
        if (r216 == null) goto L300;
        String r217 = r216.getString("player_view_translationX");
        if (r217 == null) goto L300;
    L301:
        r105.put("player_view_translationX", r217);
        Bundle r218 = r512.getExtra();
        if (r218 == null) goto L305;
        String r219 = r218.getString("player_view_translationY");
        if (r219 == null) goto L305;
    L306:
        r105.put("player_view_translationY", r219);
        if (r166 == false) goto L313;
        if (r169 == false) goto L313;
        if (r181 == false) goto L313;
        if (r121 == false) goto L313;
        boolean r220 = false;
    L314:
        if (r220 == false) goto L316;
        Object r221 = r321;
    L317:
        r105.put("is_no_stream", r221);
        if (r220 == false) goto L372;
        if (r121 == false) goto L335;
        if (Intrinsics.areEqual((String) r105.get("render_view_position"), "0") == false) goto L324;
        String r1100 = AbsBatteryStrategy.AppBg5mCombination.APP_BG_5M__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF_3M;
    L333:
        r122 = r1100;
        goto L375
    L324:
        if (Intrinsics.areEqual((String) r105.get("render_view_visible"), "0") == false) goto L327;
        r1100 = IDTResponseCode.ZIM_RESPONSE_CLIENT_TIME_INVALID;
        goto L333
    L327:
        if (Intrinsics.areEqual((String) r105.get("same_surface"), "0") == false) goto L330;
        r1100 = r107;
        goto L333
    L330:
        if (Intrinsics.areEqual((String) r105.get("surface_available"), "0") == false) goto L332;
        r1100 = AbsBatteryStrategy.AppBg5mCombination.APP_BG_5M__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF;
        goto L333
    L332:
        r1100 = r210;
        goto L333
    L335:
        if ((r410.getReasonV2() instanceof EndReason.LIVE_END) == false) goto L337;
    L370:
        String r1101 = AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF;
    L371:
        r122 = r1101;
        goto L375
    L337:
        if ((r410.getReasonV2() instanceof EndReason.LIVE_END_NO_INTERCEPT) == true) goto L370;
        if ((r410.getReasonV2() instanceof EndReason.EMPTY_URL) == false) goto L342;
        r1101 = "1003";
        goto L371
    L342:
        Bundle r222 = r512.getExtra();
        if (r222 == null) goto L345;
        String r223 = r222.getString("error_code");
    L346:
        if (r223 != null) goto L348;
    L359:
        Bundle r224 = r512.getExtra();
        if (r224 == null) goto L362;
        String r225 = r224.getString("live_player_state");
    L364:
        if (Intrinsics.areEqual(r225, "PLAYED") == false) goto L366;
        r1101 = "1005";
        goto L371
    L366:
        ILivePlayerClient r226 = r512.m();
        if (r226 == null) goto L369;
        r226.checkAsyncStreamException();
    L369:
        r1101 = AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF_3M;
        goto L371
    L362:
        r225 = null;
        goto L364
    L348:
        if (r223.length() <= 0) goto L350;
        boolean r227 = true;
    L352:
        if (r227 != true) goto L359;
        r105.put("pull_stream_error_code", r223);
        Bundle r228 = r512.getExtra();
        if (r228 == null) goto L357;
        String r229 = r228.getString("error_description");
        if (r229 == null) goto L357;
    L358:
        r105.put("pull_stream_error_reason", r229);
        r1101 = "4003";
    L357:
        r229 = r324;
        goto L358
    L350:
        r227 = false;
        goto L352
    L345:
        r223 = null;
        goto L346
    L372:
        r122 = r324;
        goto L375
    L316:
        r221 = "0";
    L313:
        r220 = true;
    L305:
        r219 = r324;
    L300:
        r217 = r324;
    L295:
        r209 = r324;
    L290:
        r207 = r324;
    L285:
        r205 = r324;
    L280:
        r203 = r324;
    L275:
        r201 = r324;
    L270:
        r199 = r324;
    L265:
        r197 = r324;
    L260:
        r195 = r324;
    L255:
        r193 = r324;
    L250:
        r191 = r324;
    L245:
        r189 = r324;
    L240:
        r187 = r324;
    L235:
        r185 = r324;
    L230:
        r183 = r324;
        goto L231
    L223:
        if (Intrinsics.areEqual("1", (String) r105.get("same_surface")) == false) goto L225;
        r181 = true;
    L219:
        r180 = r324;
    L214:
        r178 = r324;
    L209:
        r176 = "";
    L204:
        r174 = "";
    L199:
        r172 = "";
        goto L200
    L194:
        r170 = "0";
        goto L195
    L190:
        r168 = null;
    L186:
        r166 = false;
    L181:
        r163 = "";
    L176:
        r161 = "";
    L171:
        r159 = "";
    L166:
        r157 = "";
    L161:
        r155 = "";
        goto L162
    L116:
        r115 = null;
        goto L118
    L94:
        if (r108 <= r111) goto L97;
        r109 = r108 - r111;
        goto L98
    L96:
        r210 = "9999";
        goto L97
    L102:
        r210 = "9999";
        r107 = "2004";
        if (this.f106453p != 0) goto L105;
        long r230 = 0;
    L106:
        r105.put("exit_duration", String.valueOf(r230));
        boolean r231 = this.f106460w;
        if (r231 == false) goto L109;
        r513.putBoolean(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_PRE_PULL_STREAM, r231);
        goto L109
    L105:
        r230 = System.currentTimeMillis() - this.f106453p;
        goto L106
    L86:
        r106 = "0";
        goto L87
    L21:
        if (Intrinsics.areEqual(r103, EndReason.ENTER_FAILED.INSTANCE) == false) goto L41;
        int r232 = r410.getErrorCode();
        if (r232 != 208) goto L25;
        r104 = "1005";
        goto L83
    L25:
        if (r232 != 4003063) goto L27;
        r104 = "3002";
        goto L83
    L27:
        if (r232 != 30005) goto L29;
        r104 = "3001";
        goto L83
    L29:
        if (r232 == 30006) goto L35;
        switch(r232) {
            case 127: goto L36;
            case 128: goto L33;
            case 129: goto L32;
            default: goto L31;
        };
    L31:
        r104 = "4001";
        goto L83
    L32:
        r104 = "2007";
        goto L83
    L33:
        r104 = "2006";
    L36:
        r104 = "2005";
        goto L83
    L35:
        if (StringsKt.contains$default(r410.getErrPromptV2(), "私密", false, 2, null) == true) goto L36;
    L56:
        r104 = AbsBatteryStrategy.AppBg5mCombination.APP_BG_5M__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF;
        goto L83
    L41:
        if ((r103 instanceof EndReason.LIVE_END) == false) goto L43;
    L82:
        r104 = "5001";
        goto L83
    L43:
        if ((r103 instanceof EndReason.LIVE_END_NO_INTERCEPT) == true) goto L82;
        if ((r103 instanceof EndReason.FETCH_FAILED) == true) goto L47;
        if ((r103 instanceof EndReason.LIVE_DISTRIBUTION_EXIT) == false) goto L52;
    L65:
        r104 = "1006";
        goto L83
    L52:
        if (Intrinsics.areEqual(r103, EndReason.EMPTY_URL.INSTANCE) == false) goto L55;
        r104 = "4002";
        goto L83
    L55:
        if (Intrinsics.areEqual(r103, EndReason.PING_KICK_OUT.INSTANCE) == true) goto L56;
        if (Intrinsics.areEqual(r103, EndReason.AUDIENCE_BAN.INSTANCE) == false) goto L61;
        r104 = IDTResponseCode.ZIM_RESPONSE_CLIENT_TIME_INVALID;
        goto L83
    L61:
        if (Intrinsics.areEqual(r103, EndReason.WATCHER_KIT_OUT.INSTANCE) == false) goto L64;
        r104 = "2004";
        goto L83
    L64:
        if (Intrinsics.areEqual(r103, EndReason.DETAIL_SCROLL.INSTANCE) == true) goto L65;
        if (Intrinsics.areEqual(r103, EndReason.JUMP_TO_OTHER.INSTANCE) == false) goto L69;
    L81:
        r104 = "1004";
        goto L83
    L69:
        if (Intrinsics.areEqual(r103, EndReason.JUMP_TO_OTHER_MIX_ROOM.INSTANCE) == true) goto L81;
        if (Intrinsics.areEqual(r103, EndReason.USER_CLOSE.INSTANCE) == false) goto L75;
        r104 = AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF;
        goto L83
    L75:
        if (Intrinsics.areEqual(r103, EndReason.USER_KICK_OUT.INSTANCE) == false) goto L78;
        r104 = AbsBatteryStrategy.AppBg5mCombination.APP_BG_5M__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF_3M;
        goto L83
    L78:
        if (Intrinsics.areEqual(r103, EndReason.STOP_WITHOUT_RELEASE_PLAYER.INSTANCE) == false) goto L80;
        r104 = "1003";
        goto L83
    L80:
        r104 = "9999";
        goto L83
    }
}
