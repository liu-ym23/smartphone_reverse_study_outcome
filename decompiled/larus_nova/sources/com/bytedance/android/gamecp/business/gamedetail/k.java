package com.bytedance.android.gamecp.business.gamedetail;

import android.content.pm.PackageManager;
import com.bytedance.android.gamecp.common.utils.y0;

/* JADX INFO: loaded from: classes44.dex */
public final class k {
    public static final float a() {
        return y0.f() * 0.73f;
    }

    public static final boolean b(String r100) {
        if (r100 != null) goto L10;
        return false;
    L10:
        com.bytedance.android.gamecp.host_api.a.b().getHostContext().getAppContext().getPackageManager().getPackageInfo(r100, 1);     // Catch: PackageManager.NameNotFoundException -> L9
        return true;
    L12:
        return false;
    }
}
