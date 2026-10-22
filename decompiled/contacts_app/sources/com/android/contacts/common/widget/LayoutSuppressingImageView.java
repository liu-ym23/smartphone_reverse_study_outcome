package com.android.contacts.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public class LayoutSuppressingImageView extends ImageView {
    public LayoutSuppressingImageView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // android.view.View
    public void requestLayout() {
        forceLayout();
    }
}
