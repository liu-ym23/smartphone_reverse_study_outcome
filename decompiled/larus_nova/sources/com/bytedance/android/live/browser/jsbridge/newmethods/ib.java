package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes45.dex */
public final class ib implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gb f63456a;

    public ib(gb r100) {
        this.f63456a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        if (r100 == null) goto L4;
        r100.dismiss();
    L4:
        this.f63456a.finishWithResult(new gb.c("cancel"));
    }
}
