package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes45.dex */
public final class g0 implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h0 f63379a;

    public g0(h0 r100) {
        this.f63379a = r100;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        h0 r101 = this.f63379a;
        if (r101.f63408b == true) goto L6;
        h0.j(r101);
        return;
    }
}
