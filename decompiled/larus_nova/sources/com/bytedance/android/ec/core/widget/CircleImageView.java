package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes43.dex */
public class CircleImageView extends SimpleDraweeView {
    public void f() {
        RoundingParams r100 = new RoundingParams();
        r100.setRoundAsCircle(true);
        getHierarchy().setRoundingParams(r100);
        getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
    }

    public CircleImageView(Context r100) {
        super(r100);
        f();
    }

    public CircleImageView(Context r100, AttributeSet r101) {
        super(r100, r101);
        f();
    }

    public CircleImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        f();
    }
}
