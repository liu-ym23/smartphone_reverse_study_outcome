package com.bytedance.android.livesdk.widget;

import android.view.ViewGroup;

/* JADX INFO: loaded from: classes11.dex */
public final class t0 extends com.bytedance.android.live.core.utils.q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveCoverOptView f162147a;

    public t0(LiveCoverOptView r100) {
        this.f162147a = r100;
    }

    @Override // com.bytedance.android.live.core.utils.q0
    public final void h(py.k r100, int r101, int r102) {
        ViewGroup.LayoutParams r103 = this.f162147a.f160955a.getLayoutParams();
        r103.width = (int) (r103.height * (r101 / r102));
        this.f162147a.f160955a.setLayoutParams(r103);
    }
}
