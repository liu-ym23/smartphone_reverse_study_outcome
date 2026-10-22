package com.bytedance.android.shopping.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes14.dex */
public class RemoteRoundImageView extends SimpleDraweeView {
    public RemoteRoundImageView(Context r100) {
        super(r100);
    }

    public void setCornersRadius(float r100) {
        RoundingParams r101 = new RoundingParams();
        r101.setCornersRadius(r100);
        getHierarchy().setRoundingParams(r101);
    }

    public RemoteRoundImageView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public RemoteRoundImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
