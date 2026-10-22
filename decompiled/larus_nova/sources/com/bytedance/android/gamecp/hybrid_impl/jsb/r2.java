package com.bytedance.android.gamecp.hybrid_impl.jsb;

import android.os.SystemClock;
import com.bytedance.android.live.browser.jsbridge.base.GameGetExplainCardEnterDataResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import w20.z8;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "game.getExplainCardEnterData")
public final class r2 extends w20.t0<z8, GameGetExplainCardEnterDataResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f57531a = 0;

    public static final class a {
    }

    static {
    }

    public r2() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        z8 r102 = (z8) r100;
        String r103 = "";
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        final long r104 = SystemClock.elapsedRealtime();
        mw.a r105 = (mw.a) xr.s.a(mw.a.class);
        if (r105 == null) goto L19;
        r105.reportJsbInvokeEvent(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("jsbName", "game.getExplainCardEnterData"), TuplesKt.to("status", "start")}));
    L19:
        String r106 = r102.a();     // Catch: Exception -> L12
        if (r106 != null) goto L8;
        r106 = "";
    L8:
        mw.a r107 = (mw.a) xr.s.a(mw.a.class);     // Catch: Exception -> L12
        if (r107 == null) goto L21;
        r107.getIntroduceCardEnterData(r106, new GameGetExplainCardEnterDataMethod$invoke$1(this, r104));     // Catch: Exception -> L12
        return;
    L21:
        return;
    L12:
        e = move-exception;
        String r108 = e.getMessage();
        if (r108 == null) goto L17;
        r103 = r108;
    L17:
        j(r103, r104);
    }

    public final void j(String r100, long r101) {
        GameGetExplainCardEnterDataResultModel r102 = new GameGetExplainCardEnterDataResultModel();
        r102.a(GameGetExplainCardEnterDataResultModel.Code.Success);
        GameGetExplainCardEnterDataResultModel.a r103 = new GameGetExplainCardEnterDataResultModel.a();
        r103.b(Boolean.FALSE);
        mw.a r104 = (mw.a) xr.s.a(mw.a.class);
        if (r104 == null) goto L5;
        List<String> r105 = r104.getPendingIntroduceCardMessage();
    L6:
        r103.a(r105);
        Unit r106 = Unit.INSTANCE;
        r102.b(r103);
        r102.c(r100);
        finishWithResult(r102);
        mw.a r107 = (mw.a) xr.s.a(mw.a.class);
        if (r107 == null) goto L10;
        r107.reportJsbInvokeEvent(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("jsbName", "game.getExplainCardEnterData"), TuplesKt.to("status", "fail"), TuplesKt.to("reason", r100), TuplesKt.to("jsbDuration", String.valueOf(SystemClock.elapsedRealtime() - r101))}));
        return;
    L10:
        return;
    L5:
        r105 = null;
        goto L6
    }
}
