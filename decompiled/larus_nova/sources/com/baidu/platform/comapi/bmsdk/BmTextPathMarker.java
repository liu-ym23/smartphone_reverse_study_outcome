package com.baidu.platform.comapi.bmsdk;

import com.baidu.platform.comapi.bmsdk.style.BmTextStyle;

/* JADX INFO: loaded from: classes39.dex */
public class BmTextPathMarker extends BmDrawItem {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f32795i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private BmTextStyle f32796j;

    private static native boolean nativeAddGeoElement(long r100, long r101);

    private static native boolean nativeClearGeoElements(long r100);

    private static native long nativeCreate();

    private static native boolean nativeSetGeoElement(long r100, long r101);

    private static native boolean nativeSetStyle(long r100, long r101);

    private static native boolean nativeSetText(long r100, String r101);

    public BmTextPathMarker() {
        super(6, nativeCreate());
    }

    public boolean a(BmTextStyle r100) {
        this.f32796j = r100;
        if (r100 == null) goto L7;
        return nativeSetStyle(this.nativeInstance, r100.nativeInstance);
    L7:
        return nativeSetStyle(this.nativeInstance, 0);
    }

    public boolean a(BmGeoElement r100) {
        return nativeAddGeoElement(this.nativeInstance, r100.getNativeInstance());
    }

    public boolean a(String r100) {
        this.f32795i = r100;
        return nativeSetText(this.nativeInstance, r100);
    }
}
