package com.prolificinteractive.materialcalendarview;

import android.R;
import android.content.Context;
import android.graphics.PorterDuff;
import android.util.TypedValue;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes4.dex */
public class h extends ImageView {
    public h(Context r10) {
        super(r10);
        setBackgroundResource(a(r10));
    }

    public static int a(Context r10) {
        int r11 = r10.getResources().getIdentifier("selectableItemBackgroundBorderless", "attr", r10.getPackageName());
        if (r11 != 0) goto L5;
        r11 = R.attr.selectableItemBackgroundBorderless;
    L5:
        TypedValue r12 = new TypedValue();
        r10.getTheme().resolveAttribute(r11, r12, true);
        return r12.resourceId;
    }

    public void b(int r10) {
        setColorFilter(r10, PorterDuff.Mode.SRC_ATOP);
    }

    @Override // android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        if (r10 == false) goto L5;
        float r11 = 1.0f;
    L6:
        setAlpha(r11);
        return;
    L5:
        r11 = 0.1f;
        goto L6
    }
}
