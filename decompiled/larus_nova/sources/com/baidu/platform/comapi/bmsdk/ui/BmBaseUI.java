package com.baidu.platform.comapi.bmsdk.ui;

import com.baidu.mapapi.map.bmsdk.ui.BaseUI;
import com.baidu.platform.comapi.bmsdk.BmObject;
import com.baidu.platform.comapi.bmsdk.style.BmDrawableResource;
import com.baidu.platform.comapi.bmsdk.style.a;

/* JADX INFO: loaded from: classes39.dex */
public abstract class BmBaseUI extends BmObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f32859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f32860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f32861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f32862d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f32863e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private BaseUI f32864f;

    private static native boolean nativeSetAlignParent(long r100, int r101);

    private static native boolean nativeSetBackground(long r100, long r101);

    private static native boolean nativeSetBackgroundColor(long r100, int r101);

    private static native boolean nativeSetBackgroundResId(long r100, int r101);

    private static native boolean nativeSetBkColorOfLeft(long r100, int r101);

    private static native boolean nativeSetBkColorOfRight(long r100, int r101);

    private static native boolean nativeSetClickable(long r100, boolean r101);

    private static native boolean nativeSetGravity(long r100, int r101);

    private static native boolean nativeSetHeight(long r100, int r101);

    private static native boolean nativeSetLayoutWeight(long r100, int r101);

    private static native boolean nativeSetMargin(long r100, int r101, int r102, int r103, int r104);

    private static native boolean nativeSetPadding(long r100, int r101, int r102, int r103, int r104);

    private static native boolean nativeSetVisibility(long r100, int r101);

    private static native boolean nativeSetWidth(long r100, int r101);

    private BmBaseUI() {
        super(31, 0);
        this.f32859a = 1;
        this.f32860b = "";
        this.f32861c = "";
        this.f32862d = false;
        this.f32863e = false;
    }

    public BaseUI a() {
        return this.f32864f;
    }

    public boolean a(BmDrawableResource r100) {
        if (r100 == null) goto L4;
        boolean r101 = true;
    L5:
        this.f32862d = r101;
        if (r100 == null) goto L10;
        return nativeSetBackground(this.nativeInstance, r100.getNativeInstance());
    L10:
        return nativeSetBackground(this.nativeInstance, 0);
    L4:
        r101 = false;
        goto L5
    }

    public boolean b(int r100) {
        if (r100 == 0) goto L4;
        boolean r101 = true;
    L5:
        this.f32863e = r101;
        return nativeSetBackgroundColor(this.nativeInstance, a.a(r100));
    L4:
        r101 = false;
        goto L5
    }

    public boolean c(int r100) {
        if (r100 == 0) goto L4;
        boolean r101 = true;
    L5:
        this.f32863e = r101;
        return nativeSetBkColorOfLeft(this.nativeInstance, a.a(r100));
    L4:
        r101 = false;
        goto L5
    }

    public boolean d(int r100) {
        if (r100 == 0) goto L4;
        boolean r101 = true;
    L5:
        this.f32863e = r101;
        return nativeSetBkColorOfRight(this.nativeInstance, a.a(r100));
    L4:
        r101 = false;
        goto L5
    }

    public boolean e(int r100) {
        return nativeSetGravity(this.nativeInstance, r100);
    }

    public boolean f(int r100) {
        return nativeSetHeight(this.nativeInstance, r100);
    }

    public boolean g(int r100) {
        return nativeSetLayoutWeight(this.nativeInstance, r100);
    }

    public boolean h(int r100) {
        this.f32859a = r100;
        return nativeSetVisibility(this.nativeInstance, r100);
    }

    public boolean i(int r100) {
        return nativeSetWidth(this.nativeInstance, r100);
    }

    public BmBaseUI a(long r100) {
        if (this.nativeInstance != r100) goto L5;
        return this;
    L5:
        return null;
    }

    public boolean a(int r100) {
        return nativeSetAlignParent(this.nativeInstance, r100);
    }

    public boolean a(boolean r100) {
        return nativeSetClickable(this.nativeInstance, r100);
    }

    public void a(BaseUI r100) {
        this.f32864f = r100;
    }

    public void a(String r100) {
        this.f32860b = r100;
    }

    public BmBaseUI(int r100, long r101) {
        super(r100, r101);
        this.f32859a = 1;
        this.f32860b = "";
        this.f32861c = "";
        this.f32862d = false;
        this.f32863e = false;
    }

    public boolean a(int r100, int r101, int r102, int r110) {
        return nativeSetMargin(this.nativeInstance, r100, r101, r102, r110);
    }

    public boolean b(int r100, int r101, int r102, int r110) {
        return nativeSetPadding(this.nativeInstance, r100, r101, r102, r110);
    }
}
