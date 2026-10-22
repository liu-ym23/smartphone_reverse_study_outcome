package com.bytedance.apm.util;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: LogUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class k {
    public static void a(String r5, String r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.length() == 0) goto L19;
        if (r6 != null) goto L7;
        return;
    L7:
        if (r6.length() != 0) goto L10;
        return;
    L10:
        if (r6.length() > 3072) goto L13;
        b(r5, r6);
        return;
    L13:
        if (r6.length() <= 3072) goto L15;
        String r1 = r6.substring(0, 3072);
        r6 = r6.replace(r1, "");
        b(r5, r1);
        goto L13
    L15:
        b(r5, r6);
        return;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
