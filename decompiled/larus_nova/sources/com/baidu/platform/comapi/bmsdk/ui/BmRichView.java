package com.baidu.platform.comapi.bmsdk.ui;

import com.baidu.platform.comapi.bmsdk.BmObject;
import com.baidu.platform.comapi.bmsdk.animation.BmAnimation;

/* JADX INFO: loaded from: classes39.dex */
public class BmRichView extends BmObject {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f32868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f32869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BmAnimation f32870c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f32871d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f32872e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f32873f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f32874g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private BmBaseUI f32875h;

    private static native boolean nativeAddRichUIOption(long r100, long r101);

    private static native boolean nativeBuildRichViewByString(String r100);

    private static native boolean nativeBuildRichViewByTemplete(String r100);

    private static native long nativeCreate();

    private static native boolean nativeDelRichUIOption(long r100, long r101);

    private static native boolean nativeSetAnimation(long r100, long r101);

    private static native boolean nativeSetCollisionBehavior(long r100, int r101);

    private static native boolean nativeSetCollisionBorder(long r100, int r101, int r102, int r103, int r104);

    private static native boolean nativeSetCollisionLineTagId(long r100, int r101);

    private static native boolean nativeSetCollisionPriority(long r100, int r101);

    private static native boolean nativeSetCollisionPriority(long r100, short r101);

    private static native boolean nativeSetDrawFullscreenMaskFlag(long r100, boolean r101);

    private static native boolean nativeSetLocated(long r100, int r101);

    private static native boolean nativeSetOffsetX(long r100, int r101, int r102);

    private static native boolean nativeSetOffsetY(long r100, int r101, int r102);

    private static native boolean nativeSetOpacity(long r100, float r101);

    private static native boolean nativeSetScale(long r100, float r101);

    private static native boolean nativeSetScaleX(long r100, float r101);

    private static native boolean nativeSetScaleY(long r100, float r101);

    private static native boolean nativeSetShowLevel(long r100, int r101, int r102);

    private static native boolean nativeSetView(long r100, long r101);

    private static native boolean nativeSetVisibility(long r100, int r101);

    public BmRichView() {
        super(30, nativeCreate());
        this.f32868a = 1;
        this.f32869b = 2;
        this.f32870c = null;
        this.f32871d = 1.0f;
        this.f32872e = 1.0f;
        this.f32873f = 1.0f;
        this.f32874g = "";
        this.f32875h = null;
    }

    public boolean a(BmBaseUI r100) {
        this.f32875h = r100;
        long r101 = this.nativeInstance;
        if (r100 == null) goto L5;
        Long r102 = Long.valueOf(r100.getNativeInstance());
    L7:
        return nativeSetView(r101, r102.longValue());
    L5:
        r102 = null;
        goto L7
    }

    public boolean b(float r100) {
        this.f32872e = r100;
        return nativeSetScaleX(this.nativeInstance, r100);
    }

    public boolean c(float r100) {
        this.f32873f = r100;
        return nativeSetScaleY(this.nativeInstance, r100);
    }

    public boolean a(BmAnimation r100) {
        this.f32870c = r100;
        long r101 = this.nativeInstance;
        if (r100 != null) goto L5;
        long r102 = 0;
    L7:
        return nativeSetAnimation(r101, r102);
    L5:
        r102 = r100.getNativeInstance();
        goto L7
    }

    public boolean b(int r100) {
        this.f32869b = r100;
        return nativeSetLocated(this.nativeInstance, r100);
    }

    public boolean c(int r100) {
        this.f32868a = r100;
        return nativeSetVisibility(this.nativeInstance, r100);
    }

    public BmBaseUI a(long r100) {
        BmBaseUI r101 = this.f32875h;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.a(r100);
    }

    public boolean a(float r100) {
        this.f32872e = r100;
        this.f32873f = r100;
        return nativeSetScale(this.nativeInstance, r100);
    }

    public boolean a(int r100) {
        return nativeSetCollisionBehavior(this.nativeInstance, r100);
    }

    public boolean a(short r100) {
        return nativeSetCollisionPriority(this.nativeInstance, r100);
    }

    public boolean a(int r100, int r101) {
        return nativeSetShowLevel(this.nativeInstance, r100, r101);
    }
}
