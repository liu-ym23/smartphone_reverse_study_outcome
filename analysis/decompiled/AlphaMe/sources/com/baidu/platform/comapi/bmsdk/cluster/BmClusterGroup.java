package com.baidu.platform.comapi.bmsdk.cluster;

import com.baidu.platform.comapi.bmsdk.BmDrawItem;

/* loaded from: classes.dex */
public class BmClusterGroup extends BmDrawItem {
    private BmClusterGroup() {
        super(14, nativeCreate());
    }

    private static native boolean nativeAddMarker(long j4, long j5);

    private static native boolean nativeClearMarkers(long j4);

    private static native long nativeCreate();

    private static native boolean nativeRemoveMarker(long j4, long j5);

    private static native boolean nativeSetClusterTemplate(long j4, long j5);
}
