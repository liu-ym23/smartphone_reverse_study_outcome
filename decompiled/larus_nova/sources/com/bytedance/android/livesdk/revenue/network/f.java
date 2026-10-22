package com.bytedance.android.livesdk.revenue.network;

import c12.j;
import com.bytedance.android.livehostapi.foundation.IHostPlugin;
import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: classes11.dex */
public final class f implements IHostPlugin.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ bq2.b f157218a;

    public f(c12.i r100) {
        this.f157218a = r100;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin.Callback
    public final void onCancel(String r100) {
        if (this.f157218a == null) goto L6;
        Logger.i("PcdnPluginManager", "plugin = " + r100 + " install cancel");
        j.a(r100, false);
        return;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin.Callback
    public final void onSuccess(String r100) {
        if (this.f157218a == null) goto L6;
        Logger.i("PcdnPluginManager", "plugin = " + r100 + " install success");
        j.a(r100, true);
        return;
    }
}
