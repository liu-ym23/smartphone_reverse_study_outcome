package com.bytedance.android.livesdk.chatroom.ui;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes8.dex */
public final class l7 implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveProfileManageDialogV2 f113669a;

    public l7(LiveProfileManageDialogV2 r100) {
        this.f113669a = r100;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        if (this.f113669a.f112286f == null) goto L6;
        com.bytedance.android.livesdk.f.d().f();
        this.f113669a.f112286f = null;
        return;
    }
}
