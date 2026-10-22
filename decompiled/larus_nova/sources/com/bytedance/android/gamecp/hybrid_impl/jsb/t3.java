package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "gamecpShowLiveFloatWindow")
public final class t3 extends z<u3, GamecpShowLiveFloatWindowResultModel> {

    public static final class a {
    }

    static {
    }

    public t3() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        u3 r102 = (u3) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (Intrinsics.areEqual(r102.a(), Boolean.TRUE) == false) goto L7;
        xr.f r103 = (xr.f) xr.s.a(xr.f.class);
        if (r103 == null) goto L11;
        r103.s0(r101.getContext());
        return;
    L11:
        return;
    L7:
        dw.g r104 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getLiveFloatViewService();
        if (r104 == null) goto L13;
        r104.stopFloatView();
        return;
    }
}
