package com.baidu.mapapi;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes39.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ExecutorService f30515a;

    public static ExecutorService a() {
        if (f30515a != null) goto L6;
        b();
    L6:
        return f30515a;
    }

    public static synchronized void b() {
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (f30515a != null) goto L7;
        f30515a = PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("aidu/mapapi/a"));     // Catch: Throwable -> L9
    L7:
        monitor-exit(a.class);
    }
}
