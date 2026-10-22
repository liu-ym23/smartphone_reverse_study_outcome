package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import com.bytedance.android.live.effect.sticker.ui.aigc.AigcTaskPanelStatus;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerPreviewStatus;

/* JADX INFO: loaded from: classes45.dex */
public final /* synthetic */ class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f68746a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f68747b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f68748c = null;

    static {
        int[] r100 = new int[StickerLoadingStatus.values().length];
        f68746a = r100;
        r100[StickerLoadingStatus.Normal.ordinal()] = 1;
        r100[StickerLoadingStatus.Loading.ordinal()] = 2;
        r100[StickerLoadingStatus.Error.ordinal()] = 3;
        int[] r101 = new int[StickerPreviewStatus.values().length];
        f68747b = r101;
        r101[StickerPreviewStatus.None.ordinal()] = 1;
        r101[StickerPreviewStatus.Preview.ordinal()] = 2;
        r101[StickerPreviewStatus.Downgrade.ordinal()] = 3;
        int[] r102 = new int[AigcTaskPanelStatus.values().length];
        f68748c = r102;
        r102[AigcTaskPanelStatus.Done.ordinal()] = 1;
        r102[AigcTaskPanelStatus.Ready.ordinal()] = 2;
        r102[AigcTaskPanelStatus.Running.ordinal()] = 3;
    }
}
