package com.ttnet.org.chromium.base;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class n {
    public static void a(Closeable r10) {
        if (r10 != null) goto L7;
        return;
    L7:
        r10.close();     // Catch: IOException -> L6
        return;
    }
}
