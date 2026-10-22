package com.bytedance.android.live.liveinteract.service;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes46.dex */
public final class p implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f78618a = null;

    static {
        f78618a = new p();
    }

    public p() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
        com.bytedance.android.live.liveinteract.linkpanel.util.o.E(null, "cancel");
    }
}
