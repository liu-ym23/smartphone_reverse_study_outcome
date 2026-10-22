package com.bytedance.android.live.liveinteract.voicechat.radio;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes46.dex */
public final class j implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f80550a = null;

    static {
        f80550a = new j();
    }

    public j() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
    }
}
