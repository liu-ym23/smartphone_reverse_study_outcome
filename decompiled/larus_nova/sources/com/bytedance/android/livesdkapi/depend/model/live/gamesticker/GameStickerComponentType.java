package com.bytedance.android.livesdkapi.depend.model.live.gamesticker;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/GameStickerComponentType;", "", "(Ljava/lang/String;I)V", "UNKNOWN", "WEB", "NATIVE", "LYNX", "TEMPLATE_01", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum GameStickerComponentType extends Enum<GameStickerComponentType> {
    private static final /* synthetic */ GameStickerComponentType[] $VALUES = null;
    public static final GameStickerComponentType LYNX = null;
    public static final GameStickerComponentType NATIVE = null;
    public static final GameStickerComponentType TEMPLATE_01 = null;
    public static final GameStickerComponentType UNKNOWN = null;
    public static final GameStickerComponentType WEB = null;

    static {
        GameStickerComponentType r100 = new GameStickerComponentType("UNKNOWN", 0);
        UNKNOWN = r100;
        GameStickerComponentType r101 = new GameStickerComponentType("WEB", 1);
        WEB = r101;
        GameStickerComponentType r102 = new GameStickerComponentType("NATIVE", 2);
        NATIVE = r102;
        GameStickerComponentType r103 = new GameStickerComponentType("LYNX", 3);
        LYNX = r103;
        GameStickerComponentType r104 = new GameStickerComponentType("TEMPLATE_01", 4);
        TEMPLATE_01 = r104;
        $VALUES = new GameStickerComponentType[]{r100, r101, r102, r103, r104};
    }

    public static GameStickerComponentType valueOf(String r100) {
        return (GameStickerComponentType) a.a(GameStickerComponentType.class, r100);
    }

    public static GameStickerComponentType[] values() {
        return (GameStickerComponentType[]) $VALUES.clone();
    }

    private GameStickerComponentType(String r100, int r101) {
        super(r100, r101);
    }
}
