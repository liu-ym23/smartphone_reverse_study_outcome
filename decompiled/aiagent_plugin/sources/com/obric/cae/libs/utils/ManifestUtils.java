package com.obric.cae.libs.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ComponentInfo;
import android.content.pm.ServiceInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class ManifestUtils {
    public ManifestUtils() {
    }

    public static boolean isServiceSingleUser(Context r4, Class<?> r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        ServiceInfo r7 = r6.getPackageManager().getServiceInfo(new ComponentName(r6, r5), 0);     // Catch: Throwable -> L13
        int r8 = ServiceInfo.class.getField("FLAG_SINGLE_USER").getInt(null);     // Catch: NoSuchFieldException -> L7 Throwable -> L13 Throwable -> L13
    L8:
        if ((r7.flags & r8) == 0) goto L18;
        return true;
    L18:
        return false;
    L7:
        r8 = ComponentInfo.class.getField("FLAG_SINGLE_USER").getInt(null);     // Catch: Throwable -> L13 Throwable -> L13
    L19:
        return false;
    }
}
