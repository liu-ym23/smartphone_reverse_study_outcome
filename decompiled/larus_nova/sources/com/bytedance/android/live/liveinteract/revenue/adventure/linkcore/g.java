package com.bytedance.android.live.liveinteract.revenue.adventure.linkcore;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class g implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a f77934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.b f77935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static h f77936c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f77937d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f77938e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f77939f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f77940g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Observer<Integer> f77941h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final c f77942i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final b f77943j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f77944k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final g f77945l = null;

    public static final class a extends IHostAppMonitorListener.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f77946a;

        public a() {
        }

        @Override // com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener.Stub, com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener
        public final void appEnterBackground(boolean r100, boolean r101) {
            ALogger.i("AdventureLinkService", "appEnterBackground, background: " + r100 + ", isRegister: " + r101);
            this.f77946a = r100;
            if (r101 == true) goto L24;
            com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r102 = g.f77934a;
            com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r103 = g.f77934a;
            if (r103 != null) goto L7;
            return;
        L7:
            if (r103.f77918e == true) goto L9;
            return;
        L9:
            if (r100 == false) goto L13;
            Intrinsics.checkNotNullParameter("appEnterBackground", "reason");
            ALogger.i("AdventureLinkService", "enterBackground, reason: appEnterBackground");
            com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r104 = g.f77934a;
            if (r104 == null) goto L27;
            r104.e();
            return;
        L27:
            return;
        L13:
            Intrinsics.checkNotNullParameter("appEnterForeground", "reason");
            ALogger.i("AdventureLinkService", "enterForeground, reason: appEnterForeground");
            com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r105 = g.f77934a;
            if (r105 == null) goto L16;
            r105.h();
        L16:
            com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r106 = g.f77934a;
            if (r106 != null) goto L19;
            return;
        L19:
            if (r106.f77918e == true) goto L21;
            return;
        L21:
            if (g.f77937d == false) goto L31;
            g.c(true, "enterForeground");
            return;
        L31:
            return;
        }
    }

    public static final class b implements k {
        public b() {
        }

        @Override // com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.k
        public final void a(boolean r100) {
            ALogger.i("AdventureLinkService", "onLocalAudioPublishStateChanged, isPublishOpen: " + r100);
        }
    }

    public static final class c implements l {

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f77947a = null;

            static {
                f77947a = new a();
            }

            public a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r100 = g.f77934a;     // Catch: Throwable -> L4
                g.e(false, "remote_user_leave");     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public static final class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f77948a = null;

            static {
                f77948a = new b();
            }

            public b() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r100 = g.f77934a;     // Catch: Throwable -> L4
                g.e(false, "self_user_join_failed");     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public c() {
        }

        @Override // com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.l
        public final void g() {
            ALogger.i("AdventureLinkService", "onSelfLeaveRtcRoomSuccess");
        }

        @Override // com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.l
        public final void d(String r100) {
            ALogger.i("AdventureLinkService", "onRemoteRtcUserJoined, rtcUserId: " + r100);
        }

        @Override // com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.l
        public final void e(String r100) {
            ALogger.i("AdventureLinkService", "onRemoteRtcUserLeave, rtcUserId: ".concat(r100));
            MainThreadPostUtils.b(a.f77947a);
        }

        @Override // com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.l
        public final void f(int r100) {
            ALogger.i("AdventureLinkService", "onSelfJoinRtcRoomFailed, errorCode: " + r100);
            MainThreadPostUtils.b(b.f77948a);
        }

        @Override // com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.l
        public final void b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "rtcRoomId");
            Intrinsics.checkNotNullParameter(r101, "rtcUserId");
            ALogger.i("AdventureLinkService", "onSelfJoinRtcRoomSuccess, rtcRoomId: " + r100 + ", rtcUserId: " + r101);
            com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r102 = g.f77934a;
            g.c(true, "onSelfJoinRtcRoomSuccess");
        }
    }

    public g() {
    }

    static {
        f77945l = new g();
        f77940g = "";
        f77942i = new c();
        f77943j = new b();
        a r100 = new a();
        f77944k = r100;
        IMiddlewareHostApp r101 = (IMiddlewareHostApp) jc1.k.f(IMiddlewareHostApp.class);
        if (r101 == null) goto L6;
        r101.registerLiveLifeCycleListener(r100);
        return;
    }

    public static void b(String r100) {
        ALogger.i("AdventureLinkService", "leaveRtcRoom, source: " + r100);
        String r101 = ei0.a.f472759a;
        if (r100 != null) goto L5;
        r100 = "unknown";
    L5:
        Intrinsics.checkNotNullParameter(r100, "reason");
        JSONObject r102 = new JSONObject();
        r102.put("reason", r100);
        r102.put("adventure_call_user_type", ei0.a.f472759a);
        r102.put("code", "native");
        int r103 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiRevenue, MultiTraceData$TraceEvent.AdventureCall, "adventure_call_leave_rtc_room", 0, null, r102, 88);
        StringCompanionObject r104 = StringCompanionObject.INSTANCE;
        ALogger.d("AdventureFullLinkMonitor", String.format("leaveRtcRoom, extra: %s", Arrays.copyOf(new Object[]{r102}, 1)));
        f2.g();
        com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r105 = f77934a;
        if (r105 == null) goto L15;
        ALogger.i("AdventureLinkEngine", "leaveRtcRoom");
        mi6.b r106 = r105.f77916c;
        if (r106 == null) goto L10;
        r106.leaveRoom();
    L10:
        m00.g r107 = r105.f77914a;
        if (r107 == null) goto L15;
        com.bytedance.android.live.pushstream.d r108 = r107.getLiveStream();
        if (r108 == null) goto L15;
        r108.f1("adventure leave rtc room", new uv0.a(LiveRequestSourceRole.Business, "AdventureLinkEngine.leaveRtcRoom.stopAudio", null));
    L15:
        d("leaveRtcRoom");
    }

    public static void d(String r100) {
        ALogger.i("AdventureLinkService", "release, source: ".concat(r100));
        f77938e = false;
        f77939f = false;
        com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r101 = f77934a;
        if (r101 == null) goto L5;
        r101.c();
    L5:
        f77934a = null;
        com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.b r102 = f77935b;
        if (r102 == null) goto L8;
        ALogger.i("AdventureLinkSecurityManager", "release");
        r102.f77926a.clear();
    L8:
        f77935b = null;
        c(false, "release");
        h r103 = f77936c;
        if (r103 == null) goto L11;
        MainThreadPostUtils.b(new j(r103));
    L11:
        f77936c = null;
        f77937d = false;
        f77940g = "";
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.m
    public final void a(String r100) {
        ALogger.i("AdventureLinkService", "checkRtcRoom, source: " + r100);
        f2.g();
        com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r101 = f77934a;
        boolean r102 = false;
        if (r101 == null) goto L12;
        ALogger.i("AdventureLinkEngine", "checkRtcRoom, isSelfJoinedRTCRoom: " + r101.f77918e + ", isRemoteJoinedRTCRoom: " + r101.f77919f);
        if (r101.f77918e == true) goto L7;
    L9:
        boolean r103 = false;
    L10:
        if (r103 != true) goto L12;
        r102 = true;
        goto L12
    L7:
        if (r101.f77919f == false) goto L9;
        r103 = true;
    L12:
        e(r102, r100);
    }

    public static void c(boolean r100, String r101) {
        ALogger.i("AdventureLinkService", "muteLiveRoom, isMute: " + r100 + ", source: " + r101 + ", isMuteByAdventure: " + f77937d);
        if (r100 == false) goto L8;
        f77937d = true;
        h r102 = f77936c;
        if (r102 == null) goto L13;
        MainThreadPostUtils.b(new i(r102, true));
        return;
    L13:
        return;
    L8:
        if (f77937d == false) goto L15;
        f77937d = false;
        h r103 = f77936c;
        if (r103 == null) goto L16;
        MainThreadPostUtils.b(new i(r103, false));
        return;
    L16:
        return;
    }

    public static void e(boolean r110, String r111) {
        StringBuilder r100 = new StringBuilder("sendCheckRtcRoomResult, success: ");
        r100.append(r110);
        r100.append(", source: ");
        r100.append(r111);
        r100.append(", isSelfJoin: ");
        com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r101 = f77934a;
        if (r101 == null) goto L5;
        Boolean r102 = Boolean.valueOf(r101.f77918e);
    L6:
        r100.append(r102);
        r100.append(", isRemoteJoin: ");
        com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r103 = f77934a;
        if (r103 == null) goto L9;
        Boolean r104 = Boolean.valueOf(r103.f77919f);
    L10:
        r100.append(r104);
        ALogger.i("AdventureLinkService", r100.toString());
        f2.g();
        String r105 = ei0.a.f472759a;
        if (r111 != null) goto L13;
        r111 = "unknown";
    L13:
        String r106 = f77940g;
        com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r107 = f77934a;
        if (r107 == null) goto L16;
        boolean r108 = r107.f77918e;
    L17:
        if (r107 == null) goto L19;
        boolean r109 = r107.f77919f;
    L20:
        Intrinsics.checkNotNullParameter(r111, "reason");
        Intrinsics.checkNotNullParameter(r106, "rtcExtInfo");
        JSONObject r112 = new JSONObject();
        r112.put("reason", r111);
        r112.put("adventure_call_user_type", ei0.a.f472759a);
        r112.put("adventure_call_rtc_ext_info", r106);
        r112.put("isSuccess", r110);
        r112.put("isSelfUserJoinSuccess", r108);
        r112.put("isRemoteUserJoinSuccess", r109);
        int r113 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiRevenue, MultiTraceData$TraceEvent.AdventureCall, "adventure_call_check_rtc_room", 0, null, r112, 88);
        StringCompanionObject r114 = StringCompanionObject.INSTANCE;
        ALogger.d("AdventureFullLinkMonitor", String.format("checkRtcRoom, extra: %s", Arrays.copyOf(new Object[]{r112}, 1)));
        JsonObject r115 = new JsonObject();
        r115.addProperty("success", Boolean.valueOf(r110));
        ai0.c r116 = ai0.c.f3721a;
        Intrinsics.checkNotNullParameter("check_rtc_room", "type");
        JsonObject r117 = new JsonObject();
        r117.addProperty("type", "check_rtc_room");
        r117.add("data", r115);
        ih0.b r118 = ((IInteractService) jc1.k.n(IInteractService.class)).dynamicService(null);
        if (r118 == null) goto L23;
        r118.Dk("adventure", "adventure_event", r117, false);
    L23:
        if (r110 == false) goto L25;
        MainThreadPostUtils.b(new f(null));
        return;
    L25:
        b("check_rtc_room_failed");
        return;
    L19:
        r109 = false;
        goto L20
    L16:
        r108 = false;
        goto L17
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }
}
