package com.ttnet.org.chromium.base;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class JavaExceptionReporter implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f37631a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f37632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f37633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f37634d;

    interface a {
        void a(boolean r1, Throwable r2);
    }

    static {
    }

    private JavaExceptionReporter(Thread.UncaughtExceptionHandler r3, boolean r4) {
        this.f37632b = (Thread.UncaughtExceptionHandler) ZeusTransformUtils.wrapperContextForParams(r3, Thread.UncaughtExceptionHandler.class, "com.obric.aiagent.plugin");
        this.f37633c = r4;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread r3, Throwable r4) {
        if (this.f37634d == true) goto L5;
        this.f37634d = true;
        f.a().a(this.f37633c, r4);
    L5:
        Thread.UncaughtExceptionHandler r2 = this.f37632b;
        if (r2 == null) goto L9;
        r2.uncaughtException(r3, r4);
        return;
    }

    private static void installHandler(boolean r2) {
        Thread.setDefaultUncaughtExceptionHandler(new JavaExceptionReporter(Thread.getDefaultUncaughtExceptionHandler(), r2));
    }
}
