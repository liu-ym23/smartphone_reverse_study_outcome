package com.amap.api.services.nearby;

import r27.a;

/* JADX INFO: loaded from: classes28.dex */
public final enum NearbySearchFunctionType extends Enum<NearbySearchFunctionType> {
    public static final NearbySearchFunctionType DISTANCE_SEARCH = null;
    public static final NearbySearchFunctionType DRIVING_DISTANCE_SEARCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ NearbySearchFunctionType[] f28983a = null;

    static {
        NearbySearchFunctionType r100 = new NearbySearchFunctionType("DISTANCE_SEARCH", 0);
        DISTANCE_SEARCH = r100;
        NearbySearchFunctionType r101 = new NearbySearchFunctionType("DRIVING_DISTANCE_SEARCH", 1);
        DRIVING_DISTANCE_SEARCH = r101;
        f28983a = new NearbySearchFunctionType[]{r100, r101};
    }

    public static NearbySearchFunctionType[] values() {
        return (NearbySearchFunctionType[]) f28983a.clone();
    }

    public static NearbySearchFunctionType valueOf(String r100) {
        return (NearbySearchFunctionType) a.a(NearbySearchFunctionType.class, r100);
    }

    private NearbySearchFunctionType(String r100, int r101) {
        super(r100, r101);
    }
}
