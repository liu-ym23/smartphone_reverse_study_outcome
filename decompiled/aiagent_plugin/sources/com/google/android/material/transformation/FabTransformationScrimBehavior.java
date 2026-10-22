package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.animation.b;
import com.google.android.material.animation.d;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f13696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f13697b;

    public FabTransformationScrimBehavior() {
        this.f13696a = new d(75, 150);
        this.f13697b = new d(0, 150);
    }

    public FabTransformationScrimBehavior(Context r5, AttributeSet r6) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin"));
        this.f13696a = new d(75, 150);
        this.f13697b = new d(0, 150);
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout r1, View r2, View r3) {
        return ZeusTransformUtils.instanceOf(r3, FloatingActionButton.class);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean b(CoordinatorLayout r1, View r2, MotionEvent r3) {
        return super.b(r1, r2, r3);
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    public AnimatorSet b(View r7, final View r8, final boolean r9, boolean r10) {
        ArrayList r11 = new ArrayList();
        a(r8, r9, r10, r11, new ArrayList());
        AnimatorSet r12 = new AnimatorSet();
        b.a(r12, r11);
        r12.addListener(new AnonymousClass1(this, r9, r8));
        return r12;
    }

    private void a(View r3, boolean r4, boolean r5, List<Animator> r6, List<Animator.AnimatorListener> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        if (r4 == false) goto L5;
        d r2 = this.f13696a;
    L7:
        if (r4 == false) goto L11;
        if (r5 == true) goto L10;
        r3.setAlpha(0.0f);
    L10:
        ObjectAnimator r10 = ObjectAnimator.ofFloat(r3, View.ALPHA, new float[]{1.0f});
    L12:
        r2.a(r10);
        r8.add(r10);
        return;
    L11:
        r10 = ObjectAnimator.ofFloat(r3, View.ALPHA, new float[]{0.0f});
        goto L12
    L5:
        r2 = this.f13697b;
        goto L7
    }
}
