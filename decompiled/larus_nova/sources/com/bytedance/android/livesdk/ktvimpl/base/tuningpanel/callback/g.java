package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import android.view.View;

/* JADX INFO: loaded from: classes10.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f143487a;

    public g(j r100) {
        this.f143487a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ec0.a r101 = this.f143487a.f143492c;
        if (r101 == null) goto L6;
        r101.i();
        return;
    }
}
