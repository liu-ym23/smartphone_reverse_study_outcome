package com.ss.bduploader;

import android.util.Log;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: BDUploadLog.java */
/* JADX INFO: loaded from: classes4.dex */
public class s {
    private static final String TAG = "BDUploadLog";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f37555a = 112;

    static {
    }

    public static final void a(String r3, String r4) {
        if (((f37555a >> 2) & 1) != 1) goto L6;
        b(TAG, String.format("<%s>%s", new Object[]{r3, r4}));
        return;
    }

    public static final void c(String r3, String r4) {
        if (((f37555a >> 1) & 1) != 1) goto L6;
        d(TAG, String.format("<%s>%s", new Object[]{r3, r4}));
        return;
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }
}
