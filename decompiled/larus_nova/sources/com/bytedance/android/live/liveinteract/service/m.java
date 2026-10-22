package com.bytedance.android.live.liveinteract.service;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes46.dex */
public final class m implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f78614a = null;

    static {
        f78614a = new m();
    }

    public m() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
    }
}
