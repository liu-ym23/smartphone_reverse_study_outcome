package com.bytedance.android.gamecp.common.utils;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes44.dex */
public final class k implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ uu.b f57231a;

    public k(uu.b r100) {
        this.f57231a = r100;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        uu.b r101 = this.f57231a;
        if (r101 == null) goto L5;
        r101.cancel();
    L5:
        yr.b.b(4, "PermissionDialog", "listen click cancel");
    }
}
