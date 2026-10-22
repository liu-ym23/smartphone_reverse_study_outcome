package com.bytedance.android.live.broadcastgame.opengame.openapi;

import android.os.Build;
import com.bytedance.android.live.broadcastgame.opengame.cloudgame.model.LiveCloudGameSceneType;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.IHostGameCP;
import com.bytedance.android.livehostapi.business.depend.gamecp.cloudgame.IGameCPCloudGameService;
import com.bytedance.android.livehostapi.business.depend.gamecp.cloudgame.LiveCloudGameCloseStatus;
import com.bytedance.android.livehostapi.business.depend.gamecp.cloudgame.LiveGameOrientation;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.huawei.hms.android.SystemUtils;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Queue;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class OpenCloudGameMethod extends BaseOpenMethod<JSONObject> {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "openCloudGame";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [T, com.bytedance.android.livehostapi.business.depend.gamecp.cloudgame.LiveGameOrientation] */
    /* JADX WARN: Type inference failed for: r5v14, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v16, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v18, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v21, types: [T, java.lang.String] */
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(JSONObject r210, CallContext r211) {
        Intrinsics.checkNotNullParameter(r210, "params");
        Intrinsics.checkNotNullParameter(r211, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r100 = m10.a.f511570a;
        m10.a.a("OpenCloudGameMethod", "Params: " + r210);
        final Ref.ObjectRef r101 = new Ref.ObjectRef();
        r101.element = LiveGameOrientation.LANDSCAPE;
        final Ref.ObjectRef r102 = new Ref.ObjectRef();
        r102.element = "";
        final Ref.ObjectRef r103 = new Ref.ObjectRef();
        r103.element = "";
        final Ref.ObjectRef r110 = new Ref.ObjectRef();
        r110.element = "";
        final Ref.ObjectRef r104 = new Ref.ObjectRef();
        r104.element = "";
        Ref.ObjectRef r111 = new Ref.ObjectRef();
        r111.element = "";
        final ArrayList r105 = new ArrayList();
        final LinkedHashMap r112 = new LinkedHashMap();
        boolean r113 = true;
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L30
        JSONObject r106 = r210.optJSONObject("info");     // Catch: Throwable -> L30
        if (r106 == null) goto L78;
    L9:
        r101.element = LiveGameOrientation.values()[r106.optInt("orientation")];     // Catch: Throwable -> L30
        Object r107 = this.f60306d.f60809m.f61085k.get("OPEN_APP_ICON_URL");     // Catch: Throwable -> L30
        if ((r107 instanceof String) == true) goto L12;
        r107 = null;
    L12:
        String r108 = (String) r107;     // Catch: Throwable -> L30
        T r109 = r108;
        if (r108 != null) goto L15;
        r109 = "";
    L15:
        r102.element = r109;     // Catch: Throwable -> L30
        r103.element = r106.optString("gameName");     // Catch: Throwable -> L30
        r110.element = r106.optString("id");     // Catch: Throwable -> L30
        r111.element = r106.optString("roundId");     // Catch: Throwable -> L30
        Ref.ObjectRef r212 = r111;
        String r115 = "OpenCloudGameMethod";
        r104.element = StringsKt.substringAfter$default((String) r110.element, "###", null, 2, null);     // Catch: Throwable -> L28
        JSONObject r116 = r106.optJSONObject("cpExtra");     // Catch: Throwable -> L28
        boolean r117 = r106.optBoolean("prefer");     // Catch: Throwable -> L28
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L20;
    L22:
        r105.add(new Pair("cpExtra", r116));     // Catch: Throwable -> L28
        LiveCloudGameSceneType.Companion.getClass();     // Catch: Throwable -> L28
        r105.add(new Pair("prefer", LiveCloudGameSceneType.a.a(this, r117).getExtra2Game()));     // Catch: Throwable -> L28
        r105.add(new Pair("enter_from", "live_miniplay"));     // Catch: Throwable -> L28
        boolean r118 = !LiveCloudGameSceneType.a.a(this, r117).isUnLimited();
        Object r119 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L26
    L34:
        IGameCPCloudGameService r120 = ((IHostGameCP) jc1.k.n(IHostGameCP.class)).getCloudGameService();
        if (r120 == null) goto L50;
        long r121 = this.f60306d.f60809m.f61075a;
        String r122 = (String) r110.element;
        Pair[] r123 = new Pair[10];
        r123[0] = TuplesKt.to("user_id", ((IUserService) jc1.k.n(IUserService.class)).user().n());
        r123[1] = TuplesKt.to("room_id", String.valueOf(this.f60306d.f60809m.f61075a));
        r123[2] = TuplesKt.to("game_id", (String) r110.element);
        r123[3] = TuplesKt.to(EventConstants.ExtraJson.GAME_NAME, (String) r103.element);
        Room r124 = this.f60306d.n();
        if (r124 == null) goto L39;
        LiveMode r125 = r124.getStreamType();
    L40:
        r123[4] = TuplesKt.to("live_type", String.valueOf(r125));
        r123[5] = TuplesKt.to("app_id", this.f60306d.f60809m.f61083i);
        PluginContext r126 = this.f60306d;
        r123[6] = TuplesKt.to("app_name", r126.f60809m.b(r126.f60811o));
        r123[7] = TuplesKt.to("orientation", String.valueOf(((LiveGameOrientation) r101.element).getType()));
        if (r118 == false) goto L43;
        String r127 = "2";
    L44:
        r123[8] = TuplesKt.to("scene", r127);
        if (this.f60306d.f60811o == false) goto L47;
        String r128 = "anchor";
    L48:
        r123[9] = TuplesKt.to("launch_from", r128);
        r120.initMonitor(r121, r122, MapsKt.mapOf(r123));
        goto L50
    L47:
        r128 = SourceType.DEFAULT;
        goto L48
    L43:
        r127 = "1";
        goto L44
    L39:
        r125 = null;
    L50:
        IGameCPCloudGameService r213 = ((IHostGameCP) jc1.k.n(IHostGameCP.class)).getCloudGameService();
        if (r213 == null) goto L54;
        r213.monitorEvent(this.f60306d.f60809m.f61075a, (String) r110.element, "ttlive_cg_launch_start", MapsKt.emptyMap());
    L54:
        if (Result.m9452exceptionOrNullimpl(r119) == null) goto L56;
    L73:
        IGameCPCloudGameService r129 = ((IHostGameCP) jc1.k.n(IHostGameCP.class)).getCloudGameService();
        if (r129 == null) goto L76;
        r129.monitorEvent(this.f60306d.f60809m.f61075a, (String) r110.element, "ttlive_cg_launch_fail", MapsKt.mapOf(new Pair[]{TuplesKt.to("error_code", String.valueOf(LiveCloudGameCloseStatus.FAIL.getStatus())), TuplesKt.to("error_msg", "params_error " + Result.m9452exceptionOrNullimpl(r119))}));
    L76:
        OpenApiErrorInfo r130 = OpenApiErrorInfo.INCORRECT_PARAMS;
        JSONObject r131 = new JSONObject();
        r131.put("code", r130.getErrorCode());
        r131.put("errNo", r130.getErrorCode());
        r131.put("errMsg", "openCloudGame:fail " + r130.getErrorMsg());
        Unit r132 = Unit.INSTANCE;
        BaseOpenMethod.q(this, r131, r130);
        return;
    L56:
        if (StringsKt.isBlank((String) r110.element) == true) goto L73;
        if (StringsKt.isBlank((String) r104.element) == true) goto L73;
        final Ref.ObjectRef r133 = r212;
        Function0<Unit> r134 = new OpenCloudGameMethod$call$openGame$1(this, r103, r102, r110, r104, r105, r112, r101, r133);
        String r135 = Build.MANUFACTURER;
        if (r135 != null) goto L63;
    L65:
        r113 = false;
    L66:
        if (r113 == true) goto L68;
    L70:
        this.f60306d.f60807k.a();
        r134.invoke();
    L71:
        JSONObject r136 = new JSONObject();
        r136.put("code", 0);
        r136.put("errCode", 0);
        r136.put("errMsg", "openCloudGame:ok");
        Unit r137 = Unit.INSTANCE;
        r(r136);
        int r138 = m10.a.f511570a;
        m10.a.a(r115, "Cloud game " + ((String) r110.element) + " launch success.");
        return;
    L68:
        if (com.bytedance.android.livesdk.config.c1.f119913a.getValue().booleanValue() == false) goto L70;
        r134.invoke();
        this.f60306d.f60807k.a();
        goto L71
    L63:
        if (r135.contains(SystemUtils.PRODUCT_HUAWEI) == false) goto L65;
    L26:
        th = th;
    L33:
        Result.Companion r139 = Result.Companion;
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L34
    L20:
        if (com.bytedance.android.livesdk.sharedpref.b.f158221u3.getValue().booleanValue() == false) goto L22;
        r117 = true;
    L28:
        th = th;
    L32:
        r118 = true;
        goto L33
    L78:
        r106 = new JSONObject();     // Catch: Throwable -> L7
    L7:
        th = th;
        r212 = r111;
        r115 = "OpenCloudGameMethod";
        r118 = true;
    L30:
        th = th;
        r212 = r111;
        r115 = "OpenCloudGameMethod";
        goto L32
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public /* bridge */ /* synthetic */ void call(JSONObject r100, CallContext r101) {
        call2(r100, r101);
    }

    public OpenCloudGameMethod(PluginContext r100, g0 r101, Queue<Long> r102) {
        Intrinsics.checkNotNullParameter(r100, "pluginContext");
        Intrinsics.checkNotNullParameter(r101, "openApi");
        super(r100, r102);
    }
}
