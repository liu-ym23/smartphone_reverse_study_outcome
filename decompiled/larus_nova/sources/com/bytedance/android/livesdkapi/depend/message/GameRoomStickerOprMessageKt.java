package com.bytedance.android.livesdkapi.depend.message;

import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameRoomStickerSize;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerInfo;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerOpr;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerOprKt;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toGameStickerInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/GameStickerInfo;", "Lcom/bytedance/android/livesdkapi/depend/message/GameRoomStickerOprMessage;", "livebase-model_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class GameRoomStickerOprMessageKt {
    public static final GameStickerInfo toGameStickerInfo(GameRoomStickerOprMessage r110) {
        Intrinsics.checkNotNullParameter(r110, "$this$toGameStickerInfo");
        int r100 = r110.getStickerType();
        GameStickerOpr r101 = GameStickerOprKt.toGameStickerOpr(r110.getOprType());
        GameRoomStickerSize r102 = r110.getStickerSize();
        if (r102 != null) goto L5;
        r102 = new GameRoomStickerSize();
    L5:
        GameRoomStickerSize r103 = r102;
        String r104 = r110.getStickerData();
        if (r104 != null) goto L8;
        String r105 = "";
    L9:
        String r106 = r110.getStickerDigest();
        if (r106 != null) goto L12;
        String r107 = "";
    L13:
        String r108 = r110.getStickerUrl();
        if (r108 != null) goto L16;
        String r109 = "";
    L17:
        String r111 = r110.getGameId();
        if (r111 != null) goto L20;
        String r112 = "";
    L21:
        String r113 = r110.getRecordId();
        if (r113 == null) goto L26;
        Long r114 = StringsKt.toLongOrNull(r113);
        if (r114 == null) goto L26;
        long r115 = r114.longValue();
    L28:
        if (r115 > 0) goto L30;
        r115 = System.currentTimeMillis() / ((long) 1000);
    L30:
        GameStickerSource r116 = GameStickerSource.IM;
        return new GameStickerInfo(r116, r100, r101, r103, r105, r107, r109, r115, r112);
    L26:
        r115 = System.currentTimeMillis() / ((long) 1000);
        goto L28
    L20:
        r112 = r111;
        goto L21
    L16:
        r109 = r108;
        goto L17
    L12:
        r107 = r106;
        goto L13
    L8:
        r105 = r104;
        goto L9
    }
}
