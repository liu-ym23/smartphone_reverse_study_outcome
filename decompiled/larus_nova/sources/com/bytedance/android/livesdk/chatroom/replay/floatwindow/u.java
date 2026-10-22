package com.bytedance.android.livesdk.chatroom.replay.floatwindow;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes7.dex */
public final class u implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f108720a = null;

    static {
        f108720a = new u();
    }

    public u() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
    }
}
