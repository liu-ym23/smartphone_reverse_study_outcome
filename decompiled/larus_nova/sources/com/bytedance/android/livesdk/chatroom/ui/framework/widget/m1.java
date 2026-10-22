package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes8.dex */
public final class m1 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m1 f113426a = null;

    static {
        f113426a = new m1();
    }

    public m1() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
    }
}
