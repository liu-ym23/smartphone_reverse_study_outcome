package com.bytedance.android.livesdk.gift.platform.business.effect.player;

import com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener;
import com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController;

/* JADX INFO: loaded from: classes9.dex */
public final class m implements IPlayerController.FirstGLFrameListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f129486a;

    public m(k r100) {
        this.f129486a = r100;
    }

    @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController.FirstGLFrameListener
    public final void a() {
        IPlayerActionListener r100 = this.f129486a.f129469b;
        if (r100 == null) goto L6;
        r100.onFirstFrame();
        return;
    }
}
