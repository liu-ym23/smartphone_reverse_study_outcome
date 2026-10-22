package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "preloadInteractGame")
public final class k2 extends v0<r5, PreloadInteractGameResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f57523a = 0;

    public static final class a {
    }

    static {
    }

    public k2() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        r5 r102 = (r5) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        n1.a("preloadInteractGame", GsonProtectorUtils.toJson(new Gson(), r102));
        xr.f r103 = (xr.f) xr.s.a(xr.f.class);
        if (r103 == null) goto L8;
        xr.h r104 = r103.getGameService();
        if (r104 == null) goto L9;
        r104.preloadInteractGame(r102.b(), r102.a(), new GameCpPreloadInteractGameMethod$invoke$1(this), new GameCpPreloadInteractGameMethod$invoke$2(this));
        return;
    L9:
        return;
    }
}
