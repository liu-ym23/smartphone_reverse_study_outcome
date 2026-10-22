package com.android.contacts.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.android.contacts.common.interactions.TouchPointManager;

/* JADX INFO: loaded from: classes.dex */
public class ActivityTouchLinearLayout extends LinearLayout {
    public ActivityTouchLinearLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r2) {
        if (r2.getAction() != 0) goto L7;
        TouchPointManager.getInstance().setPoint((int) r2.getRawX(), (int) r2.getRawY());
        return false;
    L7:
        return false;
    }
}
