package com.apm.lite.k;

import java.io.Closeable;

/* JADX INFO: loaded from: classes39.dex */
public final class j {
    public static void a(Closeable r100) {
        if (r100 == null) goto L8;
        r100.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public static void b(String r100) {
        m1.a.b(m1.a.a("android.os.FileUtils"), "setPermissions", new Object[]{r100, 493, -1, -1});     // Catch: Exception -> L5
        return;
    }
}
