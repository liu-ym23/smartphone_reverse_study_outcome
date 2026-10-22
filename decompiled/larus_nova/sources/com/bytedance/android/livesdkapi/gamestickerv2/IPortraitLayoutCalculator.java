package com.bytedance.android.livesdkapi.gamestickerv2;

import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.BottomContainerSize;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerInfo;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H&J\u001c\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/gamestickerv2/IPortraitLayoutCalculator;", "", "calculate", "Lkotlin/Pair;", "", "size", "Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/BottomContainerSize;", "containerWidth", "containerHeight", "info", "Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/GameStickerInfo;", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPortraitLayoutCalculator {
    Pair<Integer, Integer> calculate(BottomContainerSize r100, int r101, int r102);

    Pair<Integer, Integer> calculate(GameStickerInfo r100);
}
