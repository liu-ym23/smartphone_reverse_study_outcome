package com.bytedance.android.livesdk.chatroom.ui;

import android.graphics.Bitmap;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes8.dex */
public final class y4 implements Callable<Bitmap> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Bitmap call() throws Exception {
        ILivePlayerClient r100 = LivePlatformPlayerManager.f();
        if (r100 == null) goto L11;
        Bitmap r101 = r100.getBitmap();
        if (r101 == null) goto L8;
        return r101;
    L8:
        if (r100.getRenderView() != null) goto L10;
        return null;
    L10:
        return r100.getRenderView().getBitmap();
    L11:
        return null;
    }

    public y4() {
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Bitmap call() throws Exception {
        return call();
    }
}
