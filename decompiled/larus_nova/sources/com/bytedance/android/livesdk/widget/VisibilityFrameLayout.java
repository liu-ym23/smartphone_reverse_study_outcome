package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes11.dex */
public class VisibilityFrameLayout extends FrameLayout {

    public interface a {
    }

    public void setListener(a r100) {
    }

    public VisibilityFrameLayout(Context r100) {
        super(r100);
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
    }

    public VisibilityFrameLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public VisibilityFrameLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
