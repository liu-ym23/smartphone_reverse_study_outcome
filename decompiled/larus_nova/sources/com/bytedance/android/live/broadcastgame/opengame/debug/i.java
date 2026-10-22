package com.bytedance.android.live.broadcastgame.opengame.debug;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes45.dex */
public final class i implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f60015a = null;

    static {
        f60015a = new i();
    }

    public i() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
    }
}
