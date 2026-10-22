package com.bytedance.android.livesdk;

import android.content.DialogInterface;
import com.bytedance.android.livesdkapi.service.IMiddleWareWindowDegradeManager;

/* JADX INFO: loaded from: classes7.dex */
public final class c9 implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f104418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DialogInterface.OnDismissListener f104419b;

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        DialogInterface.OnDismissListener r101 = this.f104419b;
        if (r101 == null) goto L5;
        r101.onDismiss(r100);
    L5:
        String r102 = this.f104418a;
        if (r102 == null) goto L11;
        IMiddleWareWindowDegradeManager r103 = (IMiddleWareWindowDegradeManager) jc1.k.f(IMiddleWareWindowDegradeManager.class);
        if (r103 == null) goto L12;
        r103.checkRecoverForHybrid(r102, "dismiss");
        return;
    L12:
        return;
    }

    public c9(String r100, DialogInterface.OnDismissListener r101) {
        this.f104418a = r100;
        this.f104419b = r101;
    }
}
