package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.al;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: HeaderScrollingViewBehavior.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class b extends c<View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Rect f13183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Rect f13184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f13185c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f13186d;

    private static int c(int r0) {
        if (r0 != 0) goto L5;
        return 8388659;
    L5:
        return r0;
    }

    float a(View r1) {
        return 1.0f;
    }

    abstract View b(List<View> r1);

    public boolean b() {
        return false;
    }

    public b() {
        this.f13183a = new Rect();
        this.f13184b = new Rect();
        this.f13185c = 0;
    }

    public b(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"));
        this.f13183a = new Rect();
        this.f13184b = new Rect();
        this.f13185c = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout r7, View r8, int r9, int r10, int r11, int r12) {
        int r0 = r8.getLayoutParams().height;
        if (r0 != (-1)) goto L5;
    L6:
        View r2 = b(r7.getDependencies(r8));
        if (r2 == null) goto L27;
        int r13 = View.MeasureSpec.getSize(r11);
        if (r13 > 0) goto L11;
        r13 = r7.getHeight();
    L16:
        int r14 = r13 + b(r2);
        int r3 = r2.getMeasuredHeight();
        if (b() == false) goto L19;
        r8.setTranslationY(-r3);
    L20:
        if (r0 != (-1)) goto L22;
        int r6 = 1073741824;
    L23:
        r7.onMeasureChild(r8, r9, r10, View.MeasureSpec.makeMeasureSpec(r14, r6), r12);
        return true;
    L22:
        r6 = Integer.MIN_VALUE;
        goto L23
    L19:
        r14 = r14 - r3;
        goto L20
    L11:
        if (ViewCompat.v(r2) == false) goto L16;
        al r4 = r7.getLastWindowInsets();
        if (r4 == null) goto L16;
        r13 = r13 + (r4.b() + r4.d());
        goto L16
    L27:
        return false;
    L5:
        if (r0 == (-2)) goto L6;
        return false;
    }

    @Override // com.google.android.material.appbar.c
    public void b(CoordinatorLayout r9, View r10, int r11) {
        View r0 = b(r9.getDependencies(r10));
        if (r0 == null) goto L12;
        CoordinatorLayout.LayoutParams r1 = (CoordinatorLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r10.getLayoutParams(), CoordinatorLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        Rect r5 = this.f13183a;
        r5.set(r9.getPaddingLeft() + r1.leftMargin, r0.getBottom() + r1.topMargin, (r9.getWidth() - r9.getPaddingRight()) - r1.rightMargin, ((r9.getHeight() + r0.getBottom()) - r9.getPaddingBottom()) - r1.bottomMargin);
        al r2 = r9.getLastWindowInsets();
        if (r2 != null) goto L7;
    L11:
        Rect r12 = this.f13184b;
        androidx.core.view.d.a(c(r1.gravity), r10.getMeasuredWidth(), r10.getMeasuredHeight(), r5, r12, r11);
        int r13 = c(r0);
        r10.layout(r12.left, r12.top - r13, r12.right, r12.bottom - r13);
        this.f13185c = r12.top - r0.getBottom();
        return;
    L7:
        if (ViewCompat.v(r9) == false) goto L11;
        if (ViewCompat.v(r10) == true) goto L11;
        r5.left += r2.a();
        r5.right -= r2.c();
        goto L11
    L12:
        super.b(r9, r10, r11);
        this.f13185c = 0;
    }

    final int c(View r3) {
        if (this.f13186d == 0) goto L7;
        float r4 = a(r3);
        int r2 = this.f13186d;
        return androidx.core.a.a.a((int) (r4 * r2), 0, r2);
    L7:
        return 0;
    }

    int b(View r1) {
        return r1.getMeasuredHeight();
    }

    final int d() {
        return this.f13185c;
    }

    public final void b(int r1) {
        this.f13186d = r1;
    }

    public final int e() {
        return this.f13186d;
    }
}
