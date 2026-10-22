package com.bytedance.android.livesdk.interactivity.interactive.dialog.provider;

import android.view.View;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.b f137279a;

    public d(a.b r100) {
        this.f137279a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        k82.a r101 = this.f137279a.f137270t.f137248a;
        if (r101 == null) goto L6;
        r101.A();
        return;
    }
}
