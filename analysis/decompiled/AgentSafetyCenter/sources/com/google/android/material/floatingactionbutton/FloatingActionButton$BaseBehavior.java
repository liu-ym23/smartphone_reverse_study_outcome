package com.google.android.material.floatingactionbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import b3.a;
import b3.d;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class FloatingActionButton$BaseBehavior<T> extends a {
    public FloatingActionButton$BaseBehavior(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p6.a.f9816h);
        typedArrayObtainStyledAttributes.getBoolean(0, true);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // b3.a
    public final boolean getInsetDodgeRect(androidx.coordinatorlayout.widget.a aVar, View view, Rect rect) {
        view.getClass();
        throw new ClassCastException();
    }

    @Override // b3.a
    public final void onAttachedToLayoutParams(d dVar) {
        if (dVar.f1884h == 0) {
            dVar.f1884h = 80;
        }
    }

    @Override // b3.a
    public final boolean onDependentViewChanged(androidx.coordinatorlayout.widget.a aVar, View view, View view2) {
        throw new ClassCastException();
    }

    @Override // b3.a
    public final boolean onLayoutChild(androidx.coordinatorlayout.widget.a aVar, View view, int i) {
        throw new ClassCastException();
    }

    public FloatingActionButton$BaseBehavior() {
    }
}
