package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/stickerdialogv2/StickerLoadingStatus;", "", "Normal", "Loading", "Error", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum StickerLoadingStatus extends Enum<StickerLoadingStatus> {
    public static final StickerLoadingStatus Error = null;
    public static final StickerLoadingStatus Loading = null;
    public static final StickerLoadingStatus Normal = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StickerLoadingStatus[] f68652a = null;

    static {
        StickerLoadingStatus r100 = new StickerLoadingStatus("Normal", 0);
        Normal = r100;
        StickerLoadingStatus r101 = new StickerLoadingStatus("Loading", 1);
        Loading = r101;
        StickerLoadingStatus r102 = new StickerLoadingStatus("Error", 2);
        Error = r102;
        f68652a = new StickerLoadingStatus[]{r100, r101, r102};
    }

    public static StickerLoadingStatus valueOf(String r100) {
        return (StickerLoadingStatus) r27.a.a(StickerLoadingStatus.class, r100);
    }

    public static StickerLoadingStatus[] values() {
        return (StickerLoadingStatus[]) f68652a.clone();
    }

    public StickerLoadingStatus(String r100, int r101) {
        super(r100, r101);
    }
}
