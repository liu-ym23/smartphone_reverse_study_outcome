package com.bytedance.android.livesdk.chatroom.room.apm;

import android.os.Looper;
import android.os.Message;
import androidx.camera.core.RetryPolicy;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.room.t0;
import com.bytedance.android.livesdk.config.i91;
import com.bytedance.android.livesdk.config.so0;
import com.bytedance.android.livesdk.config.to0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ttvideoengine.portrait.PortraitEngine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes7.dex */
public final class LiveMkStallManager extends com.bytedance.android.livesdk.chatroom.room.apm.b implements q81.d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f110643d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final fo2.c f110644e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile HashMap<String, Integer> f110645f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap<String, Boolean> f110646g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final WeakHandler f110647h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final IPerformanceManager f110648i;

    public static final class a {
    }

    public static final class b implements WeakHandler.IHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f110649a = null;

        static {
            f110649a = new b();
        }

        public b() {
        }

        @Override // com.bytedance.android.livesdkapi.depend.handler.WeakHandler.IHandler
        public final void handleMsg(Message r100) {
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveMkStallManager f110650a;

        public c(LiveMkStallManager r100) {
            this.f110650a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        L16:
            return;
        L3:
            if (this.f110650a.f110686a == false) goto L12;
            LiveMkStallManager r100 = this.f110650a;     // Catch: Throwable -> L9
            r100.getClass();     // Catch: Throwable -> L9
            if (com.bytedance.android.livesdk.chatroom.room.apm.b.v(r100) == false) goto L7;
            r100.A();     // Catch: Throwable -> L9
        L7:
            r100.f110686a = false;     // Catch: Throwable -> L9
            return;
        }
    }

    static {
    }

    @Override // q81.d
    public final void i(long r100, String r101) {
    }

    @Override // q81.d
    public final void t(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "from");
    }

    public final void A() {
        com.bytedance.android.livesdk.log.filter.o r100 = j0.l().c(am2.x.class);
        if (r100 == null) goto L28;
        if (r100.getMap() == null) goto L28;
        String r101 = "";
        if (r100.getMap().containsKey("enter_from_merge") == false) goto L15;
        HashMap<String, String> r102 = this.f110688c;
        String r103 = r100.getMap().get("enter_from_merge");
        if (r103 != null) goto L13;
        r103 = "";
    L13:
        r102.put("enter_from_merge", r103);
    L15:
        if (r100.getMap().containsKey("enter_method") == false) goto L21;
        HashMap<String, String> r104 = this.f110688c;
        String r105 = r100.getMap().get("enter_method");
        if (r105 != null) goto L19;
        r105 = "";
    L19:
        r104.put("enter_method", r105);
    L21:
        if (r100.getMap().containsKey("action_type") == false) goto L28;
        HashMap<String, String> r106 = this.f110688c;
        String r107 = r100.getMap().get("action_type");
        if (r107 == null) goto L26;
        r101 = r107;
    L26:
        r106.put("action_type", r101);
    L28:
        if (to0.f121315a.getValue().booleanValue() == true) goto L87;
    L29:
        Object r110 = "room_id";
    L83:
        j0.l().sendLog("livesdk_mk_performance", this.f110688c, new Object[0]);
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L95;
        String r108 = this.f110688c.get(r110);
        String r109 = this.f110688c.get("p0_loaded");
        String r111 = this.f110688c.get("p0_duration");
        String r112 = this.f110688c.get("p1_duration");
        String r113 = this.f110688c.get(PortraitEngine.LABEL_FIRST_FRAME);
        return;
    L95:
        return;
    L87:
        String r114 = this.f110688c.get("room_id");     // Catch: Exception -> L35
        if (r114 == null) goto L36;
        long r115 = CastLongProtector.parseLong(r114);     // Catch: Exception -> L35
    L38:
        if (r115 == 0) goto L29;
        MiddlewareRoomContext.Companion.getClass();
        MiddlewareRoomContext r116 = MiddlewareRoomContext.a.a(null, r115);
        if (r116 == null) goto L29;
        com.bytedance.live.datacontext.m<Long> r117 = r116.getEnterRoomTimeStamp();
        if (r117 == null) goto L29;
        Long r118 = r117.getValue();
        if (r118 == null) goto L29;
        long r119 = r118.longValue();
        String r120 = this.f110688c.get("init_room_ts");     // Catch: Exception -> L63
        if (r120 == null) goto L51;
        long r121 = CastLongProtector.parseLong(r120);     // Catch: Exception -> L63
    L91:
        String r122 = this.f110688c.get("first_frame_ts");     // Catch: Exception -> L62
        if (r122 == null) goto L56;
        long r123 = CastLongProtector.parseLong(r122);     // Catch: Exception -> L62
    L93:
        String r124 = this.f110688c.get("room_fragment_ts");     // Catch: Exception -> L61
        if (r124 == null) goto L64;
        long r125 = CastLongProtector.parseLong(r124);     // Catch: Exception -> L61
    L66:
        if (r123 > 0) goto L68;
        this.f110688c.put("has_first_frame", "0");
        goto L29
    L68:
        this.f110688c.put("has_first_frame", "1");
        r110 = "room_id";
        if (r125 <= 0) goto L76;
        this.f110688c.put("is_first_room", "1");
        if (r125 < r123) goto L73;
        this.f110688c.put("play_duration_type", "1");
        this.f110688c.put("live_duration_start", String.valueOf(r125 - r119));
    L74:
        this.f110688c.put("fragment_create", String.valueOf(r125 - r119));
        this.f110688c.put(PortraitEngine.LABEL_FIRST_FRAME, String.valueOf(r123 - r119));
        goto L83
    L73:
        this.f110688c.put("play_duration_type", "2");
        this.f110688c.put("live_duration_start", String.valueOf(r123 - r119));
        goto L74
    L76:
        if (r121 <= 0) goto L83;
        this.f110688c.put("is_first_room", "0");
        if (r121 < r123) goto L81;
        this.f110688c.put("play_duration_type", "1");
        this.f110688c.put("live_duration_start", String.valueOf(r121 - r119));
    L82:
        this.f110688c.put("init_room", String.valueOf(r121 - r119));
        this.f110688c.put(PortraitEngine.LABEL_FIRST_FRAME, String.valueOf(r123 - r119));
        goto L83
    L81:
        this.f110688c.put("play_duration_type", "2");
        this.f110688c.put("live_duration_start", String.valueOf(r123 - r119));
    L64:
        r125 = 0;
        goto L66
    L56:
        r123 = 0;
    L62:
        r123 = 0;
        goto L64
    L51:
        r121 = 0;
    L63:
        r121 = 0;
        r123 = 0;
    L36:
        r115 = 0;
        goto L38
    }

    @Override // q81.d
    public final void q() {
        Boolean r100 = this.f110646g.get("fast_gift_duration");
        Boolean r101 = Boolean.TRUE;
        if (Intrinsics.areEqual(r100, r101) == false) goto L5;
        return;
    L5:
        this.f110646g.put("fast_gift_duration", r101);
    }

    @Override // com.bytedance.android.livesdk.chatroom.room.apm.b
    public final boolean u() {
        if (so0.f121242a.getValue().intValue() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // q81.d
    public final void d(long r100) {
        if (u() == true) goto L5;
        return;
    L5:
        if (this.f110686a == true) goto L13;
        this.f110686a = true;
        this.f110687b.setupPrefDataForStart(r100, false);
        ALogger.i("LiveRoomFpsMonitor", "=========start monitor fps roomId=" + r100 + "============");
        t0 r101 = LiveRoomFpsMonitor.f110673a;
        if (r101 == null) goto L10;
        ((LinkedHashMap) r101.f111154a).clear();
        r101.f111155b = null;
        ALogger.i("LiveRoomFpsMonitor", "cleatData");
    L10:
        this.f110688c.clear();
        this.f110645f.clear();
        this.f110646g.clear();
        this.f110647h.removeCallbacksAndMessages(null);
        this.f110643d = System.currentTimeMillis();
        this.f110648i.startMonitorFps("mk_stall");
        this.f110644e.b();
        LiveRoomFpsMonitor.c(4, r100);
        return;
    }

    public final boolean x(String r100) {
        Integer r101 = this.f110645f.get(r100);
        if (r101 != null) goto L6;
    L7:
        Integer r102 = this.f110645f.get(r100);
        if (r102 != null) goto L11;
    L15:
        return false;
    L11:
        if (r102.intValue() != 3) goto L15;
        if (this.f110688c.get("commerce_duration") != null) goto L15;
    L16:
        return true;
    L6:
        if (r101.intValue() == 4) goto L16;
        goto L7
    }

    public LiveMkStallManager(IPerformanceManager r100, fo2.b r101) {
        Intrinsics.checkNotNullParameter(r100, "livePerformanceManager");
        Intrinsics.checkNotNullParameter(r101, "livePlayerStallManager");
        super(r100);
        this.f110648i = r100;
        this.f110644e = new fo2.c(r101);
        this.f110645f = new HashMap();
        this.f110646g = new HashMap();
        this.f110647h = new WeakHandler(Looper.getMainLooper(), b.f110649a);
    }

    @Override // q81.d
    public final void a(long r100, String r101) {
        if (w(r100) == false) goto L5;
        return;
    L5:
        LiveRoomFpsMonitor.f110677e.a(1, r100);
        HashMap<String, String> r102 = this.f110688c;
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        r102.put("p1_duration", r101);
        y(this.f110688c.get("p1_s_f_u_e"), this.f110688c.get("p1_duration"), new LiveMkStallManager$notifyP1WidgetLoaded$1(this));
    }

    @Override // q81.d
    public final void b(long r100, String r101) {
        if (w(r100) == false) goto L5;
        return;
    L5:
        HashMap<String, String> r102 = this.f110688c;
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        r102.put("direct_show_s_f_u_e", r101);
        this.f110688c.put("has_preload_data", "0");
    }

    @Override // q81.d
    public final void c(long r100, String r101) {
        Boolean r102 = this.f110646g.get("gift_duration");
        Boolean r103 = Boolean.TRUE;
        if (Intrinsics.areEqual(r102, r103) == false) goto L5;
        return;
    L5:
        this.f110646g.put("gift_duration", r103);
        z("gift_duration", r100, r101);
    }

    @Override // q81.d
    public final void e(long r100, String r101) {
        if (w(r100) == false) goto L5;
        return;
    L5:
        HashMap<String, String> r102 = this.f110688c;
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        r102.put("init_room_ts", r101);
    }

    @Override // q81.d
    public final void f(long r100, String r101) {
        if (w(r100) == false) goto L5;
        return;
    L5:
        HashMap<String, String> r102 = this.f110688c;
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        r102.put("part_show_s_f_u_e", r101);
        this.f110688c.put("has_preload_data", "1");
    }

    @Override // q81.d
    public final void h(long r100, String r101) {
        if (w(r100) == false) goto L5;
        return;
    L5:
        HashMap<String, String> r102 = this.f110688c;
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        r102.put("room_fragment_ts", r101);
    }

    @Override // q81.d
    public final void j(long r100, String r101) {
        if (w(r100) == false) goto L5;
        return;
    L5:
        HashMap<String, String> r102 = this.f110688c;
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        r102.put("p2_s_f_u_e", r101);
        LiveRoomFpsMonitor.c(2, r100);
    }

    @Override // q81.d
    public final void k(long r100, String r101) {
        if (w(r100) == false) goto L5;
        return;
    L5:
        HashMap<String, String> r102 = this.f110688c;
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        r102.put("other_s_f_u_e", r101);
    }

    @Override // q81.d
    public final void l(long r100, String r101) {
        if (w(r100) == false) goto L5;
        return;
    L5:
        HashMap<String, String> r102 = this.f110688c;
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        r102.put("p1_s_f_u_e", r101);
        LiveRoomFpsMonitor.c(1, r100);
    }

    @Override // q81.d
    public final void m(long r100, String r101) {
        if (w(r100) == false) goto L5;
        return;
    L5:
        HashMap<String, String> r102 = this.f110688c;
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        r102.put("continue_show_s_f_u_e", r101);
    }

    @Override // q81.d
    public final void n(long r110, String r111) {
        y(this.f110688c.get("other_s_f_u_e"), r111, new LiveMkStallManager$notifyWidgetLoaded$1(this));
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L49
        i91 r101 = com.bytedance.android.live.core.tetris.widgets.g.c();     // Catch: Throwable -> L49
        Map<String, Map<String, Long>> r102 = null;
        if (r101 == null) goto L6;
        ArrayList<String> r103 = r101.i();     // Catch: Throwable -> L49
    L7:
        boolean r104 = false;
        if (r103 != null) goto L10;
    L13:
        boolean r105 = true;
    L14:
        if (r105 == true) goto L51;
        MiddlewareRoomContext r106 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, r110, 1);     // Catch: Throwable -> L49
        if (r106 == null) goto L19;
        r102 = r106.getWidgetMetrics();     // Catch: Throwable -> L49
    L19:
        if (r102 != null) goto L21;
    L22:
        r104 = true;
    L23:
        if (r104 == true) goto L51;
        Iterator<T> r107 = r103.iterator();     // Catch: Throwable -> L49
    L27:
        if (r107.hasNext() == false) goto L47;
        String r108 = (String) r107.next();     // Catch: Throwable -> L49
        if (r102 == null) goto L27;
        Map<String, Long> r109 = r102.get(r108);     // Catch: Throwable -> L49
        if (r109 == null) goto L27;
        int r112 = com.bytedance.android.livesdk.widget.monitor.c.f161850d;     // Catch: Throwable -> L49
        Long r113 = r109.get("load_start_from_user_enter");     // Catch: Throwable -> L49
        if (r113 == null) goto L37;
        String r114 = String.valueOf(r113.longValue());     // Catch: Throwable -> L49
        if (r114 == null) goto L37;
        this.f110688c.put(r108 + "-load_s_f_u_e", r114);     // Catch: Throwable -> L49
    L37:
        Long r115 = r109.get("load_finish_from_user_enter");     // Catch: Throwable -> L49
        if (r115 == null) goto L42;
        String r116 = String.valueOf(r115.longValue());     // Catch: Throwable -> L49
        if (r116 == null) goto L42;
        this.f110688c.put(r108 + "-load_e_f_u_e", r116);     // Catch: Throwable -> L49
    L42:
        Long r117 = r109.get("load_cost_time");     // Catch: Throwable -> L49
        if (r117 == null) goto L27;
        String r118 = String.valueOf(r117.longValue());     // Catch: Throwable -> L49
        if (r118 == null) goto L27;
        this.f110688c.put(r108 + "-load_cost", r118);     // Catch: Throwable -> L49
        goto L27
    L47:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L49
        goto L51
    L21:
        if (r102.isEmpty() == false) goto L23;
    L51:
        z("widget_duration", r110, r111);
        this.f110647h.postDelayed(new c(this), RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS);
        t0.a r119 = new t0.a(this.f110688c.get("is_first_room"), this.f110688c.get("has_preload_data"), this.f110688c.get("device_rate"), this.f110688c.get("live_mode"), this.f110688c.get("room_scene"));
        t0 r120 = LiveRoomFpsMonitor.f110673a;
        if (r120 == null) goto L54;
        r120.f111155b = r119;
    L54:
        ALogger.i("LiveRoomFpsMonitor", "updateCommonFpsParam =".concat(String.valueOf(r119)));
        LiveRoomFpsMonitor.f110677e.a(4, r110);
        LiveRoomFpsMonitor.c(5, r110);
        return;
    L10:
        if (r103.isEmpty() == true) goto L13;
        r105 = false;
        goto L14
    L6:
        r103 = null;
    L49:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L51
    }

    @Override // q81.d
    public final void o(long r100, String r101) {
        if (w(r100) == false) goto L5;
        return;
    L5:
        HashMap<String, String> r102 = this.f110688c;
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        r102.put("p2_duration", r101);
        y(this.f110688c.get("p2_s_f_u_e"), this.f110688c.get("p2_duration"), new LiveMkStallManager$notifyP2WidgetLoaded$1(this));
        HashMap<String, String> r103 = this.f110688c;
        ILinkServiceExternal r104 = (ILinkServiceExternal) jc1.k.f(ILinkServiceExternal.class);
        if (r104 == null) goto L11;
        Integer r105 = Integer.valueOf(r104.getEnterRoomLinkmicScene());
    L12:
        r103.put("room_scene", String.valueOf(r105));
        LiveRoomFpsMonitor.f110677e.a(2, r100);
        return;
    L11:
        r105 = null;
        goto L12
    }

    @Override // q81.d
    public final void p(long r100, String r101) {
        if (w(r100) == false) goto L5;
        return;
    L5:
        HashMap<String, String> r102 = this.f110688c;
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        r102.put("first_frame_ts", r101);
    }

    @Override // q81.d
    public final void r(long r100, String r101) {
        Boolean r102 = this.f110646g.get("commerce_duration");
        Boolean r103 = Boolean.TRUE;
        if (Intrinsics.areEqual(r102, r103) == false) goto L5;
        return;
    L5:
        this.f110646g.put("commerce_duration", r103);
        z("commerce_duration", r100, r101);
    }

    @Override // q81.d
    public final void s(long r100, String r101) {
        if (w(r100) == false) goto L5;
        return;
    L5:
        HashMap<String, String> r102 = this.f110688c;
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        r102.put("p0_s_f_u_e", r101);
        LiveRoomFpsMonitor.c(0, r100);
    }

    public final void y(String r100, String r101, Function1<? super String, Unit> r102) {
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L16
        Long r104 = null;
        if (r100 == null) goto L5;
        Long r105 = StringsKt.toLongOrNull(r100);     // Catch: Throwable -> L16
    L6:
        if (r101 == null) goto L8;
        r104 = StringsKt.toLongOrNull(r101);     // Catch: Throwable -> L16
    L8:
        if (r105 == null) goto L15;
        if (r104 != null) goto L11;
        return;
    L11:
        if (r105.longValue() > r104.longValue()) goto L22;
        r102.invoke(String.valueOf(r104.longValue() - r105.longValue()));     // Catch: Throwable -> L16
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
        return;
    L22:
        return;
    L15:
        return;
    L5:
        r105 = null;
    L16:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public final void z(String r100, long r101, String r102) {
        if (w(r101) == false) goto L5;
        return;
    L5:
        HashMap<String, String> r103 = this.f110688c;
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        r103.put(r100, r102);
        HashMap<String, Integer> r104 = this.f110645f;
        String r105 = String.valueOf(r101);
        Integer r106 = this.f110645f.get(String.valueOf(r101));
        if (r106 != null) goto L11;
        r106 = 0;
    L11:
        r104.put(r105, Integer.valueOf(r106.intValue() + 1));
        if (x(String.valueOf(r101)) == true) goto L14;
        return;
    L14:
        if (com.bytedance.android.livesdk.chatroom.room.apm.b.v(this) == false) goto L16;
        A();
    L16:
        this.f110686a = false;
    }

    @Override // q81.d
    public final void g(long r110, String r111, String r112, boolean r113, String r114, Function0<Unit> r115) {
        Intrinsics.checkNotNullParameter(r114, "from");
        if (w(r110) == false) goto L8;
        if (r115 == null) goto L23;
        Unit r100 = r115.invoke();
        return;
    L23:
        return;
    L8:
        if (r113 == false) goto L12;
        LiveRoomFpsMonitor.f110677e.a(0, r110);
    L12:
        if (Intrinsics.areEqual(this.f110688c.get("p0_loaded"), "1") == false) goto L21;
        if (r113 == true) goto L21;
        if (com.bytedance.android.livesdk.chatroom.room.apm.b.v(this) == false) goto L17;
        A();
    L17:
        this.f110686a = false;
        if (r115 == null) goto L24;
        Unit r101 = r115.invoke();
        return;
    L24:
        return;
    L21:
        this.f110648i.stopMonitorFps("mk_stall", new LiveMkStallManager$stop$1(this, r113, r115, r110, r112, r111));
        this.f110648i.releaseFpsMonitor("mk_stall");
    }
}
