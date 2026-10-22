package com.android.contacts.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.GridView;

/* JADX INFO: loaded from: classes2.dex */
public class SurnameGridView extends GridView {
    private int mPrePosition;
    private OnPressChangeListener mPressChangeListener;
    private int mTouchedPosition;

    public interface OnPressChangeListener {
        void onTouched(int r1);
    }

    public SurnameGridView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mTouchedPosition = -1;
        this.mPrePosition = -1;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent r5) {
        int r0 = pointToPosition((int) r5.getX(), (int) r5.getY());
        int r1 = r5.getActionMasked();
        if (r1 != 0) goto L5;
        this.mTouchedPosition = r0;
    L15:
        if (this.mPrePosition == r0) goto L18;
        this.mPressChangeListener.onTouched(r0);
        this.mPrePosition = r0;
    L18:
        return super.onTouchEvent(r5);
    L5:
        if (r1 != 1) goto L7;
    L9:
        r0 = -1;
        goto L15
    L7:
        if (r1 != 2) goto L9;
        int r2 = this.mTouchedPosition;
        if (r2 != r0) goto L9;
        r0 = r2;
        goto L15
    }

    public void setOnPressChangeListener(OnPressChangeListener r1) {
        this.mPressChangeListener = r1;
    }
}
