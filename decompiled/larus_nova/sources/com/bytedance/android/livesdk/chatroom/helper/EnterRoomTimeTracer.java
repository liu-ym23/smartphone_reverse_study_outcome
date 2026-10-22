package com.bytedance.android.livesdk.chatroom.helper;

import am2.x;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.status.api.IAggregateService;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.m0;
import com.bytedance.android.livesdk.config.ou;
import com.bytedance.android.livesdk.config.pa1;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.landscape.LandscapeLiveMonitor;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdk.utils.v5;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.paid.PaidReplayConstants;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.service.IHotRoomManager;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.alog.middleware.ALogService;
import com.ss.android.common.applog.AppLog;
import com.ss.ttvideoengine.portrait.PortraitEngine;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class EnterRoomTimeTracer extends BaseMonitor {
    public static Boolean L;
    public String A;
    public int B;
    public Boolean C;
    public Integer D;
    public Boolean E;
    public Integer F;
    public Integer G;
    public Integer H;
    public Integer I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f106373J;
    public Long K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f106374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f106375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f106376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, String> f106377d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public JSONObject f106378e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SparseArray<a> f106379f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f106380g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f106381h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f106382i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f106383j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f106384k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f106385l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f106386m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f106387n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f106388o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Map<String, String> f106389p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f106390q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f106391r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f106392s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f106393t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f106394u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f106395v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f106396w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f106397x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f106398y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f106399z;

    public static final enum EventName extends Enum<EventName> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EventName[] f106400a = null;
        public static final EventName end_p0_widget_load = null;
        public static final EventName end_request_feed = null;
        public static final EventName end_request_room = null;
        public static final EventName end_setup = null;
        public static final EventName first_frame = null;
        public static final EventName play_container_build = null;
        public static final EventName play_container_end = null;
        public static final EventName playing = null;
        public static final EventName render_view_bind = null;
        public static final EventName render_view_surface_ready = null;
        public static final EventName room_container_build = null;
        public static final EventName start_enter_room = null;
        public static final EventName start_pull_stream = null;
        public static final EventName start_request_feed = null;
        public static final EventName start_request_room = null;
        public static final EventName start_setup = null;
        public static final EventName stream_audio_device_open_end = null;
        public static final EventName stream_audio_device_open_start = null;
        public static final EventName stream_find_stream_info_end = null;
        public static final EventName stream_find_stream_info_start = null;
        public static final EventName stream_first_audio_frame_decode_end = null;
        public static final EventName stream_first_audio_package_end = null;
        public static final EventName stream_first_frame_from_player_core = null;
        public static final EventName stream_first_frame_render_end = null;
        public static final EventName stream_first_video_frame_decode_end = null;
        public static final EventName stream_first_video_package_end = null;
        public static final EventName stream_player_dns_analysis_end = null;
        public static final EventName stream_prepare_block_end = null;
        public static final EventName stream_prepare_end = null;
        public static final EventName stream_sdk_dns_analysis_end = null;
        public static final EventName stream_set_surface_time = null;
        public static final EventName stream_start = null;
        public static final EventName stream_tcp_connect_end = null;
        public static final EventName stream_tcp_first_package_end = null;
        public static final EventName stream_tfo_fall_back_time = null;
        public static final EventName stream_video_device_open_end = null;
        public static final EventName stream_video_device_open_start = null;
        public static final EventName stream_video_device_wait_end = null;
        public static final EventName stream_video_device_wait_start = null;
        public static final EventName surface_control_first_frame = null;
        public static final EventName touch_up_click = null;
        public static final EventName vs_video_player_try_play = null;

        static {
            EventName r100 = new EventName("touch_up_click", 0);
            touch_up_click = r100;
            EventName r101 = new EventName("start_enter_room", 1);
            start_enter_room = r101;
            EventName r102 = new EventName("start_request_feed", 2);
            start_request_feed = r102;
            EventName r103 = new EventName("end_request_feed", 3);
            end_request_feed = r103;
            EventName r104 = new EventName("start_request_room", 4);
            start_request_room = r104;
            EventName r105 = new EventName("end_request_room", 5);
            end_request_room = r105;
            EventName r110 = new EventName("start_setup", 6);
            start_setup = r110;
            EventName r111 = new EventName("end_setup", 7);
            end_setup = r111;
            EventName r112 = new EventName("room_container_build", 8);
            room_container_build = r112;
            EventName r113 = new EventName("play_container_build", 9);
            play_container_build = r113;
            EventName r114 = new EventName("play_container_end", 10);
            play_container_end = r114;
            EventName r115 = new EventName("start_pull_stream", 11);
            start_pull_stream = r115;
            EventName r106 = new EventName(PortraitEngine.LABEL_FIRST_FRAME, 12);
            first_frame = r106;
            EventName r107 = new EventName("playing", 13);
            playing = r107;
            EventName r108 = new EventName("stream_start", 14);
            stream_start = r108;
            EventName r109 = new EventName("stream_sdk_dns_analysis_end", 15);
            stream_sdk_dns_analysis_end = r109;
            EventName r116 = new EventName("end_p0_widget_load", 16);
            end_p0_widget_load = r116;
            EventName r117 = new EventName("stream_prepare_block_end", 17);
            stream_prepare_block_end = r117;
            EventName r118 = new EventName("stream_player_dns_analysis_end", 18);
            stream_player_dns_analysis_end = r118;
            EventName r119 = new EventName("stream_tfo_fall_back_time", 19);
            stream_tfo_fall_back_time = r119;
            EventName r120 = new EventName("stream_tcp_connect_end", 20);
            stream_tcp_connect_end = r120;
            EventName r121 = new EventName("stream_tcp_first_package_end", 21);
            stream_tcp_first_package_end = r121;
            EventName r122 = new EventName("stream_first_video_package_end", 22);
            stream_first_video_package_end = r122;
            EventName r123 = new EventName("stream_first_audio_package_end", 23);
            stream_first_audio_package_end = r123;
            EventName r124 = new EventName("stream_first_video_frame_decode_end", 24);
            stream_first_video_frame_decode_end = r124;
            EventName r125 = new EventName("stream_first_audio_frame_decode_end", 25);
            stream_first_audio_frame_decode_end = r125;
            EventName r126 = new EventName("stream_first_frame_from_player_core", 26);
            stream_first_frame_from_player_core = r126;
            EventName r127 = new EventName("stream_first_frame_render_end", 27);
            stream_first_frame_render_end = r127;
            EventName r128 = new EventName("stream_video_device_open_start", 28);
            stream_video_device_open_start = r128;
            EventName r129 = new EventName("stream_video_device_open_end", 29);
            stream_video_device_open_end = r129;
            EventName r130 = new EventName("stream_audio_device_open_start", 30);
            stream_audio_device_open_start = r130;
            EventName r131 = new EventName("stream_audio_device_open_end", 31);
            stream_audio_device_open_end = r131;
            EventName r132 = new EventName("stream_prepare_end", 32);
            stream_prepare_end = r132;
            EventName r133 = new EventName("stream_set_surface_time", 33);
            stream_set_surface_time = r133;
            EventName r134 = new EventName("stream_video_device_wait_start", 34);
            stream_video_device_wait_start = r134;
            EventName r135 = new EventName("stream_video_device_wait_end", 35);
            stream_video_device_wait_end = r135;
            EventName r136 = new EventName("stream_find_stream_info_start", 36);
            stream_find_stream_info_start = r136;
            EventName r137 = new EventName("stream_find_stream_info_end", 37);
            stream_find_stream_info_end = r137;
            EventName r138 = new EventName("vs_video_player_try_play", 38);
            vs_video_player_try_play = r138;
            EventName r139 = new EventName("render_view_bind", 39);
            render_view_bind = r139;
            EventName r140 = new EventName("render_view_surface_ready", 40);
            render_view_surface_ready = r140;
            EventName r141 = new EventName("surface_control_first_frame", 41);
            surface_control_first_frame = r141;
            f106400a = new EventName[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141};
        }

        public static EventName[] values() {
            return (EventName[]) f106400a.clone();
        }

        public static EventName valueOf(String r100) {
            return (EventName) r27.a.a(EventName.class, r100);
        }

        public EventName(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f106401a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f106402b;

        public final String toString() {
            return "Event: " + this.f106401a + " : " + this.f106402b + "\n";
        }

        public a(String r100, long r101) {
            this.f106401a = r100;
            this.f106402b = r101;
        }
    }

    public final void p() {
        this.f106376c = false;
        this.f106379f.clear();
        this.f106375b = 0;
        this.f106377d = null;
        this.f106378e = null;
        this.f106374a = null;
        this.f106381h = false;
        this.f106383j = false;
        this.f106382i = false;
        this.f106384k = null;
        this.f106395v = null;
        this.f106386m = false;
        this.f106387n = false;
        this.f106390q = false;
        this.f106392s = 0;
        this.f106393t = 0;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.K = null;
    }

    static {
        L = Boolean.TRUE;
    }

    public EnterRoomTimeTracer() {
        this.f106376c = false;
        this.f106379f = new SparseArray();
        this.f106380g = false;
    }

    public final void l(EventName r100) {
        m(r100, System.currentTimeMillis());
    }

    public final void q(Bundle r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.f106376c == true) goto L47;
        Bundle r101 = m0.a(r100);
        if (r101 != null) goto L9;
    L11:
        long r102 = r100.getLong(ILiveRoomPlayFragmentConstant.EXTRA_USER_ACTION_ENTER_ROOM_START_TIME, -1);
        String r103 = r100.getString(ILiveRoomPlayFragmentConstant.EXTRA_USER_ACTION_ENTER_ROOM_TYPE, "");
        ALogger.i("ROOM_PRELOAD", "startTrace  roomId : " + r100.getLong(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_ID, -1) + " start : " + r102);
        if (r102 >= 0) goto L14;
        return;
    L14:
        if (TextUtils.isEmpty(r103) == true) goto L48;
        this.f106376c = true;
        if (this.f106379f.get(EventName.playing.ordinal()) != null) goto L19;
        this.f106379f.clear();
    L19:
        this.f106375b = r102;
        this.f106374a = r103;
        long r104 = r100.getLong(ILiveRoomPlayFragmentConstant.EXTRA_USER_ACTION_ENTER_ROOM_TOUCH_UP_START_TIME);
        if (r104 <= 0) goto L22;
        m(EventName.touch_up_click, r104);
    L22:
        m(EventName.start_enter_room, r102);
        m(EventName.start_request_feed, r100.getLong(ILiveRoomPlayFragmentConstant.EXTRA_FEED_REQUEST_START_TIME));
        m(EventName.end_request_feed, r100.getLong(ILiveRoomPlayFragmentConstant.EXTRA_FEED_REQUEST_END_TIME));
        m(EventName.start_request_room, r100.getLong(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_REQUEST_START_TIME));
        m(EventName.end_request_room, r100.getLong(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_REQUEST_END_TIME));
        m(EventName.start_setup, r100.getLong(ILiveRoomPlayFragmentConstant.EXTRA_BEGIN_START_ACTIVITY_TIME));
        m(EventName.start_pull_stream, r100.getLong(ILiveRoomPlayFragmentConstant.EXTRA_START_PULL_STREAM));
        m(EventName.end_setup, r100.getLong(ILiveRoomPlayFragmentConstant.EXTRA_ACTIVITY_ON_CREATE_TIME));
        m(EventName.room_container_build, r100.getLong(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_ROOM_FRAGMENT_CREATE));
        m(EventName.play_container_build, r100.getLong(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_PLAY_FRAGMENT_CREATE));
        m(EventName.play_container_end, r100.getLong(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_PLAY_FRAGMENT_END));
        this.f106381h = r100.getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_PRE_PULL_STREAM, this.f106381h);
        this.f106383j = r100.getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_SCHEMA_ENTER_REQUEST_PULL, this.f106383j);
        this.f106382i = r100.getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_HAS_STREAM_ADDR, this.f106382i);
        this.f106384k = String.valueOf(LiveMode.Companion.valueOf(r100.getInt(ILiveRoomPlayFragmentConstant.EXTRA_STREAM_TYPE, 0)).ordinal());
        this.f106388o = r100.getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_IS_HIT_CACHE, false);
        this.f106391r = r100.getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_IS_SURFACEVIEW, false);
        if (r100.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_NUM) == false) goto L26;
        this.D = Integer.valueOf(r100.getInt(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_NUM, 0));
        r100.remove(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_NUM);
    L26:
        if (r100.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_AUTO_ENTER) == false) goto L29;
        this.E = Boolean.valueOf(r100.getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_AUTO_ENTER, false));
        r100.remove(ILiveRoomPlayFragmentConstant.EXTRA_AUTO_ENTER);
    L29:
        if (r100.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_IS_FROM_PREVIEW) == false) goto L32;
        this.F = Integer.valueOf(r100.getInt(ILiveRoomPlayFragmentConstant.EXTRA_IS_FROM_PREVIEW, 0));
        r100.remove(ILiveRoomPlayFragmentConstant.EXTRA_IS_FROM_PREVIEW);
    L32:
        if (r100.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_IS_ENTER_FROM_OTHER_CHANNEL) == false) goto L35;
        this.G = Integer.valueOf(r100.getInt(ILiveRoomPlayFragmentConstant.EXTRA_IS_ENTER_FROM_OTHER_CHANNEL, 0));
        r100.remove(ILiveRoomPlayFragmentConstant.EXTRA_IS_ENTER_FROM_OTHER_CHANNEL);
    L35:
        if (r100.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_IS_PLUGIN_INSTALL) == false) goto L38;
        this.H = Integer.valueOf(r100.getInt(ILiveRoomPlayFragmentConstant.EXTRA_IS_PLUGIN_INSTALL, 0));
        r100.remove(ILiveRoomPlayFragmentConstant.EXTRA_IS_PLUGIN_INSTALL);
    L38:
        if (r100.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_IS_PLUGIN_LOAD) == false) goto L41;
        this.I = Integer.valueOf(r100.getInt(ILiveRoomPlayFragmentConstant.EXTRA_IS_PLUGIN_LOAD, 0));
        r100.remove(ILiveRoomPlayFragmentConstant.EXTRA_IS_PLUGIN_LOAD);
    L41:
        if (r100.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_TRY_ENTER_ROOM_TIME) == false) goto L46;
        this.K = Long.valueOf(r100.getLong(ILiveRoomPlayFragmentConstant.EXTRA_TRY_ENTER_ROOM_TIME, 0));
        r100.remove(ILiveRoomPlayFragmentConstant.EXTRA_TRY_ENTER_ROOM_TIME);
        return;
    L46:
        return;
    L48:
        return;
    L9:
        if (r101.getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_IS_BACK_PRE_ROOM_NOW, false) == false) goto L11;
        return;
    }

    public final void m(EventName r100, long r101) {
        if (r101 > 0) goto L5;
        return;
    L5:
        if (r100 == EventName.touch_up_click) goto L10;
        if (r101 >= this.f106375b) goto L10;
        return;
    L10:
        if (this.f106379f.get(r100.ordinal()) == null) goto L12;
        return;
    L12:
        ALogger.i("ROOM_PRELOAD", "addEvent  eventName : " + r100 + " timestamp : " + r101);
        this.f106379f.put(r100.ordinal(), new a(r100.toString(), r101));
    }

    public final long o(EventName r110, EventName r111) {
        a r112 = this.f106379f.get(r110.ordinal());
        a r113 = this.f106379f.get(r111.ordinal());
        if (r112 == null) goto L14;
        if (r113 == null) goto L16;
        long r100 = r112.f106402b;
        if (r100 <= 0) goto L17;
        long r114 = r113.f106402b;
        if (r114 > 0) goto L10;
        return -1;
    L10:
        if ((r114 - r100) <= 3600000) goto L13;
        return -1;
    L13:
        return Math.max(r114 - r100, 0);
    L17:
        return -1;
    L16:
        return -1;
    L14:
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r18v0, types: [java.io.BufferedWriter] */
    public final void n(long r210, Map<String, String> r211, ILivePlayerClient r212) {
        if (this.f106376c == true) goto L5;
        return;
    L5:
        this.f106376c = false;
        if (this.f106380g == true) goto L12;
        if (r212 == null) goto L12;
        JSONObject r100 = r212.getFirstFrameBlockInfo();
        if (r100 == null) goto L12;
        m(EventName.stream_start, r100.optLong("start_play_time"));
        m(EventName.stream_sdk_dns_analysis_end, r100.optLong("sdk_dns_analysis_end"));
        m(EventName.stream_player_dns_analysis_end, r100.optLong("player_dns_analysis_end"));
        m(EventName.stream_tcp_connect_end, r100.optLong("tcp_connect_end"));
        m(EventName.stream_tcp_first_package_end, r100.optLong("tcp_first_package_end"));
        m(EventName.stream_first_video_package_end, r100.optLong("first_video_package_end"));
        m(EventName.stream_first_video_frame_decode_end, r100.optLong("first_video_frame_decode_end"));
        m(EventName.stream_first_frame_render_end, r100.optLong("first_frame_render_end"));
        this.f106380g = true;
    L12:
        a r101 = this.f106379f.get(EventName.surface_control_first_frame.ordinal());
        String r102 = "1";
        if (r101 != null) goto L15;
    L17:
        EventName r103 = EventName.start_enter_room;
        EventName r110 = EventName.playing;
        long r111 = o(r103, r110);
        long r112 = o(EventName.touch_up_click, r110);
        this.f106394u = "0";
        long r113 = -1;
    L19:
        if (r111 >= 0) goto L23;
        p();
        return;
    L23:
        if (r210 < 0) goto L33;
        boolean r114 = fh1.e.f476961a;
        String r115 = String.valueOf(r111);
        Intrinsics.checkNotNullParameter(r115, "duration");
        if (fh1.e.f476961a == false) goto L33;
        if (TextUtils.isEmpty(r115) == true) goto L33;
        Map<Long, HashMap<String, String>> r104 = fh1.e.f476962b;
        HashMap<String, String> r105 = (HashMap) ((LinkedHashMap) r104).get(Long.valueOf(r210));
        if (r105 != null) goto L32;
        r105 = new HashMap();
        r104.put(Long.valueOf(r210), r105);
    L32:
        r105.put("first_frame_duration", r115);
        ALogger.w("FirstScreen_TAG", "firstFrame load  roomId:::  " + r210 + "  duration:::   " + r115);
    L33:
        this.f106377d = new HashMap();
        this.f106378e = new JSONObject();
        if (jc1.k.f(IHotRoomManager.class) == null) goto L38;
        Room r106 = ((IRoomService) jc1.k.f(IRoomService.class)).getCurrentRoomFromRoomContext();
        if (r106 == null) goto L38;
        ((HashMap) this.f106377d).put(IPerformanceManager.Params.hotroom_type, String.valueOf(((IHotRoomManager) jc1.k.f(IHotRoomManager.class)).getHotRoomType(r106.getRoomId())));
    L38:
        if (r211 == null) goto L48;
        Iterator<Map.Entry<String, String>> r107 = r211.entrySet().iterator();
    L41:
        if (r107.hasNext() == false) goto L48;
        Map.Entry<String, String> r108 = r107.next();
        if (r108.getKey() == null) goto L41;
        if (r108.getValue() == null) goto L41;
        ((HashMap) this.f106377d).put(r108.getKey(), r108.getValue());
    L48:
        if (r112 <= 0) goto L51;
        ((HashMap) this.f106377d).put("duration_from_touch", String.valueOf(r112));
    L51:
        if (r113 <= 0) goto L53;
        ((HashMap) this.f106377d).put("duration_old", String.valueOf(r113));
    L53:
        ((HashMap) this.f106377d).put("type", this.f106374a);
        if (this.f106377d != null) goto L56;
    L157:
        String r213 = "";
    L159:
        if (this.f106377d != null) goto L161;
    L172:
        ((HashMap) this.f106377d).put("duration", String.valueOf(r111));
        ((HashMap) this.f106377d).put("scene_type", "0");
        ((HashMap) this.f106377d).put(IPerformanceManager.Params.room_type, this.f106385l);
        ((HashMap) this.f106377d).put(IPerformanceManager.Params.landscape_scene, String.valueOf(LandscapeLiveMonitor.getLandscapeScene()));
        IAggregateService r109 = (IAggregateService) jc1.k.f(IAggregateService.class);
        if (r109 == null) goto L178;
        JSONObject r116 = r109.getPlayerStatsLog();
        if (r116 == null) goto L178;
        ((HashMap) this.f106377d).put(IPerformanceManager.Stream.stream_cdn_ip, r116.optString("cdn_ip:"));
        ((HashMap) this.f106377d).put(IPerformanceManager.Stream.stream_cdn_play_url, r116.optString("url:"));
        ((HashMap) this.f106377d).put("resolution", String.valueOf(Math.min(r116.optInt("width:"), r116.optInt("height:"))));
    L178:
        if (ou.f120932a.getValue().booleanValue() == false) goto L180;
    L231:
        Object r214 = "scene_type";
    L233:
        if (lo2.a.d() == false) goto L235;
        lo2.a r117 = lo2.a.e();
        r117.i("data_enter_room_cost", r111 + "ms");
        EnterRoomTimeTracer r118 = this;
        r117.i("data_enter_room_split_cost", it1.a.d(r118.f106379f));
    L236:
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_enter_room_duration_all", 0, r111, r118.f106378e);
        u.l().sendLog("livesdk_enter_room_duration", r118.f106377d, new Object[]{Room.class, am2.n.f()});
        String r119 = am2.n.f().c();
        if (TextUtils.isEmpty(r119) == true) goto L243;
        HashMap r120 = new HashMap();
        Map<String, String> r121 = r118.f106377d;
        if (r121 == null) goto L241;
        r120.put("enter_from_merge", (String) ((HashMap) r121).get("enter_from_merge"));
        r120.put("enter_method", (String) ((HashMap) r118.f106377d).get("enter_method"));
        Object r122 = r214;
        r120.put(r122, (String) ((HashMap) r118.f106377d).get(r122));
        r120.put("action_type", (String) ((HashMap) r118.f106377d).get("action_type"));
    L241:
        ((ILiveDouPlusService) jc1.k.n(ILiveDouPlusService.class)).adLiveOpenSuccess(r119, r111, r120);
    L243:
        if (pa1.f120964a.getValue().booleanValue() == true) goto L245;
    L247:
        p();
        return;
    L245:
        if (RoomContext.getShared() == null) goto L247;
        RoomContext.getShared().getEnterRoomDurationLogMap().setValue(new HashMap(r118.f106377d));
        goto L247
    L235:
        r118 = this;
        goto L236
    L180:
        if (v5.b().getBoolean("live.enter.room.key", false) == false) goto L231;
        String r123 = it1.a.d(this.f106379f);
        File r124 = s1.getContext().getExternalFilesDir("/live/performance/enterRoom/");
        if (r124 == null) goto L184;
        String r125 = r124.getAbsolutePath();
    L186:
        if (TextUtils.isEmpty(r125) == false) goto L188;
        ALogService.eSafely("FileUtils", "traceLog: 获取sd卡目录失败");
        goto L231
    L188:
        PolarisFileWrapper r126 = new PolarisFileWrapper(r125);
        if (r126.exists() == true) goto L191;
        r126.mkdirs();
    L191:
        StringBuilder r127 = new StringBuilder();
        r127.append(r125);
        StringBuilder r128 = new StringBuilder();
        String r129 = Build.BRAND;
        String r130 = Build.MODEL;
        IHostContext r131 = (IHostContext) jc1.k.f(IHostContext.class);
        if (r131 == null) goto L194;
        String r132 = "host" + r131.getVersionCode();
    L196:
        if (r129 == null) goto L198;
        r129 = r129.replace(".", "$");
    L198:
        if (r130 == null) goto L200;
        r130 = r130.replace(".", "$");
    L200:
        StringBuilder r133 = new StringBuilder();
        r214 = "scene_type";
        r133.append(p6.f159120a.format(new Date(System.currentTimeMillis())));
        r133.append("_");
        r128.append(r133.toString());
        r128.append("sdk1_");
        r128.append(r132 + "_");
        r128.append(r129 + "_");
        r128.append(r130 + "_");
        r128.append(AppLog.v());
        Object r134 = " ";
        r127.append(r128.toString().replace(" ", r213));
        PolarisFileWrapper r135 = new PolarisFileWrapper(r127.toString());
        if (r135.exists() == false) goto L249;
    L206:
        Object r136 = null;
        r136 = null;
        r136 = null;
        BufferedWriter r137 = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(r135, true), XML.CHARSET_UTF8));     // Catch: Throwable -> L215 Exception -> L217
        r137.write(r123);     // Catch: Exception -> L213 Throwable -> L223
        r137.close();     // Catch: IOException -> L211
        r134 = r137;
    L251:
    L211:
        e = move-exception;
        IOException r138 = e;
        r138.printStackTrace();
        r136 = r138;
        r134 = r137;
    L213:
        e = e;
    L219:
        e.printStackTrace();     // Catch: Throwable -> L223
        StringBuilder r139 = new StringBuilder("Exception：");     // Catch: Throwable -> L215
        r139.append(e.toString());     // Catch: Throwable -> L215
        ALogService.eSafely("FileUtils", r139.toString());     // Catch: Throwable -> L215
        r134 = r139;
    L215:
        th = th;
    L222:
        ?? r140 = r136;
        Throwable r141 = th;
        if (r140 == 0) goto L276;
        r140.close();     // Catch: IOException -> L228
        throw r141;
    L228:
        e = move-exception;
        e.printStackTrace();
        throw r141;
    L276:
        throw r141;
    L217:
        e = e;
    L223:
        th = th;
        r136 = r134;
        goto L222
    L249:
        r135.createNewFile();     // Catch: IOException -> L204
    L204:
        e = move-exception;
        e.printStackTrace();
        ALogService.eSafely("FileUtils", "创建文件文件失败");
        goto L233
    L194:
        r132 = r213;
        goto L196
    L184:
        r125 = r213;
        goto L186
    L161:
        if (this.f106378e == null) goto L172;
        int r142 = 0;
    L165:
        if (r142 >= this.f106379f.size()) goto L172;
        a r143 = this.f106379f.valueAt(r142);
        if (r143 == null) goto L171;
        if (TextUtils.isEmpty(r143.f106401a) == true) goto L171;
        ((HashMap) this.f106377d).put(r143.f106401a, String.valueOf(r143.f106402b));
        BaseMonitor.add(this.f106378e, r143.f106401a, r143.f106402b);
    L171:
        r142 = r142 + 1;
        goto L165
    L56:
        if (this.f106378e == null) goto L157;
        if (this.f106384k == null) goto L157;
        com.bytedance.android.livesdk.log.filter.o r144 = u.l().c(x.class);
        com.bytedance.android.livesdk.log.filter.o r145 = u.l().c(Room.class);
        if (r144 == null) goto L64;
        r144.a(this.f106377d);
    L64:
        if (r145 == null) goto L69;
        if (this.f106384k.contains("vs") == true) goto L69;
        r145.a(this.f106377d);
    L69:
        if (this.f106389p != null) goto L71;
    L75:
        Map<String, String> r146 = this.f106377d;
        if (this.f106381h == false) goto L78;
        Object r147 = "1";
    L79:
        ((HashMap) r146).put("pre_pull_stream", r147);
        Map<String, String> r148 = this.f106377d;
        if (this.f106383j == false) goto L82;
        Object r149 = "1";
    L83:
        ((HashMap) r148).put("schema_request_pull", r149);
        Map<String, String> r150 = this.f106377d;
        if (this.f106388o == false) goto L86;
        Object r151 = "1";
    L87:
        ((HashMap) r150).put("is_hit_cache", r151);
        Map<String, String> r152 = this.f106377d;
        if (this.f106382i == false) goto L90;
        Object r153 = "1";
    L91:
        ((HashMap) r152).put("has_stream_addr", r153);
        Map<String, String> r154 = this.f106377d;
        String r155 = this.f106384k;
        if (r155 != null) goto L95;
        r155 = String.valueOf(LiveMode.VIDEO.ordinal());
    L95:
        ((HashMap) r154).put("stream_type", r155);
        Map<String, String> r156 = this.f106377d;
        if (this.f106386m == false) goto L99;
        String r157 = "1";
    L102:
        ((HashMap) r156).put("push_stream_type", r157);
        Map<String, String> r158 = this.f106377d;
        if (ILiveRoomPlayFragmentConstant.ENTER_ROOM_TYPE_WITH_SLIDE.equals(this.f106374a) == false) goto L105;
        Object r159 = "1";
    L106:
        ((HashMap) r158).put("is_slide", r159);
        Map<String, String> r160 = this.f106377d;
        if (this.f106390q == false) goto L109;
        Object r161 = "1";
    L110:
        ((HashMap) r160).put("is_share_view", r161);
        Map<String, String> r162 = this.f106377d;
        if (this.f106391r == false) goto L113;
        Object r163 = "1";
    L114:
        ((HashMap) r162).put(ILiveRoomPlayFragmentConstant.EXTRA_IS_SURFACEVIEW, r163);
        Map<String, String> r164 = this.f106377d;
        String r165 = this.f106395v;
        if (r165 != null) goto L118;
        r165 = "";
    L118:
        ((HashMap) r164).put("enter_action", r165);
        Map<String, String> r166 = this.f106377d;
        EventName r167 = EventName.start_enter_room;
        EventName r168 = EventName.start_setup;
        ((HashMap) r166).put("duration_param_build", String.valueOf(o(r167, r168)));
        ((HashMap) this.f106377d).put("duration_feed_request", String.valueOf(o(EventName.start_request_feed, EventName.end_request_feed)));
        Map<String, String> r169 = this.f106377d;
        EventName r170 = EventName.end_setup;
        ((HashMap) r169).put("duration_start_page", String.valueOf(o(r168, r170)));
        Map<String, String> r171 = this.f106377d;
        EventName r172 = EventName.room_container_build;
        ((HashMap) r171).put("duration_page_init", String.valueOf(o(r170, r172)));
        Map<String, String> r173 = this.f106377d;
        EventName r174 = EventName.play_container_build;
        ((HashMap) r173).put("duration_room_container_build", String.valueOf(o(r172, r174)));
        Map<String, String> r175 = this.f106377d;
        EventName r176 = EventName.play_container_end;
        ((HashMap) r175).put("duration_play_container_build", String.valueOf(o(r174, r176)));
        Map<String, String> r177 = this.f106377d;
        EventName r178 = EventName.playing;
        ((HashMap) r177).put("duration_wait_playing", String.valueOf(o(r176, r178)));
        Map<String, String> r179 = this.f106377d;
        EventName r180 = EventName.start_pull_stream;
        EventName r181 = EventName.stream_start;
        ((HashMap) r179).put("duration_invoke", String.valueOf(o(r180, r181)));
        Map<String, String> r182 = this.f106377d;
        EventName r183 = EventName.render_view_bind;
        ((HashMap) r182).put("duration_renderview_create_prepare", String.valueOf(o(r167, r183)));
        Map<String, String> r184 = this.f106377d;
        EventName r185 = EventName.render_view_surface_ready;
        ((HashMap) r184).put("duration_renderview_create", String.valueOf(o(r183, r185)));
        Map<String, String> r186 = this.f106377d;
        EventName r187 = EventName.stream_set_surface_time;
        ((HashMap) r186).put("duration_renderview_set", String.valueOf(o(r185, r187)));
        Map<String, String> r188 = this.f106377d;
        EventName r189 = EventName.stream_first_video_frame_decode_end;
        ((HashMap) r188).put("duration_render_wait_surface", String.valueOf(o(r189, r187)));
        Map<String, String> r190 = this.f106377d;
        EventName r191 = EventName.stream_first_frame_render_end;
        ((HashMap) r190).put("duration_stream_duration", String.valueOf(o(r181, r191)));
        Map<String, String> r192 = this.f106377d;
        EventName r193 = EventName.stream_sdk_dns_analysis_end;
        r213 = "";
        ((HashMap) r192).put("duration_sdk_dns_analysis", String.valueOf(o(r181, r193)));
        Map<String, String> r194 = this.f106377d;
        EventName r195 = EventName.stream_player_dns_analysis_end;
        ((HashMap) r194).put("duration_player_dns_analysis", String.valueOf(o(r193, r195)));
        Map<String, String> r196 = this.f106377d;
        EventName r197 = EventName.stream_tcp_connect_end;
        ((HashMap) r196).put("duration_tcp_connect", String.valueOf(o(r195, r197)));
        Map<String, String> r198 = this.f106377d;
        EventName r199 = EventName.stream_tcp_first_package_end;
        ((HashMap) r198).put("duration_tcp_first_package", String.valueOf(o(r197, r199)));
        Map<String, String> r200 = this.f106377d;
        EventName r1100 = EventName.stream_first_video_package_end;
        ((HashMap) r200).put("duration_first_video_package", String.valueOf(o(r199, r1100)));
        ((HashMap) this.f106377d).put("duration_first_video_decode", String.valueOf(o(r1100, r189)));
        ((HashMap) this.f106377d).put("duration_first_frame_render", String.valueOf(o(r189, r191)));
        Map<String, String> r201 = this.f106377d;
        EventName r202 = EventName.first_frame;
        ((HashMap) r201).put("duration_callback", String.valueOf(o(r191, r202)));
        ((HashMap) this.f106377d).put("duration_end", String.valueOf(o(r202, r178)));
        ((HashMap) this.f106377d).put("duration_start", String.valueOf(o(r167, r180)));
        ((HashMap) this.f106377d).put("duration_start_to_stream", String.valueOf(o(r167, r181)));
        if (L.booleanValue() == false) goto L121;
        ((HashMap) this.f106377d).put(LocationMonitorConst.IS_COLD_BOOT, "1");
        L = Boolean.FALSE;
    L122:
        ((HashMap) this.f106377d).put("is_surface_control", this.f106394u);
        ((HashMap) this.f106377d).put("resolution_strategy", String.valueOf(this.f106396w));
        ((HashMap) this.f106377d).put("result_sdk_key", String.valueOf(this.f106398y));
        ((HashMap) this.f106377d).put("strategy_info", String.valueOf(this.f106397x));
        ((HashMap) this.f106377d).put("auto_resolution_state", String.valueOf(this.f106399z));
        ((HashMap) this.f106377d).put("resolution_ui_name", String.valueOf(this.A));
        ((HashMap) this.f106377d).put("resolution_fps", String.valueOf(this.B));
        ((HashMap) this.f106377d).put("is_compound_screen", String.valueOf(this.C));
        Integer r203 = this.D;
        if (r203 == null) goto L125;
        ((HashMap) this.f106377d).put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_NUM, r203.toString());
    L125:
        Boolean r204 = this.E;
        if (r204 != null) goto L128;
    L130:
        ((HashMap) this.f106377d).put(ILiveRoomPlayFragmentConstant.EXTRA_AUTO_ENTER, "0");
    L131:
        Integer r205 = this.G;
        if (r205 == null) goto L134;
        ((HashMap) this.f106377d).put(com.bytedance.android.ec.core.event.a.KEY_ENTER_SOURCE, r205.toString());
    L134:
        Integer r206 = this.F;
        if (r206 == null) goto L137;
        ((HashMap) this.f106377d).put(ILiveRoomPlayFragmentConstant.EXTRA_IS_FROM_PREVIEW, r206.toString());
    L137:
        Integer r207 = this.H;
        if (r207 == null) goto L140;
        ((HashMap) this.f106377d).put("is_plugin_install", r207.toString());
    L140:
        Integer r208 = this.I;
        if (r208 == null) goto L143;
        ((HashMap) this.f106377d).put("is_plugin_load", r208.toString());
    L143:
        a r209 = this.f106379f.get(r178.ordinal());
        Long r215 = this.K;
        if (r215 == null) goto L147;
        if (r209 == null) goto L147;
        ((HashMap) this.f106377d).put("total_duration", String.valueOf(r209.f106402b - r215.longValue()));
    L147:
        Map<String, String> r216 = this.f106377d;
        if (this.f106373J == true) goto L151;
        r102 = "0";
    L151:
        ((HashMap) r216).put("is_share_player", r102);
        if (((HashMap) this.f106377d).size() <= 0) goto L159;
        Iterator r217 = ((HashMap) this.f106377d).entrySet().iterator();
    L155:
        if (r217.hasNext() == false) goto L159;
        Map.Entry r218 = (Map.Entry) r217.next();
        BaseMonitor.add(this.f106378e, (String) r218.getKey(), (String) r218.getValue());
        goto L155
    L128:
        if (r204.booleanValue() == false) goto L130;
        ((HashMap) this.f106377d).put(ILiveRoomPlayFragmentConstant.EXTRA_AUTO_ENTER, "1");
        goto L131
    L121:
        ((HashMap) this.f106377d).put(LocationMonitorConst.IS_COLD_BOOT, "0");
        goto L122
    L113:
        r163 = "0";
        goto L114
    L109:
        r161 = "0";
        goto L110
    L105:
        r159 = "0";
        goto L106
    L99:
        if (this.f106387n == false) goto L101;
        r157 = "2";
        goto L102
    L101:
        r157 = "0";
        goto L102
    L90:
        r153 = "0";
        goto L91
    L86:
        r151 = "0";
        goto L87
    L82:
        r149 = "0";
        goto L83
    L78:
        r147 = "0";
        goto L79
    L71:
        if (this.f106384k.contains("vs") == false) goto L73;
    L74:
        ((HashMap) this.f106377d).putAll(this.f106389p);
        goto L75
    L73:
        if (PaidReplayConstants.VALUE_FROM_CONTENT_TYPE.equals(this.f106384k) == false) goto L75;
    L15:
        if (r101.f106402b == 0) goto L17;
        EventName r219 = EventName.start_enter_room;
        EventName r1101 = EventName.stream_first_frame_render_end;
        r111 = o(r219, r1101);
        r112 = o(EventName.touch_up_click, r1101);
        r113 = o(r219, EventName.playing);
        this.f106394u = "1";
        goto L19
    }
}
