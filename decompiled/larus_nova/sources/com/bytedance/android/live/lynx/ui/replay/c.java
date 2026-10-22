package com.bytedance.android.live.lynx.ui.replay;

import android.view.View;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayVideoViewForLynx f82799a;

    public c(ReplayVideoViewForLynx r100) {
        this.f82799a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ReplayVideoViewForLynx r101 = this.f82799a;
        if (r101.f82790w == false) goto L6;
        r101.d();
        return;
    }
}
