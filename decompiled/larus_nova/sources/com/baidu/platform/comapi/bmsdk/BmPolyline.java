package com.baidu.platform.comapi.bmsdk;

/* JADX INFO: loaded from: classes39.dex */
public class BmPolyline extends BmBaseLine {
    private static native long nativeCreate();

    private static native boolean nativeUseGeodesic(long r100, boolean r101);

    public BmPolyline() {
        super(8, nativeCreate());
    }
}
