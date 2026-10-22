package com.bytedance.android.live.gift;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/gift/RevStickerPanel;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "EFFECT_GIFT", "EFFECT_INTERACT_GIFT", "EFFECT_INTERACT_GIFT_SPECIAL", "EFFECT_INTERACT_GIFT_PK_ENV", "EFFECT_PK_INTERACT_PLAY", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RevStickerPanel extends Enum<RevStickerPanel> {
    public static final RevStickerPanel EFFECT_GIFT = null;
    public static final RevStickerPanel EFFECT_INTERACT_GIFT = null;
    public static final RevStickerPanel EFFECT_INTERACT_GIFT_PK_ENV = null;
    public static final RevStickerPanel EFFECT_INTERACT_GIFT_SPECIAL = null;
    public static final RevStickerPanel EFFECT_PK_INTERACT_PLAY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RevStickerPanel[] f69005a = null;
    private final String value;

    static {
        RevStickerPanel r100 = new RevStickerPanel("EFFECT_GIFT", 0, "effect_gift");
        EFFECT_GIFT = r100;
        RevStickerPanel r101 = new RevStickerPanel("EFFECT_INTERACT_GIFT", 1, "effect_interact_gift");
        EFFECT_INTERACT_GIFT = r101;
        RevStickerPanel r102 = new RevStickerPanel("EFFECT_INTERACT_GIFT_SPECIAL", 2, "effect_interact_gift_special");
        EFFECT_INTERACT_GIFT_SPECIAL = r102;
        RevStickerPanel r103 = new RevStickerPanel("EFFECT_INTERACT_GIFT_PK_ENV", 3, "effect_interact_gift_pk_env");
        EFFECT_INTERACT_GIFT_PK_ENV = r103;
        RevStickerPanel r104 = new RevStickerPanel("EFFECT_PK_INTERACT_PLAY", 4, "effect_pk_interact_play");
        EFFECT_PK_INTERACT_PLAY = r104;
        f69005a = new RevStickerPanel[]{r100, r101, r102, r103, r104};
    }

    public static RevStickerPanel valueOf(String r100) {
        return (RevStickerPanel) a.a(RevStickerPanel.class, r100);
    }

    public static RevStickerPanel[] values() {
        return (RevStickerPanel[]) f69005a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public RevStickerPanel(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
