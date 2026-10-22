package com.bytedance.android.live.liveinteract.floatwindow.applywindow;

import com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener;

/* JADX INFO: loaded from: classes46.dex */
public class d extends IHostAppMonitorListener.Stub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f73304a;

    public d() {
    }

    @Override // com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener.Stub, com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener
    public final void appEnterBackground(boolean r100, boolean r101) {
        super.appEnterBackground(r100, r101);
        this.f73304a = r100;
    }
}
