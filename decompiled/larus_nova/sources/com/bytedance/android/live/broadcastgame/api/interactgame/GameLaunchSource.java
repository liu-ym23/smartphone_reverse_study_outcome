package com.bytedance.android.live.broadcastgame.api.interactgame;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/interactgame/GameLaunchSource;", "", "", "source", "J", "getSource", "()J", "Panel", "Scan", "GamePromote", "Invite", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GameLaunchSource extends Enum<GameLaunchSource> {
    public static final GameLaunchSource GamePromote = null;
    public static final GameLaunchSource Invite = null;
    public static final GameLaunchSource Panel = null;
    public static final GameLaunchSource Scan = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GameLaunchSource[] f59291a = null;
    private final long source;

    static {
        GameLaunchSource r100 = new GameLaunchSource("Panel", 0, 1);
        Panel = r100;
        GameLaunchSource r101 = new GameLaunchSource("Scan", 1, 2);
        Scan = r101;
        GameLaunchSource r102 = new GameLaunchSource("GamePromote", 2, 3);
        GamePromote = r102;
        GameLaunchSource r103 = new GameLaunchSource("Invite", 3, 9);
        Invite = r103;
        f59291a = new GameLaunchSource[]{r100, r101, r102, r103};
    }

    public static GameLaunchSource valueOf(String r100) {
        return (GameLaunchSource) r27.a.a(GameLaunchSource.class, r100);
    }

    public static GameLaunchSource[] values() {
        return (GameLaunchSource[]) f59291a.clone();
    }

    public final long getSource() {
        return this.source;
    }

    public GameLaunchSource(String r100, int r101, long r102) {
        super(r100, r101);
        this.source = r102;
    }
}
