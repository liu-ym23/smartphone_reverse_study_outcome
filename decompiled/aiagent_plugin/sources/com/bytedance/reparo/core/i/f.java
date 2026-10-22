package com.bytedance.reparo.core.i;

import android.app.Application;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PackageUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    public static boolean a(Application r2) {
        if ((((Application) ZeusTransformUtils.wrapperContextForParams(r2, Application.class, "com.obric.aiagent.plugin")).getApplicationInfo().flags & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }
}
