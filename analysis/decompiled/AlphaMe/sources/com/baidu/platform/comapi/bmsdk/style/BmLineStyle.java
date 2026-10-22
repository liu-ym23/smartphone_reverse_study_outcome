package com.baidu.platform.comapi.bmsdk.style;

import com.baidu.platform.comapi.bmsdk.BmObject;

/* loaded from: classes.dex */
public class BmLineStyle extends BmObject {

    /* renamed from: a, reason: collision with root package name */
    private int f8691a;

    /* renamed from: b, reason: collision with root package name */
    private int f8692b;

    /* renamed from: c, reason: collision with root package name */
    private int f8693c;

    /* renamed from: d, reason: collision with root package name */
    private BmBitmapResource f8694d;

    /* renamed from: e, reason: collision with root package name */
    private int f8695e;

    /* renamed from: f, reason: collision with root package name */
    private int f8696f;

    /* renamed from: g, reason: collision with root package name */
    private int f8697g;

    /* renamed from: h, reason: collision with root package name */
    private int f8698h;

    /* renamed from: i, reason: collision with root package name */
    private int f8699i;

    public BmLineStyle() {
        super(51, nativeCreate());
        this.f8691a = 0;
        this.f8692b = 0;
        this.f8693c = 0;
        this.f8694d = null;
        this.f8695e = 0;
        this.f8696f = 0;
        this.f8697g = 0;
        this.f8698h = 0;
        this.f8699i = 0;
    }

    private static native long nativeCreate();

    private static native boolean nativeSetBitmapResource(long j4, long j5);

    private static native boolean nativeSetBmpResId(long j4, int i4);

    private static native boolean nativeSetColor(long j4, int i4);

    private static native boolean nativeSetLineResId(long j4, int i4);

    private static native boolean nativeSetLineType(long j4, int i4);

    private static native boolean nativeSetStrokeColor(long j4, int i4);

    private static native boolean nativeSetStrokeWidth(long j4, int i4);

    private static native boolean nativeSetTextureOption(long j4, int i4);

    private static native boolean nativeSetWidth(long j4, int i4);

    public boolean a(int i4) {
        this.f8693c = i4;
        return nativeSetColor(this.nativeInstance, a.a(i4));
    }

    public boolean b(int i4) {
        this.f8699i = i4;
        return nativeSetLineType(this.nativeInstance, i4);
    }

    public boolean c(int i4) {
        this.f8698h = i4;
        return nativeSetTextureOption(this.nativeInstance, i4);
    }

    public boolean d(int i4) {
        int i5 = i4 / 2;
        this.f8695e = i5;
        return nativeSetWidth(this.nativeInstance, i5);
    }

    public boolean a(BmBitmapResource bmBitmapResource) {
        this.f8694d = bmBitmapResource;
        this.f8692b = 0;
        this.f8691a = 0;
        return nativeSetBitmapResource(this.nativeInstance, bmBitmapResource.getNativeInstance());
    }
}
