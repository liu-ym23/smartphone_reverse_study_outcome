package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes8.dex */
public final class p3 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p3 f117332a = null;

    static {
        f117332a = new p3();
    }

    public p3() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.cancel();
    }
}
