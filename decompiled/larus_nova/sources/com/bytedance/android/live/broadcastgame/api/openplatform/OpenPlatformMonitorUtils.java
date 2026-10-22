package com.bytedance.android.live.broadcastgame.api.openplatform;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.livesdk.crash.SourceType;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class OpenPlatformMonitorUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f59388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f59389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final OpenPlatformMonitorUtils f59390c = null;

    public OpenPlatformMonitorUtils() {
    }

    static {
        f59390c = new OpenPlatformMonitorUtils();
        f59388a = -1;
        f59389b = -1;
    }

    public final void h(d r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, "appInfo");
        Intrinsics.checkNotNullParameter(r101, ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY);
        d(this, "ttlive_open_platform_audience_entrence_hide", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, r100, r101).c();
    }

    public static void o(Map r100, e r101, int r110) {
        OpenPlatformMonitorUtils r102 = f59390c;
        Intrinsics.checkNotNullParameter(r100, "appInfo");
        Intrinsics.checkNotNullParameter(r101, ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY);
        Object r103 = r100.get("game");
        Object r104 = null;
        if ((r103 instanceof u) == true) goto L5;
        r103 = null;
    L5:
        u r105 = (u) r103;
        if (r105 == null) goto L8;
        a("ttlive_open_platform_parse_schema", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, r105, r101, r110, null, null).c();
        return;
    L8:
        Object r111 = r100.get("app_id");
        if ((r111 instanceof String) == true) goto L11;
        r111 = null;
    L11:
        String r112 = (String) r111;
        Object r106 = r100.get("OPEN_APP_NAME");
        if ((r106 instanceof String) == true) goto L14;
        r106 = null;
    L14:
        String r107 = (String) r106;
        Object r108 = r100.get("schema");
        if ((r108 instanceof String) == false) goto L18;
        r104 = r108;
    L18:
        d(r102, "ttlive_open_platform_parse_schema", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, new d(r112, r107, (String) r104), r101).c();
    }

    public final void g(d r100, e r101, final String r102) {
        Intrinsics.checkNotNullParameter(r100, "appInfo");
        Intrinsics.checkNotNullParameter(r101, ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY);
        Intrinsics.checkNotNullParameter(r102, "clickLocation");
        g r103 = d(this, "ttlive_open_platform_audience_entrance_click", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, r100, r101);
        Function1<g, Unit> r104 = new OpenPlatformMonitorUtils$logEntranceClick$1(r102);
        Intrinsics.checkNotNullParameter(r104, "block");
        r104.invoke(r103);
        r103.c();
    }

    public final void l(u r100, e r101, final boolean r110) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r101, ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY);
        g r102 = b(this, "ttlive_open_platform_icon_click", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, r100, r101, 96);
        Function1<g, Unit> r103 = new OpenPlatformMonitorUtils$logIconClick$1(r110);
        Intrinsics.checkNotNullParameter(r103, "block");
        r103.invoke(r102);
        r102.c();
    }

    public static g e(String r100, LiveTracingMonitor.EventType r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "service");
        Intrinsics.checkNotNullParameter(r101, "eventType");
        Intrinsics.checkNotNullParameter(r103, "launchFrom");
        g r104 = new g(r100, r101, r102);
        JSONObject r105 = r104.f59425d;
        r105.put("launch_from", r103);
        r105.put("status", r102);
        return r104;
    }

    public final void j(d r100, e r101, final boolean r102, final boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "appInfo");
        Intrinsics.checkNotNullParameter(r101, ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY);
        g r104 = d(this, "ttlive_open_platform_audience_entrance_prepare", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, r100, r101);
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L5
        Function1<g, Unit> r106 = new OpenPlatformMonitorUtils$logEntrancePrepare$$inlined$runCatching$lambda$1(r102, r103);     // Catch: Throwable -> L5
        Intrinsics.checkNotNullParameter(r106, "block");     // Catch: Throwable -> L5
        r106.invoke(r104);     // Catch: Throwable -> L5
        Object r107 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r107) == false) goto L10;
        r107 = null;
    L10:
        g r108 = (g) r107;
        if (r108 == null) goto L16;
        r108.c();
        return;
    L16:
        return;
    L5:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public final void k(d r100, e r101, final long r102, final boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "appInfo");
        Intrinsics.checkNotNullParameter(r101, ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY);
        g r104 = d(this, "ttlive_open_platform_audience_entrance_show", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, r100, r101);
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L5
        Function1<g, Unit> r106 = new OpenPlatformMonitorUtils$logEntranceShow$$inlined$runCatching$lambda$1(r102, r103);     // Catch: Throwable -> L5
        Intrinsics.checkNotNullParameter(r106, "block");     // Catch: Throwable -> L5
        r106.invoke(r104);     // Catch: Throwable -> L5
        Object r107 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r107) == false) goto L10;
        r107 = null;
    L10:
        g r108 = (g) r107;
        if (r108 == null) goto L16;
        r108.c();
        return;
    L16:
        return;
    L5:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static /* synthetic */ g d(OpenPlatformMonitorUtils r100, String r101, LiveTracingMonitor.EventType r110, d r111, e r112) {
        r100.getClass();
        return c(r101, r110, r111, r112, 0, null, null, null);
    }

    public static void m(u r100, e r101, int r110, Integer r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r101, ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY);
        a("ttlive_open_platform_launch_check", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, r100, r101, r110, r111, r112).c();
    }

    public final void n(d r100, e r101, final boolean r102, final String r103, final boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "appInfo");
        Intrinsics.checkNotNullParameter(r101, ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY);
        Intrinsics.checkNotNullParameter(r103, "entranceStatus");
        g r105 = d(this, "ttlive_open_platform_audience_receive_entrance", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, r100, r101);
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L5
        final boolean r107 = false;
        Function1<g, Unit> r108 = new OpenPlatformMonitorUtils$logReceiveEntrance$$inlined$runCatching$lambda$1(r107, r102, r103, r104);     // Catch: Throwable -> L5
        Intrinsics.checkNotNullParameter(r108, "block");     // Catch: Throwable -> L5
        r108.invoke(r105);     // Catch: Throwable -> L5
        Object r109 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r109) == false) goto L10;
        r109 = null;
    L10:
        g r110 = (g) r109;
        if (r110 == null) goto L16;
        r110.c();
        return;
    L16:
        return;
    L5:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static /* synthetic */ g b(OpenPlatformMonitorUtils r100, String r101, LiveTracingMonitor.EventType r102, u r110, e r111, int r112) {
        r100.getClass();
        return a(r101, r102, r110, r111, 0, null, null);
    }

    public static g a(String r100, LiveTracingMonitor.EventType r101, final u r102, final e r103, final int r110, final Integer r111, final String r112) {
        g r104 = e(r100, r101, r110, "anchor");
        Function1<g, Unit> r105 = new OpenPlatformMonitorUtils$anchorEvent$1(r102, r103, r110, r111, r112);
        Intrinsics.checkNotNullParameter(r105, "block");
        r105.invoke(r104);
        return r104;
    }

    public static g c(String r100, LiveTracingMonitor.EventType r101, final d r102, final e r110, final int r111, final Integer r112, final String r113, final String r114) {
        g r103 = e(r100, r101, r111, SourceType.DEFAULT);
        Function1<g, Unit> r104 = new OpenPlatformMonitorUtils$audienceEvent$1(r102, r110, r111, r112, r113, r114);
        Intrinsics.checkNotNullParameter(r104, "block");
        r104.invoke(r103);
        return r103;
    }

    public static void i(d r110, e r111, int r112, final boolean r113, final long r114, Integer r115, String r116, String r117, int r210) {
        Object r100 = null;
        if ((r210 & 32) == 0) goto L5;
        Integer r101 = null;
    L7:
        if ((r210 & 64) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r210 & 128) == 0) goto L13;
        String r118 = null;
    L14:
        Intrinsics.checkNotNullParameter(r110, "appInfo");
        Intrinsics.checkNotNullParameter(r111, ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY);
        g r103 = c("ttlive_open_platform_audience_entrance_info", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, r110, r111, r112, r101, r102, r118);
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L17
        Function1<g, Unit> r105 = new OpenPlatformMonitorUtils$logEntranceInfo$$inlined$runCatching$lambda$1(r113, r114);     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter(r105, "block");     // Catch: Throwable -> L17
        r105.invoke(r103);     // Catch: Throwable -> L17
        Object r106 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L17
    L20:
        if (Result.m9455isFailureimpl(r106) == true) goto L23;
        r100 = r106;
    L23:
        g r107 = (g) r100;
        if (r107 == null) goto L29;
        r107.c();
        return;
    L29:
        return;
    L17:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    L13:
        r118 = r117;
        goto L14
    L9:
        r102 = r116;
        goto L11
    L5:
        r101 = r115;
        goto L7
    }

    public static void f(d r110, e r111, int r112, final boolean r113, boolean r114, long r115, Integer r210, String r211, String r212, int r213) {
        if ((r213 & 16) == 0) goto L5;
        final boolean r100 = false;
    L7:
        if ((r213 & 32) == 0) goto L9;
        final long r101 = 0;
    L10:
        Object r102 = null;
        if ((r213 & 64) == 0) goto L13;
        Integer r116 = null;
    L15:
        if ((r213 & 128) == 0) goto L17;
        String r117 = null;
    L19:
        if ((r213 & 256) == 0) goto L21;
        String r118 = null;
    L22:
        Intrinsics.checkNotNullParameter(r110, "appInfo");
        Intrinsics.checkNotNullParameter(r111, ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY);
        g r103 = c("ttlive_open_platform_entrance_visible_check", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, r110, r111, r112, r116, r117, r118);
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L25
        Function1<g, Unit> r105 = new OpenPlatformMonitorUtils$logAudienceVisibleCheck$$inlined$runCatching$lambda$1(r113, r100, r101);     // Catch: Throwable -> L25
        Intrinsics.checkNotNullParameter(r105, "block");     // Catch: Throwable -> L25
        r105.invoke(r103);     // Catch: Throwable -> L25
        Object r106 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L25
    L28:
        if (Result.m9455isFailureimpl(r106) == true) goto L31;
        r102 = r106;
    L31:
        g r107 = (g) r102;
        if (r107 == null) goto L37;
        r107.c();
        return;
    L37:
        return;
    L25:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L28
    L21:
        r118 = r212;
        goto L22
    L17:
        r117 = r211;
        goto L19
    L13:
        r116 = r210;
        goto L15
    L9:
        r101 = r115;
        goto L10
    L5:
        r100 = r114;
        goto L7
    }
}
