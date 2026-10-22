package com.bytedance.android.livesdk.chatroom.viewmodule.sharelinkpanel;

import com.bytedance.android.live.core.utils.f2;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes8.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveLinkShareToThirdDialogFragment f115499a;

    public j(LiveLinkShareToThirdDialogFragment r100) {
        this.f115499a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LiveLinkShareToThirdDialogFragment r100 = this.f115499a;     // Catch: Throwable -> L4
        int r101 = LiveLinkShareToThirdDialogFragment.f115461n;     // Catch: Throwable -> L4
        r100.getClass();     // Catch: Throwable -> L4
        f2.b(R.string.ttlive_share_link_panel_copy_success, 0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
