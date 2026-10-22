package com.bytedance.android.shopping.widget.legacy;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.common.utility.UIUtils;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes14.dex */
public class RemoteRoundImageView extends SimpleDraweeView {
    public final void f() {
        RoundingParams r100 = new RoundingParams();
        r100.setCornersRadius(UIUtils.dip2Px(getContext(), 2.0f));
        getHierarchy().setRoundingParams(r100);
        getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
    }

    public RemoteRoundImageView(Context r100) {
        super(r100);
        f();
    }

    public RemoteRoundImageView(Context r100, AttributeSet r101) {
        super(r100, r101);
        f();
    }

    public RemoteRoundImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        f();
    }
}
