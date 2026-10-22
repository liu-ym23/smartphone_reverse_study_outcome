package com.bytedance.android.livesdkapi.gamestickerv2;

import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerInfo;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/gamestickerv2/IGameStickerUpdateListener;", "", "onSeiSceneUpdate", "", "ver", "", "", "displayId", "", "onStickerUpdate", "info", "Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/GameStickerInfo;", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IGameStickerUpdateListener {
    void onSeiSceneUpdate(Set<Integer> r100, Set<String> r101);

    void onStickerUpdate(GameStickerInfo r100);
}
