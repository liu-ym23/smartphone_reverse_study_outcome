package com.bytedance.applog.map.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
public final class MapConfig {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/applog/map/api/MapConfig$MapScreenCaptureMethod;", "", "Canvas", "PixCopy", "map-api_release"}, k = 1, mv = {1, 6, 0})
    public static final enum MapScreenCaptureMethod extends Enum<MapScreenCaptureMethod> {
        public static final MapScreenCaptureMethod Canvas = null;
        public static final MapScreenCaptureMethod PixCopy = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MapScreenCaptureMethod[] f192484a = null;

        public static MapScreenCaptureMethod valueOf(String r100) {
            return (MapScreenCaptureMethod) r27.a.a(MapScreenCaptureMethod.class, r100);
        }

        public static MapScreenCaptureMethod[] values() {
            return (MapScreenCaptureMethod[]) f192484a.clone();
        }

        static {
            MapScreenCaptureMethod r100 = new MapScreenCaptureMethod("Canvas", 0);
            Canvas = r100;
            MapScreenCaptureMethod r101 = new MapScreenCaptureMethod("PixCopy", 1);
            PixCopy = r101;
            f192484a = new MapScreenCaptureMethod[]{r100, r101};
        }

        public MapScreenCaptureMethod(String r100, int r101) {
            super(r100, r101);
        }
    }
}
