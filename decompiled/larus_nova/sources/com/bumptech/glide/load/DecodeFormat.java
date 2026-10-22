package com.bumptech.glide.load;

import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public final enum DecodeFormat extends Enum<DecodeFormat> {
    private static final /* synthetic */ DecodeFormat[] $VALUES = null;
    public static final DecodeFormat DEFAULT = null;
    public static final DecodeFormat PREFER_ARGB_8888 = null;
    public static final DecodeFormat PREFER_RGB_565 = null;

    static {
        DecodeFormat r100 = new DecodeFormat("PREFER_ARGB_8888", 0);
        PREFER_ARGB_8888 = r100;
        DecodeFormat r101 = new DecodeFormat("PREFER_RGB_565", 1);
        PREFER_RGB_565 = r101;
        $VALUES = new DecodeFormat[]{r100, r101};
        DEFAULT = r100;
    }

    public static DecodeFormat[] values() {
        return (DecodeFormat[]) $VALUES.clone();
    }

    public static DecodeFormat valueOf(String r100) {
        return (DecodeFormat) a.a(DecodeFormat.class, r100);
    }

    private DecodeFormat(String r100, int r101) {
        super(r100, r101);
    }
}
