package com.baidu.platform.comapi.bmsdk.cluster;

import com.baidu.platform.comapi.bmsdk.BmDrawItem;

/* JADX INFO: loaded from: classes39.dex */
public class BmClusterGroup extends BmDrawItem {
    private static native boolean nativeAddMarker(long r100, long r101);

    private static native boolean nativeClearMarkers(long r100);

    private static native long nativeCreate();

    private static native boolean nativeRemoveMarker(long r100, long r101);

    private static native boolean nativeSetClusterTemplate(long r100, long r101);

    private BmClusterGroup() {
        super(14, nativeCreate());
    }
}
