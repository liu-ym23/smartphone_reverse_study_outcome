package com.bytedance.android.live.liveinteract.revenue.adventure.linkcore;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes46.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f77951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f77952b;

    public i(h r100, boolean r101) {
        this.f77951a = r100;
        this.f77952b = r101;
    }

    public final void a() {
        ALogger.i("AdventureMediaManager", "muteLiveRoom, isMute: " + this.f77952b);
        if (this.f77952b == false) goto L7;
        ILivePlayerClient r100 = h.a(this.f77951a);
        if (r100 == null) goto L11;
        r100.mute("AdventureMediaManager.muteLiveRoom");
        return;
    L11:
        return;
    L7:
        ILivePlayerClient r101 = h.a(this.f77951a);
        if (r101 == null) goto L13;
        r101.unmute("AdventureMediaManager.muteLiveRoom");
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
