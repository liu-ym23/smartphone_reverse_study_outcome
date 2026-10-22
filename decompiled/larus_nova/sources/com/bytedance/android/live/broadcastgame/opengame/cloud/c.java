package com.bytedance.android.live.broadcastgame.opengame.cloud;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements CloudExecutor.a {
    public c() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.cloud.CloudExecutor.a
    public final void onSuccess() {
        ALogger.d("CloudExecutor_CloudRequestListener", "onSuccess");
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.cloud.CloudExecutor.a
    public final void a(CloudResultType$ClientResultType r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "clientResultType");
        Intrinsics.checkNotNullParameter(r101, "errMsg");
        CloudExecutor.a.C0985a.a(r100, r101);
    }
}
