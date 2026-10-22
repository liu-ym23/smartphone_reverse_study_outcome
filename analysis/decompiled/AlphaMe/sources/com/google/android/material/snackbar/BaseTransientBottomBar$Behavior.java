package com.google.android.material.snackbar;

import A1.c;
import B0.g;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.gms.common.api.internal.p;
import com.google.android.material.behavior.SwipeDismissBehavior;
import t.d;

/* loaded from: classes.dex */
public class BaseTransientBottomBar$Behavior extends SwipeDismissBehavior<View> {

    /* renamed from: i, reason: collision with root package name */
    public final p f10909i = new p((SwipeDismissBehavior) this);

    @Override // com.google.android.material.behavior.SwipeDismissBehavior
    public final boolean c(View view) {
        this.f10909i.getClass();
        return view instanceof c;
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior, A.b
    public final boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        p pVar = this.f10909i;
        pVar.getClass();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                if (d.f15272e == null) {
                    d.f15272e = new d(7);
                }
                d dVar = d.f15272e;
                g.y(pVar.f9664b);
                synchronized (dVar.f15273a) {
                    g.y(dVar.f15275c);
                }
            }
        } else if (coordinatorLayout.z(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
            if (d.f15272e == null) {
                d.f15272e = new d(7);
            }
            d dVar2 = d.f15272e;
            g.y(pVar.f9664b);
            synchronized (dVar2.f15273a) {
                g.y(dVar2.f15275c);
            }
        }
        return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
    }
}
