package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes8.dex */
public final class j4 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j4 f117251a = null;

    static {
        f117251a = new j4();
    }

    public j4() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
    }
}
