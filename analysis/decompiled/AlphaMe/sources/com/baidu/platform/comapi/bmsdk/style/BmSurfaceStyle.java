package com.baidu.platform.comapi.bmsdk.style;

import com.baidu.platform.comapi.bmsdk.BmObject;

/* loaded from: classes.dex */
public class BmSurfaceStyle extends BmObject {

    /* renamed from: a, reason: collision with root package name */
    private int f8700a;

    /* renamed from: b, reason: collision with root package name */
    private int f8701b;

    /* renamed from: c, reason: collision with root package name */
    private BmBitmapResource f8702c;

    public BmSurfaceStyle() {
        super(53, nativeCreate());
        this.f8700a = 0;
        this.f8701b = 0;
        this.f8702c = null;
    }

    private static native long nativeCreate();

    private static native boolean nativeSetBitmapResource(long j4, long j5);

    private static native boolean nativeSetBmpResId(long j4, int i4);

    private static native boolean nativeSetColor(long j4, int i4);

    public boolean a(int i4) {
        this.f8701b = i4;
        return nativeSetColor(this.nativeInstance, a.a(i4));
    }

    public boolean a(BmBitmapResource bmBitmapResource) {
        this.f8702c = bmBitmapResource;
        this.f8700a = 0;
        return nativeSetBitmapResource(this.nativeInstance, bmBitmapResource.getNativeInstance());
    }
}
