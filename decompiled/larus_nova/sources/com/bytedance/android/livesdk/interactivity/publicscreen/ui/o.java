package com.bytedance.android.livesdk.interactivity.publicscreen.ui;

import android.view.View;

/* JADX INFO: loaded from: classes9.dex */
public final class o implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PublicScreenConfigSliderView f140264a;

    public o(PublicScreenConfigSliderView r100) {
        this.f140264a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f140264a.getDisable() == true) goto L5;
        this.f140264a.b(0, true);
        return;
    L5:
        la2.a r101 = this.f140264a.f140187e;
        if (r101 == null) goto L10;
        r101.a();
        return;
    }
}
