package com.bytedance.android.live.effect.beauty.smallitem;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes45.dex */
public final class o implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f67720a = null;

    static {
        f67720a = new o();
    }

    public o() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        if (r100 == null) goto L5;
        r100.dismiss();
        return;
    }
}
