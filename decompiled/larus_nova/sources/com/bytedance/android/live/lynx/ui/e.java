package com.bytedance.android.live.lynx.ui;

import com.ss.android.ugc.aweme.live.alphaplayer.listener.IMonitor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class e implements IMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveLynxAlphaPlayer f82734a;

    public e(LiveLynxAlphaPlayer r100) {
        this.f82734a = r100;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.listener.IMonitor
    public final void a(String r100, Exception r101) {
        Intrinsics.checkNotNullParameter(r100, "player");
        Intrinsics.checkNotNullParameter(r101, "e");
        this.f82734a.Q("failed when init media player, and player is " + r100 + ", error msg is " + r101 + ' ', this.f82734a.f82677g, -8);
        throw null;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.listener.IMonitor
    public final void monitor(boolean r100, String r101, int r102, int r103, String r104) {
        Intrinsics.checkNotNullParameter(r101, "playerType");
        Intrinsics.checkNotNullParameter(r104, "errorInfo");
        this.f82734a.Q("failed when monitor: state = " + r100 + ", playerType = " + r101 + ", what = " + r102 + ", extra = " + r103 + ", errorInfo = " + r104, this.f82734a.f82677g, -9);
        throw null;
    }
}
