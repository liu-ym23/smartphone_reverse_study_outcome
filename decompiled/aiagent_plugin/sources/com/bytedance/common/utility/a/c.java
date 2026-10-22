package com.bytedance.common.utility.a;

import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: ThreadPlus.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final AtomicInteger f6701a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ExecutorService f6702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ExecutorService f6703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Runnable f6704d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f6705e;

    static {
        f6702b = a.a();
        f6703c = a.a();
        f6701a = new AtomicInteger();
    }

    public c(Runnable r2, String r3, boolean r4) {
        this.f6704d = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin");
        this.f6705e = r4;
    }

    public c(String r1) {
        this(false);
    }

    public c() {
        this(false);
    }

    public c(boolean r1) {
        this.f6705e = r1;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable r0 = this.f6704d;
        if (r0 == null) goto L6;
        r0.run();
        return;
    }

    public void a() {
        if (Logger.debug() == false) goto L5;
        Runnable r0 = new AnonymousClass1(this);
    L7:
        if (this.f6705e == false) goto L9;
        f6703c.submit(r0);
        return;
    L9:
        f6702b.submit(r0);
        return;
    L5:
        r0 = this;
        goto L7
    }

    public static void a(Runnable r2) {
        Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        f6702b.submit(r3);
        return;
    }
}
