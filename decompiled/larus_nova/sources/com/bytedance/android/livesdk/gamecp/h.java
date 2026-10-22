package com.bytedance.android.livesdk.gamecp;

import com.bytedance.android.livehostapi.business.depend.IPluginInstallCallback;

/* JADX INFO: loaded from: classes8.dex */
public final class h implements IPluginInstallCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ dw.l f125437a;

    public h(dw.l r100) {
        this.f125437a = r100;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.IPluginInstallCallback
    public final void onResult(boolean r100) {
        this.f125437a.onResult(r100);
    }
}
