package com.obric.autoaction.vdplayer.components.panel;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import d.h.b.o;

/* JADX INFO: compiled from: TouchTargetUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
final class VisibleTouchDelegate extends TouchDelegate {
    private final View target;

    public VisibleTouchDelegate(Rect r2, View r3) {
        o.e(r2, "bounds");
        o.e(r3, "target");
        super(r2, r3);
        this.target = r3;
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(MotionEvent r2) {
        o.e(r2, "event");
        if (this.target.getVisibility() == 0) goto L5;
        return false;
    L5:
        if (this.target.isEnabled() == true) goto L8;
        return false;
    L8:
        return super.onTouchEvent(r2);
    }
}
