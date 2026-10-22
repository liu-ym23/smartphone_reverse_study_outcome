package com.bytedance.android.livesdk.admin;

import android.view.View;
import xs2.b;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MenuAdapter.a f103073a;

    public a(MenuAdapter.a r100) {
        this.f103073a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f103073a.f103072b == null) goto L6;
        b r101 = b.a();
        this.f103073a.f103072b.getClass();
        r101.post(new sd1.b());
        return;
    }
}
