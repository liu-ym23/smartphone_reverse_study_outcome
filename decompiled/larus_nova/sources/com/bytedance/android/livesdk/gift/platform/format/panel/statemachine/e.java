package com.bytedance.android.livesdk.gift.platform.format.panel.statemachine;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f132153a = null;

    static {
        f132153a = new e();
    }

    public e() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
    }
}
