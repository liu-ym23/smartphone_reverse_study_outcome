package com.bytedance.android.ec.host.api.map.abstraction;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/host/api/map/abstraction/MapProvider;", "", "AMAP", "BDMAP", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum MapProvider extends Enum<MapProvider> {
    public static final MapProvider AMAP = null;
    public static final MapProvider BDMAP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MapProvider[] f46183a = null;

    static {
        MapProvider r100 = new MapProvider("AMAP", 0);
        AMAP = r100;
        MapProvider r101 = new MapProvider("BDMAP", 1);
        BDMAP = r101;
        f46183a = new MapProvider[]{r100, r101};
    }

    public static MapProvider valueOf(String r100) {
        return (MapProvider) a.a(MapProvider.class, r100);
    }

    public static MapProvider[] values() {
        return (MapProvider[]) f46183a.clone();
    }

    public MapProvider(String r100, int r101) {
        super(r100, r101);
    }
}
