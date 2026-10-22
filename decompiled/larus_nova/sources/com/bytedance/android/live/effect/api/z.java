package com.bytedance.android.live.effect.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class z {
    public static final boolean a(LiveEffectScene r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isGiftMenu");
        if (r100 != LiveEffectScene.GiftMenuPreview) goto L5;
    L8:
        return true;
    L5:
        if (r100 == LiveEffectScene.GiftMenuLive) goto L8;
        return false;
    }
}
