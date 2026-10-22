package com.bytedance.android.live.liveinteract.animation.universalwidget;

import com.ss.android.ugc.aweme.live.alphaplayer.listener.IMonitor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class i implements IMonitor {
    public i() {
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
    }
}
