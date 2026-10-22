package com.bytedance.android.livesdkapi.depend.model.live;

import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
public final enum GameKind extends Enum<GameKind> {
    private static final /* synthetic */ GameKind[] $VALUES = null;
    public static final GameKind CLOUD = null;
    public static final GameKind EFFECT = null;
    public static final GameKind UNKNOWN = null;
    public static final GameKind WGAMEX = null;
    public static final GameKind WMINI = null;
    public int type;

    static {
        GameKind r100 = new GameKind("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        GameKind r101 = new GameKind("EFFECT", 1, 1);
        EFFECT = r101;
        GameKind r102 = new GameKind("WMINI", 2, 2);
        WMINI = r102;
        GameKind r103 = new GameKind("WGAMEX", 3, 3);
        WGAMEX = r103;
        GameKind r104 = new GameKind(FeatureConfigInfo.CLOUD_CONFIG_FEATURE_TYPE_ID, 4, 4);
        CLOUD = r104;
        $VALUES = new GameKind[]{r100, r101, r102, r103, r104};
    }

    public static GameKind[] values() {
        return (GameKind[]) $VALUES.clone();
    }

    public static GameKind valueOf(String r100) {
        return (GameKind) a.a(GameKind.class, r100);
    }

    private GameKind(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
