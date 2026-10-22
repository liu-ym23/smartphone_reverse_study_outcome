package com.byted.cast.proxy;

import android.text.TextUtils;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public final enum CastProxyOutputResolution extends Enum<CastProxyOutputResolution> {
    private static final /* synthetic */ CastProxyOutputResolution[] $VALUES = null;
    public static final CastProxyOutputResolution RESOLUTION_1080P = null;
    public static final CastProxyOutputResolution RESOLUTION_4K = null;
    public static final CastProxyOutputResolution RESOLUTION_540P = null;
    public static final CastProxyOutputResolution RESOLUTION_720P = null;
    private final String resolution;

    static {
        CastProxyOutputResolution r100 = new CastProxyOutputResolution("RESOLUTION_540P", 0, "540p");
        RESOLUTION_540P = r100;
        CastProxyOutputResolution r101 = new CastProxyOutputResolution("RESOLUTION_720P", 1, "720p");
        RESOLUTION_720P = r101;
        CastProxyOutputResolution r102 = new CastProxyOutputResolution("RESOLUTION_1080P", 2, "1080p");
        RESOLUTION_1080P = r102;
        CastProxyOutputResolution r103 = new CastProxyOutputResolution("RESOLUTION_4K", 3, "4K");
        RESOLUTION_4K = r103;
        $VALUES = new CastProxyOutputResolution[]{r100, r101, r102, r103};
    }

    public static CastProxyOutputResolution[] values() {
        return (CastProxyOutputResolution[]) $VALUES.clone();
    }

    public String getResolution() {
        return this.resolution;
    }

    public static int getResolutionHeight(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return 0;
    L6:
        if (RESOLUTION_540P.getResolution().equals(r100) == false) goto L10;
        return 540;
    L10:
        if (RESOLUTION_720P.getResolution().equals(r100) == false) goto L14;
        return 720;
    L14:
        if (RESOLUTION_1080P.getResolution().equals(r100) == false) goto L18;
        return 1080;
    L18:
        if (RESOLUTION_4K.getResolution().equals(r100) == false) goto L21;
        return 2160;
    L21:
        return 0;
    }

    public static CastProxyOutputResolution valueOf(String r100) {
        return (CastProxyOutputResolution) a.a(CastProxyOutputResolution.class, r100);
    }

    private CastProxyOutputResolution(String r100, int r101, String r102) {
        super(r100, r101);
        this.resolution = r102;
    }
}
