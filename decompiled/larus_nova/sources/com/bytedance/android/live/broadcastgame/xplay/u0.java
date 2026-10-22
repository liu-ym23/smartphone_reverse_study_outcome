package com.bytedance.android.live.broadcastgame.xplay;

/* JADX INFO: loaded from: classes45.dex */
public final /* synthetic */ class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f62478a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f62479b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f62480c = null;

    static {
        int[] r100 = new int[IXplayCoreService.State.values().length];
        f62478a = r100;
        IXplayCoreService.State r101 = IXplayCoreService.State.Running;
        r100[r101.ordinal()] = 1;
        IXplayCoreService.State r102 = IXplayCoreService.State.Loaded;
        r100[r102.ordinal()] = 2;
        IXplayCoreService.State r103 = IXplayCoreService.State.SwitchToGuide;
        r100[r103.ordinal()] = 3;
        IXplayCoreService.State r104 = IXplayCoreService.State.SwitchToHost;
        r100[r104.ordinal()] = 4;
        IXplayCoreService.State r105 = IXplayCoreService.State.Loading;
        r100[r105.ordinal()] = 5;
        IXplayCoreService.State r110 = IXplayCoreService.State.Stopped;
        r100[r110.ordinal()] = 6;
        int[] r106 = new int[IXplayCoreService.State.values().length];
        f62479b = r106;
        r106[r102.ordinal()] = 1;
        r106[r101.ordinal()] = 2;
        r106[r103.ordinal()] = 3;
        r106[r104.ordinal()] = 4;
        int[] r107 = new int[IXplayCoreService.State.values().length];
        f62480c = r107;
        r107[r101.ordinal()] = 1;
        r107[r103.ordinal()] = 2;
        r107[r104.ordinal()] = 3;
        r107[r105.ordinal()] = 4;
        r107[r102.ordinal()] = 5;
        r107[r110.ordinal()] = 6;
    }
}
