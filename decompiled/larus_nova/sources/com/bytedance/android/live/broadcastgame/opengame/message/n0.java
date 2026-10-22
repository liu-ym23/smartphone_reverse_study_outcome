package com.bytedance.android.live.broadcastgame.opengame.message;

import com.bytedance.android.livesdk.message.model.hh;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class n0 implements com.bytedance.android.live.broadcastgame.c0<m0>, vlc.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.live.broadcastgame.b0 f60263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vlc.d f60264b;

    @Override // com.bytedance.android.live.broadcastgame.c0
    public final void release() {
        this.f60264b.removeMessageListener(this);
    }

    public n0(vlc.d r100) {
        Intrinsics.checkNotNullParameter(r100, "messageManager");
        this.f60264b = r100;
    }

    @Override // com.bytedance.android.live.broadcastgame.c0
    public final void a(com.bytedance.android.live.broadcastgame.b0 r100) {
        Intrinsics.checkNotNullParameter(r100, "queue");
        this.f60263a = r100;
        this.f60264b.addMessageListener(MessageType.OPEN_GAME_OPEN_REWARD_MESSAGE.getIntType(), this);
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r110) {
        Intrinsics.checkNotNullParameter(r110, "message");
        if ((r110 instanceof hh) == false) goto L8;
        com.bytedance.android.live.broadcastgame.b0 r100 = this.f60263a;
        if (r100 == null) goto L9;
        hh r111 = (hh) r110;
        r100.insert(new m0(r111.appId, r111.startId, r111.rewardId, r111.rewardCount, r111.rewardDiamonds, r111.rewardName));
        return;
    L9:
        return;
    }
}
