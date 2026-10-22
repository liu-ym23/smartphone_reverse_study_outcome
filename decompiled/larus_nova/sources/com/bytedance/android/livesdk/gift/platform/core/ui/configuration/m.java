package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes9.dex */
public final class m implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f131982a = null;

    static {
        f131982a = new m();
    }

    public m() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
    }
}
