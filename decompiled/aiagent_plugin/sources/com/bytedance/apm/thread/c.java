package com.bytedance.apm.thread;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: LogBypassStoreEventManager.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile ExecutorService f4879a;

    /* JADX INFO: compiled from: LogBypassStoreEventManager.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final c f4881a = null;

        static {
            f4881a = new c(null);
        }
    }

    /* synthetic */ c(AnonymousClass1 r1) {
        this();
    }

    private c() {
        this.f4879a = Executors.newFixedThreadPool(1, new AnonymousClass1(this));
    }

    public static c a() {
        if (com.bytedance.apm.c.j() == true) goto L5;
        return null;
    L5:
        return a.f4881a;
    }

    public void a(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        this.f4879a.submit(r4);
    }
}
