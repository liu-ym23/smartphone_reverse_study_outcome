package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes45.dex */
public final class d9 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f9 f63348a;

    public d9(f9 r100) {
        this.f63348a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
        this.f63348a.finishWithFailure();
    }
}
