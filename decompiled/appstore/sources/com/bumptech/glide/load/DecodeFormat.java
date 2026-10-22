package com.bumptech.glide.load;

/* JADX INFO: loaded from: classes.dex */
public final enum DecodeFormat extends Enum<DecodeFormat> {
    private static final /* synthetic */ DecodeFormat[] $VALUES = null;
    public static final DecodeFormat DEFAULT = null;
    public static final DecodeFormat PREFER_ARGB_8888 = null;
    public static final DecodeFormat PREFER_RGB_565 = null;

    static {
        DecodeFormat r10 = new DecodeFormat("PREFER_ARGB_8888", 0);
        PREFER_ARGB_8888 = r10;
        DecodeFormat r11 = new DecodeFormat("PREFER_RGB_565", 1);
        PREFER_RGB_565 = r11;
        $VALUES = new DecodeFormat[]{r10, r11};
        DEFAULT = r10;
    }

    private DecodeFormat(String r10, int r11) {
        super(r10, r11);
    }

    public static DecodeFormat valueOf(String r10) {
        return (DecodeFormat) Enum.valueOf(DecodeFormat.class, r10);
    }

    public static DecodeFormat[] values() {
        return (DecodeFormat[]) $VALUES.clone();
    }
}
