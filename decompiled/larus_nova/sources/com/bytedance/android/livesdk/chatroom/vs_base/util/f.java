package com.bytedance.android.livesdk.chatroom.vs_base.util;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes8.dex */
public final class f implements DialogInterface.OnClickListener {
    public f() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
    }
}
