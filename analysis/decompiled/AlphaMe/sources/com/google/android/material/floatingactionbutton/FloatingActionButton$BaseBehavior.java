package com.google.android.material.floatingactionbutton;

import A.b;
import A.d;
import B0.g;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.room.AbstractC0351g;
import m1.AbstractC0769a;

/* loaded from: classes.dex */
public class FloatingActionButton$BaseBehavior<T> extends b {
    public FloatingActionButton$BaseBehavior() {
    }

    @Override // A.b
    public final boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
        g.y(view);
        throw null;
    }

    @Override // A.b
    public final void onAttachedToLayoutParams(d dVar) {
        if (dVar.f12h == 0) {
            dVar.f12h = 80;
        }
    }

    @Override // A.b
    public final boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        AbstractC0351g.A(view);
        throw null;
    }

    @Override // A.b
    public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i4) {
        AbstractC0351g.A(view);
        throw null;
    }

    public FloatingActionButton$BaseBehavior(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0769a.f13545k);
        typedArrayObtainStyledAttributes.getBoolean(0, true);
        typedArrayObtainStyledAttributes.recycle();
    }
}
