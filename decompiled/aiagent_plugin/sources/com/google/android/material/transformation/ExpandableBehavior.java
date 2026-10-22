package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.d.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public abstract class ExpandableBehavior extends CoordinatorLayout.b<View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f13687a;

    public abstract boolean a(View r1, View r2, boolean r3, boolean r4);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public abstract boolean a(CoordinatorLayout r1, View r2, View r3);

    static /* synthetic */ int a(ExpandableBehavior r0) {
        return r0.f13687a;
    }

    public ExpandableBehavior() {
        this.f13687a = 0;
    }

    public ExpandableBehavior(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"));
        this.f13687a = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout r3, final View r4, int r5) {
        if (ViewCompat.F(r4) == true) goto L15;
        final b r6 = e(r3, r4);
        if (r6 != null) goto L7;
        return false;
    L7:
        if (a(r6.isExpanded()) == true) goto L9;
        return false;
    L9:
        if (r6.isExpanded() == false) goto L11;
        final int r7 = 1;
    L12:
        this.f13687a = r7;
        r4.getViewTreeObserver().addOnPreDrawListener(new AnonymousClass1(this, r4, r7, r6));
        return false;
    L11:
        r7 = 2;
        goto L12
    L15:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public boolean b(CoordinatorLayout r3, View r4, View r5) {
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (a(r6.isExpanded()) == true) goto L5;
        return false;
    L5:
        if (r6.isExpanded() == false) goto L7;
        int r7 = 1;
    L8:
        this.f13687a = r7;
        return a((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.aiagent.plugin"), r4, r6.isExpanded(), true);
    L7:
        r7 = 2;
        goto L8
    }

    public b e(CoordinatorLayout r7, View r8) {
        List<View> r0 = r7.getDependencies(r8);
        int r1 = r0.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        View r3 = (View) ZeusTransformUtils.preCheckCast(r0.get(r2), View.class, "com.obric.aiagent.plugin");
        if (a(r7, r8, r3) == true) goto L7;
        r2 = r2 + 1;
        goto L3
    L7:
        return (b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin");
    L9:
        return null;
    }

    private boolean a(boolean r3) {
        if (r3 == false) goto L11;
        int r2 = this.f13687a;
        if (r2 == 0) goto L9;
        if (r2 == 2) goto L9;
        return false;
    L9:
        return true;
    L11:
        if (this.f13687a == 1) goto L13;
        return false;
    L13:
        return true;
    }
}
