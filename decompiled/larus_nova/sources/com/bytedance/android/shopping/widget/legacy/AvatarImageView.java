package com.bytedance.android.shopping.widget.legacy;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.ec.core.widget.CircleImageView;
import com.bytedance.common.utility.UIUtils;
import com.facebook.drawee.drawable.ScalingUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes14.dex */
public class AvatarImageView extends CircleImageView {
    @Override // com.bytedance.android.ec.core.widget.CircleImageView
    public final void f() {
        super.f();
        getHierarchy().setPlaceholderImage(R.drawable.ec_ic_img_signin_defaultavatar, ScalingUtils.ScaleType.CENTER_CROP);
    }

    public AvatarImageView(Context r100) {
        super(r100);
    }

    public void setBorderWidth(int r100) {
        if (getHierarchy().getRoundingParams() == null) goto L6;
        getHierarchy().getRoundingParams().setBorderWidth(UIUtils.dip2Px(getContext(), r100));
        return;
    }

    public void setBorderWidthPx(int r100) {
        if (getHierarchy().getRoundingParams() == null) goto L6;
        getHierarchy().getRoundingParams().setBorderWidth(r100);
        return;
    }

    public void setRoundingParamsPadding(float r100) {
        if (getHierarchy().getRoundingParams() == null) goto L6;
        getHierarchy().getRoundingParams().setPadding(r100);
        return;
    }

    public AvatarImageView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public AvatarImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
