package com.android.contacts.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import obric.widget.BarsHelper;

/* JADX INFO: loaded from: classes2.dex */
public class ShadowRelativeLayout extends RelativeLayout {
    private View mShadow;

    public ShadowRelativeLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        View r3 = BarsHelper.createShadowBuilder(r1).build(this);
        this.mShadow = r3;
        r3.setVisibility(0);
    }

    public void setShadowVisible(boolean r1) {
        View r0 = this.mShadow;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    @Override // android.view.View
    public void setVisibility(int r2) {
        super.setVisibility(r2);
        if (r2 == 8) goto L5;
        boolean r3 = true;
    L6:
        setShadowVisible(r3);
        return;
    L5:
        r3 = false;
        goto L6
    }
}
