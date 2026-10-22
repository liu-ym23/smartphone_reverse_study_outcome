package com.bytedance.android.livesdkapi.depend.model.live.gamesticker;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/GameStickerOpr;", "", "(Ljava/lang/String;I)V", "UNKNOWN", "CREATE", "REFRESH", "DESTROY", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum GameStickerOpr extends Enum<GameStickerOpr> {
    private static final /* synthetic */ GameStickerOpr[] $VALUES = null;
    public static final GameStickerOpr CREATE = null;
    public static final GameStickerOpr DESTROY = null;
    public static final GameStickerOpr REFRESH = null;
    public static final GameStickerOpr UNKNOWN = null;

    static {
        GameStickerOpr r100 = new GameStickerOpr("UNKNOWN", 0);
        UNKNOWN = r100;
        GameStickerOpr r101 = new GameStickerOpr("CREATE", 1);
        CREATE = r101;
        GameStickerOpr r102 = new GameStickerOpr("REFRESH", 2);
        REFRESH = r102;
        GameStickerOpr r103 = new GameStickerOpr("DESTROY", 3);
        DESTROY = r103;
        $VALUES = new GameStickerOpr[]{r100, r101, r102, r103};
    }

    public static GameStickerOpr valueOf(String r100) {
        return (GameStickerOpr) a.a(GameStickerOpr.class, r100);
    }

    public static GameStickerOpr[] values() {
        return (GameStickerOpr[]) $VALUES.clone();
    }

    private GameStickerOpr(String r100, int r101) {
        super(r100, r101);
    }
}
