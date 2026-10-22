package com.bytedance.framwork.core.sdklib.util;

import android.database.Cursor;

/* JADX INFO: loaded from: classes2.dex */
public class DbUtils {
    public DbUtils() {
    }

    public static void safeCloseCursor(Cursor r1) {
        if (r1 == null) goto L10;
        if (r1.isClosed() == true) goto L11;
        r1.close();     // Catch: Exception -> L7
        return;
    L11:
        return;
    L12:
        return;
    }
}
