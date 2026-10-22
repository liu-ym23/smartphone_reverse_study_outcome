package com.baidu.platform.comapi.bmsdk;

import com.baidu.mapapi.map.Marker;
import com.baidu.platform.comapi.bmsdk.style.BmDrawableResource;

/* JADX INFO: loaded from: classes39.dex */
public class BmIconMarker extends BmBaseMarker {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f32778w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private BmDrawableResource f32779x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Marker f32780y;

    private static native long nativeCreate();

    private static native boolean nativeSetAnimationType(long r100, int r101);

    private static native boolean nativeSetBmpResId(long r100, int r101);

    private static native boolean nativeSetColor(long r100, int r101);

    private static native boolean nativeSetDrawableResource(long r100, long r101);

    public BmIconMarker() {
        super(4, nativeCreate());
        this.f32778w = 0;
    }

    @Override // com.baidu.platform.comapi.bmsdk.BmDrawItem, com.baidu.platform.comapi.bmsdk.BmObject, java.lang.AutoCloseable
    public void close() throws Exception {
        super.close();
        BmDrawableResource r100 = this.f32779x;     // Catch: Exception -> L7
        if (r100 == null) goto L10;
        r100.close();     // Catch: Exception -> L7
        return;
    L10:
        return;
    }

    public Marker d() {
        return this.f32780y;
    }

    public boolean a(BmDrawableResource r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        BmDrawableResource r101 = this.f32779x;
        if (r101 != null) goto L8;
    L10:
        this.f32779x = r100;
        this.f32778w = 0;
        return nativeSetDrawableResource(getNativeInstance(), this.f32779x.getNativeInstance());
    L8:
        if (r101.getNativeInstance() == r100.getNativeInstance()) goto L10;
        this.f32779x.close();     // Catch: Exception -> L12
        goto L10
    }

    public boolean o(int r100) {
        return nativeSetAnimationType(getNativeInstance(), r100);
    }

    public void a(Marker r100) {
        this.f32780y = r100;
    }
}
