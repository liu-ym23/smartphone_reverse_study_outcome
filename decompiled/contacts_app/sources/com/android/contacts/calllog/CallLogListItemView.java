package com.android.contacts.calllog;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes.dex */
public class CallLogListItemView extends LinearLayout {
    public CallLogListItemView(Context r1) {
        super(r1);
    }

    public CallLogListItemView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public CallLogListItemView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        forceLayout();
    }
}
