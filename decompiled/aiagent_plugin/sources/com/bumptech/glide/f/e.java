package com.bumptech.glide.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Executors.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Executor f3325a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Executor f3326b = null;

    static {
        f3325a = new AnonymousClass1();
        f3326b = new AnonymousClass2();
    }

    public static Executor a() {
        return f3325a;
    }

    public static Executor b() {
        return f3326b;
    }

    public static void a(ExecutorService r3) {
        ExecutorService r4 = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r3, ExecutorService.class, "com.obric.aiagent.plugin");
        r4.shutdownNow();
    L11:
        e = move-exception;
        r4.shutdownNow();
        Thread.currentThread().interrupt();
        throw new RuntimeException(e);
    L4:
        if (r4.awaitTermination(5, TimeUnit.SECONDS) == true) goto L10;
        r4.shutdownNow();     // Catch: InterruptedException -> L11
        if (r4.awaitTermination(5, TimeUnit.SECONDS) == false) goto L9;
        return;
    L9:
        throw new RuntimeException("Failed to shutdown");     // Catch: InterruptedException -> L11
    }
}
