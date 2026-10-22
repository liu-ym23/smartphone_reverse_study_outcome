package com.bytedance.android.gamecp.common.track.monitor;

import android.view.View;

/* JADX INFO: loaded from: classes44.dex */
public final class f implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f56839a;

    public f(a r100) {
        this.f56839a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        a r109 = this.f56839a;
        if (r109.f56815e == true) goto L5;
        return;
    L5:
        r109.c();
    }
}
