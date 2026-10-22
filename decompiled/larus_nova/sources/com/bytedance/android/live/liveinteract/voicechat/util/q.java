package com.bytedance.android.live.liveinteract.voicechat.util;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes46.dex */
public final class q implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f80874a = null;

    static {
        f80874a = new q();
    }

    public q() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
    }
}
