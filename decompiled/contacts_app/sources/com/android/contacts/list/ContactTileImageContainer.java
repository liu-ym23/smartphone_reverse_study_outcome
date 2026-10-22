package com.android.contacts.list;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public class ContactTileImageContainer extends FrameLayout {
    public ContactTileImageContainer(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        forceLayout();
    }
}
