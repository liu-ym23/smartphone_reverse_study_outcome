package com.baidu.mapapi.map;

import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoFunctions;

/* JADX INFO: loaded from: classes39.dex */
public final enum PoiTagType extends Enum<PoiTagType> {
    public static final PoiTagType All = null;
    public static final PoiTagType Epidemic = null;
    public static final PoiTagType Shop = null;
    public static final PoiTagType Travel = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ PoiTagType[] f31213a = null;

    static {
        PoiTagType r100 = new PoiTagType(CancelRetainContactInfoFunctions.All, 0);
        All = r100;
        PoiTagType r101 = new PoiTagType("Epidemic", 1);
        Epidemic = r101;
        PoiTagType r102 = new PoiTagType("Travel", 2);
        Travel = r102;
        PoiTagType r103 = new PoiTagType("Shop", 3);
        Shop = r103;
        f31213a = new PoiTagType[]{r100, r101, r102, r103};
    }

    public static PoiTagType[] values() {
        return (PoiTagType[]) f31213a.clone();
    }

    public static PoiTagType valueOf(String r100) {
        return (PoiTagType) r27.a.a(PoiTagType.class, r100);
    }

    private PoiTagType(String r100, int r101) {
        super(r100, r101);
    }
}
