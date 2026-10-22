package com.bytedance.android.gamecp.business.gamedetail.strategy.scene;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/strategy/scene/GameDetailScene;", "", "LIVE", "VIDEO", "OFFICIAL", "SAAS_NOVEL", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GameDetailScene extends Enum<GameDetailScene> {
    public static final GameDetailScene LIVE = null;
    public static final GameDetailScene OFFICIAL = null;
    public static final GameDetailScene SAAS_NOVEL = null;
    public static final GameDetailScene VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GameDetailScene[] f55614a = null;

    static {
        GameDetailScene r100 = new GameDetailScene("LIVE", 0);
        LIVE = r100;
        GameDetailScene r101 = new GameDetailScene("VIDEO", 1);
        VIDEO = r101;
        GameDetailScene r102 = new GameDetailScene("OFFICIAL", 2);
        OFFICIAL = r102;
        GameDetailScene r103 = new GameDetailScene("SAAS_NOVEL", 3);
        SAAS_NOVEL = r103;
        f55614a = new GameDetailScene[]{r100, r101, r102, r103};
    }

    public static GameDetailScene valueOf(String r100) {
        return (GameDetailScene) a.a(GameDetailScene.class, r100);
    }

    public static GameDetailScene[] values() {
        return (GameDetailScene[]) f55614a.clone();
    }

    public GameDetailScene(String r100, int r101) {
        super(r100, r101);
    }
}
