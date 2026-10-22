package com.bytedance.android.gamecp.hybrid_impl.jsb;

import android.os.SystemClock;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.gamecp.host_api.model.Room;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "game.getExplainCardEnterRoomData")
public final class s2 extends k<t2, GameGetExplainCardEnterRoomDataResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f57538a = 0;

    public static final class a {
    }

    static {
    }

    public s2() {
    }

    public static JsonObject j(List r100) {
        JSONObject r101 = new JSONObject();
        bw.i r102 = com.bytedance.android.gamecp.host_api.a.b().getLiveService();
        if (r100 == null) goto L57;
        Iterator r103 = r100.iterator();
    L6:
        if (r103.hasNext() == false) goto L57;
        t2.a r104 = (t2.a) r103.next();
        String r105 = r104.a();
        if (r105 == null) goto L6;
        String r106 = r104.getType();
        if (Intrinsics.areEqual(r106, "int") == false) goto L12;
    L15:
        boolean r107 = true;
    L16:
        if (r107 == false) goto L19;
        Object r108 = r102.getLiveSettingsValue(r105, 0);
    L55:
        r101.put(r105, r108);
        goto L6
    L19:
        if (Intrinsics.areEqual(r104.getType(), "bool") == false) goto L22;
        r108 = r102.getLiveSettingsValue(r105, Boolean.FALSE);
        goto L55
    L22:
        if (Intrinsics.areEqual(r104.getType(), "string") == false) goto L24;
        r108 = r102.getLiveSettingsValue(r105, "");
        goto L55
    L24:
        Object r109 = null;
        if (Intrinsics.areEqual(r104.getType(), "object") == false) goto L40;
        String r110 = SliceInitService.DEFAULT_SWITCH;
        String r111 = (String) r102.getLiveSettingsValue(r105, SliceInitService.DEFAULT_SWITCH);
        if (r111 == null) goto L60;
        r110 = r111;
    L60:
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L32
        Object r113 = Result.m9449constructorimpl(new JSONObject(r110));     // Catch: Throwable -> L32
    L35:
        if (Result.m9455isFailureimpl(r113) == true) goto L38;
        r109 = r113;
    L38:
        r108 = (JSONObject) r109;
    L32:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L35
    L40:
        if (Intrinsics.areEqual(r104.getType(), "array") == false) goto L54;
        String r115 = "[]";
        String r116 = (String) r102.getLiveSettingsValue(r105, "[]");
        if (r116 == null) goto L58;
        r115 = r116;
    L58:
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L47
        Object r118 = Result.m9449constructorimpl(new JSONArray(r115));     // Catch: Throwable -> L47
    L50:
        if (Result.m9455isFailureimpl(r118) == true) goto L53;
        r109 = r118;
    L53:
        r108 = (JSONArray) r109;
    L47:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L50
    L54:
        r108 = null;
        goto L55
    L12:
        if (Intrinsics.areEqual(r106, ItemStyle.ITEM_STYLE_DOUBLE) == true) goto L15;
        r107 = false;
    L57:
        return GsonProtectorUtils.parse(new JsonParser(), r101.toString()).getAsJsonObject();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v32, types: [T, com.google.gson.JsonObject] */
    /* JADX WARN: Type inference failed for: r0v36 */
    /* JADX WARN: Type inference failed for: r0v37, types: [T, com.google.gson.JsonObject] */
    /* JADX WARN: Type inference failed for: r0v52, types: [T, com.google.gson.JsonObject] */
    /* JADX WARN: Type inference failed for: r0v55 */
    /* JADX WARN: Type inference failed for: r3v9, types: [T, com.google.gson.JsonObject] */
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r210) {
        t2 r100 = (t2) r110;
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        final long r111 = SystemClock.elapsedRealtime();
        mw.a r101 = (mw.a) xr.s.a(mw.a.class);
        if (r101 == null) goto L5;
        r101.reportJsbInvokeEvent(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("jsbName", "game.getExplainCardEnterRoomData"), TuplesKt.to("status", "start")}));
    L5:
        final Ref.ObjectRef r102 = new Ref.ObjectRef();
        r102.element = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L8
        r102.element = j(r100.a());     // Catch: Throwable -> L8
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L13;
        String r106 = String.valueOf(r105.getMessage());
        r102.element = new JsonObject();
        k("setting_fail", r106, r111);
    L13:
        Room r107 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getRoomData();
        if (r107 == null) goto L21;
        Long r108 = r107.getRoomId();
        if (r108 == null) goto L21;
        String r109 = String.valueOf(r108.longValue());
        if (r109 == null) goto L21;
        String r112 = r109;
    L22:
        Ref.ObjectRef r113 = new Ref.ObjectRef();
        r113.element = null;
        Ref.BooleanRef r114 = new Ref.BooleanRef();
        r114.element = false;
        mw.a r115 = (mw.a) xr.s.a(mw.a.class);     // Catch: Throwable -> L39
        if (r115 == null) goto L26;
        ?? r116 = r115.getToolbarData(r112, "", "");     // Catch: Throwable -> L39
    L27:
        r113.element = r116;     // Catch: Throwable -> L39
        if (r116 == 0) goto L32;
        JsonElement r117 = r116.get("isAudienceEntranceShow");     // Catch: Throwable -> L39
        if (r117 == null) goto L32;
        boolean r118 = r117.getAsBoolean();     // Catch: Throwable -> L39
    L33:
        r114.element = r118;     // Catch: Throwable -> L39
        if (r118 == false) goto L36;
        k("toolbar_success", "", r111);     // Catch: Throwable -> L39
    L37:
        Object r119 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L39
    L41:
        Throwable r120 = Result.m9452exceptionOrNullimpl(r119);
        if (r120 == null) goto L76;
        r120.getMessage();
        r113.element = new JsonObject();
        k("toolbar_fail", "toolbar_fail", r111);
    L76:
        mw.a r121 = (mw.a) xr.s.a(mw.a.class);     // Catch: Throwable -> L54
        if (r121 == null) goto L49;
        final Ref.ObjectRef r211 = r113;
        final String r122 = r112;
        final Ref.BooleanRef r123 = r114;
        List<String> r124 = null;
        Object r125 = "jsbName";
        Object r126 = "status";
        Object r127 = "game.getExplainCardEnterRoomData";
        Pair<Boolean, String> r128 = r121.getIntroduceCardEnterData(r112, new GameGetExplainCardEnterRoomDataMethod$invoke$$inlined$runCatching$lambda$1(this, r122, r102, r211, r123, r111));     // Catch: Throwable -> L52
    L50:
        Object r129 = Result.m9449constructorimpl(r128);     // Catch: Throwable -> L52
    L57:
        Throwable r130 = Result.m9452exceptionOrNullimpl(r129);
        if (r130 == null) goto L73;
        String r131 = String.valueOf(r130.getMessage());
        JsonObject r132 = (JsonObject) r102.element;
        if (r132 != null) goto L62;
        r132 = new JsonObject();
    L62:
        JsonObject r133 = (JsonObject) r211.element;
        if (r133 != null) goto L65;
        r133 = new JsonObject();
    L65:
        boolean r134 = r123.element;
        GameGetExplainCardEnterRoomDataResultModel r135 = new GameGetExplainCardEnterRoomDataResultModel();
        r135.a(GameGetExplainCardEnterRoomDataResultModel.Code.Success);
        GameGetExplainCardEnterRoomDataResultModel.a r136 = new GameGetExplainCardEnterRoomDataResultModel.a();
        r136.f(r132);
        r136.g(r133);
        r136.a(Boolean.valueOf(r134));
        r136.c(Boolean.FALSE);
        mw.a r137 = (mw.a) xr.s.a(mw.a.class);
        if (r137 == null) goto L68;
        List<String> r138 = r137.getPendingIntroduceCardMessage();
    L69:
        r136.b(r138);
        Unit r139 = Unit.INSTANCE;
        r135.b(r136);
        r135.c(r131);
        finishWithResult(r135);
        mw.a r140 = (mw.a) xr.s.a(mw.a.class);
        if (r140 == null) goto L82;
        r140.reportJsbInvokeEvent(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(r125, r127), TuplesKt.to(r126, "fail"), TuplesKt.to("reason", r131), TuplesKt.to("jsbDuration", String.valueOf(SystemClock.elapsedRealtime() - r111))}));
        return;
    L82:
        return;
    L68:
        r138 = r124;
        goto L69
    L73:
        return;
    L52:
        th = th;
    L56:
        Result.Companion r141 = Result.Companion;
        r129 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L57
    L49:
        r123 = r114;
        r211 = r113;
        r125 = "jsbName";
        r126 = "status";
        r127 = "game.getExplainCardEnterRoomData";
        r124 = null;
        r128 = null;
    L54:
        th = th;
        r123 = r114;
        r211 = r113;
        r125 = "jsbName";
        r126 = "status";
        r127 = "game.getExplainCardEnterRoomData";
        r124 = null;
        goto L56
    L36:
        k("toolbar_fail", "toolbar invisible", r111);     // Catch: Throwable -> L39
    L32:
        r118 = false;
        goto L33
    L26:
        r116 = 0;
    L39:
        th = move-exception;
        Result.Companion r142 = Result.Companion;
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L21:
        r112 = "";
    L8:
        th = move-exception;
        Result.Companion r143 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public static void k(String r100, String r101, long r102) {
        mw.a r103 = (mw.a) xr.s.a(mw.a.class);
        if (r103 == null) goto L6;
        r103.reportJsbInvokeEvent(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("jsbName", "game.getExplainCardEnterRoomData"), TuplesKt.to("status", r100), TuplesKt.to("reason", r101), TuplesKt.to("jsbDuration", String.valueOf(SystemClock.elapsedRealtime() - r102))}));
        return;
    }
}
