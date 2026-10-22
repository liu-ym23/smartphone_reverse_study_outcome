package com.bytedance.retrofit2;

import android.util.Log;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: RetrofitLogger.java */
/* JADX INFO: loaded from: classes.dex */
public class ae {
    private static final String TAG = "Logger";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static int f9429a = 4;

    static {
    }

    public static void a(int r0) {
        f9429a = r0;
    }

    public static void a(String r2, String r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (f9429a > 3) goto L8;
        b(r2, r3);
        return;
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
