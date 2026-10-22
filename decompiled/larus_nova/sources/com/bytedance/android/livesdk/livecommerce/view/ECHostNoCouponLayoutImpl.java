package com.bytedance.android.livesdk.livecommerce.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes10.dex */
public class ECHostNoCouponLayoutImpl extends ECHostNoCouponLayout {
    public ECHostNoCouponLayoutImpl(Context r100) {
        super(r100);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.view.ECHostNoCouponLayout
    public final TextView a(View r100) {
        return (TextView) r100.findViewById(R.id.tv_bind_notice);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.view.ECHostNoCouponLayout
    public final TextView b(View r100) {
        return (TextView) r100.findViewById(R.id.tv_bind_coupon);
    }

    public ECHostNoCouponLayoutImpl(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public ECHostNoCouponLayoutImpl(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
