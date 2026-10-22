package com.bumptech.glide.manager;

import android.content.Context;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: DefaultConnectivityMonitorFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements d {
    private static final String TAG = "ConnectivityMonitor";

    public f() {
    }

    @Override // com.bumptech.glide.manager.d
    public c a(Context r3, c.a r4) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        c.a r5 = (c.a) ZeusTransformUtils.wrapperContextForParams(r4, c.a.class, "com.obric.aiagent.plugin");
        if (androidx.core.content.a.b(r2, "android.permission.ACCESS_NETWORK_STATE") != 0) goto L5;
        boolean r6 = true;
    L7:
        if (a(TAG, 3) == false) goto L12;
        if (r6 == false) goto L10;
        String r0 = "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor";
    L11:
        a(TAG, r0);
        goto L12
    L10:
        r0 = "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor";
    L12:
        if (r6 == false) goto L15;
        return new e(r2, r5);
    L15:
        return new j();
    L5:
        r6 = false;
        goto L7
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static boolean a(String r1, int r2) {
        if (com.obric.aiagent.apm.impl.a.a() == true) goto L7;
        return Log.isLoggable(r1, r2);
    L7:
        if (r2 == 6) goto L9;
    L11:
        return false;
    L9:
        if (Log.isLoggable(r1, r2) == false) goto L11;
        return true;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
