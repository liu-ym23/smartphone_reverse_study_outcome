package com.bytedance.android.live.livepullstream.api;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerScene;
import gl0.a;
import gl0.c;
import gl0.d;
import gl0.f;

/* JADX INFO: loaded from: classes46.dex */
@ServiceLookup("com.bytedance.android.live.livepullstream.PullStreamService")
public interface IPullStreamService extends a {
    /* synthetic */ ILivePlayerClient getLivePlayerClient(long r100, Bundle r101);

    c getLivePlayerOptimizer();

    d getLiveStatusErrorView(Context r100, ILivePlayerScene r101);

    f getStreamStrategyOptimizer();

    /* synthetic */ boolean preCreateSurface(Context r100, long r101, Bundle r102);

    /* synthetic */ boolean prePullStream(long r100, Bundle r101);

    void tryInstallBMFPlugin();

    void tryInstallPullStreamPlugin();

    /* synthetic */ void useSurfaceControl(Context r100, long r101, Bundle r102);
}
