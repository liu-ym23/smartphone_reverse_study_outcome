package com.bytedance.android.livesdkapi.gamestickerv2;

import com.bytedance.android.livesdkapi.depend.message.GameRoomStickerOprMessage;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerScene;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H&J&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/gamestickerv2/IGameStickerTaskManager;", "", "dispatch", "", "roomId", "", "message", "Lcom/bytedance/android/livesdkapi/depend/message/GameRoomStickerOprMessage;", "sei", "obtainTask", "Lcom/bytedance/android/livesdkapi/gamestickerv2/IGameStickerTask;", "scene", "Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/GameStickerScene;", "stickerTypes", "", "", "recycle", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IGameStickerTaskManager {
    void dispatch(String r100, GameRoomStickerOprMessage r101);

    void dispatch(String r100, String r101);

    IGameStickerTask obtainTask(GameStickerScene r100, String r101, Set<Integer> r102);

    void recycle(String r100);
}
