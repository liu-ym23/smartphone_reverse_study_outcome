package com.bytedance.android.livesdk.chatroom.resolution.tips.stall;

import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.larus.apm.impl.protector.RunnableProtector;
import jc1.k;

/* JADX INFO: loaded from: classes7.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VSStallSceneStrategy f110558a;

    public h(VSStallSceneStrategy r100) {
        this.f110558a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.android.livesdk.chatroom.vsplayer.api.b r100 = ((IVSPlayerService) k.n(IVSPlayerService.class)).provideVSPlayerTipService(this.f110558a.f110522i);     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.hidePlayerTip("resolution_downgrade");     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
