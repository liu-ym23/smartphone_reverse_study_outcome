package com.bytedance.android.live.recharge.exchange;

import android.content.DialogInterface;
import jw0.h;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f89793a = null;

    static {
        f89793a = new c();
    }

    public c() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        com.bytedance.android.live.recharge.util.d.c(false);
        h.b("0");
        r100.dismiss();
    }
}
