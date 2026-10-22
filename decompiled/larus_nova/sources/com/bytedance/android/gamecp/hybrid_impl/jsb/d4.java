package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "game.getGeckoInfo")
public final class d4 extends l<u2, GameGetGeckoInfoResultModel> {

    public static final class a {
    }

    static {
    }

    public d4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        u2 r102 = (u2) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Long r103 = com.bytedance.android.gamecp.host_api.a.b().getBrowserService().getGeckoLatestChannelVersion(r102.a());
        if (r103 == null) goto L5;
        long r104 = r103.longValue();
    L6:
        GameGetGeckoInfoResultModel.a r105 = new GameGetGeckoInfoResultModel.a();
        r105.a(Long.valueOf(r104));
        r105.b(String.valueOf(r104));
        GameGetGeckoInfoResultModel r106 = new GameGetGeckoInfoResultModel();
        r106.a(GameGetGeckoInfoResultModel.Code.Success);
        r106.b(r105);
        Unit r107 = Unit.INSTANCE;
        finishWithResult(r106);
        return;
    L5:
        r104 = 0;
        goto L6
    }
}
