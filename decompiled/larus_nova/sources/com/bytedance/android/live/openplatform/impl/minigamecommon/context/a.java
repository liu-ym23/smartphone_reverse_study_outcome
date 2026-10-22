package com.bytedance.android.live.openplatform.impl.minigamecommon.context;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f85361a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f85362b = null;

    static {
        int[] r100 = new int[OnMiniGameLifecycleChangeListener.MiniGameLifecycle.values().length];
        f85361a = r100;
        r100[OnMiniGameLifecycleChangeListener.MiniGameLifecycle.OnCreate.ordinal()] = 1;
        r100[OnMiniGameLifecycleChangeListener.MiniGameLifecycle.OnResume.ordinal()] = 2;
        r100[OnMiniGameLifecycleChangeListener.MiniGameLifecycle.OnStop.ordinal()] = 3;
        r100[OnMiniGameLifecycleChangeListener.MiniGameLifecycle.OnExit.ordinal()] = 4;
        r100[OnMiniGameLifecycleChangeListener.MiniGameLifecycle.OnDestroy.ordinal()] = 5;
        int[] r101 = new int[MiniGameContext.StopType.values().length];
        f85362b = r101;
        r101[MiniGameContext.StopType.ON_GAME_EXIT.ordinal()] = 1;
        r101[MiniGameContext.StopType.ON_MINI_GAME_STOP.ordinal()] = 2;
    }
}
