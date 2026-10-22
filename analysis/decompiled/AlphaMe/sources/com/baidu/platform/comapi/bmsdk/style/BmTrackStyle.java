package com.baidu.platform.comapi.bmsdk.style;

import com.baidu.platform.comapi.bmsdk.BmObject;
import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public class BmTrackStyle extends BmObject {

    /* renamed from: a, reason: collision with root package name */
    private int f8708a;

    /* renamed from: b, reason: collision with root package name */
    private int f8709b;

    /* renamed from: c, reason: collision with root package name */
    private BmBitmapResource f8710c;

    /* renamed from: d, reason: collision with root package name */
    private float f8711d;

    /* renamed from: e, reason: collision with root package name */
    private BmBitmapResource f8712e;

    /* renamed from: f, reason: collision with root package name */
    private float f8713f;

    /* renamed from: g, reason: collision with root package name */
    private int f8714g;

    public BmTrackStyle() {
        super(61, nativeCreate());
        this.f8708a = 0;
        this.f8709b = 0;
        this.f8710c = null;
        this.f8711d = Property.DEFAULT_FLOAT_VALUE;
        this.f8712e = null;
        this.f8713f = Property.DEFAULT_FLOAT_VALUE;
        this.f8714g = 0;
    }

    private static native long nativeCreate();

    private static native boolean nativeSetBitmapResource(long j4, long j5);

    private static native boolean nativeSetColor(long j4, int i4);

    private static native boolean nativeSetOpacity(long j4, float f4);

    private static native boolean nativeSetPaletteBitmapResource(long j4, long j5);

    private static native boolean nativeSetPaletteOpacity(long j4, float f4);

    private static native boolean nativeSetTrackType(long j4, int i4);

    private static native boolean nativeSetWidth(long j4, int i4);

    public boolean a(int i4) {
        this.f8714g = i4;
        return nativeSetColor(this.nativeInstance, a.a(i4));
    }

    public boolean b(int i4) {
        this.f8709b = i4;
        return nativeSetTrackType(this.nativeInstance, i4);
    }

    public boolean c(int i4) {
        this.f8708a = i4;
        return nativeSetWidth(this.nativeInstance, i4);
    }

    public boolean a(BmBitmapResource bmBitmapResource) {
        this.f8710c = bmBitmapResource;
        return nativeSetBitmapResource(this.nativeInstance, bmBitmapResource.getNativeInstance());
    }

    public boolean b(BmBitmapResource bmBitmapResource) {
        this.f8712e = bmBitmapResource;
        return nativeSetPaletteBitmapResource(this.nativeInstance, bmBitmapResource.getNativeInstance());
    }

    public boolean a(float f4) {
        this.f8711d = f4;
        return nativeSetOpacity(this.nativeInstance, f4);
    }

    public boolean b(float f4) {
        this.f8713f = f4;
        return nativeSetPaletteOpacity(this.nativeInstance, f4);
    }
}
