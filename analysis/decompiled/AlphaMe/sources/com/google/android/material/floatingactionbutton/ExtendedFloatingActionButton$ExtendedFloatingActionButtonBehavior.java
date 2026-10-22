package com.google.android.material.floatingactionbutton;

import A.b;
import A.d;
import B0.g;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.room.AbstractC0351g;
import m1.AbstractC0769a;

/* loaded from: classes.dex */
public class ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior<T> extends b {
    public ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior() {
    }

    @Override // A.b
    public final boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
        g.y(view);
        return super.getInsetDodgeRect(coordinatorLayout, null, rect);
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

    public ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0769a.f13544j);
        typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.getBoolean(1, true);
        typedArrayObtainStyledAttributes.recycle();
    }
}
