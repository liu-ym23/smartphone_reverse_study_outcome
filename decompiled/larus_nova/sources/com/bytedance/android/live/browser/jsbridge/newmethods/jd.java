package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes45.dex */
public final class jd implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final jd f63495a = null;

    static {
        f63495a = new jd();
    }

    public jd() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
    }
}
