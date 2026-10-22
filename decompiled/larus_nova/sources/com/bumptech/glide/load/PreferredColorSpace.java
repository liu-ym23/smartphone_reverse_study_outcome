package com.bumptech.glide.load;

import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public final enum PreferredColorSpace extends Enum<PreferredColorSpace> {
    private static final /* synthetic */ PreferredColorSpace[] $VALUES = null;
    public static final PreferredColorSpace DISPLAY_P3 = null;
    public static final PreferredColorSpace SRGB = null;

    static {
        PreferredColorSpace r100 = new PreferredColorSpace("SRGB", 0);
        SRGB = r100;
        PreferredColorSpace r101 = new PreferredColorSpace("DISPLAY_P3", 1);
        DISPLAY_P3 = r101;
        $VALUES = new PreferredColorSpace[]{r100, r101};
    }

    public static PreferredColorSpace[] values() {
        return (PreferredColorSpace[]) $VALUES.clone();
    }

    public static PreferredColorSpace valueOf(String r100) {
        return (PreferredColorSpace) a.a(PreferredColorSpace.class, r100);
    }

    private PreferredColorSpace(String r100, int r101) {
        super(r100, r101);
    }
}
