package com.bytedance.android.livesdk.interactivity.api.chatchannel.utils;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes9.dex */
public final class v implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f133015a = null;

    static {
        f133015a = new v();
    }

    public v() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
    }
}
