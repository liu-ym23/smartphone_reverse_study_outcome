package com.bytedance.android.livesdkapi.gamestickerv2;

import com.bytedance.android.livesdkapi.depend.message.GameRoomStickerOprMessage;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerScene;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0016\u0010\b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0007H&J\b\u0010\u0011\u001a\u00020\u000bH&J\b\u0010\u0012\u001a\u00020\u0003H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H&¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdkapi/gamestickerv2/IGameStickerTask;", "", "addStickerInfoUpdateListener", "", "listener", "Lcom/bytedance/android/livesdkapi/gamestickerv2/IGameStickerUpdateListener;", "getTaskRoomId", "", "init", "stickerTypes", "", "", "onMessage", "message", "Lcom/bytedance/android/livesdkapi/depend/message/GameRoomStickerOprMessage;", "onSei", "sei", "referenceCount", "release", "removeStickerInfoUpdateListener", "setScene", "scene", "Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/GameStickerScene;", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IGameStickerTask {
    void addStickerInfoUpdateListener(IGameStickerUpdateListener r100);

    String getTaskRoomId();

    void init(Set<Integer> r100);

    void onMessage(GameRoomStickerOprMessage r100);

    void onSei(String r100);

    int referenceCount();

    void release();

    void removeStickerInfoUpdateListener(IGameStickerUpdateListener r100);

    void setScene(GameStickerScene r100);
}
