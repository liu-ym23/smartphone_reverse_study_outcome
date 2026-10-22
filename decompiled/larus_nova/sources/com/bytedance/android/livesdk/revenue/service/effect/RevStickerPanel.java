package com.bytedance.android.livesdk.revenue.service.effect;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/service/effect/RevStickerPanel;", "", "STICKER", "EFFECT_GIFT", "EFFECT_ATMOSPHERE", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RevStickerPanel extends Enum<RevStickerPanel> {
    public static final RevStickerPanel EFFECT_ATMOSPHERE = null;
    public static final RevStickerPanel EFFECT_GIFT = null;
    public static final RevStickerPanel STICKER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RevStickerPanel[] f157302a = null;

    static {
        RevStickerPanel r100 = new RevStickerPanel("STICKER", 0);
        STICKER = r100;
        RevStickerPanel r101 = new RevStickerPanel("EFFECT_GIFT", 1);
        EFFECT_GIFT = r101;
        RevStickerPanel r102 = new RevStickerPanel("EFFECT_ATMOSPHERE", 2);
        EFFECT_ATMOSPHERE = r102;
        f157302a = new RevStickerPanel[]{r100, r101, r102};
    }

    public static RevStickerPanel valueOf(String r100) {
        return (RevStickerPanel) r27.a.a(RevStickerPanel.class, r100);
    }

    public static RevStickerPanel[] values() {
        return (RevStickerPanel[]) f157302a.clone();
    }

    public RevStickerPanel(String r100, int r101) {
        super(r100, r101);
    }
}
