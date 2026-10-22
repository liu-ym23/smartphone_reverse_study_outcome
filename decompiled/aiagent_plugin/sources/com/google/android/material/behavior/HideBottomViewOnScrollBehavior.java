package com.google.android.material.behavior;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.animation.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.b<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f13205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f13206b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f13207c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ViewPropertyAnimator f13208d;

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout r1, V r2, View r3, View r4, int r5, int r6) {
        if (r5 != 2) goto L5;
        return true;
    L5:
        return false;
    }

    static /* synthetic */ ViewPropertyAnimator a(HideBottomViewOnScrollBehavior r0, ViewPropertyAnimator r1) {
        r0.f13208d = r1;
        return r1;
    }

    public HideBottomViewOnScrollBehavior() {
        this.f13205a = 0;
        this.f13206b = 2;
        this.f13207c = 0;
    }

    public HideBottomViewOnScrollBehavior(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"));
        this.f13205a = 0;
        this.f13206b = 2;
        this.f13207c = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout r4, V r5, int r6) {
        ViewGroup.MarginLayoutParams r0 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r5.getLayoutParams(), ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        this.f13205a = r5.getMeasuredHeight() + r0.bottomMargin;
        return super.a(r4, r5, r6);
    }

    public void a(V r3, int r4) {
        this.f13207c = r4;
        if (this.f13206b != 1) goto L6;
        r3.setTranslationY(this.f13205a + r4);
        return;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public void a(CoordinatorLayout r1, V r2, View r3, int r4, int r5, int r6, int r7, int r8, int[] r9) {
        if (r5 <= 0) goto L4;
        b(r2);
        return;
    L4:
        if (r5 >= 0) goto L8;
        a(r2);
        return;
    }

    public boolean b() {
        if (this.f13206b != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public void a(V r2) {
        a(r2, true);
    }

    public void a(V r8, boolean r9) {
        if (b() == false) goto L5;
        return;
    L5:
        ViewPropertyAnimator r0 = this.f13208d;
        if (r0 == null) goto L8;
        r0.cancel();
        r8.clearAnimation();
    L8:
        this.f13206b = 2;
        if (r9 == false) goto L11;
        a(r8, 0, 225, a.f13145d);
        return;
    L11:
        r8.setTranslationY(0);
    }

    public boolean c() {
        if (this.f13206b == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public void b(V r2) {
        b(r2, true);
    }

    public void b(V r9, boolean r10) {
        if (c() == false) goto L5;
        return;
    L5:
        ViewPropertyAnimator r0 = this.f13208d;
        if (r0 == null) goto L8;
        r0.cancel();
        r9.clearAnimation();
    L8:
        this.f13206b = 1;
        int r4 = this.f13205a + this.f13207c;
        if (r10 == false) goto L11;
        a(r9, r4, 175, a.f13144c);
        return;
    L11:
        r9.setTranslationY(r4);
    }

    private void a(V r3, int r4, long r5, TimeInterpolator r7) {
        this.f13208d = r3.animate().translationY(r4).setInterpolator((TimeInterpolator) ZeusTransformUtils.wrapperContextForParams(r7, TimeInterpolator.class, "com.obric.aiagent.plugin")).setDuration(r5).setListener(new AnonymousClass1(this));
    }
}
