package com.bytedance.android.gamecp.common.utils;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.Window;

/* JADX INFO: loaded from: classes44.dex */
public final class m0 implements DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Dialog f57240a;

    public m0(Dialog r100) {
        this.f57240a = r100;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface r100) {
        Window r101 = this.f57240a.getWindow();
        if (r101 == null) goto L6;
        r101.clearFlags(8);
        n0.a(r101);
        return;
    }
}
