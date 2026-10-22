package com.bytedance.android.livehostapi.business;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\nH'J,\u0010\u000b\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\nH'J,\u0010\f\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\nH'¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/OnStickerGameStateChangeListener;", "", "onGameEnd", "", "gameSticker", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker;", "arg1", "", "arg2", "arg3", "", "onGameRequest", "onGameStart", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface OnStickerGameStateChangeListener {
    void onGameEnd(Sticker r100, int r101, int r102, String r103);

    void onGameRequest(Sticker r100, int r101, int r102, String r103);

    void onGameStart(Sticker r100, int r101, int r102, String r103);
}
