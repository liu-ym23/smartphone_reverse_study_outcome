package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CronetManifest.java */
/* JADX INFO: loaded from: classes4.dex */
public final class j {
    public static boolean a(Context r2, h.b r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        ApplicationInfo r5 = r4.getPackageManager().getApplicationInfo(r4.getPackageName(), 128);     // Catch: PackageManager.NameNotFoundException -> L8
        if (r5.metaData == null) goto L11;
        return r5.metaData.getBoolean("com.ttnet.org.chromium.net.CronetMetricsOptIn");
    L11:
        return false;
    L12:
        return false;
    }
}
