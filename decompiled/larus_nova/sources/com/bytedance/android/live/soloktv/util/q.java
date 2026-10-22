package com.bytedance.android.live.soloktv.util;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes7.dex */
public final class q implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f101640a = null;

    static {
        f101640a = new q();
    }

    public q() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
    }
}
