package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.android.live.browser.jsbridge.base.GameShowExplainCardLynxContainerResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.locallife.cube.PrefetchTiming;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import w20.d9;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "game.showExplainCardLynxContainer")
public final class i3 extends w20.x0<d9, GameShowExplainCardLynxContainerResultModel> {

    public static final class a {
    }

    static {
    }

    public i3() {
    }

    public static void j(String r100) {
        mw.a r101 = (mw.a) xr.s.a(mw.a.class);
        if (r101 == null) goto L6;
        HashMap r102 = new HashMap();
        r102.put("status", r100);
        r102.put("from", PrefetchTiming.JSB);
        Unit r103 = Unit.INSTANCE;
        r101.reportFullLinkEvent(r102);
        return;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        d9 r102 = (d9) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        j("show invoke");
        JsonObject r103 = r102.a();
        if (r103 == null) goto L15;
        mw.a r104 = (mw.a) xr.s.a(mw.a.class);
        if (r104 == null) goto L14;
        Boolean r105 = r102.b();
        boolean r106 = false;
        if (r105 == null) goto L9;
        boolean r107 = r105.booleanValue();
    L10:
        Boolean r108 = r102.c();
        if (r108 == null) goto L13;
        r106 = r108.booleanValue();
    L13:
        r104.showIntroduceCard(r103, r107, r106);
        goto L14
    L9:
        r107 = false;
    L14:
        GameShowExplainCardLynxContainerResultModel r109 = new GameShowExplainCardLynxContainerResultModel();
        r109.a(GameShowExplainCardLynxContainerResultModel.Code.Success);
        Unit r110 = Unit.INSTANCE;
        finishWithResult(r109);
        j("show success");
        return;
    L15:
        GameShowExplainCardLynxContainerResultModel r111 = new GameShowExplainCardLynxContainerResultModel();
        r111.a(GameShowExplainCardLynxContainerResultModel.Code.Failed);
        Unit r112 = Unit.INSTANCE;
        finishWithResult(r111);
        j("show fail");
    }
}
