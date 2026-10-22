package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/ui/configuration/ClickType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "NormalGiftEffectSwitch", "StickerGiftEffectSwitch", "EffectGame", "RoleSkill", "GiftVoice", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ClickType extends Enum<ClickType> {
    public static final ClickType EffectGame = null;
    public static final ClickType GiftVoice = null;
    public static final ClickType NormalGiftEffectSwitch = null;
    public static final ClickType RoleSkill = null;
    public static final ClickType StickerGiftEffectSwitch = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ClickType[] f131927a = null;
    private final String value;

    static {
        ClickType r100 = new ClickType("NormalGiftEffectSwitch", 0, "common_gift");
        NormalGiftEffectSwitch = r100;
        ClickType r101 = new ClickType("StickerGiftEffectSwitch", 1, "face_gift");
        StickerGiftEffectSwitch = r101;
        ClickType r102 = new ClickType("EffectGame", 2, "game_gift");
        EffectGame = r102;
        ClickType r103 = new ClickType("RoleSkill", 3, "role_gift");
        RoleSkill = r103;
        ClickType r104 = new ClickType("GiftVoice", 4, "gift_voice");
        GiftVoice = r104;
        f131927a = new ClickType[]{r100, r101, r102, r103, r104};
    }

    public static ClickType valueOf(String r100) {
        return (ClickType) r27.a.a(ClickType.class, r100);
    }

    public static ClickType[] values() {
        return (ClickType[]) f131927a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public ClickType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
