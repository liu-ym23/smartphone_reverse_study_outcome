package com.bytedance.android.live.broadcastgame.xplay.singlecast;

/* JADX INFO: loaded from: classes45.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f62454a = null;

    static {
        int[] r100 = new int[IXplayGameCastService.IGameCastSession.Event.values().length];
        f62454a = r100;
        r100[IXplayGameCastService.IGameCastSession.Event.CastStarted.ordinal()] = 1;
        r100[IXplayGameCastService.IGameCastSession.Event.CastStopped.ordinal()] = 2;
        r100[IXplayGameCastService.IGameCastSession.Event.CastMinimized.ordinal()] = 3;
        r100[IXplayGameCastService.IGameCastSession.Event.CastResumed.ordinal()] = 4;
        r100[IXplayGameCastService.IGameCastSession.Event.ResumeCastClicked.ordinal()] = 5;
    }
}
