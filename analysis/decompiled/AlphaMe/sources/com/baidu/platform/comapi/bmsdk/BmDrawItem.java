package com.baidu.platform.comapi.bmsdk;

import com.baidu.platform.comapi.bmsdk.animation.BmAnimation;

/* loaded from: classes.dex */
public abstract class BmDrawItem extends BmObject {

    /* renamed from: a, reason: collision with root package name */
    protected int f8623a;

    /* renamed from: b, reason: collision with root package name */
    protected float f8624b;

    /* renamed from: c, reason: collision with root package name */
    protected String f8625c;

    /* renamed from: d, reason: collision with root package name */
    int f8626d;

    /* renamed from: e, reason: collision with root package name */
    private int f8627e;

    /* renamed from: f, reason: collision with root package name */
    private int f8628f;

    /* renamed from: g, reason: collision with root package name */
    long f8629g;

    /* renamed from: h, reason: collision with root package name */
    protected BmAnimation f8630h;

    private BmDrawItem() {
        super(2, 0L);
        this.f8623a = 1;
        this.f8624b = 1.0f;
        this.f8625c = "";
        this.f8627e = 4;
        this.f8628f = 22;
        this.f8629g = -1L;
        this.f8630h = null;
    }

    private static native boolean nativeSetAnimation(long j4, long j5);

    private static native boolean nativeSetClickable(long j4, boolean z4);

    private static native boolean nativeSetHoleClickable(long j4, boolean z4);

    private static native boolean nativeSetOpacity(long j4, float f4);

    private static native boolean nativeSetShowLevel(long j4, int i4, int i5);

    private static native boolean nativeSetVisibility(long j4, int i4);

    public long a() {
        return this.f8629g;
    }

    public int b() {
        return this.f8626d;
    }

    public boolean c(int i4) {
        this.f8623a = i4;
        return nativeSetVisibility(this.nativeInstance, i4);
    }

    public void d(int i4) {
        this.f8626d = i4;
    }

    public void a(long j4) {
        this.f8629g = j4;
    }

    public boolean b(int i4) {
        return nativeSetShowLevel(this.nativeInstance, i4, this.f8628f);
    }

    public boolean a(int i4, int i5) {
        this.f8627e = i4;
        this.f8628f = i5;
        return nativeSetShowLevel(this.nativeInstance, i4, i5);
    }

    public boolean b(boolean z4) {
        return nativeSetHoleClickable(this.nativeInstance, z4);
    }

    public boolean a(int i4) {
        return nativeSetShowLevel(this.nativeInstance, this.f8627e, i4);
    }

    public boolean a(float f4) {
        this.f8624b = f4;
        return nativeSetOpacity(this.nativeInstance, f4);
    }

    public BmDrawItem(int i4, long j4) {
        super(i4, j4);
        this.f8623a = 1;
        this.f8624b = 1.0f;
        this.f8625c = "";
        this.f8627e = 4;
        this.f8628f = 22;
        this.f8629g = -1L;
        this.f8630h = null;
    }

    public boolean a(boolean z4) {
        return nativeSetClickable(this.nativeInstance, z4);
    }

    public boolean a(BmAnimation bmAnimation) {
        this.f8630h = bmAnimation;
        return nativeSetAnimation(this.nativeInstance, bmAnimation == null ? 0L : bmAnimation.getNativeInstance());
    }
}
