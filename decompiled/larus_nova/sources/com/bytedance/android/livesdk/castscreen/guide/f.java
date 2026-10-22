package com.bytedance.android.livesdk.castscreen.guide;

import android.view.View;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f104493a;

    public f(g r100) {
        this.f104493a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        g r101 = this.f104493a;
        View r102 = r101.f104500g;
        if (r102 == null) goto L6;
        g.b(r101, r102, r101.f104504k, r101.f104503j, r101.f104502i);
        return;
    }
}
