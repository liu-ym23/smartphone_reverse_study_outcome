package com.bytedance.android.ec.host.api.map.abstraction;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ec/host/api/map/abstraction/MapStatus;", "", "UNKNOWN", "LOADED", "RENDERING", "ERROR", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum MapStatus extends Enum<MapStatus> {
    public static final MapStatus ERROR = null;
    public static final MapStatus LOADED = null;
    public static final MapStatus RENDERING = null;
    public static final MapStatus UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MapStatus[] f46184a = null;

    static {
        MapStatus r100 = new MapStatus("UNKNOWN", 0);
        UNKNOWN = r100;
        MapStatus r101 = new MapStatus("LOADED", 1);
        LOADED = r101;
        MapStatus r102 = new MapStatus("RENDERING", 2);
        RENDERING = r102;
        MapStatus r103 = new MapStatus("ERROR", 3);
        ERROR = r103;
        f46184a = new MapStatus[]{r100, r101, r102, r103};
    }

    public static MapStatus valueOf(String r100) {
        return (MapStatus) a.a(MapStatus.class, r100);
    }

    public static MapStatus[] values() {
        return (MapStatus[]) f46184a.clone();
    }

    public MapStatus(String r100, int r101) {
        super(r100, r101);
    }
}
