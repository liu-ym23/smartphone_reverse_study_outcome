package com.bytedance.android.livesdk.livecommerce.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes10.dex */
public class ECHostNetErrorLayoutImpl extends ECHostNetErrorLayout {
    @Override // com.bytedance.android.livesdk.livecommerce.view.ECHostNetErrorLayout
    public int getGrayColor() {
        return -1;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.view.ECHostNetErrorLayout
    public final TextView a() {
        View r100 = this.f153156a;
        if (r100 != null) goto L5;
        return null;
    L5:
        return (TextView) r100.findViewById(R.id.tv_retry);
    }

    public ECHostNetErrorLayoutImpl(Context r100) {
        super(r100);
    }

    public ECHostNetErrorLayoutImpl(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public ECHostNetErrorLayoutImpl(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
