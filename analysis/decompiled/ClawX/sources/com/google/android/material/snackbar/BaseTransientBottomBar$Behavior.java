package com.google.android.material.snackbar;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import p0.b;
import r6.x;
import v1.c;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class BaseTransientBottomBar$Behavior extends SwipeDismissBehavior<View> {

    /* renamed from: h, reason: collision with root package name */
    public final b f1346h;

    public BaseTransientBottomBar$Behavior() {
        b bVar = new b(14);
        this.f1229e = Math.min(Math.max(0.0f, 0.1f), 1.0f);
        this.f1230f = Math.min(Math.max(0.0f, 0.6f), 1.0f);
        this.d = 0;
        this.f1346h = bVar;
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior, t.a
    public final boolean f(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        this.f1346h.getClass();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                if (x.f5219b == null) {
                    x.f5219b = new x(5);
                }
                synchronized (x.f5219b.f5220a) {
                }
            }
        } else if (coordinatorLayout.o(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
            if (x.f5219b == null) {
                x.f5219b = new x(5);
            }
            synchronized (x.f5219b.f5220a) {
            }
        }
        return super.f(coordinatorLayout, view, motionEvent);
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior
    public final boolean r(View view) {
        this.f1346h.getClass();
        return view instanceof c;
    }
}
