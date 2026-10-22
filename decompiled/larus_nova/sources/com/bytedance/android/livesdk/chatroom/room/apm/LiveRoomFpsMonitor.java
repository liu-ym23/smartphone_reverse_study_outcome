package com.bytedance.android.livesdk.chatroom.room.apm;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.room.t0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.performance.IStallCallback;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public final class LiveRoomFpsMonitor implements q81.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t0 f110673a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Double f110674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Long f110675c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f110676d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final LiveRoomFpsMonitor f110677e = null;

    public static final class a implements IStallCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f110678a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f110679b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f110680c;

        @Override // com.bytedance.android.livesdkapi.performance.IStallCallback
        public final void onFpsReady(double r100, JSONObject r110) {
            if (r100 >= 0) goto L6;
            return;
        L6:
            if (this.f110678a != 5) goto L8;
            t0 r101 = LiveRoomFpsMonitor.f110673a;
            LiveRoomFpsMonitor.f110674b = Double.valueOf(r100);
            LiveRoomFpsMonitor.f110675c = Long.valueOf(this.f110679b);
            ALogger.i("LiveRoomFpsMonitor", "stopWidgetFpsMonitor PreLongTimeFps =" + LiveRoomFpsMonitor.f110674b);
        L12:
            if (this.f110678a != 4) goto L43;
            long r102 = this.f110679b;
            ALogger.i("LiveRoomFpsMonitor", "start report log roomId=" + r102);
            if (r102 <= 0) goto L25;
            t0 r103 = LiveRoomFpsMonitor.f110673a;
            if (r103 == null) goto L25;
            Double r104 = LiveRoomFpsMonitor.f110674b;
            if (r103.f111154a.containsKey(r102 + IPerformanceManager.SCENE_LIVE_ENTER_ROOM_ALL_WIDGET_LOAD_FPS) == true) goto L22;
            if (r104 != null) goto L22;
            boolean r105 = false;
        L23:
            if (r105 != true) goto L25;
            boolean r106 = true;
        L26:
            if (r106 == false) goto L44;
            t0 r107 = LiveRoomFpsMonitor.f110673a;
            if (r107 == null) goto L45;
            HashMap r108 = new HashMap();
            Map<String, Double> r109 = r107.f111154a;
            StringBuilder r111 = new StringBuilder();
            r111.append(r102);
            t0 r112 = LiveRoomFpsMonitor.f110673a;
            r111.append(LiveRoomFpsMonitor.b(0));
            LinkedHashMap r113 = (LinkedHashMap) r109;
            r108.put("p0_widget_fps", String.valueOf(r113.get(r111.toString())));
            r108.put("p1_widget_fps", String.valueOf(r113.get(r102 + LiveRoomFpsMonitor.b(1))));
            r108.put("p2_widget_fps", String.valueOf(r113.get(r102 + LiveRoomFpsMonitor.b(2))));
            r108.put("all_widget_fps", String.valueOf(r113.get(r102 + LiveRoomFpsMonitor.b(4))));
            Double r114 = LiveRoomFpsMonitor.f110674b;
            if (r114 == null) goto L32;
            r108.put("long_time_watch_fps", String.valueOf(r114.doubleValue()));
        L32:
            r108.put("current_room_id", String.valueOf(r102));
            t0.a r115 = r107.f111155b;
            if (r115 == null) goto L35;
            r108.put("device_rate", r115.f111158c);
            r108.put("is_first_room", r115.f111156a);
            r108.put("has_preload_data", r115.f111157b);
            r108.put("live_model", r115.f111159d);
            r108.put("scene", r115.f111160e);
        L35:
            Long r116 = LiveRoomFpsMonitor.f110675c;
            if (r116 == null) goto L38;
            r108.put(com.bytedance.android.ec.core.event.a.KEY_PRE_ROOM_ID, String.valueOf(r116.longValue()));
        L38:
            j0.l().sendLog("livesdk_enter_room_fps", r108, new Object[0]);
            LiveRoomFpsMonitor.f110674b = null;
            LiveRoomFpsMonitor.f110675c = null;
            if (r107 == null) goto L41;
            ((LinkedHashMap) r107.f111154a).clear();
            r107.f111155b = null;
            ALogger.i("LiveRoomFpsMonitor", "cleatData");
        L41:
            ALogger.i("LiveRoomFpsMonitor", "==========end send log success==========");
            return;
        L45:
            return;
        L44:
            return;
        L22:
            r105 = true;
        L25:
            r106 = false;
            goto L26
        L43:
            return;
        L8:
            t0 r117 = LiveRoomFpsMonitor.f110673a;
            if (r117 == null) goto L12;
            String r118 = this.f110679b + this.f110680c;
            Intrinsics.checkNotNullParameter(r118, "key");
            r117.f111154a.put(r118, Double.valueOf(r100));
            ALogger.i("LiveRoomFpsMonitor", "update fps key=" + r118 + ", fps=" + r100);
            goto L12
        }

        public a(int r100, long r101, String r102) {
            this.f110678a = r100;
            this.f110679b = r101;
            this.f110680c = r102;
        }

        @Override // com.bytedance.android.livesdkapi.performance.IStallCallback
        public final void onBlockReady(long r100, int r101, long r102) {
            ALogger.i("LiveRoomFpsMonitor", "onBlockReady level =" + this.f110678a);
        }
    }

    public LiveRoomFpsMonitor() {
    }

    public static String b(int r100) {
        if (r100 != 0) goto L4;
        return IPerformanceManager.SCENE_LIVE_ENTER_ROOM_P0_WIDGET_LOAD_FPS;
    L4:
        if (r100 != 1) goto L6;
        return IPerformanceManager.SCENE_LIVE_ENTER_ROOM_P1_WIDGET_LOAD_FPS;
    L6:
        if (r100 != 2) goto L8;
        return IPerformanceManager.SCENE_LIVE_ENTER_ROOM_P2_WIDGET_LOAD_FPS;
    L8:
        if (r100 != 4) goto L10;
        return IPerformanceManager.SCENE_LIVE_ENTER_ROOM_ALL_WIDGET_LOAD_FPS;
    L10:
        if (r100 == 5) goto L12;
        return "";
    L12:
        return IPerformanceManager.SCENE_LIVE_LONG_TIME_WATCH_FPS;
    }

    static {
        f110677e = new LiveRoomFpsMonitor();
        f110673a = new t0();
        f110676d = InfraKotlinExtsKt.mainThreadLazy(LiveRoomFpsMonitor$hostPerformanceManager$2.INSTANCE);
    }

    public static void c(int r100, long r101) {
        if (r101 <= 0) goto L13;
        String r102 = b(r100);
        Lazy r103 = f110676d;
        IPerformanceManager r104 = (IPerformanceManager) r103.getValue();
        if (r104 == null) goto L8;
        r104.releaseFpsMonitor(r102);
    L8:
        IPerformanceManager r105 = (IPerformanceManager) r103.getValue();
        if (r105 == null) goto L12;
        r105.startMonitorFps(r102);
        return;
    L12:
        return;
    }

    @Override // q81.g
    public final void a(int r100, long r101) {
        if (r100 != 5) goto L6;
        ALogger.i("LiveRoomFpsMonitor", "stopWidgetFpsMonitor roomId =" + r101);
    L6:
        if (r101 > 0) goto L8;
        return;
    L8:
        String r102 = b(r100);
        Lazy r103 = f110676d;
        IPerformanceManager r104 = (IPerformanceManager) r103.getValue();
        if (r104 == null) goto L11;
        r104.stopMonitorFps(r102, new a(r100, r101, r102));
    L11:
        IPerformanceManager r105 = (IPerformanceManager) r103.getValue();
        if (r105 == null) goto L15;
        r105.releaseFpsMonitor(r102);
        return;
    }
}
