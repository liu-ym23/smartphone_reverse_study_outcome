package com.bytedance.android.livesdkapi.depend.model.live.gamesticker;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/GameStickerOrientation;", "", "(Ljava/lang/String;I)V", "VERTICAL", "LANDSCAPE", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum GameStickerOrientation extends Enum<GameStickerOrientation> {
    private static final /* synthetic */ GameStickerOrientation[] $VALUES = null;
    public static final GameStickerOrientation LANDSCAPE = null;
    public static final GameStickerOrientation VERTICAL = null;

    static {
        GameStickerOrientation r100 = new GameStickerOrientation("VERTICAL", 0);
        VERTICAL = r100;
        GameStickerOrientation r101 = new GameStickerOrientation("LANDSCAPE", 1);
        LANDSCAPE = r101;
        $VALUES = new GameStickerOrientation[]{r100, r101};
    }

    public static GameStickerOrientation valueOf(String r100) {
        return (GameStickerOrientation) a.a(GameStickerOrientation.class, r100);
    }

    public static GameStickerOrientation[] values() {
        return (GameStickerOrientation[]) $VALUES.clone();
    }

    private GameStickerOrientation(String r100, int r101) {
        super(r100, r101);
    }
}
