package com.byted.mgl.merge.service.api.liveplayer;

import android.content.Context;
import com.bytedance.bdp.bdpbase.service.IBdpService;

/* JADX INFO: loaded from: classes43.dex */
public interface BdpGameLivePlayerService extends IBdpService {
    IGameTTLivePlayer createLivePlayer(Context r100);

    IGameLivePlayerDns getLivePlayerDnsOptimizer(Context r100);

    boolean isSupportNativeLivePlayer();
}
