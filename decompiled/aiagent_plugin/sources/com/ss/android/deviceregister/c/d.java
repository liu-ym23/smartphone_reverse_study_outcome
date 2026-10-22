package com.ss.android.deviceregister.c;

import android.content.Context;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: InstallPmsUtils.java */
/* JADX INFO: loaded from: classes4.dex */
class d {
    public static boolean a(Context r2) {
        return a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "android.permission.READ_PHONE_STATE");
    }

    private static boolean a(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT >= 23) goto L12;
        return true;
    L12:
        if (r5.checkSelfPermission(r4) != 0) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }
}
