package com.bytedance.android.live.soloktv.util;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes7.dex */
public final class o implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f101638a = null;

    static {
        f101638a = new o();
    }

    public o() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
    }
}
