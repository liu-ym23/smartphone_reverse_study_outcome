package com.bytedance.android.livesdkapi.enterparam;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B}\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\nR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/enterparam/PreviewEtDataCache;", "", "enterRoomCache", "", "", "mobParamsCache", "paramsCache", "firstRoomParamsCache", "firstRoomMobParamsCache", "firstShowRoomParamsCache", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "getEnterRoomCache", "()Ljava/util/Map;", "getFirstRoomMobParamsCache", "getFirstRoomParamsCache", "getFirstShowRoomParamsCache", "getMobParamsCache", "getParamsCache", "room_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewEtDataCache {
    private final Map<String, String> enterRoomCache;
    private final Map<String, String> firstRoomMobParamsCache;
    private final Map<String, String> firstRoomParamsCache;
    private final Map<String, String> firstShowRoomParamsCache;
    private final Map<String, String> mobParamsCache;
    private final Map<String, String> paramsCache;

    public final Map<String, String> getEnterRoomCache() {
        return this.enterRoomCache;
    }

    public final Map<String, String> getFirstRoomMobParamsCache() {
        return this.firstRoomMobParamsCache;
    }

    public final Map<String, String> getFirstRoomParamsCache() {
        return this.firstRoomParamsCache;
    }

    public final Map<String, String> getFirstShowRoomParamsCache() {
        return this.firstShowRoomParamsCache;
    }

    public final Map<String, String> getMobParamsCache() {
        return this.mobParamsCache;
    }

    public final Map<String, String> getParamsCache() {
        return this.paramsCache;
    }

    public PreviewEtDataCache(Map<String, String> r100, Map<String, String> r101, Map<String, String> r102, Map<String, String> r103, Map<String, String> r104, Map<String, String> r105) {
        Intrinsics.checkNotNullParameter(r100, "enterRoomCache");
        Intrinsics.checkNotNullParameter(r101, "mobParamsCache");
        Intrinsics.checkNotNullParameter(r102, "paramsCache");
        Intrinsics.checkNotNullParameter(r103, "firstRoomParamsCache");
        Intrinsics.checkNotNullParameter(r104, "firstRoomMobParamsCache");
        Intrinsics.checkNotNullParameter(r105, "firstShowRoomParamsCache");
        this.enterRoomCache = r100;
        this.mobParamsCache = r101;
        this.paramsCache = r102;
        this.firstRoomParamsCache = r103;
        this.firstRoomMobParamsCache = r104;
        this.firstShowRoomParamsCache = r105;
    }
}
