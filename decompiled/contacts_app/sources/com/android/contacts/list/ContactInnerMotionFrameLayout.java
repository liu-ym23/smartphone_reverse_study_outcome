package com.android.contacts.list;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public class ContactInnerMotionFrameLayout extends FrameLayout {
    public ContactInnerMotionFrameLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent r1) {
        super.dispatchGenericMotionEvent(r1);
        return true;
    }
}
