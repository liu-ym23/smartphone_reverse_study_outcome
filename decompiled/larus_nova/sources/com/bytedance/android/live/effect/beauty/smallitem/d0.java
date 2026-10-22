package com.bytedance.android.live.effect.beauty.smallitem;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes45.dex */
public final class d0 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d0 f67683a = null;

    static {
        f67683a = new d0();
    }

    public d0() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        if (r100 == null) goto L5;
        r100.dismiss();
        return;
    }
}
