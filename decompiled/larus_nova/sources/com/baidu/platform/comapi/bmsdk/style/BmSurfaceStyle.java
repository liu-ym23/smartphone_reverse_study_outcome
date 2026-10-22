package com.baidu.platform.comapi.bmsdk.style;

import com.baidu.platform.comapi.bmsdk.BmObject;

/* JADX INFO: loaded from: classes39.dex */
public class BmSurfaceStyle extends BmObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f32839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f32840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BmBitmapResource f32841c;

    private static native long nativeCreate();

    private static native boolean nativeSetBitmapResource(long r100, long r101);

    private static native boolean nativeSetBmpResId(long r100, int r101);

    private static native boolean nativeSetColor(long r100, int r101);

    public BmSurfaceStyle() {
        super(53, nativeCreate());
        this.f32839a = 0;
        this.f32840b = 0;
        this.f32841c = null;
    }

    public boolean a(BmBitmapResource r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        BmBitmapResource r101 = this.f32841c;
        if (r101 != null) goto L8;
    L10:
        this.f32841c = r100;
        this.f32839a = 0;
        return nativeSetBitmapResource(getNativeInstance(), r100.getNativeInstance());
    L8:
        if (r101.getNativeInstance() == r100.getNativeInstance()) goto L10;
        this.f32841c.close();     // Catch: Exception -> L12
        goto L10
    }

    public boolean a(int r100) {
        this.f32840b = r100;
        return nativeSetColor(getNativeInstance(), a.a(r100));
    }
}
