package com.baidu.platform.comapi.bmsdk;

import com.baidu.platform.comapi.bmsdk.style.BmTextStyle;

/* loaded from: classes.dex */
public class BmTextPathMarker extends BmDrawItem {

    /* renamed from: i, reason: collision with root package name */
    private String f8657i;

    /* renamed from: j, reason: collision with root package name */
    private BmTextStyle f8658j;

    public BmTextPathMarker() {
        super(6, nativeCreate());
    }

    private static native boolean nativeAddGeoElement(long j4, long j5);

    private static native boolean nativeClearGeoElements(long j4);

    private static native long nativeCreate();

    private static native boolean nativeSetGeoElement(long j4, long j5);

    private static native boolean nativeSetStyle(long j4, long j5);

    private static native boolean nativeSetText(long j4, String str);

    public boolean a(String str) {
        this.f8657i = str;
        return nativeSetText(this.nativeInstance, str);
    }

    public boolean a(BmTextStyle bmTextStyle) {
        this.f8658j = bmTextStyle;
        if (bmTextStyle != null) {
            return nativeSetStyle(this.nativeInstance, bmTextStyle.nativeInstance);
        }
        return nativeSetStyle(this.nativeInstance, 0L);
    }

    public boolean a(BmGeoElement bmGeoElement) {
        return nativeAddGeoElement(this.nativeInstance, bmGeoElement.getNativeInstance());
    }
}
