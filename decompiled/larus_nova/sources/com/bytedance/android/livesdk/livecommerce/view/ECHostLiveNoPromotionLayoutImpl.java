package com.bytedance.android.livesdk.livecommerce.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes10.dex */
public class ECHostLiveNoPromotionLayoutImpl extends ECHostLiveNoPromotionLayout {
    @Override // com.bytedance.android.livesdk.livecommerce.view.ECHostLiveNoPromotionLayout
    public final void b() {
    }

    public ECHostLiveNoPromotionLayoutImpl(Context r100) {
        super(r100);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.view.ECHostLiveNoPromotionLayout
    public final TextView a(View r100) {
        return (TextView) r100.findViewById(R.id.tv_add_promotion);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.view.ECHostLiveNoPromotionLayout
    public final TextView c(View r100) {
        return (TextView) r100.findViewById(R.id.tv_no_promotion);
    }

    public ECHostLiveNoPromotionLayoutImpl(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public ECHostLiveNoPromotionLayoutImpl(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
