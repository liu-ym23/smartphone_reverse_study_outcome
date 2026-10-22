package com.bytedance.android.live.effect.common;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class g implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveCommonStickerAdjustBarView f67856a;

    @Override // com.bytedance.android.live.effect.common.b
    public final void a(Sticker r100, Sticker.ComposerConfig r101) {
        Intrinsics.checkNotNullParameter(r100, "sticker");
        Intrinsics.checkNotNullParameter(r101, "composerConfig");
    }

    public g(LiveCommonStickerAdjustBarView r100) {
        this.f67856a = r100;
    }

    @Override // com.bytedance.android.live.effect.common.b
    public final void b(Sticker r100, Sticker.ComposerConfig r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "sticker");
        Intrinsics.checkNotNullParameter(r101, "composerConfig");
        LiveCommonStickerRenderViewModel r103 = LiveCommonStickerAdjustBarView.R5(this.f67856a);
        if (r103 == null) goto L6;
        r103.updateTagValue(r100, r101, r102);
        return;
    }
}
