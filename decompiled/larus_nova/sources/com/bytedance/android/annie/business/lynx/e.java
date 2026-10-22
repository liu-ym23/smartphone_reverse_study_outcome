package com.bytedance.android.annie.business.lynx;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import q26.j;

/* JADX INFO: loaded from: classes43.dex */
public final class e extends com.bytedance.ies.bullet.lynx.b {
    public e() {
    }

    @Override // com.bytedance.ies.bullet.lynx.e
    public final com.bytedance.ies.bullet.lynx.a a(s26.a r100, j r101) {
        Intrinsics.checkNotNullParameter(r100, "service");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new d(r100, r101);
    }

    @Override // com.bytedance.ies.bullet.lynx.b
    public final d b(s26.a r100, j r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "service");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "sessionId");
        return new d(r100, r101, r102);
    }
}
