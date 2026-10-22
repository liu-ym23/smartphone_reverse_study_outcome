package com.bytedance.android.live.uikit.rtl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes7.dex */
public class AutoRTLImageView extends ImageView {
    public AutoRTLImageView(Context r100) {
        this(r100, null);
    }

    private void init(Context r100) {
        Drawable r101 = getDrawable();
        Drawable r102 = getBackground();
        if (r101 == null) goto L5;
        r101.setAutoMirrored(true);
    L5:
        if (r102 == null) goto L8;
        r102.setAutoMirrored(true);
        return;
    }

    @Override // android.view.View
    public void setBackground(Drawable r100) {
        super.setBackground(r100);
        if (r100 == null) goto L6;
        r100.setAutoMirrored(true);
        return;
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable r100) {
        super.setImageDrawable(r100);
        if (r100 == null) goto L6;
        r100.setAutoMirrored(true);
        return;
    }

    public AutoRTLImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public AutoRTLImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        init(r100);
    }
}
