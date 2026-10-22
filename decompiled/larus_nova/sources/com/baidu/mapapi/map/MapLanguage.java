package com.baidu.mapapi.map;

/* JADX INFO: loaded from: classes39.dex */
public final enum MapLanguage extends Enum<MapLanguage> {
    public static final MapLanguage CHINESE = null;
    public static final MapLanguage ENGLISH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ MapLanguage[] f31023a = null;

    static {
        MapLanguage r100 = new MapLanguage("CHINESE", 0);
        CHINESE = r100;
        MapLanguage r101 = new MapLanguage("ENGLISH", 1);
        ENGLISH = r101;
        f31023a = new MapLanguage[]{r100, r101};
    }

    public static MapLanguage[] values() {
        return (MapLanguage[]) f31023a.clone();
    }

    public static MapLanguage valueOf(String r100) {
        return (MapLanguage) r27.a.a(MapLanguage.class, r100);
    }

    private MapLanguage(String r100, int r101) {
        super(r100, r101);
    }
}
