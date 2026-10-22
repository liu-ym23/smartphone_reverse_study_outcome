package com.android.contacts.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.android.contacts.list.SlideListView;

/* JADX INFO: loaded from: classes2.dex */
public class AutoScrollListView extends SlideListView {
    private static final float PREFERRED_SELECTION_OFFSET_FROM_TOP = 0.33f;
    private static final String TAG = "AutoScrollListView";
    private int mRequestedScrollPosition;
    private boolean mSmoothScrollRequested;

    public AutoScrollListView(Context r1) {
        super(r1);
        this.mRequestedScrollPosition = -1;
    }

    public AutoScrollListView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mRequestedScrollPosition = -1;
    }

    public AutoScrollListView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mRequestedScrollPosition = -1;
    }

    public void requestPositionToScreen(int r1, boolean r2) {
        this.mRequestedScrollPosition = r1;
        this.mSmoothScrollRequested = r2;
        requestLayout();
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    protected void layoutChildren() {
        super.layoutChildren();
        int r0 = this.mRequestedScrollPosition;
        if (r0 != (-1)) goto L5;
        return;
    L5:
        this.mRequestedScrollPosition = -1;
        int r1 = getFirstVisiblePosition() + 1;
        int r2 = getLastVisiblePosition();
        if (r0 < r1) goto L9;
        if (r0 > r2) goto L9;
        return;
    L9:
        int r3 = (int) (getHeight() * 0.33f);
        if (this.mSmoothScrollRequested == true) goto L12;
        setSelectionFromTop(r0, r3);
        super.layoutChildren();
        return;
    L12:
        int r4 = (r2 - r1) * 2;
        if (r0 >= r1) goto L19;
        int r5 = r4 + r0;
        if (r5 < getCount()) goto L17;
        r5 = getCount() - 1;
    L17:
        if (r5 >= r1) goto L24;
        setSelection(r5);
        super.layoutChildren();
    L24:
        smoothScrollToPositionFromTop(r0, r3);
        return;
    L19:
        int r6 = r0 - r4;
        if (r6 >= 0) goto L22;
        r6 = 0;
    L22:
        if (r6 <= r2) goto L24;
        setSelection(r6);
        super.layoutChildren();
        goto L24
    }
}
