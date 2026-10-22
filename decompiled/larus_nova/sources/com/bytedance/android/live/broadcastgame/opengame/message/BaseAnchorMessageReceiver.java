package com.bytedance.android.live.broadcastgame.opengame.message;

import com.bytedance.android.live.broadcastgame.channel.receiver.helper.ImAlignHelper;
import com.bytedance.android.live.broadcastgame.opengame.message.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public abstract class BaseAnchorMessageReceiver<T extends k> implements com.bytedance.android.live.broadcastgame.c0<T>, vlc.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.live.broadcastgame.b0 f60182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f60183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final vlc.d f60184c;

    public abstract int b();

    public abstract Long c(tlc.d r100);

    public abstract boolean d(tlc.d r100);

    public abstract a e(tlc.d r100);

    @Override // com.bytedance.android.live.broadcastgame.c0
    public final void release() {
        this.f60184c.removeMessageListener(this);
    }

    public BaseAnchorMessageReceiver(vlc.d r100) {
        Intrinsics.checkNotNullParameter(r100, "messageManager");
        this.f60184c = r100;
        this.f60183b = LazyKt.lazy(new BaseAnchorMessageReceiver$imAlignHelper$2(this));
    }

    @Override // com.bytedance.android.live.broadcastgame.c0
    public final void a(com.bytedance.android.live.broadcastgame.b0 r100) {
        Intrinsics.checkNotNullParameter(r100, "queue");
        this.f60182a = r100;
        this.f60184c.addMessageListener(b(), this);
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        ImAlignHelper r101 = (ImAlignHelper) this.f60183b.getValue();
        boolean r102 = d(r100);
        Long r103 = c(r100);
        if (r103 == null) goto L5;
        long r104 = r103.longValue();
    L6:
        r101.a(new b0(r102, r104, r100));
        return;
    L5:
        r104 = 0;
        goto L6
    }
}
