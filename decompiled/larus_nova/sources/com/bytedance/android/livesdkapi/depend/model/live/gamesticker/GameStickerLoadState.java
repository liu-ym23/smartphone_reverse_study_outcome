package com.bytedance.android.livesdkapi.depend.model.live.gamesticker;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/GameStickerLoadState;", "", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "LOADING", "SUCCESS", "FAIL", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum GameStickerLoadState extends Enum<GameStickerLoadState> {
    private static final /* synthetic */ GameStickerLoadState[] $VALUES = null;
    public static final GameStickerLoadState FAIL = null;
    public static final GameStickerLoadState LOADING = null;
    public static final GameStickerLoadState NONE = null;
    public static final GameStickerLoadState SUCCESS = null;

    static {
        GameStickerLoadState r100 = new GameStickerLoadState(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        GameStickerLoadState r101 = new GameStickerLoadState("LOADING", 1);
        LOADING = r101;
        GameStickerLoadState r102 = new GameStickerLoadState("SUCCESS", 2);
        SUCCESS = r102;
        GameStickerLoadState r103 = new GameStickerLoadState("FAIL", 3);
        FAIL = r103;
        $VALUES = new GameStickerLoadState[]{r100, r101, r102, r103};
    }

    public static GameStickerLoadState valueOf(String r100) {
        return (GameStickerLoadState) a.a(GameStickerLoadState.class, r100);
    }

    public static GameStickerLoadState[] values() {
        return (GameStickerLoadState[]) $VALUES.clone();
    }

    private GameStickerLoadState(String r100, int r101) {
        super(r100, r101);
    }
}
