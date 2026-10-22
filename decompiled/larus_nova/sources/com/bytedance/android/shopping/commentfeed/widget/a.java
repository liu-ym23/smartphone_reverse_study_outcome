package com.bytedance.android.shopping.commentfeed.widget;

import bc3.d;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentImageIndicatorNumView f172494a;

    public a(CommentImageIndicatorNumView r100) {
        this.f172494a = r100;
    }

    @Override // bc3.d
    public final void onItemSelected(int r100) {
        CommentImageIndicatorNumView r101 = this.f172494a;
        int r102 = r100 + 1;
        if (r102 >= 0) goto L5;
    L8:
        r101.setVisibility(8);
        return;
    L5:
        if (r102 > r101.f172407b) goto L8;
        r101.setVisibility(0);
        r101.f172406a.setText(th.a.f(r101.getContext()).getString(R.string.shopping_tip_image_indicator_num, new Object[]{String.valueOf(r102), String.valueOf(r101.f172407b)}));
    }
}
