package com.byted.cast.common.source;

import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public final enum SearchType extends Enum<SearchType> {
    private static final /* synthetic */ SearchType[] $VALUES = null;
    public static final SearchType BLE = null;
    public static final SearchType MDNS = null;
    public static final SearchType SSDP = null;

    static {
        SearchType r100 = new SearchType("BLE", 0);
        BLE = r100;
        SearchType r101 = new SearchType("SSDP", 1);
        SSDP = r101;
        SearchType r102 = new SearchType("MDNS", 2);
        MDNS = r102;
        $VALUES = new SearchType[]{r100, r101, r102};
    }

    public static SearchType[] values() {
        return (SearchType[]) $VALUES.clone();
    }

    public static SearchType valueOf(String r100) {
        return (SearchType) a.a(SearchType.class, r100);
    }

    private SearchType(String r100, int r101) {
        super(r100, r101);
    }
}
