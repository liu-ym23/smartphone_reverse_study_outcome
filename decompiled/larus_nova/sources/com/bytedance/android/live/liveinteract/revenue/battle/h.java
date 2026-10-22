package com.bytedance.android.live.liveinteract.revenue.battle;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class h implements zt0.b {
    public h() {
    }

    @Override // zt0.b
    public final void a(String r100) {
        ALogger.i("CommonWidgetResouce", "#DressResourceDebug# [scoreIconMoveUri] onSyncSuccess id " + r100);
    }

    @Override // zt0.b
    public final void b(String r100, String r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "version");
        ALogger.i("CommonWidgetResouce", "#DressResourceDebug# [scoreIconMoveUri] onSyncFailed id " + r100);
    }
}
