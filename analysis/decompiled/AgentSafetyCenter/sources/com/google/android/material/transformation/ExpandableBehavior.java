package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import b3.a;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@Deprecated
/* loaded from: classes.dex */
public abstract class ExpandableBehavior extends a {
    public ExpandableBehavior() {
    }

    @Override // b3.a
    public abstract boolean layoutDependsOn(androidx.coordinatorlayout.widget.a aVar, View view, View view2);

    @Override // b3.a
    public final boolean onDependentViewChanged(androidx.coordinatorlayout.widget.a aVar, View view, View view2) {
        view2.getClass();
        throw new ClassCastException();
    }

    @Override // b3.a
    public final boolean onLayoutChild(androidx.coordinatorlayout.widget.a aVar, View view, int i) {
        if (!view.isLaidOut()) {
            List listV = aVar.v(view);
            int size = listV.size();
            for (int i3 = 0; i3 < size; i3++) {
                layoutDependsOn(aVar, view, (View) listV.get(i3));
            }
        }
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
    }
}
