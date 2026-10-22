package com.bytedance.android.livesdkapi.gamestickerv2;

import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.BottomContainerParams;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.BottomContainerSize;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/gamestickerv2/ILandscapeLayoutCalculator;", "", "calculate", "Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/BottomContainerParams;", "size", "Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/BottomContainerSize;", "containerWidth", "", "containerHeight", "videoWidth", "videoHeight", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILandscapeLayoutCalculator {
    BottomContainerParams calculate(BottomContainerSize r100, int r101, int r102, int r103, int r104);
}
