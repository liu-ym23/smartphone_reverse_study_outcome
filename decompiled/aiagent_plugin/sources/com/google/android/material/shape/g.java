package com.google.android.material.shape;

import android.view.View;
import android.widget.ScrollView;

/* JADX INFO: compiled from: InterpolateOnScrollPositionChangeHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f13540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MaterialShapeDrawable f13541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ScrollView f13542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int[] f13543d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int[] f13544e;

    public void a() {
        ScrollView r0 = this.f13542c;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.getChildCount() == 0) goto L18;
        this.f13542c.getLocationInWindow(this.f13543d);
        this.f13542c.getChildAt(0).getLocationInWindow(this.f13544e);
        int r1 = (this.f13540a.getTop() - this.f13543d[1]) + this.f13544e[1];
        int r2 = this.f13540a.getHeight();
        int r3 = this.f13542c.getHeight();
        if (r1 >= 0) goto L10;
        this.f13541b.setInterpolation(Math.max(0.0f, Math.min(1.0f, (r1 / r2) + 1.0f)));
        this.f13540a.invalidate();
        return;
    L10:
        int r4 = r1 + r2;
        if (r4 <= r3) goto L14;
        this.f13541b.setInterpolation(Math.max(0.0f, Math.min(1.0f, 1.0f - ((r4 - r3) / r2))));
        this.f13540a.invalidate();
        return;
    L14:
        if (this.f13541b.getInterpolation() == 1.0f) goto L21;
        this.f13541b.setInterpolation(1.0f);
        this.f13540a.invalidate();
        return;
    L21:
        return;
    L18:
        throw new IllegalStateException("Scroll bar must contain a child to calculate interpolation.");
    }
}
