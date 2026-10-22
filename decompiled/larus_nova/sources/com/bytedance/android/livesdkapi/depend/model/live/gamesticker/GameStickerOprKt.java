package com.bytedance.android.livesdkapi.depend.model.live.gamesticker;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toGameStickerOpr", "Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/GameStickerOpr;", "", "live-model-api_saasRelease"}, k = 2, mv = {1, 5, 1})
public final class GameStickerOprKt {
    public static final GameStickerOpr toGameStickerOpr(int r100) {
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L15;
        if (r100 == 3) goto L14;
        return GameStickerOpr.UNKNOWN;
    L14:
        return GameStickerOpr.DESTROY;
    L15:
        return GameStickerOpr.REFRESH;
    L12:
        return GameStickerOpr.CREATE;
    }
}
