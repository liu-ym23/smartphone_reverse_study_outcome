package com.bytedance.android.livesdk.microom.enhance;

import android.view.View;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f153841a;

    public b(i r100) {
        this.f153841a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f153841a.c("click");
        this.f153841a.d();
    }
}
