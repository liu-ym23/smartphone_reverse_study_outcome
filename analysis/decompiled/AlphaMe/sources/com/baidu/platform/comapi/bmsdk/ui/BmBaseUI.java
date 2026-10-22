package com.baidu.platform.comapi.bmsdk.ui;

import com.baidu.mapapi.map.bmsdk.ui.BaseUI;
import com.baidu.platform.comapi.bmsdk.BmObject;
import com.baidu.platform.comapi.bmsdk.style.BmDrawableResource;
import com.baidu.platform.comapi.bmsdk.style.a;

/* loaded from: classes.dex */
public abstract class BmBaseUI extends BmObject {

    /* renamed from: a, reason: collision with root package name */
    private int f8719a;

    /* renamed from: b, reason: collision with root package name */
    private String f8720b;

    /* renamed from: c, reason: collision with root package name */
    private String f8721c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f8722d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f8723e;

    /* renamed from: f, reason: collision with root package name */
    private BaseUI f8724f;

    private BmBaseUI() {
        super(31, 0L);
        this.f8719a = 1;
        this.f8720b = "";
        this.f8721c = "";
        this.f8722d = false;
        this.f8723e = false;
    }

    private static native boolean nativeSetAlignParent(long j4, int i4);

    private static native boolean nativeSetBackground(long j4, long j5);

    private static native boolean nativeSetBackgroundColor(long j4, int i4);

    private static native boolean nativeSetBackgroundResId(long j4, int i4);

    private static native boolean nativeSetBkColorOfLeft(long j4, int i4);

    private static native boolean nativeSetBkColorOfRight(long j4, int i4);

    private static native boolean nativeSetClickable(long j4, boolean z4);

    private static native boolean nativeSetGravity(long j4, int i4);

    private static native boolean nativeSetHeight(long j4, int i4);

    private static native boolean nativeSetLayoutWeight(long j4, int i4);

    private static native boolean nativeSetMargin(long j4, int i4, int i5, int i6, int i7);

    private static native boolean nativeSetPadding(long j4, int i4, int i5, int i6, int i7);

    private static native boolean nativeSetVisibility(long j4, int i4);

    private static native boolean nativeSetWidth(long j4, int i4);

    public void a(BaseUI baseUI) {
        this.f8724f = baseUI;
    }

    public boolean b(int i4) {
        this.f8723e = i4 != 0;
        return nativeSetBackgroundColor(this.nativeInstance, a.a(i4));
    }

    public boolean c(int i4) {
        this.f8723e = i4 != 0;
        return nativeSetBkColorOfLeft(this.nativeInstance, a.a(i4));
    }

    public boolean d(int i4) {
        this.f8723e = i4 != 0;
        return nativeSetBkColorOfRight(this.nativeInstance, a.a(i4));
    }

    public boolean e(int i4) {
        return nativeSetGravity(this.nativeInstance, i4);
    }

    public boolean f(int i4) {
        return nativeSetHeight(this.nativeInstance, i4);
    }

    public boolean g(int i4) {
        return nativeSetLayoutWeight(this.nativeInstance, i4);
    }

    public boolean h(int i4) {
        this.f8719a = i4;
        return nativeSetVisibility(this.nativeInstance, i4);
    }

    public boolean i(int i4) {
        return nativeSetWidth(this.nativeInstance, i4);
    }

    public BaseUI a() {
        return this.f8724f;
    }

    public BmBaseUI a(long j4) {
        if (this.nativeInstance == j4) {
            return this;
        }
        return null;
    }

    public boolean b(int i4, int i5, int i6, int i7) {
        return nativeSetPadding(this.nativeInstance, i4, i5, i6, i7);
    }

    public boolean a(BmDrawableResource bmDrawableResource) {
        this.f8722d = bmDrawableResource != null;
        if (bmDrawableResource != null) {
            return nativeSetBackground(this.nativeInstance, bmDrawableResource.getNativeInstance());
        }
        return nativeSetBackground(this.nativeInstance, 0L);
    }

    public BmBaseUI(int i4, long j4) {
        super(i4, j4);
        this.f8719a = 1;
        this.f8720b = "";
        this.f8721c = "";
        this.f8722d = false;
        this.f8723e = false;
    }

    public boolean a(int i4) {
        return nativeSetAlignParent(this.nativeInstance, i4);
    }

    public boolean a(int i4, int i5, int i6, int i7) {
        return nativeSetMargin(this.nativeInstance, i4, i5, i6, i7);
    }

    public boolean a(boolean z4) {
        return nativeSetClickable(this.nativeInstance, z4);
    }

    public void a(String str) {
        this.f8720b = str;
    }
}
