package com.bytedance.android.shopping.anchorv4.components;

import android.view.View;

/* JADX INFO: loaded from: classes12.dex */
public final class m0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WireframeComponent f166110a;

    public m0(WireframeComponent r100) {
        this.f166110a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        com.bytedance.android.shopping.anchorv4.containers.g r101 = this.f166110a.f166056o;
        if (r101 == null) goto L6;
        r101.b(true, true, false);
        return;
    }
}
