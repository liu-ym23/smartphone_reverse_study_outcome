package com.bytedance.android.live.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes45.dex */
public class HSImageView extends SimpleDraweeView {
    public boolean isAnimating() {
        if (getController() != null) goto L5;
        return false;
    L5:
        if (getController().getAnimatable() != null) goto L7;
        return false;
    L7:
        return getController().getAnimatable().isRunning();
    }

    public HSImageView(Context r100) {
        super(r100);
    }

    public HSImageView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public HSImageView(Context r100, GenericDraweeHierarchy r101) {
        super(r100, r101);
    }

    public HSImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }

    public HSImageView(Context r100, AttributeSet r101, int r102, int r103) {
        super(r100, r101, r102, r103);
    }
}
