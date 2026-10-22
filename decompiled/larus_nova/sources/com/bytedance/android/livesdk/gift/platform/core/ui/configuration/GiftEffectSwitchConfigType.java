package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/ui/configuration/GiftEffectSwitchConfigType;", "", "NormalGiftSwitch", "StickerGiftSwitch", "SoundAndVibrationSwitch", "EffectGame", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GiftEffectSwitchConfigType extends Enum<GiftEffectSwitchConfigType> {
    public static final GiftEffectSwitchConfigType EffectGame = null;
    public static final GiftEffectSwitchConfigType NormalGiftSwitch = null;
    public static final GiftEffectSwitchConfigType SoundAndVibrationSwitch = null;
    public static final GiftEffectSwitchConfigType StickerGiftSwitch = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GiftEffectSwitchConfigType[] f131958a = null;

    static {
        GiftEffectSwitchConfigType r100 = new GiftEffectSwitchConfigType("NormalGiftSwitch", 0);
        NormalGiftSwitch = r100;
        GiftEffectSwitchConfigType r101 = new GiftEffectSwitchConfigType("StickerGiftSwitch", 1);
        StickerGiftSwitch = r101;
        GiftEffectSwitchConfigType r102 = new GiftEffectSwitchConfigType("SoundAndVibrationSwitch", 2);
        SoundAndVibrationSwitch = r102;
        GiftEffectSwitchConfigType r103 = new GiftEffectSwitchConfigType("EffectGame", 3);
        EffectGame = r103;
        f131958a = new GiftEffectSwitchConfigType[]{r100, r101, r102, r103};
    }

    public static GiftEffectSwitchConfigType valueOf(String r100) {
        return (GiftEffectSwitchConfigType) r27.a.a(GiftEffectSwitchConfigType.class, r100);
    }

    public static GiftEffectSwitchConfigType[] values() {
        return (GiftEffectSwitchConfigType[]) f131958a.clone();
    }

    public GiftEffectSwitchConfigType(String r100, int r101) {
        super(r100, r101);
    }
}
