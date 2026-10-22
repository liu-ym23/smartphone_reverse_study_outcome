package com.android.contacts.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.QuickContactBadge;

/* JADX INFO: loaded from: classes.dex */
public class LayoutSuppressingQuickContactBadge extends QuickContactBadge {
    public LayoutSuppressingQuickContactBadge(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // android.view.View
    public void requestLayout() {
        forceLayout();
    }
}
