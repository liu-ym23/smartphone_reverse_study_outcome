package com.bytedance.android.btm.api;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements ComponentCallbacks2 {
    public b() {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        BtmSDK.INSTANCE.getService().onLowMemory();
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int r100) {
        if (r100 != 80) goto L6;
        BtmSDK.INSTANCE.getService().onLowMemory();
        return;
    }
}
