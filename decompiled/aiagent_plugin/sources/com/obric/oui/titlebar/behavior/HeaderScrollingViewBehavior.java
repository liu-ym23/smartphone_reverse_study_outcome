package com.obric.oui.titlebar.behavior;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.al;
import androidx.core.view.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class HeaderScrollingViewBehavior extends a<View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Rect f36684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Rect f36685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f36686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f36687d;

    private static int c(int r0) {
        if (r0 != 0) goto L5;
        return 8388659;
    L5:
        return r0;
    }

    float a(View r1) {
        return 1.0f;
    }

    abstract View a(List<View> r1);

    public boolean b() {
        return false;
    }

    @Override // com.obric.oui.titlebar.behavior.a
    public /* bridge */ /* synthetic */ boolean a(int r1) {
        return super.a(r1);
    }

    @Override // com.obric.oui.titlebar.behavior.a, androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout r1, View r2, int r3) {
        return super.a(r1, r2, r3);
    }

    @Override // com.obric.oui.titlebar.behavior.a
    public /* bridge */ /* synthetic */ int d() {
        return super.d();
    }

    public HeaderScrollingViewBehavior() {
        this.f36684a = new Rect();
        this.f36685b = new Rect();
        this.f36686c = 0;
    }

    public HeaderScrollingViewBehavior(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"));
        this.f36684a = new Rect();
        this.f36685b = new Rect();
        this.f36686c = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout r7, View r8, int r9, int r10, int r11, int r12) {
        int r0 = r8.getLayoutParams().height;
        if (r0 != (-1)) goto L5;
    L6:
        View r2 = a(r7.getDependencies(r8));
        if (r2 == null) goto L27;
        int r13 = View.MeasureSpec.getSize(r11);
        if (r13 > 0) goto L11;
        r13 = r7.getHeight();
    L16:
        int r14 = r13 + c(r2);
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
        r8.setTranslationY(0.0f);
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

    @Override // com.obric.oui.titlebar.behavior.a
    public void b(CoordinatorLayout r9, View r10, int r11) {
        View r0 = a(r9.getDependencies(r10));
        if (r0 == null) goto L12;
        CoordinatorLayout.LayoutParams r1 = (CoordinatorLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r10.getLayoutParams(), CoordinatorLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        Rect r5 = this.f36684a;
        r5.set(r9.getPaddingLeft() + r1.leftMargin, r0.getBottom() + r1.topMargin, (r9.getWidth() - r9.getPaddingRight()) - r1.rightMargin, ((r9.getHeight() + r0.getBottom()) - r9.getPaddingBottom()) - r1.bottomMargin);
        al r2 = r9.getLastWindowInsets();
        if (r2 != null) goto L7;
    L11:
        Rect r12 = this.f36685b;
        d.a(c(r1.gravity), r10.getMeasuredWidth(), r10.getMeasuredHeight(), r5, r12, r11);
        int r13 = b(r0);
        r10.layout(r12.left, r12.top - r13, r12.right, r12.bottom - r13);
        this.f36686c = r12.top - r0.getBottom();
        return;
    L7:
        if (ViewCompat.v(r9) == false) goto L11;
        if (ViewCompat.v(r10) == true) goto L11;
        r5.left += r2.a();
        r5.right -= r2.c();
        goto L11
    L12:
        super.b(r9, r10, r11);
        this.f36686c = 0;
    }

    final int b(View r3) {
        if (this.f36687d == 0) goto L7;
        float r4 = a(r3);
        int r2 = this.f36687d;
        return androidx.core.a.a.a((int) (r4 * r2), 0, r2);
    L7:
        return 0;
    }

    int c(View r1) {
        return r1.getMeasuredHeight();
    }

    final int c() {
        return this.f36686c;
    }

    public final void b(int r1) {
        this.f36687d = r1;
    }

    public final int e() {
        return this.f36687d;
    }
}
