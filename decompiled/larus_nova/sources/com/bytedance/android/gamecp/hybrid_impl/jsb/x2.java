package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.android.live.browser.jsbridge.base.GamePreloadImageResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import w20.c9;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "game.preloadImage")
public final class x2 extends w20.w0<c9, GamePreloadImageResultModel> {

    public static final class a {
    }

    static {
    }

    public x2() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        c9 r102 = (c9) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.a();
        if (r103 == null) goto L9;
        mw.a r104 = (mw.a) xr.s.a(mw.a.class);
        if (r104 == null) goto L7;
        r104.preloadImage(r103);
    L7:
        GamePreloadImageResultModel r105 = new GamePreloadImageResultModel();
        r105.a(GamePreloadImageResultModel.Code.Success);
        GamePreloadImageResultModel.a r106 = new GamePreloadImageResultModel.a();
        r106.a(Boolean.TRUE);
        Unit r107 = Unit.INSTANCE;
        r105.b(r106);
        finishWithResult(r105);
        return;
    }
}
