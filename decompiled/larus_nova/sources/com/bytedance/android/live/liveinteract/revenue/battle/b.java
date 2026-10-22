package com.bytedance.android.live.liveinteract.revenue.battle;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements zt0.b {
    public b() {
    }

    @Override // zt0.b
    public final void a(String r100) {
        ALogger.i("CommonWidgetResouce", "#DressResourceDebug# [getCrownSettingAnim] onSyncSuccess id " + r100);
    }

    @Override // zt0.b
    public final void b(String r100, String r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "version");
        ALogger.i("CommonWidgetResouce", "#DressResourceDebug# [getCrownSettingAnim] onSyncFailed id " + r100);
    }
}
