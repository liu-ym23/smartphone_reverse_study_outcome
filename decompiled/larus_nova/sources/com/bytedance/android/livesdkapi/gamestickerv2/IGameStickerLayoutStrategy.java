package com.bytedance.android.livesdkapi.gamestickerv2;

import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerInfo;
import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/gamestickerv2/IGameStickerLayoutStrategy;", "", LynxViewpagerItem.BIND_ON_ATTACH, "", "viewProxy", "Lcom/bytedance/android/livesdkapi/gamestickerv2/IGameStickerContainerViewProxy;", "detach", "requestLayout", "info", "Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/GameStickerInfo;", "code", "", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IGameStickerLayoutStrategy {
    void attach(IGameStickerContainerViewProxy r100);

    void detach();

    void requestLayout(GameStickerInfo r100, int r101);
}
