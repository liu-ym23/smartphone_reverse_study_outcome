package com.bytedance.android.ec.sdk.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import com.bytedance.android.ec.base.service.ECServiceManager;

/* JADX INFO: loaded from: classes44.dex */
public final class e {
    public static boolean a() {
        boolean r100 = ECServiceManager.f42805a;
        hj.c r101 = (hj.c) ECServiceManager.b(hj.c.class);
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.f();
    }

    public static Activity getActivity(Context r100) {
        if ((r100 instanceof Activity) == false) goto L7;
        return (Activity) r100;
    L7:
        if ((r100 instanceof ContextWrapper) == true) goto L9;
        return null;
    L9:
        return getActivity(((ContextWrapper) r100).getBaseContext());
    }
}
