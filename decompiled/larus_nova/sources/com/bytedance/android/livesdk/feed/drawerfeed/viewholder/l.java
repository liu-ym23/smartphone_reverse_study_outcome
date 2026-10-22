package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.q0;
import com.bytedance.android.live.core.widget.HSImageView;

/* JADX INFO: loaded from: classes8.dex */
public final class l extends q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HSImageView f123969a;

    public l(HSImageView r100) {
        this.f123969a = r100;
    }

    @Override // com.bytedance.android.live.core.utils.q0
    public final void h(py.k r100, int r101, int r102) {
        ViewGroup.LayoutParams r103 = this.f123969a.getLayoutParams();
        r103.width = (int) (r103.height * (r101 / r102));
        this.f123969a.setLayoutParams(r103);
    }
}
