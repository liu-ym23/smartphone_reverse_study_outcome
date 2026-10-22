package com.bytedance.android.live.broadcastgame.opengame.message;

import com.bytedance.android.livesdk.message.model.ih;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class k0 implements com.bytedance.android.live.broadcastgame.c0<j0>, vlc.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.live.broadcastgame.b0 f60241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vlc.d f60242b;

    @Override // com.bytedance.android.live.broadcastgame.c0
    public final void release() {
        this.f60242b.removeMessageListener(this);
    }

    public k0(vlc.d r100) {
        Intrinsics.checkNotNullParameter(r100, "messageManager");
        this.f60242b = r100;
    }

    @Override // com.bytedance.android.live.broadcastgame.c0
    public final void a(com.bytedance.android.live.broadcastgame.b0 r100) {
        Intrinsics.checkNotNullParameter(r100, "queue");
        this.f60241a = r100;
        this.f60242b.addMessageListener(MessageType.OPEN_GAME_PERFORMANCE_FINISH_MESSAGE.getIntType(), this);
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if ((r100 instanceof ih) == false) goto L8;
        com.bytedance.android.live.broadcastgame.b0 r101 = this.f60241a;
        if (r101 == null) goto L9;
        ih r102 = (ih) r100;
        String r103 = r102.taskId;
        r101.insert(new j0(r102.appId, r103));
        return;
    L9:
        return;
    }
}
