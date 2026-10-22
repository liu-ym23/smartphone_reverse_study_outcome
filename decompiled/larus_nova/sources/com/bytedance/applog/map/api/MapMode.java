package com.bytedance.applog.map.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/applog/map/api/MapMode;", "", "RealtimeSearch", "FullMap", "map-api_release"}, k = 1, mv = {1, 6, 0})
public final enum MapMode extends Enum<MapMode> {
    public static final MapMode FullMap = null;
    public static final MapMode RealtimeSearch = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MapMode[] f192485a = null;

    public static MapMode valueOf(String r100) {
        return (MapMode) r27.a.a(MapMode.class, r100);
    }

    public static MapMode[] values() {
        return (MapMode[]) f192485a.clone();
    }

    static {
        MapMode r100 = new MapMode("RealtimeSearch", 0);
        RealtimeSearch = r100;
        MapMode r101 = new MapMode("FullMap", 1);
        FullMap = r101;
        f192485a = new MapMode[]{r100, r101};
    }

    public MapMode(String r100, int r101) {
        super(r100, r101);
    }
}
