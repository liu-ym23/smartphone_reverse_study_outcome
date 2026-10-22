package com.bytedance.android.live.liveinteract.floatwindow.onlinewindow;

import android.view.View;

/* JADX INFO: loaded from: classes46.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f73419a;

    public d(b r100) {
        this.f73419a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f73419a.f73417p.close();
    }
}
