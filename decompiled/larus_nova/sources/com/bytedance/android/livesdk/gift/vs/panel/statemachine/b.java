package com.bytedance.android.livesdk.gift.vs.panel.statemachine;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f132397a = null;

    static {
        f132397a = new b();
    }

    public b() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
    }
}
