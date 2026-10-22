package com.bytedance.android.live.broadcastgame.opengame.message;

import com.bytedance.android.livesdk.message.model.fh;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class s implements com.bytedance.android.live.broadcastgame.c0<r>, vlc.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.live.broadcastgame.b0 f60274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vlc.d f60275b;

    @Override // com.bytedance.android.live.broadcastgame.c0
    public final void release() {
        this.f60275b.removeMessageListener(this);
    }

    public s(vlc.d r100) {
        Intrinsics.checkNotNullParameter(r100, "messageManager");
        this.f60275b = r100;
    }

    @Override // com.bytedance.android.live.broadcastgame.c0
    public final void a(com.bytedance.android.live.broadcastgame.b0 r100) {
        Intrinsics.checkNotNullParameter(r100, "queue");
        this.f60274a = r100;
        this.f60275b.addMessageListener(MessageType.OPEN_GAME_DIAMOND_PAY_MESSAGE.getIntType(), this);
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if ((r100 instanceof fh) == false) goto L8;
        com.bytedance.android.live.broadcastgame.b0 r101 = this.f60274a;
        if (r101 == null) goto L9;
        fh r102 = (fh) r100;
        r101.insert(new r(r102.appId, r102.startId, r102.diamonds));
        return;
    L9:
        return;
    }
}
