package com.bytedance.android.livesdk.player.statehandler;

import com.bytedance.android.livesdk.player.LivePlayerContext;
import com.bytedance.android.livesdk.player.api.ITTLivePlayer;
import com.bytedance.android.livesdk.player.i0;
import com.bytedance.android.livesdk.player.utils.g;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class PausedStateHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LivePlayerContext f156071a;

    public PausedStateHandler(LivePlayerContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f156071a = r100;
    }

    public final void a(i0 r100) {
        Intrinsics.checkNotNullParameter(r100, "effect");
        if ((r100 instanceof i0.c) == true) goto L5;
        return;
    L5:
        this.f156071a.e("PausedStateHandler handle() " + r100, false);
        ITTLivePlayer r101 = this.f156071a.f154929e;
        if (r101 == null) goto L8;
        r101.pause();
    L8:
        g.e(0, false, false, new PausedStateHandler$handle$1(this), 7);
    }
}
