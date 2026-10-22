package com.baidu.mapapi.map;

/* JADX INFO: loaded from: classes39.dex */
public final enum MapLayer extends Enum<MapLayer> {
    public static final MapLayer BM_LAYER_OVERLAY = null;
    public static final MapLayer MAP_LAYER_HEATMAP = null;
    public static final MapLayer MAP_LAYER_HEXAGONMAP = null;
    public static final MapLayer MAP_LAYER_LOCATION = null;
    public static final MapLayer MAP_LAYER_OVERLAY = null;
    public static final MapLayer MAP_LAYER_TRACE_OVERLAY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ MapLayer[] f31024a = null;

    static {
        MapLayer r100 = new MapLayer("MAP_LAYER_OVERLAY", 0);
        MAP_LAYER_OVERLAY = r100;
        MapLayer r101 = new MapLayer("BM_LAYER_OVERLAY", 1);
        BM_LAYER_OVERLAY = r101;
        MapLayer r102 = new MapLayer("MAP_LAYER_HEATMAP", 2);
        MAP_LAYER_HEATMAP = r102;
        MapLayer r103 = new MapLayer("MAP_LAYER_HEXAGONMAP", 3);
        MAP_LAYER_HEXAGONMAP = r103;
        MapLayer r104 = new MapLayer("MAP_LAYER_LOCATION", 4);
        MAP_LAYER_LOCATION = r104;
        MapLayer r105 = new MapLayer("MAP_LAYER_TRACE_OVERLAY", 5);
        MAP_LAYER_TRACE_OVERLAY = r105;
        f31024a = new MapLayer[]{r100, r101, r102, r103, r104, r105};
    }

    public static MapLayer[] values() {
        return (MapLayer[]) f31024a.clone();
    }

    public static MapLayer valueOf(String r100) {
        return (MapLayer) r27.a.a(MapLayer.class, r100);
    }

    private MapLayer(String r100, int r101) {
        super(r100, r101);
    }
}
