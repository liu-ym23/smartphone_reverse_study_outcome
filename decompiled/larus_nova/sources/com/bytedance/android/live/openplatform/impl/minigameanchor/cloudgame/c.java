package com.bytedance.android.live.openplatform.impl.minigameanchor.cloudgame;

import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import io.reactivex.disposables.CompositeDisposable;
import uf2.d0;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements com.bytedance.android.live.openplatform.impl.minigameanchor.cast.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0.b f85175a;

    public static final class a {
    }

    public static final class b implements d0.b.a {
        public b() {
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.openplatform.impl.minigameanchor.cast.c
    public final void setRadioMode(boolean r100) {
    }

    public c() {
        new CompositeDisposable();
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r100 = ILiveWrappedLivePusher.a.b();
        if (r100 == null) goto L5;
        d0.b r101 = r100.newLiveCoreVideoFrameAvailableListener(new b());
    L6:
        this.f85175a = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.openplatform.impl.minigameanchor.cast.c
    public final void a(int r100) {
        int r101 = qo0.a.f534145a;
        qo0.a.c("MiniGameSingleCastStreamV2", "setCameraPushFrameRotation " + r100);
    }
}
