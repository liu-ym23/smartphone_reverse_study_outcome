package com.bytedance.android.livesdk.chatroom.ui;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes8.dex */
public final class k7 implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveProfileManageDialogV2 f113645a;

    public k7(LiveProfileManageDialogV2 r100) {
        this.f113645a = r100;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        com.bytedance.android.livesdk.f.d().f();
        this.f113645a.f112285e = null;
    }
}
