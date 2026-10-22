package com.bytedance.android.live.misc;

import com.bytedance.android.livesdk.chatroom.vs.player.VSPlayerServiceImpl;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;

/* JADX INFO: loaded from: classes46.dex */
public class LiveService$$livereplay {
    public LiveService$$livereplay() {
    }

    public static void registerP0Service() {
    }

    public static void registerP2Service() {
    }

    public static void registerP1Service() {
        jc1.k.l(IVSPlayerService.class, new VSPlayerServiceImpl());
    }

    public static void registerService() {
        jc1.k.l(IVSPlayerService.class, new VSPlayerServiceImpl());
    }
}
