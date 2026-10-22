package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes9.dex */
public final class j implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f131097a = null;

    static {
        f131097a = new j();
    }

    public j() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
    }
}
