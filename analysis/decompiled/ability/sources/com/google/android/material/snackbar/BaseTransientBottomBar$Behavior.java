package com.google.android.material.snackbar;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import f3.C1433b;
import f3.d;
import u1.C2031a;

/* loaded from: classes3.dex */
public class BaseTransientBottomBar$Behavior extends SwipeDismissBehavior<View> {
    public final C1433b i;

    public BaseTransientBottomBar$Behavior() {
        C1433b c1433b = new C1433b();
        this.f = Math.min(Math.max(0.0f, 0.1f), 1.0f);
        this.g = Math.min(Math.max(0.0f, 0.6f), 1.0f);
        this.d = 0;
        this.i = c1433b;
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior
    public final boolean c(View view) {
        this.i.getClass();
        return view instanceof d;
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        this.i.getClass();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                if (C2031a.d == null) {
                    C2031a.d = new C2031a();
                }
                synchronized (C2031a.d.f6686a) {
                }
            }
        } else if (coordinatorLayout.isPointInChildBounds(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
            if (C2031a.d == null) {
                C2031a.d = new C2031a();
            }
            synchronized (C2031a.d.f6686a) {
            }
        }
        return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
    }
}
