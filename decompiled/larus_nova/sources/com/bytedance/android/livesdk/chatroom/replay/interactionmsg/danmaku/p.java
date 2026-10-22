package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku;

import com.ss.ugc.live.barrage.barrage.AbsBarrage;
import com.ss.ugc.live.barrage.controller.ScrollBarrageController;

/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class p implements ScrollBarrageController.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayDanmakuWidget f109068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f109069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f109070c;

    public /* synthetic */ p(ReplayDanmakuWidget r100, float r101, float r102) {
        this.f109068a = r100;
        this.f109069b = r101;
        this.f109070c = r102;
    }

    public final float a(AbsBarrage r100) {
        ReplayDanmakuWidget r101 = this.f109068a;
        float r102 = this.f109069b;
        float r103 = this.f109070c;
        r101.getClass();
        float r104 = 1.0f;
        if ((r100 instanceof com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.barrage.a) == false) goto L7;
        float r105 = r100.f458058f.width();
        if (r105 <= r102) goto L7;
        r104 = Math.min((((r105 - r102) / r103) * 0.05f) + 1.0f, 1.2f);
    L7:
        com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.barrage.d r106 = r101.f108930j;
        if (r106 != null) goto L10;
        return r104;
    L10:
        return r104 * r106.f109000e.getFactor();
    }
}
