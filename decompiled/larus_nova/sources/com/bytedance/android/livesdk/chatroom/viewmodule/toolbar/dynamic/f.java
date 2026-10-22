package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes8.dex */
public final class f implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f116102a;

    public f(i r100) {
        this.f116102a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        r100.dismiss();
        i r102 = this.f116102a;
        if (r102 == null) goto L6;
        r102.onCancelClick();
        return;
    }
}
