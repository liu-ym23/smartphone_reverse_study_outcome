package com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.Window;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Dialog f118170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f118171b;

    public a(Dialog r100, b r101) {
        this.f118170a = r100;
        this.f118171b = r101;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface r100) {
        this.f118171b.r(this.f118170a);
        Window r101 = this.f118170a.getWindow();
        if (r101 == null) goto L6;
        r101.clearFlags(8);
        return;
    }
}
