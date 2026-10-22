package com.ss.bduploader.net;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: BDUploadThreadPool.java */
/* JADX INFO: loaded from: classes4.dex */
public class f {
    private static final String TAG = "BDUploadThreadPool";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile ThreadPoolExecutor f37531a;

    public f() {
    }

    public static ThreadPoolExecutor a() {
        if (f37531a != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f37531a != null) goto L9;
        f37531a = new ThreadPoolExecutor(3, Integer.MAX_VALUE, 300, TimeUnit.SECONDS, new SynchronousQueue());     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return f37531a;
    }

    public static Future a(Runnable r2) {
        Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin");
        if (f37531a != null) goto L6;
        a();
    L6:
        return f37531a.submit(r3);
    }
}
