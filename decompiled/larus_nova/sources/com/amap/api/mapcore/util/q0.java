package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes28.dex */
public abstract class q0 extends r0 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final float f27868l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f27869m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f27870n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f27871o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f27872p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f27873q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f27874r;

    public q0(Context r100) {
        super(r100);
        this.f27871o = 0.0f;
        this.f27872p = 0.0f;
        this.f27873q = 0.0f;
        this.f27874r = 0.0f;
        this.f27868l = ViewConfiguration.get(r100).getScaledEdgeSlop();
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_amap_api_mapcore_util_q0_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public PointF a(int r100) {
        if (r100 != 0) goto L6;
        return new PointF(this.f27871o, this.f27872p);
    L6:
        return new PointF(this.f27873q, this.f27874r);
    }

    @Override // com.amap.api.mapcore.util.r0
    public void b(MotionEvent r100) {
        super.b(r100);
        MotionEvent r101 = this.f27913c;
        int r102 = r101.getPointerCount();
        int r103 = r100.getPointerCount();
        if (r103 != 2) goto L8;
        if (r103 != r102) goto L9;
        float r104 = r101.getX(0);
        float r105 = r101.getY(0);
        float r106 = r101.getX(1);
        float r107 = r101.getY(1);
        float r108 = r100.getX(0);
        float r109 = r100.getY(0);
        float r110 = r100.getX(1);
        float r111 = r100.getY(1);
        this.f27871o = r108 - r104;
        this.f27872p = r109 - r105;
        this.f27873q = r110 - r106;
        this.f27874r = r111 - r107;
        return;
    L9:
        return;
    }

    public boolean c(MotionEvent r110) {
        int r100 = this.f27918h;
        if (r100 == 0) goto L8;
        int r101 = this.f27919i;
        if (r101 == 0) goto L8;
        float r102 = this.f27868l;
        this.f27869m = r100 - r102;
        this.f27870n = r101 - r102;
    L9:
        float r103 = this.f27868l;
        float r104 = this.f27869m;
        float r105 = this.f27870n;
        if (this.f27918h > 0) goto L12;
    L14:
        float r106 = s0.a(r110, 0);
        float r107 = s0.b(r110, 0);
        float r108 = s0.a(r110, 1);
        float r111 = s0.b(r110, 1);
    L16:
        if (r106 >= r103) goto L18;
    L25:
        boolean r109 = true;
    L27:
        if (r108 >= r103) goto L29;
    L36:
        boolean r112 = true;
    L37:
        if (r109 == false) goto L40;
        if (r112 == false) goto L40;
        return true;
    L40:
        if (r109 == false) goto L42;
        return true;
    L42:
        if (r112 == false) goto L44;
        return true;
    L44:
        return false;
    L29:
        if (r111 < r103) goto L36;
        if (r108 > r104) goto L36;
        if (r111 > r105) goto L36;
        r112 = false;
        goto L37
    L18:
        if (r107 < r103) goto L25;
        if (r106 > r104) goto L25;
        if (r107 > r105) goto L25;
        r109 = false;
        goto L27
    L12:
        if (this.f27919i <= 0) goto L14;
        r106 = s0.a(r110, 0, this.f27920j);
        r107 = s0.b(r110, 0, this.f27921k);
        r108 = s0.a(r110, 1, this.f27920j);
        r111 = s0.b(r110, 1, this.f27921k);
    L8:
        DisplayMetrics r113 = INVOKEVIRTUAL_com_amap_api_mapcore_util_q0_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(this.f27911a.getResources());
        float r114 = r113.widthPixels;
        float r115 = this.f27868l;
        this.f27869m = r114 - r115;
        this.f27870n = r113.heightPixels - r115;
        goto L9
    }
}
