package com.bytedance.android.live.platformplayer.panel;

import com.bytedance.android.livesdk.message.model.nk;

/* JADX INFO: loaded from: classes46.dex */
public final class e implements vlc.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f85760a;

    public e(f r100) {
        this.f85760a = r100;
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if ((r100 instanceof nk) == true) goto L5;
        return;
    L5:
        this.f85760a.a((nk) r100);
    }
}
