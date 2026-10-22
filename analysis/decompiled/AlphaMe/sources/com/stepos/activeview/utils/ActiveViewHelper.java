package com.stepos.activeview.utils;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* loaded from: classes.dex */
public class ActiveViewHelper {
    public static void setBackgroundRoundCorner(View view, final float f4) {
        if (view == null) {
            return;
        }
        view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.stepos.activeview.utils.ActiveViewHelper.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view2, Outline outline) {
                outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), f4);
            }
        });
        view.setClipToOutline(true);
    }
}
