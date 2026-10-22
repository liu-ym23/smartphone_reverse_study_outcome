package com.bytedance.android.live.broadcastgame.opengame.sonicgame;

/* JADX INFO: loaded from: classes45.dex */
public final /* synthetic */ class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f61063a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f61064b = null;

    static {
        int[] r100 = new int[SonicGamePlugin.SonicState.values().length];
        f61063a = r100;
        r100[SonicGamePlugin.SonicState.RESUME.ordinal()] = 1;
        r100[SonicGamePlugin.SonicState.PAUSE.ordinal()] = 2;
        r100[SonicGamePlugin.SonicState.DESTROY.ordinal()] = 3;
        int[] r101 = new int[GameCastStrategy.values().length];
        f61064b = r101;
        r101[GameCastStrategy.VIDEO_CHATROOM.ordinal()] = 1;
        r101[GameCastStrategy.VIDEO_SINGLE.ordinal()] = 2;
    }
}
