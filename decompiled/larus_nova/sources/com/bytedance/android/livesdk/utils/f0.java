package com.bytedance.android.livesdk.utils;

import com.bytedance.android.livehostapi.foundation.IHostPlugin;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes11.dex */
public final class f0 implements IHostPlugin.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f158944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f0 f158945b = null;

    public f0() {
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin.Callback
    public final void onCancel(String r100) {
    }

    static {
        f158945b = new f0();
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin.Callback
    public final void onSuccess(String r100) {
        if (f158944a == false) goto L5;
        return;
    L5:
        com.bytedance.android.live.core.utils.f2.b(R.string.ttlive_broadcast_plugin_loaded, 0);
        f158944a = true;
    }
}
