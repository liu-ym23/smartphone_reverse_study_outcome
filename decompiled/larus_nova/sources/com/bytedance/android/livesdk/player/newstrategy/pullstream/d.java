package com.bytedance.android.livesdk.player.newstrategy.pullstream;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class d implements e {
    public d() {
    }

    @Override // com.bytedance.android.livesdk.player.newstrategy.pullstream.e
    public final void a(j r100, q r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "result");
        ALogger.i("FinishInterceptor", "result: " + r101);
    }
}
