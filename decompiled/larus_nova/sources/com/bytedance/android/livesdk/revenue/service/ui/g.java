package com.bytedance.android.livesdk.revenue.service.ui;

import android.content.Context;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdk.widget.z0;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class g implements d {
    public g() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.revenue.service.ui.d
    public final cs2.b yn(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        z0.a().getClass();
        return new cs2.b(new x0.b(r100, r101));
    }
}
