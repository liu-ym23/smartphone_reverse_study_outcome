package com.bytedance.android.live.effect.sticker.chain;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes45.dex */
public final class g implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f68167a = null;

    static {
        f68167a = new g();
    }

    public g() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
    }
}
