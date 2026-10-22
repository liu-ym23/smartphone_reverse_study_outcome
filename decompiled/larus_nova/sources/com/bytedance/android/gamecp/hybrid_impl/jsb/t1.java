package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "game.closeGameDetail")
public final class t1 extends f<u1, GameCloseGameDetailResultModel> {

    public static final class a {
    }

    static {
    }

    public t1() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        u1 r102 = (u1) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        xr.f r103 = (xr.f) xr.s.a(xr.f.class);
        if (r103 == null) goto L5;
        r101.getContext();
        r103.j0();
    L5:
        String r104 = r102.a();
        if (r104 != null) goto L8;
    L11:
        boolean r105 = true;
    L12:
        if (r105 == true) goto L14;
        com.bytedance.android.gamecp.host_api.a.b().getActionHandleService().handle(r101.getContext(), r102.a());
    L14:
        GameCloseGameDetailResultModel r106 = new GameCloseGameDetailResultModel();
        r106.a(GameCloseGameDetailResultModel.Code.Success);
        r106.b("success");
        Unit r107 = Unit.INSTANCE;
        finishWithResult(r106);
        return;
    L8:
        if (r104.length() == 0) goto L11;
        r105 = false;
        goto L12
    }
}
