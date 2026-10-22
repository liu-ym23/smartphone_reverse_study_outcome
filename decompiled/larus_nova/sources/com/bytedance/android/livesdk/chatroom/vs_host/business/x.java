package com.bytedance.android.livesdk.chatroom.vs_host.business;

import android.content.Context;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livehostapi.platform.IHostAction;

/* JADX INFO: loaded from: classes8.dex */
public final class x implements yr1.q, com.bytedance.android.scope.o {
    public x() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // yr1.q
    public final boolean a(Context r100, String r101) {
        IHostAction r102 = (IHostAction) jc1.k.f(IHostAction.class);
        if (r102 == null) goto L6;
        r102.showStickyToast(r100, r101, 0);
        return true;
    L6:
        return false;
    }

    @Override // yr1.q
    public final boolean c(Context r100, String r101) {
        IHostApp r102 = (IHostApp) jc1.k.f(IHostApp.class);
        if (r102 == null) goto L6;
        r102.systemToast(r100, r101, 0);
        return true;
    L6:
        return false;
    }

    @Override // yr1.q
    public final boolean centerToast(Context r100, String r101, int r102) {
        IHostApp r103 = (IHostApp) jc1.k.f(IHostApp.class);
        if (r103 == null) goto L6;
        r103.centerToast(r100, r101, r102);
        return true;
    L6:
        return false;
    }
}
