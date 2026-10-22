package com.bytedance.android.live.room.share.jsbridge;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes47.dex */
public final class p implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f100323a = null;

    static {
        f100323a = new p();
    }

    public p() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        if (r100 == null) goto L5;
        r100.dismiss();
        return;
    }
}
