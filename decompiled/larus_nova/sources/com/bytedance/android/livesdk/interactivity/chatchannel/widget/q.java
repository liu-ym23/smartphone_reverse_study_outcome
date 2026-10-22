package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes9.dex */
public final class q implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f134698a = null;

    static {
        f134698a = new q();
    }

    public q() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
    }
}
