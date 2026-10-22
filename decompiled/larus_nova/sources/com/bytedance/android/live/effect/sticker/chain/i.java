package com.bytedance.android.live.effect.sticker.chain;

import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.common.LiveCommonStickerRenderViewModel;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerBaseViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class i implements m {
    public i() {
    }

    @Override // com.bytedance.android.live.effect.sticker.chain.m
    public final void a(l r100) {
        Intrinsics.checkNotNullParameter(r100, "chain");
        StickerBaseViewModel.a r101 = StickerBaseViewModel.Companion;
        LiveEffectScene r102 = r100.f68172e;
        String r103 = r100.f68173f;
        r101.getClass();
        LiveCommonStickerRenderViewModel r104 = (LiveCommonStickerRenderViewModel) StickerBaseViewModel.a.b(r102, r103, LiveCommonStickerRenderViewModel.class);
        if (r104 == null) goto L5;
        r104.renderSticker(r100.f68174g);
    L5:
        r100.a();
    }
}
