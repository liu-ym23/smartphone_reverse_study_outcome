package com.baidu.platform.comapi.bmsdk;

import com.baidu.platform.comapi.bmsdk.animation.BmAnimation;

/* JADX INFO: loaded from: classes39.dex */
public abstract class BmDrawItem extends BmObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f32761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected float f32762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected String f32763c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f32764d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f32765e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f32766f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    long f32767g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected BmAnimation f32768h;

    private BmDrawItem() {
        super(2, 0);
        this.f32761a = 1;
        this.f32762b = 1.0f;
        this.f32763c = "";
        this.f32765e = 4;
        this.f32766f = 22;
        this.f32767g = -1;
        this.f32768h = null;
    }

    private static native boolean nativeSetAnimation(long r100, long r101);

    private static native boolean nativeSetClickable(long r100, boolean r101);

    private static native boolean nativeSetHoleClickable(long r100, boolean r101);

    private static native boolean nativeSetOpacity(long r100, float r101);

    private static native boolean nativeSetShowLevel(long r100, int r101, int r102);

    private static native boolean nativeSetVisibility(long r100, int r101);

    public long a() {
        return this.f32767g;
    }

    public int b() {
        return this.f32764d;
    }

    @Override // com.baidu.platform.comapi.bmsdk.BmObject, java.lang.AutoCloseable
    public void close() throws Exception {
        super.close();
    }

    public boolean a(BmAnimation r100) {
        this.f32768h = r100;
        long r101 = getNativeInstance();
        if (r100 != null) goto L5;
        long r102 = 0;
    L7:
        return nativeSetAnimation(r101, r102);
    L5:
        r102 = r100.getNativeInstance();
        goto L7
    }

    public boolean b(int r100) {
        return nativeSetShowLevel(getNativeInstance(), r100, this.f32766f);
    }

    public boolean c(int r100) {
        this.f32761a = r100;
        return nativeSetVisibility(getNativeInstance(), r100);
    }

    public void d(int r100) {
        this.f32764d = r100;
    }

    public boolean a(float r100) {
        this.f32762b = r100;
        return nativeSetOpacity(getNativeInstance(), r100);
    }

    public boolean b(boolean r100) {
        return nativeSetHoleClickable(getNativeInstance(), r100);
    }

    public boolean a(int r100) {
        return nativeSetShowLevel(getNativeInstance(), this.f32765e, r100);
    }

    public boolean a(boolean r100) {
        return nativeSetClickable(getNativeInstance(), r100);
    }

    public void a(long r100) {
        this.f32767g = r100;
    }

    public BmDrawItem(int r100, long r101) {
        super(r100, r101);
        this.f32761a = 1;
        this.f32762b = 1.0f;
        this.f32763c = "";
        this.f32765e = 4;
        this.f32766f = 22;
        this.f32767g = -1;
        this.f32768h = null;
    }

    public boolean a(int r100, int r101) {
        this.f32765e = r100;
        this.f32766f = r101;
        return nativeSetShowLevel(getNativeInstance(), this.f32765e, this.f32766f);
    }
}
