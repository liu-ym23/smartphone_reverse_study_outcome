package com.bytedance.android.shopping.anchorv4.voavhs.detailimages;

import android.graphics.PointF;
import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class o extends k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PointF f168331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PointF f168332d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PointF f168333e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p f168334f;

    public o(LargeImageView.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f168334f = r100;
        this.f168333e = new PointF();
    }

    public static PointF a(MotionEvent r100) {
        int r101 = r100.getPointerCount();
        float r102 = 0.0f;
        float r103 = 0.0f;
        int r104 = 0;
    L3:
        if (r104 >= r101) goto L5;
        r102 = r102 + r100.getX(r104);
        r103 = r103 + r100.getY(r104);
        r104 = r104 + 1;
        goto L3
    L5:
        float r105 = r101;
        return new PointF(r102 / r105, r103 / r105);
    }

    public final void b(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        MotionEvent r101 = this.f168330b;
        if (r101 == null) goto L33;
        this.f168332d = a(r101);
        this.f168331c = a(r100);
        if (r101.getPointerCount() == r100.getPointerCount()) goto L7;
        boolean r102 = true;
    L8:
        PointF r103 = this.f168333e;
        float r104 = 0.0f;
        if (r102 == false) goto L11;
        float r105 = 0.0f;
    L20:
        r103.x = r105;
        if (r102 == true) goto L31;
        PointF r106 = this.f168331c;
        if (r106 == null) goto L26;
        float r107 = r106.y;
    L27:
        PointF r108 = this.f168332d;
        if (r108 == null) goto L30;
        r104 = r108.y;
    L30:
        r104 = r107 - r104;
        goto L31
    L26:
        r107 = 0.0f;
    L31:
        r103.y = r104;
        return;
    L11:
        PointF r109 = this.f168331c;
        if (r109 == null) goto L14;
        float r110 = r109.x;
    L15:
        PointF r111 = this.f168332d;
        if (r111 == null) goto L18;
        float r112 = r111.x;
    L19:
        r105 = r110 - r112;
        goto L20
    L18:
        r112 = 0.0f;
        goto L19
    L14:
        r110 = 0.0f;
        goto L15
    L7:
        r102 = false;
        goto L8
    }
}
