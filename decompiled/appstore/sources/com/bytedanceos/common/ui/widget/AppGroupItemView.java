package com.bytedanceos.common.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedanceos.common.ui.widget.oui.OUIAppItemView;

/* JADX INFO: loaded from: classes2.dex */
public class AppGroupItemView extends OUIAppItemView {
    public AppGroupItemView(Context r10) {
        this(r10, null);
    }

    public void updateAppStatusViewLayout() {
        addRightMarginForLine();
        addRightMarginForAppStatusView();
    }

    public AppGroupItemView(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public AppGroupItemView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        addLeftMarginForLine();
        addNameRlMargin();
    }
}
