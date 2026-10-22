package com.bytedance.android.gamecp.hybrid_impl.jsb;

import android.os.SystemClock;
import com.bytedance.android.live.browser.jsbridge.base.GameGetToolbarDataResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import w20.a9;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "game.getToolbarData")
public final class v2 extends w20.u0<a9, GameGetToolbarDataResultModel> {

    public static final class a {
    }

    static {
    }

    public v2() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        a9 r102 = (a9) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        long r103 = SystemClock.elapsedRealtime();
        j("start", r103, "");
        String r104 = r102.a();
        if (r104 != null) goto L5;
        r104 = "";
    L5:
        mw.a r105 = (mw.a) xr.s.a(mw.a.class);
        Boolean r106 = null;
        if (r105 == null) goto L8;
        JsonObject r107 = r105.getToolbarData(r104, "", "");
    L9:
        if (r107 != null) goto L13;
        mw.a r108 = (mw.a) xr.s.a(mw.a.class);
        if (r108 == null) goto L13;
        r108.reportFullLinkEvent(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("status", "toolbar error"), TuplesKt.to("reason", "toolbar data is null")}));
    L13:
        if (r107 != null) goto L15;
        r107 = new JsonObject();
    L15:
        GameGetToolbarDataResultModel r109 = new GameGetToolbarDataResultModel();
        r109.a(GameGetToolbarDataResultModel.Code.Success);
        GameGetToolbarDataResultModel.a r110 = new GameGetToolbarDataResultModel.a();
        r110.c(r107);
        JsonElement r111 = r107.get("isAudienceEntranceShow");
        if (r111 == null) goto L18;
        r106 = Boolean.valueOf(r111.getAsBoolean());
    L18:
        r110.b(r106);
        if (Intrinsics.areEqual(r110.a(), Boolean.TRUE) == false) goto L21;
        j("success", r103, "");
    L22:
        Unit r112 = Unit.INSTANCE;
        r109.b(r110);
        finishWithResult(r109);
        return;
    L21:
        j("fail", r103, "toolbar invisible");
        goto L22
    L8:
        r107 = null;
        goto L9
    }

    public static void j(String r100, long r101, String r102) {
        mw.a r103 = (mw.a) xr.s.a(mw.a.class);
        if (r103 == null) goto L6;
        r103.reportJsbInvokeEvent(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("jsbName", "game.getToolbarData"), TuplesKt.to("status", r100), TuplesKt.to("reason", r102), TuplesKt.to("jsbDuration", String.valueOf(SystemClock.elapsedRealtime() - r101))}));
        return;
    }
}
