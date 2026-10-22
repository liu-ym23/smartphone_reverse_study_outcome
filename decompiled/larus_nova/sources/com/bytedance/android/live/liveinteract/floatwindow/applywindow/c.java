package com.bytedance.android.live.liveinteract.floatwindow.applywindow;

import android.view.View;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f73303a;

    public c(a r100) {
        this.f73303a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f73303a.f73301o.close();
    }
}
