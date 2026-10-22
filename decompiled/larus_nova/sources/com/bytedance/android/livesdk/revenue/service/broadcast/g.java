package com.bytedance.android.livesdk.revenue.service.broadcast;

import android.content.Context;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import com.bytedance.android.livehostapi.business.depend.livead.MiniAppConstants;
import com.bytedance.android.scope.o;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class g implements o, b {
    public g() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.revenue.service.broadcast.b
    public final boolean openMiniApp(Context r100, String r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "location");
        Intrinsics.checkNotNullParameter(r102, "liveParams");
        r102.put("scene", MiniAppConstants.Scene.INSTANCE.getAUDIENCE_IN_LIVE());
        IInteractGameService r103 = (IInteractGameService) k.f(IInteractGameService.class);
        if (r103 != null) goto L7;
        return false;
    L7:
        return r103.openMiniApp(r100, r101, r102);
    }
}
