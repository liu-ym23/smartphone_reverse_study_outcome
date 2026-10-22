package com.bytedance.android.live.effect.common;

import com.bytedance.android.live.effect.sticker.ui.stickerdialogv2.StickerLoadingStatus;

/* JADX INFO: loaded from: classes45.dex */
public final /* synthetic */ class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f67870a = null;

    static {
        int[] r100 = new int[StickerLoadingStatus.values().length];
        f67870a = r100;
        r100[StickerLoadingStatus.Loading.ordinal()] = 1;
        r100[StickerLoadingStatus.Error.ordinal()] = 2;
        r100[StickerLoadingStatus.Normal.ordinal()] = 3;
    }
}
