package com.bytedance.crash.o;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;

/* JADX INFO: compiled from: IoUtil.java */
/* JADX INFO: loaded from: classes.dex */
public final class k {
    public static void a(Closeable r2) {
        Closeable r3 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r2, Closeable.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L9;
        r3.close();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }
}
