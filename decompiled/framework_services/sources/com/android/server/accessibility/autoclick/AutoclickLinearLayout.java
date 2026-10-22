package com.android.server.accessibility.autoclick;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes.dex */
public class AutoclickLinearLayout extends LinearLayout {
    private OnHoverChangedListener mListener;

    public interface OnHoverChangedListener {
        void onHoverChanged(boolean r1);
    }

    public AutoclickLinearLayout(Context context) {
        super(context);
    }

    public AutoclickLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AutoclickLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public AutoclickLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setOnHoverChangedListener(OnHoverChangedListener listener) {
        this.mListener = listener;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptHoverEvent(MotionEvent event) {
        int action = event.getActionMasked();
        if (action != 9) goto L5;
    L8:
        boolean r1 = true;
    L9:
        setHovered(r1);
        return false;
    L5:
        if (action == 7) goto L8;
        r1 = false;
        goto L9
    }

    @Override // android.view.View
    public void onHoverChanged(boolean hovered) {
        super.onHoverChanged(hovered);
        if (this.mListener == null) goto L6;
        this.mListener.onHoverChanged(hovered);
        return;
    }
}
