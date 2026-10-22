package com.bytedance.android.ecom.arch.slice.render.util.touch_delegate;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes44.dex */
public final class SlcHackTouchDelegate extends TouchDelegate {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f50764f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f50765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f50766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f50767c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f50768d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f50769e;

    static {
        f50764f = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SlcHackTouchDelegate.class), "mSlop", "getMSlop()I"))};
    }

    public final int a() {
        Lazy r100 = this.f50767c;
        KProperty r101 = f50764f[0];
        return ((Number) r100.getValue()).intValue();
    }

    @Override // android.view.TouchDelegate
    public final boolean onTouchEvent(MotionEvent r100) {
        boolean r101 = false;
        if (this.f50769e.isShown() == true) goto L5;
    L32:
        return false;
    L5:
        if (this.f50769e.isAttachedToWindow() == false) goto L32;
        int r102 = (int) r100.getX();
        int r103 = (int) r100.getY();
        final Ref.BooleanRef r104 = new Ref.BooleanRef();
        r104.element = false;
        int r105 = r100.getAction();
        boolean r106 = true;
        if (r105 == 0) goto L22;
        if (r105 == 1) goto L15;
        if (r105 == 2) goto L15;
        if (r105 != 3) goto L25;
        boolean r107 = this.f50766b;
        this.f50766b = false;
        r101 = r107;
    L25:
        if (r101 == false) goto L30;
        if (r106 == false) goto L28;
        float r108 = 2;
        r100.setLocation(this.f50769e.getWidth() / r108, this.f50769e.getHeight() / r108);
    L29:
        r104.element = this.f50769e.dispatchTouchEvent(r100);
        goto L30
    L28:
        float r109 = -(a() * 2);
        r100.setLocation(r109, r109);
    L30:
        int r110 = com.bytedance.android.ecom.arch.slice.utils.a.f51057a;
        com.bytedance.android.ecom.arch.slice.utils.a.a(new AnonymousClass1(this, r104));
        return r104.element;
    L15:
        boolean r111 = this.f50766b;
        if (r111 == true) goto L18;
    L20:
        r101 = r111;
        goto L25
    L18:
        if (this.f50765a.contains(r102, r103) == true) goto L20;
        r101 = r111;
        r106 = false;
        goto L25
    L22:
        if (this.f50768d.contains(r102, r103) == false) goto L24;
        this.f50766b = true;
        r101 = true;
        goto L25
    L24:
        this.f50766b = false;
        goto L25
    }

    public SlcHackTouchDelegate(Rect r100, View r101) {
        super(r100, r101);
        this.f50768d = r100;
        this.f50769e = r101;
        Rect r102 = new Rect(r100);
        this.f50765a = r102;
        this.f50767c = LazyKt.lazy(LazyThreadSafetyMode.NONE, new SlcHackTouchDelegate$mSlop$2(this));
        r102.inset(-a(), -a());
    }
}
