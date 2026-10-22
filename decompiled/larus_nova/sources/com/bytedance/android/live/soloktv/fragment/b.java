package com.bytedance.android.live.soloktv.fragment;

import com.ss.bytedance.ies.videoclip.api.player.IPlayer;

/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f101201a = null;

    static {
        int[] r100 = new int[IPlayer.PlayerStatus.values().length];
        f101201a = r100;
        r100[IPlayer.PlayerStatus.FINISHED.ordinal()] = 1;
        r100[IPlayer.PlayerStatus.PAUSED.ordinal()] = 2;
        r100[IPlayer.PlayerStatus.PLAYING.ordinal()] = 3;
    }
}
