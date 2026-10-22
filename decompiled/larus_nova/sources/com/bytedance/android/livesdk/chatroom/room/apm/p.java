package com.bytedance.android.livesdk.chatroom.room.apm;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.monitor.trace.TraceMonitor;
import com.bytedance.android.live.core.setting.j2;
import com.bytedance.android.live.livepullstream.api.apm.APMEvent;
import com.bytedance.android.livesdk.chatroom.room.p0;
import com.bytedance.android.livesdk.config.pu;
import com.bytedance.android.livesdk.f5;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.room.data.EndReason;
import com.bytedance.android.livesdk.utils.v6;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.room.RoomBaseSession;
import com.bytedance.android.livesdkapi.model.LiveRoomAPMConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.android.logsdk.format.Spm;
import com.bytedance.awemeopen.apps.photo.event.PinchStableViewEvent;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class p implements is2.g, q81.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bundle f110711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f110712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f110713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f110714d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f110715e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final IRoomEventHub f110716f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final p0 f110717g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public JSONObject f110718h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public JSONObject f110719i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public JSONObject f110720j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<APMEvent> f110721k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final LiveRoomAPMConfig f110722l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final q81.i f110723m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public RoomExitExtensionMonitor f110724n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final q81.f f110725o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Map<String, String> f110726p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public b f110727q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f110728r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f110729s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f110730t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final a f110731u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final WeakHandler f110732v;

    public class a implements WeakHandler.IHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f110733a;

        public a(p r100) {
            this.f110733a = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.handler.WeakHandler.IHandler
        public final void handleMsg(Message r100) {
            if (r100.what != 2) goto L15;
            this.f110733a.b(com.bytedance.android.live.livepullstream.api.apm.a.a(APMEvent.Level.E, "enter room timeout"));
            JSONObject r101 = this.f110733a.f110720j;
            if (r101 != null) goto L8;
        L13:
            p r102 = this.f110733a;
            b r103 = r102.f110727q;
            r103.f110734a = true;
            r103.f110735b = true;
            r103.f110736c = true;
            r102.h(1, "enter room timeout");
            return;
        L8:
            if (r101.opt("network_status") != null) goto L11;
            this.f110733a.a("network_status", "time_out");
        L11:
            if (this.f110733a.f110720j.opt("player_status") != null) goto L13;
            this.f110733a.a("player_status", "time_out");
            goto L13
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f110734a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f110735b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f110736c;

        public b() {
        }
    }

    @Override // is2.g
    public final String businessTypeV2() {
        return "LiveRoomAPMMonitor";
    }

    @Override // tw2.a
    public final Map<String, Object> getEnvData() {
        return null;
    }

    @Override // tw2.b
    public final Map<String, Object> getPropertyParams() {
        return null;
    }

    @Override // tw2.b
    public final String getSpm() {
        return null;
    }

    @Override // tw2.b
    public final boolean isIgnored() {
        return false;
    }

    @Override // is2.g
    public final void onOrientationChangeV2(int r100) {
    }

    @Override // is2.g
    public final void onRoomBackgroundV2() {
    }

    @Override // is2.g
    public final void onRoomPrepareV2(boolean r100) {
    }

    public final long e() {
        Bundle r100 = this.f110711a;
        if (r100 != null) goto L5;
        return 0;
    L5:
        Long r101 = Long.valueOf(r100.getLong(ILiveRoomPlayFragmentConstant.EXTRA_BEGIN_START_ACTIVITY_TIME, 0));
        if (r101.longValue() > 0) goto L8;
        Long r102 = Long.valueOf(this.f110711a.getLong(ILiveRoomPlayFragmentConstant.EXTRA_ACTIVITY_ON_CREATE_TIME, 0));
        if (r102.longValue() <= 0) goto L14;
        return r102.longValue();
    L14:
        return this.f110711a.getLong(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_STAR_TIME, 0);
    L8:
        return r101.longValue();
    }

    public final void g() {
        b(com.bytedance.android.live.livepullstream.api.apm.a.a(APMEvent.Level.I, "first frame ready x"));
        c("point_finish_first_frame_time", String.valueOf(System.currentTimeMillis()));
        long r100 = System.currentTimeMillis() - e();
        if (e() > 0) goto L5;
    L7:
        a("player_status", "success");
        this.f110727q.f110735b = true;
        h(0, "");
        return;
    L5:
        if (r100 >= this.f110722l.enterRoomTimeout) goto L7;
        d("start_to_first_frame_cost", r100);
        goto L7
    }

    public final void b(APMEvent r110) {
        List<String> r100 = this.f110722l.blackEventName;
        if (r100 == null) goto L7;
        if (r100.contains(r110.a()) == false) goto L7;
        return;
    L7:
        if (this.f110721k.size() <= this.f110722l.maxEventSize) goto L9;
        ListProtector.remove(this.f110721k, 0);
    L9:
        this.f110721k.add(r110);
        if (r110.b() != APMEvent.Level.E) goto L19;
        if (this.f110722l.enableWriteALogE == false) goto L27;
        Spm r101 = Spm.obtain().businessId(String.valueOf(this.f110712b)).addArg("user_id", String.valueOf(this.f110713c)).result(500).addArg("tag", "LiveRoomMonitor").addArg("key", r110.a());
        if (r110.c() != null) goto L16;
        String r111 = "";
    L17:
        Spm r112 = r101.addArg("message", r111);
        ArrayList<String> r102 = sw2.a.f543700a;
        Intrinsics.checkNotNullParameter(r112, "spm");
        sw2.a.b(r112, "");
        return;
    L16:
        r111 = r110.c();
        goto L17
    L27:
        return;
    L19:
        if (this.f110722l.enableWriteALogI == false) goto L29;
        Spm r103 = Spm.obtain().businessId(String.valueOf(this.f110712b)).addArg("user_id", String.valueOf(this.f110713c)).result(200).addArg("tag", "LiveRoomMonitor").addArg("key", r110.a());
        if (r110.c() != null) goto L23;
        String r113 = "";
    L24:
        Spm r114 = r103.addArg("message", r113);
        ArrayList<String> r104 = sw2.a.f543700a;
        Intrinsics.checkNotNullParameter(r114, "spm");
        sw2.a.b(r114, "");
        return;
    L23:
        r113 = r110.c();
        goto L24
    }

    public p(RoomBaseSession r100, LiveRoomAPMConfig r101) {
        this.f110726p = Collections.emptyMap();
        this.f110727q = new b();
        this.f110728r = 0;
        this.f110729s = 0;
        this.f110730t = 0;
        this.f110731u = new a(this);
        this.f110732v = new WeakHandler(Looper.getMainLooper(), this.f110731u);
        if (r100.getExtra() != null) goto L5;
        Bundle r102 = Bundle.EMPTY;
    L6:
        this.f110711a = r102;
        p0 r103 = r100.getEventHub();
        this.f110717g = r103;
        IRoomEventHub r104 = com.bytedance.android.live.platformplayer.utils.c.c(r100);
        this.f110716f = r104;
        this.f110718h = new JSONObject();
        this.f110719i = new JSONObject();
        this.f110720j = new JSONObject();
        this.f110721k = new LinkedList();
        this.f110722l = r101;
        this.f110723m = r100.getExtensionMonitor();
        this.f110725o = r100.getApmTraceAPMMonitor();
        if (r101.enableRoomAPM == true) goto L9;
        return;
    L9:
        if (pu.f121007a.getValue().booleanValue() == true) goto L28;
        this.f110712b = String.valueOf(r100.getRoomId());
        this.f110713c = r100.getUserId();
        b(com.bytedance.android.live.livepullstream.api.apm.a.a(APMEvent.Level.I, "monitor start"));
        if (r100.getGetFragment() == null) goto L29;
        Fragment r105 = r100.getGetFragment().invoke();
        if (r105 == null) goto L27;
        if (r104 == null) goto L30;
        r104.getPlayerMediaError().observe(r105, new q(this));
        if (r104.getFirstFrame().getValue().booleanValue() == false) goto L21;
        g();
    L21:
        r104.getFirstFrame().observe(r105, new r(this));
        r104.getPlaying().observe(r105, new s(this));
        r104.getReset().observe(r105, new t(this));
        r103.f111118a.observe(r105, new u(this));
        r103.getStartEnterRoomRequest().observe(r105, new v(this));
        r103.getInteractionResume().observe(r105, new w(this));
        r103.getUpdateInteraction().observe(r105, new x(this));
        r103.getPartShowInteraction().observe(r105, new i(this));
        r103.getShowInteraction().observe(r105, new j(this));
        r103.getHideInteraction().observe(r105, new k(this));
        MutableLiveData<Boolean> r106 = r103.getInitRoom();
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == false) goto L24;
        r106 = r103.isRoomVisible();
    L24:
        r106.observe(r105, new l(this));
        r103.getEndRoom().observe(r105, new m(this));
        r103.getRoomScrolled().observe(r105, new n(this));
        r103.f111120c.observe(r105, new o(this));
        return;
    L30:
        return;
    L27:
        return;
    L29:
        return;
    L28:
        return;
    L5:
        r102 = r100.getExtra();
        goto L6
    }

    public static void f(Map r100, JSONObject r101) {
        if (r100 == null) goto L15;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100.isEmpty() == true) goto L23;
        Iterator r102 = r100.entrySet().iterator();
    L9:
        if (r102.hasNext() == false) goto L24;
        Map.Entry r103 = (Map.Entry) r102.next();
        r101.put((String) r103.getKey(), r103.getValue());     // Catch: JSONException -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L9
    L24:
        return;
    L23:
        return;
    }

    public final void a(String r100, String r101) {
        JSONObject r102 = this.f110720j;
        if (r102 == null) goto L9;
        r102.put(r100, r101);     // Catch: JSONException -> L6
        return;
    L10:
        return;
    }

    public final void c(String r100, String r101) {
        JSONObject r102 = this.f110719i;
        if (r102 == null) goto L9;
        r102.put(r100, r101);     // Catch: JSONException -> L6
        return;
    L10:
        return;
    }

    public final void d(String r100, long r101) {
        JSONObject r102 = this.f110718h;
        if (r102 == null) goto L9;
        r102.put(r100, r101);     // Catch: JSONException -> L6
        return;
    L10:
        return;
    }

    public final void h(int r110, String r111) {
        b r100 = this.f110727q;
        if (r100.f110735b == true) goto L5;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == true) goto L12;
        return;
    L12:
        this.f110732v.removeMessages(2);
        if (this.f110728r <= 0) goto L15;
        return;
    L15:
        HashMap r102 = new HashMap();
        com.bytedance.android.livesdk.log.filter.o r103 = j0.l().c(am2.x.class);
        com.bytedance.android.livesdk.log.filter.o r104 = j0.l().c(Room.class);
        if (r103 == null) goto L18;
        r103.a(r102);
    L18:
        if (r104 == null) goto L21;
        r104.a(r102);
    L21:
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L23;
    L31:
        long r105 = e();
        long r106 = System.currentTimeMillis() - r105;
        if (r105 > 0) goto L34;
    L36:
        a("status_code", String.valueOf(r110));
        a("preview_extra", this.f110711a.getString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_PREVIEW_TRACE, ""));
        b(com.bytedance.android.live.livepullstream.api.apm.a.c(APMEvent.Level.I, "enter_finish", "enter_code=" + r110 + ", desc=" + r111 + ", total cost=" + r106));
        i(this.f110721k, this.f110719i);
        this.f110726p = new HashMap(r102);
        f(r102, this.f110719i);
        String r107 = null;
        if (com.bytedance.android.live.core.monitor.trace.c.a() == false) goto L41;
        String r108 = LiveTracingMonitor.EventModule.ROOM_APM.getName();
        int r109 = com.bytedance.android.live.core.monitor.trace.e.f64997m;
        com.bytedance.android.live.core.monitor.trace.e.a r112 = com.bytedance.android.live.core.monitor.trace.e.b.a("ttlive_room_apm_enter", r108);
        r112.f65012c = "webcast_client_room_apm";
        r112.f65017h = Integer.valueOf(r110);
        r112.f65018i = r111;
        r112.f65014e = this.f110712b;
        r112.f65016g = v6.a();
        r112.f65015f = this.f110714d;
        r112.f65011b = this.f110715e;
        com.bytedance.android.live.core.monitor.trace.e r113 = r112.a();
        JSONObject r114 = this.f110720j;
        JSONObject r115 = this.f110718h;
        JSONObject r116 = this.f110719i;
        Intrinsics.checkNotNullParameter(r113, "traceMeta");
        TraceMonitor.i(r113, r114, r115, r116);
        if (j2.f65330a.getValue().disable_room_apm_stats == true) goto L42;
        LiveTracingMonitor.i("ttlive_room_apm_stats", null, null, null);
    L42:
        this.f110718h = new JSONObject();
        this.f110719i = new JSONObject();
        this.f110721k.clear();
        this.f110728r++;
        q81.i r117 = this.f110723m;
        if (r117 == null) goto L46;
        r117.b();
        r107 = this.f110723m.getSid();
    L46:
        if (TextUtils.isEmpty(r107) == false) goto L49;
        r107 = String.valueOf(System.currentTimeMillis());
    L49:
        RoomExitExtensionMonitor r118 = new RoomExitExtensionMonitor(r107);
        this.f110724n = r118;
        r118.i(this.f110712b, this.f110713c);
        return;
    L41:
        LiveTracingMonitor.c("ttlive_room_apm_enter", LiveTracingMonitor.EventModule.ROOM_APM, LiveTracingMonitor.EventType.BUSSINESS_API_CALL, r110, r111, this.f110720j, this.f110718h, this.f110719i);
        goto L42
    L34:
        if (r106 >= this.f110722l.enterRoomTimeout) goto L36;
        c("duration", String.valueOf(r106));
        d("start_to_total_ready_cost", r106);
        b(com.bytedance.android.live.livepullstream.api.apm.a.b(APMEvent.Level.I, PinchStableViewEvent.State.ENTER_START, r105));
        goto L36
    L23:
        if (f5.f123403a.getValue().booleanValue() == false) goto L31;
        String r119 = (String) r102.get("enter_from_merge");
        String r120 = (String) r102.get("enter_method");
        if (TextUtils.isEmpty(r119) == true) goto L30;
        if (TextUtils.isEmpty(r120) == false) goto L31;
    L30:
        throw new RuntimeException("enter_from_merge = " + r119 + " enter_method = " + r120 + "两者都不可以为空   联系 @wangjiahao.hasong");
    L5:
        if (r100.f110736c == false) goto L9;
        if (r100.f110734a == false) goto L9;
        r101 = true;
        goto L10
    }

    public final void i(List<APMEvent> r100, JSONObject r101) {
        if (r100 == null) goto L21;
        if (r101 == null) goto L22;
        JSONArray r102 = new JSONArray();     // Catch: Exception -> L11
        Iterator<APMEvent> r103 = r100.iterator();     // Catch: Exception -> L11
    L7:
        if (r103.hasNext() == false) goto L9;
        r102.put(r103.next().h());     // Catch: Exception -> L11
        goto L7
    L9:
        r101.put("event_list", r102.toString());     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        r101.put("event_list_error", e.getMessage());     // Catch: JSONException -> L15
        return;
    L24:
        return;
    L22:
        return;
    }

    @Override // is2.g
    public final void onRoomEnterV2(Room r100, ls2.a r101) {
        this.f110715e = r100.getEnterLogId();
        this.f110712b = r100.getIdStr();
        this.f110714d = r100.getOwnerUserIdString();
        b(com.bytedance.android.live.livepullstream.api.apm.a.c(APMEvent.Level.I, "room/enter request success", "log_id=" + r100.getEnterLogId()));
        d("start_to_entered_cost", System.currentTimeMillis() - e());
        c("anchor_tab_type", String.valueOf(r100.getAnchorTabType()));
        c("room_auth", String.valueOf(r100.getRoomAuthStatus()));
        c("enter_room_log_id", r100.getEnterLogId());
        long r102 = this.f110719i.optLong("point_start_request_time", -1);
        c("point_finish_request_time", String.valueOf(System.currentTimeMillis()));
        long r103 = System.currentTimeMillis() - r102;
        if (r102 > 0) goto L5;
    L7:
        a("network_status", "success");
        this.f110730t = System.currentTimeMillis();
        this.f110727q.f110734a = true;
        h(0, "");
        return;
    L5:
        if (r103 >= this.f110722l.enterRoomTimeout) goto L7;
        d("enter_request_start_to_end_cost", r103);
        goto L7
    }

    @Override // is2.g
    public final void onRoomPreloadV2(Room r100, boolean r101) {
        this.f110715e = r100.getEnterLogId();
        this.f110712b = r100.getIdStr();
        this.f110714d = r100.getOwnerUserIdString();
    }

    @Override // is2.g
    public final void onRoomExitV2(long r100, String r101, boolean r110, Room r111, ls2.e r112, boolean r113, EndReason r114) {
        if (Boolean.TRUE.equals(this.f110717g.getInitRoom().getValue()) == false) goto L5;
    L7:
        if (r113 == true) goto L10;
        return;
    L10:
        if (this.f110729s <= 0) goto L12;
        return;
    L12:
        this.f110732v.removeMessages(2);
        if (r114 == null) goto L15;
        a("exit_code", z.f110770a.b(r114));
    L17:
        if (this.f110717g.f111118a.getValue() == null) goto L22;
        if (TextUtils.isEmpty(this.f110717g.f111118a.getValue().f485663c) == true) goto L22;
        c("enter_room_log_id", this.f110717g.f111118a.getValue().f485663c);
    L22:
        if ((r114 instanceof EndReason.PLAYER_ERROR) == false) goto L25;
        xs2.b.a().post(new zg1.h("enter_error", "msg: ttplayer init failed"));
    L31:
        String r102 = "";
        if (this.f110728r != 0) goto L43;
        String r103 = "roomId=" + r100 + ",userId=" + r101 + ", error=" + r112 + ", exit_error_ms=" + r112.getErrMsgV2();
        if (TextUtils.isEmpty(r112.getErrMsgV2()) == true) goto L42;
        r114.getClass();
        if (TextUtils.equals(r114.getClass().getSimpleName(), "STOP_WITHOUT_RELEASE_PLAYER") == true) goto L42;
        r102 = Log.getStackTraceString(new Throwable());     // Catch: Exception -> L39
    L41:
        r103 = r103 + ", reason=" + r112.getReasonV2() + ", trace=" + r102;
    L39:
        e = move-exception;
        ALogger.i("LiveRoomMonitor", "apm getStackTraceString error: " + e.getMessage());
    L42:
        b(com.bytedance.android.live.livepullstream.api.apm.a.c(APMEvent.Level.E, "abnormal exit room", r103));
        b r104 = this.f110727q;
        r104.f110734a = true;
        r104.f110735b = true;
        r104.f110736c = true;
        h(2, r112.getErrMsgV2() + " " + z.f110770a.b(r112.getReasonV2()));
    L100:
        this.f110729s++;
        return;
    L43:
        z r105 = z.f110770a;
        boolean r106 = r105.a(r112.getReasonV2());
        String r107 = "error=" + r112 + ", exit_error_ms=" + r112.getErrMsgV2() + ", reason=" + r112.getReasonV2() + ", endCode=" + r112.getEndV2();
        if (TextUtils.isEmpty(r112.getSourceKeyV2()) == true) goto L47;
        r107 = r107 + ", sourceKey=" + r112.getSourceKeyV2();
    L47:
        if (TextUtils.isEmpty(r112.getSourceValueV2V2()) == true) goto L50;
        r107 = r107 + ", sourceValue=" + r112.getSourceValueV2V2();
    L50:
        if (TextUtils.isEmpty(r112.getPlayerStateV2()) == true) goto L52;
        r107 = r107 + ", playerState=" + r112.getPlayerStateV2();
    L52:
        if (r106 == false) goto L54;
        APMEvent.Level r115 = APMEvent.Level.I;
    L55:
        b(com.bytedance.android.live.livepullstream.api.apm.a.c(r115, "exit room", r107));
        if (r106 == true) goto L59;
        c("status_code", r112.getErrorCode() + "");
        c("status_msg", r112.getErrMsgV2() + " " + r105.b(r112.getReasonV2()));
    L59:
        if (this.f110730t <= 0) goto L63;
        long r108 = System.currentTimeMillis();
        long r109 = this.f110730t;
        if (r108 <= r109) goto L63;
        d("watch_live_duration", r108 - r109);
        c("duration", String.valueOf(r108 - this.f110730t));
    L63:
        LiveRoomAPMConfig r116 = this.f110722l;
        int r117 = r116.uploadExitRoomLevel;
        if (r117 == 2) goto L68;
        if (r117 != 1) goto L100;
        if (r106 == true) goto L100;
    L68:
        if (r116.exitUploadAll() == false) goto L70;
    L72:
        c("trace", Log.getStackTraceString(new Exception()));
    L73:
        b(com.bytedance.android.live.livepullstream.api.apm.a.a(APMEvent.Level.I, "upload events by exit room; hashCode=" + hashCode()));
        f(this.f110726p, this.f110719i);
        if (this.f110721k == null) goto L93;
        q81.f r118 = this.f110725o;
        if (r118 == null) goto L93;
        if ((r118.b() instanceof HashMap) == false) goto L93;
        if (this.f110722l == null) goto L93;
        HashMap r119 = (HashMap) this.f110725o.b();
        Iterator r120 = r119.keySet().iterator();
    L84:
        if (r120.hasNext() == false) goto L93;
        String r121 = (String) r120.next();
        if ((r119.get(r121) instanceof List) == false) goto L84;
        List r122 = (List) r119.get(r121);
        if (r122 == null) goto L84;
    L90:
        if (r122.size() <= this.f110722l.maxEventSize) goto L92;
        ListProtector.remove(r122, r122.size() - 1);
        goto L90
    L92:
        this.f110721k.addAll(r122);
    L93:
        i(this.f110721k, this.f110719i);
        if (com.bytedance.android.live.core.monitor.trace.c.a() == false) goto L96;
        String r123 = LiveTracingMonitor.EventModule.ROOM_APM.getName();
        int r124 = com.bytedance.android.live.core.monitor.trace.e.f64997m;
        com.bytedance.android.live.core.monitor.trace.e.a r125 = com.bytedance.android.live.core.monitor.trace.e.b.a("ttlive_room_apm_exit", r123);
        r125.f65012c = "webcast_client_room_apm";
        r125.f65014e = this.f110712b;
        r125.f65015f = this.f110714d;
        r125.f65016g = v6.a();
        com.bytedance.android.live.core.monitor.trace.e r126 = r125.a();
        JSONObject r127 = this.f110720j;
        JSONObject r128 = this.f110718h;
        JSONObject r129 = this.f110719i;
        Intrinsics.checkNotNullParameter(r126, "traceMeta");
        TraceMonitor.i(r126, r127, r128, r129);
    L97:
        this.f110719i = new JSONObject();
        this.f110718h = new JSONObject();
        this.f110721k.clear();
        RoomExitExtensionMonitor r130 = this.f110724n;
        if (r130 == null) goto L100;
        r130.j();
        goto L100
    L96:
        LiveTracingMonitor.e("ttlive_room_apm_exit", LiveTracingMonitor.EventModule.ROOM_APM, LiveTracingMonitor.EventType.BUSSINESS_API_CALL, this.f110720j, this.f110718h, this.f110719i);
        goto L97
    L70:
        if (this.f110722l.exitUploadOnlyAbnormal() == false) goto L73;
        if (r106 == true) goto L73;
    L54:
        r115 = APMEvent.Level.E;
        goto L55
    L25:
        if ((r114 instanceof EndReason.ENTER_FAILED) == false) goto L31;
        xs2.b r131 = xs2.b.a();
        StringBuilder r132 = new StringBuilder("code: ");
        if (r112.getErrorCode() <= 0) goto L29;
        int r133 = r112.getErrorCode();
    L30:
        r132.append(r133);
        r132.append(", msg: ");
        r132.append(r112.getErrMsgV2());
        r131.post(new zg1.h("enter_error,", r132.toString()));
        goto L31
    L29:
        r133 = 103;
        goto L30
    L15:
        a("exit_code", "unknown");
        goto L17
    L5:
        if (MultiRoomConfig.INSTANCE.enableRoomPreload() == true) goto L7;
    }
}
