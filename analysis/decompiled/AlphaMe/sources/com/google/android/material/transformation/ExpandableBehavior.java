package com.google.android.material.transformation;

import A.b;
import B0.g;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.ArrayList;

@Deprecated
/* loaded from: classes.dex */
public abstract class ExpandableBehavior extends b {
    public ExpandableBehavior() {
    }

    @Override // A.b
    public abstract boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2);

    @Override // A.b
    public final boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        g.y(view2);
        throw null;
    }

    @Override // A.b
    public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i4) {
        if (!view.isLaidOut()) {
            ArrayList arrayListV = coordinatorLayout.v(view);
            int size = arrayListV.size();
            for (int i5 = 0; i5 < size; i5++) {
                layoutDependsOn(coordinatorLayout, view, (View) arrayListV.get(i5));
            }
        }
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
    }
}
