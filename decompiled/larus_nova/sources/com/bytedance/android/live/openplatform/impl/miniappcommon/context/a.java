package com.bytedance.android.live.openplatform.impl.miniappcommon.context;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f85012a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f85013b = null;

    static {
        int[] r100 = new int[OnMiniAppLifecycleChangeListener.MiniAppLifecycle.values().length];
        f85012a = r100;
        r100[OnMiniAppLifecycleChangeListener.MiniAppLifecycle.OnCreate.ordinal()] = 1;
        r100[OnMiniAppLifecycleChangeListener.MiniAppLifecycle.OnResume.ordinal()] = 2;
        r100[OnMiniAppLifecycleChangeListener.MiniAppLifecycle.OnStop.ordinal()] = 3;
        r100[OnMiniAppLifecycleChangeListener.MiniAppLifecycle.OnDestroy.ordinal()] = 4;
        int[] r101 = new int[MiniAppContext.StopType.values().length];
        f85013b = r101;
        r101[MiniAppContext.StopType.ON_APP_EXIT.ordinal()] = 1;
        r101[MiniAppContext.StopType.ON_MINI_APP_STOP.ordinal()] = 2;
    }
}
