package com.baidu.platform.comapi.bmsdk;

import com.baidu.mapapi.map.Marker;
import com.baidu.platform.comapi.bmsdk.style.BmDrawableResource;

/* loaded from: classes.dex */
public class BmIconMarker extends BmBaseMarker {

    /* renamed from: w, reason: collision with root package name */
    private int f8640w;

    /* renamed from: x, reason: collision with root package name */
    private BmDrawableResource f8641x;

    /* renamed from: y, reason: collision with root package name */
    private Marker f8642y;

    public BmIconMarker() {
        super(4, nativeCreate());
        this.f8640w = 0;
    }

    private static native long nativeCreate();

    private static native boolean nativeSetAnimationType(long j4, int i4);

    private static native boolean nativeSetBmpResId(long j4, int i4);

    private static native boolean nativeSetColor(long j4, int i4);

    private static native boolean nativeSetDrawableResource(long j4, long j5);

    public void a(Marker marker) {
        this.f8642y = marker;
    }

    public BmDrawableResource d() {
        return this.f8641x;
    }

    public Marker e() {
        return this.f8642y;
    }

    public boolean o(int i4) {
        return nativeSetAnimationType(this.nativeInstance, i4);
    }

    public boolean a(BmDrawableResource bmDrawableResource) {
        this.f8641x = bmDrawableResource;
        this.f8640w = 0;
        return bmDrawableResource != null ? nativeSetDrawableResource(this.nativeInstance, bmDrawableResource.getNativeInstance()) : nativeSetDrawableResource(this.nativeInstance, 0L);
    }
}
