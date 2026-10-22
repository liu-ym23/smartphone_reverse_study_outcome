package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.q0;

/* JADX INFO: loaded from: classes8.dex */
public final class i0 extends q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DrawerSmallLiveViewHolder f123963a;

    public i0(DrawerSmallLiveViewHolder r100) {
        this.f123963a = r100;
    }

    @Override // com.bytedance.android.live.core.utils.q0
    public final void h(py.k r100, int r101, int r102) {
        ViewGroup.LayoutParams r103 = this.f123963a.R.getLayoutParams();
        r103.height = (int) (this.f123963a.R.getWidth() * (r102 / r101));
        this.f123963a.R.setLayoutParams(r103);
    }
}
