package com.baidu.mapapi;

import com.amap.api.location.AMapLocation;

/* JADX INFO: loaded from: classes39.dex */
public final enum CoordType extends Enum<CoordType> {
    private static final /* synthetic */ CoordType[] $VALUES = null;
    public static final CoordType BD09LL = null;
    public static final CoordType GCJ02 = null;

    static {
        CoordType r100 = new CoordType(AMapLocation.COORD_TYPE_GCJ02, 0);
        GCJ02 = r100;
        CoordType r101 = new CoordType("BD09LL", 1);
        BD09LL = r101;
        $VALUES = new CoordType[]{r100, r101};
    }

    public static CoordType[] values() {
        return (CoordType[]) $VALUES.clone();
    }

    public static CoordType valueOf(String r100) {
        return (CoordType) r27.a.a(CoordType.class, r100);
    }

    private CoordType(String r100, int r101) {
        super(r100, r101);
    }
}
