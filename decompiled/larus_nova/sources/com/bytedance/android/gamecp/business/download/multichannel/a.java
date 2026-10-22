package com.bytedance.android.gamecp.business.download.multichannel;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f52814a;

    public a(Runnable r100) {
        this.f52814a = r100;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Runnable r101 = this.f52814a;
        if (r101 == null) goto L6;
        r101.run();
        return;
    }
}
