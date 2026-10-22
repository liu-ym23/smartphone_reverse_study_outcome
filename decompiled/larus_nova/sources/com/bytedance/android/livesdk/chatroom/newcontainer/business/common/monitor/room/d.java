package com.bytedance.android.livesdk.chatroom.newcontainer.business.common.monitor.room;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.monitor.trace.TraceMonitor;
import com.bytedance.android.live.livepullstream.api.apm.APMEvent;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.chatroom.room.RoomSession;
import com.bytedance.android.livesdk.chatroom.room.p0;
import com.bytedance.android.livesdk.room.data.EndReason;
import com.bytedance.android.livesdk.room.state.ContainerLifecycle;
import com.bytedance.android.livesdk.room.state.LiveRoomNewState;
import com.bytedance.android.livesdk.room.state.RoomDataType;
import com.bytedance.android.livesdk.room.state.RoomStateChangeLifecycle;
import com.bytedance.android.livesdk.room.state.WidgetLevel;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import ts2.f;
import ts2.i;
import ts2.r;

/* JADX INFO: loaded from: classes7.dex */
public final class d extends com.bytedance.android.livesdk.room.c<ls2.c> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f107297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f107298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f107299d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f107300e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f107301f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Long f107302g;

    @Override // os2.a
    public final ls2.c d() {
        return null;
    }

    public d() {
        this.f107302g = 0L;
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void g(com.bytedance.android.livesdk.room.b r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        A(LiveRoomNewState.ROOM_AFTER_PRE_ENTER_ROOM.getDes(), "");
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void i(com.bytedance.android.livesdk.room.b r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        A(LiveRoomNewState.ROOM_STOP_ROOM_FINISH.getDes(), "");
        ik1.c r100 = jk1.a.c(r110);
        ls2.e r101 = r100.f490225r;
        Object r102 = null;
        if (r101 == null) goto L5;
        EndReason r103 = r101.getReasonV2();
    L7:
        if ((r103 instanceof EndReason.STOP_WITHOUT_RELEASE_PLAYER) == false) goto L10;
        String r104 = "SCROLL_TO_NEXT_ROOM";
    L20:
        a r105 = this.f107297b;
        if (r105 == null) goto L78;
        ls2.e r106 = r100.f490225r;
        if (r106 == null) goto L25;
        String r107 = r106.getErrPromptV2();
    L26:
        ls2.e r108 = r100.f490225r;
        if (r108 == null) goto L29;
        Integer r109 = Integer.valueOf(r108.getErrorCode());
    L31:
        if (r105.f107285a != 0) goto L34;
        r105.d(r110, -999, "abnormal enter room", "reportExitRoom");
    L34:
        if (r105.f107286b <= 0) goto L36;
        boolean r111 = false;
    L76:
        r102 = Boolean.valueOf(r111);
        goto L78
    L36:
        r105.ai(com.bytedance.android.live.livepullstream.api.apm.a.c(APMEvent.Level.I, "exit finish", "exitType: " + r104 + "，exitCode:" + r109 + ", , exitMsg:" + r107));
        a.b(r105.f107289e, r105.f107291g);
        r105.f(r105.f107288d, r105.f107291g);
        if (r110 == null) goto L39;
        String r112 = r110.f510499f;
    L40:
        Intrinsics.checkNotNullParameter("enter_from_merge", "key");
        JSONObject r113 = r105.f107291g;
        if (r113 != null) goto L87;
    L43:
        if (r110 == null) goto L45;
        String r114 = r110.f510500g;
    L46:
        Intrinsics.checkNotNullParameter("enter_method", "key");
        JSONObject r115 = r105.f107291g;
        if (r115 != null) goto L89;
    L49:
        IMiddleWareHostContext r116 = (IMiddleWareHostContext) k.f(IMiddleWareHostContext.class);
        if (r116 == null) goto L52;
        String r117 = r116.getServerDeviceId();
    L53:
        Intrinsics.checkNotNullParameter("device_id", "key");
        JSONObject r118 = r105.f107291g;
        if (r118 == null) goto L57;
        r118.put("device_id", r117);     // Catch: JSONException -> L84
    L57:
        if (com.bytedance.android.live.core.monitor.trace.c.a() == false) goto L74;
        int r119 = com.bytedance.android.live.core.monitor.trace.e.f64997m;
        com.bytedance.android.live.core.monitor.trace.e.a r120 = com.bytedance.android.live.core.monitor.trace.e.b.a("ttlive_room_apm_exit", LiveTracingMonitor.EventModule.ROOM_APM.getName());
        r120.f65012c = "webcast_client_room_apm";
        if (r110 == null) goto L63;
        Long r121 = r110.f510496c;
        if (r121 == null) goto L63;
        String r122 = String.valueOf(r121.longValue());
    L64:
        r120.f65014e = r122;
        if (r110 == null) goto L69;
        Room r123 = r110.f157611t;
        if (r123 == null) goto L69;
        String r124 = r123.getAnchorId();
    L70:
        r120.f65015f = r124;
        r120.f65016g = ((IMiddlewareUserService) k.n(IMiddlewareUserService.class)).user().n();
        com.bytedance.android.live.core.monitor.trace.e r125 = r120.a();
        JSONObject r126 = r105.f107292h;
        JSONObject r127 = r105.f107290f;
        JSONObject r128 = r105.f107291g;
        Intrinsics.checkNotNullParameter(r125, "traceMeta");
        TraceMonitor.i(r125, r126, r127, r128);
        StringBuilder r129 = new StringBuilder("reportExitRoom: ");
        if (r110 == null) goto L73;
        r102 = r110.f510496c;
    L73:
        r129.append(r102);
        r129.append(", size:");
        r129.append(r105.f107291g.length());
        r129.append(", mApmEvents:");
        r129.append(((ArrayList) r105.f107288d).size());
        ALogger.d("EnterRoomApmReportService", r129.toString());
    L75:
        r105.e();
        r111 = true;
        r105.f107286b++;
    L69:
        r124 = null;
    L63:
        r122 = null;
        goto L64
    L74:
        LiveTracingMonitor.e("ttlive_room_apm_exit", LiveTracingMonitor.EventModule.ROOM_APM, LiveTracingMonitor.EventType.BUSSINESS_API_CALL, r105.f107292h, r105.f107290f, r105.f107291g);
        goto L75
    L52:
        r117 = null;
        goto L53
    L89:
        r115.put("enter_method", r114);     // Catch: JSONException -> L83
        goto L49
    L45:
        r114 = null;
        goto L46
    L87:
        r113.put("enter_from_merge", r112);     // Catch: JSONException -> L82
        goto L43
    L39:
        r112 = null;
        goto L40
    L29:
        r109 = null;
        goto L31
    L25:
        r107 = null;
    L78:
        if (Intrinsics.areEqual(r102, Boolean.TRUE) == false) goto L80;
        this.f107299d = false;
        this.f107298c = false;
        this.f107300e = false;
        this.f107301f = false;
    L80:
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        return;
    L10:
        if ((r103 instanceof EndReason.USER_CLOSE) == false) goto L13;
        r104 = "USER_CLOSE";
        goto L20
    L13:
        if ((r103 instanceof EndReason.JUMP_TO_OTHER) == false) goto L15;
        r104 = "INNER_LIVE_JUMPER";
        goto L20
    L15:
        if (r101 == null) goto L19;
        EndReason r130 = r101.getReasonV2();
        if (r130 == null) goto L19;
        r104 = r130.toString();
    L19:
        r104 = null;
        goto L20
    L5:
        r103 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void l(com.bytedance.android.livesdk.room.b r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f107298c = true;
        A(LiveRoomNewState.ROOM_STREAM_READY.getDes(), "");
        C(r100, 0, "", "onFirstFrameReady");
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void o(com.bytedance.android.livesdk.room.b r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        a r101 = new a();
        r100.c(q81.b.class, r101);
        Unit r102 = Unit.INSTANCE;
        this.f107297b = r101;
        A(LiveRoomNewState.ROOM_CONTAINER_INIT.getDes(), "");
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void u(com.bytedance.android.livesdk.room.b r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        A(LiveRoomNewState.ROOM_START_ENTER_ROOM_FINISH.getDes(), "isFirstRoom: " + r100.f510506m + ", originRoomId: " + r100.f510496c);
        a r101 = this.f107297b;
        if (r101 == null) goto L5;
        r101.f107285a = 0;
        r101.f107286b = 0;
    L5:
        this.f107302g = r100.f510496c;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    public static String B(String r100, String r101) {
        if (r2.a(r101) == false) goto L7;
        return "room->" + r100 + ": " + r101;
    L7:
        return "room->" + r100;
    }

    public final void A(String r100, String r101) {
        a r102 = this.f107297b;
        if (r102 == null) goto L6;
        r102.ai(com.bytedance.android.live.livepullstream.api.apm.a.a(APMEvent.Level.I, B(r100, r101)));
        return;
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void n(com.bytedance.android.livesdk.room.b r100, i r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r102 = LiveRoomNewState.ROOM_DATA_READY.getDes();
        RoomDataType r103 = null;
        if (r101 == null) goto L7;
        RoomDataType r104 = r101.f547349b;
        if (r104 == null) goto L7;
        String r105 = r104.name();
    L8:
        A(r102, r105);
        if (r101 == null) goto L12;
        r103 = r101.f547349b;
    L12:
        if (r103 != RoomDataType.ALL_ROOM) goto L14;
        this.f107299d = true;
        C(r100, 0, "onRoomDataReady", "onRoomDataReady");
    L14:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return;
    L7:
        r105 = null;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void t(com.bytedance.android.livesdk.room.b r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ik1.c r102 = jk1.a.c(r100);
        Fragment r103 = r100.f510501h;
        if (r103 == null) goto L18;
        RoomSession r104 = r102.f490211d;
        if (r104 == null) goto L11;
        p0 r105 = r104.getEventHub();
        if (r105 == null) goto L11;
        MutableLiveData<hl0.a> r106 = r105.f111118a;
        if (r106 == null) goto L11;
        r106.observe(r103, new b(this, r100));
    L11:
        RoomSession r107 = r102.f490211d;
        if (r107 == null) goto L18;
        IRoomEventHub r108 = r107.n();
        if (r108 == null) goto L18;
        MutableLiveData<String> r109 = r108.getPlayerMediaError();
        if (r109 == null) goto L18;
        r109.observe(r103, new c(this, r100));
    L18:
        A(LiveRoomNewState.ROOM_CONTAINER_FINISH.getDes(), "");
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    public final void z(String r100, String r101) {
        a r102 = this.f107297b;
        if (r102 == null) goto L6;
        r102.ai(com.bytedance.android.live.livepullstream.api.apm.a.a(APMEvent.Level.E, B(r100, r101)));
        return;
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void f(com.bytedance.android.livesdk.room.b r100, final ContainerLifecycle r101, ts2.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 == null) goto L6;
        ts2.d.h(r101, new LiveRoomApmMonitorBusiness$containerStateChanged$1(this, r101));
    L6:
        if (r101 == null) goto L10;
        Function0<Unit> r103 = new LiveRoomApmMonitorBusiness$containerStateChanged$2(this, r101);
        Intrinsics.checkNotNullParameter(r101, "$this$onBackPressed");
        Intrinsics.checkNotNullParameter(r103, "action");
        if (r101 != ContainerLifecycle.ON_BACK_PRESSED) goto L10;
        r103.invoke();
    L10:
        if (r101 == null) goto L14;
        Function0<Unit> r104 = new LiveRoomApmMonitorBusiness$containerStateChanged$3(this, r101);
        Intrinsics.checkNotNullParameter(r101, "$this$roomDisposeContext");
        Intrinsics.checkNotNullParameter(r104, "action");
        if (r101 != ContainerLifecycle.ROOM_DISPOSE_CONTEXT) goto L14;
        r104.invoke();
    L14:
        if (r101 == null) goto L16;
        ts2.d.d(r101, new LiveRoomApmMonitorBusiness$containerStateChanged$4(this, r101));
    L16:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void p(com.bytedance.android.livesdk.room.b r100, RoomStateChangeLifecycle r101, ts2.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 == null) goto L7;
        Function0<Unit> r103 = new LiveRoomApmMonitorBusiness$onRoomStateChanged$1(this);
        Intrinsics.checkNotNullParameter(r101, "$this$onHorizontalEvent");
        Intrinsics.checkNotNullParameter(r103, "action");
        if (r101 != RoomStateChangeLifecycle.LIVE_HORIZONTAL_PLAY_EVENT) goto L7;
        r103.invoke();
    L7:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.android.livesdk.room.c
    public final void y(com.bytedance.android.livesdk.room.b r100, WidgetLevel r101, r r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "widgetLevel");
        A(LiveRoomNewState.ROOM_WIDGET_LOAD_FINISH.getDes() + '_' + r101.name(), "");
        if (r101 != WidgetLevel.P0) goto L5;
        this.f107300e = true;
        C(r100, 0, "widgetLoadFinish", "widgetLoadFinish");
    L5:
        super.y(r100, r101, r102);
    }

    public final void C(com.bytedance.android.livesdk.room.b r100, int r101, String r102, String r103) {
        if (this.f107299d == false) goto L9;
        if (this.f107298c == false) goto L9;
        if (this.f107300e == false) goto L9;
    L10:
        boolean r104 = true;
    L12:
        if (r104 == true) goto L14;
        return;
    L14:
        if ((!Intrinsics.areEqual(this.f107302g, r100.f510496c)) == false) goto L16;
        z("roomId not equal", "originRoomId: " + this.f107302g + ", currentRoomId: " + r100.f510496c);
    L16:
        a r105 = this.f107297b;
        if (r105 == null) goto L19;
        Boolean r106 = Boolean.valueOf(r105.d(r100, r101, r102, r103));
    L21:
        if (Intrinsics.areEqual(r106, Boolean.TRUE) == false) goto L25;
        this.f107299d = false;
        this.f107298c = false;
        this.f107300e = false;
        this.f107301f = false;
        return;
    L25:
        return;
    L19:
        r106 = null;
    L9:
        if (this.f107301f == true) goto L10;
        r104 = false;
        goto L12
    }
}
