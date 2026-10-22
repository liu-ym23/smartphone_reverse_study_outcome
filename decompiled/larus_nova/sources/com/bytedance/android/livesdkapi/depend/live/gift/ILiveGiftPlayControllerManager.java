package com.bytedance.android.livesdkapi.depend.live.gift;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdkapi.depend.IDependency;
import com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController;

/* JADX INFO: loaded from: classes12.dex */
public interface ILiveGiftPlayControllerManager extends IDependency {
    ITextureViewPlayerController createTextureViewPlayer(LifecycleOwner r100);

    ILiveGiftPlayController get(int r100);

    ILiveGiftPlayController initialize(int r100, LifecycleOwner r101);

    ILiveGiftPlayController initializeForPlay(int r100, LifecycleOwner r101);

    void release(int r100);
}
