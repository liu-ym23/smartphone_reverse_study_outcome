package com.bytedance.android.livesdk.gamecp;

import com.bytedance.android.livesdk.chatroom.utils.n3;
import com.bytedance.android.livesdkapi.service.gamecp.ILiveIMService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b0 implements ILiveIMService {
    public b0() {
    }

    @Override // com.bytedance.android.livesdkapi.service.gamecp.ILiveIMService
    public final void removeMessageListener(long r100, vlc.l r101) {
        Intrinsics.checkNotNullParameter(r101, "listener");
        vlc.d r102 = n3.c(r100);
        if (r102 == null) goto L6;
        r102.removeMessageListener(r101);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.service.gamecp.ILiveIMService
    public final void addMessageListener(long r100, String r101, vlc.l r102) {
        Intrinsics.checkNotNullParameter(r101, "messageType");
        Intrinsics.checkNotNullParameter(r102, "listener");
        vlc.d r103 = n3.c(r100);
        if (r103 == null) goto L6;
        r103.addMessageListener(r101, r102);
        return;
    }
}
