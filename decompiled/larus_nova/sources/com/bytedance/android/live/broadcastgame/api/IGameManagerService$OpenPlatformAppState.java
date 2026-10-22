package com.bytedance.android.live.broadcastgame.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"com/bytedance/android/live/broadcastgame/api/IGameManagerService$OpenPlatformAppState", "", "Lcom/bytedance/android/live/broadcastgame/api/IGameManagerService$OpenPlatformAppState;", "OpenPlatformAppStateUnusable", "OpenPlatformAppStateReady", "OpenPlatformAppStateInitializing", "OpenPlatformAppStateRunning", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum IGameManagerService$OpenPlatformAppState extends Enum<IGameManagerService$OpenPlatformAppState> {
    public static final IGameManagerService$OpenPlatformAppState OpenPlatformAppStateInitializing = null;
    public static final IGameManagerService$OpenPlatformAppState OpenPlatformAppStateReady = null;
    public static final IGameManagerService$OpenPlatformAppState OpenPlatformAppStateRunning = null;
    public static final IGameManagerService$OpenPlatformAppState OpenPlatformAppStateUnusable = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IGameManagerService$OpenPlatformAppState[] f59281a = null;

    static {
        IGameManagerService$OpenPlatformAppState r100 = new IGameManagerService$OpenPlatformAppState("OpenPlatformAppStateUnusable", 0);
        OpenPlatformAppStateUnusable = r100;
        IGameManagerService$OpenPlatformAppState r101 = new IGameManagerService$OpenPlatformAppState("OpenPlatformAppStateReady", 1);
        OpenPlatformAppStateReady = r101;
        IGameManagerService$OpenPlatformAppState r102 = new IGameManagerService$OpenPlatformAppState("OpenPlatformAppStateInitializing", 2);
        OpenPlatformAppStateInitializing = r102;
        IGameManagerService$OpenPlatformAppState r103 = new IGameManagerService$OpenPlatformAppState("OpenPlatformAppStateRunning", 3);
        OpenPlatformAppStateRunning = r103;
        f59281a = new IGameManagerService$OpenPlatformAppState[]{r100, r101, r102, r103};
    }

    public static IGameManagerService$OpenPlatformAppState valueOf(String r100) {
        return (IGameManagerService$OpenPlatformAppState) r27.a.a(IGameManagerService$OpenPlatformAppState.class, r100);
    }

    public static IGameManagerService$OpenPlatformAppState[] values() {
        return (IGameManagerService$OpenPlatformAppState[]) f59281a.clone();
    }

    public IGameManagerService$OpenPlatformAppState(String r100, int r101) {
        super(r100, r101);
    }
}
