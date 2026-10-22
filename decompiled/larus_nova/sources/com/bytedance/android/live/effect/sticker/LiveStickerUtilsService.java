package com.bytedance.android.live.effect.sticker;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/LiveStickerUtilsService;", "Lcom/bytedance/android/live/effect/sticker/ILiveStickerUtilsService;", "()V", "convertStickerBean", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker;", "effect", "Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "liveeffect-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveStickerUtilsService implements ILiveStickerUtilsService {
    public LiveStickerUtilsService() {
    }

    @Override // com.bytedance.android.live.effect.sticker.ILiveStickerUtilsService
    public Sticker convertStickerBean(Effect r100) {
        return d.b(r100);
    }
}
