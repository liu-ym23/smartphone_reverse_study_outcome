package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.button;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class f implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PointF f116523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PointF f116524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PointF f116525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PointF f116526d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PointF f116527e;

    public static final class a {
    }

    static {
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r110) {
        float r100 = r110;
        int r101 = 1;
    L4:
        if (r101 > 13) goto L9;
        PointF r102 = this.f116527e;
        float r103 = 3;
        PointF r104 = this.f116523a;
        float r105 = r104.x * r103;
        r102.x = r105;
        PointF r106 = this.f116526d;
        float r107 = ((this.f116524b.x - r104.x) * r103) - r105;
        r106.x = r107;
        PointF r108 = this.f116525c;
        float r109 = (1 - r102.x) - r107;
        r108.x = r109;
        float r111 = ((r102.x + ((r106.x + (r109 * r100)) * r100)) * r100) - r110;
        if (Math.abs(r111) < 0.001d) goto L9;
        r100 = r100 - (r111 / (this.f116527e.x + (((2 * this.f116526d.x) + ((r103 * this.f116525c.x) * r100)) * r100)));
        r101 = r101 + 1;
    L9:
        PointF r112 = this.f116527e;
        float r113 = 3;
        PointF r114 = this.f116523a;
        float r115 = r114.y * r113;
        r112.y = r115;
        PointF r116 = this.f116526d;
        float r117 = (r113 * (this.f116524b.y - r114.y)) - r115;
        r116.y = r117;
        PointF r118 = this.f116525c;
        float r119 = (1 - r112.y) - r117;
        r118.y = r119;
        return r100 * (r112.y + ((r116.y + (r119 * r100)) * r100));
    }

    public f(float r100, float r101, float r102, float r103) {
        PointF r104 = new PointF(r100, r101);
        PointF r105 = new PointF(r102, r103);
        Intrinsics.checkNotNullParameter(r104, "start");
        Intrinsics.checkNotNullParameter(r105, "end");
        this.f116525c = new PointF();
        this.f116526d = new PointF();
        this.f116527e = new PointF();
        float r106 = r104.x;
        boolean r107 = false;
        float r108 = 0;
        if (r106 >= r108) goto L5;
    L7:
        boolean r109 = false;
    L8:
        if (r109 == false) goto L20;
        float r110 = r105.x;
        if (r110 >= r108) goto L12;
    L14:
        if (r107 == false) goto L18;
        this.f116523a = r104;
        this.f116524b = r105;
        return;
    L18:
        throw new IllegalArgumentException("endX value must be in the range [0, 1]".toString());
    L12:
        if (r110 > 1) goto L14;
        r107 = true;
        goto L14
    L20:
        throw new IllegalArgumentException("startX value must be in the range [0, 1]".toString());
    L5:
        if (r106 > 1) goto L7;
        r109 = true;
        goto L8
    }
}
