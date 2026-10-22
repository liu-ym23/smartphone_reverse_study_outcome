package com.obric.common.oea.foundation.blur;

/* JADX INFO: loaded from: classes3.dex */
public final enum BlurUtils$BLEND_MODE extends Enum<BlurUtils$BLEND_MODE> {
    private static final /* synthetic */ BlurUtils$BLEND_MODE[] $VALUES = null;
    public static final BlurUtils$BLEND_MODE COLOR_BURN = null;
    public static final BlurUtils$BLEND_MODE COLOR_DODGE = null;
    public static final BlurUtils$BLEND_MODE DEFAULT = null;
    public static final BlurUtils$BLEND_MODE LUMINOSITY = null;
    public static final BlurUtils$BLEND_MODE OVERLAY = null;
    public static final BlurUtils$BLEND_MODE PLUS_DARKER = null;
    public static final BlurUtils$BLEND_MODE PLUS_LIGHTER = null;
    public static final BlurUtils$BLEND_MODE SOFT_LIGHT = null;

    static {
        BlurUtils$BLEND_MODE r10 = new BlurUtils$BLEND_MODE("DEFAULT", 0);
        DEFAULT = r10;
        BlurUtils$BLEND_MODE r11 = new BlurUtils$BLEND_MODE("COLOR_BURN", 1);
        COLOR_BURN = r11;
        BlurUtils$BLEND_MODE r12 = new BlurUtils$BLEND_MODE("COLOR_DODGE", 2);
        COLOR_DODGE = r12;
        BlurUtils$BLEND_MODE r13 = new BlurUtils$BLEND_MODE("PLUS_DARKER", 3);
        PLUS_DARKER = r13;
        BlurUtils$BLEND_MODE r14 = new BlurUtils$BLEND_MODE("PLUS_LIGHTER", 4);
        PLUS_LIGHTER = r14;
        BlurUtils$BLEND_MODE r15 = new BlurUtils$BLEND_MODE("LUMINOSITY", 5);
        LUMINOSITY = r15;
        BlurUtils$BLEND_MODE r16 = new BlurUtils$BLEND_MODE("OVERLAY", 6);
        OVERLAY = r16;
        BlurUtils$BLEND_MODE r17 = new BlurUtils$BLEND_MODE("SOFT_LIGHT", 7);
        SOFT_LIGHT = r17;
        $VALUES = new BlurUtils$BLEND_MODE[]{r10, r11, r12, r13, r14, r15, r16, r17};
    }

    private BlurUtils$BLEND_MODE(String r10, int r11) {
        super(r10, r11);
    }

    public static BlurUtils$BLEND_MODE valueOf(String r10) {
        return (BlurUtils$BLEND_MODE) Enum.valueOf(BlurUtils$BLEND_MODE.class, r10);
    }

    public static BlurUtils$BLEND_MODE[] values() {
        return (BlurUtils$BLEND_MODE[]) $VALUES.clone();
    }
}
