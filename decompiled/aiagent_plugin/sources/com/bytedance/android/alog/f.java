package com.bytedance.android.alog;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Util.java */
/* JADX INFO: loaded from: classes.dex */
class f {
    static String a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        String r4 = r3.getPackageManager().getPackageInfo(r3.getPackageName(), 0).versionName;     // Catch: Exception -> L5
    L7:
        if (TextUtils.isEmpty(r4) == false) goto L12;
        return SensitiveType.UNKNOWN;
    L12:
        return r4;
    L5:
        r4 = null;
        goto L7
    }
}
