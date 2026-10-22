package com.bytedance.android.livesdkapi.depend.model.live.gamesticker;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/GameStickerSource;", "", "(Ljava/lang/String;I)V", "REQUEST", "IM", "SEI", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum GameStickerSource extends Enum<GameStickerSource> {
    private static final /* synthetic */ GameStickerSource[] $VALUES = null;
    public static final GameStickerSource IM = null;
    public static final GameStickerSource REQUEST = null;
    public static final GameStickerSource SEI = null;

    static {
        GameStickerSource r100 = new GameStickerSource("REQUEST", 0);
        REQUEST = r100;
        GameStickerSource r101 = new GameStickerSource("IM", 1);
        IM = r101;
        GameStickerSource r102 = new GameStickerSource("SEI", 2);
        SEI = r102;
        $VALUES = new GameStickerSource[]{r100, r101, r102};
    }

    public static GameStickerSource valueOf(String r100) {
        return (GameStickerSource) a.a(GameStickerSource.class, r100);
    }

    public static GameStickerSource[] values() {
        return (GameStickerSource[]) $VALUES.clone();
    }

    private GameStickerSource(String r100, int r101) {
        super(r100, r101);
    }
}
