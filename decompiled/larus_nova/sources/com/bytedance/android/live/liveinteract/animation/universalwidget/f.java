package com.bytedance.android.live.liveinteract.animation.universalwidget;

import com.bytedance.android.live.core.log.ALogger;
import com.ss.android.ugc.aweme.live.alphaplayer.listener.IMonitor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f implements IMonitor {
    public f() {
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.listener.IMonitor
    public final void a(String r100, Exception r101) {
        Intrinsics.checkNotNullParameter(r100, "player");
        Intrinsics.checkNotNullParameter(r101, "e");
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.listener.IMonitor
    public final void monitor(boolean r100, String r101, int r102, int r103, String r104) {
        Intrinsics.checkNotNullParameter(r101, "playerType");
        Intrinsics.checkNotNullParameter(r104, "errorInfo");
        ALogger.i("MultiLinkEffect.Widget", "monitor:  state = " + r100 + "  playerType = " + r101 + "  what = " + r102 + "  extra = " + r103 + "  errorInfo = " + r104);
    }
}
