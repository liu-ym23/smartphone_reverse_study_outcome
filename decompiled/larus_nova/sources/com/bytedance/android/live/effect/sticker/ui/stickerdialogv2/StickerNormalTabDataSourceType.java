package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/stickerdialogv2/StickerNormalTabDataSourceType;", "", "Normal", "Favorite", "Campaign", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum StickerNormalTabDataSourceType extends Enum<StickerNormalTabDataSourceType> {
    public static final StickerNormalTabDataSourceType Campaign = null;
    public static final StickerNormalTabDataSourceType Favorite = null;
    public static final StickerNormalTabDataSourceType Normal = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StickerNormalTabDataSourceType[] f68667a = null;

    static {
        StickerNormalTabDataSourceType r100 = new StickerNormalTabDataSourceType("Normal", 0);
        Normal = r100;
        StickerNormalTabDataSourceType r101 = new StickerNormalTabDataSourceType("Favorite", 1);
        Favorite = r101;
        StickerNormalTabDataSourceType r102 = new StickerNormalTabDataSourceType("Campaign", 2);
        Campaign = r102;
        f68667a = new StickerNormalTabDataSourceType[]{r100, r101, r102};
    }

    public static StickerNormalTabDataSourceType valueOf(String r100) {
        return (StickerNormalTabDataSourceType) r27.a.a(StickerNormalTabDataSourceType.class, r100);
    }

    public static StickerNormalTabDataSourceType[] values() {
        return (StickerNormalTabDataSourceType[]) f68667a.clone();
    }

    public StickerNormalTabDataSourceType(String r100, int r101) {
        super(r100, r101);
    }
}
