package com.baidu.platform.comapi.bmsdk.style;

import com.baidu.platform.comapi.bmsdk.BmObject;

/* JADX INFO: loaded from: classes39.dex */
public class BmTrackStyle extends BmObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f32848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f32849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BmBitmapResource f32850c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f32851d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private BmBitmapResource f32852e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f32853f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f32854g;

    private static native long nativeCreate();

    private static native boolean nativeSetBitmapResource(long r100, long r101);

    private static native boolean nativeSetColor(long r100, int r101);

    private static native boolean nativeSetOpacity(long r100, float r101);

    private static native boolean nativeSetPaletteBitmapResource(long r100, long r101);

    private static native boolean nativeSetPaletteOpacity(long r100, float r101);

    private static native boolean nativeSetTrackType(long r100, int r101);

    private static native boolean nativeSetWidth(long r100, int r101);

    public BmTrackStyle() {
        super(61, nativeCreate());
        this.f32848a = 0;
        this.f32849b = 0;
        this.f32850c = null;
        this.f32851d = 0.0f;
        this.f32852e = null;
        this.f32853f = 0.0f;
        this.f32854g = 0;
    }

    @Override // com.baidu.platform.comapi.bmsdk.BmObject, java.lang.AutoCloseable
    public void close() throws Exception {
        super.close();
        BmBitmapResource r100 = this.f32850c;
        if (r100 != null) goto L13;
    L6:
        BmBitmapResource r101 = this.f32852e;
        if (r101 == null) goto L17;
        r101.close();     // Catch: Exception -> L11
    L9:
        this.f32852e = null;
        return;
    L17:
        return;
    L13:
        r100.close();     // Catch: Exception -> L12
    L5:
        this.f32850c = null;
        goto L6
    }

    public boolean a(BmBitmapResource r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        BmBitmapResource r101 = this.f32850c;
        if (r101 != null) goto L8;
    L10:
        this.f32850c = r100;
        return nativeSetBitmapResource(getNativeInstance(), r100.getNativeInstance());
    L8:
        if (r101.getNativeInstance() == r100.getNativeInstance()) goto L10;
        this.f32850c.close();     // Catch: Exception -> L12
        goto L10
    }

    public boolean b(BmBitmapResource r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        BmBitmapResource r101 = this.f32852e;
        if (r101 != null) goto L8;
    L10:
        this.f32852e = r100;
        return nativeSetPaletteBitmapResource(getNativeInstance(), r100.getNativeInstance());
    L8:
        if (r101.getNativeInstance() == r100.getNativeInstance()) goto L10;
        this.f32850c.close();     // Catch: Exception -> L12
        goto L10
    }

    public boolean c(int r100) {
        this.f32848a = r100;
        return nativeSetWidth(getNativeInstance(), this.f32848a);
    }

    public boolean a(int r100) {
        this.f32854g = r100;
        return nativeSetColor(getNativeInstance(), a.a(this.f32854g));
    }

    public boolean b(float r100) {
        this.f32853f = r100;
        return nativeSetPaletteOpacity(getNativeInstance(), this.f32853f);
    }

    public boolean a(float r100) {
        this.f32851d = r100;
        return nativeSetOpacity(getNativeInstance(), this.f32851d);
    }

    public boolean b(int r100) {
        this.f32849b = r100;
        return nativeSetTrackType(getNativeInstance(), r100);
    }
}
