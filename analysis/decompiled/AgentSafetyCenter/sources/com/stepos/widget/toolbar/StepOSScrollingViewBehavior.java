package com.stepos.widget.toolbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import b3.a;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class StepOSScrollingViewBehavior extends a {
    public StepOSScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        context.getClass();
        attributeSet.getClass();
    }

    @Override // b3.a
    public final boolean layoutDependsOn(androidx.coordinatorlayout.widget.a aVar, View view, View view2) {
        return false;
    }

    @Override // b3.a
    public final boolean onDependentViewChanged(androidx.coordinatorlayout.widget.a aVar, View view, View view2) {
        aVar.getClass();
        view2.getClass();
        return false;
    }

    @Override // b3.a
    public final boolean onLayoutChild(androidx.coordinatorlayout.widget.a aVar, View view, int i) {
        int childCount = aVar.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            aVar.getChildAt(i3);
        }
        return false;
    }

    public StepOSScrollingViewBehavior() {
    }
}
