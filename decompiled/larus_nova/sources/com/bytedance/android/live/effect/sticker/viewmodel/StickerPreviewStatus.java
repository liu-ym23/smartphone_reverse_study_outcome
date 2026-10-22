package com.bytedance.android.live.effect.sticker.viewmodel;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/viewmodel/StickerPreviewStatus;", "", "None", "Downgrade", "Preview", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum StickerPreviewStatus extends Enum<StickerPreviewStatus> {
    public static final StickerPreviewStatus Downgrade = null;
    public static final StickerPreviewStatus None = null;
    public static final StickerPreviewStatus Preview = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StickerPreviewStatus[] f68805a = null;

    static {
        StickerPreviewStatus r100 = new StickerPreviewStatus("None", 0);
        None = r100;
        StickerPreviewStatus r101 = new StickerPreviewStatus("Downgrade", 1);
        Downgrade = r101;
        StickerPreviewStatus r102 = new StickerPreviewStatus("Preview", 2);
        Preview = r102;
        f68805a = new StickerPreviewStatus[]{r100, r101, r102};
    }

    public static StickerPreviewStatus valueOf(String r100) {
        return (StickerPreviewStatus) r27.a.a(StickerPreviewStatus.class, r100);
    }

    public static StickerPreviewStatus[] values() {
        return (StickerPreviewStatus[]) f68805a.clone();
    }

    public StickerPreviewStatus(String r100, int r101) {
        super(r100, r101);
    }
}
