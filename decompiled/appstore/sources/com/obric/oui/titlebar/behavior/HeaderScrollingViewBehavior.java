package com.obric.oui.titlebar.behavior;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.c;
import com.google.android.material.badge.BadgeDrawable;
import com.google.common.primitives.Ints;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f17523d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f17524e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f17525f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f17526g;

    public HeaderScrollingViewBehavior() {
        this.f17523d = new Rect();
        this.f17524e = new Rect();
        this.f17525f = 0;
    }

    public static int resolveGravity(int r10) {
        if (r10 != 0) goto L5;
        return BadgeDrawable.TOP_START;
    L5:
        return r10;
    }

    public abstract View findFirstDependency(List r10);

    public final int getOverlapPixelsForOffset(View r10) {
        if (this.f17526g == 0) goto L7;
        float r11 = getOverlapRatioForOffset(r10);
        int r12 = this.f17526g;
        return p.a.b((int) (r11 * r12), 0, r12);
    L7:
        return 0;
    }

    public float getOverlapRatioForOffset(View r10) {
        return 1.0f;
    }

    public final int getOverlayTop() {
        return this.f17526g;
    }

    public int getScrollRange(View r10) {
        return r10.getMeasuredHeight();
    }

    public final int getVerticalLayoutGap() {
        return this.f17525f;
    }

    @Override // com.obric.oui.titlebar.behavior.ViewOffsetBehavior
    public void layoutChild(CoordinatorLayout r10, View r11, int r12) {
        View r13 = findFirstDependency(r10.getDependencies(r11));
        if (r13 == null) goto L12;
        CoordinatorLayout.c r14 = (CoordinatorLayout.c) r11.getLayoutParams();
        Rect r15 = this.f17523d;
        r15.set(r10.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r14).leftMargin, r13.getBottom() + ((ViewGroup.MarginLayoutParams) r14).topMargin, (r10.getWidth() - r10.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) r14).rightMargin, ((r10.getHeight() + r13.getBottom()) - r10.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) r14).bottomMargin);
        WindowInsetsCompat r16 = r10.getLastWindowInsets();
        if (r16 != null) goto L7;
    L11:
        Rect r17 = this.f17524e;
        c.a(resolveGravity(r14.f2409c), r11.getMeasuredWidth(), r11.getMeasuredHeight(), r15, r17, r12);
        int r18 = getOverlapPixelsForOffset(r13);
        r11.layout(r17.left, r17.top - r18, r17.right, r17.bottom - r18);
        this.f17525f = r17.top - r13.getBottom();
        return;
    L7:
        if (ViewCompat.x(r10) == false) goto L11;
        if (ViewCompat.x(r11) == true) goto L11;
        r15.left += r16.k();
        r15.right -= r16.l();
        goto L11
    L12:
        super.layoutChild(r10, r11, r12);
        this.f17525f = 0;
    }

    @Override // com.obric.oui.titlebar.behavior.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout r10, View r11, int r12) {
        return super.onLayoutChild(r10, r11, r12);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onMeasureChild(CoordinatorLayout r10, View r11, int r12, int r13, int r14, int r15) {
        int r16 = r11.getLayoutParams().height;
        if (r16 != (-1)) goto L5;
    L6:
        View r17 = findFirstDependency(r10.getDependencies(r11));
        if (r17 == null) goto L27;
        int r18 = View.MeasureSpec.getSize(r14);
        if (r18 > 0) goto L11;
        r18 = r10.getHeight();
    L16:
        int r19 = r18 + getScrollRange(r17);
        int r20 = r17.getMeasuredHeight();
        if (shouldHeaderOverlapScrollingChild() == false) goto L19;
        r11.setTranslationY(-r20);
    L20:
        if (r16 != (-1)) goto L22;
        int r21 = Ints.MAX_POWER_OF_TWO;
    L23:
        r10.onMeasureChild(r11, r12, r13, View.MeasureSpec.makeMeasureSpec(r19, r21), r15);
        return true;
    L22:
        r21 = Integer.MIN_VALUE;
        goto L23
    L19:
        r11.setTranslationY(0.0f);
        r19 = r19 - r20;
        goto L20
    L11:
        if (ViewCompat.x(r17) == false) goto L16;
        WindowInsetsCompat r22 = r10.getLastWindowInsets();
        if (r22 == null) goto L16;
        r18 = r18 + (r22.m() + r22.j());
        goto L16
    L27:
        return false;
    L5:
        if (r16 == (-2)) goto L6;
        return false;
    }

    public final void setOverlayTop(int r10) {
        this.f17526g = r10;
    }

    public boolean shouldHeaderOverlapScrollingChild() {
        return false;
    }

    public HeaderScrollingViewBehavior(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.f17523d = new Rect();
        this.f17524e = new Rect();
        this.f17525f = 0;
    }
}
