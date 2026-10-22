package com.baidu.platform.comapi.bmsdk.cluster;

import com.baidu.platform.comapi.bmsdk.BmObject;

/* JADX INFO: loaded from: classes39.dex */
public class BmClusterTemplate extends BmObject {
    private static native long nativeCreate();

    private static native boolean nativeSetClusterUI(long r100, long[] r101, int r102);

    private BmClusterTemplate() {
        super(15, nativeCreate());
    }
}
