package com.bytedance.android.live.broadcastgame.xplay;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayScene;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.larus.platform.model.upload.ResourceUploadError;
import com.lynx.tasm.LynxError;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class XplayMonitorSession implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Regex f61948f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f61949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f61950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f61951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Long> f61952d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.live.broadcastgame.api.xplay.p f61953e;

    public static final class Companion {
        public Companion() {
        }

        public static void c(k1 r100, final XplayMonitorSession r101) {
            Intrinsics.checkNotNullParameter(r100, "$this$monitorTaskDuration");
            Intrinsics.checkNotNullParameter(r101, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
            Function2<l1, m1.b, Unit> r102 = new XplayMonitorSession$Companion$monitorTaskDuration$1(r101);
            Intrinsics.checkNotNullParameter(r100, "$this$onComplete");
            Intrinsics.checkNotNullParameter(r102, "callback");
            r100.c(new XplayTasksDslKt$onComplete$1(r102));
        }

        public static /* synthetic */ void b(String r100, JSONObject r101, JSONObject r102) {
            a(r100, r101, new JSONObject(), r102);
        }

        public static void a(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
            if (com.bytedance.android.live.core.utils.v.a() == false) goto L5;
            int r104 = XplayLog.f61931a;
            XplayLog.c("XplayMonitorSession", r100 + ": " + r101 + ' ' + r102 + ' ' + r103);
        L5:
            LiveTracingMonitor.f(r100, LiveTracingMonitor.EventModule.XPLAY, r101, r102, r103);
        }
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    static {
        new Companion();
        f61948f = new Regex("[^_0-9a-zA-Z]");
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        this.f61949a = System.currentTimeMillis();
    }

    public XplayMonitorSession(com.bytedance.android.live.broadcastgame.api.xplay.p r100) {
        Intrinsics.checkNotNullParameter(r100, "newEnv");
        this.f61953e = r100;
        this.f61952d = new LinkedHashMap();
    }

    public final void a(JSONObject r100) {
        r100.put("app_id", this.f61953e.f59508h.f59485b);
        com.bytedance.android.live.broadcastgame.api.model.q0 r101 = this.f61953e.f59508h.f59495l;
        String r102 = "";
        if (r101 == null) goto L6;
        String r103 = r101.c();
        if (r103 == null) goto L6;
    L7:
        r100.put("game_id", r103);
        com.bytedance.android.live.broadcastgame.api.model.q0 r104 = this.f61953e.f59508h.f59495l;
        if (r104 == null) goto L11;
        String r105 = r104.b();
        if (r105 == null) goto L11;
    L12:
        r100.put("channel", r105);
        String r106 = this.f61953e.f59503c;
        if (r106 == null) goto L16;
        r102 = r106;
    L16:
        r100.put("anchor_id", r102);
        r100.put(EventConstants.ExtraJson.GAME_NAME, this.f61953e.f59508h.f59486c);
        r100.put("scene_type", String.valueOf(this.f61953e.f59506f.getSceneId()));
        if (this.f61953e.f59504d == false) goto L19;
        String r107 = "anchor";
    L20:
        r100.put("launch_from", r107);
        r100.put("is_xplay", 1);
        r100.put(BdpAppEventConstant.PARAMS_GAME_CATEGORY, IPerformanceManager.MODULE_BARRAGE);
        r100.put("app_version", this.f61953e.f59508h.f59492i);
        return;
    L19:
        r107 = SourceType.DEFAULT;
    L11:
        r105 = "";
    L6:
        r103 = "";
        goto L7
    }

    public final void d(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        if (this.f61950b == null) goto L5;
        return;
    L5:
        long r101 = System.currentTimeMillis() - this.f61949a;
        if ((r100 instanceof XplayException) == false) goto L8;
        XplayException r102 = (XplayException) r100;
        k(r101, 0, r102.getErrorInfo());
        c("xplay_exception", r102.getErrorInfo().a(), r102.getErrorInfo().b());
        return;
    L8:
        k(r101, 0, q.a.c(q.f62336c, null, r100, 3));
        int r103 = com.bytedance.android.live.broadcastgame.api.openplatform.h.a(r100);
        String r104 = com.bytedance.android.livesdk.utils.o1.a(r100);
        if (r104 != null) goto L11;
        r104 = "";
    L11:
        c("launch_throwable", r103, r104);
    }

    public final void h(int r100) {
        JSONObject r101 = new JSONObject();
        r101.put("status", r100);
        a(r101);
        Unit r102 = Unit.INSTANCE;
        JSONObject r103 = new JSONObject();
        a(r103);
        Companion.b("ttlive_xplay_continue_play", r101, r103);
    }

    public final void i(int r110, int r111) {
        JSONObject r100 = new JSONObject();
        r100.put("status", 0);
        r100.put("code", r110);
        r100.put("reason", r111);
        a(r100);
        Unit r101 = Unit.INSTANCE;
        JSONObject r102 = new JSONObject();
        a(r102);
        Companion.b("ttlive_xplay_force_stop", r100, r102);
        n("xplayForceStop", r110, "code: " + r110 + ", reason: " + r111);
        if (this.f61953e.f59506f != XplayScene.TalkRoom) goto L10;
        IInteractService r103 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r103 == null) goto L11;
        com.bytedance.android.live.liveinteract.utils.l r104 = r103.getLinkMicGameFullLinkMonitor();
        if (r104 == null) goto L12;
        com.bytedance.android.live.liveinteract.utils.l.a.a(r104, LinkMonitorData.XplayForceStop, null, null, r110, Integer.valueOf(r111), null, null, null, null, TTVideoEngineInterface.PLAYER_OPTION_SET_FIRST_RANGE_SIZE);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void j(int r100, q r101) {
        com.bytedance.android.live.broadcastgame.api.xplay.p r102 = this.f61953e;
        if (r102 == null) goto L9;
        com.bytedance.android.live.broadcastgame.api.xplay.s r103 = r102.f59510j;
        if (r103 == null) goto L9;
        if (r103.f59533g != true) goto L9;
        String r104 = "pod_merge";
    L10:
        JSONObject r105 = new JSONObject();
        r105.put("status", r100);
        r105.put("merge_type", r104);
        String r106 = null;
        if (r101 == null) goto L13;
        Integer r107 = Integer.valueOf(r101.a());
    L14:
        r105.put("error_code", r107);
        if (r101 == null) goto L19;
        ErrorCodeException r108 = r101.f62338b;
        if (r108 == null) goto L19;
        Integer r109 = Integer.valueOf(r108.getCode());
    L20:
        r105.put("cause_error_code", r109);
        a(r105);
        Unit r110 = Unit.INSTANCE;
        JSONObject r111 = new JSONObject();
        a(r111);
        if (r101 == null) goto L23;
        String r112 = r101.b();
    L24:
        r111.put("error_msg", r112);
        if (r101 == null) goto L29;
        ErrorCodeException r113 = r101.f62338b;
        if (r113 == null) goto L29;
        String r114 = r113.getMsg();
    L30:
        r111.put("cause_error_msg", r114);
        Map.Entry r115 = (Map.Entry) CollectionsKt.lastOrNull(((LinkedHashMap) this.f61952d).entrySet());
        if (r115 == null) goto L33;
        r106 = (String) r115.getKey();
    L33:
        if (r106 != null) goto L35;
        r106 = "";
    L35:
        r111.put("last_completed_task", r106);
        Companion.b("ttlive_xplay_server_merge_start", r105, r111);
        return;
    L29:
        r114 = null;
        goto L30
    L23:
        r112 = null;
    L19:
        r109 = null;
        goto L20
    L13:
        r107 = null;
    L9:
        r104 = "rtc_merge";
        goto L10
    }

    public final void c(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "failReason");
        Intrinsics.checkNotNullParameter(r102, "errorMsg");
        com.bytedance.android.live.broadcastgame.api.xplay.p r103 = this.f61953e;
        if (r103.f59506f == XplayScene.TalkRoom) goto L5;
        return;
    L5:
        if (r103.f59504d == false) goto L18;
        IInteractService r104 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r104 == null) goto L11;
        com.bytedance.android.live.liveinteract.utils.m r105 = r104.getLinkMicGameLogUtils();
        if (r105 == null) goto L11;
        r105.f(false, r100, String.valueOf(r101), r102);
    L11:
        IInteractService r106 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r106 == null) goto L19;
        com.bytedance.android.live.liveinteract.utils.n r107 = r106.getLinkMicGameTraceUtils();
        if (r107 == null) goto L20;
        r107.a(this.f61953e.f59504d, r100, r101, r102);
        return;
    L20:
        return;
    L19:
        return;
    }

    public final void g(int r100, int r101, String r102) {
        JSONObject r103 = new JSONObject();
        r103.put("status", r100);
        r103.put("error_code", r101);
        a(r103);
        Unit r104 = Unit.INSTANCE;
        JSONObject r105 = new JSONObject();
        a(r105);
        r105.put("error_msg", r102);
        Companion.b("ttlive_open_platform_app_start", r103, r105);
        JSONObject r106 = new JSONObject();
        r106.put("status", r100);
        r106.put("error_code", r101);
        r106.put("error_msg", r102);
        n("appStartApi", r101, r106.toString());
    }

    public final void k(long r210, int r310, q r311) {
        JSONObject r100 = new JSONObject();
        r100.put("status", r310);
        if (r311 == null) goto L5;
        Integer r101 = Integer.valueOf(r311.a());
    L6:
        r100.put("error_code", r101);
        if (r311 == null) goto L11;
        ErrorCodeException r102 = r311.f62338b;
        if (r102 == null) goto L11;
        Integer r103 = Integer.valueOf(r102.getCode());
    L12:
        r100.put("cause_error_code", r103);
        a(r100);
        Unit r104 = Unit.INSTANCE;
        JSONObject r105 = new JSONObject();
        r105.put("duration", r210);
        r105.put("retry_count", this.f61951c);
        JSONObject r110 = new JSONObject();
        a(r110);
        if (r311 == null) goto L15;
        String r111 = r311.b();
    L16:
        r110.put("error_msg", r111);
        if (r311 == null) goto L21;
        ErrorCodeException r112 = r311.f62338b;
        if (r112 == null) goto L21;
        String r113 = r112.getMsg();
    L22:
        r110.put("cause_error_msg", r113);
        Map.Entry r106 = (Map.Entry) CollectionsKt.lastOrNull(((LinkedHashMap) this.f61952d).entrySet());
        if (r106 == null) goto L25;
        String r107 = (String) r106.getKey();
    L27:
        if (r107 != null) goto L29;
        r107 = "";
        String r114 = r107;
    L30:
        r110.put("last_completed_task", r107);
        Companion.a("ttlive_xplay_start", r100, r105, r110);
        int r108 = 0;
        if (r310 != 1) goto L33;
        int r109 = 0;
    L34:
        JSONObject r115 = new JSONObject();
        r115.put("status", r310);
        if (r311 == null) goto L37;
        Integer r116 = Integer.valueOf(r311.a());
    L38:
        r115.put("error_code", r116);
        if (r311 == null) goto L41;
        String r117 = r311.b();
    L42:
        r115.put("error_msg", r117);
        if (r311 == null) goto L47;
        ErrorCodeException r118 = r311.f62338b;
        if (r118 == null) goto L47;
        Integer r119 = Integer.valueOf(r118.getCode());
    L48:
        r115.put("cause_error_code", r119);
        r115.put("duration", r210);
        r115.put("retry_count", this.f61951c);
        Map.Entry r120 = (Map.Entry) CollectionsKt.lastOrNull(((LinkedHashMap) this.f61952d).entrySet());
        if (r120 == null) goto L51;
        String r121 = (String) r120.getKey();
    L52:
        if (r121 != null) goto L54;
        r121 = r114;
    L54:
        r115.put("last_completed_task", r121);
        a(r115);
        n("xplayStart", r109, r115.toString());
        if (this.f61953e.f59506f != XplayScene.TalkRoom) goto L101;
        HashMap r122 = new HashMap();
        r122.put("xplay_duration", Long.valueOf(r210));
        Iterator r123 = ((LinkedHashMap) this.f61952d).entrySet().iterator();
    L58:
        if (r123.hasNext() == false) goto L60;
        Map.Entry r124 = (Map.Entry) r123.next();
        r122.put(((String) r124.getKey()) + "_duration", Long.valueOf(((Number) r124.getValue()).longValue()));
        goto L58
    L60:
        if (r310 == 0) goto L75;
        if (r310 != 1) goto L63;
        IInteractService r125 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r125 == null) goto L105;
        com.bytedance.android.live.liveinteract.utils.l r126 = r125.getLinkMicGameFullLinkMonitor();
        if (r126 == null) goto L106;
        com.bytedance.android.live.liveinteract.utils.l.a.a(r126, LinkMonitorData.XplayLoad, null, null, 0, null, null, null, null, r122, 254);
        return;
    L106:
        return;
    L105:
        return;
    L63:
        if (r310 != 2) goto L110;
        IInteractService r127 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r127 == null) goto L102;
        com.bytedance.android.live.liveinteract.utils.l r128 = r127.getLinkMicGameFullLinkMonitor();
        if (r128 == null) goto L103;
        com.bytedance.android.live.liveinteract.utils.l.a.a(r128, LinkMonitorData.XplayLoad, null, null, -102, null, ResourceUploadError.CANCELED, null, null, r122, 214);
        return;
    L103:
        return;
    L102:
        return;
    L110:
        return;
    L75:
        if (r311 == null) goto L79;
        XplayErrorCode r129 = r311.f62337a;
        if (r129 == null) goto L79;
        r108 = r129.getCode();
    L79:
        if (r108 != 0) goto L81;
        int r211 = -101;
    L82:
        IInteractService r130 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r130 == null) goto L108;
        com.bytedance.android.live.liveinteract.utils.l r131 = r130.getLinkMicGameFullLinkMonitor();
        if (r131 == null) goto L109;
        LinkMonitorData r132 = LinkMonitorData.XplayLoad;
        if (r311 == null) goto L91;
        ErrorCodeException r133 = r311.f62338b;
        if (r133 == null) goto L91;
        Integer r212 = Integer.valueOf(r133.getCode());
    L92:
        if (r311 == null) goto L97;
        XplayErrorCode r134 = r311.f62337a;
        if (r134 == null) goto L97;
        String r135 = r134.getErrorMsg();
        if (r135 == null) goto L97;
    L98:
        com.bytedance.android.live.liveinteract.utils.l.a.a(r131, r132, null, null, r211, r212, r135, null, null, r122, 198);
        return;
    L97:
        r135 = "unknown";
    L91:
        r212 = null;
        goto L92
    L109:
        return;
    L108:
        return;
    L81:
        r211 = r108;
        goto L82
    L101:
        return;
    L51:
        r121 = null;
    L47:
        r119 = null;
        goto L48
    L41:
        r117 = null;
        goto L42
    L37:
        r116 = null;
        goto L38
    L33:
        r109 = -1;
        goto L34
    L29:
        r114 = "";
        goto L30
    L25:
        r107 = null;
    L21:
        r113 = null;
        goto L22
    L15:
        r111 = null;
    L11:
        r103 = null;
        goto L12
    L5:
        r101 = null;
        goto L6
    }

    public final void n(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r102, com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG);
        if (this.f61953e.f59506f != XplayScene.TalkRoom) goto L10;
        IInteractService r103 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r103 == null) goto L11;
        com.bytedance.android.live.liveinteract.utils.n r104 = r103.getLinkMicGameTraceUtils();
        if (r104 == null) goto L12;
        r104.a(this.f61953e.f59504d, r100, r101, r102);
        return;
    L12:
        return;
    L11:
        return;
    }

    public static void f(XplayMonitorSession r100, String r101, Integer r102, String r103, a10.d r104, String r105, int r106) {
        if ((r106 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r106 & 4) == 0) goto L9;
        r103 = null;
    L9:
        if ((r106 & 8) == 0) goto L12;
        r104 = null;
    L12:
        if ((r106 & 16) == 0) goto L14;
        r105 = null;
    L14:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "type");
        JSONObject r107 = new JSONObject();
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L20
        r107.put("code", r102);     // Catch: Throwable -> L20
        r107.put("type", r101);     // Catch: Throwable -> L20
        if (r103 != null) goto L18;
        r103 = GsonHelper.get().toJson(r104);     // Catch: Throwable -> L20
    L18:
        r107.put("message", r103);     // Catch: Throwable -> L20
        r107.put(OnekeyLoginConstants.CU_KEY_SEQ, r105);     // Catch: Throwable -> L20
        r100.a(r107);     // Catch: Throwable -> L20
        Object r109 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L20
    L22:
        JSONObject r110 = new JSONObject();
        if (Result.m9455isFailureimpl(r109) == false) goto L25;
        r109 = r110;
    L25:
        JSONObject r111 = new JSONObject();
        r100.a(r111);
        Unit r112 = Unit.INSTANCE;
        Companion.b("ttlive_xplay_custom_message", (JSONObject) r109, r111);
        return;
    L20:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    }
}
