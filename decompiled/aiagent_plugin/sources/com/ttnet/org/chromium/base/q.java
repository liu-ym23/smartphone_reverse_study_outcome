package com.ttnet.org.chromium.base;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: compiled from: StreamUtil.java */
/* JADX INFO: loaded from: classes4.dex */
public class q {
    public static void a(Closeable r2) {
        Closeable r3 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r2, Closeable.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L8;
        return;
    L8:
        r3.close();     // Catch: IOException -> L7
        return;
    }
}
