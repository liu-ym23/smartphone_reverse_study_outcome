package com.baidu.platform.comapi.bmsdk.ui;

import com.baidu.platform.comapi.bmsdk.BmObject;
import com.baidu.platform.comapi.bmsdk.animation.BmAnimation;

/* loaded from: classes.dex */
public class BmRichView extends BmObject {

    /* renamed from: a, reason: collision with root package name */
    private int f8728a;

    /* renamed from: b, reason: collision with root package name */
    private int f8729b;

    /* renamed from: c, reason: collision with root package name */
    private BmAnimation f8730c;

    /* renamed from: d, reason: collision with root package name */
    private float f8731d;

    /* renamed from: e, reason: collision with root package name */
    private float f8732e;

    /* renamed from: f, reason: collision with root package name */
    private float f8733f;

    /* renamed from: g, reason: collision with root package name */
    private String f8734g;

    /* renamed from: h, reason: collision with root package name */
    private BmBaseUI f8735h;

    public BmRichView() {
        super(30, nativeCreate());
        this.f8728a = 1;
        this.f8729b = 2;
        this.f8730c = null;
        this.f8731d = 1.0f;
        this.f8732e = 1.0f;
        this.f8733f = 1.0f;
        this.f8734g = "";
        this.f8735h = null;
    }

    private static native boolean nativeAddRichUIOption(long j4, long j5);

    private static native boolean nativeBuildRichViewByString(String str);

    private static native boolean nativeBuildRichViewByTemplete(String str);

    private static native long nativeCreate();

    private static native boolean nativeDelRichUIOption(long j4, long j5);

    private static native boolean nativeSetAnimation(long j4, long j5);

    private static native boolean nativeSetCollisionBehavior(long j4, int i4);

    private static native boolean nativeSetCollisionBorder(long j4, int i4, int i5, int i6, int i7);

    private static native boolean nativeSetCollisionLineTagId(long j4, int i4);

    private static native boolean nativeSetCollisionPriority(long j4, int i4);

    private static native boolean nativeSetCollisionPriority(long j4, short s4);

    private static native boolean nativeSetDrawFullscreenMaskFlag(long j4, boolean z4);

    private static native boolean nativeSetLocated(long j4, int i4);

    private static native boolean nativeSetOffsetX(long j4, int i4, int i5);

    private static native boolean nativeSetOffsetY(long j4, int i4, int i5);

    private static native boolean nativeSetOpacity(long j4, float f4);

    private static native boolean nativeSetScale(long j4, float f4);

    private static native boolean nativeSetScaleX(long j4, float f4);

    private static native boolean nativeSetScaleY(long j4, float f4);

    private static native boolean nativeSetShowLevel(long j4, int i4, int i5);

    private static native boolean nativeSetView(long j4, long j5);

    private static native boolean nativeSetVisibility(long j4, int i4);

    public boolean a(BmBaseUI bmBaseUI) {
        this.f8735h = bmBaseUI;
        return nativeSetView(this.nativeInstance, (bmBaseUI != null ? Long.valueOf(bmBaseUI.getNativeInstance()) : null).longValue());
    }

    public boolean b(int i4) {
        this.f8729b = i4;
        return nativeSetLocated(this.nativeInstance, i4);
    }

    public boolean c(int i4) {
        this.f8728a = i4;
        return nativeSetVisibility(this.nativeInstance, i4);
    }

    public BmBaseUI a(long j4) {
        BmBaseUI bmBaseUI = this.f8735h;
        if (bmBaseUI != null) {
            return bmBaseUI.a(j4);
        }
        return null;
    }

    public boolean b(float f4) {
        this.f8732e = f4;
        return nativeSetScaleX(this.nativeInstance, f4);
    }

    public boolean c(float f4) {
        this.f8733f = f4;
        return nativeSetScaleY(this.nativeInstance, f4);
    }

    public boolean a(int i4, int i5) {
        return nativeSetShowLevel(this.nativeInstance, i4, i5);
    }

    public boolean a(int i4) {
        return nativeSetCollisionBehavior(this.nativeInstance, i4);
    }

    public boolean a(short s4) {
        return nativeSetCollisionPriority(this.nativeInstance, (int) s4);
    }

    public boolean a(BmAnimation bmAnimation) {
        this.f8730c = bmAnimation;
        return nativeSetAnimation(this.nativeInstance, bmAnimation == null ? 0L : bmAnimation.getNativeInstance());
    }

    public boolean a(float f4) {
        this.f8732e = f4;
        this.f8733f = f4;
        return nativeSetScale(this.nativeInstance, f4);
    }
}
