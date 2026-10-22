package com.baidu.lbsapi.auth;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes39.dex */
class l extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ LBSAuthManager f30471a;

    public l(LBSAuthManager r100, Looper r101) {
        this.f30471a = r100;
        super(r101);
    }

    @Override // android.os.Handler
    public void handleMessage(Message r100) {
        b.a("handleMessage !!");
        LBSAuthManagerListener r101 = (LBSAuthManagerListener) LBSAuthManager.a().get(r100.getData().getString("listenerKey"));
        b.a("handleMessage listener = " + r101);
        if (r101 == null) goto L6;
        r101.onAuthResult(r100.what, r100.obj.toString());
        return;
    }
}
