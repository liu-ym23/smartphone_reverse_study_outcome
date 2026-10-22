package com.bytedance.android.live.lynx.components;

import android.view.View;

/* JADX INFO: loaded from: classes46.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveLynxFragment f82600a;

    public g(LiveLynxFragment r100) {
        this.f82600a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        com.bytedance.android.live.lynx.api.c r101 = this.f82600a.f82588x;
        if (r101 == null) goto L6;
        r101.reload();
        return;
    }
}
