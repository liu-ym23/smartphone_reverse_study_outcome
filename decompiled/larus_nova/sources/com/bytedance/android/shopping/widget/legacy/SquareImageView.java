package com.bytedance.android.shopping.widget.legacy;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes14.dex */
public class SquareImageView extends SimpleDraweeView {
    public SquareImageView(Context r100) {
        super(r100);
        setAspectRatio(1.0f);
    }

    public SquareImageView(Context r100, AttributeSet r101) {
        super(r100, r101);
        setAspectRatio(1.0f);
    }

    public SquareImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        setAspectRatio(1.0f);
    }
}
