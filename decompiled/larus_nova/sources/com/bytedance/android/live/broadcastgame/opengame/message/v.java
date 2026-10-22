package com.bytedance.android.live.broadcastgame.opengame.message;

import com.bytedance.android.livesdk.message.model.bh;
import com.bytedance.android.livesdk.message.model.gh;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class v implements com.bytedance.android.live.broadcastgame.c0<u>, vlc.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.live.broadcastgame.b0 f60282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vlc.d f60283b;

    @Override // com.bytedance.android.live.broadcastgame.c0
    public final void release() {
        this.f60283b.removeMessageListener(this);
    }

    public v(vlc.d r100) {
        Intrinsics.checkNotNullParameter(r100, "messageManager");
        this.f60283b = r100;
    }

    @Override // com.bytedance.android.live.broadcastgame.c0
    public final void a(com.bytedance.android.live.broadcastgame.b0 r100) {
        Intrinsics.checkNotNullParameter(r100, "queue");
        this.f60282a = r100;
        this.f60283b.addMessageListener(MessageType.OPEN_GAME_FOLLOW_STATUS_MESSAGE.getIntType(), this);
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r110) {
        Intrinsics.checkNotNullParameter(r110, "message");
        if ((r110 instanceof gh) == false) goto L16;
        List<bh> r100 = ((gh) r110).items;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L12;
        bh r103 = (bh) r102.next();
        if ((!r103.userInfo.isEmpty()) == false) goto L10;
        t r104 = new t(r103.userInfo, r103.secNickName, r103.secAvatarUrl, r103.action, String.valueOf(r103.timestamp));
    L11:
        r101.add(r104);
        goto L6
    L10:
        r104 = new t(r103.userInfo, r103.secNickName, r103.secAvatarUrl, r103.action, String.valueOf(r103.timestamp));
        goto L11
    L12:
        com.bytedance.android.live.broadcastgame.b0 r105 = this.f60282a;
        if (r105 == null) goto L20;
        r105.insert(new u(r101));
        return;
    L20:
        return;
    }
}
