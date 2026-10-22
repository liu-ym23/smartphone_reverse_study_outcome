package com.ttnet.org.chromium.base;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: Logger.java */
/* JADX INFO: loaded from: classes4.dex */
public class k {
    private static final String TAG = "Logger";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static int f37712a = 4;

    static {
    }

    public static void a(int r0) {
        f37712a = r0;
    }

    public static boolean a() {
        if (f37712a > 3) goto L5;
        return true;
    L5:
        return false;
    }

    public static void a(String r2, String r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (f37712a > 3) goto L8;
        b(r2, r3);
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
