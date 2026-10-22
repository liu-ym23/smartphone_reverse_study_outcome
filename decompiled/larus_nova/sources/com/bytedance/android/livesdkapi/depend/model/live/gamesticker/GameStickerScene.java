package com.bytedance.android.livesdkapi.depend.model.live.gamesticker;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/GameStickerScene;", "", "(Ljava/lang/String;I)V", "UNKNOWN", "PREVIEW", "ENTER", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum GameStickerScene extends Enum<GameStickerScene> {
    private static final /* synthetic */ GameStickerScene[] $VALUES = null;
    public static final GameStickerScene ENTER = null;
    public static final GameStickerScene PREVIEW = null;
    public static final GameStickerScene UNKNOWN = null;

    static {
        GameStickerScene r100 = new GameStickerScene("UNKNOWN", 0);
        UNKNOWN = r100;
        GameStickerScene r101 = new GameStickerScene("PREVIEW", 1);
        PREVIEW = r101;
        GameStickerScene r102 = new GameStickerScene("ENTER", 2);
        ENTER = r102;
        $VALUES = new GameStickerScene[]{r100, r101, r102};
    }

    public static GameStickerScene valueOf(String r100) {
        return (GameStickerScene) a.a(GameStickerScene.class, r100);
    }

    public static GameStickerScene[] values() {
        return (GameStickerScene[]) $VALUES.clone();
    }

    private GameStickerScene(String r100, int r101) {
        super(r100, r101);
    }
}
