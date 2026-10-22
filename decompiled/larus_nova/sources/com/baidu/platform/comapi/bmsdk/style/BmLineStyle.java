package com.baidu.platform.comapi.bmsdk.style;

import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.platform.comapi.bmsdk.BmObject;

/* JADX INFO: loaded from: classes39.dex */
public class BmLineStyle extends BmObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f32829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f32830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f32831c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BmBitmapResource f32832d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f32833e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f32834f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f32835g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f32836h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f32837i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f32838j;

    private static native boolean nativeClearBitmapResource(long r100);

    private static native long nativeCreate();

    private static native boolean nativeSetBitmapResource(long r100, long r101);

    private static native boolean nativeSetBmpResId(long r100, int r101);

    private static native boolean nativeSetColor(long r100, int r101);

    private static native boolean nativeSetLineResId(long r100, int r101);

    private static native boolean nativeSetLineType(long r100, int r101);

    private static native boolean nativeSetStrokeColor(long r100, int r101);

    private static native boolean nativeSetStrokeWidth(long r100, int r101);

    private static native boolean nativeSetTextureOption(long r100, int r101);

    private static native boolean nativeSetWidth(long r100, float r101);

    public boolean a() {
        if (this.f32832d != null) goto L6;
        return true;
    L6:
        this.f32832d = null;
        return nativeClearBitmapResource(this.nativeInstance);
    }

    public BmLineStyle() {
        super(51, nativeCreate());
        this.f32829a = 0;
        this.f32830b = 0;
        this.f32831c = 0;
        this.f32832d = null;
        this.f32833e = 0;
        this.f32834f = 0.0f;
        this.f32835g = 0;
        this.f32836h = 0;
        this.f32837i = 0;
        this.f32838j = 0;
    }

    @Override // com.baidu.platform.comapi.bmsdk.BmObject, java.lang.AutoCloseable
    public void close() throws Exception {
        super.close();
        BmBitmapResource r100 = this.f32832d;
        if (r100 == null) goto L10;
        r100.close();     // Catch: Exception -> L7
    L5:
        this.f32832d = null;
        return;
    }

    public boolean a(BmBitmapResource r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        BmBitmapResource r101 = this.f32832d;
        if (r101 != null) goto L8;
    L10:
        this.f32832d = r100;
        this.f32830b = 0;
        this.f32829a = 0;
        return nativeSetBitmapResource(getNativeInstance(), r100.getNativeInstance());
    L8:
        if (r101.getNativeInstance() == r100.getNativeInstance()) goto L10;
        this.f32832d.close();     // Catch: Exception -> L12
        goto L10
    }

    public boolean b(int r100) {
        this.f32838j = r100;
        return nativeSetLineType(getNativeInstance(), r100);
    }

    public boolean c(int r100) {
        this.f32837i = r100;
        return nativeSetTextureOption(getNativeInstance(), r100);
    }

    public boolean d(int r100) {
        if (r100 == 0) goto L7;
        if (r100 == 1) goto L7;
        return false;
    L7:
        this.f32833e = r100;
        return true;
    }

    public boolean a(float r100) {
        int r101 = this.f32833e;
        if (r101 != 0) goto L5;
        this.f32834f = r100 / 2.0f;
    L10:
        return nativeSetWidth(getNativeInstance(), this.f32834f);
    L5:
        if (r101 != 1) goto L10;
        this.f32834f = ((r100 * 310.0f) / SysOSUtil.getDensityDpi()) / 2.0f;
        goto L10
    }

    public boolean a(int r100) {
        this.f32831c = r100;
        return nativeSetColor(getNativeInstance(), a.a(r100));
    }
}
