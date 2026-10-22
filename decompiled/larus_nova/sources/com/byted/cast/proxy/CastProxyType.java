package com.byted.cast.proxy;

import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public final enum CastProxyType extends Enum<CastProxyType> {
    private static final /* synthetic */ CastProxyType[] $VALUES = null;
    public static final CastProxyType CastProxyTypeDouyin = null;
    public static final CastProxyType CastProxyTypeGeneral = null;

    static {
        CastProxyType r100 = new CastProxyType("CastProxyTypeGeneral", 0);
        CastProxyTypeGeneral = r100;
        CastProxyType r101 = new CastProxyType("CastProxyTypeDouyin", 1);
        CastProxyTypeDouyin = r101;
        $VALUES = new CastProxyType[]{r100, r101};
    }

    public static CastProxyType[] values() {
        return (CastProxyType[]) $VALUES.clone();
    }

    public static CastProxyType valueOf(String r100) {
        return (CastProxyType) a.a(CastProxyType.class, r100);
    }

    private CastProxyType(String r100, int r101) {
        super(r100, r101);
    }
}
