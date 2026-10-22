package com.bytedance.android.live.lynx.ui;

import com.lynx.tasm.base.LLog;
import com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController;
import com.ss.android.ugc.aweme.live.alphaplayer.listener.IProgressListener;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements IProgressListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveLynxAlphaPlayer f82732a;

    public c(LiveLynxAlphaPlayer r100) {
        this.f82732a = r100;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.listener.IProgressListener
    public final void onProgress(long r100) {
        IPlayerController r101 = this.f82732a.f82671a;     // Catch: Exception -> L7
        if (r101 == null) goto L5;
        r101.getDuration();     // Catch: Exception -> L7
    L5:
        this.f82732a.getClass();     // Catch: Exception -> L7
        throw null;     // Catch: Exception -> L7
    L7:
        e = move-exception;
        e.printStackTrace();
        LLog.e("x-alpha-video", e.toString());
    }
}
