package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.android.live.browser.jsbridge.base.GameDismissExplainCardLynxContainerResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import w20.y8;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "game.dismissExplainCardLynxContainer")
public final class l2 extends w20.s0<y8, GameDismissExplainCardLynxContainerResultModel> {

    public static final class a {
    }

    static {
    }

    public l2() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        y8 r102 = (y8) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
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
        r104.hideIntroduceCard(r103, r107, r106);
        goto L14
    L9:
        r107 = false;
    L14:
        GameDismissExplainCardLynxContainerResultModel r109 = new GameDismissExplainCardLynxContainerResultModel();
        r109.a(GameDismissExplainCardLynxContainerResultModel.Code.Success);
        Unit r110 = Unit.INSTANCE;
        finishWithResult(r109);
        return;
    L15:
        GameDismissExplainCardLynxContainerResultModel r111 = new GameDismissExplainCardLynxContainerResultModel();
        r111.a(GameDismissExplainCardLynxContainerResultModel.Code.Failed);
        Unit r112 = Unit.INSTANCE;
        finishWithResult(r111);
    }
}
