package com.byted.cast.proxy;

import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public final enum CastProxyMediaType extends Enum<CastProxyMediaType> {
    private static final /* synthetic */ CastProxyMediaType[] $VALUES = null;
    public static final CastProxyMediaType FLV = null;
    public static final CastProxyMediaType M3U8 = null;
    public static final CastProxyMediaType MP4 = null;
    private final String extension;

    static {
        CastProxyMediaType r100 = new CastProxyMediaType("M3U8", 0, "m3u8");
        M3U8 = r100;
        CastProxyMediaType r101 = new CastProxyMediaType("FLV", 1, "flv");
        FLV = r101;
        CastProxyMediaType r102 = new CastProxyMediaType("MP4", 2, "mp4");
        MP4 = r102;
        $VALUES = new CastProxyMediaType[]{r100, r101, r102};
    }

    public static CastProxyMediaType[] values() {
        return (CastProxyMediaType[]) $VALUES.clone();
    }

    public String getExtension() {
        return this.extension;
    }

    public static CastProxyMediaType valueOf(String r100) {
        return (CastProxyMediaType) a.a(CastProxyMediaType.class, r100);
    }

    private CastProxyMediaType(String r100, int r101, String r102) {
        super(r100, r101);
        this.extension = r102;
    }
}
