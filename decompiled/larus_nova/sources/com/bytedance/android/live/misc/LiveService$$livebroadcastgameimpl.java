package com.bytedance.android.live.misc;

import com.bytedance.android.live.broadcastgame.InteractGameMonitorService;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;

/* JADX INFO: loaded from: classes46.dex */
public class LiveService$$livebroadcastgameimpl {
    public LiveService$$livebroadcastgameimpl() {
    }

    public static void registerService() {
        jc1.k.l(IInteractGameMonitorService.class, new InteractGameMonitorService());
    }
}
