package com.google.android.material.snackbar;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.a;
import com.google.android.material.behavior.SwipeDismissBehavior;
import f8.b;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class BaseTransientBottomBar$Behavior extends SwipeDismissBehavior<View> {

    /* renamed from: h, reason: collision with root package name */
    public final b f2464h;

    public BaseTransientBottomBar$Behavior() {
        b bVar = new b(6);
        this.f2407e = Math.min(Math.max(0.0f, 0.1f), 1.0f);
        this.f2408f = Math.min(Math.max(0.0f, 0.6f), 1.0f);
        this.f2406d = 0;
        this.f2464h = bVar;
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior
    public final boolean c() {
        this.f2464h.getClass();
        return false;
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior, b3.a
    public final boolean onInterceptTouchEvent(a aVar, View view, MotionEvent motionEvent) {
        this.f2464h.getClass();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                synchronized (h7.b.a().f5399a) {
                }
            }
        } else if (aVar.z(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
            synchronized (h7.b.a().f5399a) {
            }
        }
        return super.onInterceptTouchEvent(aVar, view, motionEvent);
    }
}
