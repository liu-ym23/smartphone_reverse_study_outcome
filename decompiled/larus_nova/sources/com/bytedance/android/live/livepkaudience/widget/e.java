package com.bytedance.android.live.livepkaudience.widget;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes46.dex */
public final class e implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f82437a = null;

    static {
        f82437a = new e();
    }

    public e() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
    }
}
